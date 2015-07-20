/**
 * 
 */
package com.mWebsite.dao;

/**
 * @author lxynox
 *
 */
public interface DaoFactory {
	 ContactDao createContactDao();
	//UserDao createUserDao();
	 ArticleDao createArticleDao();
}
  