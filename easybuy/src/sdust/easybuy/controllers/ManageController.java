package sdust.easybuy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManageController {

	//进入后台管理系统界面。
	@RequestMapping("/enterManage")
	public ModelAndView enterManageSystem(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manage/index");
		return mav;
	}
	
}
