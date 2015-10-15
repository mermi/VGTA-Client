package tn.esprit.thewalkingdev.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import tn.esprit.thewalkingdev.entites.TypeEquipment;
import tn.esprit.thewalkingdev.gui.delegates.BrandDelegate;
import tn.esprit.thewalkingdev.gui.delegates.TypeEquipmentDelegate;
import tn.esprit.thewalkingdev.services.contract.BrandRemote;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class DisplayTypesController implements Initializable, ControlledScreen {
	ScreensController ctrl;
	@FXML
	private AnchorPane pane;
	@FXML
	private Button back;
	@FXML
	private TableView<TypeEquipment> tableView;
	@FXML
	private TableColumn<TypeEquipment, Integer> idCl;
	@FXML
	private TableColumn<TypeEquipment, String> typeCl;
	@FXML
	private Button delete;
	@FXML
	private TextField nameTF;
	@FXML
	private Button addB;
	@FXML
	private Button update;
	@FXML
	private TextField nameTF1;
	@FXML
	private Button updateB;
	private ObservableList<TypeEquipment> listType;
	private ObservableList list = FXCollections.observableArrayList();
	private int i;
	
	private TypeEquipment type2;

	public void back(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				"/tn/esprit/thewalkingdev/gui/view/afficheEquipment.FXML"));
		pane.getChildren().add(node);

	}
	// Event Listener on Button[#delete].onAction
	@FXML
	public void deleteType(ActionEvent event) {
		i = tableView.getSelectionModel().getFocusedIndex();
		TypeEquipment type = (TypeEquipment) tableView.getSelectionModel()
				.getSelectedItem();
		System.out.println(type);
		try {
			TypeEquipmentDelegate.deleteTypeEqui(type);
			list.remove(type);
			JOptionPane.showMessageDialog(null,
					"Suppression effectué avec succés");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Impossible de supprimer un type utilisé");
		}
	}

	// Event Listener on Button[#addB].onAction
	@FXML
	public void add(ActionEvent event) {
		TypeEquipment type = new TypeEquipment();

		type.setTypeEq(nameTF.getText());
		System.out.println(nameTF.getText());
		TypeEquipmentDelegate.addTypeEquipment(type);
		list.add(type);
		JOptionPane.showMessageDialog(null, "Ajout effectué avec succés");
	
	}

	// Event Listener on Button[#update].onAction
	@FXML
	public void updateTypeFromTable(ActionEvent event) {
		i = tableView.getSelectionModel().getFocusedIndex();
		type2 = (TypeEquipment) tableView.getSelectionModel().getSelectedItem();
		nameTF1.setText(type2.getTypeEq());
		list.remove(type2);
	}

	// Event Listener on Button[#updateB].onAction
	@FXML
	public void update(ActionEvent event) {
		i = tableView.getSelectionModel().getFocusedIndex();

		String label = (String) nameTF1.getText();
		type2.setTypeEq(label);
		TypeEquipmentDelegate.updateTypeEq(type2);

		JOptionPane.showMessageDialog(null, "Update effectué avec succés");

		list.add(type2);

		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		// tableView.setTableMenuButtonVisible(true);
		idCl.setCellValueFactory(new PropertyValueFactory<>("id"));
		typeCl.setCellValueFactory(new PropertyValueFactory<>("typeEq"));
		tableView.setItems(list);
		;
	}

	@Override
	public void setScreenParent(ScreensController screenPage) {

		ctrl = screenPage;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TypeEquipmentDelegate.displayTypeEquipments().stream()
				.forEach((type) -> {
					list.add(type);
				});
		;
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		// tableView.setTableMenuButtonVisible(true);
		idCl.setCellValueFactory(new PropertyValueFactory<>("id"));
		typeCl.setCellValueFactory(new PropertyValueFactory<>("typeEq"));
		tableView.setItems(list);
		;
	}
}
