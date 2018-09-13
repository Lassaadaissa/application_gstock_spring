package com.stock.mvc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommandeFournisseur implements Serializable{
	
	@Id
	@GeneratedValue
	private Long idLigneCdeFrs;
	
	@ManyToOne
	@JoinColumn(name="idFournisseur")
	private Article Fournisseur;
	
	
	@ManyToOne
	@JoinColumn(name="idCommandeFournisseur")

	private CommandeClient commandeFournisseur;


	public Long getIdLigneCdeFrs() {
		return idLigneCdeFrs;
	}


	public void setIdLigneCdeFrs(Long idLigneCdeFrs) {
		this.idLigneCdeFrs = idLigneCdeFrs;
	}


	public Article getFournisseur() {
		return Fournisseur;
	}


	public void setFournisseur(Article fournisseur) {
		Fournisseur = fournisseur;
	}


	public CommandeClient getCommandeFournisseur() {
		return commandeFournisseur;
	}


	public void setCommandeFournisseur(CommandeClient commandeFournisseur) {
		this.commandeFournisseur = commandeFournisseur;
	}


	
	
}
