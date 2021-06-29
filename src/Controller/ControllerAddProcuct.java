package Controller;

import Model.Customer;
import Model.Product;
import Model.executingCommand;
import View.View;
import View.ViewAddProduct;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControllerAddProcuct {

	public ControllerAddProcuct(ViewAddProduct viewAddProduct, View view, executingCommand ec) {
		viewAddProduct.addProcuct(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				InputHelper inputHelper = new InputHelper();
				String proName, storePrice, customerPrice, customerName, cellPhone, makat;
				boolean isInters;
				proName = viewAddProduct.getTfEnterProductName().getText();
				if (proName.isEmpty())
					proName = "null";
				storePrice = viewAddProduct.getTfEnterProductStorePrice().getText();
				if (storePrice.isEmpty())
					storePrice = "0";
				customerPrice = viewAddProduct.getTfEnterProductCustomerPrice().getText();
				if (customerPrice.isEmpty())
					customerPrice = "0";
				customerName = viewAddProduct.getTfCustomerName().getText();
				if (customerName.isEmpty())
					customerName = "null";
				cellPhone = viewAddProduct.getTfCustomerCell().getText();
				if (cellPhone.isEmpty())
					cellPhone = "null";
				isInters = viewAddProduct.wantToUpdate();
				makat = viewAddProduct.getTfMakat().getText();
				inputHelper.setString(storePrice);
				if (inputHelper.cheackIfStringIsInt() == false) {
					viewAddProduct.setBadSignal("Wrong Input");
					return;
				}
				inputHelper.setString(customerPrice);
				if (inputHelper.cheackIfStringIsInt() == false) {
					viewAddProduct.setBadSignal("Wrong Input");
					return;
				}
				if (makat.isEmpty()) {
					viewAddProduct.setBadSignal("Must Enter A Catalog Number For The Product");
					return;
				}
				Customer c = new Customer(customerName, cellPhone, isInters);
				ec.getAddObserverCommand().setCustomer(c);
				ec.addObserver();
				Product p = new Product(proName, Integer.parseInt(storePrice), Integer.parseInt(customerPrice), c);
				ec.getAddProductToTheStoreCommand().setP(p);
				ec.getAddProductToTheStoreCommand().setMakat(makat);
				ec.addProductToTheStore();
				viewAddProduct.clearAll();
				if (ec.getAddProductToTheStoreCommand().getIsNew()) {// if really new product was add then show the //
																		// buton to delete it
					view.activeDeleteLastEntryButton();
					view.setGoodSiganl("New Product Was Added");
				} else {
					view.disableDeleteLastEntryButton();
					view.setGoodSiganl("The Product With The Catalog Number " + makat + " Was Updated");
				}
				view.disableObserver();
				viewAddProduct.closeStage();
			}
		});
	}
}
