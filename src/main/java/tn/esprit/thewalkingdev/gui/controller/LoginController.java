package tn.esprit.thewalkingdev.gui.controller;

 

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

  




import tn.esprit.thewalkingdev.entites.Administrator;
import tn.esprit.thewalkingdev.gui.delegates.AdministratorDelegate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
 
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController implements Initializable{
   @FXML 
private TextField login;
   @FXML 
   private PasswordField password;
   @FXML 
   private Label message;
  @FXML
  private Button btnlogin;
	 
	 @FXML 
	   private void loginAction(ActionEvent actionEvent) throws IOException
	   {
 
		 if(AdministratorDelegate.doauthentifiacation(login.getText(),password.getText())==false)
		 {
				JOptionPane.showMessageDialog(null, "Error :Password Or Username Incorrect");
			 
		 }else{
			Parent page_acceuil = FXMLLoader.load(getClass().getResource(
						"/tn/esprit/thewalkingdev/gui/view/AffichageGamer.fxml"));
				Scene scene = new Scene(page_acceuil);
				Stage ad = (Stage) (((Node) actionEvent.getSource()).getScene()
						.getWindow());
				ad.setScene(scene);
				ad.show();
			 
				 		 }
 
}


	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}
