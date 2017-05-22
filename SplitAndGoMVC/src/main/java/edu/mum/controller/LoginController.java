package edu.mum.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "failed", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Locale locale) {

		if (error != null) {
			model.addAttribute("error", messageSource.getMessage("error.invaliduserpass", null, locale));
		}

		if (logout != null) {
			model.addAttribute("logoutMsg", messageSource.getMessage("logout.success", null, locale));
		}

		return "login";
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accesssDenied(Model model) {
		return "403";
	}
}