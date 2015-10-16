package tn.esprit.thewalkingdev.gui.delegates;

import java.util.List;

import tn.esprit.thewalkingdev.entites.Sponsor;
import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.SponsorRemote;

public class SponsorDelegate {
	//private static SponsorRemote remote;
	private static final String jndi = "vgta/SponsorCrud!tn.esprit.thewalkingdev.services.contract.SponsorRemote";

	public static SponsorRemote getProxy() {

		return (SponsorRemote) ServicesLocator.getInstance().getProxy(jndi);

	}

	public static void addSponsor(Sponsor sponsor) {
		getProxy().addSponsor(sponsor);
	}

	public static void deleteSponsor(Sponsor sponsor) {
		getProxy().deleteSponsor(sponsor);
	}

	public static List<Sponsor> displaySponsor() {
		return getProxy().findAllSponsors();
	}

	public static void updateSponsor(Sponsor sponsor) {
		getProxy().updateSponsor(sponsor);
	}

	public static Sponsor findSponsorById(Integer idSponsor) {
		return getProxy().findSponsorById(idSponsor);
	}
	public static List<Sponsor> searchSponsor(String keyword) {
		return getProxy().searchSponsor(keyword);
	}

}
