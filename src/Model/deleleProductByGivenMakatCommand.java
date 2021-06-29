package Model;

import java.io.IOException;

public class deleleProductByGivenMakatCommand  implements Command{

	private Store theStore;
	private String makatToDelete;
	private boolean isDelete = false;
	
	public deleleProductByGivenMakatCommand(Store theStore) {
		this.theStore = theStore;
	}
	@Override
	public void execute() {
		try {
			isDelete = theStore.deleleProductByGivenMakat(makatToDelete);
		} catch (IOException e) {
		}
	}
	
	public void setMakatToDelete(String makatToDelete) {
		this.makatToDelete = makatToDelete;
	}
	
	public boolean getIsDelete(){
		return isDelete;
	}

}
