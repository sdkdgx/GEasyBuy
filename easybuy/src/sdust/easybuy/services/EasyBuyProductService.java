package sdust.easybuy.services;

import java.util.List;

import sdust.easybuy.dao.EasyBuyProductDao;
import sdust.easybuy.model.EasyBuyProduct;

public class EasyBuyProductService {

	// 获取EasyBuyProductDao对象。
	EasyBuyProductDao easyBuyProductDao = new EasyBuyProductDao();

	// 获取所有商品信息。
	public List<EasyBuyProduct> getAllProducts() {
		return easyBuyProductDao.getAll();
	}

	// 根据Id获取一个商品的信息。
	public EasyBuyProduct getProductById(int id) {
		return easyBuyProductDao.getById(id);
	}

	// 根据商品分类Id获取属于这个商品分类的所有商品。
	public List<EasyBuyProduct> getProductsByEpcId(int epcId) {
		return easyBuyProductDao.getProductsByEpcId(epcId);
	}

	// 删除一个商品信息。
	public void delete(EasyBuyProduct product) {
		easyBuyProductDao.delete(product);
	}

	// 更新一个商品的信息。
	public void update(EasyBuyProduct product) {
		easyBuyProductDao.update(product);
	}

	// 获取优惠类型为Type的所有商品的信息。
	public List<EasyBuyProduct> getSpecialProducts(int type) {
		return easyBuyProductDao.getSpecialProducts(type);
	}

	// 获取商品链表，并完成分页功能。
	public List<EasyBuyProduct> getProductsListByIdWithPage(int epcId,
			int pageIndex, int pageSize) {
		return easyBuyProductDao.getProductsListByIdWithPage(epcId, pageIndex, pageSize);
	}

	// 新增并保存一个商品的信息。
	public void save(EasyBuyProduct product) {
		easyBuyProductDao.saveOrUpdate(product);
	}

	// 根据商品Id获取一个特定的商品。
	public EasyBuyProduct getById(int id) {
		return easyBuyProductDao.getById(id);
	}

}
