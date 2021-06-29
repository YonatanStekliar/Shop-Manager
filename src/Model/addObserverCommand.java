package Model;

public class addObserverCommand implements Command{

	private Store theStore;
	private Customer c;
	public addObserverCommand(Store s) {
		this.theStore = s;
	}
	@Override
	public void execute() {
		theStore.addObserver(c);
	}
	
	public void setCustomer(Customer c) {
		this.c = c;
	}
}
