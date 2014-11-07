package me.nicedev.easylobby.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainUtils {

	public static String getTime() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    Date dateobj = new Date();
	    return df.format(dateobj);
	}
	
}
