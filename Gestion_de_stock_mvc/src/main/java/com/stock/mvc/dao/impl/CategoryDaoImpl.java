package com.stock.mvc.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.stock.mvc.dao.ICategoryDao;
import com.stock.mvc.entities.Article;
import com.stock.mvc.entities.Category;

@SuppressWarnings("unchecked")
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements ICategoryDao{

	@Override
	public List<Article> selectAllArticlesByCategory(Long idCategory) {
		Query query = em.createQuery("select a from " + Article.class.getSimpleName() + " a where a.category.idCategory = :x");
		query.setParameter("x", idCategory);
		return null;
	}

}
