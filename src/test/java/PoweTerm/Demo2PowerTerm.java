package PoweTerm;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.windows.WindowsDriver;

public class Demo2PowerTerm 
{
 public static WindowsDriver driver = null;

	@BeforeMethod
	public void SetUp() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "\"C:\\Program Files (x86)\\Ericom Software\\PowerTerm\\ptw32.exe\"");

//		cap.setCapability("platform", "Windows");
//		cap.setCapability("deviceName", "WindowsPC");
		try {
			driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	}

@Test(priority=2)
public void ShowPowerTermTitle()
{
	
	
	
	String title = driver.getTitle();
	if(title.contains("(A) TELNET () : PowerTerm InterConnect Demo")){
		System.out.println("Connecting.....");
	}
	else{
		System.out.println("Not Connecting.....");
	}
	driver.findElementByName("Close").click();
	System.out.println("close the application");
}
	
	

	
	
	@Test(priority = 1)
	public void LaunchApplication() throws InterruptedException
	{
		System.out.println("Connet POPUP");
		driver.findElementByName("Close").click();
		System.out.println("Connect POPUP Status: OK");
		System.out.println("Process On File");
		driver.findElementByName("Terminal").click();
		driver.findElementByName("Setup...").click();
		
		System.out.println("check RadioButton active or not:If Active Then Status:TRue");
	
		
		boolean b = driver.findElementByName("WYSE 50").isSelected();
		System.out.println(b);
		
		
		driver.findElementByName("OK").click();
		System.out.println("close the application");
		driver.findElementByName("Close").click();


	}
	
	@AfterMethod
	public void CleanUp() 
	{
		driver.quit();
	}
}
