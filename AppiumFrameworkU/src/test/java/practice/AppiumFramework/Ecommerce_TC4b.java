package practice.AppiumFramework;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
//Very important step
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

//appium/java-client
public class Ecommerce_TC4b extends TestBase {

	@Test
	public  void totalValidation() throws IOException {

		AndroidDriver<AndroidElement> driver = Ecommerce_TC4b.InstallInvokeAPK();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")
				.click();
		// driver.findElementByAndroidUIAutomator("new UiScrollable(new
		// UiSelector()).scrollIntoView(text(\""+India+"\"));").click();
		// driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new
		// UiSelector().scrollable(true).instance(0)).scrollIntoView(new
		// UiSelector().textMatches(\"" + containedText + "\").instance(0))"));
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Ayesha");
		driver.hideKeyboard();
		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		/*
		 * List<AndroidElement> addToCartEle =
		 * driver.findElementsByXPath("//*[@text='ADD TO CART']");
		 * addToCartEle.get(0).click(); addToCartEle.get(1).click();
		 */

		// driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		// driver.findElementsByXPath("//*[@text='ADD TO CART']").get(1).click();

		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();

		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<AndroidElement> priceEle = driver.findElementsById("com.androidsample.generalstore:id/productPrice");
		double actTotPrice = 0, price = 0;

		for (AndroidElement curEle : priceEle) {
			price = getAmount(curEle.getText());
			actTotPrice += price;
		}

		AndroidElement expTotalPriceEle = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl");

		double expTotPrice = getAmount(expTotalPriceEle.getText());

		Assert.assertEquals(expTotPrice, actTotPrice);

		AndroidElement checkBoxEle = driver.findElementByClassName("android.widget.CheckBox");
		TouchAction tActionObj = new TouchAction(driver);
		tActionObj.tap(tapOptions().withElement(element(checkBoxEle))).perform();

		AndroidElement termsEle = driver.findElementById("com.androidsample.generalstore:id/termsButton");
		tActionObj.longPress(longPressOptions().withElement(element(termsEle)).withDuration(ofSeconds(2))).release()
				.perform();

		AndroidElement termsTitleEle = driver.findElementById("com.androidsample.generalstore:id/alertTitle");
		Assert.assertEquals(termsTitleEle.getText(), "Terms Of Conditions");

		driver.findElementById("android:id/button1").click();
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		
		

	}

	public static double getAmount(String value) {
		value = value.substring(1).trim();
		return Double.parseDouble(value);
	}
}
