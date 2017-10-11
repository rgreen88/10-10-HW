package com.example.rynel.broadcastreceiver;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.rynel.broadcastreceiver.utils.Constants;

/**
 * Created by rynel on 10/11/2017.
 */

public class MyDynamicReceiver extends MyStaticReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        //intent.getAction() receives from MyStaticReceiver
        String action = intent.getAction();

        switch (action){

            case Intent.ACTION_AIRPLANE_MODE_CHANGED:

                boolean isAirPlaneModeOn = intent.getBooleanExtra("state", false);
                if (isAirPlaneModeOn){
                    Toast.makeText(context, "Airplane mode is on", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(context, "Airplane mode is off", Toast.LENGTH_SHORT).show();

                break;


            case Intent.ACTION_CAMERA_BUTTON:

                    Toast.makeText(context, "Camera button was pressed", Toast.LENGTH_SHORT).show();

                break;


            case Intent.ACTION_POWER_CONNECTED:

                boolean isPowerConnected = intent.getBooleanExtra("state", false);
                if (isPowerConnected)
                    Toast.makeText(context, "Power is connected", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context, "Power is disconnected", Toast.LENGTH_SHORT).show();

                break;


            case Intent.ACTION_TIMEZONE_CHANGED:

                Toast.makeText(context, "Time zone changed", Toast.LENGTH_SHORT).show();

                break;

            case Intent.ACTION_POWER_DISCONNECTED:   //redundancy with action power connected case

                boolean isPowerDisConnected = intent.getBooleanExtra("state", false);
                if (isPowerDisConnected)
                    Toast.makeText(context, "Power is disconnected", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context, "Power is connected", Toast.LENGTH_SHORT).show();

                break;



            case Constants.ACTION.ACTION1:

                String data = intent.getStringExtra(Constants.KEYS.DATANAME1);
                Toast.makeText(context, data, Toast.LENGTH_SHORT).show();

                break;

            case Constants.ACTION.ACTION2:

                data = intent.getStringExtra(Constants.KEYS.DATANAME2);
                Toast.makeText(context, data, Toast.LENGTH_SHORT).show();

                break;

            case Constants.ACTION.ACTION3:

                data = intent.getStringExtra(Constants.KEYS.DATANAME3);
                Toast.makeText(context, data, Toast.LENGTH_SHORT).show();

                break;

        }
    }
}