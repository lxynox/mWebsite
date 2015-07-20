/**
 * 
 */
package com.mWebsite.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mWebsite.bean.Article;
import com.mWebsite.dao.ArticleDao;
import com.mWebsite.dao.DaoFactory;
import com.mWebsite.dao.DaoFactoryImpl;

/**
 * @author lxynox
 *
 */
public class ArticleServiceImpl extends HttpServlet implements ArticleService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// TODO: Check whether the daoFactory should be instantiated here (not good decoupled from implementation)
	DaoFactory daoFactory = new DaoFactoryImpl();
	ArticleDao articleDao = daoFactory.createArticleDao();
	
	public static final String REQUEST_ADD = "add";
	public static final String REQUEST_DISPLAY = "display";
	
	
	/**
	 * @param args
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		new ArticleServiceImpl().doGet(request, response);
	}
	
	/* (non-Javadoc)
	 * @see com.mWebsite.service.ArticleService#addArticle(com.mWebsite.service.Article)
	 */
	@Override
	public boolean addArticle(Article article) {
		// TODO Auto-generated method stub
		return articleDao.addArticle(article);
	}

	/* (non-Javadoc)
	 * @see com.mWebsite.service.ArticleService#displayArticles()
	 */
	@Override
	public List<Article> displayArticles() {
		// TODO Auto-generated method stub
		return articleDao.getArticles();
	}

	@Override
	protected void doPost (HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException { 
		doGet(request, response);
	}

	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {

		RequestDispatcher rd = null;
		
		if (request.getParameter("requestType").equals(REQUEST_ADD)) { 
			/* respond to add contact request */
//			 pass parameter here
			String title = request.getParameter("title");
			String tag = request.getParameter("tag");
			String paragraph = request.getParameter("paragraph");
			
			Article article = new Article();
			
			article.setTitle(title); 
			article.setTag(tag);
			article.setParagraph(paragraph);
			
			addArticle(article);
			request.setAttribute("article", article);
// TODO: delete contactList from this if block after the test
			List<Article> articleList = displayArticles();
			request.getSession().getServletContext().setAttribute("articleList", articleList);
//System.out.println (request.getContextPath());
			rd = request.getRequestDispatcher("blog.jsp");

		} else if (request.getParameter("requestType").equals(REQUEST_DISPLAY)) {
			/* respond to display contacts request */
			List<Article> articleList = displayArticles();
			request.setAttribute("articleList", articleList);
			
			rd = request.getRequestDispatcher("display.jsp");
		} else {
			// handle some other cases
		}
		//
		rd.forward(request, response);
	}

}
