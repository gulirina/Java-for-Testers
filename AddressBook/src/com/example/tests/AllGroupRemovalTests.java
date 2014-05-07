package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class AllGroupRemovalTests extends Base{
	
	@Test
	public void removeAllGroups() {
		//check existence
		SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();
		if(oldList.size()==0){
			//...
		}
		else{
			do {
				//save old
				oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
				int index = app.getCommonHelper().chooseRandom(oldList);
				//actions
				app.getGroupHelper().deleteGroup(index);//or we can use a constant
				//save new
				SortedListOf<GroupData> newList = app.getGroupHelper().getUiGroups();
				//compare states
				assertThat(newList, equalTo(oldList.without(index)));	
				oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
			} while(oldList.size()>0);
		}		
	}
}
