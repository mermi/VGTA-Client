package tn.esprit.thewalkingdev.gui.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.jboss.marshalling.ByteBufferInput;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

import javassist.expr.Instanceof;
import tn.esprit.thewalkingdev.entites.Gamer;
import tn.esprit.thewalkingdev.entites.Role;
import tn.esprit.thewalkingdev.gui.delegates.GamerDelegate;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class ShowGamerController extends Application implements Initializable {
	public static Gamer gam = new Gamer();
	public boolean issearch = false;
	public boolean isshow;
	@FXML
	public Hyperlink newadmin;

	public ShowGamerController() {
	}

	@FXML
	public void addnew(ActionEvent event) throws IOException {
		Parent page_acceuil = FXMLLoader.load(getClass().getResource(
				"/tn/esprit/thewalkingdev/gui/view/Addadmin.fxml"));
		Scene scene = new Scene(page_acceuil);
		Stage ad = (Stage) (((Node) event.getSource()).getScene().getWindow());
		ad.setScene(scene);
		ad.show();
	}

	@FXML
	Label lfirstname;
	@FXML
	Label llastname;
	@FXML
	Label lemail;
	@FXML
	TextField bfName;
	@FXML
	TextField jd;

	@FXML
	ChoiceBox<String> critaire;
	@FXML
	ImageView immage;

	@FXML
	TextField blastname;
	@FXML
	TextField bemail;
	@FXML
	ChoiceBox<String> brole;
	@FXML
	ChoiceBox<String> bteam;
	@FXML
	Button recherche;
	@FXML
	Button refrech;
	@FXML
	TableColumn firstNameCol = new TableColumn("First Name");

	@FXML
	TableColumn lastNameCol = new TableColumn("Last Name");
	@FXML
	TableColumn emailCol = new TableColumn("Email");
	@FXML
	TableColumn team = new TableColumn("Team");
	@FXML
	TableColumn role = new TableColumn("Role");
	@FXML
	TableView<Person> table = new TableView<Person>();
	List<Gamer> listGamer = GamerDelegate.dofindAllGamers();;
	@FXML
	Button update;

	private final ObservableList<Person> data = FXCollections
			.observableArrayList();

	@FXML
	private void ajoutAction(ActionEvent actionEvent) {
		try {
			Parent page_ajout = FXMLLoader.load(getClass().getResource(
					"/tn/esprit/thewalkingdev/gui/view/addGamer.fxml"));
			Scene scene = new Scene(page_ajout);
			Stage ad = (Stage) (((Node) actionEvent.getSource()).getScene()
					.getWindow());
			ad.setScene(scene);
			ad.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(new Group());
		stage.setTitle("Table View Sample");
		stage.setWidth(450);
		stage.setHeight(550);
		stage.setScene(scene);
		stage.show();
	}

	public static class Person {

		private final SimpleStringProperty firstName;
		private final SimpleStringProperty lastName;
		private final SimpleStringProperty email;
		private SimpleStringProperty team;
		private final Role role;

		private Person(String fName, String lName, String email, Role role2,
				String team) {
			this.firstName = new SimpleStringProperty(fName);
			this.lastName = new SimpleStringProperty(lName);
			this.email = new SimpleStringProperty(email);
			this.role = role2;
			this.team = new SimpleStringProperty(team);
		}

		public String getFirstName() {
			return firstName.get();
		}

		public void setFirstName(String fName) {
			firstName.set(fName);
		}

		public String getLastName() {
			return lastName.get();
		}

		public void setLastName(String fName) {
			lastName.set(fName);
		}

		public String getEmail() {
			return email.get();
		}

		public void setEmail(String fName) {
			email.set(fName);
		}

		public String getTeam() {
			return team.getValue();
		}

		public void setTeam(SimpleStringProperty team) {
			this.team = team;
		}

		public Role getRole() {
			return role;
		}

	}

	@FXML
	public void deleteAction(ActionEvent actionEvent) {
		for (Gamer s : listGamer) {

			if ((s.getEmail().equals(table.getSelectionModel()
					.getSelectedItem().getEmail()))
					&& (s.getLastName().equals(
							table.getSelectionModel().getSelectedItem()
									.getLastName()) && (s.getFirstName()
							.equals(table.getSelectionModel().getSelectedItem()
									.getFirstName())))) {
				GamerDelegate.dodeleteGamer(s);

			}

		}
		Person person = new Person(null, null, null, null, null);
		ObservableList<Person> lspers, selectedperson;
		lspers = table.getItems();
		selectedperson = table.getSelectionModel().getSelectedItems();
		selectedperson.forEach(lspers::remove);
	}

	public void mosoue(MouseEvent actionEvent) throws IOException {
		if (actionEvent.getClickCount() > 0) {
			for (Gamer s : listGamer) {

				if ((s.getEmail().equals(table.getSelectionModel()
						.getSelectedItem().getEmail()))
						&& (s.getLastName().equals(
								table.getSelectionModel().getSelectedItem()
										.getLastName()) && (s.getFirstName()
								.equals(table.getSelectionModel()
										.getSelectedItem().getFirstName())))) {

					Gamer gamer1 = new Gamer();

					gamer1 = GamerDelegate.dofindGamerById(s.getId());

					if (gamer1.getImage() != null) {
						byte[] im = gamer1.getImage();
						ByteArrayInputStream bais = new ByteArrayInputStream(im);
						BufferedImage image = ImageIO.read(bais);
						Image immm = SwingFXUtils.toFXImage(image, null);
						immage.setImage(immm);
					} else {
						immage.setImage(null);

					}

				}

			}
		}
	}

	@FXML
	public void updateAction(ActionEvent actionEvent) throws IOException {
		FXMLLoader load = new FXMLLoader();
		load.setLocation(getClass().getResource(
				"/tn/esprit/thewalkingdev/gui/view/UpdateGamer.fxml"));
		load.load();
		Parent page_ajout = load.getRoot();

		Scene scene = new Scene(page_ajout);
		Stage ad = (Stage) (((Node) actionEvent.getSource()).getScene()
				.getWindow());
		ad.setScene(scene);
		// passage Gamer
		UpdateGamerController showController = load.getController();
		for (Gamer s : listGamer) {
			if ((s.getEmail().equals(table.getSelectionModel()
					.getSelectedItem().getEmail()))
					&& (s.getLastName().equals(
							table.getSelectionModel().getSelectedItem()
									.getLastName()) && (s.getFirstName()
							.equals(table.getSelectionModel().getSelectedItem()
									.getFirstName())))) {

				showController.setGg(s);
			}

		}
		ad.show();

	}

	@FXML
	public void recherche(ActionEvent actionEvent) throws Exception {
		if (critaire.getSelectionModel().getSelectedItem() == null)
			JOptionPane.showMessageDialog(null, "Error :Please select one ");
		else {
			if (critaire.getSelectionModel().getSelectedItem()
					.equals("BY Last Name")) {
				llastname.setVisible(true);
				blastname.setVisible(true);
				bemail.setVisible(false);
				bfName.setVisible(false);
				brole.setVisible(false);
				bteam.setVisible(false);
				critaire.setVisible(false);
			}

			if (critaire.getSelectionModel().getSelectedItem()
					.equals("BY First Name")) {
				lfirstname.setVisible(true);
				bfName.setVisible(true);
				bemail.setVisible(false);
				blastname.setVisible(false);
				brole.setVisible(false);
				bteam.setVisible(false);

				critaire.setVisible(false);
			}
			if (critaire.getSelectionModel().getSelectedItem()
					.equals("BY Email")) {
				lemail.setVisible(true);
				bemail.setVisible(true);
				bfName.setVisible(false);
				blastname.setVisible(false);
				brole.setVisible(false);
				bteam.setVisible(false);

				critaire.setVisible(false);
			}
			if (critaire.getSelectionModel().getSelectedItem()
					.equals("BY Role")) {
				brole.setVisible(true);
				bfName.setVisible(false);
				blastname.setVisible(false);
				bemail.setVisible(false);
				bteam.setVisible(false);

				critaire.setVisible(false);
			}
			if (critaire.getSelectionModel().getSelectedItem()
					.equals("BY Team")) {
				bteam.setVisible(true);
				bfName.setVisible(false);
				blastname.setVisible(false);
				bemail.setVisible(false);
				brole.setVisible(false);

				critaire.setVisible(false);
			}

			firstNameCol
					.setCellValueFactory(new PropertyValueFactory<Person, String>(
							"firstName"));

			lastNameCol
					.setCellValueFactory(new PropertyValueFactory<Person, String>(
							"lastName"));

			emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>(
					"email"));
			team.setCellValueFactory(new PropertyValueFactory<Person, String>(
					"team"));
			role.setCellValueFactory(new PropertyValueFactory<Person, String>(
					"role"));

 			data.clear();

			 

			for (Gamer s : listGamer) {

				if (brole.getSelectionModel().getSelectedItem() != null)

				{
 							 
					System.out.println(s.getRole().toString());
					if (s.getRole() != null) {
						if (brole.getSelectionModel().getSelectedItem()
								.equals(s.getRole().toString())) {
							if (s.getTeam() == null) {
								data.add(new Person(s.getFirstName(), s
										.getLastName(), s.getEmail(), s
										.getRole(), " "));
							} else {
								data.add(new Person(s.getFirstName(), s
										.getLastName(), s.getEmail(), s
										.getRole(), s.getTeam().getName()));
							}
						}
					 
					}
				}

 
				if (bteam.getSelectionModel().getSelectedItem() != null)

				{
 					String nomteam =  bteam.getSelectionModel().getSelectedItem();
				
 					if (nomteam.equals(s.getTeam().getName())) {
						if (s.getTeam() == null) {
							data.add(new Person(s.getFirstName(), s
									.getLastName(), s.getEmail(), s.getRole(),
									" "));
						} else {
							data.add(new Person(s.getFirstName(), s
									.getLastName(), s.getEmail(), s.getRole(),
									s.getTeam().getName()));
						}
					}
				}

			}// for
			if (bfName.getText() != null) {
				List<Gamer> lst = GamerDelegate.dosearchfirstname(bfName
						.getText());
				for (Gamer s : lst) {
					if (s.getTeam() == null) {
						data.add(new Person(s.getFirstName(), s.getLastName(),
								s.getEmail(), s.getRole(), " "));
					} else {
						data.add(new Person(s.getFirstName(), s.getLastName(),
								s.getEmail(), s.getRole(), s.getTeam()
										.getName()));
					}

				}
			}
			if (blastname.getText() != null) {
				List<Gamer> lst = GamerDelegate.dosearchlastname(blastname
						.getText());
				for (Gamer s : lst) {
					if (s.getTeam() == null) {
						data.add(new Person(s.getFirstName(), s.getLastName(),
								s.getEmail(), s.getRole(), " "));
					} else {
						data.add(new Person(s.getFirstName(), s.getLastName(),
								s.getEmail(), s.getRole(), s.getTeam()
										.getName()));
					}
				}
			}
			if (bemail.getText() != null) {
				List<Gamer> lst = GamerDelegate.dosearchemail(bemail.getText());
				for (Gamer s : lst) {
					if (s.getTeam() == null) {
						data.add(new Person(s.getFirstName(), s.getLastName(),
								s.getEmail(), s.getRole(), " "));
					} else {
						data.add(new Person(s.getFirstName(), s.getLastName(),
								s.getEmail(), s.getRole(), s.getTeam()
										.getName()));
					}

				}
			}
			table.setEditable(true);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		critaire.getItems().addAll("BY Last Name", "BY First Name", "BY Email",
				"BY Role", "BY Team");
		brole.getItems().addAll("Gamer", "Active Member", "VIP Member",
				"Administrative Council");
		bteam.getItems().addAll("team Logistic", "team Media",
				"team Organisation", "team Sponsoring");
		firstNameCol
				.setCellValueFactory(new PropertyValueFactory<Person, String>(
						"firstName"));

		lastNameCol
				.setCellValueFactory(new PropertyValueFactory<Person, String>(
						"lastName"));

		emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>(
				"email"));
		team.setCellValueFactory(new PropertyValueFactory<Person, String>(
				"team"));
		role.setCellValueFactory(new PropertyValueFactory<Person, String>(
				"role"));

		table.setEditable(true);
		for (Gamer s : listGamer) {
			if (s.getTeam() == null) {
				data.add(new Person(s.getFirstName(), s.getLastName(), s
						.getEmail(), s.getRole(), " "));
			} else {
				data.add(new Person(s.getFirstName(), s.getLastName(), s
						.getEmail(), s.getRole(), s.getTeam().getName()));
			}

		}
		table.setEditable(true);
		table.setItems(data);

	}

	public void refrech(ActionEvent actionEvent) {

		lemail.setVisible(false);
		lfirstname.setVisible(false);
		llastname.setVisible(false);
		brole.setVisible(false);

		bteam.setVisible(false);
		bfName.setVisible(false);
		blastname.setVisible(false);
		bemail.setVisible(false);
 	if (bemail.getText() != null)
 	{
 		bemail.setText(null);
 	}
	if (blastname.getText() != null)
 	{
		blastname.setText(null);
 	}
	if (bfName.getText() != null)
 	{
		bfName.setText(null);
 	}
	if (bteam.getSelectionModel().getSelectedItem()  != null)
 	{
		bteam.setSelectionModel(new SingleSelectionModel<String>() {

			@Override
			protected int getItemCount() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			protected String getModelItem(int index) {
				// TODO Auto-generated method stub
				return null;
			}
		});
 	}
	if (brole.getSelectionModel().getSelectedItem()  != null)
 	{
		brole.setSelectionModel(new SingleSelectionModel<String>() {

			@Override
			protected int getItemCount() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			protected String getModelItem(int index) {
				// TODO Auto-generated method stub
				return null;
			}
		});
 	} 
		critaire.setVisible(true);
		data.clear();

		firstNameCol
				.setCellValueFactory(new PropertyValueFactory<Person, String>(
						"firstName"));

		lastNameCol
				.setCellValueFactory(new PropertyValueFactory<Person, String>(
						"lastName"));

		emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>(
				"email"));
		team.setCellValueFactory(new PropertyValueFactory<Person, String>(
				"team"));
		role.setCellValueFactory(new PropertyValueFactory<Person, String>(
				"role"));

		table.setEditable(true);
		for (Gamer s : listGamer) {
			if (s.getTeam() == null) {
				data.add(new Person(s.getFirstName(), s.getLastName(), s
						.getEmail(), s.getRole(), " "));
			} else {
				data.add(new Person(s.getFirstName(), s.getLastName(), s
						.getEmail(), s.getRole(), s.getTeam().getName()));
			}

		}
		table.setEditable(true);
		table.setItems(data);

	}

	public Gamer getGam() {
		return gam;
	}

	public void setGam(Gamer gam) {
		this.gam = gam;
	}
	public void deco(ActionEvent actionEvent) {
		try {
			Parent page_acceuil = FXMLLoader.load(getClass().getResource(
					"/tn/esprit/thewalkingdev/gui/view/Login.fxml"));
			Scene scene = new Scene(page_acceuil);
			Stage ad = (Stage) (((Node) actionEvent.getSource()).getScene().getWindow());
			ad.setScene(scene);
			ad.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
