package com.example.lab4receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver standAloneRx;
    BroadcastReceiver subClassedRx;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);

        //Create intent filter
        IntentFilter filter = new IntentFilter();
        //listen for app action
        filter.addAction("com.example.lab4broadcaster");

        //Stand Alone Receiver Class MyStandAloneReceiver
        //Instantiate receiver object
        standAloneRx = new MyStandAloneReceiver();
        //Register receiver with intent filter & receiver objects (Context-registered receivers)
        registerReceiver(standAloneRx, filter);

        //Code for Subclasses receiver MySubclassReceiver
        //Instantiate receiver object
        subClassedRx = new MySubclassReceiver();
        //Register receiver with intent filter & receiver objects (Context-registered receivers)
        registerReceiver(subClassedRx, filter);
    }

    //By including the Broadcast Receiver as a subclass of your activity
    //you can interact with the activity itself. (in this case the text view)
    public class MySubclassReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String msg = "Received message:" + intent.getStringExtra("Life_form");
            tv.setText(msg);
        }
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(standAloneRx);
        unregisterReceiver(subClassedRx);
        super.onDestroy();
    }
}