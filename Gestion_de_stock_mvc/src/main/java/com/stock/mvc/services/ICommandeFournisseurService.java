package com.stock.mvc.services;

import java.util.List;

import com.stock.mvc.entities.Article;
import com.stock.mvc.entities.CommandeFournisseur;

public interface ICommandeFournisseurService {
	
	public CommandeFournisseur save(CommandeFournisseur entity);
	
	public CommandeFournisseur update(CommandeFournisseur entity);

	public List<CommandeFournisseur> selectAll();

	public List<CommandeFournisseur> selectAll(String sortField, String sort);

	public CommandeFournisseur getById(Long id);

	public void remove(Long id);

	public CommandeFournisseur findOne(String paramName, Object paramValue);

	public CommandeFournisseur findOne(String[] paramNames, Object[] paramValues);

	public int findCountBy(String paramName, String paramValue);

}
