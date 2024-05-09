package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksTabPage {
	WebDriver driver;

	public TasksTabPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private String tasksTab = "container_tasks";

	public String tasksTab() {
		return tasksTab;
	}

//	private String addNewBtn = "//*[@id=\"taskManagementPage\"]/div[1]/div[1]/div[1]/div[1]/div[3]/div"; 
	private String addNewBtn = "//*[@id=\"taskManagementPage\"]/div[1]/div[1]/div[1]/div[1]/div[3]/div/div[1]";
	public String addNewBtn() {
		return addNewBtn;
	}

	private String newCustomerBtn = "/html/body/div[20]/div[1][@class='item createNewCustomer']";

	public String newCustomerBtn() {
		return newCustomerBtn;
	}

	private String enterCustomerNameTextBox = "//*[@id=\"customerLightBox_content\"]/div[2]/div[1]/div/div[1]/div[1]/input";

	public String enterCustomerNameTextBox() {
		return enterCustomerNameTextBox;
	}
	
	private String createCustomer = "//*[@id=\"customerLightBox_content\"]/div[3]/div[2]/div[1]/div/div[1]";
	public String createCustomer() {
		return createCustomer;
	}

	private String newProject = "/html/body/div[20]/div[2][@class='item createNewProject']";
	public String newProject() {
		return newProject;
	}
	
	private String enterProjectName = "//*[@id=\"createProjectPopup_content\"]/div[2]/div[1]/div/div[1]/div[1]/input";
	public String enterProjectName() {
		return enterProjectName;
	}
	
	private String taskName = "//*[@id=\"createProjectPopup_content\"]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div[1]/table/tbody/tr[1]/td[1]";
	public String taskName() {
		return taskName;
	}
	
	private String createProject = "//*[@id=\"createProjectPopup_content\"]/div[3]/div[2]/div[1]/div/div[1]";
	public String createProject() {
		return createProject;
	}
	
	private String createNewTasks = "/html/body/div[20]/div[3]";
	public String createNewTasks() {
		return createNewTasks;
	}
	
	private String enteringTaskName = "//*[@id=\"createTasksPopup_content\"]/div[1]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[1]/td[1]/input";
	public String enteringTaskName() {
		return enteringTaskName;
	}
	
	private String createTask = "//*[@id=\"createTasksPopup_content\"]/div[2]/div[2]/div[1]/div/div[1]";
	public String createTask() {
		return createTask;
	}
	
	private String searchCustomerName = "//*[@id=\"taskManagementPage\"]/div[1]/div[1]/div[1]/div[2]/div[1]/div/table/tbody/tr/td[1]/div/input";
	public String searchCustomerName() {
		return searchCustomerName;
	}
	
	private String customerName = "//*[@id=\"taskManagementPage\"]/div[1]/div[1]/div[2]/div/div[3]/div/div[1]/div[2]/div/div[3]/div[1]/span";
	public String customerName() {
		return customerName;
	}
	private String collapseButton = "//*[@id=\"taskManagementPage\"]/div[1]/div[1]/div[2]/div/div[3]/div/div[1]/div[2]/div[1]/div[1]";
	public String collapseButton() {
		return collapseButton;
	}
	
	private String viewCustomerProjects = "//*[@id=\"taskManagementPage\"]/div[1]/div[1]/div[2]/div/div[3]/div/div[1]/div[2]/div[2]/div[2]/div[2]";
	public String viewCustomerProjects() {
		return viewCustomerProjects;
	}
	
	private String customerProjectName = "//*[@id=\"taskManagementPage\"]/div[1]/div[1]/div[2]/div/div[3]/div/div[1]/div[2]/div[3]/div[2]/div[1]";
	public String customerProjectName() {
	return customerProjectName;
	}
	
}
