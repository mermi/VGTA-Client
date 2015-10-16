package tn.esprit.thewalkingdev.gui.delegates;


import java.util.List;

import tn.esprit.thewalkingdev.entites.TypeEvent;
import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.TeamRemote;
import tn.esprit.thewalkingdev.services.contract.TypeEventRemote;

public class TypeEventCrudDelegate {

	private static final String jndi = "vgta/TypeEventCrud!tn.esprit.thewalkingdev.services.contract.TypeEventRemote";

	public static TypeEventRemote getProxy() {

		return (TypeEventRemote) ServicesLocator.getInstance().getProxy(jndi);

	}
					
	
	public static List<TypeEvent> doShowTypeEvent(){
		return getProxy().findAllTypeEvent();
	}
	public static void doAddTypeEvent(TypeEvent typeEvent){
		getProxy().addTypeEvent(typeEvent);
	}
	public static List<String> doShowTypeEventByLabel(){
		return getProxy().findTypeEventBylabel();
	}
}
