package sdust.easybuy.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sdust.easybuy.model.EasyBuyProduct;
import sdust.easybuy.model.EasyBuyProductCategory;
import sdust.easybuy.services.EasyBuyProductCategoryService;
import sdust.easybuy.services.EasyBuyProductService;

@Controller
@RequestMapping("/productCategory")
public class EasyBuyProductCategoryController {

	//获取Service对象。
	private EasyBuyProductService pService = new EasyBuyProductService();
	private EasyBuyProductCategoryService pcService = new EasyBuyProductCategoryService();

	//获取所有商品分类。
	@RequestMapping("/getAll")
	public String getAllProductCategory() {

		return "index";
	}

	//根据商品分类Id获取某个商品分类，获取这个分类所有的商品。
	@RequestMapping("/getProductsByEpcId/{epcId}")
	public ModelAndView getProductsByEpcId(
			@PathVariable("epcId") int epcId,
			@RequestParam(value = "pageIndex", required = false) Integer pageIndex) {
		
		if(pageIndex == null)
			pageIndex = 1;
		int pageSize = 4;
		int count = pService.getProductsByEpcId(epcId).size();
        int totalPage  = count % pageSize == 0 ?(count/pageSize):((count/pageSize)+1);
        
		ModelAndView mav = new ModelAndView();
		mav.setViewName("product-list");
		List<EasyBuyProduct> products = pService.getProductsListByIdWithPage(epcId,pageIndex,pageSize);
		//List<EasyBuyProduct> products = pService.getProductsByEpcId(epcId);
		List<EasyBuyProductCategory> ebpcs = pcService
				.getAllProductCategories();
		mav.addObject("products", products);
		mav.addObject("productCategories", ebpcs);
		mav.addObject("pageIndex",pageIndex);
		mav.addObject("totalPage",totalPage);
		mav.addObject("epcId",epcId);
		return mav;
	}

	// 进入后台管理系统的分类管理界面。 
	@RequestMapping("/enterProductCategoryManage")
	public ModelAndView enterProductCatetoryManage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manage/productCategory");
		List<EasyBuyProductCategory> productCategories = pcService
				.getAllProductCategories();
		mav.addObject("ebpcs", productCategories);
		return mav;
	}

	// 进入商品分类新增界面。 
	@RequestMapping("/enterProductCategoryAdd")
	public ModelAndView enterProductCategoryAdd() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manage/productCategory-add");
		List<EasyBuyProductCategory> ebpcs = pcService.getFirstCategory();
		mav.addObject("ebpcs", ebpcs);
		return mav;
	}

	//处理商品分类新增界面传递过来的信息，并进行保存。
	@RequestMapping("/productCategoryCreate")
	public ModelAndView productCategoryCreate(EasyBuyProductCategory pc) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/productCategory/enterProductCategoryManage");
		pcService.saveOrUpdate(pc);
		return mav;
	}

	//进入商品分类信息修改界面。
	@RequestMapping("/enterProductCategoryUpdate/{id}")
	public ModelAndView enterProductCategoryUpdate(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manage/productCategory-modify");
		EasyBuyProductCategory ebpc = pcService.getProductCategoryEbpcById(id);
		List<EasyBuyProductCategory> ebpcs = pcService.getFirstCategory();
		mav.addObject("ebpcs", ebpcs);
		mav.addObject("ebpc", ebpc);
		return mav;
	}

	//进入商品分类信息删除界面，删除特定的分类。
	@RequestMapping("/enterProductCategoryDelete/{id}")
	public ModelAndView enterProductCategoryDelete(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/productCategory/enterProductCategoryManage");
		pcService.deleteByEbpcId(id);
		return mav;
	}

	//接受商品分类信息更新界面的信息，并进行更新处理。
	@RequestMapping("/productCategoryUpdate")
	public ModelAndView productCategoryUpdate(EasyBuyProductCategory pc) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/productCategory/enterProductCategoryManage");
		pcService.update(pc);
		return mav;
	}

}
