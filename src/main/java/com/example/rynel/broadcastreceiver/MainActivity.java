package com.example.rynel.broadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

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
}
