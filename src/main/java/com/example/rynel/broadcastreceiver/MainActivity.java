package com.example.rynel.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";
    private static final String ACTION = "receiveList";
    private static final String KEY = "data";

    MyReceiver myReceiver;
    Button intentServiceButton;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void broadCastIntent(View view){

        //intent creation
        Intent intent = new Intent();

        //bind etData to editText
        EditText editText = (EditText) findViewById(R.id.etData);

        //extra data passing with casting CharSequence for read-only character sequences
        intent.putExtra("message", (CharSequence)editText.getText().toString());
        intent.setAction("com.broadcast");
        sendBroadcast(intent);
    }


    @Override
    protected void onStart() {
        super.onStart();

        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction( ACTION );
        registerReceiver( myReceiver, intentFilter );
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver( myReceiver );
    }

    public void buttonPressed(View view) {
        Log.d(TAG, "buttonPressed: Starting Service");
        Intent intService = new Intent( this, MyIntentService.class );
        startService( intService  );
    }

    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: Broadcast Received, Checking Action");
            String action = intent.getAction();

            switch ( action ) {
                case ACTION:
                    Log.d(TAG, "onReceive: Fetching data");
                    ArrayList<Person> personArrayList = intent.getParcelableArrayListExtra( KEY );

                    PersonListAdapter psa = new PersonListAdapter( MainActivity.this, R.layout.list_view_item,
                            personArrayList);

                    listView.setAdapter( psa );
                    break;
            }
        }
    }
}
