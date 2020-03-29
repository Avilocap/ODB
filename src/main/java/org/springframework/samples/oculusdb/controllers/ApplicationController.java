
package org.springframework.samples.oculusdb.controllers;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/applications")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String listadoAplicaciones(final ModelMap modelMap) {
		String vista = "applications/listadoAplicaciones";
		Iterable<Application> applications = applicationService.findAll();
		modelMap.addAttribute("applications", applications);
		return vista;

	}

	@GetMapping("/loadGet")
	public String loadApplicationGet() {
		return "applications/getApplication";
	}

	@GetMapping("/appInfo/{appId}")
	public ModelAndView showOwner2(@PathVariable("appId") int appId) {

		ModelAndView vista = new ModelAndView("applications/applicationsDetails");
		Application application = new Application();
		Optional<Application> ap = this.applicationService.findApplicationById(appId);
		if (ap.isPresent()) {
			application = ap.get();
		}
		// Esto es una prueba
		vista.addObject("app", application);
		return vista;
	}

	@GetMapping("/pdf/{appId}")
	public ModelAndView appToPDF(@PathVariable("appId") int appId) throws Exception {
		// https://www.oodlestechnologies.com/blogs/How-To-Create-PDF-through-HTML-Template-In-Spring-Boot/
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

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				"org.springframework.samples.oculusdb");
		context.refresh();
		PdfGeneratorUtil pdfGenerator = context.getBean(PdfGeneratorUtil.class);

		pdfGenerator.createPdf("applications/applicationOnPDF", data);
		vistaPDF.addObject("app", application);
		return vistaPDF;
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
		List<Application> favorites = new ArrayList<>();
		User user = this.userService.userByUsername(currentPrincipalName);
		favorites = user.getFavorites();
		Optional<Application> ap = this.applicationService.findApplicationById(appId);
		if (ap.isPresent()) {
			app = ap.get();
		}
		favorites.add(app);
		user.setFavorites(favorites);
		userService.saveUser(user);
		model.addAttribute("favorites", favorites);
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
