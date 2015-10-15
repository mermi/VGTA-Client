package tn.esprit.thewalkingdev.gui.controller;

import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.print.DocFlavor.STRING;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import tn.esprit.thewalkingdev.entites.Team;
import tn.esprit.thewalkingdev.entites.Trophy;
import tn.esprit.thewalkingdev.entites.TypeEvent;
import tn.esprit.thewalkingdev.entites.Venue;
import tn.esprit.thewalkingdev.gui.delegates.EventCrudDelegate;
import tn.esprit.thewalkingdev.gui.delegates.TypeEventCrudDelegate;
import tn.esprit.thewalkingdev.gui.delegates.VenueCrudDelegate;

public class AddEventController1 implements Initializable, ControlledScreen {
	@FXML
	private Button button;
	@FXML
	private ComboBox<Team> ownerCB;
	@FXML
	private ChoiceBox<Boolean> streamingCB;
	@FXML
	private ChoiceBox<Boolean> tournamentCB;
	@FXML
	private ComboBox<String> typeCB;
	@FXML
	private ComboBox<String> venueCB;
	@FXML
	private ComboBox<Trophy> trophyCB;

	ScreensController ctr;
	ObservableList<String> listTypeEvent;
	private ObservableList<String> listVenue;
	private ObservableList<String> listOwner;
	private ObservableList<Boolean> listbool;
	private List<Boolean> listB;
	private ObservableList<String> listTrophy;
	private List<String> listTrophyBD;

	@FXML
	private ObservableList<Boolean> streaming = FXCollections
			.observableArrayList(false, true);
	@FXML
	private ObservableList<Boolean> tournament = FXCollections
			.observableArrayList(false, true);
	@FXML
	private DatePicker dateEvent;
	@FXML
	private TextField numberOfReservation;
	@FXML
	private ComboBox<String> trophiesB;
	@FXML
	private ComboBox<String> venueB;
	@FXML
	private Button addTypeEvent;


	// Event Listener on Button[#button].onAction
	@FXML
	public void button(ActionEvent event) {
		//EventCrudDelegate.addEvent(null);
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

		venueB.setItems(listVenue);

	}

	@Override
	public void setScreenParent(ScreensController screenPage) {
		ctr = screenPage;

	}
}
