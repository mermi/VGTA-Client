package tn.esprit.thewalkingdev.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

import tn.esprit.thewalkingdev.entites.*;
import tn.esprit.thewalkingdev.gui.delegates.BrandDelegate;

public class AddBrandController implements Initializable, ControlledScreen {
	ScreensController ctr;
	@FXML
	private TextField nameTF;
	@FXML
	private Button addB;
	@FXML
	private Button back;
	

	// Event Listener on Button[#addB].onAction
	@FXML
	public void add(ActionEvent event) {
		Brand brand = new Brand();
		brand.setLabel(nameTF.getText());
		

		
		BrandDelegate.addBrand(brand);
		JOptionPane.showMessageDialog(null, "Ajout effectué avec succés");
	}

	@FXML
	public void back(ActionEvent event) {
		Brand brand = new Brand();
		brand.setLabel(nameTF.getText());
		

		
		BrandDelegate.addBrand(brand);
		JOptionPane.showMessageDialog(null, "Ajout effectué avec succés");
	}
	@Override
	public void setScreenParent(ScreensController screenPage) {
		ctr = screenPage;
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
