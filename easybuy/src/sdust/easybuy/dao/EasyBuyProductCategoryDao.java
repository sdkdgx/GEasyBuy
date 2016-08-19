package sdust.easybuy.dao;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sdust.easybuy.model.EasyBuyProductCategory;

public class EasyBuyProductCategoryDao extends
		EasyBuyBaseDao<EasyBuyProductCategory> {

	//根据Id删除一个商品分类。
	public void deleteById(int id) {
		Transaction ts = session.getTransaction();
		ts.begin();
		EasyBuyProductCategory productCategory = (EasyBuyProductCategory) session
				.load(EasyBuyProductCategory.class, id);
		session.delete(productCategory);
		ts.commit();
		sessionFactory.openSession();
	}

	//更新一个商品分类的信息。
	public void update(EasyBuyProductCategory ebpc) {
		Transaction ts = session.getTransaction();
		ts.begin();
		session.merge(ebpc);
		ts.commit();
		sessionFactory.openSession();
	}

	//获取主商品分类列表。
	public List<EasyBuyProductCategory> getFirstCategory() {
		Transaction ts = session.getTransaction();
		ts.begin();
		List<EasyBuyProductCategory> ebpcs = session.createCriteria(EasyBuyProductCategory.class)
				.add(Restrictions.eq("epcParentId", 0)).list();
		ts.commit();
		return ebpcs;
	}
	
	//获取次商品分类的列表。
	public List<EasyBuyProductCategory> getSecondCategory() {
		Transaction ts = session.getTransaction();
		ts.begin();
		List<EasyBuyProductCategory> ebpcs = session.createCriteria(EasyBuyProductCategory.class)
				.add(Restrictions.ge("epcParentId", 1)).list();
		ts.commit();
		return ebpcs;
	}

	//测试
	public static void main(String[] args) {
		EasyBuyProductCategoryDao dao = new EasyBuyProductCategoryDao();
		dao.deleteById(18);
	}

}
