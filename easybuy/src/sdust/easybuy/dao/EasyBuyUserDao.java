package sdust.easybuy.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sdust.easybuy.model.EasyBuyComment;
import sdust.easybuy.model.EasyBuyUser;

public class EasyBuyUserDao extends EasyBuyBaseDao<EasyBuyUser> {

	//接受一个User，根据这个User的用户名和密码在数据库中查询符合的记录。若相应记录存在，则返回这个对象。否则，返回Null。
	public EasyBuyUser getByUser(EasyBuyUser user) {
		List<EasyBuyUser> users = (List<EasyBuyUser>) session
				.createCriteria(EasyBuyUser.class)
				.add(Restrictions.eq("euUserName", user.getEuUserName()))
				.add(Restrictions.eq("euPassword", user.getEuPassword()))
				.list();
		if (users != null && users.size() > 0) {
			EasyBuyUser eu = users.get(0);
			return eu;
		}
		return null;
	}
	
	//更新一个用户的信息。
	public void updateUserByUser(EasyBuyUser user){
		Transaction tx = session.getTransaction();
		tx.begin();
		session.merge(user);
		tx.commit();
		sessionFactory.openSession();
	}

	//测试。
	public static void main(String[] args) {
		
		EasyBuyUser user = new EasyBuyUserDao().getByUser(new EasyBuyUser(
				"guest", "guest"));
		Set<EasyBuyComment> ebcs = user.getEasyBuyComments();
		
		for(EasyBuyComment c : ebcs){
			System.out.println(c.getEcContent());
		}

	}

}
