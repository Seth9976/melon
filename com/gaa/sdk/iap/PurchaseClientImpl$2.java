package com.gaa.sdk.iap;

import B.a;
import Z8.b;
import Z8.g;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.iloen.melon.utils.log.LogU;

class PurchaseClientImpl.2 extends ResultReceiver {
    public final b a;

    public PurchaseClientImpl.2(j j0, Handler handler0, b b0) {
        this.a = b0;
        super(handler0);
    }

    @Override  // android.os.ResultReceiver
    public final void onReceiveResult(int v, Bundle bundle0) {
        d d0 = a.Z(v);
        g g0 = this.a.b;
        boolean z = d0.a();
        LogU.Companion.d("OneStoreIapClientLifecycle", "launchUpdateOrInstallFlow() " + z + ", " + d0.a + ", " + d0.b);
        if(d0.a()) {
            g0.i();
        }
    }
}

