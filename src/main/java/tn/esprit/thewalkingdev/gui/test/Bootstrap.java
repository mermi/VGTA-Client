package tn.esprit.thewalkingdev.gui.test;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.thewalkingdev.entites.TypeEvent;
import tn.esprit.thewalkingdev.entites.Venue;
import tn.esprit.thewalkingdev.gui.delegates.TypeEventCrudDelegate;
import tn.esprit.thewalkingdev.gui.delegates.VenueCrudDelegate;

public class Bootstrap{

	
	public static void main(String[] args) {
		System.out.println("Iam in boot");
	
		//TypeEventCrudDelegate.doAddTypeEvent(new TypeEvent("Hello"));
		//VenueCrudDelegate.doAddVenue(new Venue("Cité des science", "Bizerte"));
		//List<TypeEvent>  listtypeEventDB = new ArrayList<TypeEvent>();
		
		//System.out.println(listtypeEventDB.size());
		//List<String> listTypeEvent = new ArrayList<String>();
		//listTypeEvent.addAll(TypeEventCrudDelegate.doShowTypeEventByLabel());
		//System.out.println(listTypeEvent.size());
		
		List<String> listVenue = new ArrayList<String>();
		listVenue.addAll(VenueCrudDelegate.doShowVenueByLabel());
		System.out.println(listVenue.size());
				
	}

}
