package sdust.easybuy.services;

import java.util.List;

import sdust.easybuy.dao.EasyBuyShoppingCartDao;
import sdust.easybuy.model.EasyBuyShoppingCart;

public class EasyBuyShoppingCartService {

	//获取easyBuyShoppingCartDao对象。
	EasyBuyShoppingCartDao easyBuyShoppingCartDao = new EasyBuyShoppingCartDao();

	//根据Id获取一个购物车条目。
	public EasyBuyShoppingCart getCartByCartId(int id) {
		return easyBuyShoppingCartDao.getById(id);
	}

	//保存或者更新一个购物条目的信息。
	public void saveOrUpdateCart(EasyBuyShoppingCart cart) {
		easyBuyShoppingCartDao.saveOrUpdate(cart);
	}

	//根据UserId获取属于一个用户的所有购物车条目。
	public List<EasyBuyShoppingCart> getCartsByUserId(int id) {
		return easyBuyShoppingCartDao.getCartsByUserId(id);
	}

	//删除一个购物车的信息。
	public void deleteCart(EasyBuyShoppingCart cart) {
		easyBuyShoppingCartDao.delete(cart);
	}

	//测试。
	public static void main(String[] args) {
		EasyBuyShoppingCartService service = new EasyBuyShoppingCartService();
		EasyBuyShoppingCart cart = service.getCartByCartId(57);
		System.out.println(cart.getEasyBuyProduct().getEpDescription());
		service.deleteCart(cart);
	}

}
