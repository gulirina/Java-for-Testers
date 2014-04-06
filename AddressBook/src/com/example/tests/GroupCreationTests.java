package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupCreationTests extends Base{
  
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
	    //save old
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    //actions
	    app.getGroupHelper().createGroup(group);
	    //save new
	    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    //compare states
	    assertThat(newList, equalTo(oldList.withAdded(group)));
	   }
	}

