package Controller;

import Model.executingCommand;
import View.View;
import View.ViewDeleteProcudtByGivenMakat;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControllerDeleteProcudtByGivenMakat {

	public ControllerDeleteProcudtByGivenMakat(ViewDeleteProcudtByGivenMakat viewDeleteProcudtByGivenMakat,
			View theView, executingCommand executingCommand) {
		viewDeleteProcudtByGivenMakat.ok(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				executingCommand.getDeleleProductByGivenMakatCommand()
						.setMakatToDelete(viewDeleteProcudtByGivenMakat.getSearch().getText());
				executingCommand.deleleProductByGivenMakat();
				if (executingCommand.getDeleleProductByGivenMakatCommand().getIsDelete())
					theView.setGoodSiganl("Product Was Deleted Successfully");
				else
					theView.setBadSiganl("Cannot Delete The Product");
				viewDeleteProcudtByGivenMakat.closeStage();
			}
		});
	}

}
