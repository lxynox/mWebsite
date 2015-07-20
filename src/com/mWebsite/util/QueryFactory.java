/**
 * 
 */
package com.mWebsite.util;

import com.mWebsite.bean.Article;
import com.mWebsite.bean.Contact;

/**
 * @author lxynox
 * @date Jul, 17, 2015
 * @category query producer 
 */
public class QueryFactory {
	/* queries about Contact */
	public static String getContact(int id) {
		return "select * from Contact where id = " + id;
	}
	public static String getAllContact() {
		return "select * from Contact";
	}
	public static String addContact(Contact contact) {
		return "insert into Contact(name, email, message, subject) values ('" + contact.getName() +
				"','" + contact.getEmail() +
				"','" + contact.getMessage() +
				"','" + contact.getSubject() + "')";
	}
	public static String removeContact(int id) {
		return "delete from Contact where id = " + id;
	}
	public static String removeAllContact() {
		return "truncate table Contact";
	}
	
	/* queries about the article */
	public static String getAllArticle() {
		return "select * from Article";
	}
	public static String addArticle(Article article) {
		return "insert into Article(title, tag, paragraph) values ('" + article.getTitle() +
				"','" + article.getTag() +
				"','" + article.getParagraph() + "')";
	}
	/* queries on other tables */
}
