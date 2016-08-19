package sdust.easybuy.services;

import java.util.List;

import sdust.easybuy.dao.EasyBuyOrderDetailDao;
import sdust.easybuy.model.EasyBuyOrderDetail;

public class EasyBuyOrderDetailService {
	
	//获取EasyBuyOrderDetailDao对象。
	EasyBuyOrderDetailDao easyBuyOrderDetailDao = new EasyBuyOrderDetailDao();
	
	//获取所有订单条目。
	public List<EasyBuyOrderDetail> getAllOrderDetails(){
		return easyBuyOrderDetailDao.getAll();
	}
	
	//更新或保存某一条订单条目。
	public void saveOrUpdate(EasyBuyOrderDetail easyBuyOrderDetail){
		easyBuyOrderDetailDao.saveOrUpdate(easyBuyOrderDetail);
	}

}
