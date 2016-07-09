package sdust.easybuy.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sdust.easybuy.model.EasyBuyProduct;
import sdust.easybuy.model.EasyBuyUser;
import sdust.easybuy.services.EasyBuyProductService;
import sdust.easybuy.services.EasyBuyUserService;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/hello1")
	public String hello1() {
		System.out.println("Is in SuccessController!");
		return "loginSuccess";
	}

	@RequestMapping("/hello2/{name}")
	public ModelAndView hello2(@PathVariable("name") String name) {
		System.out.println(name);
		List<EasyBuyProduct> products = new EasyBuyProductService()
				.getAllProducts();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.addObject("products", products);
		mav.setViewName("loginSuccess");
//		map.put("name", name);
//		map.put("products", products);
		return mav;
	}

}
