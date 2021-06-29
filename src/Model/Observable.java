package Model;

public interface Observable {
	void addObserver(Customer c);
	void deleteObserver(Observer o);
	void notifyObservers(String mag);
}
