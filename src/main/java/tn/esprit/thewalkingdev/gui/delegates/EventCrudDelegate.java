package tn.esprit.thewalkingdev.gui.delegates;

import java.util.List;

import tn.esprit.thewalkingdev.entites.Event;
import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.EventRemote;

public class EventCrudDelegate {

	static EventRemote  eventService = (EventRemote) ServicesLocator
			.getInstance()
			.getProxy(
					"vgta/EventCrud!tn.esprit.thewalkingdev.services.contract.EventRemote");
	
	public static void addEvent(Event event){
		eventService.addEvent(event);
	}
	public static void doEditEvent (Event event){
		eventService.updateEvent(event);
	}
	public static void doDeleteEvent(int id){
		eventService.deleteEvent(id);
	}
	public static List<Event> doFindAllEvent(){
		return eventService.findAllEvents();
	}
}
