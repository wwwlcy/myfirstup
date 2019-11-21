package com.atgui.utils;

public class Exchange {
	public static Integer stringToInteger(String str,Integer defaultValue) {
		if(null !=str) {
			return Integer.parseInt(str);
		}else {
			return defaultValue;
		}	
	}
}
