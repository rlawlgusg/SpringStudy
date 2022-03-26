package com.sist.exam07;

public class WriteArticleServicelmpl {
	private ArticleDao dao;
	
	public void setDao(ArticleDao dao) {
		this.dao = dao;
	}

	public void insert() {
		dao.insert();
	}
}
