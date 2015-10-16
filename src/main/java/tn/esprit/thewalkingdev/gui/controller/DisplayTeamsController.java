package tn.esprit.thewalkingdev.gui.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class DisplayTeamsController {
	@FXML
	private Button logisticBtn;
	@FXML
	private AnchorPane pane;
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
			pane.getChildren().clear();
			Node node;
			node = (Node) FXMLLoader.load(getClass().getResource(
					"/tn/esprit/thewalkingdev/gui/view/DisplayTeamLogistic.fxml"));
			pane.getChildren().add(node);
		} catch (IOException e) {
			e.printStackTrace();
		}					
			
	}

	// Event Listener on Button[#organisationBtn].onAction
	@FXML
	public void OrganisationBtnAction(ActionEvent event) {
		try {
			pane.getChildren().clear();
			Node node;
			node = (Node) FXMLLoader.load(getClass().getResource(
					"/tn/esprit/thewalkingdev/gui/view/DisplayTeamOrganisation.fxml"));
			pane.getChildren().add(node);
		} catch (IOException e) {
			e.printStackTrace();
									
			

		}
	}

	// Event Listener on Button[#MediaBtn].onAction
	@FXML
	public void mediaBtnAction(ActionEvent event) {
		
			try {
				pane.getChildren().clear();
				Node node;
				node = (Node) FXMLLoader.load(getClass().getResource(
						"/tn/esprit/thewalkingdev/gui/view/DisplayTeamMedia.fxml"));
				pane.getChildren().add(node);
			} catch (IOException e) {
				e.printStackTrace();
										
				

			
			}
					
	}

	// Event Listener on Button[#sponsoringBtn].onAction
	@FXML
	public void SponsoringBtnAction(ActionEvent event) {
		try {
			pane.getChildren().clear();
			Node node;
			node = (Node) FXMLLoader.load(getClass().getResource(
					"/tn/esprit/thewalkingdev/gui/view/DisplayTeamSponsoring.fxml"));
			pane.getChildren().add(node);
		} catch (IOException e) {
			e.printStackTrace();
									
			

		
		}
	}
}
		

