package utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import controller.MainProject;


public interface DateUtil {

	
	/*	Adds nDays to the given date and returns the output
	 * 	1. conversion from java.sql.Date to java.util.Date 
	 * 	2. using Calendar to manipulate the converted date
	 *  3. conversion of result back to java.sql.Date 
	 *  4. return 
	 */
	public static Date addDays(Date date, int nDays) { 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try{  
	           cal.setTime(sdf.parse(date.toString()));  
	           cal.add(Calendar.DAY_OF_MONTH, nDays);
	           return new Date(cal.getTime().getTime());
		}
		catch(ParseException e){  
			MainProject.log.info(date.toString());
			e.printStackTrace();
	            return null;
	         }  
    	
    }
    
    
}
