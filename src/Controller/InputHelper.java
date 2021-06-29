package Controller;

public class InputHelper {

	private String str;

	public InputHelper() {
	}

	public boolean cheackIfStringIsInt() {
		try {
			// the String to int conversion happens here
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
	public boolean cheackIfStringIsBoolean() {
		String helper = str;
		helper.toLowerCase();
		if(helper.equals("true") || helper.equals("false"))
			return true;
		return false;
	}
	
	public void setString(String str) {
		this.str = str;
	}
}
