package com.example.tests;

import org.testng.annotations.Test;


public class TheSecondNewGroupCreation extends Base {

  @Test
  public void newGroup() throws Exception {
    openMainPage();
    goToGroupsPage();
    initNewGroupCreation();
    GroupData group = new GroupData();
    group.groupname="Gulirina_Group";
    group.header="gulirina's_header";
    group.footer="gulirina's_footer";
	fillGroupForm(group);
    submitNewGroupCreation();
    returnToGroupsPage();
  }
  
  @Test
  public void newEmptyGroup() throws Exception {
    openMainPage();
    goToGroupsPage();
    initNewGroupCreation();
    GroupData group = new GroupData("", "", "");
	fillGroupForm(group);
    submitNewGroupCreation();
    returnToGroupsPage();
  }

}

