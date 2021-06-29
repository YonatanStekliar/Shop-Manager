package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewSendMassge {
	private BorderPane bp;
	private TextField search;
	private Text text;
	private VBox showProduct;
	private HBox hbField;
	private Button ok;
	private Stage stage;

	public ViewSendMassge(Stage stage) {
		this.stage = stage;
		bp = new BorderPane();
		text = new Text("Please Enter The Message:");
		text.setFont(Font.font("David", 20));
		search = new TextField();
		hbField = new HBox();
		hbField.setAlignment(Pos.CENTER);
		ok = new Button("Send");
		ok.setFont(Font.font("David", 20));
		hbField.getChildren().addAll(text, search);
		showProduct = new VBox();
		showProduct.setAlignment(Pos.CENTER);
		showProduct.getChildren().addAll(hbField, ok);
		bp.setCenter(showProduct);
		Scene scene = new Scene(bp, 1200, 800);
		stage.setTitle("Send Message");
		stage.setScene(scene);
		stage.show();
	}

	public TextField getSearch() {
		return search;
	}

	public Text getText() {
		return text;
	}

	public VBox getShowProduct() {
		return showProduct;
	}

	public void ok(EventHandler<ActionEvent> event) {
		ok.setOnAction(event);
	}
	
	public void closeStage() {
		stage.close();
	}
}
