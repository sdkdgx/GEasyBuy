package sdust.easybuy.services;

import java.util.List;

import sdust.easybuy.dao.EasyBuyOrderDao;
import sdust.easybuy.model.EasyBuyOrder;

public class EasyBuyOrderDetail {
	
	EasyBuyOrderDao dao = new EasyBuyOrderDao();
	
	public List<EasyBuyOrder> getAllOrderDetails(){
		return dao.getAll();
	}

}
