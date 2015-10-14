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
	public static List<Event> doFindAll()

	{
		return eventService.findAllEvents();
		
		
	}

}
