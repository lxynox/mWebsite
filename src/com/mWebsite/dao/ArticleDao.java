/**
 * 
 */
package com.mWebsite.dao;

import java.util.List;

import com.mWebsite.bean.Article;

/**
 * @author lxynox
 * @date Jul, 18, 2015
 */
public interface ArticleDao {

	// execute query
	Article getArticle(int id);
	/**
	 * 
	 * @return
	 */
	List<Article> getArticles();
	
	// execute update	
	boolean removeArticle(int id);
	/**
	 * 
	 * @param article
	 * @return
	 */
	boolean addArticle(Article article);
	
}
