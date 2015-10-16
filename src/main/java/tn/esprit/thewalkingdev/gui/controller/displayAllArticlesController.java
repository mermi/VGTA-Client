package tn.esprit.thewalkingdev.gui.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Instant;
import java.util.Date;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import tn.esprit.thewalkingdev.entites.Article;
import tn.esprit.thewalkingdev.gui.delegates.ArticleCrudDelegate;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class displayAllArticlesController implements Initializable {
	@FXML
	private Button b_new;
	@FXML
	private Button b_update;
	@FXML
	private Button b_delete;
	@FXML
	private Button b_confirm_add;
	@FXML
	private TableView<Article> tv_articles;
	@FXML
	private TableColumn<Article, String> col_title;
	@FXML
	private TableColumn<Article, Date> col_date;
	@FXML
	private Button b_show;
	@FXML
	private Pane pane_show;
	@FXML
	private ImageView id_img;
	@FXML
	private Text txt_title;
	@FXML
	private TextArea id_show;
	@FXML
	private Label l_date;
	@FXML
	private Pane pane_edit;
	@FXML
	private TextArea id_text;
	@FXML
	private Button b_confirm_edit;
	@FXML
	private TextField tf_title;
	@FXML
	private TextField tf_image_path;
	@FXML
	private TextField tf_video_path;
	@FXML
	private CheckBox cb_remove_image;
	@FXML
	private TextField tf_search;
	@FXML
	private Hyperlink hl_video;
	@FXML
	private Button b_file_chooser;

	private ObservableList<Article> list = FXCollections.observableArrayList();

	private Article article_edit = new Article();
	private File file = null;

	// Event Listener on Button[#b_new].onAction
	@FXML
	public void popAdd(ActionEvent event) {
		pane_edit.setVisible(true);
		pane_show.setVisible(false);
		b_confirm_edit.setVisible(false);
		b_confirm_add.setVisible(true);
	}

	// Event Listener on Button[#b_confirm_add].onAction
	@FXML
	public void confirmAdd(ActionEvent event) {
		String title = tf_title.getText();
		String text = id_text.getText();
		String video = tf_video_path.getText();
		Article article = new Article(title, text, null, video,
				Date.from(Instant.now()));

		// region uploadfile
		if (file != null) {
			byte[] bFile = new byte[(int) file.length()];
			FileInputStream fileInputStream = null;

			// convert file into array of bytes
			try {
				fileInputStream = new FileInputStream(file);
				fileInputStream.read(bFile);
				fileInputStream.close();
				article.setImage(bFile);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// endregion

		ArticleCrudDelegate.doAddArticle(article);
		list.clear();
		tf_title.clear();
		tf_video_path.clear();
		id_text.clear();
		tf_image_path.clear();
		displayArticles();

	}

	// Event Listener on Button[#b_update].onAction
	@FXML
	public void popUpdate(ActionEvent event) {
		pane_edit.setVisible(true);
		pane_show.setVisible(false);
		b_confirm_add.setVisible(false);
		b_confirm_edit.setVisible(true);

		// Retrieve article from list
		article_edit = tv_articles.getSelectionModel().getSelectedItem();

		// Retrieve article fields
		tf_title.setText(article_edit.getTitle());
		id_text.setText(article_edit.getText());
		tf_video_path.setText(article_edit.getVideo());

	}

	// Event Listener on Button[#b_confirm_edit].onAction
	@FXML
	public void confirmEdit(ActionEvent event) {

		String title = tf_title.getText();
		String text = id_text.getText();
		String video = tf_video_path.getText();

		if (file != null) {
			byte[] bFile = new byte[(int) file.length()];
			FileInputStream fileInputStream = null;

			// convert file into array of bytes
			try {
				fileInputStream = new FileInputStream(file);
				fileInputStream.read(bFile);
				fileInputStream.close();
				 
				 article_edit.setImage(bFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		article_edit.setTitle(title);
		article_edit.setText(text);
		article_edit.setVideo(video);
		article_edit.setPubDate(Date.from(Instant.now()));
		if (cb_remove_image.isSelected()) {
			article_edit.setImage(null);
		}

		ArticleCrudDelegate.doUpdateArticle(article_edit);
		list.clear();
		tf_title.clear();
		tf_video_path.clear();
		id_text.clear();
		tf_image_path.clear();
		article_edit = new Article();
		list.clear();
		displayArticles();

	}

	// Event Listener on Button[#b_delete].onAction
	@FXML
	public void deleteArticle(ActionEvent event) {
		Article article = tv_articles.getSelectionModel().getSelectedItem();
		ArticleCrudDelegate.doDeleteArticle(article.getId_article());
		list.clear();
		displayArticles();
	}

	// Event Listener on Button[#b_show].onAction
	@FXML
	public void loadArticle(ActionEvent event) {
		pane_edit.setVisible(false);
		pane_show.setVisible(true);

		Article article = tv_articles.getSelectionModel().getSelectedItem();

		id_show.setText(article.getText());
		l_date.setText("Dernière modification le " + article.getPubDate());
		txt_title.setText(article.getTitle());

		if (article.getImage() == null)
			id_img.setVisible(false);
		else {
			try {
				byte[] lob_img = article.getImage();
				ByteArrayInputStream bais = new ByteArrayInputStream(lob_img);
				BufferedImage bimg = ImageIO.read(bais);
				Image image = SwingFXUtils.toFXImage(bimg, null);
				id_img.setImage(image);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// Event Listener on TextField[#tf_search].onKeyReleased
	@FXML
	public void searchArticle(KeyEvent event) {
		if (tf_search == null) {
			displayArticles();
		}
		list.clear();
		String keyword = tf_search.getText();
		ArticleCrudDelegate.doSearchArticle(keyword).stream()
				.forEach(a -> list.add(a));
		tv_articles.setTableMenuButtonVisible(true);
		tv_articles.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_date.setCellValueFactory(new PropertyValueFactory<>("pubDate"));
		tv_articles.setItems(list);
	}

	// Event Listener on Button[#b_file_chooser].onAction
	@FXML
	public void chooseFile(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"PNG images (*.png)", "*.png");
		FileChooser.ExtensionFilter extFilter1 = new FileChooser.ExtensionFilter(
				"JPEG images (*.jpg)", "*.jpg");
		FileChooser.ExtensionFilter extFilte3 = new FileChooser.ExtensionFilter(
				"Gif images (*.gif)", "*.gif");
		FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter(
				"All files (*.*)", "*.*");
		fileChooser.getExtensionFilters().addAll(extFilter1, extFilte3,
				extFilter, extFilter2);
		Stage primaryStage = new Stage();
		file = fileChooser.showOpenDialog(primaryStage);
		FileInputStream fileInputStream = null;
		String fpath = file.getPath();
		tf_image_path.setText(fpath);

		byte[] bFile = new byte[(int) file.length()];

		// convert file into array of bytes
		try {
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Event Listener on Hyperlink[#hl_video].onAction
	@FXML
	public void popUpVideo(ActionEvent event) {
		Stage stage = new Stage();
		if (tf_video_path.getText() == "") {

		} else if (tf_video_path.getText().contains("http")) {
			WebView webview = new WebView();
			webview.getEngine().load(tf_video_path.getText());
			stage.setScene(new Scene(webview));
			stage.show();
		} else {
			File f = new File(tf_video_path.getText());
			Media m = new Media(f.toURI().toString());
			MediaPlayer mp = new MediaPlayer(m);
			MediaView mv = new MediaView(mp);

			StackPane root = new StackPane();
			root.getChildren().add(mv);

			stage.setScene(new Scene(root));
			stage.setTitle("video player");
			stage.show();
			mp.play();

		}

	}

	public void displayArticles() {
		ArticleCrudDelegate.dofindAllArticles().stream()
				.forEach(a -> list.add(a));
		tv_articles.setTableMenuButtonVisible(true);
		tv_articles.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_date.setCellValueFactory(new PropertyValueFactory<>("pubDate"));
		tv_articles.setItems(list);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pane_edit.setVisible(false);
		pane_show.setVisible(false);
		displayArticles();

	}
}
