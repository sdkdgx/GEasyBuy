package sdust.easybuy.services;

import java.util.List;

import sdust.easybuy.dao.EasyBuyProductCategoryDao;
import sdust.easybuy.model.EasyBuyProductCategory;

public class EasyBuyProductCategoryService {

	//获取EasyBuyProductCategoryDao对象。
	private EasyBuyProductCategoryDao easyBuyProductCategoryDao = new EasyBuyProductCategoryDao();

	//获取所有商品分类。
	public List<EasyBuyProductCategory> getAllProductCategories() {
		return easyBuyProductCategoryDao.getAll();
	}

	//更新或者保存一个商品分类。
	public void saveOrUpdate(EasyBuyProductCategory pc) {
		easyBuyProductCategoryDao.saveOrUpdate(pc);
	}

	//删除一个商品分类信息。
	public void deleteByEbpcId(int id) {
		easyBuyProductCategoryDao.deleteById(id);
	}

	//根据Id获取一个商品分类的信息。
	public EasyBuyProductCategory getProductCategoryEbpcById(int id) {
		return easyBuyProductCategoryDao.getById(id);
	}

	//更新一个商品分类的信息。
	public void update(EasyBuyProductCategory ebpc) {
		easyBuyProductCategoryDao.update(ebpc);
	}

	//获取所有父类商品分类的信息。
	public List<EasyBuyProductCategory> getFirstCategory() {
		return easyBuyProductCategoryDao.getFirstCategory();
	}

	//获取所有子类商品分类的信息。
	public List<EasyBuyProductCategory> getSecondCategory() {
		return easyBuyProductCategoryDao.getSecondCategory();
	}

}
