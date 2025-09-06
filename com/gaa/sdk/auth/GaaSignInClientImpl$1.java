package com.gaa.sdk.auth;

import Z8.b;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

class GaaSignInClientImpl.1 extends ResultReceiver {
    public final b a;

    public GaaSignInClientImpl.1(d d0, Handler handler0, b b0) {
        this.a = b0;
        super(handler0);
    }

    @Override  // android.os.ResultReceiver
    public final void onReceiveResult(int v, Bundle bundle0) {
        e e0 = d.c(v);
        this.a.a(e0);
    }
}

