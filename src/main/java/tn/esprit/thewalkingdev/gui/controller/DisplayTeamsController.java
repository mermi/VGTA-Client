package tn.esprit.thewalkingdev.gui.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class DisplayTeamsController {
	@FXML
	private Button logisticBtn;
	@FXML
	private Button organisationBtn;
	@FXML
	private Button MediaBtn;
	@FXML
	private Button sponsoringBtn;
	@FXML
	private Button btnBach;
	// Event Listener on Button[#logisticBtn].onAction
	@FXML
	public void LogisticBtnAction(ActionEvent event) {
		try {
			Parent pageTeamLogistic = FXMLLoader
					.load(getClass()
							.getResource(
									"/tn/esprit/thewalkingdev/gui/view/DisplayTeamLogistic.fxml"));
			Scene scene = new Scene(pageTeamLogistic);
			Stage ad = (Stage) ((Node) event.getSource()).getScene()
					.getWindow();
			ad.setScene(scene);
			ad.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#organisationBtn].onAction
	@FXML
	public void OrganisationBtnAction(ActionEvent event) {
		try {
			Parent organisation = FXMLLoader
					.load(getClass()
							.getResource(
									"/tn/esprit/thewalkingdev/gui/view/DisplayTeamOrganisation.fxml"));
			Scene scene = new Scene(organisation);
			Stage ad = (Stage) ((Node) event.getSource()).getScene()
					.getWindow();
			ad.setScene(scene);
			ad.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#MediaBtn].onAction
	@FXML
	public void mediaBtnAction(ActionEvent event) {
		try {
			Parent media = FXMLLoader.load(getClass().getResource(
					"/tn/esprit/thewalkingdev/gui/view/DisplayTeamMedia.fxml"));
			Scene scene = new Scene(media);
			Stage ad = (Stage) ((Node) event.getSource()).getScene()
					.getWindow();
			ad.setScene(scene);
			ad.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#sponsoringBtn].onAction
	@FXML
	public void SponsoringBtnAction(ActionEvent event) {
		try {
			Parent sponsoring = FXMLLoader
					.load(getClass()
							.getResource(
									"/tn/esprit/thewalkingdev/gui/view/DisplayTeamSponsoring.fxml"));
			Scene scene = new Scene(sponsoring);
			Stage ad = (Stage) ((Node) event.getSource()).getScene()
					.getWindow();
			ad.setScene(scene);
			ad.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
