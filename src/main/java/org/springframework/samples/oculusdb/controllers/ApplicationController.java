
package org.springframework.samples.oculusdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/applications")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;


	@RequestMapping("/list")
	public String listadoAplicaciones(final ModelMap modelMap) {
		String vista = "applications/listadoAplicaciones";
		Iterable<Application> applications = this.applicationService.findAll();
		modelMap.addAttribute("applications", applications);
		return vista;
	}

	@RequestMapping("/get")
	public String getApplication(@RequestParam String id) throws IOException {
		String vista = "applications/test";
		this.applicationService.getInfoOfOneApplication(id);
		return vista;
	}

}
