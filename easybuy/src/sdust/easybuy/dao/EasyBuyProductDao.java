package sdust.easybuy.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sdust.easybuy.model.EasyBuyProduct;

public class EasyBuyProductDao extends EasyBuyBaseDao<EasyBuyProduct> {

	//根据商品Id获取一个商品对象。
	public List<EasyBuyProduct> getProductsByEpcId(int epcId) {
		Transaction ts = this.getSession().getTransaction();
		ts.begin();
		List<EasyBuyProduct> products = session
				.createCriteria(EasyBuyProduct.class)
				.createCriteria("easyBuyProductCategory")
				.add(Restrictions.eq("epcId", epcId)).list();
		ts.commit();
		return products;
	}

	//更新一个商品的信息。
	public void update(EasyBuyProduct product) {
		Transaction ts = session.getTransaction();
		ts.begin();
		session.merge(product);
		ts.commit();
	}

	
	//获取所有特价商品。
	public List<EasyBuyProduct> getSpecialProducts(int type) {
		Transaction ts = session.getTransaction();
		List<EasyBuyProduct> products = session
				.createCriteria(EasyBuyProduct.class)
				.add(Restrictions.eq("epSpecial", type)).list();
		return products;
	}
	
	//获取商品列表，并实现分页功能。
	public List<EasyBuyProduct> getProductsListByIdWithPage(int epcId,int pageIndex,int pageSize) {
		Transaction ts = this.getSession().getTransaction();
		ts.begin();
		int start = (pageIndex * pageSize)-pageSize;
		final String hql = "from EasyBuyProduct where easyBuyProductCategory.epcId = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, epcId);
		query.setFirstResult(start);  
		query.setMaxResults(pageSize);  
		ts.commit();
		return (List<EasyBuyProduct>)query.list();  
	}

	//测试
	public static void main(String[] args) {
		List<EasyBuyProduct> products = new EasyBuyProductDao()
				.getSpecialProducts(1);
		System.out.println(products.size());
	}
}