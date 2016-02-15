package com.example.copaamerica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.example.copaamerica.R;

public class CalendarioActivity extends Activity {

	private Intent inten;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calendario);
		inten=new Intent(this, MainActivity.class);
		WebView view = (WebView) findViewById(R.id.webView1);

		if (view != null)
		{
			//"@drawable/calendario_image"
			String uriStr = "file:///android_asset/calendario.png"; 
			view.loadUrl(uriStr);
			WebSettings webSettings = view.getSettings();
			webSettings.setBuiltInZoomControls(true);
		}
		view.setOnKeyListener(new OnKeyListener() {
			
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if (keyCode == KeyEvent.KEYCODE_BACK) {
					inten.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //Elimina las otras activity
					startActivity(new Intent(inten));
					finish();
					return true; // consume event, hence do nothing on camera button
				}
				return false;
			}
		});
		
		
	}
	
}
