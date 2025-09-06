package com.gaa.sdk.iap;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.lifecycle.b;
import java.util.concurrent.Callable;
import y5.a;

public final class g implements Callable {
    public final b a;
    public final T7.b b;
    public final j c;

    public g(j j0, b b0, T7.b b1) {
        this.c = j0;
        this.a = b0;
        this.b = b1;
    }

    @Override
    public final Object call() {
        j j0 = this.c;
        T7.b b0 = this.b;
        k k0 = (k)this.a.b;
        try {
            int v = j0.c ? 7 : 6;
            String s = k0.b.optString("purchaseToken");
            if(TextUtils.isEmpty(s)) {
                s = k0.b.optString("purchaseId");
                v = 5;
            }
            a.X("PurchaseClientImpl", "Consuming api: " + v + ", purchaseToken: " + s);
            Bundle bundle0 = new Bundle();
            bundle0.putString("inAppSdkLibraryVersion", j0.h);
            if(!TextUtils.isEmpty(null)) {
                bundle0.putString("developerPayload", null);
            }
            int v1 = B.a.f(((K5.a)j0.f).C0(v, "com.iloen.melon", s, bundle0), "PurchaseClientImpl");
            a.X("PurchaseClientImpl", (v1 == 0 ? "Successfully consumed purchaseToken: " + s : "Error consuming purchaseData with purchaseToken. Response code: " + v1));
            E9.g g0 = j0.j;
            h h0 = new h(j0, b0, v1, k0);
            g0.getClass();
            if(!Thread.interrupted()) {
                ((Handler)g0.a).post(h0);
                return null;
            }
            return null;
        }
        catch(Exception exception0) {
        }
        a.Y("PurchaseClientImpl", "Error consuming purchaseData; ex: " + exception0);
        E9.g g1 = j0.j;
        h h1 = new h(j0, b0, 1007, null);
        g1.getClass();
        if(!Thread.interrupted()) {
            ((Handler)g1.a).post(h1);
        }
        return null;
    }
}

