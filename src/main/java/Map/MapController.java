package Map;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import tn.esprit.thewalkingdev.entites.Event;
import tn.esprit.thewalkingdev.gui.delegates.EventCrudDelegate;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;
import javafx.event.ActionEvent;

public class MapController implements Initializable {
	@FXML
	private Button Load;
	@FXML
	private Button Draw;
	@FXML
	private WebView web;

	// Event Listener on Button[#Load].onAction
	@FXML
	public void loadlocation(ActionEvent event) {
		web.getEngine().load(getClass().getResource("index.html").toExternalForm());
		
	
	}
	@FXML
	public void draw(ActionEvent event) {
		List<Event> lste=EventCrudDelegate.doFindAll();
		for(Event e:lste)
		{
 			web.getEngine().executeScript("document.goToLocation('"+e.getVenue().getAdress()+"','"+e.getName_event()+"','blue')"); 

		}

 
		ArrayList<Float> al=new ArrayList<Float>();;
		al.add((float) 61.05488);
		al.add((float) 28.022335);
		al.add((float) 61.05488);

		web.getEngine().executeScript("document.createPath("+al+",'red','l')");

	
	}

	public void initialize(URL location, ResourceBundle resources) {
web.getEngine().load("https://www.google.tn/maps?source=tldsi&hl=en");		
	}
}
