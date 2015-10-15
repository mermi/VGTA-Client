package tn.esprit.thewalkingdev.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javax.swing.JOptionPane;

import tn.esprit.thewalkingdev.entites.Brand;
import tn.esprit.thewalkingdev.entites.Equipment;
import tn.esprit.thewalkingdev.entites.TypeEquipment;
import tn.esprit.thewalkingdev.gui.delegates.EquipmentDelegate;
import tn.esprit.thewalkingdev.services.contract.EquipmentRemote;

public class AfficheEquipmentController implements Initializable,
		ControlledScreen {
	ScreensController ctrl;
	public static String DisplayBrandScreen = "/tn/esprit/thewalkingdev/gui/view/displayBrand.FXML";
	public static String DisplayTypeScreen = "/tn/esprit/thewalkingdev/gui/view/displayTypes.FXML";
	@FXML
	private TableView<Equipment> tableView;
	@FXML
	private TableColumn<Equipment, Integer> idCl;
	@FXML
	private TableColumn<Equipment, Integer> quantityCl;
	@FXML
	private TableColumn<Equipment, Brand> brandCl;
	@FXML
	private TableColumn<Equipment, TypeEquipment> TypeCl;

	@FXML
	private Button delete;
	private int i;
	static EquipmentRemote remote;
	static EquipmentRemote remoteDelete;
	private List<Equipment> listEquiDb;
	private ObservableList<Equipment> listEqui;
	private ObservableList list = FXCollections.observableArrayList();
	@FXML
	private Button addbrandB;
	@FXML
	private Button addEquipmentB;
	@FXML
	private Button manageTypeB;
	@FXML
	private AnchorPane pane;

	// Event Listener on Button[#delete].onAction
	@FXML
	public void deleteEquipment(ActionEvent event) {

		i = tableView.getSelectionModel().getFocusedIndex();
		Equipment equipment = (Equipment) tableView.getSelectionModel()
				.getSelectedItem();

		EquipmentDelegate.deleteEquipment(equipment);
		list.remove(equipment);

		JOptionPane.showMessageDialog(null, "Suppression effectué avec succés");
	}

	// Event Listener on Button[#addbrandB].onAction
	@FXML
	public void addBrand(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				DisplayBrandScreen));
		pane.getChildren().add(node);
	}

	@FXML
	public void manageTypes(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				DisplayTypeScreen));
		pane.getChildren().add(node);
	}
	// Event Listener on Button[#addEquipmentB].onAction
	@FXML
	public void addEquipment(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				"/tn/esprit/thewalkingdev/gui/view/manageEquipment.fxml"));
		pane.getChildren().add(node);
	}

	@Override
	public void setScreenParent(ScreensController screenPage) {
		ctrl = screenPage;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		EquipmentDelegate.displayEquis().stream().forEach((equipment) -> {
			list.add(equipment);
		});
		;
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		// tableView.setTableMenuButtonVisible(true);
		idCl.setCellValueFactory(new PropertyValueFactory<>("id"));
		quantityCl.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		brandCl.setCellValueFactory(new PropertyValueFactory<>("brand"));

		TypeCl.setCellValueFactory(new PropertyValueFactory<>("typeEquipment"));
		tableView.setItems(list);

	}
}
