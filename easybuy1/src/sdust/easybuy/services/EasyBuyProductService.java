package sdust.easybuy.services;

import java.util.List;

import sdust.easybuy.dao.EasyBuyProductDao;
import sdust.easybuy.model.EasyBuyProduct;

public class EasyBuyProductService {
	
	EasyBuyProductDao dao = new EasyBuyProductDao();
	
	public List<EasyBuyProduct> getAllProducts(){
		return dao.getAll();
	}
	
	public EasyBuyProduct getProductById(int id){
		return dao.getById(id);
	}

}
