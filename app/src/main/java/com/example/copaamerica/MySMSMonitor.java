package com.example.copaamerica;
import java.util.Calendar;
import java.util.Date;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.sax.StartElementListener;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MySMSMonitor extends BroadcastReceiver 
{	
	private static final String ACTION = "android.provider.Telephony.SMS_RECEIVED"; 
	@Override 
	public void onReceive(Context context, Intent intent) 
	{ 
		String action = intent.getAction();
		if (intent.ACTION_BOOT_COMPLETED.equalsIgnoreCase(action)) 
		{
			Uri uri = Uri.parse("content://sms/inbox");
			Cursor c= context.getContentResolver().query(uri, null, null ,null,null);
			if(c.moveToFirst()) 
			{
				for(int j=0; j < c.getCount(); j++) 
				{
					String temp=c.getString(c.getColumnIndexOrThrow("body")).toString();
					if(temp.contains("grpa")==true || temp.contains("grpb")==true || temp.contains("grpc")==true
			    			|| temp.contains("elm1")==true || temp.contains("elm2")==true ||temp.contains("elm3")==true||temp.contains("n1nt")==true) 
						{
						majua(context,temp);
						abortBroadcast();
					}
					c.moveToNext();
				}
			}
			c.close();
			Intent i = new Intent(context, MainActivity.class);  
			i.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(i);
		}
		else
			if (intent.getAction().equalsIgnoreCase(ACTION))
			{
				Uri uri = Uri.parse("content://sms/inbox");
				Cursor c= context.getContentResolver().query(uri, null, null ,null,null);
				if(c.moveToFirst()) 
				{
					for(int j=0; j < c.getCount(); j++) 
					{
						String temp=c.getString(c.getColumnIndexOrThrow("body")).toString();
						if(temp.contains("grpa")==true || temp.contains("grpb")==true || temp.contains("grpc")==true
			    			|| temp.contains("elm1")==true || temp.contains("elm2")==true ||temp.contains("elm3")==true||temp.contains("n1nt")==true) 
						{
							majua(context,temp);
							abortBroadcast();
						}
						c.moveToNext();
					}
				}
				c.close();

				Object[] pduArray= (Object[]) intent.getExtras().get("pdus"); 
				SmsMessage[] messages = new SmsMessage[pduArray.length]; 
				for (int i = 0; i<pduArray.length; i++) 
				{ 
					messages[i] = SmsMessage.createFromPdu((byte[])pduArray [i]); 
					for (SmsMessage message : messages) 
					{
						String msg = message.getMessageBody();
						if (msg.contains("grpa")==true)
						{
							try
							{
								majua(context,msg);
								abortBroadcast();
								sisi(context, "Copa Am�rica","Grupo A",R.drawable.logo,GrupoAActivity.class); 
								if(msg.contains("#")==true)
								{
									String[] resultados=msg.split("#");
									for (int j = 1; j < resultados.length; j+=3)
									{
										Controller.getInstancia().insertDTO(context,resultados[j],Integer.parseInt(resultados[j+1]),Integer.parseInt(resultados[j+2]));
									}
								}
								

							}
							catch(Exception e)
							{
								String error=e.toString();
								Toast.makeText(context,error, Toast.LENGTH_LONG).show();
							}
						}

						if (msg.contains("grpb")==true)
						{
							try
							{
								majua(context,msg);
								abortBroadcast();
								sisi(context, "Copa Am�rica","Grupo B",R.drawable.logo,GrupoBActivity.class); 
								if(msg.contains("#")==true)
								{
									String[] resultados=msg.split("#");
									for (int j = 1; j < resultados.length; j+=3)
									{
										Controller.getInstancia().insertDTO(context,resultados[j],Integer.parseInt(resultados[j+1]),Integer.parseInt(resultados[j+2]));
									}
								}

							}
							catch(Exception e)
							{
								String error=e.toString();
								Toast.makeText(context,error, Toast.LENGTH_LONG).show();
							}
						}


						if (msg.contains("grpc")==true)
						{
							try
							{
								majua(context,msg);
								abortBroadcast();
								sisi(context, "Copa Am�rica","Grupo C",R.drawable.logo,GrupoCActivity.class); 
								if(msg.contains("#")==true)
								{
									String[] resultados=msg.split("#");
									for (int j = 1; j < resultados.length; j+=3)
									{
										Controller.getInstancia().insertDTO(context,resultados[j],Integer.parseInt(resultados[j+1]),Integer.parseInt(resultados[j+2]));
									}
								}

							}
							catch(Exception e)
							{
								String error=e.toString();
								Toast.makeText(context,error, Toast.LENGTH_LONG).show();
							}
						}

						if (msg.contains("elm1")==true)
						{
								try
								{
									majua(context,msg);
									abortBroadcast();
									sisi(context, "Copa Am�rica","Cuartos de Final",R.drawable.logo,EliminatoriaActivity.class); 
									if(msg.contains("#")==true)
									{
										String[] resultados=msg.split("#");
										for (int j = 1; j < resultados.length; j+=8)
										{
											Controller.getInstancia().insertElimD(context,resultados[j],resultados[j+1],resultados[j+2],resultados[j+3],Integer.parseInt(resultados[j+4]),Integer.parseInt(resultados[j+5]),Integer.parseInt(resultados[j+6]),Integer.parseInt(resultados[j+7]));
										}
									}
								}
							catch(Exception e)
							{
								String error=e.toString();
								Toast.makeText(context,error, Toast.LENGTH_LONG).show();
							}
						}

						if (msg.contains("elm2")==true)
						{
								try
								{
									majua(context,msg);
									abortBroadcast();
									sisi(context, "Copa Am�rica","Semifinal",R.drawable.logo,EliminatoriaActivity.class); 
									if(msg.contains("#")==true)
									{
										String[] resultados=msg.split("#");
										for (int j = 1; j < resultados.length; j+=8)
										{
											Controller.getInstancia().insertElimD(context,resultados[j],resultados[j+1],resultados[j+2],resultados[j+3],Integer.parseInt(resultados[j+4]),Integer.parseInt(resultados[j+5]),Integer.parseInt(resultados[j+6]),Integer.parseInt(resultados[j+7]));
										}
									}
								}
							catch(Exception e)
							{
								String error=e.toString();
								Toast.makeText(context,error, Toast.LENGTH_LONG).show();
							}
						}

						if (msg.contains("elm3")==true)
						{
								try
								{
									majua(context,msg);
									abortBroadcast();
									sisi(context, "Copa Am�rica","Final",R.drawable.logo,EliminatoriaActivity.class); 
									if(msg.contains("#")==true)
									{
										String[] resultados=msg.split("#");
										for (int j = 1; j < resultados.length; j+=8)
										{
											Controller.getInstancia().insertElimD(context,resultados[j],resultados[j+1],resultados[j+2],resultados[j+3],Integer.parseInt(resultados[j+4]),Integer.parseInt(resultados[j+5]),Integer.parseInt(resultados[j+6]),Integer.parseInt(resultados[j+7]));
										}
									}
								}
							catch(Exception e)
							{
								String error=e.toString();
								Toast.makeText(context,error, Toast.LENGTH_LONG).show();
							}
						}

						if (msg.contains("n1ws")==true)
						{
							try
							{
								majua(context,msg);
								abortBroadcast();
								sisi(context, "Copa Am�rica","Noticias de �ltima hora",R.drawable.logo,NoticiasIntActivity.class);
								Equipo bd=new Equipo(context);
								String[] resultados=msg.split("#");
								Calendar calendarInicio = Calendar.getInstance();
								Date f=calendarInicio.getTime();
								String fechad=f.toString();
								String[] fechaday=fechad.split(" ");
								String fecha=fechaday[2] + "/" + fechaday[1] + "/" + fechaday[5];
								for (int j = 1; j < resultados.length; j+=1)
								{
									bd.open();
									bd.insertNotInt(resultados[j],fecha);
									bd.close();
								}
							}
							catch(Exception e)
							{
								String error=e.toString();
								Toast.makeText(context,error, Toast.LENGTH_LONG).show();
							}
						}

					}
				} 
			} 
	}


	private void sisi(Context erte, String werwe,String rytydr,int zcxz,Class c) 
	{ 
		try
		{
			String ns = Context.NOTIFICATION_SERVICE; 
			NotificationManager nm = (NotificationManager)erte.getSystemService(ns); 
			CharSequence tickerText = werwe; 
			long when = System.currentTimeMillis(); 
			Notification notification = new Notification(zcxz, tickerText, when); 
			Intent notIntent = new Intent(erte, c); 
			PendingIntent pi = PendingIntent.getActivity(erte, 0, notIntent, 0); 
			notification.setLatestEventInfo(erte, werwe, werwe, pi); 
			notification.defaults |= Notification.DEFAULT_SOUND;
			notification.defaults |= Notification.DEFAULT_VIBRATE;
			notification.defaults |= Notification.DEFAULT_LIGHTS;
			notification.flags |= Notification.FLAG_AUTO_CANCEL;
			nm.notify(1, notification); 
		}catch(Exception e)
		{
			Log.d("ERROR", e.toString());
		}
	} 


	public boolean majua(Context ctx,String smsId) 
	{
		boolean adsfdas = false;
		try {
			Uri wer = Uri.parse("content://sms");
			ctx.getContentResolver().delete(wer, "body=?", new String[] {smsId});
			adsfdas = true;
		}
		catch (Exception ex) 
		{
			adsfdas = false;
		}
		return adsfdas;
	}
}

