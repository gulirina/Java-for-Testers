package com.example.fw;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.netbeans.jemmy.ClassReference;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class ApplicationManager {
	
	public  WebDriver driver;
	public  String baseUrl;
	private Properties properties;
	private FolderHelper folderHelper;
	
	
	public ApplicationManager(Properties properties) {
		this.properties = properties;
		String browser = properties.getProperty("browser");
		if("firefox".equals(browser)){
			driver = new FirefoxDriver();
		} else if ("chrome".equals(browser)){
			driver = new ChromeDriver();
		} else{
			throw new Error("Unsupported browser: "+browser);
		}
		
	    baseUrl = properties.getProperty("baseUrl");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl);
	}
	
	public void stop() {
		driver.quit();	   	
	}

	public FolderHelper getFolderHelper() {
		if(folderHelper == null){
			folderHelper = new FolderHelper(this);
		}
		return folderHelper;
	}

	public void getApplication() {
		try {
			new ClassReference("addressbook.AddressBookFrame").startApplication();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
