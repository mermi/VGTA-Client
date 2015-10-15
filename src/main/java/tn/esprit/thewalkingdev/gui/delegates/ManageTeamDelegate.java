package tn.esprit.thewalkingdev.gui.delegates;

import java.util.List;

import tn.esprit.thewalkingdev.entites.Team;
import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.TeamRemote;

public class ManageTeamDelegate {
	private static TeamRemote remote;
	private static final String jndi = "vgta/teamCrud!tn.esprit.thewalkingdev.services.contract.teamRemote";

	public static TeamRemote getProxy() {

		return (TeamRemote) ServicesLocator.getInstance().getProxy(jndi);

	}

	public static Boolean doaddTeam(Team team) {
		return getProxy().addTeam(team);

	}

	public static Boolean doupdateTeam(Team team) {
		return getProxy().updateTeam(team);
	}

	public static Boolean dodeleteteam(Team team) {
		return getProxy().deleteTeam(team);
	}

	public static Team dofindteamById(Integer idteam) {
		return getProxy().findTeamById(idteam);
	}

	public static List<Team> dofindAllteams() {
		return getProxy().findAllTeams();
	}

}
