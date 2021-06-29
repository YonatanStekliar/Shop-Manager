package Model;

public class notifyObserversCommand implements Command {
	private Store theStore;
	private String msgToSend;

	public notifyObserversCommand(Store theStore) {
		this.theStore = theStore;
	}

	public void setMsgText(String str) {
		this.msgToSend = str;
	}

	@Override
	public void execute() {
		this.theStore.notifyObservers(msgToSend);

	}
}
