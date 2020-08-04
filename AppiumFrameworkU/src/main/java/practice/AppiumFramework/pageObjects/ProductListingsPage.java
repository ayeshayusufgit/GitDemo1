package practice.AppiumFramework.pageObjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductListingsPage {
	
	@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
	private List<AndroidElement> addToCartBTN;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private AndroidElement cartBTN;
	
	
	public ProductListingsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public List<AndroidElement> getAddToCartBTNs() {
		System.out.println("Finding List of  Add To Cart BTNs");
		return addToCartBTN;
	}
	
	public AndroidElement getCartBTN() {
		System.out.println("Finding Cart BTN");
		return cartBTN;
	} 
}
