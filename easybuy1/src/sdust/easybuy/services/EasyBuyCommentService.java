package sdust.easybuy.services;

import java.util.List;

import sdust.easybuy.dao.EasyBuyCommentDao;
import sdust.easybuy.model.EasyBuyComment;

public class EasyBuyCommentService {
	
	private EasyBuyCommentDao dao = new EasyBuyCommentDao();
	
	public List<EasyBuyComment> getAllComments(){
		return dao.getAll();
	}

}
