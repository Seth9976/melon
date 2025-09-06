package com.google.android.gms.common;

import U4.x;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.base.zau;

@SuppressLint({"HandlerLeak"})
final class zad extends zau {
    final GoogleApiAvailability zaa;
    private final Context zab;

    public zad(GoogleApiAvailability googleApiAvailability0, Context context0) {
        this.zaa = googleApiAvailability0;
        super((Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper()));
        this.zab = context0.getApplicationContext();
    }

    @Override  // android.os.Handler
    public final void handleMessage(Message message0) {
        int v = message0.what;
        if(v != 1) {
            x.u(v, "Don\'t know how to handle this message: ", "GoogleApiAvailability");
            return;
        }
        int v1 = this.zaa.isGooglePlayServicesAvailable(this.zab);
        if(this.zaa.isUserResolvableError(v1)) {
            this.zaa.showErrorNotification(this.zab, v1);
        }
    }
}

