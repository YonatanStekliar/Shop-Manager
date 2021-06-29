package View;

/*
import javafx.scene.control.CheckBox;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextField;
*/
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import javafx.scene.Scene;
import javafx.scene.text.Font;

public class View {
	private Group root;
	private BorderPane bp;
	private ToggleGroup tgr;
	private Text tHowToSotr, signal;
	private RadioButton rbAsc, rbDesc, rbInsert;
	private Button bConfirmSort, bShowProductByGivenMakat, bShowAllProducts, bShowProfits, bAddProduct,
			bDeleteProcudtByGivenMakat, bDeleteAllProducts, bDeleteLastEntry, bSendMassge, bShowObservs, bClose;
	private VBox vbSort, vbMain;
	private HBox hbShow, hbAdd, hbDelete, hbObserver;
	private Stage stage;
	
	public View(Stage primaryStage) {
		root = new Group();
		bp = new BorderPane();
		bConfirmSort = new Button("Confirm");
		bConfirmSort.setFont(Font.font("David", 20));
		tgr = new ToggleGroup();
		signal = new Text();
		signal.setFont(Font.font("David", 20));
		tHowToSotr = new Text("Please choose which way to sort the products in the store");
		tHowToSotr.setFont(Font.font("David", 20));
		rbAsc = new RadioButton("Ascending Order");
		rbAsc.setFont(Font.font("David", 20));
		rbAsc.setToggleGroup(tgr);
		rbDesc = new RadioButton("Descending Order");
		rbDesc.setFont(Font.font("David", 20));
		rbDesc.setToggleGroup(tgr);
		rbInsert = new RadioButton("Insert Order");
		rbInsert.setFont(Font.font("David", 20));
		rbInsert.setToggleGroup(tgr);
		vbSort = new VBox();
		vbSort.setAlignment(Pos.CENTER);

		bAddProduct = new Button("Add Product");
		bAddProduct.setFont(Font.font("David", 20));
		bAddProduct.setPrefWidth(250);
		hbAdd = new HBox();
		hbAdd.setAlignment(Pos.CENTER);
		hbAdd.getChildren().add(bAddProduct);

		bShowAllProducts = new Button("Show All Products");
		bShowAllProducts.setFont(Font.font("David", 20));
		bShowAllProducts.setPrefWidth(250);
		bShowProductByGivenMakat = new Button("Show Product By Makat");
		bShowProductByGivenMakat.setFont(Font.font("David", 19));
		bShowProductByGivenMakat.setPrefWidth(250);
		bShowProductByGivenMakat.setPrefHeight(40);
		bShowProfits = new Button("Show Profit");
		bShowProfits.setFont(Font.font("David", 20));
		bShowProfits.setPrefWidth(250);
		hbShow = new HBox();
		hbShow.setAlignment(Pos.CENTER);
		hbShow.getChildren().addAll(bShowAllProducts, bShowProductByGivenMakat, bShowProfits);

		bDeleteAllProducts = new Button("Delete all Products");
		bDeleteAllProducts.setFont(Font.font("David", 20));
		bDeleteAllProducts.setPrefWidth(250);
		bDeleteLastEntry = new Button("Delete Last Product");
		bDeleteLastEntry.setFont(Font.font("David", 19));
		bDeleteLastEntry.setPrefWidth(250);
		bDeleteLastEntry.setDisable(true);
		bDeleteProcudtByGivenMakat = new Button("Delete Product By Makat");
		bDeleteProcudtByGivenMakat.setFont(Font.font("David", 19));
		bDeleteProcudtByGivenMakat.setPrefWidth(250);
		bDeleteProcudtByGivenMakat.setPrefHeight(40);
		hbDelete = new HBox();
		hbDelete.setAlignment(Pos.CENTER);
		hbDelete.getChildren().addAll(bDeleteAllProducts, bDeleteLastEntry, bDeleteProcudtByGivenMakat);

		bSendMassge = new Button("Send Discount Message");
		bSendMassge.setFont(Font.font("David", 19));
		bSendMassge.setPrefWidth(250);
		bSendMassge.setPrefHeight(40);
		bShowObservs = new Button("Show Clients Intrested In Updates");
		bShowObservs.setFont(Font.font("David", 16));
		bShowObservs.setPrefWidth(250);
		bShowObservs.setPrefHeight(40);
		bShowObservs.setDisable(true);
		hbObserver = new HBox();
		hbObserver.setAlignment(Pos.CENTER);
		hbObserver.getChildren().addAll(bSendMassge, bShowObservs);
		
		Label lWelcome = new Label("Welcome To The Store!");
		lWelcome.setFont(Font.font("David",75));
		lWelcome.setAlignment(Pos.TOP_CENTER);

		stage = primaryStage;
		bClose = new Button("Close");
		vbMain = new VBox();
		vbMain.getChildren().addAll(lWelcome,hbAdd, hbShow, hbDelete, hbObserver, signal,bClose);
		vbMain.setAlignment(Pos.CENTER);
		primaryStage.setTitle("Store Application");
		Scene scene = new Scene(bp, 1000, 750);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void mainMenu() {
		vbSort.getChildren().clear();
		bp.setCenter(vbMain);
	}

	public void setWhichWaySort() {
		vbSort.getChildren().addAll(tHowToSotr, rbAsc, rbDesc, rbInsert, bConfirmSort, signal);
		vbSort.setAlignment(Pos.CENTER);
		bp.setCenter(vbSort);
	}
	
	public void whichWaySort(EventHandler<ActionEvent> event) {
		bConfirmSort.setOnAction(event);
	}

	public void ShowProfits(EventHandler<ActionEvent> event) {
		bShowProfits.setOnAction(event);
	}

	public int getSortChoose() {
		if (rbAsc.isSelected())
			return 1;
		if (rbDesc.isSelected())
			return 2;
		if (rbInsert.isSelected())
			return 3;
		return 0;
	}

	public void closeTheStage() {
		stage.close();
	}
	
	public void addProduct(EventHandler<ActionEvent> event) {
		bAddProduct.setOnAction(event);
	}

	public void showAllProducts(EventHandler<ActionEvent> event) {
		bShowAllProducts.setOnAction(event);
	}

	public void ShowProductByGivenMakat(EventHandler<ActionEvent> event) {
		bShowProductByGivenMakat.setOnAction(event);
	}

	public void DeleteAllProducts(EventHandler<ActionEvent> event) {
		bDeleteAllProducts.setOnAction(event);
	}

	public void DeleteProcudtByGivenMakat(EventHandler<ActionEvent> event) {
		bDeleteProcudtByGivenMakat.setOnAction(event);
	}
	public void DeleteLastEntry(EventHandler<ActionEvent> event) {
		bDeleteLastEntry.setOnAction(event);
	}
	
	public void SendMassge(EventHandler<ActionEvent> event) {
		bSendMassge.setOnAction(event);
	}
	
	public void ShowObservs(EventHandler<ActionEvent> event) {
		bShowObservs.setOnAction(event);
	}
	
	public void close(EventHandler<ActionEvent> event) {
		bClose.setOnAction(event);
	}
	
	public void disableSendMsg() {
		bSendMassge.setDisable(true);
	}
	
	public void ableSendMsg() {
		bSendMassge.setDisable(false);
	}
	
	public void setGoodSiganl(String msg) {
		this.signal.setText(msg);
		this.signal.setFill(Color.GREEN);
	}

	public void setBadSiganl(String msg) {
		this.signal.setText(msg);
		this.signal.setFill(Color.RED);
	}

	public Group getRoot() {
		return root;
	}

	public BorderPane getBp() {
		return bp;
	}

	public ToggleGroup getTgr() {
		return tgr;
	}

	public Text gettHowToSotr() {
		return tHowToSotr;
	}

	public RadioButton getRbAsc() {
		return rbAsc;
	}

	public RadioButton getRbDesc() {
		return rbDesc;
	}

	public RadioButton getRbInsert() {
		return rbInsert;
	}

	public Button getbConfirmSort() {
		return bConfirmSort;
	}

	public VBox getVbSort() {
		return vbSort;
	}
	
	
	public Text getSignal() {
		return signal;
	}

	public Button getbShowProductByGivenMakat() {
		return bShowProductByGivenMakat;
	}

	public Button getbShowAllProducts() {
		return bShowAllProducts;
	}

	public Button getbShowProfits() {
		return bShowProfits;
	}

	public Button getbAddProduct() {
		return bAddProduct;
	}

	public Button getbDeleteProcudtByGivenMakat() {
		return bDeleteProcudtByGivenMakat;
	}

	public Button getbDeleteAllProducts() {
		return bDeleteAllProducts;
	}

	public Button getbDeleteLastEntry() {
		return bDeleteLastEntry;
	}

	public Button getbSendMassge() {
		return bSendMassge;
	}

	public Button getbShowObservs() {
		return bShowObservs;
	}

	public VBox getVbMain() {
		return vbMain;
	}

	public HBox getHbShow() {
		return hbShow;
	}

	public HBox getHbAdd() {
		return hbAdd;
	}

	public HBox getHbDelete() {
		return hbDelete;
	}

	public HBox getHbObserver() {
		return hbObserver;
	}

	public void activeDeleteLastEntryButton() {
		this.bDeleteLastEntry.setDisable(false);
	}

	public void disableDeleteLastEntryButton() {
		this.bDeleteLastEntry.setDisable(true);
	}

	public void activeObserver() {
		this.bShowObservs.setDisable(false);
	}
	
	public void disableObserver() {
		this.bShowObservs.setDisable(true);
	}
}
