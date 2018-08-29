package com.site.StickyBoard;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	public SiteUserService siteUserService;
	
	@GetMapping("login")
	public String loginPage() {
		return "login.html";
	}
	
	@GetMapping("logout")
	public String logoutPage() {
		return "logout.html";
	}
	
	@PostMapping("login")
	public String login() {
		return "redirect:/";
	}
	
	@PostMapping("logout")
	public String logout() {
		return "redirect:/";
	}
	
	@GetMapping("register")
	public ModelAndView registerPage(Model model) {
		return new ModelAndView("register.html", "siteUser", new SiteUserDTO());
	}
	
	@PostMapping("register")
	public String register(@Valid @ModelAttribute("siteUser")SiteUserDTO siteUserDTO, BindingResult result, Errors errors, Model model) {
		if(!result.hasErrors()) {
			SiteUser siteUser = registerUser(siteUserDTO, result);
			return "redirect:/";
		}
		model.addAttribute("errors", errors.getFieldErrors());
		return "register.html";
	}
	
	@RequestMapping("users")
	public String usersPage(Model model) {
		model.addAttribute("users", siteUserService.getAllUsers());
		return "users.html";
	}
	
	@RequestMapping("*")
	public ModelAndView defaultPage() {
		return new ModelAndView("defaultPage.html");
	}
	
	private SiteUser registerUser(SiteUserDTO siteUserDTO, BindingResult result) {
		SiteUser siteUser = null;
		try {
			siteUser = siteUserService.registerUser(siteUserDTO);
		} catch (Exception e) {
			
		}
		return siteUser;
	}
	
	

}
