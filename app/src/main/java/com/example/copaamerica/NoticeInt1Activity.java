package com.example.copaamerica;

import java.util.LinkedList;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.EditText;

public class NoticeInt1Activity extends Activity {
	
	private Intent inten;
	@Override 
	public void onCreate(Bundle bundle)
	{ 
		super.onCreate(bundle);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.noticiasint1);
		inten=new Intent(this, NoticiasIntActivity.class);
		final LinkedList<NotInt> list= Controller.getInstancia().getListDTONotInt(getApplicationContext());
		EditText ed=(EditText)findViewById(R.id.rowint1);
		ed.setText(list.get(0).getMgs());
	}

	public void onBackPressed() 
	{
	   inten.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	   startActivity(new Intent(inten));	
	   this.finish();
	   return;
	}
}