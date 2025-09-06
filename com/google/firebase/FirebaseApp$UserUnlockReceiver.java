package com.google.firebase;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.atomic.AtomicReference;

@TargetApi(24)
class FirebaseApp.UserUnlockReceiver extends BroadcastReceiver {
    public final Context a;
    public static final AtomicReference b;

    static {
        FirebaseApp.UserUnlockReceiver.b = new AtomicReference();
    }

    public FirebaseApp.UserUnlockReceiver(Context context0) {
        this.a = context0;
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        synchronized(e.k) {
            for(Object object1: e.l.values()) {
                ((e)object1).e();
            }
        }
        this.a.unregisterReceiver(this);
    }
}

