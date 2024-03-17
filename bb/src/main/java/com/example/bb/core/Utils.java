package com.example.bb.core;

import java.text.DecimalFormat;
import java.util.Random;

public class Utils {
	public static String getRandomNumber() {
		return new DecimalFormat("000000").format(new Random().nextInt(999999));
	}

	public static String getRandomPassword() {
		  String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$";
	      String numbers = "1234567890";
	      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	      Random random = new Random();
	     
	      char[] password = new char[10];

	      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
	      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
	      password[3] = numbers.charAt(random.nextInt(numbers.length()));
	   
	      for(int i = 4; i< 10 ; i++) {
	         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	      }
	      return String.valueOf(password);
	}
}
