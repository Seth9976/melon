package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

public final class x extends BroadcastReceiver {
    public y a;
    public Context b;

    public final void a() {
        if(Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Connectivity change received registered");
        }
        IntentFilter intentFilter0 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        y y0 = this.a;
        if(y0 != null) {
            this.b = ((FirebaseMessaging)y0.d).b;
            ((FirebaseMessaging)y0.d).b.registerReceiver(this, intentFilter0);
        }
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        if(this.a == null || !this.a.a()) {
            return;
        }
        if(Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
        }
        y y0 = this.a;
        ((FirebaseMessaging)y0.d).getClass();
        FirebaseMessaging.b(y0, 0L);
        Context context1 = this.b;
        if(context1 != null) {
            context1.unregisterReceiver(this);
        }
        this.a = null;
    }
}

