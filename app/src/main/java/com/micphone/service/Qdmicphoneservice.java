package com.micphone.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Qdmicphoneservice extends Service {
    public Qdmicphoneservice() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}