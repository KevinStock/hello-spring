package org.launchcode.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.models.HelloMessage;
import org.launchcode.models.Language;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	public ArrayList<Language> setLanguages() {
		ArrayList<Language> languages = new ArrayList<Language>();
		languages.add(new Language("English", "Hello, "));
		languages.add(new Language("Italian", "Ciao, "));
		languages.add(new Language("Croatian", "Bog, "));
		return languages;
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloForm(Model model) {
		model.addAttribute("languages", setLanguages());
		return "helloform";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String hello(HttpServletRequest request, Model model) {
		
		// get name parameter from request; will be null of no parameter passed in
		String name = request.getParameter("name");
				
		if (name == null || name == "") {
			name = "world";
		}
		
		String language = request.getParameter("language");
				
		model.addAttribute("message", HelloMessage.getMessage(name, language));
		return "hello";
	}
	
}
