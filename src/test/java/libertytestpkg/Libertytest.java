package libertytestpkg;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import libertypagepkg.Libertypage; 

public class Libertytest {
	org.openqa.selenium.WebDriver driver;
	@BeforeTest
	public void setup()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("----disable-notifications");
		driver=new ChromeDriver(options);
	}
	@BeforeMethod
	public void urlload()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.libertyshoesonline.com/");
	}
	@Test
	public void test1() throws Exception
	{
		Libertypage obj=new Libertypage(driver);
		obj.validations();
		obj.selection();
		obj.shopping("132103");
		obj.register();
		obj.addaddress();
		obj.payment("3456123456789234","0325","927");
	}
}
