package sdust.easybuy.services;

import java.util.List;

import sdust.easybuy.dao.EasyBuyOrderDao;
import sdust.easybuy.model.EasyBuyOrder;

public class EasyBuyOrderService {
	
	//获取EasyBuyOrderDao对象。
	EasyBuyOrderDao easyBuyOrderDao = new EasyBuyOrderDao();
	
	//获取所有订单列表。
	public List<EasyBuyOrder> getAllOrders(){
		return easyBuyOrderDao.getAll();
	}
	
	//根据Id获取某个订单的信息。
	public EasyBuyOrder getOrderByOrderId(int id){
		return easyBuyOrderDao.getById(id);
	}
	
	//删除某个订单。
	public void deleteOrderByOrder(EasyBuyOrder easyBuyOrder){
		easyBuyOrderDao.delete(easyBuyOrder);
	}
	
	//更新或者保存某个订单。
	public void saveOrUpdate(EasyBuyOrder easyBuyOrder){
		easyBuyOrderDao.saveOrUpdate(easyBuyOrder);
	}
	
	//更新某个订单的信息。
	public void update(EasyBuyOrder easyBuyOrder){
		easyBuyOrderDao.update(easyBuyOrder);
	}
	
}
