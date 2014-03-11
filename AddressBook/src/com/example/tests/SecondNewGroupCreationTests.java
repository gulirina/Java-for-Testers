package com.example.tests;

import org.testng.annotations.Test;



public class SecondNewGroupCreationTests extends Base{
  @Test
  public void testNewGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().goToGroupsPage();
    app.getGroupHelper().initNewGroupCreation();
    GroupData group = new GroupData();
    group.groupname="Gulirina_Group";
    group.header="Gulirina_header";
    group.footer="Gulirina_footer";
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitNewGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
  }
  
@Test
  public void testNewEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().goToGroupsPage();
	app.getGroupHelper().initNewGroupCreation();
    GroupData group = new GroupData(" "," "," ");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitNewGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
  }
}

