package sdust.easybuy.dao;

import java.util.List;

import org.hibernate.Transaction;

import sdust.easybuy.model.EasyBuyComment;

public class EasyBuyCommentDao extends EasyBuyBaseDao<EasyBuyComment> {

	//更新一条留言。
	public void update(EasyBuyComment comment) {
		Transaction ts = session.getTransaction();
		ts.begin();
		session.merge(comment);
		ts.commit();
		sessionFactory.openSession();
	}

	// 测试
	public static void main(String[] args) {
		List<EasyBuyComment> ebcs = new EasyBuyCommentDao().getAll();
		for (EasyBuyComment ebc : ebcs) {
			System.out.println(ebc.getEcContent());
		}
	}

}
