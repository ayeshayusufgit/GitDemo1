package practice.AppiumFramework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
	private AndroidDriver driver;
	
	
	//Adding new comment for develop branch code1
	//Adding new comment for develop branch code2
	
	public Utilities(AndroidDriver<AndroidElement> driver) {
		this .driver=driver;
	}
	
	public void scrollToText(String country){
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+country+"\"));");
	}

}
