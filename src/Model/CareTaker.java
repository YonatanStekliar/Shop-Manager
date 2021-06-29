package Model;

import java.util.Stack;

public class CareTaker {
	
	private Stack<MementoClass> memento;

	public CareTaker() {
		this.memento = new Stack<>();
	}

	public void save(MementoClass makat) {
		memento.push(makat);
	}

	public MementoClass restore() {
		if(memento.isEmpty())
			return null;
		return memento.pop();
	}
}
