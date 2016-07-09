package sdust.easybuy.controllers;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sdust.easybuy.model.EasyBuyUser;
import sdust.easybuy.services.EasyBuyUserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	static {
		System.out.println("ok");
	}

	@RequestMapping("/doLogin")
	public String login(@ModelAttribute EasyBuyUser user, HttpSession session) {
		System.out.println(user.getEuUserName() + ": " + user.getEuPassword());
		System.out.println("It's in Login/Login");
		String key = (String) session
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		System.out.println(key);
		if (user != null) {
			EasyBuyUser ebu = new EasyBuyUserService().login(user);
			{
				if (ebu != null) {
					session.setAttribute("user", ebu);
					return "redirect:/index/firstPage";
				}
			}
		}
		return "loginError";

	}

}
