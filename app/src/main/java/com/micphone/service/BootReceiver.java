package com.micphone.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import com.micphone.service.utile.Config;

public class BootReceiver extends BroadcastReceiver {
    private static final String TAG = "gdmicphoneservice";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED") ||
                intent.getAction().equals("android.intent.action.MEDIA_MOUNTED")){
            Intent serviceIntent = new Intent(context, Qdmicphoneservice.class);
            if (Config.isFrontService() && Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(serviceIntent);
            } else {
                // Pre-O behavior.
                context.startService(serviceIntent);
            }
        }
    }
}
