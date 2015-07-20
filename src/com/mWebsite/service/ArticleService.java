/**
 * 
 */
package com.mWebsite.service;

import java.util.List;
import com.mWebsite.bean.Article;
/**
 * @author lxynox
 *
 */
public interface ArticleService extends Service {
	boolean addArticle(Article artilce);
	
	List<Article> displayArticles();
}


