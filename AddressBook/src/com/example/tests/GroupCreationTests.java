package com.example.tests;


import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import com.example.utils.SortedListOf;

public class GroupCreationTests extends Base{
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		//return wrapGroupForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
		return wrapGroupForDataProvider(loadGroupsFromCsvFile(new File("groups.txt"))).iterator();
	}	
  
	@Test(dataProvider = "groupsFromFile")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
	    //save old
		SortedListOf<GroupData> oldList = new  SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
	    //actions
	    app.getGroupHelper().createGroup(group);
	    //save new
	    SortedListOf<GroupData> newList = new  SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
	    //compare states
	    assertThat(newList, equalTo(oldList.withAdded(group)));
	   }
	}

