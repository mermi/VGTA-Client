package tn.esprit.thewalkingdev.gui.delegates;

import java.util.List;

import tn.esprit.thewalkingdev.entites.Team;
import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.TeamRemote;

public class TeamCrudDelegate {

	static TeamRemote teamServices = (TeamRemote) ServicesLocator
			.getInstance()
			.getProxy(
					"vgta/TeamCrud!tn.esprit.thewalkingdev.services.contract.TeamRemote");
	
	public static List<String> doShowTeamOrganisation(){
		return teamServices.findAllNameTeamOrganisation();
	}
	public void doAddTeamOrganiser(Team teamOrg){
		teamServices.addTeam(teamOrg);
	}
}
