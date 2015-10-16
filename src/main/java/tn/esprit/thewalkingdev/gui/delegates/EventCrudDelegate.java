package tn.esprit.thewalkingdev.gui.delegates;

import java.util.List;

import tn.esprit.thewalkingdev.entites.Event;
import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.AdministratorRemote;
import tn.esprit.thewalkingdev.services.contract.EventRemote;

public class EventCrudDelegate {

//	private static AdministratorRemote remote;
	private static final String jndi="vgta/EventCrud!tn.esprit.thewalkingdev.services.contract.EventRemote";
	public static EventRemote getProxy( ){			 

		return (EventRemote) ServicesLocator.getInstance().getProxy(jndi);
		
	}
					
	
	public static void addEvent(Event event){
		getProxy().addEvent(event);
	}
	public static void doEditEvent (Event event){
		getProxy().updateEvent(event);
	}
	public static void doDeleteEvent(int id){
		getProxy().deleteEvent(id);
	}
	public static List<Event> doFindAllEvent(){
		return getProxy().findAllEvents();
	}
}
