package Main;

// Submitted By:
// Bar Mizrahi - 316080365
// Yonatan Stekliar - 316554260

import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import Model.Store;
import Model.addObserverCommand;
import Model.addProductToTheStoreCommand;
import Model.deleleProductByGivenMakatCommand;
import Model.deleteAllProductCommand;
import Model.deleteLastEntryCommand;
import Model.executingCommand;
import Model.getEachProductProfitAndTotalProfitCommand;
import Model.getProductByMakatCommand;
import Model.notifyObserversCommand;
import Model.readStoreFromTheFileCommand;
import Model.setMapOfProductsCommand;
import Model.storeToStringCommand;
import javafx.application.Application;

public class program extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws IOException {
		File f = new File("products.txt");
		RandomAccessFile raf = new RandomAccessFile(f, "rw");
		Store s = new Store(raf);
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
		View.View view = new View.View(primaryStage);
		Controller.Controller controller = new Controller.Controller(view, ec, raf);
	}
}
