package tn.esprit.thewalkingdev.gui.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController implements ControlledScreen {
	ScreensController ctrl;
	@FXML
	private AnchorPane pane;
	@FXML
	private Button viewLog;
	@FXML
	private Button viewLogEvent;
	@FXML
	private Button viewgamerr;
	@FXML
	private Button TeamBtn;
	public static String DisplayEquipmentScreen = "/tn/esprit/thewalkingdev/gui/view/afficheEquipment.FXML";
	public static String DisplayEquipment = "Add Equipment";
	public static String DisplayEventScreen = "/tn/esprit/thewalkingdev/gui/view/AddEvent.fxml";
	public static String DisplayEquipement = "Add Event";
	public static String DisplayTeamsScreen = "/tn/esprit/thewalkingdev/gui/view/DisplayTeams.FXML";
	public static String DisplayTeams = "Display Teams";

	// Event Listener on Button[#viewLog].onAction
	@FXML
	public void viewLogistics(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				DisplayEquipmentScreen));
		pane.getChildren().add(node);
	}

	// Event Listener on Button[#viewEvent].onAction
	@FXML
	public void viewEvent(ActionEvent event) throws IOException{
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				DisplayEventScreen));
		pane.getChildren().add(node);
	}
	@FXML
	public void viewgamer(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				"/tn/esprit/thewalkingdev/gui/view/AffichageGamer.fxml"));
		pane.getChildren().add(node);
	}
	@Override
	public void setScreenParent(ScreensController screenPage) {
		ctrl = screenPage;
	}
	@FXML
	public void deco(ActionEvent actionEvent) {
		try {
			Parent page_acceuil = FXMLLoader.load(getClass().getResource(
					"/tn/esprit/thewalkingdev/gui/view/Login.fxml"));
			Scene scene = new Scene(page_acceuil);
			Stage ad = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
			ad.setScene(scene);
			ad.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Event Listener on Button[#TeamBtn].onAction
		@FXML
		public void TeamBtnAction(ActionEvent event) throws IOException {
			pane.getChildren().clear();
			Node node;
			node = (Node) FXMLLoader.load(getClass().getResource(
					"/tn/esprit/thewalkingdev/gui/view/DisplayTeams.fxml"));
			pane.getChildren().add(node);
		}
}
