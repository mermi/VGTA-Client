package tn.esprit.thewalkingdev.gui.delegates;

import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.TrophyRemote;

public class TrophyCrudDelegate {

	static TrophyRemote trophyServices = (TrophyRemote) ServicesLocator
			.getInstance()
			.getProxy(
					"vgta/TrophyCrud!tn.esprit.thewalkingdev.services.contract.TrophyRemote");
	
}
