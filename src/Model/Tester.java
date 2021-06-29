package Model;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Tester {

	public static void main(String[] args) throws IOException {
		File f = new File("products.txt");
		Store s;
		RandomAccessFile raf = new RandomAccessFile(f, "rw");
		if (raf.length() > 0) {
			s = new Store(raf);
			s.setMapOfProducts(Integer.parseInt(raf.readUTF()));
		}
		// if here -> there is file that is not empty ne need
		// to ask him
		else {// if here then the file is empty and we need to ask him which way he want the
				// map to be
			s = new Store(raf);
			s.setMapOfProducts(1);
			raf.writeUTF(String.valueOf(1));// out of the store constrcture
			// cuz all the time write the number of his choose
		}
		Customer c = new Customer("yonatan", "054", false);
		Customer c1 = new Customer("bar", "052", true);
		Product p = new Product("milk", 5, 10, c);
		Product p1 = new Product("shoes", 100, 150, c);
		Product p2 = new Product("A", 3, 5, c1);
		Product p3 = new Product("m", 400, 700, c1);
		// all the commands
		addProductToTheStoreCommand ap = new addProductToTheStoreCommand(s);
		getProductByMakatCommand gp = new getProductByMakatCommand(s, null);
		deleteLastEntryCommand dl = new deleteLastEntryCommand(s);
		deleleProductByGivenMakatCommand dp = new deleleProductByGivenMakatCommand(s);
		deleteAllProductCommand da = new deleteAllProductCommand(s);
		storeToStringCommand ss = new storeToStringCommand(s, null);
		getEachProductProfitAndTotalProfitCommand gprofit = new getEachProductProfitAndTotalProfitCommand(s, null);
		notifyObserversCommand noc = new notifyObserversCommand(s);
		addObserverCommand aoc = new addObserverCommand(s);
		setMapOfProductsCommand smc = new setMapOfProductsCommand(s);
		readStoreFromTheFileCommand rfc = new readStoreFromTheFileCommand(s);
		executingCommand ec = new executingCommand(dl, dp, da, ap, gp, ss, gprofit, noc, smc, aoc, rfc);
		ec.readStoreFromTheFile();
		System.out.println(s);
		dp.setMakatToDelete("s"); // set makat to delete by given makat
		ec.getAddProductToTheStoreCommand().setMakat("s");
		ap.setP(p);
		ec.addProductToTheStore();
		System.out.println(s);
		ap.setMakat("b");
		ap.setP(p1);
		ec.addProductToTheStore();
		System.out.println(s);
		ap.setMakat("aba");
		ap.setP(p2);
		ec.addProductToTheStore();
		System.out.println(s);
		ap.setMakat("zzz");
		ap.setP(p3);
		ec.addProductToTheStore();
		System.out.println(s);
		ec.getEachProductProfitAndTotalProfit();
		ec.deleteLastEntry();
		System.out.println("after delete last enetry : \n" + s);
		ec.deleleProductByGivenMakat();
		System.out.println("after delete product by given a makat: \n" + s);
		// ec.deleteAllProduct();
		// System.out.println("after delete all: \n"+s);
		System.out.println(s);
		gp.setMakat("aba"); // set the map to look for
		ec.getProductByMakat();
		s.addObserver(c);
		s.addObserver(c1);
		noc.setMsgText("New Discount");
		ec.notifyObservers();
		System.out.println(Update.getlReceiverr());
	}

}
