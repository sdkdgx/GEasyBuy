package sdust.easybuy.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sdust.easybuy.model.EasyBuyProduct;
import sdust.easybuy.services.EasyBuyProductService;

@Controller
@RequestMapping("/product")
public class EasyBuyProductController {

	@RequestMapping("/showView/{id}")
	public String showView(@PathVariable("id") int id, HttpServletRequest request) {
		EasyBuyProduct product = new EasyBuyProductService().getProductById(id);
		request.setAttribute("product", product);
		System.out.println(product);
		return "product-view";
	}

}
