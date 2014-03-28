package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupRemovalTests extends Base {
	
	@Test
	public void deleteSomeGroup() {
		//check existence
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
		 if(oldList.size()==0){
			GroupData group = new GroupData();
			app.getGroupHelper().createGroup(group);
		 }
		 else{
			 //...
		 }
		//save old
		oldList = app.getGroupHelper().getGroups();
		int index = app.getCommonHelper().chooseRandom(oldList);
		//actions
		app.getGroupHelper().deleteGroup(index);
		//save new
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
		//compare states
		assertThat(newList,equalTo(oldList.without(index)));
	
	}
}
