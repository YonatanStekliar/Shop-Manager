package Controller;

import Model.Update;
import Model.executingCommand;
import View.View;
import View.ViewSendMassge;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControllerSendMassge {

	public ControllerSendMassge(ViewSendMassge viewSendMassge, View view, executingCommand executingCommand) {
		viewSendMassge.ok(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String msg = viewSendMassge.getSearch().getText();
				executingCommand.getNotifyObserversCommand().setMsgText(msg);
				executingCommand.notifyObservers();
				view.setGoodSiganl("The Message Was Sent!");
				view.activeObserver();
				System.out.println(Update.getlReceiverr());
				viewSendMassge.closeStage();
			}
		});
	}

}
