package com.example.tests;

import java.util.Collections;
import java.util.List;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class NewGroupCreationTests extends Base{
  
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
	    app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().goToGroupsPage();
	    //save old
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    //actions
	    app.getGroupHelper().quickGroupCreation(group);
	    //app.getGroupHelper().fillGroupForm(group);
	    //app.getGroupHelper().submitNewGroupCreation();
	    //app.getGroupHelper().returnToGroupsPage();
	    //save new
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    //compare states
	    oldList.add(group);
	    Collections.sort(oldList);
	    AssertJUnit.assertEquals(newList, oldList);
	   }
	}

