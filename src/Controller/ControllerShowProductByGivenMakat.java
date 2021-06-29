package Controller;

import Model.executingCommand;
import View.ViewShowProductByGivenMakat;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

public class ControllerShowProductByGivenMakat {

	public ControllerShowProductByGivenMakat(ViewShowProductByGivenMakat viewShowProductByGivenMakat,
			executingCommand executingCommand) {
		viewShowProductByGivenMakat.ok(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				executingCommand.getGetProductByMakatCommand().setTf(new Text());
				executingCommand.getGetProductByMakatCommand().setMakat(viewShowProductByGivenMakat.getSearch().getText());
				executingCommand.getProductByMakat();
				viewShowProductByGivenMakat.getShowProduct().getChildren()
						.add(executingCommand.getGetProductByMakatCommand().getText());
				viewShowProductByGivenMakat.addCloseButton();
			}
		});
	
		viewShowProductByGivenMakat.closeAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				viewShowProductByGivenMakat.closeSearchByGivenMakat();
				
			}
		});
		
	}

}
