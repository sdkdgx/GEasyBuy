package sdust.easybuy.services;

import java.util.List;

import sdust.easybuy.dao.EasyBuyOrderDao;
import sdust.easybuy.model.EasyBuyOrder;

public class EasyBuyOrderService {
	
	EasyBuyOrderDao dao = new EasyBuyOrderDao();
	
	public List<EasyBuyOrder> getAllOrders(){
		return dao.getAll();
	}

}
