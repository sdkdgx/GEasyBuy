package sdust.easybuy.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sdust.easybuy.model.EasyBuyProductCategory;
import sdust.easybuy.services.EasyBuyProductCategoryService;

@Controller
@RequestMapping("/productCategory")
public class EasyBuyProductCategoryController {

	@RequestMapping("/getAll")
	public String getAllProductCategory() {

		return "index";
	}

}
