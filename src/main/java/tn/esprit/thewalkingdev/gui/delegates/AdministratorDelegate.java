package tn.esprit.thewalkingdev.gui.delegates;

import java.util.List;

import tn.esprit.thewalkingdev.entites.Administrator;
import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.AdministratorRemote;
   
public class AdministratorDelegate {
	private static AdministratorRemote remote;
	private static final String jndi="vgta/AdministratorCrud!tn.esprit.thewalkingdev.services.contract.AdministratorRemote";
	public static AdministratorRemote getProxy( )
	{			 

		return (AdministratorRemote) ServicesLocator.getInstance().getProxy(jndi);
		
	}
	public static Boolean doaddAdministrator(Administrator Administrator)
	{
		return getProxy().addAdministrator(Administrator);
		
	}

	public static Boolean doupdateAdministrator(Administrator Administrator){
		return getProxy().updateAdministrator(Administrator);
	}


	public static Boolean dodeleteAdministrator(Administrator Administrator){
		return getProxy().deleteAdministrator(Administrator);
	}


	public static Administrator dofindAdministratorById(Integer idAdministrator){
		return getProxy().findAdministratorById(idAdministrator);
	}


	public static List<Administrator> dofindAllAdministrators(){
		return getProxy().findAllAdministrators();
	}

	
	public static boolean doauthentifiacation(String login,String password){
		
		return getProxy().authentifiacation(login, password);
	}
	 
public static Boolean dofindBy(String login){
		
		return getProxy().findBy(login);
	}

}
