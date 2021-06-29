package Model;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class getProductByMakatCommand implements Command {

	private Store theStore;
	private String makat;
	private Text tf;
	
	public getProductByMakatCommand(Store theStore, Text tf) {
		this.theStore = theStore;
		this.tf = tf;
	}
	
	@Override
	public void execute() {
		//tf.clear();
		Product pro = theStore.getProductByMakat(makat);
		if(pro!=null) {
			//System.out.println(pro.toString());
			tf.setText(pro.toString()); 
		}
		else 
			//System.out.println("there is no product by this makat: " + makat);
			tf.setText("there is no product by this makat: " + makat); 
	}

	public void setMakat(String makat) {
		this.makat = makat;
	}

	public void setTf(Text tf) {
		this.tf = tf;
		tf.setFont(Font.font("David", 20));
	}
	public Text getText() {
		return tf;
	}
}
