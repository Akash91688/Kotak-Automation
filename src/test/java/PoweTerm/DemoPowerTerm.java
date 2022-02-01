package PoweTerm;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class DemoPowerTerm 

{
	public static WindowsDriver driver = null;

	@BeforeMethod
	public void SetUp() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "\"C:\\Program Files (x86)\\Ericom Software\\PowerTerm\\ptw32.exe\"");

		cap.setCapability("platform", "Windows");
		cap.setCapability("deviceName", "WindowsPC");
		try {
			driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
		} catch (MalformedURLException e) 
		{

			e.printStackTrace();
		}
	}

	@Test
	public void EnterHostName()
	{
		
		driver.findElementByName("TELNET").click();
		System.out.println("Enter Host name");
		driver.findElementByClassName("Edit").sendKeys("Demo1");
		driver.findElementByName("Save As...").click();
        System.out.println("Host Name Saved");
		driver.findElementByName("OK").click();
		driver.findElementByName("Close").click();


	}
	
    @AfterMethod
public void TearDown()
{
	driver.quit();
}

}




