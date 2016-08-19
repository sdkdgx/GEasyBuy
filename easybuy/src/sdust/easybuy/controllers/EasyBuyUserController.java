package sdust.easybuy.controllers;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sdust.easybuy.model.EasyBuyUser;
import sdust.easybuy.services.EasyBuyUserService;

@Controller
@RequestMapping("/user")
// 用户Controller
public class EasyBuyUserController {

	EasyBuyUserService easyBuyUserService = new EasyBuyUserService();

	// 进入登录页面
	@RequestMapping("/enterLogin")
	public String enterLogin() {
		return "login";
	}

	// 进行登陆操作
	@RequestMapping("/doLogin")
	public String login(@ModelAttribute EasyBuyUser user, HttpSession session,
			HttpServletRequest request) {
		System.out.println(user.getEuUserName() + ": " + user.getEuPassword());
		System.out.println("It's in Login/Login");
		if (user != null) {
			//判断用户名是否为空。
			if (user.getEuUserName() == null || user.getEuUserName().equals("")) {
				request.setAttribute("msg", "用户名不能为空 !");
				return "login";
			}
			//判断密码是否为空。
			if (user.getEuPassword() == null || user.getEuPassword().equals("")) {
				request.setAttribute("msg", "密码不能为空 !");
				return "login";
			}
			//从数据库中查出符合条件的用户是否存在。
			EasyBuyUser ebu = easyBuyUserService.login(user);
			{
				//若存在，则将User存入session中，跳转至首页。
				if (ebu != null) {
					session.setAttribute("user", ebu);
					return "redirect:/index/firstPage";
				} 
				//若所查询的用户不存在，则返回登录页面。
				else {
					request.setAttribute("msg", "用户名或密码不正确 !");
					return "login";
				}
			}
		}
		//跳转至错误界面。
		return "loginError";

	}

	// 进入注册页面
	@RequestMapping("/enterRegister")
	public String enterRegister() {
		return "register";
	}

	// 进行注册操作
	@RequestMapping("/doRegister")
	public String registerUser(EasyBuyUser user, HttpSession session) {
		//默认注册的用户是普通用户。
		user.setEuStatus(1);
		session.setAttribute("user", user);
		user.setEuBirthday(new Date(System.currentTimeMillis()));
		easyBuyUserService.registerUser(user);
		return "redirect:/index/firstPage";
	}

	// 退出登陆
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.setAttribute("user", null);
		return "redirect:/index/firstPage";
	}

	// 当购物车请求此操作时更新session中的User
	@RequestMapping("/updateUserForCart")
	public ModelAndView updateUserForCart(HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/cart/getCart");
		EasyBuyUser user = easyBuyUserService.getUser((EasyBuyUser) session
				.getAttribute("user"));
		System.out.println(user.getEasyBuyShoppingCarts().size());
		session.setAttribute("user", user);
		return mav;
	}

	// 进入用户管理页面
	@RequestMapping("enterUserManage")
	public ModelAndView enterUserManage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manage/user");
		List<EasyBuyUser> users = easyBuyUserService.getAllUser();
		mav.addObject("users", users);
		return mav;
	}

	// 进入用户修改页面
	@RequestMapping("/userModify/{id}")
	public ModelAndView userModify(@PathVariable(value = "id") int id) {
		ModelAndView mav = new ModelAndView();
		EasyBuyUser user = easyBuyUserService.getUserByUserId(id);
		mav.setViewName("manage/user-modify");
		mav.addObject("ebuser", user);
		return mav;
	}

	// 进行用户信息修改操作
	@RequestMapping("/userUpdate")
	public ModelAndView userUpdate(EasyBuyUser user) {
		System.out.println(user.getEuUserId());
		ModelAndView mav = new ModelAndView();
		EasyBuyUser eu = easyBuyUserService.getUser(user);
		user.setEuBirthday(eu.getEuBirthday());
		easyBuyUserService.updateUser(user);
		mav.setViewName("redirect:/user/enterUserManage");
		return mav;
	}

	// 进入用户新增页面
	@RequestMapping("/enterUserAdd")
	public ModelAndView userAdd() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manage/user-add");
		return mav;
	}

	// 进行用户新增操作
	@RequestMapping("/userCreate")
	public ModelAndView userCreate(EasyBuyUser user) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/user/enterUserManage");
		user.setEuStatus(1);
		user.setEuBirthday(new Date(System.currentTimeMillis()));
		easyBuyUserService.saveOrUpdate(user);
		return mav;
	}

}
