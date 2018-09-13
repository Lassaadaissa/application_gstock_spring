package com.stock.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.dao.IArticleDao;
import com.stock.mvc.dao.IMvtStockDao;
import com.stock.mvc.entities.Article;
import com.stock.mvc.entities.MvtStock;
import com.stock.mvc.services.IArticleService;
import com.stock.mvc.services.IMvtStockService;

@Transactional
public class MvtStockServiceImpl implements IMvtStockService{
	
	private IMvtStockDao dao;
	
	public void setDao(IMvtStockDao dao) {
		this.dao = dao;
	}

	@Override
	public MvtStock save(MvtStock entity) {
		return dao.save(entity);
	}

	@Override
	public MvtStock update(MvtStock entity) {
		return dao.update(entity);
	}

	@Override
	public List<MvtStock> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<MvtStock> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public MvtStock getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public MvtStock findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public MvtStock findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
