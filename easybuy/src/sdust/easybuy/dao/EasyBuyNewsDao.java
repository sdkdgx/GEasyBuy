package sdust.easybuy.dao;

import org.hibernate.Transaction;

import sdust.easybuy.model.EasyBuyNews;

public class EasyBuyNewsDao extends EasyBuyBaseDao<EasyBuyNews> {
	
	//更新一条新闻。
	public void update(EasyBuyNews news){
		Transaction ts = session.getTransaction();
		ts.begin();
		session.merge(news);
		ts.commit();
	}

}
