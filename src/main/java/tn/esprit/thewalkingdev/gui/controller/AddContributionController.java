package tn.esprit.thewalkingdev.gui.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import tn.esprit.thewalkingdev.entites.Sponsor;
import tn.esprit.thewalkingdev.gui.delegates.SponsorDelegate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class AddContributionController implements Initializable  {
	@FXML
	private ComboBox  cbspon;
	
	private ObservableList<Sponsor> listSponsor;
	//private ObservableList list = FXCollections.observableArrayList();
	private int i;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
}
