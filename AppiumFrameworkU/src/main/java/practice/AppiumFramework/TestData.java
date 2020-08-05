package practice.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {

	//adding comment for data provider
	@DataProvider(name = "InputData")
	public Object[][] getDataforEditField() {
		// 2 sets of data, "hello" , "!@#$$"
		Object[][] obj = new Object[][] {

				{ "Ayesha", "Female", "India" }, { "Abu", "Male", "Bahrain" } };

		return obj;

	}

}
