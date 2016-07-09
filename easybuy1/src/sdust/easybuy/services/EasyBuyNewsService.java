package sdust.easybuy.services;

import java.util.List;
import java.util.Stack;

import sdust.easybuy.dao.EasyBuyNewsDao;
import sdust.easybuy.model.EasyBuyNews;

public class EasyBuyNewsService {
	
	EasyBuyNewsDao dao = new EasyBuyNewsDao();
	
	public List<EasyBuyNews> getTopNewses(){
		List<EasyBuyNews> newses = dao.getAll();
		List<EasyBuyNews> result = new Stack<EasyBuyNews>();
		for(int i = newses.size() - 1; i >= 0; i--){
			result.add(newses.get(i));
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		EasyBuyNewsService service = new EasyBuyNewsService();
		List<EasyBuyNews> newss = service.getTopNewses();
		for(EasyBuyNews news : newss){
			System.out.println(news.getEnTitle());
		}
	}

}
