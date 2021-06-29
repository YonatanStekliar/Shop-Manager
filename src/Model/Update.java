package Model;

import java.util.ArrayList;
import java.util.List;

public class Update {

	private String msg;
	
	private static Update updateInstance = null;
	private static List<String> lReceiverr;
	private Update() {
		this.msg = "";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static Update getUpdateInstance() {
		if(updateInstance == null) 
			updateInstance = new Update();
		lReceiverr = new ArrayList<String>();
		return updateInstance;
	}
	
	public static void addCustomer(String c) {
		lReceiverr.add(c);
	}

	public static List<String> getlReceiverr() {
		return lReceiverr;
	}
	
	public static int sizeOfLReceiverr() {
		if(lReceiverr.isEmpty())
			return 0;
		return lReceiverr.size();
	}
	
	public static void deleteAllReceiver() {
		if(lReceiverr!=null)
			lReceiverr.clear();
	}
	
	
}
