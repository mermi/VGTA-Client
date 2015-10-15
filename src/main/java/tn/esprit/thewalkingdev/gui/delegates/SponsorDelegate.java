package tn.esprit.thewalkingdev.gui.delegates;

import java.util.List;

import tn.esprit.thewalkingdev.entites.Sponsor;
import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.SponsorRemote;

public class SponsorDelegate {
	static SponsorRemote  sponsorService = (SponsorRemote) ServicesLocator
			.getInstance()
			.getProxy(
					"vgta/SponsorCrud!tn.esprit.thewalkingdev.services.contract.SponsorRemote");
	
	public static void addSponsor(Sponsor sponsor){
		sponsorService.addSponsor(sponsor);
	}
	public static void deleteSponsor(Sponsor sponsor){
		sponsorService.deleteSponsor(sponsor);
	}
	public static List<Sponsor> displaySponsor(){
		return sponsorService.findAllSponsors();
	}
	public static void updateSponsor(Sponsor sponsor){
		sponsorService.updateSponsor(sponsor);
	}
	public static Sponsor findSponsorById(Integer idSponsor){
		return sponsorService.findSponsorById(idSponsor);
	}
	
}
