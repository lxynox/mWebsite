/**
 * 
 */
package com.mWebsite.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mWebsite.bean.Article;


/**
 * @author lxynox
 *
 */
public class ArticleDaoImpl implements ArticleDao {
	
	SqlConnector connector = SqlConnector.getInstance();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test getArticles()
		List<Article> articleList = new ArticleDaoImpl().getArticles();
		for (Article article: articleList) {
			System.out.println (article);
		}
	}

	@Override
	public Article getArticle(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> getArticles() {
		List<Map<String, ?>> articleMapList = connector.getAllArticleStringContainer();
		
		List<Article> articleList = new ArrayList<Article>();
		for (Map<String, ?> articleMap: articleMapList) {
			String title = (String) articleMap.get("title");
			String tag = (String) articleMap.get("tag");
			String paragraph = (String) articleMap.get("paragraph");
			int id = (int) articleMap.get("id");
			Timestamp timestamp = (Timestamp) articleMap.get("time");
			
			Article article = new Article (id, title, tag, paragraph, timestamp);
			articleList.add (article);
		}
		System.out.println (articleList);
		return articleList;
	}

	@Override
	public boolean removeArticle(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addArticle(Article article) {
		String responseCode = connector.insertArticle(article);
		if (responseCode.equals("")) return true;
		// TODO: else if the responseCode.length() > 0 differentiate different cases  
		return false;
	}

}
