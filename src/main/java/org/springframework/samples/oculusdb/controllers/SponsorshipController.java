
package org.springframework.samples.oculusdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.application.Comments;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.services.SponsorService;
import org.springframework.samples.oculusdb.services.SponsorShipService;
import org.springframework.samples.oculusdb.services.UserService;
import org.springframework.samples.oculusdb.sponsor.Sponsor;
import org.springframework.samples.oculusdb.sponsor.Sponsorship;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/sponsorship")
public class SponsorshipController {

	@Autowired
	private SponsorService sponsorService;

	@Autowired
	private SponsorShipService sponsorShipService;

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String listSponsorships(final ModelMap modelMap) {
		String vista;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = this.userService.userByUsername(currentPrincipalName);
		if (userService.isSponsor(user)) {
			vista = "sponsorship/list";
			Iterable<Sponsorship> sponsorships = userService.sponsorshipsOfUser(user);
			modelMap.addAttribute("sponsorships", sponsorships);
		}
		else {
			vista = "error";
		}
		return vista;
	}

	@GetMapping(value = "/new")
	public String addSponsorship(final ModelMap modelMap) {
		Sponsorship sponsorship = new Sponsorship();
		modelMap.addAttribute("sponsorship", sponsorship);
		return "sponsorship/new";

	}

	@PostMapping(value = "/new")
	public String newSponsorhip(@Valid Sponsorship sponsorship, BindingResult result,
								  ModelMap model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = this.userService.userByUsername(currentPrincipalName);
		if(result.hasErrors()) {
			return "sponsorship/new";
		}
		if (userService.isSponsor(user)) {
			sponsorship.setUser(user);
			sponsorShipService.saveSponsorship(sponsorship);
			user.getSponsorships().add(sponsorship);
			userService.saveUser(user);
		}

		return "sponsorship/creacion";
	}

}
