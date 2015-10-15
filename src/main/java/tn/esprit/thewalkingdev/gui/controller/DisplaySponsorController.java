package tn.esprit.thewalkingdev.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import tn.esprit.thewalkingdev.entites.Sponsor;
import tn.esprit.thewalkingdev.services.contract.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.thewalkingdev.gui.delegates.SponsorDelegate;
import tn.esprit.thewalkingdev.gui.mail.*;

public class DisplaySponsorController implements Initializable {

	@FXML
	private TableView<Sponsor> tableView;
	@FXML
	private TableColumn<Sponsor, String> ClNameSponsor;
	@FXML
	private TableColumn<Sponsor, Integer> ClIdSponsor;
	@FXML
	private TableColumn<Sponsor, String> ClNameContact;
	@FXML
	private TableColumn<Sponsor, String> ClEmail;
	@FXML
	private TableColumn<Sponsor, String> ClDateStart;
	@FXML
	private TableColumn<Sponsor, String> CLDateEnd;
	@FXML
	private Button BtRemove;
	@FXML
	private Button BtAdd;
	@FXML
	private AnchorPane PaneAddSpon;
	@FXML
	private AnchorPane PanelMail;
	@FXML
	private Button BtSendMail;
	@FXML
	private Button BtSend;
	@FXML
	private TextArea taMail;
	@FXML
	private Button BtshowUpdate;
	@FXML
	private TextField tfupname;
	@FXML
	private AnchorPane PanelUpdate;
	@FXML
	private TextField tfupnamesp;
	@FXML
	private TextField tfupnamectsp;
	@FXML
	private TextField tfupemail;
	@FXML
	private DatePicker dtupendcont;
	@FXML
	private DatePicker dtupstartcont;
	@FXML
	private Button btupdateSpon;
	static SponsorRemote remoteSponsor;
	static SponsorRemote remoteDelete;
	private ObservableList<Sponsor> listSponsor;
	private ObservableList<Sponsor> list = FXCollections.observableArrayList();
	private int i;
	static SponsorRemote remoteFind;
	public static String AddSponsorScreen = "/tn/esprit/thewalkingdev/gui/view/AddSponsor.FXML";
	public static String MailSponsorScreen = "/tn/esprit/thewalkingdev/gui/view/SendMail.FXML";

	// Event Listener on Button[#BtRemove].onAction
	@FXML
	public void deleteSponsor(ActionEvent event) {
		Context context;
		i = tableView.getSelectionModel().getFocusedIndex();
		Sponsor sponsor = (Sponsor) tableView.getSelectionModel()
				.getSelectedItem();

		try {
			SponsorDelegate.deleteSponsor(sponsor);
			;
			list.remove(sponsor);
			JOptionPane.showMessageDialog(null,
					"Deleting completed successfully");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Can not delete a sponsor");
		}
	}

	// addsponsor
	@FXML
	public void addsponsor(ActionEvent event) throws IOException {
		PaneAddSpon.getChildren().clear();
		Node node;
		node = (Node) FXMLLoader.load(getClass().getResource(AddSponsorScreen));
		PaneAddSpon.getChildren().add(node);
	}

	// show mail
	@FXML
	public void Send(ActionEvent event) throws IOException {
		PanelMail.setVisible(true);
	}

	// send mail
	@FXML
	public void SendMail(ActionEvent event) throws IOException {
		Sponsor sponsor = (Sponsor) tableView.getSelectionModel()
				.getSelectedItem();
		String mailuser = sponsor.getEmail();
		String nomUser = sponsor.getName_sponsor();

		String Dest, subject, contenu;
		Dest = mailuser;
		subject = taMail.getText();
		contenu = "Miss or Mrs  " + nomUser;
		SendMail sendMail = new SendMail();
		tn.esprit.thewalkingdev.gui.mail.SendMail.sendMessage(subject, contenu,
				Dest, "anesmazouni@gmail.com");
	}

	@FXML
	public void BtshowUpdate(ActionEvent event) throws IOException {

		Sponsor sponsor = (Sponsor) tableView.getSelectionModel()
				.getSelectedItem();
		System.out.println(sponsor.getName_sponsor());
		tfupnamesp.setText(sponsor.getName_sponsor());
		tfupnamectsp.setText(sponsor.getName_contact_sponsor());
		tfupemail.setText(sponsor.getEmail());
		PanelUpdate.setVisible(true);
	}

	@FXML
	public void btupdateSpon(ActionEvent event) throws IOException {
		i = tableView.getSelectionModel().getFocusedIndex();
		Sponsor Sponsor = (Sponsor) tableView.getSelectionModel()
				.getSelectedItem();
		// Sponsor Sponsor = new Sponsor();
		Sponsor.setName_sponsor(tfupnamesp.getText());
		Sponsor.setName_contact_sponsor(tfupnamectsp.getText());
		Sponsor.setEmail(tfupemail.getText());

		LocalDate localDateS = dtupstartcont.getValue();
		Instant instantS = Instant.from(localDateS.atStartOfDay(ZoneId
				.systemDefault()));
		Date dts = Date.from(instantS);

		LocalDate localDateE = dtupendcont.getValue();
		Instant instantE = Instant.from(localDateE.atStartOfDay(ZoneId
				.systemDefault()));
		Date dtE = Date.from(instantE);

		Sponsor.setDateStart(dts);
		Sponsor.setDateEnd(dtE);
		if (tfupnamesp.getText().isEmpty() || tfupnamectsp.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "fill in all fields");
		} else if (tfupemail.getText().contains("@") == false) {
			JOptionPane.showMessageDialog(null, "check your address mail");
		} else {
			SponsorDelegate.updateSponsor(Sponsor);
			JOptionPane.showMessageDialog(null,
					"Editing performed successfully");
		}
		tableView.refresh();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("*********!!!!*****");
		PanelMail.setVisible(false);
		PanelUpdate.setVisible(false);

		SponsorDelegate.displaySponsor().stream().forEach((Sponsor) -> {
			list.add(Sponsor);
		});
		;
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		// tableView.setTableMenuButtonVisible(true);
		ClIdSponsor
				.setCellValueFactory(new PropertyValueFactory<>("id_sponsor"));
		ClNameSponsor.setCellValueFactory(new PropertyValueFactory<>(
				"name_sponsor"));
		ClNameContact.setCellValueFactory(new PropertyValueFactory<>(
				"name_contact_sponsor"));
		ClEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		ClDateStart
				.setCellValueFactory(new PropertyValueFactory<>("dateStart"));
		CLDateEnd.setCellValueFactory(new PropertyValueFactory<>("dateEnd"));
		tableView.setItems(list);
		;

	}
}
