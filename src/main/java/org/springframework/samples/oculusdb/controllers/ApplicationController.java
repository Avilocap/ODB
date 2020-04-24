
package org.springframework.samples.oculusdb.controllers;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.administrator.PdfGeneratorUtil;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.services.ApplicationService;
import org.springframework.samples.oculusdb.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Controller
@RequestMapping("/applications")
public class ApplicationController {

	@Autowired
	PdfGeneratorUtil pdfGenerator;

	@Autowired
	private ApplicationService applicationService;

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String listadoAplicaciones(final ModelMap modelMap) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = this.userService.userByUsername(currentPrincipalName);
		if (userService.isAdmin(user)) {
			modelMap.addAttribute("admin", true);
		}
		String vista = "applications/listadoAplicaciones";
		Iterable<Application> applications = applicationService.findAll();
		modelMap.addAttribute("applications", applications);
		return vista;

	}

	@GetMapping("/listOrd")
	public String listadoAplicacionesOrd(final ModelMap modelMap) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = this.userService.userByUsername(currentPrincipalName);
		if (userService.isAdmin(user)) {
			modelMap.addAttribute("admin", true);
		}
		String vista = "applications/listadoAplicaciones";
		Iterable<Application> applications = applicationService.findAll();
		List<Application> applications3 = (List<Application>) applications;

		Collections.sort(applications3, (a1, a2) -> a1.getCategory().getId().compareTo(a2.getCategory().getId()));
		modelMap.addAttribute("applications", applications3);
		return vista;

	}

	@GetMapping("/loadGet")
	public String loadApplicationGet() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = this.userService.userByUsername(currentPrincipalName);
		if (userService.isAdmin(user)) {
			return "applications/getApplication";
		}
		else {
			return "security/login";
		}

	}

	@GetMapping("/appInfo/{appId}")
	public ModelAndView showOwner2(@PathVariable("appId") int appId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Boolean isAdmin = authentication.getAuthorities().stream().filter(o -> o.getAuthority().equals("ADMIN")).findFirst().isPresent();

		ModelAndView vista = new ModelAndView("applications/applicationsDetails");
		Application application = new Application();
		Optional<Application> ap = this.applicationService.findApplicationById(appId);
		if (ap.isPresent()) {
			application = ap.get();
		}
		// Esto es una prueba
		vista.addObject("app", application);
		vista.addObject("isAdmin", isAdmin);
		return vista;
	}

	@GetMapping("/pdf/{appId}")
	public void appToPDF(@PathVariable("appId") int appId, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView vistaPDF = new ModelAndView("applications/applicationsDetails");
		Application application = new Application();
		Optional<Application> ap = this.applicationService.findApplicationById(appId);
		if (ap.isPresent()) {
			application = ap.get();
		}

		Map<String, String> data = new HashMap<String, String>();
		data.put("name", application.getName());
		data.put("description", application.getDescription());
		data.put("picture", application.getPicture());
		data.put("releaseDate", application.getReleaseDate().toString());
		data.put("price", application.getPrice().toString());
		data.put("website", application.getWebsite());
		data.put("company", application.getCompany());
		data.put("incomeEstimation", application.getIncomeEstimation().toString());
		data.put("salesEstimation", application.getSalesEstimation().toString());
		data.put("totalReviews", application.getTotalReviews().toString());

		File outputPDF = pdfGenerator.createPdf("applications/applicationOnPDF", data, application.getName());

		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=" + outputPDF);

		try (OutputStream out = response.getOutputStream()) {
			Path path = outputPDF.toPath();
			Files.copy(path, out);
			out.flush();
		}
		catch (IOException e) {
			// handle exception
		}

	}

	@RequestMapping("/get")
	public ModelAndView getApplication(@RequestParam String id) throws IOException, JSONException {
		ModelAndView vista = new ModelAndView("applications/applicationsDetails");
		Application application = this.applicationService.getInfoOfOneApplication(id);
		vista.addObject("app", application);
		return vista;
	}

	@GetMapping("appInfo/edit")
	public String initUpdateForm(@RequestParam int appId, ModelMap model) {
		String view = "applications/createOrUpdateApplicationForm";
		Application application = new Application();
		Optional<Application> ap = this.applicationService.findApplicationById(appId);
		if (ap.isPresent()) {
			application = ap.get();
		}
		model.put("app", application);
		return view;
	}

	@PostMapping("appInfo/edit")
	public String processUpdateForm(@Valid Application application, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.put("app", application);
			return "applications/createOrUpdateApplicationForm";
		}
		else {
			Application application1 = this.applicationService.saveApplication(application);
			String vista = "applications/applicationsDetails";
			model.put("app", application1);
			return vista;
		}
	}

	@RequestMapping("appInfo/delete")
	public String deleteApp(@RequestParam("appId") int appId) {

		Optional<Application> ap = this.applicationService.findApplicationById(appId);
		ap.ifPresent(application -> this.applicationService.deleteApplication(application));
		return "applications/todoOk";
	}

	@GetMapping("/appInfo/{appId}/favorite")
	public String addToFavorites(@PathVariable("appId") int appId, ModelMap model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		Application app = new Application();
		User user = this.userService.userByUsername(currentPrincipalName);
		Optional<Application> ap = this.applicationService.findApplicationById(appId);
		if (ap.isPresent()) {
			app = ap.get();
		}
		user.getFavorites().add(app);
		userService.saveUser(user);

		model.addAttribute("favorites", user.getFavorites());
		return "applications/favorites";
	}

	@RequestMapping("/favorites/delete")
	public String deleteFavorite(@RequestParam("appId") int appId, ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User currentUser = userService.userByUsername(currentPrincipalName);
		List<Application> newList = new ArrayList<Application>(currentUser.getFavorites());
		newList.removeIf(x -> x.getId() == appId);
		currentUser.setFavorites(newList);
		userService.saveUser(currentUser);
		model.addAttribute("favorites", currentUser.getFavorites());
		return "applications/favorites";

	}

	@GetMapping("/favorites")
	public String favorites(final ModelMap modelMap) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		String vista = "applications/favorites";
		List<Application> favorites = this.userService.userByUsername(currentPrincipalName).getFavorites();
		modelMap.addAttribute("favorites", favorites);
		return vista;
	}

}
