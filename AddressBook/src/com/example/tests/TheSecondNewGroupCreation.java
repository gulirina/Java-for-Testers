package com.example.tests;

import org.testng.annotations.Test;



public class TheSecondNewGroupCreation extends Base{
  @Test
  public void newGroup() throws Exception {
    openMainPage();
    goToGroupsPage();
    initNewGroupCreation();
    GroupData group = new GroupData();
    group.groupname="Gulirina_Group";
    group.header="Gulirina_header";
    group.footer="Gulirina_footer";
	fillGroupForm(group);
    submitNewGroupCreation();
    returnToGroupsPage();
  }
  
 /* @Test
  public void newEmptyGroup() throws Exception {
    openMainPage();
    goToGroupsPage();
    initNewGroupCreation();
    GroupData group = new GroupData("", "", "");
	fillGroupForm(group);
    submitNewGroupCreation();
    returnToGroupsPage();
  }*/
}

