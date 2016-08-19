package sdust.easybuy.services;

import java.util.List;
import java.util.Stack;

import sdust.easybuy.dao.EasyBuyNewsDao;
import sdust.easybuy.model.EasyBuyNews;

public class EasyBuyNewsService {
	
	//获取EasyBuyNewsDao对象。
	EasyBuyNewsDao easyBuyNewsDao = new EasyBuyNewsDao();
	
	//按照时间顺序获取所有新闻记录。
	public List<EasyBuyNews> getTopNewses(){
		List<EasyBuyNews> newses = easyBuyNewsDao.getAll();
		List<EasyBuyNews> result = new Stack<EasyBuyNews>();
		for(int i = newses.size() - 1; i >= 0; i--){
			result.add(newses.get(i));
		}
		return result;
	}
	
	//依据Id获取某条新闻记录。
	public EasyBuyNews getNewsById(int id){
		return easyBuyNewsDao.getById(id);
	}
	
	//删除一条新记录。
	public void deleteByNews(EasyBuyNews news){
		easyBuyNewsDao.delete(news);
	}
	
	//获取所有的新闻纪录。
	public List<EasyBuyNews> getAllNewses(){
		return easyBuyNewsDao.getAll();
	}
	
	//更新一条新闻纪录。
	public void update(EasyBuyNews news){
		easyBuyNewsDao.update(news);
	}
	
	//删除一条新闻纪录。
	public void delete(EasyBuyNews news){
		easyBuyNewsDao.delete(news);
	}
	
	//更细或保存一条新闻纪录。
	public void saveOrUpdate(EasyBuyNews news){
		easyBuyNewsDao.saveOrUpdate(news);
	}
	
	//测试。
	public static void main(String[] args) {
		EasyBuyNewsService service = new EasyBuyNewsService();
		List<EasyBuyNews> newss = service.getTopNewses();
		for(EasyBuyNews news : newss){
			System.out.println(news.getEnTitle());
		}
	}

}
