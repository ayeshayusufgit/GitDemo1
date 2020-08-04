package practice.AppiumFramework.pageObjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage {

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<AndroidElement> productPriceList;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private AndroidElement totalAmount;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private AndroidElement proceedBTN;

	public CheckoutPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public List<AndroidElement> getProductPriceList(){
		return productPriceList;
	}
	
	public AndroidElement getProductPriceTotal(){
		return totalAmount;
	}
	
	public AndroidElement getProceedBTN(){
		return proceedBTN;
	}
	
	
}
