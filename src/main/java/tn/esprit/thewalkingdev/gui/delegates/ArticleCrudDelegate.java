package tn.esprit.thewalkingdev.gui.delegates;

import java.util.List;

import tn.esprit.thewalkingdev.entites.Article;
import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.ArticleRemote;

public class ArticleCrudDelegate {

	static ArticleRemote eventService = (ArticleRemote) ServicesLocator
			.getInstance()
			.getProxy(
					"VGTA/ArticleCrud!tn.esprit.thewalkingdev.services.contract.ArticleRemote");
	
	public static void doAddArticle(Article article){
		eventService.addArticle(article);
	}
	
	public static void doUpdateArticle(Article article){
		eventService.updateArticle(article);
	}
	
	public static void doDeleteArticle(int id_article){
		eventService.deleteArticle(id_article);
	}
	
	public static List<Article> dofindAllArticles(){
		return eventService.findAllArticles();
	}
	
	public static List<Article> doSearchArticle(String keyword){
		return eventService.searchArticle(keyword);
	}

}
