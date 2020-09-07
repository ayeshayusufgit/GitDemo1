package practice.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

//Adding 1st comment to this file
//Adding 2nd comment to this file
//Adding 3rd comment to this file
//Adding 4th comment to this file
//Adding 5th comment to this file
//Adding 6th comment to this file
//Adding 7th comment to this file
//Adding for the 2nd person(clone directory)
//Adding 2nd comment for the 2nd person(clone directory)TestBase
//Adding 3rd comment for the 2nd person(clone directory)TestBase
//Adding 4th comment for the 2nd person(clone directory)TestBase

public class TestBase {
	public static AppiumDriverLocalService service;
	private static AndroidDriver<AndroidElement> driver;

	public void testDemo1() {
		System.out.println("Demo1");
	}

	public void testDemo2() {
		System.out.println("Demo2");
	}

	public static void startEmulator() {
		try {
			Runtime.getRuntime().exec("./src/main/java/resources/startEmulator.bat");
			// Runtime.getRuntime().exec("./src/main/java/resources/test.bat");

			// Runtime.getRuntime().exec("cmd /c
			// \"E:\\java_workspace\\AppiumFrameworkU\\src\\main\\java\\resources\\test.bat\"");
			System.out.println("Run bat file");
			Thread.sleep(10000);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public AppiumDriverLocalService startServer() {
		boolean flag = checkIfServerIsRunning(4723);
		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}

	public static boolean checkIfServerIsRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;

		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static AndroidDriver<AndroidElement> InstallInvokeAPK() throws IOException {

		// FileInputStream fis=new
		// FileInputStream(System.getProperty("usr.dir")+"\\src\\main\\java\\practice\\AppiumFramework\\global.properties");
		FileInputStream fis = new FileInputStream(".\\src\\main\\java\\practice\\AppiumFramework\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);

		// Define the source folder
		File f1 = new File("src");

		// Define the destination and name of the APK file
		File f2 = new File(f1, (String) prop.get("GeneralStoreApp"));

		// COnfiguration setting to work with the application
		DesiredCapabilities cap = new DesiredCapabilities();

		// String device = (String) prop.get("device");
		String device = System.getProperty("deviceName");
		System.out.println(device);

		/*
		 * if (device.contains("Emulator")) { startEmulator(); }
		 */

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		// cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		// cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3_XL_API_28_2");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		// Define the maximum timeout period to execute command
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
		cap.setCapability(MobileCapabilityType.APP, f2.getAbsolutePath());

		// Use the Android Driver to work with Android Platform Elements
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

		return driver;
	}

	public static void getScreenShot(String testName) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("./screenshots/" + testName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void killAllProcess() {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Thread.sleep(10000);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
