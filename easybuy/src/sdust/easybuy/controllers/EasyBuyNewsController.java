package sdust.easybuy.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sdust.easybuy.model.EasyBuyComment;
import sdust.easybuy.model.EasyBuyNews;
import sdust.easybuy.services.EasyBuyCommentService;
import sdust.easybuy.services.EasyBuyNewsService;

@Controller
@RequestMapping("/news")
public class EasyBuyNewsController {

	// 获取Service对象。
	EasyBuyNewsService newsService = new EasyBuyNewsService();
	EasyBuyCommentService commentService = new EasyBuyCommentService();

	// 点击某条新闻的超链接后会打开新闻详情界面。
	@RequestMapping("/getNewsDetail/{enId}")
	public ModelAndView getNewsDetail(@PathVariable("enId") int id) {
		EasyBuyNews news = newsService.getNewsById(id);
		ModelAndView mav = new ModelAndView();
		List<EasyBuyNews> newses = newsService.getTopNewses();
		List<EasyBuyComment> comments = commentService.getAllComments();
		mav.setViewName("news-view");
		mav.addObject("news", news);
		mav.addObject("newses", newses);
		mav.addObject("comments", comments);
		return mav;
	}

	// 进入后台管理系统的新闻管理界面。
	@RequestMapping("/enterNewsManage")
	public ModelAndView enterNewsManage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manage/news");
		List<EasyBuyNews> newses = newsService.getAllNewses();
		mav.addObject("newses", newses);
		return mav;
	}

	// 进入后台管理系统的新闻管理界面，点击新增后进入新增新闻页面。
	@RequestMapping("/enterNewsCreate")
	public ModelAndView enterNewsCreate() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manage/news-add");
		return mav;
	}

	// 进入后台管理系统的新闻管理界面，点击修改后对某条新闻进行修改。
	@RequestMapping("/enterNewsModify/{id}")
	public ModelAndView enterNewsModify(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("manage/news-modify");
		EasyBuyNews news = newsService.getNewsById(id);
		mav.addObject("news", news);
		return mav;
	}

	// 进入后台管理系统的新闻管理界面，点击删除后，对某条新闻进行删除。
	@RequestMapping("/enterNewsDelete/{id}")
	public ModelAndView enterNewsDelete(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/news/enterNewsManage");
		EasyBuyNews news = newsService.getNewsById(id);
		newsService.deleteByNews(news);
		return mav;
	}

	// 接受来自新闻更新页面的信息，并进行更新和保存。
	@RequestMapping("/newsUpdate")
	public ModelAndView newsUpdate(EasyBuyNews news) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/news/enterNewsManage");
		newsService.update(news);
		return mav;
	}

	// 接受来自新闻添加页面的信息，进行处理和保存。
	@RequestMapping("/newsCreate")
	public ModelAndView newsCreate(EasyBuyNews news) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/news/enterNewsManage");
		news.setEnCreateTime(new Date(System.currentTimeMillis()));
		newsService.saveOrUpdate(news);
		return mav;
	}

}
