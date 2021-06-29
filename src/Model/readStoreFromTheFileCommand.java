package Model;

import java.io.IOException;

public class readStoreFromTheFileCommand implements Command {
	private Store theStore;
	public readStoreFromTheFileCommand(Store theStore) {
		this.theStore = theStore;
}
	@Override
	public void execute() {
		try {
			theStore.readStoreFromTheFile();
		} catch (IOException e) {
			
		}
		
	}
}
