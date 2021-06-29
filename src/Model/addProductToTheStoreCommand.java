package Model;

import java.io.IOException;

public class addProductToTheStoreCommand implements Command {

	private Store theStore;
	private String makat;
	private Product p;
	private boolean isNew = false;

	public addProductToTheStoreCommand(Store theStore) {
		this.theStore = theStore;
	}

	@Override
	public void execute() {
		try {
			isNew = theStore.addProductToTheStore(makat, p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}
	}

	public void setMakat(String makat) {
		this.makat = makat;
	}

	public void setP(Product p) {
		this.p = p;
	}
	
	public boolean getIsNew() {
		return isNew;
	}

}
