package tn.esprit.thewalkingdev.gui.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

 import tn.esprit.thewalkingdev.entites.Gamer;
import tn.esprit.thewalkingdev.entites.Role;
import tn.esprit.thewalkingdev.gui.delegates.GamerDelegate;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class addGamerController extends Application {
	@FXML
	private Button image;
	@FXML
	private Button add;
	@FXML
	private TextField age;
	@FXML
	private TextField fnom;
	@FXML
	private TextField fprenom;
	@FXML
	private TextField femail;
	@FXML
	private TextField fnumtel;
	@FXML
	private PasswordField fpassword;
	@FXML
	private PasswordField fpasssword;
	@FXML
	private Button iporIm;
	@FXML
	private Text epass;
	@FXML
	private Text epasss;
	@FXML
	private Text enumm;
	@FXML
	private Text eemail;
	@FXML
	private Text nome;
	@FXML
	private Text enom;
	@FXML
	private Text eage;

	@FXML
	private Button reset;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}
	@FXML
	public void resett() {
		age.clear();
		femail.clear();
		fnom.clear();
		fnumtel.clear();
		fpasssword.clear();
		fpassword.clear();
		fprenom.clear();
	}

	public boolean verify() {
		int position = femail.getText().indexOf("@");
		int position1 = femail.getText().indexOf(".");
System.out.println(position);
		if (position == -1 || position1 == -1) {

			eemail.setVisible(true);

			return false;

		}
		if (age.getText().equals("")) {
			eage.setVisible(true);
		} else {
			eage.setVisible(false);
		}
		if (femail.getText().equals("")) {
			eemail.setVisible(true);
		} else {
			eemail.setVisible(false);
		}
		if (fprenom.getText().equals("")) {
			enom.setVisible(true);
		} else {
			enom.setVisible(false);
		}
		if (fnom.getText().equals("")) {
			nome.setVisible(true);
		} else {
			nome.setVisible(false);
		}
		if (fnumtel.getText().equals("")) {
			enumm.setVisible(true);
		} else {
			enumm.setVisible(false);

		}
		if (fpassword.getText().equals("")) {
			epasss.setVisible(true);
		 
			System.out.println("vokf");
			return false;

		} else {

			epasss.setVisible(false);
		 
		}

		return true;

	}

	public boolean verifpassword() {
		if (!fpasssword.getText().equals(fpassword.getText())) {
			epass.setText("two pass word are not equal");
			epasss.setText("two pass word are not equal");
			epass.setVisible(true);
			epasss.setVisible(true);
			fpasssword.clear();
			fpassword.clear();
			return false;

		}
		return true;
	}
	 byte[] bFile;
	File file;
	@FXML
	public void handle(ActionEvent arg0) throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.png)", "*.png");
        FileChooser.ExtensionFilter extFilter1 = new FileChooser.ExtensionFilter("TXT files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilte3 = new FileChooser.ExtensionFilter("TXT files (*.png)", "*.gif");
        FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("TXT files (*.jpg)", "*.*");
        fileChooser.getExtensionFilters().addAll(extFilter1,extFilte3,extFilter,extFilter2);
        Stage primaryStage = new Stage();
		  file = fileChooser.showOpenDialog(primaryStage);
		  FileInputStream fileInputStream=null;
	        
	        
	        
	        byte[] bFile = new byte[(int) file.length()];
	        
	      
	            //convert file into array of bytes
		    fileInputStream = new FileInputStream(file);
		    fileInputStream.read(bFile);
		    fileInputStream.close();
		       
		     System.out.println(bFile.length+"longuer");
       
    }

	@FXML
	public void ajoutAction(ActionEvent actionEvent) throws IOException {
 
		Parent page_ajout;
	 
			Gamer gamer = new Gamer();

 		  
			if (verify() && verifpassword()) {
				if(file!=null)
			      {
				   byte[] bFile = new byte[(int) file.length()];
					  FileInputStream fileInputStream=null;
				      
			            //convert file into array of bytes
				    fileInputStream = new FileInputStream(file);
				    fileInputStream.read(bFile);
				    fileInputStream.close();
				   
			gamer.setImage(bFile);
 				gamer.setAge(Integer.parseInt(age.getText()));
 				gamer.setRole(Role.Gamer);
				gamer.setEmail(femail.getText());
				gamer.setLastName(fnom.getText());
				gamer.setFirstName(fprenom.getText());
				gamer.setNumtel(Integer.parseInt(fnumtel.getText()));
				gamer.setPwd(fpasssword.getText());
				GamerDelegate.doaddGamer(gamer);

				page_ajout = FXMLLoader.load(getClass().getResource(
						"/tn/esprit/thewalkingdev/gui/view/AffichageGamer.fxml"));
				Scene scene = new Scene(page_ajout);
				Stage ad = (Stage) (((Node) actionEvent.getSource()).getScene()
						.getWindow());
				ad.setScene(scene);
				ad.show();

			}else
				{
				 
 					   
			 
	 				gamer.setAge(Integer.parseInt(age.getText()));
					gamer.setEmail(femail.getText());
					gamer.setLastName(fnom.getText());
					gamer.setFirstName(fprenom.getText());
					gamer.setNumtel(Integer.parseInt(fnumtel.getText()));
					gamer.setPwd(fpasssword.getText());
					GamerDelegate.doaddGamer(gamer);

					page_ajout = FXMLLoader.load(getClass().getResource(
							"/tn/esprit/thewalkingdev/gui/view/AffichageGamer.fxml"));
					Scene scene = new Scene(page_ajout);
					Stage ad = (Stage) (((Node) actionEvent.getSource()).getScene()
							.getWindow());
					ad.setScene(scene);
					ad.show();

				}
				
				}
			 
		 

		

	}}

