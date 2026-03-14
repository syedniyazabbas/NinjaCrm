package generic_utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class JavaUtility {
	public int generateRandomNubmer() {
		int ran= (int)(Math.random()*9999);
		return ran;
		
	}
	public String getCurrentDateAndTime() {
		
		LocalDateTime now=LocalDateTime.now();
		System.out.println(now);
	System.out.println(LocalDate.now());	
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
		String formatteddatetime=now.format(formatter);
		return formatteddatetime;
	}
	public String getRandomString() {

	    String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    StringBuilder sb=new StringBuilder();
	    Random r=new Random();

	    for(int i=0;i<5;i++) {
	        sb.append(chars.charAt(r.nextInt(chars.length())));
	    }

	    return sb.toString();
	}
	public int getRandom4DigitNumber() {
	    Random r = new Random();
	    return 1000 + r.nextInt(9000);
	}
	
	
	
	
	public static void main(String[] args) {
		JavaUtility ju=new JavaUtility();
		System.out.println(ju.generateRandomNubmer());
		System.out.println(ju.getCurrentDateAndTime());
		
		
		
	}
	

}
