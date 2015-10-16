package tn.esprit.thewalkingdev.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import tn.esprit.thewalkingdev.entites.Brand;
import tn.esprit.thewalkingdev.entites.Equipment;
import tn.esprit.thewalkingdev.entites.Team;
import tn.esprit.thewalkingdev.entites.TypeEquipment;
import tn.esprit.thewalkingdev.gui.delegates.BrandDelegate;
import tn.esprit.thewalkingdev.gui.delegates.EquipmentDelegate;
import tn.esprit.thewalkingdev.gui.delegates.TeamCrudDelegate;
import tn.esprit.thewalkingdev.gui.delegates.TypeEquipmentDelegate;

public class manageEquipmentController implements Initializable,
		ControlledScreen {
	ScreensController ctrl;
	@FXML
	private AnchorPane pane;
	@FXML
	private Button add;
	@FXML
	private Button backB;
	
	@FXML
	private TextField quantityField;
	@FXML
	private Label quantity;
	@FXML
	private Label brand;
	@FXML
	private Label type;
	@FXML
	private ComboBox<Brand> brandCB;
	@FXML
	private ComboBox<TypeEquipment> typeCB;
	@FXML
	private Button update;
	@FXML
	private TableView<Equipment> table;
	@FXML
	private TableColumn<Equipment, Integer> idCl;
	@FXML
	private TableColumn<Equipment, Integer> quantityCl;
	@FXML
	private TableColumn<Equipment, Brand> brandCl;
	@FXML
	private TableColumn<Equipment, TypeEquipment> typeCl;
	@FXML
	private Button updateEqui;
	@FXML
	private Button delete;
	private ObservableList<Equipment> listEqui;
	private ObservableList list = FXCollections.observableArrayList();
	private int i;
	private ObservableList<TypeEquipment> listType;
	private ObservableList<Brand> listBrand;

	private Equipment equi2;

	// Event Listener on Button[#add].onAction
	@FXML
	public void addEquipment(ActionEvent event) {
		Equipment equipment = new Equipment();
		Team t = new Team();
		t.setId_team(1);
		equipment.setTeamLogistics(t);
		equipment.setBrand(brandCB.getValue());
		equipment.setQuantity(Integer.parseInt(quantityField.getText()));
		equipment.setTypeEquipment(typeCB.getValue());
		if (quantityField.getText().isEmpty() || brandCB.getValue()==null || typeCB.getValue()==null
				) {
			JOptionPane.showMessageDialog(null, "Fill in all fields");}
		else{
		EquipmentDelegate.addEquipment(equipment);
		list.add(equipment);
		JOptionPane.showMessageDialog(null, "Ajout effectué avec succés");}
		quantityField.clear();
	}

	// Event Listener on Button[#backB].onAction
	@FXML
	public void back(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				"/tn/esprit/thewalkingdev/gui/view/afficheEquipment.FXML"));
		pane.getChildren().add(node);
	}
	

	// Event Listener on Button[#update].onAction
	@FXML
	public void updateEquipment(ActionEvent event) {
		i = table.getSelectionModel().getFocusedIndex();

		equi2.setQuantity(Integer.parseInt(quantityField.getText()));
		equi2.setBrand(brandCB.getValue());
		equi2.setTypeEquipment(typeCB.getValue());
		EquipmentDelegate.updateEquipment(equi2);

		JOptionPane.showMessageDialog(null, "Update effectué avec succés");

		list.add(equi2);

		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		// tableView.setTableMenuButtonVisible(true);
		idCl.setCellValueFactory(new PropertyValueFactory<>("id"));
		quantityCl.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		brandCl.setCellValueFactory(new PropertyValueFactory<>("brand"));

		typeCl.setCellValueFactory(new PropertyValueFactory<>("typeEquipment"));
		table.setItems(list);
		add.setDisable(false);
		update.setDisable(true);
		quantityField.clear();
	}

	// Event Listener on Button[#updateEqui].onAction
	@FXML
	public void updateFromTable(ActionEvent event) {
		i = table.getSelectionModel().getFocusedIndex();
		equi2 = (Equipment) table.getSelectionModel().getSelectedItem();
		quantityField.setText(Integer.toString(equi2.getQuantity()));
		brandCB.setPromptText(equi2.getBrand().getLabel());
		typeCB.setPromptText(equi2.getTypeEquipment().getTypeEq());
		add.setDisable(true);
		update.setDisable(false);
		list.remove(equi2);
	}

	// Event Listener on Button[#delete].onAction
	@FXML
	public void delete(ActionEvent event) {
		i = table.getSelectionModel().getFocusedIndex();
		Equipment equipment = (Equipment) table.getSelectionModel()
				.getSelectedItem();

		EquipmentDelegate.deleteEquipment(equipment);
		list.remove(equipment);

		JOptionPane.showMessageDialog(null, "Suppression effectué avec succés");
	}

	@Override
	public void setScreenParent(ScreensController screenPage) {
		ctrl = screenPage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listType = FXCollections.observableArrayList(TypeEquipmentDelegate
				.displayTypeEquipments());

		typeCB.setItems(listType);

		listBrand = FXCollections.observableArrayList(BrandDelegate
				.displayBrands());

		brandCB.setItems(listBrand);
		EquipmentDelegate.displayEquis().stream().forEach((equipment) -> {
			list.add(equipment);
		});
		;
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		// tableView.setTableMenuButtonVisible(true);
		idCl.setCellValueFactory(new PropertyValueFactory<>("id"));
		quantityCl.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		brandCl.setCellValueFactory(new PropertyValueFactory<>("brand"));

		typeCl.setCellValueFactory(new PropertyValueFactory<>("typeEquipment"));
		table.setItems(list);
		update.setDisable(true);
	}
}
