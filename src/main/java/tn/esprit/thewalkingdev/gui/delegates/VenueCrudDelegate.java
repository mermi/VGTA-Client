package tn.esprit.thewalkingdev.gui.delegates;

import java.util.List;

import tn.esprit.thewalkingdev.entites.Venue;
import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.VenueRemote;

public class VenueCrudDelegate {

	static VenueRemote venueServices = (VenueRemote) ServicesLocator
			.getInstance()
			.getProxy(
					"vgta/VenueCrud!tn.esprit.thewalkingdev.services.contract.VenueRemote");
	public static List<String> doShowVenueByLabel(){
		return venueServices.findAllLabelVenue();
	}
	public static void doAddVenue(Venue venue){
		venueServices.addVenue(venue);
	}
}
