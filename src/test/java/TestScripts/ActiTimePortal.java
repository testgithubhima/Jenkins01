package TestScripts;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ActiTimePortal {

	@Test
	public void loginportal() throws Throwable {
		String key = "webdriver.chrome.driver";
		String value = "./src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream("./PropertyFileData.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);	
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");	
		driver.get(URL);	
		driver.findElement(By.id("username")).sendKeys(USERNAME); 
		driver.findElement(By.name("pwd")).sendKeys(PASSWORD); 
		driver.findElement(By.xpath("//div[text()='Login ']")).click(); 
	}
}
