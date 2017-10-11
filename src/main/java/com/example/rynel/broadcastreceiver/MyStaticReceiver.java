package com.example.rynel.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by rynel on 10/11/2017.
 */

public class MyStaticReceiver extends BroadcastReceiver {

    private static final String TAG = "MyStaticReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // an Intent broadcast.

        Log.d(TAG, "onReceive: ");


    }
}
