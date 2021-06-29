package Model;

import java.io.IOException;

public class deleteAllProductCommand implements Command {

	private Store theStore;
	
	public deleteAllProductCommand(Store theStore) {
	this.theStore = theStore;
}
	@Override
	public void execute() {
		try {
			theStore.deleteAllProduct();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}
		
	}

}
