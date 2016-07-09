package sdust.easybuy.services;

import sdust.easybuy.dao.EasyBuyUserDao;
import sdust.easybuy.model.EasyBuyUser;

public class EasyBuyUserService {

	private EasyBuyUserDao easyBuyUserDao = new EasyBuyUserDao();

	public EasyBuyUser login(EasyBuyUser user) {
		EasyBuyUser ebu = easyBuyUserDao.getByUser(user);
		return ebu;
	}
	
	public void registerUser(EasyBuyUser user){
		easyBuyUserDao.saveOrUpdate(user);
	}
}
