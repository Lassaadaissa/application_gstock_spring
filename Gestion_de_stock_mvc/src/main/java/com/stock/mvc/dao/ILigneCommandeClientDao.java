package com.stock.mvc.dao;

import java.util.List;

import com.stock.mvc.entities.Category;
import com.stock.mvc.entities.LigneCommandeClient;

public interface ILigneCommandeClientDao extends IGenericDao<LigneCommandeClient>{
	public List<LigneCommandeClient> getByIdCommande(Long idCommandeClient);
}
