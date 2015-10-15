package tn.esprit.thewalkingdev.gui.delegates;


import java.util.List;

import tn.esprit.thewalkingdev.entites.TypeEvent;
import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.TypeEventRemote;

public class TypeEventCrudDelegate {

	static TypeEventRemote typeEventServices = (TypeEventRemote) ServicesLocator
			.getInstance()
			.getProxy(
					"vgta/TypeEventCrud!tn.esprit.thewalkingdev.services.contract.TypeEventRemote");
	
	public static List<TypeEvent> doShowTypeEvent(){
		return typeEventServices.findAllTypeEvent();
	}
	public static void doAddTypeEvent(TypeEvent typeEvent){
		typeEventServices.addTypeEvent(typeEvent);
	}
	public static List<String> doShowTypeEventByLabel(){
		return typeEventServices.findTypeEventBylabel();
	}
}
