package utils;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;



public class TimeUtil {

	public static void diff(Time t1, Time t2) {
		
		var d = t2.getTime()-t1.getTime();
		
		
		
		var t= new Time(d);

		
		
	}
	
	public static Time millisToTime(Long millis) {
		String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
	    TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1),
	    TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1));
		
		return Time.valueOf(hms);
		
	}
	
	
}
