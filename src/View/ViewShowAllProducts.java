package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ViewShowAllProducts {
	private BorderPane bp;
	private VBox showAll;
	private Text text;
	private Button close;
	private Stage stage;
	public ViewShowAllProducts(Stage stage) {
		this.stage = stage;
		bp = new BorderPane();
		close = new Button("Close");
		text = new Text();
		text.setFont(Font.font("David", 10));
		showAll = new VBox();
		showAll.setAlignment(Pos.CENTER);
		bp.setCenter(showAll);
		Scene scene = new Scene(bp,1300, 800);
		stage.setTitle("Show All Products");
		stage.setScene(scene);
		stage.show();
	}
	public Text getText() {
		return text;
	}
	public VBox getShowAll() {
		return showAll;
	}

	public void addCloseButton() {
		showAll.getChildren().add(close);
	}
	
	public void close(EventHandler<ActionEvent> event) {
		close.setOnAction(event);
	}
	
	public void closeTheStage() {
		stage.close();
	}
}
