package sdust.easybuy.controllers;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sdust.easybuy.model.EasyBuyProduct;
import sdust.easybuy.model.EasyBuyProductCategory;
import sdust.easybuy.model.EasyBuyShoppingCart;
import sdust.easybuy.model.EasyBuyUser;
import sdust.easybuy.services.EasyBuyProductCategoryService;
import sdust.easybuy.services.EasyBuyProductService;
import sdust.easybuy.services.EasyBuyShoppingCartService;
import sdust.easybuy.services.EasyBuyUserService;

@Controller
@RequestMapping("/cart")
// 购物车Controller
public class EasyBuyShoppingCartController {

	EasyBuyUserService ebuService = new EasyBuyUserService();
	EasyBuyShoppingCartService easyBuyShoppingCartService = new EasyBuyShoppingCartService();
	EasyBuyProductService easyBuyProductService = new EasyBuyProductService();

	// 进入购物车界面
	@RequestMapping("/getCart")
	public ModelAndView enterCart(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// 将所有的商品分类列表存入ModelAndView
		List<EasyBuyProductCategory> ebpcs = new EasyBuyProductCategoryService()
				.getAllProductCategories();
		mav.addObject("productCategories", ebpcs);
		// 获取当前登录的用户
		EasyBuyUser user = (EasyBuyUser) session.getAttribute("user");
		// 如果用户没有登录，则跳转用户登录页面。如果已经登录，进入购物车页面。
		if (user != null) {
			mav.setViewName("shopping");
		} else {
			mav.setViewName("redirect:/user/enterLogin");
		}
		return mav;
	}

	// 某个商品的数量增加:将某个商品的数量加一后再返回购物车页面。
	@RequestMapping("/add/{id}")
	public ModelAndView add(@PathVariable("id") int id, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// 从Session中获取目前登录用户的购物车列表。
		EasyBuyUser user = (EasyBuyUser) session.getAttribute("user");
		Set<EasyBuyShoppingCart> carts = user.getEasyBuyShoppingCarts();
		// 根据id将特定的购物车条目中的商品数量加一。
		for (EasyBuyShoppingCart cart : carts) {
			if (cart.getEscId() == id) {
				cart.setEscProductQuantity(cart.getEscProductQuantity() + 1);
				easyBuyShoppingCartService.saveOrUpdateCart(cart);
			}
		}
		mav.setViewName("redirect:/cart/getCart");
		return mav;
	}

	// 某个商品的数量减少:将某个商品的数量减一后再返回购物车页面。
	@RequestMapping("/dec/{id}")
	public ModelAndView dec(@PathVariable("id") int id, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// 从Session中获取目前登录用户的购物车列表。
		EasyBuyUser user = (EasyBuyUser) session.getAttribute("user");
		Set<EasyBuyShoppingCart> carts = user.getEasyBuyShoppingCarts();
		// 根据id将特定的购物车条目中的商品数量加一。
		for (EasyBuyShoppingCart cart : carts) {
			if (cart.getEscId() == id) {
				if (cart.getEscProductQuantity() > 0) {
					cart.setEscProductQuantity(cart.getEscProductQuantity() - 1);
					easyBuyShoppingCartService.saveOrUpdateCart(cart);
				}
			}
		}
		mav.setViewName("redirect:/cart/getCart");
		return mav;
	}

	// 加入购物车一个新的商品
	@RequestMapping("/addNewProduct/{id}")
	public ModelAndView addNewProduct(@PathVariable("id") int id,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		// 获取当前登录的用户。
		EasyBuyUser user = (EasyBuyUser) session.getAttribute("user");
		// 如果当前用户没有登录，则跳转用户登录界面。
		if (user == null) {
			mav.setViewName("redirect:/user/enterLogin");
		} else {
			// 获取当前用户的购物车。
			Set<EasyBuyShoppingCart> carts = user.getEasyBuyShoppingCarts();
			for (EasyBuyShoppingCart cart : carts) {
				// 如果购物车中已经有相同的商品，则不需要新增商品。直接跳转购物车页面。
				if (cart.getEasyBuyProduct().getEpId() == id) {
					mav.setViewName("redirect:/cart/getCart");
					return mav;
				}
			}
			// 获取需要添加的商品。
			EasyBuyProduct product = easyBuyProductService.getById(id);
			// 创建一个购物车条目对象。将对象所需要的数据添加到对象中。
			EasyBuyShoppingCart cart = new EasyBuyShoppingCart();
			cart.setEasyBuyProduct(product);
			cart.setEasyBuyUser(user);
			cart.setEscProductQuantity(1);
			// 调用Service将购物车条目插入到数据库。
			easyBuyShoppingCartService.saveOrUpdateCart(cart);
			// 跳转UserController调用UpdateUserForCart方法对Session中的User进行更新。
			mav.setViewName("redirect:/user/updateUserForCart");

		}

		return mav;
	}

	// 将购物车里的一个商品删除
	@RequestMapping("/del/{id}")
	public ModelAndView delNewProduct(@PathVariable("id") int id,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		EasyBuyShoppingCart cart = easyBuyShoppingCartService
				.getCartByCartId(id);
		easyBuyShoppingCartService.deleteCart(cart);
		mav.setViewName("redirect:/user/updateUserForCart");
		return mav;
	}

}
