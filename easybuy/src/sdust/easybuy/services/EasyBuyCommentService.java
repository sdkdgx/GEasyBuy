package sdust.easybuy.services;

import java.util.List;

import sdust.easybuy.dao.EasyBuyCommentDao;
import sdust.easybuy.model.EasyBuyComment;

public class EasyBuyCommentService {
	
	//获取EasyBuyCommentDao对象。
	private EasyBuyCommentDao easyBuyCommentDao = new EasyBuyCommentDao();
	
	//获取所有留言。
	public List<EasyBuyComment> getAllComments(){
		return easyBuyCommentDao.getAll();
	}
	
	//根据Id获取某一条留言的信息。
	public EasyBuyComment getCommentById(int id){
		return easyBuyCommentDao.getById(id);
	}
	
	//删除一条留言。
	public void deleteByComment(EasyBuyComment comment){
		easyBuyCommentDao.delete(comment);
	}
	
	//更新一条留言。
	public void update(EasyBuyComment comment){
		easyBuyCommentDao.update(comment);
	}
	
	//新增并保存一条留言。
	public void save(EasyBuyComment comment){
		easyBuyCommentDao.saveOrUpdate(comment);
	}

}
