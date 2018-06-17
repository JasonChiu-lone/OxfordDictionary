package com.ju1cer.dicktionary;

public final class Config {
	public static final String url = "https://od-api.oxforddictionaries.com:443/api/v1/entries/en/";
	public static final String id = "a190298d";
	public static final String key = "17750c8462c9ce19ba7bb537ed9d959e";
	
	public static final String getEntry(String word) {
		return Config.url + word;
	}
}
