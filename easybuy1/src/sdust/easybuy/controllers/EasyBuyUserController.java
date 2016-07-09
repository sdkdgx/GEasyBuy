package sdust.easybuy.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sdust.easybuy.model.EasyBuyUser;
import sdust.easybuy.services.EasyBuyUserService;

@Controller
@RequestMapping("/user")
public class EasyBuyUserController {
	
	@RequestMapping("/register")
	public String registerUser(EasyBuyUser user, HttpSession session){
		user.setEuStatus(1);
		new EasyBuyUserService().registerUser(user);
		session.setAttribute("user", user);
		return "redirect:/index/firstPage";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.setAttribute("user", null);
		return "redirect:/index/firstPage";
	}

}
