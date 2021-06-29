package Model;

public class executingCommand {

	private Command deleteLastEntryCommand;
	private Command deleleProductByGivenMakatCommand;
	private Command deleteAllProductCommand;
	private Command addProductToTheStoreCommand;
	private Command getProductByMakatCommand;
	private Command storeToStringCommand;
	private Command getEachProductProfitAndTotalProfitCommand;
	private Command notifyObserversCommand;
	private Command setMapOfProductsCommand;
	private Command addObserverCommand;
	private Command readStoreFromTheFileCommand;

	public executingCommand(Command deleteLastEntryCommand, Command deleleProductByGivenMakatCommand,
			Command deleteAllProductCommand, Command addProductToTheStoreCommand, Command getProductByMakatCommand,
			Command storeToString, Command getEachProductProfitAndTotalProfitCommand, Command notifyObserversCommand,
			Command setMapOfProductsCommand, Command addObserverCommand,Command readStoreFromTheFileCommand) {
		this.deleteLastEntryCommand = deleteLastEntryCommand;
		this.deleleProductByGivenMakatCommand = deleleProductByGivenMakatCommand;
		this.deleteAllProductCommand = deleteAllProductCommand;
		this.addProductToTheStoreCommand = addProductToTheStoreCommand;
		this.getProductByMakatCommand = getProductByMakatCommand;
		this.storeToStringCommand = storeToString;
		this.getEachProductProfitAndTotalProfitCommand = getEachProductProfitAndTotalProfitCommand;
		this.notifyObserversCommand = notifyObserversCommand;
		this.setMapOfProductsCommand = setMapOfProductsCommand;
		this.addObserverCommand = addObserverCommand;
		this.readStoreFromTheFileCommand = readStoreFromTheFileCommand;
	}
	
	public void readStoreFromTheFile () {
		readStoreFromTheFileCommand.execute();
	}

	public void addObserver() {
		this.addObserverCommand.execute();
	}

	public void setMapOfProducts() {
		this.setMapOfProductsCommand.execute();
	}

	public void deleteLastEntry() {
		this.deleteLastEntryCommand.execute();
	}

	public void getEachProductProfitAndTotalProfit() {
		this.getEachProductProfitAndTotalProfitCommand.execute();
	}

	public void notifyObservers() {
		notifyObserversCommand.execute();
	}

	public void deleleProductByGivenMakat() {
		this.deleleProductByGivenMakatCommand.execute();
	}

	public void deleteAllProduct() {
		this.deleteAllProductCommand.execute();
	}

	public void addProductToTheStore() {
		this.addProductToTheStoreCommand.execute();
	}

	public void getProductByMakat() {
		this.getProductByMakatCommand.execute();
	}

	public void storeToString() {
		this.storeToStringCommand.execute();
	}

	public deleteLastEntryCommand getDeleteLastEntryCommand() {
		return (deleteLastEntryCommand)deleteLastEntryCommand;
	}

	public deleleProductByGivenMakatCommand getDeleleProductByGivenMakatCommand() {
		return (deleleProductByGivenMakatCommand)deleleProductByGivenMakatCommand;
	}

	public deleteAllProductCommand getDeleteAllProductCommand() {
		return (deleteAllProductCommand)deleteAllProductCommand;
	}

	public addProductToTheStoreCommand getAddProductToTheStoreCommand() {
		return (addProductToTheStoreCommand)addProductToTheStoreCommand;
	}

	public getProductByMakatCommand getGetProductByMakatCommand() {
		return (getProductByMakatCommand)getProductByMakatCommand;
	}

	public storeToStringCommand getStoreToString() {
		return (storeToStringCommand)storeToStringCommand;
	}

	public getEachProductProfitAndTotalProfitCommand getGetEachProductProfitAndTotalProfitCommand() {
		return (getEachProductProfitAndTotalProfitCommand)getEachProductProfitAndTotalProfitCommand;
	}

	public notifyObserversCommand getNotifyObserversCommand() {
		return (notifyObserversCommand)notifyObserversCommand;
	}

	public setMapOfProductsCommand getSetMapOfProductsCommand() {
		return (setMapOfProductsCommand)setMapOfProductsCommand;
	}

	public addObserverCommand getAddObserverCommand() {
		return (addObserverCommand)addObserverCommand;
	}
}
