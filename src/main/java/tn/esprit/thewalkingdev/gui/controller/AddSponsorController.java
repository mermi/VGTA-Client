package tn.esprit.thewalkingdev.gui.controller;



import javax.naming.Context;

import tn.esprit.thewalkingdev.entites.Sponsor;
import tn.esprit.thewalkingdev.entites.Team;
import tn.esprit.thewalkingdev.gui.delegates.SponsorDelegate;
import tn.esprit.thewalkingdev.services.contract.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;
public class AddSponsorController {
	@FXML
	private Button btAddSponsor;
	@FXML
	private TextField tfnamesponsor;
	@FXML
	private TextField tfnamecontactsponsor;
	@FXML
	private TextField tfemail;
	@FXML
	private TextField tfdatestart;
	@FXML
	private TextField tfdateend;
	@FXML
	private ComboBox<Team> CBTeamSponsor;
	@FXML
	private DatePicker dateStart;
	@FXML
	private DatePicker dateEnd;
	
	static TeamRemote remoteTeam;
	// Event Listener on Button[#btAddSponsor].onAction
	@FXML
	
	static SponsorRemote remote;
	private List<Team> listTeamDb;
	private ObservableList<Team> listTeam;
	
	public void AddSponsor(ActionEvent event) {
		Sponsor Sponsor = new Sponsor();
		Sponsor.setName_sponsor(tfnamesponsor.getText());
		Sponsor.setName_contact_sponsor(tfnamecontactsponsor.getText());
		Sponsor.setEmail(tfemail.getText());
	
		Team teamSponsor =new Team();
		teamSponsor.setId_team(4);
		Sponsor.setTeamSponsor(teamSponsor);
	
		LocalDate localDateS = dateStart.getValue();
		Instant instantS = Instant.from(localDateS.atStartOfDay(ZoneId.systemDefault()));
		Date dts = Date.from(instantS);
   
		LocalDate localDateE = dateEnd.getValue();
		Instant instantE = Instant.from(localDateE.atStartOfDay(ZoneId.systemDefault()));
		Date dtE = Date.from(instantE);
		
		
	Sponsor.setDateStart(dts);
	Sponsor.setDateEnd(dtE);
	
	  if (tfnamesponsor.getText().isEmpty() || tfnamecontactsponsor.getText().isEmpty() ) {
          JOptionPane.showMessageDialog(null, "fill in all fields");
      } else if (tfemail.getText().contains("@") == false) {
        JOptionPane.showMessageDialog(null, "check your address mail");}
	else {
	SponsorDelegate.addSponsor(Sponsor);
	JOptionPane.showMessageDialog(null, "Adding completed successfully");}
	}

}
