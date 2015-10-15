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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.JOptionPane;

import tn.esprit.thewalkingdev.entites.Brand;
import tn.esprit.thewalkingdev.entites.Equipment;
import tn.esprit.thewalkingdev.entites.Team;
import tn.esprit.thewalkingdev.entites.TypeEquipment;
import tn.esprit.thewalkingdev.gui.delegates.BrandDelegate;
import tn.esprit.thewalkingdev.gui.delegates.EquipmentDelegate;
import tn.esprit.thewalkingdev.gui.delegates.TypeEquipmentDelegate;
import tn.esprit.thewalkingdev.services.contract.BrandRemote;
import tn.esprit.thewalkingdev.services.contract.EquipmentRemote;
import tn.esprit.thewalkingdev.services.contract.TypeEquipmentDAORemote;

public class AddEquipmentController implements Initializable, ControlledScreen {
	ScreensController ctr;

	private ObservableList<Brand> listBrand;
	private List<Brand> listBrandDb;
	private ObservableList<TypeEquipment> listType;
	private List<TypeEquipment> listTypeDb;
	@FXML
	private Button add;
	@FXML
	private AnchorPane pane;
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
	private Label team;
	@FXML
	private ComboBox<Brand> brandCB;
	@FXML
	private ComboBox<TypeEquipment> typeCB;


	static EquipmentRemote remote;
	static BrandRemote remoteBrand;
	static TypeEquipmentDAORemote remoteType;

	// Event Listener on Button[#add].onAction
	@FXML
	public void addEquipment(ActionEvent event) {
		Equipment equipment = new Equipment();
		//equipment.setTeamLogistics();
		equipment.setBrand(brandCB.getValue());
		equipment.setQuantity(Integer.parseInt(quantityField.getText()));
		equipment.setTypeEquipment(typeCB.getValue());
		
		EquipmentDelegate.addEquipment(equipment);
		JOptionPane.showMessageDialog(null, "Ajout effectué avec succés");

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		listType = FXCollections.observableArrayList(TypeEquipmentDelegate
				.displayTypeEquipments());

		typeCB.setItems(listType);

		listBrand = FXCollections.observableArrayList(BrandDelegate
				.displayBrands());

		brandCB.setItems(listBrand);

	}

	public void back(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				"afficheEquipment.FXML"));
		pane.getChildren().add(node);

	}

	@Override
	public void setScreenParent(ScreensController screenPage) {
		ctr = screenPage;

	}

}
