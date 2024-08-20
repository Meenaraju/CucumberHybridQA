package Utils;

import java.util.Date;

public class CommonUtilis {
	
	public static final int IMPLICT_WAIT_TIME=10;
	public static final int EXPLICIT_WAIT_TIME=30;
	public static final int PAGE_LOAD_TIME=15;
	
	public String getEmailwithTimestamp() {
		Date date = new Date();
		return "minu"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}

}
