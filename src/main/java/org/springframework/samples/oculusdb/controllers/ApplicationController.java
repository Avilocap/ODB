
package org.springframework.samples.oculusdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		vista.addObject("app", application);
		return vista;
	}

	@RequestMapping("/get")
	public ModelAndView getApplication(@RequestParam String id) throws IOException {
		ModelAndView vista = new ModelAndView("applications/applicationsDetails");
		Application application = this.applicationService.getInfoOfOneApplication(id);
		vista.addObject("app", application);
		return vista;
	}

}
