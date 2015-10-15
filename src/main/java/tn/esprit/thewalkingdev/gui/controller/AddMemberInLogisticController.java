package tn.esprit.thewalkingdev.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.sound.midi.SysexMessage;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import tn.esprit.thewalkingdev.entites.Gamer;
import tn.esprit.thewalkingdev.entites.Team;
import tn.esprit.thewalkingdev.gui.delegates.ManageGamerDelegate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AddMemberInLogisticController extends Application implements
		Initializable {
	@FXML
	private TableColumn lastNameCol = new TableColumn("Last Name");
	@FXML
	private TableColumn firstNameCol = new TableColumn("First Name");
	@FXML
	private TableColumn roleCol = new TableColumn("Role");
	@FXML
	private TableColumn emailCol = new TableColumn("Email");

	@FXML
	private Button OkBtnID;

	@FXML
	TableView<Gamer> table = new TableView<Gamer>();
	List<Gamer> listGamer = ManageGamerDelegate.dofindAllGamers();;

	private final ObservableList<Gamer> data = FXCollections
			.observableArrayList();

	// Event Listener on Button[#OkBtnID].onAction
	@FXML
	public void OKBtnAction(ActionEvent event) {
		for (Gamer s : listGamer) {
			System.out.println("aaaaaaaaaaaaa");
			if (table.getSelectionModel().getSelectedItem().getEmail()
					.equals(s.getEmail())) {

				Team t = new Team();
				t.setId_team(1);
				s.setTeam(t);
				System.out.println(t);

				ManageGamerDelegate.doupdateGamer(s);

				JOptionPane pane = new JOptionPane(s.getFirstName() + " "
						+ s.getLastName() + "added to team logistic");
				JDialog dialog = pane.createDialog("Information Message");
				dialog.show();
				Object selectedValue = pane.getValue();

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
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {

			firstNameCol
					.setCellValueFactory(new PropertyValueFactory<Gamer, String>(
							"firstName"));

			lastNameCol
					.setCellValueFactory(new PropertyValueFactory<Gamer, String>(
							"lastName"));

			emailCol.setCellValueFactory(new PropertyValueFactory<Gamer, String>(
					"email"));

			roleCol.setCellValueFactory(new PropertyValueFactory<Gamer, String>(
					"role"));

			table.setEditable(true);

			for (Gamer s : listGamer) {

				System.out.println(s.getFirstName());

				if (s.getTeam().getName().equals("team sponsoring"))
					data.add(new Gamer(s.getFirstName(), s.getLastName(), s
							.getEmail(), s.getRole()));

				table.setItems(data);

				if (s.getTeam().getName().equals("team media")) {
					data.add(new Gamer(s.getFirstName(), s.getLastName(), s
							.getEmail(), s.getRole()));

					table.setItems(data);
				}

				if (s.getTeam().getName().equals("team organisation")) {
					data.add(new Gamer(s.getFirstName(), s.getLastName(), s
							.getEmail(), s.getRole()));

					table.setItems(data);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(new Group());
		primaryStage.setTitle("Table View Sample");
		primaryStage.setWidth(450);
		primaryStage.setHeight(550);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
