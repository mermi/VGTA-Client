package tn.esprit.thewalkingdev.gui.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainController implements ControlledScreen {
	ScreensController ctrl;
	@FXML
	private AnchorPane pane;
	@FXML
	private Button viewLog;
	@FXML
	private Button viewgamerr;
	public static String DisplayEquipmentScreen = "/tn/esprit/thewalkingdev/gui/view/afficheEquipment.FXML";
	public static String DisplayEquipment = "Add Equipment";

	// Event Listener on Button[#viewLog].onAction
	@FXML
	public void viewLogistics(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				DisplayEquipmentScreen));
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
}
