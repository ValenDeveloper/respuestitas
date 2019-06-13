package com.example.respuestitas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String BROADCAST_ACTION = "com.example.respuestitas.LN";


    private TextView txtView;
    private NotificationReceiver nReceiver;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = (TextView) findViewById(R.id.text1);

        Log.i("MainActivity", "onCreate");

        // Pedir permiso si aun no lo tiene
        int permissionNotificacion = ContextCompat.checkSelfPermission(this, Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE);
        if (permissionNotificacion != PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            startActivity(intent);
        }

        // lanzar servicio de escucha de notificaciones
        intent = new Intent(this, LectorNotificaciones.class);
        startService(intent);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_ACTION);
        nReceiver = new NotificationReceiver();
        registerReceiver(nReceiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(nReceiver);
        stopService(intent);
    }

    class NotificationReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String temp = intent.getStringExtra("oracion") + "\n" + txtView.getText();
            txtView.setText(temp);
        }
    }
}
