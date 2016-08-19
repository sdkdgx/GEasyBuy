package sdust.easybuy.services;

import java.util.List;

import sdust.easybuy.dao.EasyBuyUserDao;
import sdust.easybuy.model.EasyBuyUser;

public class EasyBuyUserService {

	//获取EasyBuyUserDao对象。
	private EasyBuyUserDao easyBuyUserDao = new EasyBuyUserDao();

	//用户登录。
	public EasyBuyUser login(EasyBuyUser easyBuyUser) {
		EasyBuyUser ebu = easyBuyUserDao.getByUser(easyBuyUser);
		return ebu;
	}
	
	//用户注册。
	public void registerUser(EasyBuyUser easyBuyUser){
		easyBuyUserDao.saveOrUpdate(easyBuyUser);
	}
	
	//根据传来的用户的Id获取完成的用户信息。
	public EasyBuyUser getUser(EasyBuyUser easyBuyUser){
		return easyBuyUserDao.getById(easyBuyUser.getEuUserId());
	}
	
	//获取所有的用户。
	public List<EasyBuyUser> getAllUser(){
		return easyBuyUserDao.getAll();
	}
	
	//根据UserId获取User对象。
	public EasyBuyUser getUserByUserId(int id){
		return easyBuyUserDao.getById(id);
	}
	
	//更新用户的信息。
	public void updateUser(EasyBuyUser easyBuyUser){
		easyBuyUserDao.updateUserByUser(easyBuyUser);
	}
	
	//保存或者更新用户。
	public void saveOrUpdate(EasyBuyUser easyBuyUser){
		easyBuyUserDao.saveOrUpdate(easyBuyUser);
	}
	
	//测试。
	public static void main(String[] args) {
		EasyBuyUser u = new EasyBuyUser();
		u.setEuUserId(12);
		u.setEuPassword("admin");
		u.setEuUserName("admin");
		System.out.println(new EasyBuyUserService().getUser(u).getEuEmail());
	}
}
