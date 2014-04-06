package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
		if(!onMainPage()){			
			click(By.linkText("home"));
		}		
	}

	public void groupsPage() {
		if(!onGroupsPage()){
			click(By.linkText("groups"));
		}	
	}
	
	public void phonePage() {
		if(!onPhonePage()){
			click(By.linkText("print phones"));
		}
	}

	private boolean onPhonePage() {
		if(driver.getCurrentUrl().contains("all&print&phones")){
			return true;
		}
		else {
			return false;
		}
	}

	private boolean onGroupsPage() {
		if(driver.getCurrentUrl().contains("/group.php")
			&& driver.findElements(By.name("new")).size()>0) {
				return true;
		}
		else {
			return false;
		}		
	}
	
	private boolean onMainPage() {
		return driver.findElements(By.id("maintable")).size()>0;
	}


}
