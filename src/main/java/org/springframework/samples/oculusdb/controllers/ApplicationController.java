
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

	private String favs = "favorites";

	@GetMapping("/list")
	public String listadoAplicaciones(final ModelMap modelMap) {
		Authentication authentication0 = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication0.getName();
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
		Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication1.getName();
		User user = this.userService.userByUsername(currentPrincipalName);
		if (userService.isAdmin(user)) {
			modelMap.addAttribute("admin", true);
		}
		String vista = "applications/listadoAplicaciones";
		Iterable<Application> applications = applicationService.findAll();
		List<Application> applications3 = (List<Application>) applications;

		applications3.sort(Comparator.comparing(a -> a.getCategory().getId()));
		modelMap.addAttribute("applications", applications3);
		return vista;

	}

	@GetMapping("/loadGet")
	public String loadApplicationGet() {
		Authentication authentication2 = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication2.getName();
		User user = this.userService.userByUsername(currentPrincipalName);
		if (userService.isAdmin(user)) {
			return "applications/getApplication";
		}
		else {
			return "security/login";
		}

	}

	@GetMapping("/loadGetBanner")
	public String loadBannerGet() {
		Authentication authentication2 = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication2.getName();
		User user = this.userService.userByUsername(currentPrincipalName);
		if (userService.isAdmin(user)) {
			return "applications/getBanner";
		}
		else {
			return "security/login";
		}

	}

	@GetMapping("/appInfo/{appId}")
	public ModelAndView showOwner2(@PathVariable("appId") int appId) {
		Authentication authentication3 = SecurityContextHolder.getContext().getAuthentication();
		Boolean isAdmin = authentication3.getAuthorities().stream().anyMatch(o -> o.getAuthority().equals("ADMIN"));

		ModelAndView vista = new ModelAndView("applications/applicationsDetails");
		Application application = new Application();
		Optional<Application> ap = this.applicationService.findApplicationById(appId);
		if (ap.isPresent()) {
			application = ap.get();
		}
		vista.addObject("app", application);
		vista.addObject("isAdmin", isAdmin);
		vista.addObject("positiveWords", applicationService.getPositiveWords(application));
		vista.addObject("negativeWords", applicationService.getNegativeWords(application));

		return vista;
	}

	@GetMapping("/pdf/{appId}")
	public void appToPDF(@PathVariable("appId") int appId, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Application application = new Application();
		Optional<Application> ap = this.applicationService.findApplicationById(appId);
		if (ap.isPresent()) {
			application = ap.get();
		}

		Map<String, String> data = new HashMap<>();
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
		boolean applicationExists = applicationService.applicationExists(id);
		if (!applicationExists) {
			Application application = this.applicationService.getInfoOfOneApplication(id);
			vista.addObject("app", application);
		}
		else {
			vista = new ModelAndView("applications/appexists");
		}

		return vista;
	}

	@RequestMapping("/getBanner")
	public String getBanner(@RequestParam String id) throws IOException, JSONException {
		if (id.isEmpty()) {
			String errorView = "users/bannerChangedError";
			return errorView;
		}
		userService.changeBanner(id);
		String view = "users/bannerChanged";
		return view;
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

		Integer userId = this.userService.userByUsername(currentPrincipalName).getId();

		boolean favoriteExists = this.applicationService.favoriteExists(appId, userId);

		Application app = new Application();
		User user = this.userService.userByUsername(currentPrincipalName);
		Optional<Application> ap = this.applicationService.findApplicationById(appId);
		if (ap.isPresent()) {
			app = ap.get();
		}
		if (favoriteExists) {
			return "applications/favoriteExists";
		}
		else {
			user.getFavorites().add(app);
			userService.saveUser(user);

			model.addAttribute(favs, user.getFavorites());
			return "applications/favorites";
		}

	}

	@RequestMapping("/favorites/delete")
	public String deleteFavorite(@RequestParam("appId") int appId, ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User currentUser = userService.userByUsername(currentPrincipalName);
		List<Application> newList = new ArrayList<>(currentUser.getFavorites());
		newList.removeIf(x -> x.getId() == appId);
		currentUser.setFavorites(newList);
		userService.saveUser(currentUser);
		model.addAttribute(favs, currentUser.getFavorites());
		return "applications/favorites";

	}

	@GetMapping("/favorites")
	public String favorites(final ModelMap modelMap) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();

		String vista = "applications/favorites";
		List<Application> favorites = this.userService.userByUsername(currentPrincipalName).getFavorites();
		modelMap.addAttribute(favs, favorites);
		return vista;
	}

}
