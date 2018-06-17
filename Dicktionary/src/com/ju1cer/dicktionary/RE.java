package com.ju1cer.dicktionary;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.text.Html;

public class RE { 	
	public static void re(String json, String word) {
		Pattern p = Pattern.compile("definitions\": \\[\\s+\"(.*?)\"");
		Matcher m = p.matcher(json);
		String def = "";
		//System.out.println(json);
		if(m.find()) {
			System.out.println("definition found");
			def = m.group(0).split("\"")[2];
			System.out.println(word + ": " + def);
			MainActivity.setT("<font color='blue'>" + word + "</font>: <font color='#6495ED'>" + def + "</font>", 1);
		}
	}
	public static void eg(String json) {
		Pattern p = Pattern.compile("examples.+\\s+.+\\s+.+");
		Matcher m = p.matcher(json);
		String eg = "";
		if(m.find()) {
			eg = m.group(0).split("\"")[4];
			int cap = eg.charAt(0);
			if(cap >= 97 && cap <= 122) {
				eg = eg.replaceFirst(String.valueOf(eg.charAt(0)), String.valueOf((char)(cap-32)));
				//System.out.println("Capital changed to " + String.valueOf(eg.charAt(0)) + " It should be " + String.valueOf((char)(cap-32)));
				//¿ªÍ·´óÐ´
			}
			MainActivity.setT("<font color='#6A5ACD'>eg: " + eg + "</font>", 2);
		}
		else {
			MainActivity.setT("<font color='#6A5ACD'>eg not found</font>", 2);
		}
	}
}
