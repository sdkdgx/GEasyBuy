package sdust.easybuy.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.catalina.connector.Request;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import sdust.easybuy.model.EasyBuyProduct;
import sdust.easybuy.model.EasyBuyProductCategory;
import sdust.easybuy.services.EasyBuyProductCategoryService;
import sdust.easybuy.services.EasyBuyProductService;

@Controller
@RequestMapping("/product")
//商品Controller
public class EasyBuyProductController {

	EasyBuyProductCategoryService easyBuyProductCategoryService = new EasyBuyProductCategoryService();
	EasyBuyProductService easyBuyProductService = new EasyBuyProductService();

	//展示商品详情
	@RequestMapping("/showView/{id}")
	public ModelAndView showView(@PathVariable("id") int id,
			HttpServletRequest request) {
		EasyBuyProduct product = easyBuyProductService.getProductById(id);
		List<EasyBuyProductCategory> productCategories = easyBuyProductCategoryService
				.getAllProductCategories();
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", product);
		mav.addObject("productCategories", productCategories);
		mav.setViewName("product-view");
		recentBrowse(request, product);
		return mav;
	}

	//这个是分页处理的方法
	public void recentBrowse(HttpServletRequest request, EasyBuyProduct product) {
		ArrayList<EasyBuyProduct> recentList = (ArrayList<EasyBuyProduct>) request
				.getSession().getAttribute("recentList");

		if (recentList == null)
			recentList = new ArrayList<EasyBuyProduct>();
		else {
			Iterator<EasyBuyProduct> iter = recentList.iterator();
			while (iter.hasNext()) {
				if (iter.next().getEpId() == product.getEpId()) {
					iter.remove();
				}
			}

			if (recentList.size() > 3)
				recentList.remove(recentList.size() - 1);
		}
		recentList.add(0, product);
		request.getSession().setAttribute("recentList", recentList);
	}

	//进入商品管理页面
	@RequestMapping("/enterProductManage")
	public ModelAndView enterProductManage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manage/product");
		List<EasyBuyProduct> products = easyBuyProductService.getAllProducts();
		mav.addObject("products", products);
		return mav;
	}

	//进入商品信息修改页面
	@RequestMapping("/enterProductModify/{id}")
	public ModelAndView enterProductModify(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView();
		EasyBuyProduct product = easyBuyProductService.getProductById(id);
		mav.addObject("product", product);
		List<EasyBuyProductCategory> ebpcs = easyBuyProductCategoryService
				.getSecondCategory();
		mav.addObject("ebpcs", ebpcs);
		mav.setViewName("manage/product-modify");
		return mav;
	}

	//进入商品删除页面，并进行商品删除处理。
	@RequestMapping("/enterProductDelete/{id}")
	public ModelAndView enterProductDelete(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/product/enterProductManage");
		EasyBuyProduct ebp = easyBuyProductService.getProductById(id);
		easyBuyProductService.delete(ebp);
		return mav;
	}

	//进入商品新增界面。
	@RequestMapping("/enterProductCreate")
	public ModelAndView enterProductCreate() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manage/product-add");
		List<EasyBuyProductCategory> ebpcs = easyBuyProductCategoryService
				.getSecondCategory();
		mav.addObject("ebpcs", ebpcs);
		return mav;
	}

	//进行商品信息的更新处理。
	@RequestMapping("productUpdate")
	public ModelAndView productUpdate(EasyBuyProduct product) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/product/enterProductManage");
		EasyBuyProduct ebp = easyBuyProductService.getProductById(product.getEpId());

		ebp.setEpName(product.getEpName());
		EasyBuyProductCategory ebpc = easyBuyProductCategoryService
				.getProductCategoryEbpcById(product.getEasyBuyProductCategory()
						.getEpcId());
		ebp.setEasyBuyProductCategory(ebpc);
		ebp.setEpStock(product.getEpStock());
		ebp.setEpPrice(product.getEpPrice());

		easyBuyProductService.update(ebp);
		return mav;
	}

	//进行商品新增的处理和操作。
	@RequestMapping(value = "/productCreate", method = RequestMethod.POST)
	public ModelAndView productCreate(
			EasyBuyProduct product,
			@RequestParam("epProduct") MultipartFile file,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/product/enterProductManage");
		System.out.println(file.getOriginalFilename());
		
		System.out.println(product.getEpDescription());
		System.out.println(product.getEpName());
		System.out.println(product.getEasyBuyProductCategory());
		System.out.println(product.getEpPrice());
		System.out.println(product.getEpStock());
		
		product.setEpSpecial(0);
		
		String fileName = "/easybuy/images/product/" + file.getOriginalFilename();
		
		product.setEpFileName(fileName);
		product.setEpcChildId(0);
		
		System.out.println(product.getEpSpecial());
		System.out.println(product.getEpFileName());
		
		easyBuyProductService.save(product);

		if (!file.isEmpty()) {
			try {
				String filePath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "images\\product/" + file.getOriginalFilename();
				file.transferTo(new File(filePath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return mav;
	}
}
