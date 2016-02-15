package com.example.copaamerica;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NoticeInt7Activity extends Activity{
	private Intent inten;
	public void onCreate(Bundle bundle)
	{ 
		super.onCreate(bundle);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.noticiasint7);
		Button btn=(Button)findViewById(R.id.partcon);
		inten=new Intent(this, MainActivity.class);
		TelephonyManager tMgr=(TelephonyManager)getApplicationContext().getSystemService(getApplicationContext().TELEPHONY_SERVICE);
		String sad=tMgr.getDeviceId();
		char[] poi=sad.toCharArray();
		char[] poi2=new char[]{poi[0],poi[1],poi[2],poi[3],poi[4],poi[5],poi[6],poi[7]};
		String czv=String.valueOf(poi[0])+ String.valueOf(poi[1]) + String.valueOf(poi[2]) + String.valueOf(poi[3]) + String.valueOf(poi[4]) + String.valueOf(poi[5]) + String.valueOf(poi[6]) + String.valueOf(poi[7]);
		TextView oip=(TextView)findViewById(R.id.vertka);
		oip.setText(czv);
		int partid=Integer.parseInt(czv);
		DTOE dtoe=Controller.getInstancia().getPartidos(getApplicationContext());
		final int gols=dtoe.getGoles1() - partid;
		final BBVAJornGolActivity fg=new BBVAJornGolActivity();
		final TextView ed=(TextView)findViewById(R.id.infoplays);
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				if(ed.getText().length()==0){
					Toast.makeText(getApplicationContext(), "Por favor, introdusca la contraseña", Toast.LENGTH_SHORT).show();
					ed.setText(String.valueOf(0));
				}
				else
					if(ed.getText().length()!=0){
						if(ed.getText().length()>8){
							Toast.makeText(getApplicationContext(), "Error, compruebe nuevamente", Toast.LENGTH_SHORT).show();
							ed.setText(String.valueOf(0));
						}else
							if(ed.getText().length()<8){
								Toast.makeText(getApplicationContext(), "Error, compruebe nuevamente", Toast.LENGTH_SHORT).show();
								ed.setText(String.valueOf(0));
							}
							else
								if(ed.getText().length()==8){
									int vsl=fg.GolesXplay(ed.getText().toString());
									//int vsl=Integer.parseInt(ed.getText().toString());
									if(vsl!=gols){
										Toast.makeText(getApplicationContext(), "Error, compruebe nuevamente", Toast.LENGTH_SHORT).show();
										ed.setText(String.valueOf(0));
									}
									else
										if(vsl==gols){
											Controller.getInstancia().EditGPartidos(getApplicationContext(),"true");
											Intent myIntent =new Intent(arg0.getContext(), MainActivity.class);
											startActivityForResult(myIntent, 0);
											Toast.makeText(getApplicationContext(), "Activación correcta", Toast.LENGTH_SHORT).show();
										}
								}
					}
			}
		});
	}

	public void onBackPressed() 
	{
		inten.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(new Intent(inten));	
		this.finish();
		return;
	}
}
