package Controller;

import java.util.List;

import Model.Update;
import Model.executingCommand;
import View.View;
import View.ViewShowObservs;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ControllerShowObservs {
	private int i, count;

	public ControllerShowObservs(ViewShowObservs viewShowObservs, View theView, executingCommand executingCommand) {
		executingCommand.notifyObservers();
		viewShowObservs.setNames(Update.sizeOfLReceiverr());// new arr
		List<String> names = Update.getlReceiverr();
		count = 0;
		Thread t = new Thread(() -> {
			try {
				for (i = 0; i < Update.sizeOfLReceiverr(); i++) {
					Thread.sleep(2000);
					Platform.runLater(() -> {
						viewShowObservs.getNames()[count] = new Text();
						viewShowObservs.getNames()[count].setFont(Font.font("David", 30));
						viewShowObservs.getNames()[count].setText(names.get(count));
						viewShowObservs.getShowNames().getChildren().add(viewShowObservs.getNames()[count]);
						count++;
					});
				}
				Platform.runLater(() -> {
					viewShowObservs.getNames()[count] = new Text();
					viewShowObservs.getNames()[count].setFont(Font.font("David", 30));
					viewShowObservs.getNames()[count].setText("Done");
					viewShowObservs.getNames()[count].setFill(Color.GREEN);
					viewShowObservs.getShowNames().getChildren().add(viewShowObservs.getNames()[count]);
					viewShowObservs.addCloseButton();
				});
			} catch (InterruptedException e) {
			}

		});
		t.start();

		viewShowObservs.close(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				viewShowObservs.closeStage();
			}
		});
	}
}
