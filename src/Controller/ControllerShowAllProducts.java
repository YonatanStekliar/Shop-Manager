package Controller;

import Model.executingCommand;
import View.ViewShowAllProducts;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

public class ControllerShowAllProducts {

	public ControllerShowAllProducts(ViewShowAllProducts viewShowAllProducts, executingCommand executingCommand) {
		executingCommand.getStoreToString().setText(new Text());
		executingCommand.storeToString();
		viewShowAllProducts.getShowAll().getChildren().add(executingCommand.getStoreToString().getText());
		viewShowAllProducts.addCloseButton();
		viewShowAllProducts.close(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				viewShowAllProducts.closeTheStage();

			}
		});
	}

}
