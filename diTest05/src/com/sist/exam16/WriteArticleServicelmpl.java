package com.sist.exam16;

public class WriteArticleServicelmpl {
	private ArticleDao dao;
	
	

	public WriteArticleServicelmpl(ArticleDao dao) {
		super();
		this.dao = dao;
	}



	public void insert() {
		dao.insert();
	}
}
