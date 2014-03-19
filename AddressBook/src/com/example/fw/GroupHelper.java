package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.Base;
import com.example.tests.GroupData;

public class GroupHelper extends HelperBase{

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void returnToGroupsPage() {
		click(By.linkText("group page"));
	}

	public void submitNewGroupCreation() {
		click(By.name("submit"));
	}

	public void fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.groupname);
		type(By.name("group_header"), group.header);
		type(By.name("group_footer"), group.footer);	    
	}

	public void initNewGroupCreation() {
		click(By.xpath("//input[@name='new']"));
	}

	public void deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
	}

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
	}

	public void submitGroupModification() {
		click(By.name("update"));
	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");
			group.groupname = title.substring("Select (".length(),title.length()-")".length());
			groups.add(group);
		}
		return groups;
	}
	
	public int chooseRandomGroup(List<GroupData> oldList) {
		Random  rnd = new Random();
	    int index = rnd.nextInt(oldList.size());
		return index;
	}

	public void quickGroupCreation(GroupData group) {
		initNewGroupCreation();
		fillGroupForm(group);
		submitNewGroupCreation();
		returnToGroupsPage();
		
	}

	

}
