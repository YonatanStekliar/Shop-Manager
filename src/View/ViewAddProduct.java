package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ViewAddProduct {
	private Group root;
	private BorderPane bp;
	private Button bConfirm;
	private TextField tfEnterProductName, tfEnterProductStorePrice, tfEnterProductCustomerPrice, tfCustomerName,
			tfCustomerCell, tfCustomerIsIntrestedInUpdates, tfMakat;
	private Text tEnterProductName, tEnterProductStorePrice, tEnterProductCustomerPrice, tCustomerName, tCustomerCell,
			tCustomerIsIntrestedInUpdates, tMakat, tSignal;
	private HBox hbProductName, hbProductStorePrice, hbProcuctCustomerPrice, hbCustomerName, hbCustomerCell,
			hbCustomerIsIntrestedInUpdates, hbMakat;
	private VBox vbCreateProcuct;
	private CheckBox CBCustomerIsIntrestedInUpdates;
	private Stage stage;

	public ViewAddProduct(Stage stage) {
		this.stage = stage;
		bp = new BorderPane();
		root = new Group();
		bConfirm = new Button("Confirm");
		bConfirm.setFont(Font.font("David", 20));
		tSignal = new Text();
		tSignal.setFont(Font.font("David", 20));
		tEnterProductName = new Text("Enter The Product's Name:");
		tfEnterProductName = new TextField();
		tEnterProductName.setFont(Font.font("David", 20));
		hbProductName = new HBox();
		hbProductName.setAlignment(Pos.CENTER);
		hbProductName.getChildren().addAll(tEnterProductName, tfEnterProductName);
		//
		tEnterProductStorePrice = new Text("Enter The Store Price:");
		tfEnterProductStorePrice = new TextField();
		tEnterProductStorePrice.setFont(Font.font("David", 20));
		hbProductStorePrice = new HBox();
		hbProductStorePrice.setAlignment(Pos.CENTER);
		hbProductStorePrice.getChildren().addAll(tEnterProductStorePrice, tfEnterProductStorePrice);
		//
		tEnterProductCustomerPrice = new Text("Enter The Customer Price:");
		tfEnterProductCustomerPrice = new TextField();
		tEnterProductCustomerPrice.setFont(Font.font("David", 20));
		hbProcuctCustomerPrice = new HBox();
		hbProcuctCustomerPrice.setAlignment(Pos.CENTER);
		hbProcuctCustomerPrice.getChildren().addAll(tEnterProductCustomerPrice, tfEnterProductCustomerPrice);
		//
		tCustomerName = new Text("Enter The Customer's Name:");
		tfCustomerName = new TextField();
		tCustomerName.setFont(Font.font("David", 20));
		hbCustomerName = new HBox();
		hbCustomerName.setAlignment(Pos.CENTER);
		hbCustomerName.getChildren().addAll(tCustomerName, tfCustomerName);
		//
		tCustomerCell = new Text("Enter The Customer's cellPhone:");
		tfCustomerCell = new TextField();
		tCustomerCell.setFont(Font.font("David", 20));
		hbCustomerCell = new HBox();
		hbCustomerCell.setAlignment(Pos.CENTER);
		hbCustomerCell.getChildren().addAll(tCustomerCell, tfCustomerCell);

		CBCustomerIsIntrestedInUpdates = new CheckBox("Does The Customer Intrested In Updates?");
		CBCustomerIsIntrestedInUpdates.setFont(Font.font("David", 20));
		tMakat = new Text("Catalog Number:");
		tfMakat = new TextField();
		tMakat.setFont(Font.font("David", 20));
		hbMakat = new HBox();
		hbMakat.setAlignment(Pos.CENTER);
		hbMakat.getChildren().addAll(tMakat, tfMakat);
		vbCreateProcuct = new VBox(hbProductName, hbProductStorePrice, hbProcuctCustomerPrice, hbMakat, hbCustomerName,
				hbCustomerCell, CBCustomerIsIntrestedInUpdates, bConfirm, tSignal);
		vbCreateProcuct.setAlignment(Pos.CENTER);
		bp.setCenter(vbCreateProcuct);
		Scene scene = new Scene(bp, 1000, 800);
		stage.setTitle("Add Product");
		stage.setScene(scene);
		stage.show();
	}

	public void setBadSignal(String msg) {
		this.tSignal.setText(msg);
		this.tSignal.setFill(Color.RED);
	}
	
	public void setGoodSignal(String msg) {
		this.tSignal.setText(msg);
		this.tSignal.setFill(Color.GREEN);
	}

	public void addProcuct(EventHandler<ActionEvent> event) {
		bConfirm.setOnAction(event);
	}

	public boolean wantToUpdate() {
		if (CBCustomerIsIntrestedInUpdates.isSelected())
			return true;
		return false;
	}
	
	public void closeStage() {
		stage.close();
	}

	public Group getRoot() {
		return root;
	}

	public BorderPane getBp() {
		return bp;
	}

	public Button getbConfirm() {
		return bConfirm;
	}

	public TextField getTfEnterProductName() {
		return tfEnterProductName;
	}

	public TextField getTfEnterProductStorePrice() {
		return tfEnterProductStorePrice;
	}

	public TextField getTfEnterProductCustomerPrice() {
		return tfEnterProductCustomerPrice;
	}

	public TextField getTfCustomerName() {
		return tfCustomerName;
	}

	public TextField getTfCustomerCell() {
		return tfCustomerCell;
	}

	public TextField getTfCustomerIsIntrestedInUpdates() {
		return tfCustomerIsIntrestedInUpdates;
	}

	public TextField getTfMakat() {
		return tfMakat;
	}

	public Text gettEnterProductName() {
		return tEnterProductName;
	}

	public Text gettEnterProductStorePrice() {
		return tEnterProductStorePrice;
	}

	public Text gettEnterProductCustomerPrice() {
		return tEnterProductCustomerPrice;
	}

	public Text gettCustomerName() {
		return tCustomerName;
	}

	public Text gettCustomerCell() {
		return tCustomerCell;
	}

	public Text gettCustomerIsIntrestedInUpdates() {
		return tCustomerIsIntrestedInUpdates;
	}

	public Text gettMakat() {
		return tMakat;
	}

	public HBox getHbProductName() {
		return hbProductName;
	}

	public HBox getHbProductStorePrice() {
		return hbProductStorePrice;
	}

	public HBox getHbProcuctCustomerPrice() {
		return hbProcuctCustomerPrice;
	}

	public HBox getHbCustomerName() {
		return hbCustomerName;
	}

	public HBox getHbCustomerCell() {
		return hbCustomerCell;
	}

	public HBox getHbCustomerIsIntrestedInUpdates() {
		return hbCustomerIsIntrestedInUpdates;
	}

	public HBox getHbMakat() {
		return hbMakat;
	}

	public VBox getVbCreateProcuct() {
		return vbCreateProcuct;
	}

	public Text gettError() {
		return tSignal;
	}

	public CheckBox getCBCustomerIsIntrestedInUpdates() {
		return CBCustomerIsIntrestedInUpdates;
	}

	public void clearAll() {
		tfCustomerCell.clear();
		tfCustomerName.clear();
		tfEnterProductCustomerPrice.clear();
		tfEnterProductName.clear();
		tfEnterProductStorePrice.clear();
		tfMakat.clear();
		CBCustomerIsIntrestedInUpdates.setSelected(false);
	}

}
