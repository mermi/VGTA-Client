package tn.esprit.thewalkingdev.gui.delegates;

import java.util.List;

import tn.esprit.thewalkingdev.entites.Article;
import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.AdministratorRemote;
import tn.esprit.thewalkingdev.services.contract.ArticleRemote;

public class ArticleCrudDelegate {
	//private static AdministratorRemote remote;
	private static final String jndi="vgta/ArticleCrud!tn.esprit.thewalkingdev.services.contract.ArticleRemote";
	public static ArticleRemote getProxy( )
	{			 

		return (ArticleRemote) ServicesLocator.getInstance().getProxy(jndi);
		
	}
	
	public static void doAddArticle(Article article){
		getProxy().addArticle(article);
	}
	
	public static void doUpdateArticle(Article article){
		getProxy().updateArticle(article);
	}
	
	public static void doDeleteArticle(int id_article){
		getProxy().deleteArticle(id_article);
	}
	
	public static List<Article> dofindAllArticles(){
		return getProxy().findAllArticles();
	}
	
	public static List<Article> doSearchArticle(String keyword){
		return getProxy().searchArticle(keyword);
	}

}
