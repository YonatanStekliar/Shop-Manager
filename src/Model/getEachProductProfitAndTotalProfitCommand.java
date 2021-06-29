package Model;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class getEachProductProfitAndTotalProfitCommand implements Command {
 Store theStore;
 private Text tf;
 public getEachProductProfitAndTotalProfitCommand(Store theStore , Text tf) {
	 this.theStore = theStore;
	 this.tf = tf;
 }
	@Override
	public void execute() {
		tf.setText(theStore.getEachProductProfitAndTotalProfit());
	}
	
	public void setTf(Text tf) {
		this.tf = tf;
		tf.setFont(Font.font("David", 20));
	}
	
	public Text getText() {
		return tf;
	}
}
