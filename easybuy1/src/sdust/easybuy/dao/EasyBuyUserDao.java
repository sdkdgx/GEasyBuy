package sdust.easybuy.dao;

import java.util.List;
import java.util.Stack;

import org.hibernate.criterion.Restrictions;

import sdust.easybuy.model.EasyBuyUser;

public class EasyBuyUserDao extends EasyBuyBaseDao<EasyBuyUser> {

	public EasyBuyUser getByUsername(String username) {
		EasyBuyUser user = (EasyBuyUser) this.getSession().load(entity,
				username);
		return user;
	}

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

	public static void main(String[] args) {
		
//		EasyBuyUser user = new EasyBuyUser();
//		user.setEuUserName("test");
//		user.setEuPassword("test");
//		user.setEuMobile("123123123");
//		user.setEuStatus(1);
//		EasyBuyUserDao dao = new EasyBuyUserDao();
//		dao.saveOrUpdate(user);
		EasyBuyUser user = new EasyBuyUserDao().getByUser(new EasyBuyUser(
				"admin", "admin"));
		System.out.println(user);

	}

}
