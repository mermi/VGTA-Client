package tn.esprit.thewalkingdev.gui.controller;

import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import tn.esprit.thewalkingdev.entites.Event;
import tn.esprit.thewalkingdev.gui.delegates.EventCrudDelegate;
import tn.esprit.thewalkingdev.gui.delegates.TypeEventCrudDelegate;
import tn.esprit.thewalkingdev.gui.delegates.VenueCrudDelegate;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

public class addEventController implements Initializable, ControlledScreen {
	@FXML
	private Button button;
	@FXML
	private ComboBox<String> ownerCB;
	@FXML
	private ChoiceBox<Boolean> streamingCB;
	@FXML
	private ChoiceBox<Boolean> tournamentCB;
	@FXML
	private ComboBox<String> typeCB;
	@FXML
	private ComboBox<String> venueCB;

	ScreensController ctr;
	ObservableList<String> listTypeEvent;
	private ObservableList<String> listVenue;
	@FXML
	private ChoiceBox<Boolean> streaming;
	@FXML
	private ChoiceBox<Boolean> tournament;
	@FXML
	private DatePicker dateEvent;
	@FXML
	private TextField numberOfReservation;
	@FXML
	private TextField NameEvent;
	
	@FXML
	private Button addTypeEvent;
	@FXML 
	private Button addVenue;

	// Event Listener on Button[#button].onAction
	@FXML
	public void button(ActionEvent event) {
		
	
	}
	@FXML
	public void addVenue(ActionEvent event){
		
        
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<String> listTypeEventdb = new ArrayList<String>();
		listTypeEventdb.addAll(TypeEventCrudDelegate.doShowTypeEventByLabel());
		listTypeEvent = FXCollections.observableList(listTypeEventdb);
		System.out.println(listTypeEvent.size());
		typeCB.setItems(listTypeEvent);
		
		List<String> listVenuedb = new ArrayList<String>();
		listVenuedb.addAll(VenueCrudDelegate.doShowVenueByLabel());
		listVenue = FXCollections.observableArrayList(listTypeEventdb);
		System.out.println(listVenue.size());
		venueCB.setItems(listVenue);

	}

	@Override
	public void setScreenParent(ScreensController screenPage) {
		ctr = screenPage;

	}
}
