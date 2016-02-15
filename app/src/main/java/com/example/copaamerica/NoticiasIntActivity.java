package com.example.copaamerica;

import java.util.LinkedList;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NoticiasIntActivity extends Activity {
	
	private Intent inten;
	@Override 
	public void onCreate(Bundle bundle)
	{ 
		super.onCreate(bundle);
        setContentView(R.layout.noticiasint);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TextView v1=(TextView)findViewById(R.id.int1);
		TextView v2=(TextView)findViewById(R.id.int2);
		TextView v3=(TextView)findViewById(R.id.int3);
		TextView v4=(TextView)findViewById(R.id.int4);
		TextView v5=(TextView)findViewById(R.id.int5);
		TextView v6=(TextView)findViewById(R.id.int6);
		
		TextView f1=(TextView)findViewById(R.id.fechaint1);
		TextView f2=(TextView)findViewById(R.id.fechaint2);
		TextView f3=(TextView)findViewById(R.id.fechaint3);
		TextView f4=(TextView)findViewById(R.id.fechaint4);
		TextView f5=(TextView)findViewById(R.id.fechaint5);
		TextView f6=(TextView)findViewById(R.id.fechaint6);
		
		final Button b1=(Button)findViewById(R.id.btnintrpj1);
		final Button b2=(Button)findViewById(R.id.btnintrpj2);
		final Button b3=(Button)findViewById(R.id.btnintrpj3);
		final Button b4=(Button)findViewById(R.id.btnintrpj4);
		final Button b5=(Button)findViewById(R.id.btnintrpj5);
		final Button b6=(Button)findViewById(R.id.btnintrpj6);
		
		b1.setVisibility(-1);
		b2.setVisibility(-1);
		b3.setVisibility(-1);
		b4.setVisibility(-1);
		b5.setVisibility(-1);
		b6.setVisibility(-1);
		
		final Button bimg1=(Button)findViewById(R.id.buttonint1);
		final Button bimg2=(Button)findViewById(R.id.buttonint2);
		final Button bimg3=(Button)findViewById(R.id.buttonint3);
		final Button bimg4=(Button)findViewById(R.id.buttonint4);
		final Button bimg5=(Button)findViewById(R.id.buttonint5);
		final Button bimg6=(Button)findViewById(R.id.buttonint6);
		
		final LinkedList<NotInt> list= Controller.getInstancia().getListDTONotInt(getApplicationContext());
		
		 b1.setOnClickListener(new OnClickListener() 
			{
				public void onClick(View arg0) 
				{
					// TODO Auto-generated method stub
					//b1.setBackgroundResource(R.drawable.btnj1);
					Intent myIntent =new Intent(arg0.getContext(), NoticeInt1Activity.class);
					startActivityForResult(myIntent, 0);
				}
			});
		 
		 b2.setOnClickListener(new OnClickListener() 
			{
				public void onClick(View arg0) 
				{
					// TODO Auto-generated method stub
					//b2.setBackgroundResource(R.drawable.btnj1);
					Intent myIntent =new Intent(arg0.getContext(), NoticeInt2Activity.class);
					startActivityForResult(myIntent, 0);
				}
			});
			
			b3.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					//b3.setBackgroundResource(R.drawable.btnj1);
					Intent myIntent =new Intent(arg0.getContext(), NoticeInt3Activity.class);
					startActivityForResult(myIntent, 0);
				}
			});
			
			b4.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					//b4.setBackgroundResource(R.drawable.btnj1);
					Intent myIntent =new Intent(arg0.getContext(), NoticeInt4Activity.class);
					startActivityForResult(myIntent, 0);
				}
			});
			
			
			b5.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					//b5.setBackgroundResource(R.drawable.btnj1);
					Intent myIntent =new Intent(arg0.getContext(), NoticeInt5Activity.class);
					startActivityForResult(myIntent, 0);
				}
			});
			
			b6.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					//b6.setBackgroundResource(R.drawable.btnj1);
					Intent myIntent =new Intent(arg0.getContext(), NoticeInt6Activity.class);
					startActivityForResult(myIntent, 0);
				}
			});			
		
		if(list.size()!=0)
		{
			String r1=" ";
			String r2=" ";
			String r3=" ";
			String r4=" ";
			String r5=" ";
			String r6=" ";
			String[] resultados1=list.get(0).getMgs().split(" ");
			String[] resultados2=list.get(1).getMgs().split(" ");
			String[] resultados3=list.get(2).getMgs().split(" ");
			String[] resultados4=list.get(3).getMgs().split(" ");
			String[] resultados5=list.get(4).getMgs().split(" ");
			String[] resultados6=list.get(5).getMgs().split(" ");
			
			if(resultados1.length!=0)
			{
				bimg1.setBackgroundResource(R.drawable.logo_noticias);
				b1.setVisibility(0);
				r1=resultados1[0] + " " + resultados1[1] + " " + resultados1[2] + " " + resultados1[3] + "...";
				f1.setText(list.get(0).getFecha());
				
				if(list.get(0).getMgs().contains("ficha") || list.get(0).getMgs().contains("fichaje") || list.get(0).getMgs().contains("cierra negociación") || list.get(0).getMgs().contains("oferta"))
				{
					bimg1.setBackgroundResource(R.drawable.logo_tras);
				}
				
				if(list.get(0).getMgs().contains("lesiona") || list.get(0).getMgs().contains("de baja") || list.get(0).getMgs().contains("lesión"))
				{
					bimg1.setBackgroundResource(R.drawable.logo_lesion);
				}
				
				if(list.get(0).getMgs().contains("listo") || list.get(0).getMgs().contains("de alta"))
				{
					bimg1.setBackgroundResource(R.drawable.logo_altas);
				}
				
				if(list.get(0).getMgs().contains("sancionado") || list.get(0).getMgs().contains("sanción"))
				{
					bimg1.setBackgroundResource(R.drawable.logo_sancion);
				}
				
				if(list.get(0).getMgs().contains("cumple") || list.get(0).getMgs().contains("cumplen") || list.get(0).getMgs().contains("cumpleaños"))
				{
					bimg1.setBackgroundResource(R.drawable.logo_ok);
				}
				
				if(list.get(0).getMgs().contains("Campeón") || list.get(0).getMgs().contains("record") || list.get(0).getMgs().contains("trofeo") || list.get(0).getMgs().contains("título") || list.get(0).getMgs().contains("premio") || list.get(0).getMgs().contains("pichichi"))
				{
					bimg1.setBackgroundResource(R.drawable.logo_premio);
				}
				
				if(list.get(0).getMgs().contains("rumor") || list.get(0).getMgs().contains("rumorea") || list.get(0).getMgs().contains("rumores"))
				{
					bimg1.setBackgroundResource(R.drawable.logo_rumores);
				}
				
				if(list.get(0).getMgs().contains("Champions"))
				{
					bimg1.setBackgroundResource(R.drawable.logo_champions);
				}
				
				if(list.get(0).getMgs().contains("APPSports"))
				{
					bimg1.setBackgroundResource(R.drawable.logo_appsport);
				}
				
				if(list.get(0).getMgs().contains("selecciones") || list.get(0).getMgs().contains("fecha fifa"))
				{
					bimg1.setBackgroundResource(R.drawable.logo_fifa);
				}
				
			}
			
			if(resultados2.length!=0)
			{
				bimg2.setBackgroundResource(R.drawable.logo_noticias);
				b2.setVisibility(0);
				r2=resultados2[0] + " " + resultados2[1] + " " + resultados2[2] + " " + resultados2[3] + "...";
				f2.setText(list.get(1).getFecha());
				
				if(list.get(1).getMgs().contains("ficha") || list.get(1).getMgs().contains("fichaje") || list.get(1).getMgs().contains("cierra negociación") || list.get(1).getMgs().contains("oferta"))
				{
					bimg2.setBackgroundResource(R.drawable.logo_tras);
				}
				
				if(list.get(1).getMgs().contains("lesiona") || list.get(1).getMgs().contains("de baja") || list.get(1).getMgs().contains("lesión"))
				{
					bimg2.setBackgroundResource(R.drawable.logo_lesion);
				}
				
				if(list.get(1).getMgs().contains("listo") || list.get(1).getMgs().contains("de alta"))
				{
					bimg2.setBackgroundResource(R.drawable.logo_altas);
				}
				
				if(list.get(1).getMgs().contains("sancionado") || list.get(1).getMgs().contains("sanción"))
				{
					bimg2.setBackgroundResource(R.drawable.logo_sancion);
				}
				
				if(list.get(1).getMgs().contains("cumple") || list.get(1).getMgs().contains("cumplen") || list.get(1).getMgs().contains("cumpleaños"))
				{
					bimg2.setBackgroundResource(R.drawable.logo_ok);
				}
				
				if(list.get(1).getMgs().contains("Campeón") || list.get(1).getMgs().contains("record") || list.get(1).getMgs().contains("trofeo") || list.get(1).getMgs().contains("título") || list.get(1).getMgs().contains("premio") || list.get(1).getMgs().contains("pichichi"))
				{
					bimg2.setBackgroundResource(R.drawable.logo_premio);
				}
				
				if(list.get(1).getMgs().contains("rumor") || list.get(1).getMgs().contains("rumorea") || list.get(1).getMgs().contains("rumores"))
				{
					bimg2.setBackgroundResource(R.drawable.logo_rumores);
				}
				
				if(list.get(1).getMgs().contains("Champions"))
				{
					bimg2.setBackgroundResource(R.drawable.logo_champions);
				}
				
				if(list.get(1).getMgs().contains("APPSports"))
				{
					bimg2.setBackgroundResource(R.drawable.logo_appsport);
				}
				
				if(list.get(1).getMgs().contains("selecciones") || list.get(1).getMgs().contains("fecha fifa"))
				{
					bimg2.setBackgroundResource(R.drawable.logo_fifa);
				}
			}
			
			if(resultados3.length!=0)
			{
				bimg3.setBackgroundResource(R.drawable.logo_noticias);
				b3.setVisibility(0);
				r3=resultados3[0] + " " + resultados3[1] + " " + resultados3[2] + " " + resultados3[3] + "...";
				f3.setText(list.get(2).getFecha());
				
				if(list.get(2).getMgs().contains("ficha") || list.get(2).getMgs().contains("fichaje") || list.get(2).getMgs().contains("cierra negociación") || list.get(2).getMgs().contains("oferta"))
				{
					bimg3.setBackgroundResource(R.drawable.logo_tras);
				}
				
				if(list.get(2).getMgs().contains("lesiona") || list.get(2).getMgs().contains("de baja") || list.get(2).getMgs().contains("lesión"))
				{
					bimg3.setBackgroundResource(R.drawable.logo_lesion);
				}
				
				if(list.get(2).getMgs().contains("listo") || list.get(2).getMgs().contains("de alta"))
				{
					bimg3.setBackgroundResource(R.drawable.logo_altas);
				}
				
				if(list.get(2).getMgs().contains("sancionado") || list.get(2).getMgs().contains("sanción"))
				{
					bimg3.setBackgroundResource(R.drawable.logo_sancion);
				}
				
				if(list.get(2).getMgs().contains("cumple") || list.get(2).getMgs().contains("cumplen") || list.get(2).getMgs().contains("cumpleaños"))
				{
					bimg3.setBackgroundResource(R.drawable.logo_ok);
				}
				
				if(list.get(2).getMgs().contains("Campeón") || list.get(2).getMgs().contains("record") || list.get(2).getMgs().contains("trofeo") || list.get(2).getMgs().contains("título") || list.get(2).getMgs().contains("premio") || list.get(2).getMgs().contains("pichichi"))
				{
					bimg3.setBackgroundResource(R.drawable.logo_premio);
				}
				
				if(list.get(2).getMgs().contains("rumor") || list.get(2).getMgs().contains("rumorea") || list.get(2).getMgs().contains("rumores"))
				{
					bimg3.setBackgroundResource(R.drawable.logo_rumores);
				}
				
				if(list.get(2).getMgs().contains("Champions"))
				{
					bimg3.setBackgroundResource(R.drawable.logo_champions);
				}
				
				if(list.get(2).getMgs().contains("APPSports"))
				{
					bimg3.setBackgroundResource(R.drawable.logo_appsport);
				}
				
				if(list.get(2).getMgs().contains("selecciones") || list.get(2).getMgs().contains("fecha fifa"))
				{
					bimg3.setBackgroundResource(R.drawable.logo_fifa);
				}
			}
			
			if(resultados4.length!=0)
			{
				bimg4.setBackgroundResource(R.drawable.logo_noticias);
				b4.setVisibility(0);
				r4=resultados4[0] + " " + resultados4[1] + " " + resultados4[2] + " " + resultados4[3] + "...";
				f4.setText(list.get(3).getFecha());
				if(list.get(3).getMgs().contains("ficha") || list.get(3).getMgs().contains("fichaje") || list.get(3).getMgs().contains("cierra negociación") || list.get(3).getMgs().contains("oferta"))
				{
					bimg4.setBackgroundResource(R.drawable.logo_tras);
				}
				
				if(list.get(3).getMgs().contains("lesiona") || list.get(3).getMgs().contains("de baja") || list.get(3).getMgs().contains("lesión"))
				{
					bimg4.setBackgroundResource(R.drawable.logo_lesion);
				}
				
				if(list.get(3).getMgs().contains("listo") || list.get(3).getMgs().contains("de alta"))
				{
					bimg4.setBackgroundResource(R.drawable.logo_altas);
				}
				
				if(list.get(3).getMgs().contains("sancionado") || list.get(3).getMgs().contains("sanción"))
				{
					bimg4.setBackgroundResource(R.drawable.logo_sancion);
				}
				
				if(list.get(3).getMgs().contains("cumple") || list.get(3).getMgs().contains("cumplen") || list.get(3).getMgs().contains("cumpleaños"))
				{
					bimg4.setBackgroundResource(R.drawable.logo_ok);
				}
				
				if(list.get(3).getMgs().contains("Campeón") || list.get(3).getMgs().contains("record") || list.get(3).getMgs().contains("trofeo") || list.get(3).getMgs().contains("título") || list.get(3).getMgs().contains("premio") || list.get(3).getMgs().contains("pichichi"))
				{
					bimg4.setBackgroundResource(R.drawable.logo_premio);
				}
				
				if(list.get(3).getMgs().contains("rumor") || list.get(3).getMgs().contains("rumorea") || list.get(3).getMgs().contains("rumores"))
				{
					bimg4.setBackgroundResource(R.drawable.logo_rumores);
				}
				
				if(list.get(3).getMgs().contains("Champions"))
				{
					bimg4.setBackgroundResource(R.drawable.logo_champions);
				}
				
				if(list.get(3).getMgs().contains("APPSports"))
				{
					bimg4.setBackgroundResource(R.drawable.logo_appsport);
				}
				
				if(list.get(3).getMgs().contains("selecciones") || list.get(3).getMgs().contains("fecha fifa"))
				{
					bimg4.setBackgroundResource(R.drawable.logo_fifa);
				}
			}
			
			if(resultados5.length!=0)
			{
				bimg5.setBackgroundResource(R.drawable.logo_noticias);
				b5.setVisibility(0);
				r5=resultados5[0] + " " + resultados5[1]+ " " +resultados5[2]+ " " +resultados5[3] + "...";
				f5.setText(list.get(4).getFecha());
				
				if(list.get(4).getMgs().contains("ficha") || list.get(4).getMgs().contains("fichaje") || list.get(4).getMgs().contains("cierra negociación") || list.get(4).getMgs().contains("oferta"))
				{
					bimg5.setBackgroundResource(R.drawable.logo_tras);
				}
				
				if(list.get(4).getMgs().contains("lesiona") || list.get(4).getMgs().contains("de baja") || list.get(4).getMgs().contains("lesión"))
				{
					bimg5.setBackgroundResource(R.drawable.logo_lesion);
				}
				
				if(list.get(4).getMgs().contains("listo") || list.get(4).getMgs().contains("de alta"))
				{
					bimg5.setBackgroundResource(R.drawable.logo_altas);
				}
				
				if(list.get(4).getMgs().contains("sancionado") || list.get(4).getMgs().contains("sanción"))
				{
					bimg5.setBackgroundResource(R.drawable.logo_sancion);
				}
				
				if(list.get(4).getMgs().contains("cumple") || list.get(4).getMgs().contains("cumplen") || list.get(4).getMgs().contains("cumpleaños"))
				{
					bimg5.setBackgroundResource(R.drawable.logo_ok);
				}
				
				if(list.get(4).getMgs().contains("Campeón") || list.get(4).getMgs().contains("record") || list.get(4).getMgs().contains("trofeo") || list.get(4).getMgs().contains("título") || list.get(4).getMgs().contains("premio") || list.get(4).getMgs().contains("pichichi"))
				{
					bimg5.setBackgroundResource(R.drawable.logo_premio);
				}
				
				if(list.get(4).getMgs().contains("rumor") || list.get(4).getMgs().contains("rumorea") || list.get(4).getMgs().contains("rumores"))
				{
					bimg5.setBackgroundResource(R.drawable.logo_rumores);
				}
				
				if(list.get(4).getMgs().contains("Champions"))
				{
					bimg5.setBackgroundResource(R.drawable.logo_champions);
				}
				
				if(list.get(4).getMgs().contains("APPSports"))
				{
					bimg5.setBackgroundResource(R.drawable.logo_appsport);
				}
				
				if(list.get(4).getMgs().contains("selecciones") || list.get(4).getMgs().contains("fecha fifa"))
				{
					bimg5.setBackgroundResource(R.drawable.logo_fifa);
				}
			}
			
			if(resultados6.length!=0)
			{
				bimg6.setBackgroundResource(R.drawable.logo_noticias);
				b6.setVisibility(0);
				r6=resultados6[0] + " " + resultados6[1]+ " " +resultados6[2]+ " " +resultados6[3] + "...";
				f6.setText(list.get(5).getFecha());
				
				if(list.get(5).getMgs().contains("ficha") || list.get(5).getMgs().contains("fichaje") || list.get(5).getMgs().contains("cierra negociación") || list.get(5).getMgs().contains("oferta"))
				{
					bimg6.setBackgroundResource(R.drawable.logo_tras);
				}
				
				if(list.get(5).getMgs().contains("lesiona") || list.get(5).getMgs().contains("de baja") || list.get(5).getMgs().contains("lesión"))
				{
					bimg6.setBackgroundResource(R.drawable.logo_lesion);
				}
				
				if(list.get(5).getMgs().contains("listo") || list.get(5).getMgs().contains("de alta"))
				{
					bimg6.setBackgroundResource(R.drawable.logo_altas);
				}
				
				if(list.get(5).getMgs().contains("sancionado") || list.get(5).getMgs().contains("sanción"))
				{
					bimg6.setBackgroundResource(R.drawable.logo_sancion);
				}
				
				if(list.get(5).getMgs().contains("cumple") || list.get(5).getMgs().contains("cumplen") || list.get(5).getMgs().contains("cumpleaños"))
				{
					bimg6.setBackgroundResource(R.drawable.logo_ok);
				}
				
				if(list.get(5).getMgs().contains("Campeón") || list.get(5).getMgs().contains("record") || list.get(5).getMgs().contains("trofeo") || list.get(5).getMgs().contains("título") || list.get(5).getMgs().contains("premio") || list.get(5).getMgs().contains("pichichi"))
				{
					bimg6.setBackgroundResource(R.drawable.logo_premio);
				}
				
				if(list.get(5).getMgs().contains("rumor") || list.get(5).getMgs().contains("rumorea") || list.get(5).getMgs().contains("rumores"))
				{
					bimg6.setBackgroundResource(R.drawable.logo_rumores);
				}
				
				if(list.get(5).getMgs().contains("Champions"))
				{
					bimg6.setBackgroundResource(R.drawable.logo_champions);
				}
				
				if(list.get(5).getMgs().contains("APPSports"))
				{
					bimg6.setBackgroundResource(R.drawable.logo_appsport);
				}
				
				if(list.get(5).getMgs().contains("selecciones") || list.get(5).getMgs().contains("fecha fifa"))
				{
					bimg6.setBackgroundResource(R.drawable.logo_fifa);
				}
			}
			
			
			
			//******************************
			v1.setText(r1);
			v2.setText(r2);
			v3.setText(r3);
			v4.setText(r4);
			v5.setText(r5);
			v6.setText(r6);
		}
		else
			if(list.size()==0)
			{
				Log.d("Error", "No se ha cargado la Base de Dtos");
			}
		inten=new Intent(this, MainActivity.class);
	}

	public void onBackPressed() 
	{
	   inten.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	   startActivity(new Intent(inten));	
	   this.finish();
	   return;
	}
}
