package sdust.easybuy.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sdust.easybuy.model.EasyBuyOrder;
import sdust.easybuy.model.EasyBuyOrderDetail;
import sdust.easybuy.model.EasyBuyShoppingCart;
import sdust.easybuy.model.EasyBuyUser;
import sdust.easybuy.services.EasyBuyOrderDetailService;
import sdust.easybuy.services.EasyBuyOrderService;
import sdust.easybuy.services.EasyBuyShoppingCartService;

@Controller
@RequestMapping("/order")
public class EasyBuyOrderController {

	// 获取Service对象。
	EasyBuyOrderService service = new EasyBuyOrderService();
	EasyBuyOrderDetailService ebodService = new EasyBuyOrderDetailService();
	EasyBuyShoppingCartService ebscService = new EasyBuyShoppingCartService();

	// 进入后台管理系统的订单管理界面。
	@RequestMapping("/enterOrderManage")
	public ModelAndView enterOrderManage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manage/order");
		List<EasyBuyOrder> orders = service.getAllOrders();
		mav.addObject("orders", orders);
		return mav;
	}

	// 进入对某个订单的修改界面。
	@RequestMapping("/enterOrderModify/{id}")
	public ModelAndView enterOrderModify(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manage/order-modify");
		EasyBuyOrder order = service.getOrderByOrderId(id);
		mav.addObject("order", order);
		return mav;
	}

	// 进入订单删除并进行对某个订单的删除。
	@RequestMapping("/enterOrderDelete/{id}")
	public ModelAndView enterOrderDelete(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/order/enterOrderManage");
		EasyBuyOrder order = service.getOrderByOrderId(id);
		service.deleteOrderByOrder(order);
		return mav;
	}

	// 接受来自订单修改界面的信息，对订单信息进行修改并保存。
	@RequestMapping("/orderUpdate")
	public ModelAndView orderUpdate(EasyBuyOrder order) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/order/enterOrderManage");
		EasyBuyOrder ebo = service.getOrderByOrderId(order.getEoId());
		ebo.setEoStatus(order.getEoStatus());
		ebo.setEoType(order.getEoType());
		ebo.setEasyBuyUser(order.getEasyBuyUser());
		service.update(order);
		System.out.println("#########" + order);
		return mav;
	}

	// 在购物车点击结算后进入，创建一个新的订单。
	@RequestMapping("/orderCreate")
	public ModelAndView orderCreate(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/index/firstPage");
		EasyBuyOrder order = new EasyBuyOrder();

		EasyBuyUser user = (EasyBuyUser) session.getAttribute("user");

		order.setEasyBuyUser(user);
		order.setEoCreateTime(new Timestamp(System.currentTimeMillis()));
		order.setEoRerAddress(user.getEuAddress());
		order.setEoStatus(1);
		order.setEoType(1);

		service.saveOrUpdate(order);

		List<EasyBuyOrderDetail> ebods = new ArrayList<EasyBuyOrderDetail>();

		Set<EasyBuyShoppingCart> carts = user.getEasyBuyShoppingCarts();

		Iterator<EasyBuyShoppingCart> iter = carts.iterator();

		while (iter.hasNext()) {
			EasyBuyShoppingCart cart = iter.next();
			if (cart.getEscProductQuantity() > 0) {
				EasyBuyOrderDetail ebod = new EasyBuyOrderDetail();
				ebod.setEasyBuyOrder(order);
				ebod.setEasyBuyProduct(cart.getEasyBuyProduct());
				ebod.setEodQuantity(cart.getEscProductQuantity());
				ebods.add(ebod);
				ebscService.deleteCart(cart);
				iter.remove();
			}
		}

		for (EasyBuyOrderDetail ebod : ebods) {
			ebodService.saveOrUpdate(ebod);
		}

		return mav;

	}

}
