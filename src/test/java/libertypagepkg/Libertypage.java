package libertypagepkg;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Libertypage {
	WebDriver driver;
	By women=By.xpath("//*[@id=\"store.menu\"]/nav[2]/ul/li[2]/a");
	By casual=By.xpath("//*[@id=\"store.menu\"]/nav[2]/ul/li[2]/ul/li/ul[1]/li[3]/a");
	By sort=By.xpath("//*[@id=\"sorter\"]");
	By viewcart=By.xpath("//*[@id=\"layer-product-list\"]/div[5]/ol/li[4]/div/div[2]/div/div/div[1]/a");
	
	By color=By.xpath("//*[@id=\"product_addtocart_form\"]/div[2]/div/ul/li/a/img");
	By size=By.xpath("//*[@id=\"option-label-eng_size-249-item-709\"]");
	
	By shoe=By.xpath("//*[@id=\"layer-product-list\"]/div[5]/ol/li[4]/div/a/img");
	By qty=By.xpath("//*[@id=\"product_addtocart_form\"]/div[2]/span/span/div/div/div[1]/div/input[3]");
	By pin=By.xpath("//*[@id=\"codvalue\"]");
	By check=By.id("cod_pinchck_btn");
	By checkout=By.xpath("//span[contains(text(),'Add to Cart')]");
	By proceed=By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[4]/div/ul/li/button");
	By register=By.xpath("//*[@id=\"checkout-step-title\"]/div[1]/div/div/div[3]/div[3]/form/div[4]/a/span");

	 
	By email1=By.xpath("//body/main[@id='maincontent']/div[2]/div[1]/div[4]/div[3]/ol[1]/li[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[3]/div[1]/input[1]");
	By pass=By.xpath("//body/main[@id='maincontent']/div[2]/div[1]/div[4]/div[3]/ol[1]/li[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[4]/div[1]/input[1]");
	By submit=By.xpath("//body/main[@id='maincontent']/div[2]/div[1]/div[4]/div[3]/ol[1]/li[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[1]/button[1]");
	
	By street=By.xpath("//input[@name=\"street[0]\"]");
	By city=By.xpath("//input[@name=\"city\"]");
	By state=By.xpath("//select[@name=\"region_id\"]");
	By zip=By.xpath("//input[@name=\"postcode\"]");
	By phone=By.xpath("//input[@name=\"telephone\"]");
	
	
	By loginmail=By.xpath("//*[@id=\"login-email\"]");
	By loginpass=By.xpath("//*[@id=\"login-password\"]");
	By login=By.xpath("//body/main[@id='maincontent']/div[2]/div[1]/div[4]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[3]/form[1]/div[2]/div[1]/button[1]");
	By next=By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button");
	
	
	By paytm=By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[4]/div[1]/label");
	By modify=By.xpath("//a[contains(text(),'Modify Cart')]");
	By account=By.xpath("/html/body/div[1]/header/div[2]/div[2]/div/div[1]/ul/li/a");
	By logout=By.xpath("/html/body/div[1]/header/div[2]/div[2]/div/div[1]/ul/li/div/div/a[4]");
	
	public Libertypage(WebDriver driver)
	{
		this.driver=driver;
	}  
	 
	 public void validations()
	 {
		 String url1=driver.getCurrentUrl();
		 if(url1.equals("https://www.libertyshoesonline.com/"))
		 {
			 System.out.println("Url Verified");
		 }
		 else
		 {
			 System.out.println("Url error");
		 }
		 String title=driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals(title, "Buy Footwear Online from the Most Trusted Indian Brand");
		 System.out.println("Title Verified");
	 }
	 
	public void selection() throws Exception
	{
		 WebElement ele = driver.findElement(women);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(casual));
		driver.findElement(casual).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)","");
		driver.findElement(sort).click();
		
		WebElement sort1 = driver.findElement(sort);
		Select sort1obj=new Select(sort1);
		sort1obj.selectByVisibleText(" Popularity");
		
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,600)","");
		
		WebElement shoe1 = driver.findElement(shoe);
		File src2=shoe1.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src2,new File("./screenshot//Elementsrc.png"));
		
		WebElement viewcart1 = driver.findElement(viewcart);
		Actions act1=new Actions(driver);
		act1.moveToElement(viewcart1).perform();
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(viewcart));
		driver.findElement(viewcart).click();
	}
	public void shopping(String pin1) throws Exception
	{
		
		File src1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src1,new File("./screenshot//fullsrc.png"));
		
		driver.findElement(color).click();
		driver.findElement(size).click();
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("window.scrollBy(0,400)", "");
		
		
		
		driver.findElement(qty).click();
		driver.findElement(pin).sendKeys(pin1);
		driver.findElement(check).click();
		driver.findElement(checkout).click();
		
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(30));
		w.until(ExpectedConditions.visibilityOfElementLocated(proceed));
		driver.findElement(proceed).click();
	}
	public void register() throws IOException
	{
		 
		String s="D:\\libertyvalue.xlsx";
		File f=new File(s);
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("sheet1");
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			
			String emailid=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Email id:: "+emailid);
			String pswd=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Password:: "+pswd);
			
			 
			driver.findElement(loginmail).sendKeys(emailid);
			driver.findElement(loginpass).sendKeys(pswd);
			driver.findElement(login).click();
			}
		}
	
	public static String getCellValue(String s1, String sheet,int r, int c)
	{
		try
		{
		
			File f1=new File(s1);
			FileInputStream fi1=new FileInputStream(f1);
			XSSFWorkbook wb1=new XSSFWorkbook(fi1);
			 
		
		XSSFCell cell=(XSSFCell) wb1.getSheet(sheet).getRow(r).getCell(c);
			if(cell.getCellType()==CellType.STRING)
			{
				return cell.getStringCellValue();
			}
			else		
			{
				return(cell.getRawValue());
			}
		}
		catch(Exception e)
		{
			return "";
		}
	
	}	 
		public void addaddress()throws IOException
		{
			String s1="D:\\libertyvalue1.xlsx"; 
			File f1=new File(s1);
			String sheet="sheet1";
			FileInputStream fi1=new FileInputStream(f1);
			XSSFWorkbook wb1=new XSSFWorkbook(fi1);
			XSSFSheet sh1=wb1.getSheet("Sheet1");
			for(int j=1;j<=sh1.getLastRowNum();j++)
			{
				String street1=getCellValue(s1,sheet,j,0);
				System.out.println("Street:: "+street1);
				String zip1=getCellValue(s1,sheet,j,2);
				System.out.println("Zipcode:: "+zip1);
				String phone1=getCellValue(s1,sheet,j,3);
				System.out.println("Phone:: "+phone1);
				
				WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(30));
				wait2.until(ExpectedConditions.visibilityOfElementLocated(street));
				
				driver.findElement(street).sendKeys(street1);	
				WebElement state1 = driver.findElement(state);
				Select state2=new Select(state1);
				state2.selectByValue("545");
				driver.findElement(zip).sendKeys(zip1);
				driver.findElement(phone).sendKeys(phone1);
				driver.findElement(next).click(); 
				}
			
		}
			
		public void payment(String num,String exp1, String cvc1) throws InterruptedException	
		{
			Thread.sleep(10000);
			driver.findElement(modify).click();
			WebElement el3 = driver.findElement(account);
			Actions act2=new Actions(driver);
			act2.moveToElement(el3).perform();
			driver.findElement(logout).click();
		}
			
	}
	
		
		 
	
	 
	 


