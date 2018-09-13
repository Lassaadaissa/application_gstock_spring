package com.stock.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.dao.IArticleDao;
import com.stock.mvc.dao.ICommandeFournisseurDao;
import com.stock.mvc.entities.Article;
import com.stock.mvc.entities.CommandeFournisseur;
import com.stock.mvc.services.IArticleService;
import com.stock.mvc.services.ICommandeFournisseurService;

@Transactional
public class CommandeFournisseurServiceImpl implements ICommandeFournisseurService{
	
	
	private ICommandeFournisseurDao dao;
	
	public void setDao(ICommandeFournisseurDao dao) {
		this.dao = dao;
	}

	@Override
	public CommandeFournisseur save(CommandeFournisseur entity) {
		return dao.save(entity);
	}

	@Override
	public CommandeFournisseur update(CommandeFournisseur entity) {
		return dao.update(entity);
	}

	@Override
	public List<CommandeFournisseur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<CommandeFournisseur> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public CommandeFournisseur getById(Long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public CommandeFournisseur findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public CommandeFournisseur findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
