package Map;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		AnchorPane root;
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("/Map/Map.fxml"));
			Scene scene = new Scene(root,600,400);
	 		primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public static void main(String[] args) {
		launch(args);
	}
}
