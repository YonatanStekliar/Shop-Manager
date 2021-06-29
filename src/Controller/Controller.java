package Controller;

import java.io.IOException;
import java.io.RandomAccessFile;

import Model.Update;
import Model.executingCommand;
import View.View;
import View.ViewAddProduct;
import View.ViewDeleteProcudtByGivenMakat;
import View.ViewSendMassge;
import View.ViewShowAllProducts;
import View.ViewShowObservs;
import View.ViewShowProductByGivenMakat;
import View.ViewShowProfits;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Controller {

	private View theView;
	private executingCommand executingCommand;

	public Controller(View view, executingCommand ec, RandomAccessFile raf) throws IOException {
		this.theView = view;
		this.executingCommand = ec;
		if (raf.length() > 0) { // no need to show "how to sort the map"
			executingCommand.getSetMapOfProductsCommand().setChoose(Integer.parseInt(raf.readUTF()));
			executingCommand.setMapOfProducts();
			executingCommand.readStoreFromTheFile();
			theView.mainMenu();
		}
		// if here -> there is file that is not empty ne need
		// to ask him
		else {// if here then the file is empty and we need to ask the user which way he want
				// the map to be sorted
			theView.setWhichWaySort();
			theView.whichWaySort(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					int choose;
					do {
						choose = theView.getSortChoose();
					} while (choose == 0);
					theView.mainMenu();
					executingCommand.getSetMapOfProductsCommand().setChoose(choose);
					executingCommand.setMapOfProducts();
					try {
						raf.writeUTF(String.valueOf(choose));
					} catch (IOException e) {
						theView.setBadSiganl("Error Writing To File");
					}
					// cuz all the time write the number of his choose
				}
			});
		}

		theView.addProduct(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ViewAddProduct ViewAddProduct = new ViewAddProduct(new Stage());
				ControllerAddProcuct ControllerAddProcuct = new ControllerAddProcuct(ViewAddProduct, theView,
						executingCommand);
				theView.ableSendMsg();
			}
		});

		theView.showAllProducts(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ViewShowAllProducts ViewShowAllProducts = new ViewShowAllProducts(new Stage());
				ControllerShowAllProducts ControllerShowAllProducts = new ControllerShowAllProducts(ViewShowAllProducts,
						executingCommand);

			}
		});

		theView.ShowProductByGivenMakat(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ViewShowProductByGivenMakat viewShowProductByGivenMakat = new ViewShowProductByGivenMakat(new Stage());
				ControllerShowProductByGivenMakat ControllerShowProductByGivenMakat = new ControllerShowProductByGivenMakat(
						viewShowProductByGivenMakat, executingCommand);

			}
		});

		theView.ShowProfits(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ViewShowProfits ViewShowProfits = new ViewShowProfits(new Stage());
				ControllerShowProfits ControllerShowProfits = new ControllerShowProfits(ViewShowProfits,
						executingCommand);

			}
		});

		theView.DeleteAllProducts(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				executingCommand.deleteAllProduct();
				theView.setGoodSiganl("All The Products Have Been Deleted");
				Update.deleteAllReceiver();
				theView.disableSendMsg();
				theView.disableDeleteLastEntryButton();
				theView.disableObserver();
			}
		});

		theView.DeleteProcudtByGivenMakat(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ViewDeleteProcudtByGivenMakat ViewDeleteProcudtByGivenMakat = new ViewDeleteProcudtByGivenMakat(
						new Stage());
				ControllerDeleteProcudtByGivenMakat ControllerDeleteProcudtByGivenMakat = new ControllerDeleteProcudtByGivenMakat(
						ViewDeleteProcudtByGivenMakat, theView, executingCommand);
			}
		});

		theView.DeleteLastEntry(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				executingCommand.deleteLastEntry();
				theView.setGoodSiganl("The Last Entry Was Deleted Successfully");
				theView.disableDeleteLastEntryButton();
			}
		});

		theView.SendMassge(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ViewSendMassge ViewSendMassge = new ViewSendMassge(new Stage());
				ControllerSendMassge ControllerSendMassge = new ControllerSendMassge(ViewSendMassge, view,
						executingCommand);
			}
		});

		theView.ShowObservs(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ViewShowObservs ViewShowObservs = new ViewShowObservs(new Stage());
				ControllerShowObservs ControllerShowObservs = new ControllerShowObservs(ViewShowObservs, theView,
						executingCommand);

			}
		});

		theView.close(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theView.closeTheStage();
				Alert A = new Alert(AlertType.INFORMATION);
				A.setHeaderText("Bye!");
				A.setContentText("Thanks For Visiting Our Store!");
				A.show();
			}
		});
	}

}
