package tn.esprit.thewalkingdev.gui.delegates;

import java.util.List;

import tn.esprit.thewalkingdev.entites.Venue;
import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.TypeEventRemote;
import tn.esprit.thewalkingdev.services.contract.VenueRemote;

public class VenueCrudDelegate {

	private static final String jndi = "vgta/VenueCrud!tn.esprit.thewalkingdev.services.contract.VenueRemote";

	public static VenueRemote getProxy() {

		return (VenueRemote) ServicesLocator.getInstance().getProxy(jndi);

	}
					
	public static List<String> doShowVenueByLabel(){
		return getProxy().findAllLabelVenue();
	}
	public static void doAddVenue(Venue venue){
		getProxy().addVenue(venue);
	}
}
