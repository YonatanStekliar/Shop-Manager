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

public class ViewShowObservs {
	private Text[] names;
	private VBox showNames;
	private BorderPane bp;
	private Button bClose;
	private int whereInNames;
	private Stage stage;

	public ViewShowObservs(Stage stage) {
		this.stage = stage;
		bClose = new Button("Close");
		bp = new BorderPane();
		showNames = new VBox();
		whereInNames = 0;
		showNames.setAlignment(Pos.CENTER);
		bp.setCenter(showNames);
		Scene scene = new Scene(bp, 800, 600);
		stage.setTitle("Show Clients Intrested In Updates");
		stage.setScene(scene);
		stage.show();
	}

	public void setNames(int count) {
		names = new Text[count+1];
	}

	public void getText(int i) {
		names[i] = new Text();
		names[i].setFont(Font.font("David", 20));
	}

	public void addTextToVbox() {
		showNames.getChildren().add(names[whereInNames]);
		whereInNames++;
	}
	
	public void setText(String name ,int i) {
		names[i].setText(name);
	}

	public Text[] getNames() {
		return names;
	}

	public VBox getShowNames() {
		return showNames;
	}

	public int getWhereInNames() {
		return whereInNames;
	}
	
	public void close(EventHandler<ActionEvent> event) {
		bClose.setOnAction(event);
	}

	public void closeStage() {
		stage.close();
	}
	
	public void addCloseButton() {
		showNames.getChildren().add(bClose);
	}
	
}
