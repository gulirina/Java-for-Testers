package com.example.tests;

import java.util.Random;

public class BaseGenerator {
	
	public static String generateRandomString() {
		Random rnd = new Random();
		if(rnd.nextInt(3)==0) {
			return "";
		}else {
			return "test"+rnd.nextInt(2);
		}
	}
	
	public static String generateRandomNumber(int limit){
		  Random rnd = new Random();
		  int number = 1+rnd.nextInt(limit);
		  String num = ""+number+"";
		  return num;
	} 
}
