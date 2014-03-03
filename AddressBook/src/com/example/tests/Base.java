package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Base {

	private static WebDriver driver;
	private static String baseUrl;
	private static boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();


	//метод инициации
	@BeforeTest 
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
	//метод завершения
	@AfterTest 
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	
	
	//from NewGroupCreation
	protected void returnToGroupsPage() {
		driver.findElement(By.linkText("group page")).click();
	}

	//from NewGroupCreation
	protected void submitNewGroupCreation() {
		driver.findElement(By.name("submit")).click();
	}

	//from NewGroupCreation
	protected void fillGroupForm(GroupData group) {
		driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.groupname);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	//from NewGroupCreation
	protected void initNewGroupCreation() {
		driver.findElement(By.name("new")).click();
	}

	//from NewGroupCreation
	protected void goToGroupsPage() {
		driver.findElement(By.linkText("groups")).click();
	}

	//from NewGroupCreation & NewContactCreation
	protected void openMainPage() {
		driver.get(baseUrl + "/addressbookv4.1.4/");
	}

	



	//from NewContactCreation
	protected void goToHomePage() {
		driver.findElement(By.linkText("home page")).click();
	}
	
	//from NewContactCreation
	protected void addNext() {
		driver.findElement(By.linkText("add next")).click();
	}


	//from NewContactCreation
	protected void submitNewContactCreation() {
		driver.findElement(By.name("submit")).click();
	}

	//from NewContactCreation
	protected void fillContactForm(ContactData contact) {
		driver.findElement(By.name("firstname")).clear();
	    driver.findElement(By.name("firstname")).sendKeys(contact.firstName);
	    driver.findElement(By.name("lastname")).clear();
	    driver.findElement(By.name("lastname")).sendKeys(contact.secondName);
	    driver.findElement(By.name("address")).clear();
	    driver.findElement(By.name("address")).sendKeys(contact.mainAddress);
	    driver.findElement(By.name("home")).clear();
	    driver.findElement(By.name("home")).sendKeys(contact.hPhone);
	    driver.findElement(By.name("mobile")).clear();
	    driver.findElement(By.name("mobile")).sendKeys(contact.mPhone);
	    driver.findElement(By.name("work")).clear();
	    driver.findElement(By.name("work")).sendKeys(contact.wPhone);
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys(contact.email1);
	    driver.findElement(By.name("email2")).clear();
	    driver.findElement(By.name("email2")).sendKeys(contact.email2);
	    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contact.bDay);
	    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.bMonth);
	    driver.findElement(By.name("byear")).clear();
	    driver.findElement(By.name("byear")).sendKeys(contact.bYear);
	    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contact.groupName);
	    driver.findElement(By.name("address2")).clear();
	    driver.findElement(By.name("address2")).sendKeys(contact.supAddress);
	    driver.findElement(By.name("phone2")).clear();
	    driver.findElement(By.name("phone2")).sendKeys(contact.supPhone);
	}

	//from NewContactCreation
	protected void initNewContactCreation() {
		driver.findElement(By.linkText("add new")).click();
	}


	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
