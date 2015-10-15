package tn.esprit.thewalkingdev.gui.controller;

import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class addTypeEventController implements Initializable, ControlledScreen {
	ScreensController ctr;
	
	@FXML
	private TextField nameType;
	
	@Override
	public void setScreenParent(ScreensController screenPage) {
		ctr = screenPage;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
