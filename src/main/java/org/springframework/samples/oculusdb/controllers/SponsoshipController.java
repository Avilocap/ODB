
package org.springframework.samples.oculusdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.application.Comments;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.model.User;
import org.springframework.samples.oculusdb.services.CreditCardService;
import org.springframework.samples.oculusdb.services.SponsorService;
import org.springframework.samples.oculusdb.services.SponsorShipService;
import org.springframework.samples.oculusdb.services.UserService;
import org.springframework.samples.oculusdb.sponsor.Sponsor;
import org.springframework.samples.oculusdb.sponsor.Sponsorship;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/sponsorship")
public class SponsoshipController {

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
			Sponsor sponsor = sponsorService.sponsorByUsername(user.getUsername());
			Iterable<Sponsorship> sponsorships = sponsor.getSponsorships();
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

}
