package sdust.easybuy.dao;

import org.hibernate.Transaction;

import sdust.easybuy.model.EasyBuyOrder;

public class EasyBuyOrderDao extends EasyBuyBaseDao<EasyBuyOrder> {
	
	//更新一个订单的信息或者状态。
	public void update(EasyBuyOrder order){
		Transaction ts = session.getTransaction();
		ts.begin();
		session.merge(order);
		ts.commit();
	}
	
}
