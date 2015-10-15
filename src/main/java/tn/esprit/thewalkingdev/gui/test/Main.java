package tn.esprit.thewalkingdev.gui.test;

import tn.esprit.thewalkingdev.gui.test.Main;
import tn.esprit.thewalkingdev.gui.controller.ScreensController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

	public static String AddEquipmentScreen = "/tn/esprit/thewalkingdev/gui/view/addEquipment.FXML";
	public static String AddEquipment = "Add Equipment";
	public static String MainScreen = "/tn/esprit/thewalkingdev/gui/view/Main.FXML";
	public static String DisplayEquipment = "Display Equipments";
	public static String AddBrandtScreen = "/tn/esprit/thewalkingdev/gui/view/addBrand.FXML";
	public static String AddBrand = "Add Brand";
	public static String DisplayTeams = "/tn/esprit/thewalkingdev/gui/view/DisplayTeams.FXML";

	public static Stage primaryStage;

	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		Main.primaryStage = primaryStage;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ScreensController mainCtrl = new ScreensController();
		mainCtrl.loadScreen(DisplayTeams, MainScreen);

		this.primaryStage = primaryStage;
		mainCtrl.setScreen(DisplayTeams);
		Group root = new Group();
		root.getChildren().addAll(mainCtrl);
		Scene scene = new Scene(root);
		primaryStage.setTitle("MAIN");
		// primaryStage.getIcons().add(new
		// Image(Main.class.getResourceAsStream("/cdlr/images/icon.png")));
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
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
