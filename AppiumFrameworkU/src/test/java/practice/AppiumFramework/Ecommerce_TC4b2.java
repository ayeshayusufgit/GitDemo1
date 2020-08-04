package practice.AppiumFramework;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import practice.AppiumFramework.pageObjects.CheckoutPage;
import practice.AppiumFramework.pageObjects.FormPage;
import practice.AppiumFramework.pageObjects.ProductListingsPage;

import java.io.IOException;

//appium/java-client
public class Ecommerce_TC4b2 extends TestBase {

	@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	public void totalValidation(String name,String gender,String country) throws IOException {
		
		AppiumDriverLocalService server=startServer();
		AndroidDriver<AndroidElement> driver = Ecommerce_TC4b2.InstallInvokeAPK();
		
		FormPage fPage = new FormPage(driver);

		// driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Ayesha");
		// fPage.nameTB.sendKeys("Ayesha");
		fPage.getNameTB().sendKeys(name);
		driver.hideKeyboard();

		// driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		// fPage.femaleRB.click();
		//fPage.getGenderRB("Female").click();
		fPage.getGenderRB(gender).click();

		// driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		fPage.getCountryDD().click();

		Utilities utilObj = new Utilities(driver);
		utilObj.scrollToText(country);
		fPage.getCountryfromDD(country).click();
		
		//Assert.assertTrue(false);

		// driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		// fPage.letsShopBTN.click();
		fPage.getLetsShopBTN().click();

		/*
		 * List<AndroidElement> addToCartEle =
		 * driver.findElementsByXPath("//*[@text='ADD TO CART']");
		 * addToCartEle.get(0).click(); addToCartEle.get(1).click();
		 */

		// driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		// driver.findElementsByXPath("//*[@text='ADD TO CART']").get(1).click();

		ProductListingsPage plObj = new ProductListingsPage(driver);
		// driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		// plObj.addToCartBTN.get(0).click();
		plObj.getAddToCartBTNs().get(0).click();

		// driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		// plObj.addToCartBTN.get(0).click();
		plObj.getAddToCartBTNs().get(0).click();

		// driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		// plObj.cartBTN.click();
		plObj.getCartBTN().click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CheckoutPage cObj = new CheckoutPage(driver);

		// List<AndroidElement> priceEle =
		// driver.findElementsById("com.androidsample.generalstore:id/productPrice");
		int count = cObj.getProductPriceList().size();

		double actTotPrice = 0, curPrice = 0;

		for (int i = 0; i < count; i++) {
			String curPriceStr = cObj.getProductPriceList().get(i).getText();
			curPrice = getAmount(curPriceStr);
			actTotPrice += curPrice;
		}

		double expTotPrice = getAmount(cObj.getProductPriceTotal().getText());

		Assert.assertEquals(expTotPrice, actTotPrice);

		cObj.getProceedBTN().click();
		server.stop();

	}
	
	@BeforeTest
	public void cleanProject() {
		killAllProcess();
	}

	public static double getAmount(String value) {
		value = value.substring(1).trim();
		return Double.parseDouble(value);
	}
}
