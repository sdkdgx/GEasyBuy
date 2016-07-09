package sdust.easybuy.services;

import java.util.List;

import sdust.easybuy.dao.EasyBuyProductCategoryDao;
import sdust.easybuy.model.EasyBuyProductCategory;

public class EasyBuyProductCategoryService {
	
	private EasyBuyProductCategoryDao dao = new EasyBuyProductCategoryDao();
	
	public List<EasyBuyProductCategory> getAllProductCategories(){
		return dao.getAll();
	}

}
