package sdust.easybuy.controllers;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sdust.easybuy.model.EasyBuyComment;
import sdust.easybuy.model.EasyBuyNews;
import sdust.easybuy.model.EasyBuyProductCategory;
import sdust.easybuy.model.EasyBuyUser;
import sdust.easybuy.services.EasyBuyCommentService;
import sdust.easybuy.services.EasyBuyNewsService;
import sdust.easybuy.services.EasyBuyProductCategoryService;

@Controller
@RequestMapping("/comment")
public class EasyBuyCommentController {

	// 获取Service对象。
	EasyBuyCommentService commentService = new EasyBuyCommentService();
	EasyBuyNewsService newsService = new EasyBuyNewsService();

	// 点击某条留言的连接后，打开新闻详情页面查看新闻的详细信息。
	@RequestMapping("/getCommentDetail/{ecId}")
	public ModelAndView getCommentDetail(@PathVariable("ecId") int id) {
		EasyBuyComment comment = commentService.getCommentById(id);
		ModelAndView mav = new ModelAndView();
		List<EasyBuyNews> newses = newsService.getTopNewses();
		List<EasyBuyComment> comments = commentService.getAllComments();
		mav.setViewName("comment-view");
		mav.addObject("comment", comment);
		mav.addObject("newses", newses);
		mav.addObject("comments", comments);
		return mav;
	}

	// 进入后台管理系统的的留言管理页面。
	@RequestMapping("/enterCommentManage")
	public ModelAndView enterCommentManage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manage/comment");
		List<EasyBuyComment> comments = commentService.getAllComments();
		for (EasyBuyComment comment : comments) {
			System.out.println(comment.getEcContent());
		}
		mav.addObject("comments", comments);
		return mav;
	}

	// 进入留言管理新增页面。
	@RequestMapping("/enterCommentCreate")
	public ModelAndView enterCommentCreate() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manage/comment-add");
		return mav;
	}

	// 进入留言修改页面。
	@RequestMapping("/enterCommentModify/{id}")
	public ModelAndView enterCommentsModify(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manage/comment-modify");
		EasyBuyComment comment = commentService.getCommentById(id);
		mav.addObject("comment", comment);
		return mav;
	}

	// 进入留言删除，并执行删除操作，返回留言管理页面。
	@RequestMapping("/enterCommentDelete/{id}")
	public ModelAndView enterCommentDelete(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/comment/enterCommentManage");
		EasyBuyComment comment = commentService.getCommentById(id);
		commentService.deleteByComment(comment);
		return mav;
	}

	// 从留言修改页面获取信息，处理并更新留言信息。
	@RequestMapping("/commentUpdate")
	public ModelAndView newsUpdate(EasyBuyComment comment) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/comment/enterCommentManage");
		EasyBuyComment ebc = commentService.getCommentById(comment.getEcId());
		ebc.setEcReply(comment.getEcReply());
		ebc.setEcReplyTime(new Timestamp(System.currentTimeMillis()));
		commentService.update(ebc);
		return mav;
	}

	// 点击留言后，进入留言界面。
	@RequestMapping("/enterComment")
	public ModelAndView enterComment() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("comment");
		List<EasyBuyProductCategory> ebpcs = new EasyBuyProductCategoryService()
				.getAllProductCategories();
		List<EasyBuyComment> comments = new EasyBuyCommentService()
				.getAllComments();
		mav.addObject("comments", comments);
		mav.addObject("productCategories", ebpcs);
		return mav;
	}

	// 进入新增留言界面。
	@RequestMapping("/commentCreate")
	public ModelAndView commentCreate(HttpSession session,
			EasyBuyComment comment) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/comment/enterComment");
		EasyBuyUser user = (EasyBuyUser) session.getAttribute("user");
		comment.setEasyBuyUser(user);
		comment.setEcCreateTime(new Timestamp(System.currentTimeMillis()));
		commentService.save(comment);
		return mav;
	}

}
