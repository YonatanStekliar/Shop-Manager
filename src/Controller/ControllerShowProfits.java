package Controller;

import Model.executingCommand;
import View.ViewShowProfits;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

public class ControllerShowProfits {

	public ControllerShowProfits(ViewShowProfits viewShowProfits, executingCommand executingCommand) {
		executingCommand.getGetEachProductProfitAndTotalProfitCommand().setTf(new Text());
		executingCommand.getEachProductProfitAndTotalProfit();
		viewShowProfits.getShowAll().getChildren().add(executingCommand.getGetEachProductProfitAndTotalProfitCommand().getText());
		viewShowProfits.addCloseButton();
		viewShowProfits.close(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				viewShowProfits.closeTheStage();
			}
		});
	}

	
	
}
