package Model;

public class setMapOfProductsCommand implements Command{
	private Store theStore;
	private int choose;
	public setMapOfProductsCommand(Store s) {
		this.theStore = s;
	}
	@Override
	public void execute() {
		theStore.setMapOfProducts(choose);
	}
	public void setChoose(int choose) {
		this.choose = choose;
	}
}
