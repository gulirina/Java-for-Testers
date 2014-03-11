package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends Base{
	
	@Test
	public void ModifySomeGroup() {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToGroupsPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData group = new GroupData();
		group.groupname = "Guliaeva Irene";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupsPage();
	}

}
