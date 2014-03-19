package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTests extends Base{
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToGroupsPage();
		
		//check existence
		 List<GroupData> oldList = app.getGroupHelper().getGroups();
		 if(oldList.size()==0){
			 app.getGroupHelper().quickGroupCreation(group);
		 }
		 else{
			 //...
		 }
		//save old
	    oldList = app.getGroupHelper().getGroups();
		int index = app.getGroupHelper().chooseRandomGroup(oldList);
		//action	    
		app.getGroupHelper().initGroupModification(index);
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupsPage();
		//save new
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    //compare states
	    oldList.remove(index);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}
