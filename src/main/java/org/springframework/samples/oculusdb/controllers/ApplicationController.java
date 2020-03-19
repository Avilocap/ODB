
package org.springframework.samples.oculusdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/applications")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@GetMapping("/applications/list")
	public String listadoAplicaciones(final ModelMap modelMap) {
		String vista = "applications/listadoAplicaciones";
		Iterable<Application> applications = applicationService.findAll();
		modelMap.addAttribute("applications", applications);
		return vista;
		
	}
	
	
	@GetMapping("/applications/{applicationId}")
	public ModelAndView showOwner(@PathVariable("applicationId") int applicationId) {
		
		ModelAndView mav = new ModelAndView("applications/applicationsDetails");
		mav.addObject(this.applicationService.findApplicationById(applicationId));
		return mav;
	}

	@RequestMapping("/get")
	public String getApplication(@RequestParam String id) throws IOException {
		String vista = "applications/test";
		this.applicationService.getInfoOfOneApplication(id);
		return vista;
	}

}
