package com.thigpen.login_reg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thigpen.login_reg.models.LoginUser;
import com.thigpen.login_reg.models.User;
import com.thigpen.login_reg.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userServ;
	
	
	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "index.jsp";
	}

	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
	
		this.userServ.register(newUser, result);
        
        
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/landingpage";
	}
	
	
	@PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		
        User user = this.userServ.login(newLogin, result); //the service method login will either return null if there are validation errors, or it will return a whole user object from the db that the user is trying to log in as
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/landingpage";
    }
	
	@GetMapping("/landingpage")
	public String home(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
		Long loggedInUserId = (Long)session.getAttribute("user_id");
		
		if(loggedInUserId == null) {
			//generate a flash message to show on the redirect
			redirectAttributes.addFlashAttribute("notAllowed", "You must log in first!");
			return "redirect:/";
		}
		
		//use the id from session to find a user in our database that has that id, so we can pass that user to the template 
		User loggedInUser = this.userServ.findUser(loggedInUserId);
		model.addAttribute("loggedInUser", loggedInUser);
		
		return "landingpage.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_id");
		return "redirect:/";
	}
	
}
