package test;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjects.LogInPage;
import pageObjects.TasksTabPage;
import resources.BaseActi;
import resources.ElementSelector;
import resources.SendKeysToElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonTest extends BaseActi {
	public WebDriver driver;

	/*
	 * author: Shiva Yadv G , Email : shiva.yadav@relanto.ai - Login to Actitime
	 * application
	 */
	@Test
	public void LoginActiTest() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		String emailValue = prop.getProperty("email");
		String passwordValue = prop.getProperty("passwd");
		ElementSelector ElementSelector = new ElementSelector(driver);
		SendKeysToElement SendKeysToElement = new SendKeysToElement(driver);
		LogInPage LogInPage = new LogInPage(driver);
		
		// Log in
		SendKeysToElement.snedKeysToElementById(LogInPage.userName(), prop.getProperty("userName"));
		SendKeysToElement.sendKeysToElementByXpath(LogInPage.password(), prop.getProperty("password"));
		ElementSelector.clickById(LogInPage.logInButton());

		// opening Tasks tab
		TasksTabPage TasksTabPage = new TasksTabPage(driver);
		ElementSelector.clickById(TasksTabPage.tasksTab());
		String ViewTimeTrackPageTabURL = driver.getCurrentUrl();
		Assert.assertEquals(ViewTimeTrackPageTabURL, "https://online.actitime.com/relanto/tasks/tasklist.do");

		
		// creating new customer
		ElementSelector.clickByxpath(TasksTabPage.addNewBtn());
		ElementSelector.clickByxpath(TasksTabPage.newCustomerBtn());
		String customerName = prop.getProperty("customerName");
		SendKeysToElement.sendKeysToElementByXpath(TasksTabPage.enterCustomerNameTextBox(), customerName);
		Actions actions = new Actions(driver);
//		actions.moveToElement(driver.findElement(By.xpath(TasksTabPage.createCustomer()))).perform();
//		ElementSelector.clickByxpath(TasksTabPage.createCustomer());
		log.debug("Clicked on create customer button");
//		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(TasksTabPage.createCustomer())));
		
		// Creating projct
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(TasksTabPage.addNewBtn()))));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(TasksTabPage.createCustomer())));
		ElementSelector.clickByxpath(TasksTabPage.addNewBtn());
		log.debug("Clicked on add new button again");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(TasksTabPage.newProject()))));
		ElementSelector.clickByxpath(TasksTabPage.newProject());
		log.debug("clicked on new project");
		SendKeysToElement.sendKeysToElementByXpath(TasksTabPage.enterProjectName(), prop.getProperty("projectName"));
		log.debug("Entered project name");
		actions.moveToElement(driver.findElement(By.xpath(TasksTabPage.createProject()))).perform(); // using move to element bcz element is clickInterceptedException
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(TasksTabPage.createProject()))));
		ElementSelector.clickByxpath(TasksTabPage.createProject());
		log.debug("Clicked on create customer button");
		
		
		// creating new task
		actions.moveToElement(driver.findElement(By.xpath(TasksTabPage.addNewBtn()))).perform(); // using move to element bcz element is clickInterceptedException
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(TasksTabPage.addNewBtn()))));
		ElementSelector.clickByxpath(TasksTabPage.addNewBtn());
		log.debug("Clicked on add new button to create new task");
		ElementSelector.clickByxpath(TasksTabPage.createNewTasks());
		log.debug("Clicked on create new task");
		SendKeysToElement.sendKeysToElementByXpath(TasksTabPage.enteringTaskName(), prop.getProperty("taskName"));
		log.debug("Entered Task name");
		ElementSelector.clickByxpath(TasksTabPage.createTask());
		log.debug("Clicked on create task");
		
		// Verification 
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(TasksTabPage.searchCustomerName()))));
		SendKeysToElement.sendKeysToElementByXpath(TasksTabPage.searchCustomerName(), prop.getProperty("customerName"));
		log.debug("Searched customer name");
		String customerNameAfterSearching = driver.findElement(By.xpath(TasksTabPage.customerName())).getText();
		log.debug("Found the customer name that is : " + customerNameAfterSearching );
		Assert.assertEquals(customerNameAfterSearching, prop.getProperty("customerName"));
		log.debug("Assertion of customer name");
		if(!driver.findElement(By.xpath(TasksTabPage.collapseButton())).isDisplayed()) {
		ElementSelector.clickByxpath(TasksTabPage.collapseButton());
		log.debug("Clicked on collapse button to see the customer projects");
		}
		ElementSelector.clickByxpath(TasksTabPage.viewCustomerProjects());
		log.debug("Clicked on customer view customer projects");
		String customerProjectName = driver.findElement(By.xpath(TasksTabPage.customerProjectName())).getText();
		log.debug("Found the project that is : " + customerProjectName );
		Assert.assertEquals(customerProjectName, prop.getProperty("projectName"));
		log.debug("Assertion of project name");
	}

	@BeforeSuite
	public void launching() throws IOException {

		log = LogManager.getLogger(CommonTest.class.getName());
		driver = initializeActiBrowser();
		log.debug("----------------------------------------------------");
		log.debug("Browser initialized");
		driver.get(prop.getProperty("URL"));
		log.debug("Web Applicaton  launched");

	}

	@AfterSuite
	public void closure() {
		driver.close();
		log.debug("Web Application closed");
		log.debug("----------------------------------------------------");

	}

}
