package tn.esprit.thewalkingdev.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import tn.esprit.thewalkingdev.entites.TypeEvent;
import tn.esprit.thewalkingdev.gui.delegates.TypeEventCrudDelegate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class addTypeEventController implements Initializable, ControlledScreen {
	ScreensController ctr;
	
	@FXML
	private TextField labelEvent;
	@FXML
	private Button addTypeEvent;
	
	@Override
	public void setScreenParent(ScreensController screenPage) {
		ctr = screenPage;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	// Event Listener on Button[#addTypeEvent].onAction
		@FXML
		public void addTypeEvent(ActionEvent event) {
			System.out.println(labelEvent.getText().toString());
			
			TypeEventCrudDelegate.doAddTypeEvent(new TypeEvent(labelEvent.getText()));
			JOptionPane.showMessageDialog(null, "Ajout effectué avec succés");
		}

}
