import java.awt.AWTException;

import org.sikuli.basics.Settings;
import org.sikuli.script.*;

public class OCR {
	public static void readScreen(){
		//Creating new thread because of the infinite loop
		//that is used to find if the user joined the lobby or not.
		Thread thread = new Thread(new Runnable() {
		     public void run() {
		    	 while (Start.isTheCallerActive){
		 			if (Start.regionToRead.text().toLowerCase().contains("joined the lobby")){
		 				try {
		 					Start.mouseMove();
		 				} catch (AWTException e) {
		 					// TODO Auto-generated catch block
		 					e.printStackTrace();
		 				} catch (InterruptedException e) {
		 					// TODO Auto-generated catch block
		 					e.printStackTrace();
		 				}
		 				Start.flipTheSwitch();
		 				break;
		 			}
		 			System.out.println(Start.regionToRead.text());//Debug
		 		}		    
		     }
		     
		});
		
		thread.start();
		
	}

}
