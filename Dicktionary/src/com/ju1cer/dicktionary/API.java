package com.ju1cer.dicktionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import android.content.Context;

public class API {
	public static void getPara(String entry, String word) {
		try {
			System.out.println("getting para");
			String str = "";
			System.setProperty("sun.net.client.defaultConnectTimeout", "5000");
			System.setProperty("sun.net.client.defaultReadTimeout", "5000");
			URL url = new URL(entry);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("app_id", Config.id);
			connection.setRequestProperty("app_key", Config.key);
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = "";
			while((line = in.readLine())!=null) {
				builder.append(line + "\n");
			}
			//System.out.println(builder.toString());
			//file.createNewFile();
			//FileWriter fw = new FileWriter(file);
			//fw.write(builder.toString());
			//fw.close();
			//Json.solute(file);
			RE.re(builder.toString(), word);
			RE.eg(builder.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
			MainActivity.setT("<font color='red'>" + e.toString() + "</font>", 3);
		}
	}
	
	public static String fileToString(File file) {
		try {
			InputStream in = new FileInputStream(file);
			int len = (int)file.length();
			byte[] buf = new byte[len];
			in.read(buf, 0, len);
			return new String(buf);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
