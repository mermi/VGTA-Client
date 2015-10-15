package tn.esprit.thewalkingdev.gui.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tn.esprit.thewalkingdev.gui.controller.ScreensController;

public class Main extends Application {

	public static String AddEquipmentScreen = "/tn/esprit/thewalkingdev/gui/view/addEquipment.FXML";
	public static String AddEquipment = "Add Equipment";
	public static String DisplayEquipmentScreen = "/tn/esprit/thewalkingdev/gui/view/Main.FXML";
	public static String DisplayEquipment = "Display Equipments";
	public static String AddBrandtScreen = "/tn/esprit/thewalkingdev/gui/view/addBrand.FXML";
	public static String AddBrand = "Add Brand";
	
	/*
	 * Event Screen
	 */
	public static String DisplayLoginScreen = "tn/esprit/thewalkingdev/gui/view/Login.fxml";

	public static String DisplayEventScreen = "tn/esprit/thewalkingdev/gui/view/Main.FXML";
	public static String DisplayEvent = "Display Event";
	
	public static Stage primaryStage;

	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		Main.primaryStage = primaryStage;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
			BorderPane root = (BorderPane) FXMLLoader.load(getClass()
					.getResource("/tn/esprit/thewalkingdev/gui/view/Login.fxml"));
			Scene scene = new Scene(root);
			 
			primaryStage.setScene(scene);
			primaryStage.show();
		
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		launch(args);
	}

}
