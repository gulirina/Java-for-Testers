package com.example.fw;

import java.util.List;
import java.util.Random;

public class CommonHelper extends WebDriverHelperBase {

	public CommonHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public static <T> int chooseRandom(List<T> list) {
		if(list.size()!=0){
		Random  rnd = new Random();
	    int index = rnd.nextInt(list.size());
		return index;
		} else {
			return -1;
		}
	}
}
