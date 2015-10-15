package tn.esprit.thewalkingdev.gui.delegates;

import java.util.List;

import tn.esprit.thewalkingdev.entites.Gamer;
import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.GamerRemote;
 
public class GamerDelegate {
	private static GamerRemote remote;
	private static final String jndi="vgta/GamerCrud!tn.esprit.thewalkingdev.services.contract.GamerRemote";
	public static GamerRemote getProxy( )
	{			 

		return (GamerRemote) ServicesLocator.getInstance().getProxy(jndi);
		
	}
	public static Boolean doaddGamer(Gamer gamer)
	{
		return getProxy().addGamer(gamer);
		
	}

	public static Boolean doupdateGamer(Gamer gamer){
		return getProxy().updateGamer(gamer);
	}


	public static Boolean dodeleteGamer(Gamer gamer){
		return getProxy().deleteGamer(gamer);
	}


	public static Gamer dofindGamerById(Integer idGamer){
		return getProxy().findGamerById(idGamer);
	}


	public static List<Gamer> dofindAllGamers(){
		return getProxy().findAllGamers();
	}

	
	public static Gamer doauthentifiacation(String login,String password){
		
		return getProxy().authentifiacation(login, password);
	}
	public static List<Gamer> dosearchemail(String email){
		
		return  getProxy().searchemail(email);
	}
public static List<Gamer> dosearchlastname(String lastname){
		
		return  getProxy().searchlastname(lastname);
	}
public static List<Gamer> dosearchfirstname(String firstname){
	
	return  getProxy().searchfirstname(firstname);
}
 

}
