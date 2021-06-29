package Model;

public class ProductMemento{
	private String name;
	private int storePrice;
	private int costumerPrice;
	private Customer customer;
	private String makat;
	
	
	public ProductMemento(Product p ,String makat) {
		this.name = p.getName();
		this.storePrice = p.getStorePrice();
		this.costumerPrice = p.getCostumerPrice();
		this.customer = p.getCustomer();
		this.makat = makat;
	}

	public String getName() {
		return name;
	}
	public String getMakat() {
		return this.makat;
	}

	public int getStorePrice() {
		return storePrice;
	}

	public int getCostumerPrice() {
		return costumerPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

}
