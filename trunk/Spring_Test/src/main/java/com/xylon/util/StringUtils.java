package com.xylon.util;

import static java.lang.String.format;

public class StringUtils {
	
	public void init(){
	}
	
	public static void main(String[] args) {
		String st = "root.xml";
		System.out.println(String.format("%d-%d", StringUtils.class.getSimpleName(), st));
	}

}
