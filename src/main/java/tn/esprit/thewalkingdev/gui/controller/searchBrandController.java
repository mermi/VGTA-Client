package tn.esprit.thewalkingdev.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import tn.esprit.thewalkingdev.entites.Brand;
import tn.esprit.thewalkingdev.gui.delegates.BrandDelegate;


public class searchBrandController implements Initializable {
	@FXML
	private AnchorPane pane;
	@FXML
	private TextField filterField;
	@FXML
	private TableView<Brand> table;
	@FXML
	private TableColumn<Brand, Integer> idCl;

	@FXML
	private TableColumn<Brand, String> brandCl;

	private ObservableList list = FXCollections.observableArrayList();

	// Event Listener on TextField[#filterField].onKeyReleased
	@FXML
	public void search(KeyEvent event) {
		if (filterField == null) {
			BrandDelegate.displayBrands().stream().forEach((b) -> {
				list.add(b);
			});
			;
			table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			// tableView.setTableMenuButtonVisible(true);
			idCl.setCellValueFactory(new PropertyValueFactory<>("idMarque"));

			brandCl.setCellValueFactory(new PropertyValueFactory<>("label"));

			table.setItems(list);

		}
		list.clear();
		String keyword = filterField.getText();

		BrandDelegate.search(keyword).stream()
				.forEach((brand) -> list.add(brand));
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		// tableView.setTableMenuButtonVisible(true);
		idCl.setCellValueFactory(new PropertyValueFactory<>("idMarque"));

		brandCl.setCellValueFactory(new PropertyValueFactory<>("brand"));

		table.setItems(list);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		BrandDelegate.displayBrands().stream().forEach(a -> list.add(a));
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		// tableView.setTableMenuButtonVisible(true);
		idCl.setCellValueFactory(new PropertyValueFactory<>("idMarque"));

		brandCl.setCellValueFactory(new PropertyValueFactory<>("label"));

		table.setItems(list);
	}
}
