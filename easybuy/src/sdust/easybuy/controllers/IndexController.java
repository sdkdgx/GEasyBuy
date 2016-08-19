package sdust.easybuy.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sdust.easybuy.model.EasyBuyComment;
import sdust.easybuy.model.EasyBuyNews;
import sdust.easybuy.model.EasyBuyProduct;
import sdust.easybuy.model.EasyBuyProductCategory;
import sdust.easybuy.services.EasyBuyCommentService;
import sdust.easybuy.services.EasyBuyNewsService;
import sdust.easybuy.services.EasyBuyProductCategoryService;
import sdust.easybuy.services.EasyBuyProductService;

@Controller
@RequestMapping("/index")
//主页Controller
public class IndexController {
	//进入首页
	@RequestMapping("/firstPage")
	public ModelAndView index(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		//获取首页展示需要的全部数据。
		List<EasyBuyProduct> ebpDisc = new EasyBuyProductService()
				.getAllProducts();
		List<EasyBuyProduct> ebpHot = new EasyBuyProductService()
				.getAllProducts();
		List<EasyBuyNews> newses = new EasyBuyNewsService().getTopNewses();
		List<EasyBuyComment> comments = new EasyBuyCommentService()
				.getAllComments();
		List<EasyBuyProductCategory> ebpcs = new EasyBuyProductCategoryService()
				.getAllProductCategories();
		List<EasyBuyProduct> specialProducts = new EasyBuyProductService().getSpecialProducts(1);
		//将获取到的数据全部保存至ModelAndView。
		mav.setViewName("index");
		mav.addObject("products", ebpDisc);
		mav.addObject("hotProducts", ebpHot);
		mav.addObject("newses", newses);
		mav.addObject("comments", comments);
		mav.addObject("productCategories", ebpcs);
		mav.addObject("specialProducts", specialProducts);
		return mav;
	}

}
