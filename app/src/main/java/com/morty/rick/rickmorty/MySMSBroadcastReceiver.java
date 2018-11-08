package com.morty.rick.rickmorty;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;

/**
 * Created by Akash Verma on 06/11/18.
 */
public class MySMSBroadcastReceiver extends BroadcastReceiver {

    private Listener listener;

    public void injectListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            Status status = (Status) extras.get(SmsRetriever.EXTRA_STATUS);

            switch (status.getStatusCode()) {
                case CommonStatusCodes.SUCCESS:
                    // Get SMS message contents
                    String message = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                    listener.onSMSReceived(message);
                    // Extract one-time code from the message and complete verification
                    // by sending the code back to your server.
                    break;
                case CommonStatusCodes.TIMEOUT:
                    // Waiting for SMS timed out (5 minutes)
                    // Handle the error ...
                    Toast.makeText(context, "Timeout", Toast.LENGTH_SHORT).show();
                    listener.onTimeOut();
                    break;
            }
        }
    }

    public interface Listener {
        void onSMSReceived(String otp);

        void onTimeOut();
    }
}
