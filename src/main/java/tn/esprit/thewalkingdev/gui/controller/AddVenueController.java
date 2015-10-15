package tn.esprit.thewalkingdev.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import tn.esprit.thewalkingdev.entites.Venue;
import tn.esprit.thewalkingdev.gui.delegates.VenueCrudDelegate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddVenueController implements Initializable, ControlledScreen  {
	
	ScreensController ctr;
	
	@FXML
	private TextField labelField;
	@FXML
	private TextField addressField;
	@FXML
	private Button addVenue;
	@Override
	public void setScreenParent(ScreensController screenPage) {
		ctr = screenPage;
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	// Event Listener on Button[#addVenue].onAction
	@FXML
	public void addVenue(ActionEvent event) {
		Venue newVenue = new Venue();
		newVenue.setLabel(labelField.getText().toString());
		newVenue.setAdress(addressField.getText().toString());
		VenueCrudDelegate.doAddVenue(newVenue);
		JOptionPane.showMessageDialog(null, "Ajout effectué avec succés");
	}

}
