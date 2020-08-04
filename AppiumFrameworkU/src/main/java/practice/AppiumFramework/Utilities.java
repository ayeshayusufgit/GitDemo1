package practice.AppiumFramework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
	private AndroidDriver driver;
	
	public Utilities(AndroidDriver<AndroidElement> driver) {
		this .driver=driver;
	}
	
	public void scrollToText(String country){
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+country+"\"));");
	}

}
