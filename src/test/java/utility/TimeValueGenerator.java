package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeValueGenerator {
	
	public static String getTime()
	{
		DateTimeFormatter dff = DateTimeFormatter.ofPattern("dd MM yyyy HH mm");
		
		LocalDateTime now	= LocalDateTime.now();
		
		String timeValue = dff.format(now);
		
		String value = timeValue.replace(" ", "");
		
		System.out.println(value);
		
		return value;
		
		
	}
	
	public static void main(String[] args) {
		TimeValueGenerator.getTime();
	}

}
