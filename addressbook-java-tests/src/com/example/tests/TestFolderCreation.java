package com.example.tests;

import java.util.List;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class TestFolderCreation extends Base {

	@Test
	public void testFolderCreation() {
		String folder = "newfolder";
		Folders oldFolders = app.getFolderHelper().getFolders();
		app.getFolderHelper().createFolder(folder);
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders,equalTo(oldFolders.withAdded(folder)));
	}
	
	@Test
	public void testVariousFolderCreation() {
		String folder1 = "newfolder1";
		String folder2 = "newfolder2";
		Folders oldFolders = app.getFolderHelper().getFolders();
		app.getFolderHelper().createFolder(folder1);
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders,equalTo(oldFolders.withAdded(folder1)));
		app.getFolderHelper().createFolder(folder2);
		Folders newFolders2 = app.getFolderHelper().getFolders();
		assertThat(newFolders2,equalTo(newFolders.withAdded(folder2)));
	}
	
	@Test
	public void testFoldersWithsameNameCreation() {
		String folder = "newfolder3";
		
		Folders oldFolders = app.getFolderHelper().getFolders();
		app.getFolderHelper().createFolder(folder);
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders,equalTo(oldFolders.withAdded(folder)));
		app.getFolderHelper().createFolder(folder);
		Folders newFolders2 = app.getFolderHelper().getFolders();
		assertThat(newFolders2,equalTo(newFolders));
	}
	
}
