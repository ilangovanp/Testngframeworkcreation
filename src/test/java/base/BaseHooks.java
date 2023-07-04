package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseHooks  {
	
	public static  WebDriver driver;
	public static Properties p;

	public static  void loadpropertyfile() throws IOException {
		File f= new File("C:\\Users\\Ilangovan\\Music\\TTestngframework\\src\\test\\java\\base\\config.properties");
		FileReader fr= new FileReader(f);
		//System.out.println(f.exists());
	    p = new Properties();
		p.load(fr);
			
		
	}
	public static String Readpropertyfile(String key) throws IOException {
		BaseHooks.loadpropertyfile();
		return p.getProperty(key);
		
	}
	
	
	
	
	
	
	

	
	
	   @BeforeTest
	   public void browseropening() throws IOException {
		   
		   String browsername=BaseHooks.Readpropertyfile("browser");
		 if (browsername.equalsIgnoreCase("Chrome")) {
		    WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
		    driver = new ChromeDriver(options);
		 }else if(browsername.equalsIgnoreCase("firefox")){
		
		
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		 }
		 else if(browsername.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver= new EdgeDriver();
		 
		   }
				driver.get(Readpropertyfile("url"));
				driver.manage().window().maximize();	
			
			
		   
	   }
	   @AfterTest
		public void teardown() {
			driver.quit();
			}
	
	@AfterMethod
	public static void failurescreenshot(ITestResult result) throws IOException {
		
		if(!result.isSuccess()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest= new File("C:\\Users\\Ilangovan\\Music\\TTestngframework\\Screenshot\\"+result.getName()+".png");
		    FileUtils.copyFile(src, dest);
				
		}
		
		
		
		
		
	}
	
	
	
	
	

}
