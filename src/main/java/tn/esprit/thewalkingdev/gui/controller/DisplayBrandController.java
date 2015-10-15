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
import javafx.scene.layout.AnchorPane;

import javax.swing.JOptionPane;

import tn.esprit.thewalkingdev.entites.Brand;
import tn.esprit.thewalkingdev.gui.delegates.BrandDelegate;
import tn.esprit.thewalkingdev.services.contract.BrandRemote;

public class DisplayBrandController implements Initializable, ControlledScreen {
	ScreensController ctrl;
	@FXML
	private AnchorPane pane;
	@FXML
	private Button search;
	@FXML
	private TableView<Brand> tableView;
	@FXML
	private TableColumn<Brand, Integer> idCl;
	@FXML
	private TableColumn<Brand, String> brandCl;
	@FXML
	private Button delete;
	@FXML
	private TextField nameTF;
	@FXML
	private Button addB;
	@FXML
	private Button back;
	@FXML
	private Button update;
	@FXML
	private TextField nameTF1;
	@FXML
	private Button updateB;
	private ObservableList<Brand> listBrand;
	private ObservableList list = FXCollections.observableArrayList();
	private int i;
	static BrandRemote remoteFind;
	private Brand brand2;
	private Integer idBrand;

	// Event Listener on Button[#delete].onAction
	@FXML
	public void deleteBrand(ActionEvent event) {
		i = tableView.getSelectionModel().getFocusedIndex();
		Brand brand = (Brand) tableView.getSelectionModel().getSelectedItem();
		System.out.println(brand);
		try {
			BrandDelegate.deleteBrand(brand);
			list.remove(brand);
			JOptionPane.showMessageDialog(null,
					"Suppression effectué avec succés");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Impossible de supprimer une marque utilisé");
		}
	}

	public void back(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				"/tn/esprit/thewalkingdev/gui/view/afficheEquipment.FXML"));
		pane.getChildren().add(node);

	}
	public void search(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				"/tn/esprit/thewalkingdev/gui/view/searchBrand.FXML"));
		pane.getChildren().add(node);

	}
	// Event Listener on Button[#addB].onAction
	@FXML
	public void add(ActionEvent event) {
		Brand brand = new Brand();
		brand.setLabel(nameTF.getText());
		System.out.println(nameTF.getText());
		BrandDelegate.addBrand(brand);
		list.add(brand);
		JOptionPane.showMessageDialog(null, "Ajout effectué avec succés");
	}

	// Event Listener on Button[#update].onAction
	@FXML
	public void updateBrandFromTable(ActionEvent event) {
		i = tableView.getSelectionModel().getFocusedIndex();
		brand2 = (Brand) tableView.getSelectionModel().getSelectedItem();
		nameTF1.setText(brand2.getLabel());
		idBrand = brand2.getIdMarque();
		list.remove(brand2);

	}

	// Event Listener on Button[#updateB].onAction
	@FXML
	public void update(ActionEvent event) {
		i = tableView.getSelectionModel().getFocusedIndex();

		String label = (String) nameTF1.getText();
		brand2.setLabel(label);
		BrandDelegate.updateBrand(brand2);

		JOptionPane.showMessageDialog(null, "Update effectué avec succés");

		list.add(brand2);

		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		// tableView.setTableMenuButtonVisible(true);
		idCl.setCellValueFactory(new PropertyValueFactory<>("id"));
		brandCl.setCellValueFactory(new PropertyValueFactory<>("label"));
		tableView.setItems(list);
		;
	}

	@Override
	public void setScreenParent(ScreensController screenPage) {
		ctrl = screenPage;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		BrandDelegate.displayBrands().stream().forEach((brand) -> {
			list.add(brand);
		});
		;
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		// tableView.setTableMenuButtonVisible(true);
		idCl.setCellValueFactory(new PropertyValueFactory<>("id"));
		brandCl.setCellValueFactory(new PropertyValueFactory<>("label"));
		tableView.setItems(list);
		;

	}
}
