package tn.esprit.thewalkingdev.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import tn.esprit.thewalkingdev.entites.Gamer;
import tn.esprit.thewalkingdev.gui.delegates.ManageGamerDelegate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DisplayTeamSponsoringController extends Application implements
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
	private Button addMemberBtnId;
	@FXML
	private Button updateNumberId;
	@FXML
	private Button deleteMemberBtnId;
	// @FXML
	// private TextField numberMax;
	@FXML
	TableView<Gamer> table = new TableView<Gamer>();
	List<Gamer> listGamer = ManageGamerDelegate.dofindAllGamers();;

	private final ObservableList<Gamer> data = FXCollections
			.observableArrayList();

	// Event Listener on Button[#addMemberBtnId].onAction
	@FXML
	public void AddMemberBtnAction(ActionEvent event) {

		try {
			Parent sponsoring = FXMLLoader
					.load(getClass()
							.getResource(
									"/tn/esprit/thewalkingdev/gui/view/AddMemberInSponsoring.fxml"));
			Scene scene = new Scene(sponsoring);
			Stage ad = (Stage) ((Node) event.getSource()).getScene()
					.getWindow();
			ad.setScene(scene);
			ad.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Event Listener on Button[#updateNumberId].onAction
	@FXML
	public void updateNumberBtnAction(ActionEvent event) {
		// Team t = new Team();
		// t.setMax_members(Integer.parseInt(numberMax.getText().toString()));
		// t.setId_team(1);
		// ManageTeamDelegate.doupdateTeam(t);
	}

	// Event Listener on Button[#deleteMemberBtnId].onAction
	@FXML
	public void DeleteMemberBtnAction(ActionEvent event) {
		for (Gamer s : listGamer) {
			if ((s.getEmail().equals(table.getSelectionModel()
					.getSelectedItem().getEmail()))) {
				s.setTeam(null);
				System.out.println(s.getAge());
				ManageGamerDelegate.doupdateGamer(s);
			}
		}
		ObservableList<Gamer> lspers, selectedg;
		lspers = table.getItems();
		selectedg = table.getSelectionModel().getSelectedItems();
		selectedg.forEach(lspers::remove);

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
				if (s.getTeam().getName().equals("team sponsoring")) {
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
