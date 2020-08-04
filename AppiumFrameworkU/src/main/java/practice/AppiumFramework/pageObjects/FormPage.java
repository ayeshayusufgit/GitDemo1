package practice.AppiumFramework.pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	private AndroidDriver<AndroidElement> driver;

	public FormPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "android:id/text1")
	private AndroidElement countryDD;

	@AndroidFindBy(xpath = "//*[@text='Argentina']")
	public AndroidElement argentinaOption;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private AndroidElement nameTB;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private AndroidElement femaleRB;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private AndroidElement letsShopBTN;

	public AndroidElement getNameTB() {
		System.out.println("Finding the Name TB");
		return nameTB;
	}

	public AndroidElement getGenderRB(String gender) {
		System.out.println("Finding the Gender RB");
		return driver.findElementByXPath("//android.widget.RadioButton[@text='"+gender+"']");
	}

	public AndroidElement getCountryDD() {
		System.out.println("Finding the Country DD");
		return countryDD;
	}
	
	public AndroidElement getCountryfromDD(String countryName) {
		return driver.findElementByXPath("//android.widget.TextView[@text='"+countryName+"']");
	}

	public AndroidElement getLetsShopBTN() {
		System.out.println("Tap on LetsShop BTN");
		return letsShopBTN;
	}

}
