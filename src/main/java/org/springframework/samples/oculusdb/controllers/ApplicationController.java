
package org.springframework.samples.oculusdb.controllers;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/applications")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@GetMapping("/list")
	public String listadoAplicaciones(final ModelMap modelMap) {
		String vista = "applications/listadoAplicaciones";
		Iterable<Application> applications = applicationService.findAll();
		modelMap.addAttribute("applications", applications);
		return vista;

	}

	@GetMapping("/loadGet")
	public String loadApplicationGet() {
		String vista = "applications/getApplication";
		return vista;
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
			String view = "applications/createOrUpdateApplicationForm";
			return view;
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
		if (ap.isPresent()) {
			this.applicationService.deleteApplication(ap.get());
		}
		return "applications/todoOk";
	}

}
