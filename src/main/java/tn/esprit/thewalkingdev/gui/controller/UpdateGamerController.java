package tn.esprit.thewalkingdev.gui.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import tn.esprit.thewalkingdev.entites.Gamer;
import tn.esprit.thewalkingdev.entites.Role;
import tn.esprit.thewalkingdev.gui.delegates.GamerDelegate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UpdateGamerController extends Application implements Initializable {
	@FXML
	private Button add;
	@FXML
	private TextField fnom;
	@FXML
	private TextField fprenom;
	@FXML
	private TextField femail;
	@FXML
	private TextField fnumtel;
	@FXML
	ChoiceBox<String> choixrole;
	@FXML
	private PasswordField fpassword;

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
	private Button reset;
	@FXML
	private Button image;
	@FXML
	private TextField age;
	@FXML
	private Text eage;

	private Gamer gg;
	// Event Listener on Button[#add].onAction
	String Password;

	public void setGg(Gamer gg) {
		femail.setText(gg.getEmail());
		fnom.setText(gg.getFirstName());
		fprenom.setText(gg.getLastName());
		fnumtel.setText(String.valueOf(gg.getNumtel()));
		age.setText(String.valueOf(gg.getAge()));
		this.gg = gg;
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
		if (!gg.getPwd().equals(fpassword.getText())) {
			epasss.setText("two pass word are not equal");
			epasss.setVisible(true);
			fpassword.clear();
			return false;

		}
		return true;
	}

	@FXML
	public void resett() {
		age.clear();
		femail.clear();
		fnom.clear();
		fnumtel.clear();

		fpassword.clear();
		fprenom.clear();
	}

	byte[] bFile;
	File file;

	@FXML
	public void handle(ActionEvent arg0) throws IOException {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"TXT files (*.png)", "*.png");
		FileChooser.ExtensionFilter extFilter1 = new FileChooser.ExtensionFilter(
				"TXT files (*.jpg)", "*.jpg");
		FileChooser.ExtensionFilter extFilte3 = new FileChooser.ExtensionFilter(
				"TXT files (*.png)", "*.gif");
		FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter(
				"TXT files (*.jpg)", "*.*");
		fileChooser.getExtensionFilters().addAll(extFilter1, extFilte3,
				extFilter, extFilter2);
		Stage primaryStage = new Stage();
		file = fileChooser.showOpenDialog(primaryStage);
		FileInputStream fileInputStream = null;

		byte[] bFile = new byte[(int) file.length()];

		// convert file into array of bytes
		fileInputStream = new FileInputStream(file);
		fileInputStream.read(bFile);
		fileInputStream.close();

		System.out.println(bFile.length + "longuer");

	}

	@FXML
	public void ajoutAction(ActionEvent actionEvent) throws IOException {
		Parent page_ajout;

		 
			Gamer gamer = new Gamer();

			if (verify() && verifpassword()) {
				if (file != null) {

					byte[] bFile = new byte[(int) file.length()];
					FileInputStream fileInputStream = null;

					// convert file into array of bytes
					fileInputStream = new FileInputStream(file);
					fileInputStream.read(bFile);
					fileInputStream.close();
					gamer.setId(gg.getId());
					gamer.setImage(bFile);
					gamer.setAge(Integer.parseInt(age.getText()));
					gamer.setEmail(femail.getText());
					gamer.setRole(Role.Gamer);
					gamer.setLastName(fnom.getText());
					gamer.setFirstName(fprenom.getText());
					gamer.setNumtel(Integer.parseInt(fnumtel.getText()));
					if (choixrole.getSelectionModel().getSelectedItem()!=null)
					{
					if (choixrole.getSelectionModel().getSelectedItem()
							.equals("Gamer"))
						gamer.setRole(Role.Gamer);
					if (choixrole.getSelectionModel().getSelectedItem()
							.equals("Active Member"))
						gamer.setRole(Role.ActiveMember);
					if (choixrole.getSelectionModel().getSelectedItem()
							.equals("VIP Member"))
						gamer.setRole(Role.VIP);
					if (choixrole.getSelectionModel().getSelectedItem()
							.equals("AdministativeCouncil"))
						gamer.setRole(Role.AdministativeCouncil);
					if (choixrole.getSelectionModel().getSelectedItem()
							.equals(""))
						gamer.setRole(null);
					}
					gamer.setNumtel(Integer.parseInt(fnumtel.getText()));
					gamer.setPwd(fpassword.getText());
					GamerDelegate.doupdateGamer(gamer);

					page_ajout = FXMLLoader
							.load(getClass()
									.getResource(
											"/tn/esprit/thewalkingdev/gui/view/AffichageGamer.fxml"));
					Scene scene = new Scene(page_ajout);
					Stage ad = (Stage) (((Node) actionEvent.getSource())
							.getScene().getWindow());
					ad.setScene(scene);
					ad.show();

				} else {
					if (choixrole.getSelectionModel().getSelectedItem()!=null)
					{
					gamer.setId(gg.getId());
					gamer.setAge(Integer.parseInt(age.getText()));
					gamer.setEmail(femail.getText());
					gamer.setLastName(fnom.getText());
					gamer.setFirstName(fprenom.getText());
					gamer.setPwd(fpassword.getText());
					if (choixrole.getSelectionModel().getSelectedItem()
							.equals("Gamer"))
						gamer.setRole(Role.Gamer);
					if (choixrole.getSelectionModel().getSelectedItem()
							.equals("Active Member"))
						gamer.setRole(Role.ActiveMember);
					if (choixrole.getSelectionModel().getSelectedItem()
							.equals("VIP Member"))
						gamer.setRole(Role.VIP);
					if (choixrole.getSelectionModel().getSelectedItem()
							.equals("Administative Council"))
						gamer.setRole(Role.AdministativeCouncil);
					if (choixrole.getSelectionModel().getSelectedItem()
							.equals(""))
						gamer.setRole(null);
					GamerDelegate.doupdateGamer(gamer);

					page_ajout = FXMLLoader
							.load(getClass()
									.getResource(
											"/tn/esprit/thewalkingdev/gui/view/AffichageGamer.fxml"));
					Scene scene = new Scene(page_ajout);
					Stage ad = (Stage) (((Node) actionEvent.getSource())
							.getScene().getWindow());
					ad.setScene(scene);
					ad.show();

				}}
			}
	

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choixrole.getItems().addAll("Gamer", "Active Member", "VIP Member",
				"Administative Council");

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

	}
}
