package practice.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {
	
	//Adding new comment for develop branch code1(TestData)
	//Adding new comment for develop branch code2(TestData)

	//adding comment for data provider
	@DataProvider(name = "InputData")
	public Object[][] getDataforEditField() {
		// 2 sets of data, "hello" , "!@#$$"
		Object[][] obj = new Object[][] {

				{ "Ayesha", "Female", "India" }, { "Abu", "Male", "Bahrain" } };

		return obj;

	}

}
