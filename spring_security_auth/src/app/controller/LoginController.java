package app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

//	@RequestMapping(path = "/login", method = RequestMethod.GET)
//	public ModelAndView login() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("/login");
//		return mv;
//	}
//
//	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/logout-success", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout=true";
	}

	@RequestMapping(path = "/login-status-error", method = RequestMethod.GET)
	public String loginStatus(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/login?error=true";
	}

	@GetMapping(value = "/private/main")
	public ModelAndView Veteriner() throws Exception {
		ModelAndView model = new ModelAndView();
		model.setViewName("main");
		return model;
	}

	// For Main Page Load...

//	  @GetMapping(value = "/main") public ModelAndView anaSayfa() throws Exception
//	  { ModelAndView model = new ModelAndView(); model.setViewName("main"); return
//	  model; }

}