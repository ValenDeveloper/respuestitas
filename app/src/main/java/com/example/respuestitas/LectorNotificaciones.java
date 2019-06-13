package com.example.respuestitas;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

public class LectorNotificaciones extends NotificationListenerService {

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i("LectorNotificacion", "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("LectorNotificacion", "onDestroy");
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
//        Log.i(TAG,"ID :" + sbn.getId() + "\t" + sbn.getNotification().tickerText + "\t" + sbn.getPackageName());
        String text = sbn.getNotification().extras.getCharSequence(Notification.EXTRA_TEXT).toString();
        String title = sbn.getNotification().extras.getCharSequence(Notification.EXTRA_TITLE).toString();
        String oracion = "Title: " + title + " Text: " + text;
        Log.i("LectorNotificacion", oracion);

        Intent broadCastIntent = new Intent();
        broadCastIntent.setAction(MainActivity.BROADCAST_ACTION);
//        broadCastIntent.putExtra("title", title);
//        broadCastIntent.putExtra("text", text);
        broadCastIntent.putExtra("oracion", oracion);
        sendBroadcast(broadCastIntent);

    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
//        Log.i(TAG,"ID :" + sbn.getId() + "\t" + sbn.getNotification().tickerText +"\t" + sbn.getPackageName());
    }

}
