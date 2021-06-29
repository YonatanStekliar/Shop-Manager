package Model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Store implements Observable {

	private Map<String, Product> mapOfProducts;
	private CareTaker careTaker;
	private OriginatorClass oC;
	private List<Customer> clients;
	private Update updatesGenerator;
	private RandomAccessFile dIn;
	private Data data;

	public Store(RandomAccessFile dIn) throws IOException {
		// choose = 1 -> by ascending order/ choose = 2 -> descending/ choose = 3 ->by
		// // order of insertion
		this.dIn = dIn;
		data = new Data(dIn);
		careTaker = new CareTaker();
		oC = new OriginatorClass();
		clients = new ArrayList<Customer>();

	}

	public void setMapOfProducts(int choose) {
		switch (choose) {
		case 1:
			mapOfProducts = new TreeMap<String, Product>();
			break;
		case 2:
			mapOfProducts = new TreeMap<String, Product>(new compareDescending());
			break;
		case 3:
			mapOfProducts = new LinkedHashMap<String, Product>();
			break;
		default:
			break;
		}
	}

	public boolean addProductToFile(String makat, Product product) throws IOException {
		dIn.seek(dIn.length());
		dIn.writeUTF(makat);
		product.writeProductToTheFile(dIn);
		return true;
	}

	public boolean deleleProductByGivenMakat(String makatToDelete) throws IOException {
		return deleteAndUpdateTheStore(makatToDelete);
	}

	public boolean deleteLastEntery() throws IOException {
		oC.getProductFromMemento(careTaker.restore());
		ProductMemento pro = oC.getProductMemento();
		if (pro == null)
			return false;
		return deleteAndUpdateTheStore(pro.getMakat());
	}

	public boolean deleteAllProduct() throws IOException {
		Iterator<String> it = data.iterator();
		dIn.seek(0);
		dIn.readUTF();
		while (it.hasNext()) {
			for (int i = 0; i < 7; i++)
				it.next();
			it.remove();
			dIn.seek(0);
			dIn.readUTF();
		}
		readStoreFromTheFile();
		return true;
	}

	private boolean deleteAndUpdateTheStore(String makatToDelete) throws IOException {
		Iterator<String> it = data.iterator();
		dIn.seek(0);
		dIn.readUTF();
		while (it.hasNext()) {
			if (makatToDelete.equals(it.next())) {
				for (int i = 0; i < 6; i++)
					it.next();
				it.remove();
				readStoreFromTheFile();
				return true;
			}
			for (int i = 0; i < 6; i++)
				it.next();
		}
		return false;
	}

	public boolean addProductToTheStore(String makat, Product product) throws IOException {
		if (mapOfProducts.isEmpty()) {
			mapOfProducts.put(makat, product);
			oC.setProduct(new ProductMemento(product, makat));
			careTaker.save(oC.saveMemento());
			updateTheFile();
			return true;
		}
		if (mapOfProducts.containsKey(makat)) {
			Product p = getProductByMakat(makat);
			mapOfProducts.replace(makat, p, product);
			updateTheFile();// then we know we just update old key
			return false;
		}
		mapOfProducts.put(makat, product); // if here then enter the new product
		oC.setProduct(new ProductMemento(product, makat));
		careTaker.save(oC.saveMemento());
		updateTheFile();
		return true;
	}

	private void updateTheFile() throws IOException {
		dIn.seek(0);
		int choose = Integer.parseInt(dIn.readUTF());
		dIn.setLength(0);
		dIn.writeUTF(String.valueOf(choose));
		for (Map.Entry<String, Product> products : mapOfProducts.entrySet()) {
			addProductToFile(products.getKey(), products.getValue());
		}
	}

	public Product getProductByMakat(String makat) { // Finds product by given makat
		for (Map.Entry<String, Product> products : mapOfProducts.entrySet()) {
			if (products.getKey().equals(makat))
				return products.getValue();
		}
		return null;
	}

	public void readStoreFromTheFile() throws IOException { // need to add iterator functions
		String makat = " ";
		Product p = null;
		Iterator<String> it = data.iterator();
		dIn.seek(0);
		dIn.readUTF();
		mapOfProducts.clear();
		while (it.hasNext()) {
			makat = it.next();
			p = Product.readProductFromTheFile(dIn, it);
			mapOfProducts.put(makat, p);
			addObserver(p.getCustomer());
		}

	}

	public String getEachProductProfitAndTotalProfit() {
		StringBuffer sb = new StringBuffer();
		int totalProfit = 0, productProfit = 0;
		for (Map.Entry<String, Product> products : mapOfProducts.entrySet()) {
			sb.append("The Makat is: " + products.getKey());
			productProfit = products.getValue().storeProfit();
			totalProfit += productProfit;
			sb.append(" Product name is: " + products.getValue().getName() + " The profit from selling it is: "
					+ productProfit + "\n");
		}
		sb.append("The Total Profit From All The Product Is: " + totalProfit + "\n");
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuffer bs = new StringBuffer();
		int count = 1;
		bs.append("The Products In The Store Are:\n");
		for (Map.Entry<String, Product> products : mapOfProducts.entrySet()) {
			bs.append(count + ". " + products.getValue().toString() + "\n    (Catalog Number: " + products.getKey()
					+ ")\n");
			count++;
		}
		return bs.toString();
	}

	@Override
	public void addObserver(Customer c) {
		if (c.isIntrestedInUpdates() && !c.getName().equals("null"))
			clients.add(c);
	}

	@Override
	public void deleteObserver(Observer o) {
		clients.remove(o);
	}

	@Override
	public void notifyObservers(String msg) {
		updatesGenerator = Update.getUpdateInstance();
		updatesGenerator.setMsg(msg);
		for (int i = 0; i < clients.size(); i++) {
			clients.get(i).update(this, updatesGenerator);
		}
	}
}
