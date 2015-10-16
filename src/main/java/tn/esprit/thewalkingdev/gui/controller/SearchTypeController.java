package tn.esprit.thewalkingdev.gui.controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import tn.esprit.thewalkingdev.entites.TypeEquipment;
import tn.esprit.thewalkingdev.gui.delegates.BrandDelegate;
import tn.esprit.thewalkingdev.gui.delegates.TypeEquipmentDelegate;

public class SearchTypeController implements Initializable  {
	@FXML
	private TextField filterField;
	@FXML
	private AnchorPane pane;
	@FXML
	private TableView<TypeEquipment> table;
	@FXML
	private TableColumn<TypeEquipment, Integer> idCl;
	@FXML
	private TableColumn<TypeEquipment, String> typeCl;
	@FXML
	private Button back;
	private ObservableList<TypeEquipment> list = FXCollections.observableArrayList();

	// Event Listener on TextField[#filterField].onKeyReleased
	@FXML
	public void search(KeyEvent event) {
		if (filterField == null) {
			display();

		}
		list.clear();
		String keyword = filterField.getText();
		TypeEquipmentDelegate.search(keyword).stream()
				.forEach((brand) -> list.add(brand));
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		idCl.setCellValueFactory(new PropertyValueFactory<>("id"));
		typeCl.setCellValueFactory(new PropertyValueFactory<>("typeEq"));

		table.setItems(list);
	}
	// Event Listener on Button[#back].onAction
	@FXML
	public void back(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				"/tn/esprit/thewalkingdev/gui/view/displayTypes.FXML"));
		pane.getChildren().add(node);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		display();
		
	}
	public void display() {
		TypeEquipmentDelegate.displayTypeEquipments().stream().forEach(a -> list.add(a));
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		// tableView.setTableMenuButtonVisible(true);
		idCl.setCellValueFactory(new PropertyValueFactory<>("id"));

		typeCl.setCellValueFactory(new PropertyValueFactory<>("typeEq"));

		table.setItems(list);

	}
}
