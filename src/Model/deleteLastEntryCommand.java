package Model;

import java.io.IOException;

public class deleteLastEntryCommand implements Command {

	private Store theStore;
	
	public deleteLastEntryCommand(Store theStore) {
		this.theStore = theStore;
	}

	@Override
	public void execute() { // might need to send it 2 nulls
		try {
			theStore.deleteLastEntery();
		} catch (IOException e) {
		}
	}
}
