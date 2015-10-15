package tn.esprit.thewalkingdev.gui.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.jboss.sasl.util.UsernamePasswordHashUtil;

import tn.esprit.thewalkingdev.entites.Administrator;
import tn.esprit.thewalkingdev.gui.delegates.AdministratorDelegate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class AddadminController {
	@FXML
	private TextField login;
	@FXML
	private PasswordField password;
	@FXML
	private Button btnlogin;
	@FXML
	private Label message;
	@FXML
	private PasswordField password1;

	// Event Listener on Button[#btnlogin].onAction
	@FXML
	public void loginAction(ActionEvent event) throws IOException {
Administrator administrator = new Administrator();
administrator.setPassword(password.getText());
administrator.setUsername(login.getText());
 if(AdministratorDelegate.dofindBy(login.getText()))
 {
		JOptionPane.showMessageDialog(null, "Error :Username Exist ");
 }else{
		if(password.getText().equals(password1.getText())){
			AdministratorDelegate.doaddAdministrator(administrator);

		Parent page_ajout = FXMLLoader.load(getClass().getResource(
				"/tn/esprit/thewalkingdev/gui/view/AffichageGamer.fxml"));
		Scene scene = new Scene(page_ajout);
		Stage ad = (Stage) (((Node) event.getSource()).getScene()
				.getWindow());
		ad.setScene(scene);
		ad.show();}
		else 		{	JOptionPane.showMessageDialog(null, "Error :Password Invalid ");
		}
	}}
}
