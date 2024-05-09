package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementSelector extends BaseActi{
	
	static WebDriver driver= null;
	public ElementSelector(WebDriver driver) {
		this.driver= driver;
	}
	
	public static void clickByxpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
		
	}
	
	public static void clickById(String id) {
		driver.findElement(By.id(id)).click();
		
	}
	
	public static void clickByLinkText(String LinkText) {
		driver.findElement(By.id(LinkText)).click();
		
	}
	
//	public static void javascriptClickByXpath(String xpath) {
//		JavascriptExecutor js = new JavaScriptExecutor(driver);
//	}
//	
}

