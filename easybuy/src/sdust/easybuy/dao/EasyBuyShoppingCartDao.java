package sdust.easybuy.dao;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sdust.easybuy.model.EasyBuyShoppingCart;

public class EasyBuyShoppingCartDao extends EasyBuyBaseDao<EasyBuyShoppingCart> {

	//根据Id获取一个购物车条目对象。
	public List<EasyBuyShoppingCart> getCartsByUserId(int id) {
		Transaction ts = this.getSession().getTransaction();
		ts.begin();
		List<EasyBuyShoppingCart> carts = session
				.createCriteria(EasyBuyShoppingCart.class)
				.add(Restrictions.eq("easyBuyUser.euUserId", id)).list();
		ts.commit();
		return carts;
	}

	//测试。
	public static void main(String[] args) {
		EasyBuyShoppingCartDao dao = new EasyBuyShoppingCartDao();
		EasyBuyShoppingCart cart = dao.getById(56);
		System.out.println(cart.getEscProductQuantity());
		dao.delete(cart);
	}

}
