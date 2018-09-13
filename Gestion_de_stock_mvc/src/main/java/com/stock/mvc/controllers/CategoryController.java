package com.stock.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stock.mvc.entities.Article;
import com.stock.mvc.entities.Category;
import com.stock.mvc.services.ICategoryService;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(value = "/")
	public String category(Model model, HttpServletRequest request, HttpServletResponse response) {
		List<Category> categories = categoryService.selectAll();
		if (categories == null) {
			categories = new ArrayList<Category>();
		}
		model.addAttribute("categories", categories);
		return "category/category";
	}
	
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterCategory(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "category/ajouterCategory";
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrerCategory(Model model, Category category) {
		if (category != null) {
			if (category.getIdCategory() != null) {
				categoryService.update(category);
			} else {
				categoryService.save(category);
			}
		}
		return "redirect:/category/";
	}
	
	@RequestMapping(value = "/modifier/{idCategory}")
	public String modifierCategory(Model model, @PathVariable Long idCategory) {
		if (idCategory != null) {
			Category category = categoryService.getById(idCategory);
			if (category != null) {
				model.addAttribute("category", category);
			}
		}
		return "category/ajouterCategory";
	}
	
	@RequestMapping(value = "/supprimer/{idCategory}")
	@ResponseBody
	public String supprimerCategory(Model model, @PathVariable Long idCategory) {
		if (idCategory != null) {
			Category category = categoryService.getById(idCategory);
			if (category != null) {
				List<Article> articleCat = categoryService.selectAllArticlesByCategory(idCategory);
				if (articleCat.isEmpty() ) {
					categoryService.remove(idCategory);
				} else {
					return "Impossible de supprimer cette categprie, car elle est affectuer des articles";
				}
			}
		}
		return "redirect:/category/";
	}

}
