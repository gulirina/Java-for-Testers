package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class NewGroupCreationTests extends Base{
  
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
	    //save old
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    //actions
	    app.getGroupHelper().createGroup(group);
	    //save new
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    //compare states
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	   }
	}

