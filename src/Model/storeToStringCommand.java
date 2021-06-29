package Model;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class storeToStringCommand implements Command {

	private Store theStore;
	private Text tf;
	
	public storeToStringCommand(Store theStore, Text tf) {
		this.theStore = theStore;
		this.tf = tf;
	}
	
	@Override
	public void execute() {
		tf.setFont(Font.font("David", 20));
		tf.setText(theStore.toString());
	}

	public void setText(Text tf) {
		this.tf = tf;
	}

	public Text getText() {
		return tf;
	}
	
}
