package Model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;

public class Product {

	private String name;
	private int storePrice;
	private int customerPrice;
	private Customer customer;

	public Product(String name, int storePrice, int customerPrice, Customer customer) {
		setName(name);
		setStorePrice(storePrice);
		setCustomerPrice(customerPrice);
		setCustomer(customer);
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setStorePrice(int storePrice) {
		if(storePrice<0) {
			this.storePrice = 0;
			return;
		}
		this.storePrice = storePrice;
	}

	private void setCustomerPrice(int costumerPrice) {
		if(costumerPrice<0) {
			this.customerPrice = 0;
			return;
		}
		this.customerPrice = costumerPrice;
	}

	private void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getName() {
		return name;
	}

	public int getStorePrice() {
		return storePrice;
	}

	public int getCostumerPrice() {
		return customerPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public int storeProfit() {
		int profit;
		profit = customerPrice - storePrice;
		if (profit < 0)
			profit = 0;
		return profit;
	}

	public static Product readProductFromTheFile(RandomAccessFile dIn, Iterator<String> myIterator) throws IOException {
		return new Product(myIterator.next(), Integer.parseInt((String) myIterator.next()),
				Integer.parseInt((String) myIterator.next()), Customer.readCustomerFromTheFile(dIn, myIterator));
	}

	public void writeProductToTheFile(RandomAccessFile dOut) throws IOException {
		dOut.writeUTF(name);
		dOut.writeUTF(String.valueOf(storePrice));
		dOut.writeUTF(String.valueOf(customerPrice));
		customer.writeCustomerToTheFile(dOut);
	}

	@Override
	public String toString() {
		if(name.equals("null"))
			return "No Name For The Product, But the Profit Is: " + storeProfit() + "\n The Customer is: " + customer.toString();
		return name + " The Profit Is: "+ storeProfit() + "\n The Customer is: " + customer.toString();
	}
}
