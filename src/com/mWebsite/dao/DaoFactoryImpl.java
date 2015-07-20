package com.mWebsite.dao;

public class DaoFactoryImpl implements DaoFactory {

	@Override
	public ContactDao createContactDao() {
		// TODO Auto-generated method stub
		return new ContactDaoImpl();
	}

	@Override
	public ArticleDao createArticleDao() {
		// TODO Auto-generated method stub
		return new ArticleDaoImpl();
	}
}
