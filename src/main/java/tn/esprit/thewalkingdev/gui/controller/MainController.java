package tn.esprit.thewalkingdev.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController extends Application implements Initializable,
		ControlledScreen {
	ScreensController ctrl;
	@FXML
	private AnchorPane pane;
	@FXML
	private Button viewLog;
	@FXML
	private Button stat;
	@FXML
	private Button viewMedia;
	@FXML
	private Button viewEvent;
	@FXML
	private Button viewgamerr;
	@FXML
	private Button TeamBtn;
	@FXML
	private Button viewSpon;
	public static Stage primaryStage;
	public static String MainScreen = "/tn/esprit/thewalkingdev/gui/view/main.FXML";
	public static String Main = "Accueil";
	public static String DisplayEquipmentScreen = "/tn/esprit/thewalkingdev/gui/view/afficheEquipment.FXML";
	public static String DisplayEquipment = "Add Equipment";
	public static String DisplayEventScreen = "/tn/esprit/thewalkingdev/gui/view/DisplayEvent.FXML";
	public static String DisplayEquipement = "Display Event";
	public static String DisplayTeamsScreen = "/tn/esprit/thewalkingdev/gui/view/DisplayTeams.FXML";
	public static String DisplayTeams = "Display Teams";

	public static String DisplaySponsorScreen = "/tn/esprit/thewalkingdev/gui/view/DisplaySponsor.FXML";

	// Event Listener on Button[#viewLog].onAction
	@FXML
	public void viewLogistics(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				DisplayEquipmentScreen));
		pane.getChildren().add(node);
	}
	@FXML
	public void viewMedia(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				"/tn/esprit/thewalkingdev/gui/view/displayAllArticles.FXML"));
		pane.getChildren().add(node);
	}

	@FXML
	public void stat(ActionEvent event) throws IOException {
		Platform.runLater(new Runnable() {
			public void run() {
				new tn.esprit.thewalkingdev.gui.test.PieChartSample()
						.start(new Stage());
			}
		});
	}

	// Event Listener on Button[#viewEvent].onAction
	@FXML
	public void viewEvent(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass()
				.getResource(DisplayEventScreen));
		pane.getChildren().add(node);
	}

	@FXML
	public void viewgamer(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				"/tn/esprit/thewalkingdev/gui/view/AffichageGamer.fxml"));
		pane.getChildren().add(node);
	}

	@Override
	public void setScreenParent(ScreensController screenPage) {
		ctrl = screenPage;
	}

	@FXML
	public void deco(ActionEvent actionEvent) {
		try {
			Parent page_acceuil = FXMLLoader.load(getClass().getResource(
					"/tn/esprit/thewalkingdev/gui/view/Login.fxml"));
			Scene scene = new Scene(page_acceuil);
			Stage ad = (Stage) (((Node) actionEvent.getSource()).getScene()
					.getWindow());
			ad.setScene(scene);
			ad.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button[#TeamBtn].onAction
	@FXML
	public void TeamBtnAction(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				"/tn/esprit/thewalkingdev/gui/view/DisplayTeams.fxml"));
		pane.getChildren().add(node);
	}

	@FXML
	public void viewSponsors(ActionEvent event) throws IOException {
		pane.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(
				DisplaySponsorScreen));
		pane.getChildren().add(node);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ScreensController mainCtrl = new ScreensController();
		mainCtrl.loadScreen(Main, MainScreen);
		mainCtrl.setScreen(Main);
		Group root = new Group();
		root.getChildren().addAll(mainCtrl);
		Scene scene = new Scene(root);
		this.primaryStage = primaryStage;
		primaryStage.getIcons().add(new Image("/tn/esprit/thewalkingdev/Images/Image1.png"));
		primaryStage.setTitle("Accueil");
		primaryStage.setScene(scene);

		//primaryStage.initStyle(StageStyle.UNDECORATED);

		primaryStage.show();

	}
}
