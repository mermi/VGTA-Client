package tn.esprit.thewalkingdev.gui.controller;

import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import tn.esprit.thewalkingdev.entites.Event;
import tn.esprit.thewalkingdev.entites.Team;
import tn.esprit.thewalkingdev.entites.Trophy;
import tn.esprit.thewalkingdev.entites.TypeEvent;
import tn.esprit.thewalkingdev.entites.Venue;
import tn.esprit.thewalkingdev.gui.delegates.EventCrudDelegate;
import tn.esprit.thewalkingdev.gui.delegates.TypeEventCrudDelegate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class addEventController implements Initializable, ControlledScreen {
	@FXML
	private Button button;
	@FXML
	private ComboBox<Team> ownerCB;
	@FXML
	private ChoiceBox<Boolean> streamingCB;
	@FXML
	private ChoiceBox<Boolean> tournamentCB;
	@FXML
	private ComboBox<TypeEvent> typeCB;
	@FXML
	private ComboBox<Venue> venueCB;
	@FXML
	private ComboBox<Trophy> trophyCB;

	ScreensController ctr;
	ObservableList<TypeEvent> listTypeEvent;
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
	/*@FXML
	private TextField nameEvent;
	*/
	@FXML
	private ComboBox<String> trophiesB;
	@FXML
	private ComboBox<String> venueB;
	@FXML
	private Button addTypeEvent;
	@FXML 
	private Button addVenue;

	// Event Listener on Button[#button].onAction
	@FXML
	public void button(ActionEvent event) {
		
		//System.out.println(nameEvent.getText().toString());
		//EventCrudDelegate.addEvent(nameEvent.getText());
	}
	@FXML
	public void addTypeEvent(ActionEvent event){
		try {
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/tn/esprit/thewalkingdev/gui/view/AddTypeEvent.fxml"));
        
			loader.load();
			Parent P = loader.getRoot();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(P));
	        stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	@FXML
	public void addVenue(ActionEvent event){
		try {
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/tn/esprit/thewalkingdev/gui/view/AddVenue.fxml"));
        
			loader.load();
			Parent P = loader.getRoot();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(P));
	        stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listTypeEvent = FXCollections.observableList(TypeEventCrudDelegate
				.doShowTypeEvent());
		System.out.println(listTypeEvent.size());
		typeCB.setItems(listTypeEvent);
		/*listVenue = FXCollections.observableArrayList(VenueCrudDelegate
				.doShowVenue());

		venueB.setItems(listVenue);*/

	}

	@Override
	public void setScreenParent(ScreensController screenPage) {
		ctr = screenPage;

	}
}
