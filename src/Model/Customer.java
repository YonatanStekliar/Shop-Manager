package Model;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;


public class Customer implements Observer {
	
	private String name;
	private String cellNum;
	private boolean isIntrestedInUpdates;
	
	public Customer(String name, String cellNum, boolean isIntrestedInUpdates) {
		setName(name);
		setCellNum(cellNum);
		setIntrestedInUpdates(isIntrestedInUpdates);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCellNum(String cellNum) {
		this.cellNum = cellNum;
	}

	public void setIntrestedInUpdates(boolean isIntrestedInUpdates) {
		this.isIntrestedInUpdates = isIntrestedInUpdates;
	}

	public String getName() {
		return name;
	}

	public String getCellNum() {
		return cellNum;
	}

	public boolean isIntrestedInUpdates() {
		return isIntrestedInUpdates;
	}
	
	public static Customer readCustomerFromTheFile(RandomAccessFile dIn, Iterator<String> myIterator) throws IOException {
		return new Customer(myIterator.next(), myIterator.next(), Boolean.parseBoolean(myIterator.next()));
	}
	
	public void writeCustomerToTheFile(RandomAccessFile dOut) throws IOException {
		dOut.writeUTF(name);
		dOut.writeUTF(cellNum);
		dOut.writeUTF(String.valueOf(isIntrestedInUpdates));
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if(!name.equals("null"))
			sb.append(name);
		if(!cellNum.equals("null"))
			sb.append(" The number is: "+ cellNum);
		sb.append((isIntrestedInUpdates? "":" not ")+" intrested in updates");
		return sb.toString();
	}


	@Override
	public void update(Observable o, Update arg) {
		if(o instanceof Store) 
			Update.addCustomer(name);	
	}

	


}
