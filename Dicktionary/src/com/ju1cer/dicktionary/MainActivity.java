package com.ju1cer.dicktionary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button button_submit;
	private Button button_reset;
	private EditText et;
	private static TextView tv;
	private static String tv_str;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (android.os.Build.VERSION.SDK_INT > 9) {  
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();  
		    StrictMode.setThreadPolicy(policy);  
		    
		}  
		
		
		button_submit = (Button) findViewById(R.id.button1);
		button_reset = (Button) findViewById(R.id.button2);
		et = (EditText) findViewById(R.id.editText1);
		tv = (TextView) findViewById(R.id.textView1);
		tv_str = "";
		
		button_submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				tv.setText("");
				for(String temp : et.getText().toString().split("(\\s+)?\n(\\s+)?")) {
					System.out.println(temp + " submitted");
					API.getPara(Config.getEntry(temp), temp);
				}
			}
		});
		
		button_reset.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				et.setText("");
				tv.setText("");
			}
		});
		
		tv.setMovementMethod(ScrollingMovementMethod.getInstance());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent intent;
		    try {
		        intent = Intent.parseUri("https://qr.alipay.com/tsx02158xlxplulylnfx432",
		                Intent.URI_INTENT_SCHEME);
		        intent.addCategory(Intent.CATEGORY_BROWSABLE);
		        intent.setComponent(null);
		        startActivity(intent);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
			return true;
		    }
		if(id == R.id.bonus) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public static void setT(String str, int type) {
		/*
		 * type 1 = definition
		 * type 2 = example
		 * type 3 = error
		 */
		if(type == 1 || type == 3) {
			tv.setText(Html.fromHtml(tv_str + "<br>===================================<br>" + str));
			tv_str += "<br>===================================<br>" + str;
		}
		else {
			tv.setText(Html.fromHtml(tv_str + "<br>" + str));
			tv_str += "<br>" + str;
			}
		tv.scrollTo(0, tv.getText().toString().length());
	}
}
