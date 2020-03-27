/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.oculusdb.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.services.ApplicationService;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.modelmbean.ModelMBeanAttributeInfo;

@Controller
public class WelcomeController {

	@Autowired
	private ApplicationService applicationService;

	@GetMapping("/")
	public String welcome(final ModelMap modelMap) {
		Iterable<Application> applications = applicationService.findAll();
		modelMap.addAttribute("applications", applications);
		return "welcome";
	}

}
