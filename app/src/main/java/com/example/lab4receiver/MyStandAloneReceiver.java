package com.example.lab4receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyStandAloneReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("Life_form");
        Toast.makeText(context, "Broadcast intent detected:" + msg, Toast.LENGTH_LONG).show();
    }
}
