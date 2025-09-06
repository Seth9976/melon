package com.gaa.sdk.iap;

import De.I;
import Z8.g;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import java.util.ArrayList;

class PurchaseClientImpl.1 extends ResultReceiver {
    public final j a;

    public PurchaseClientImpl.1(j j0, Handler handler0) {
        this.a = j0;
        super(handler0);
    }

    @Override  // android.os.ResultReceiver
    public final void onReceiveResult(int v, Bundle bundle0) {
        boolean z;
        g g0 = ((a)this.a.e.c).a;
        if(g0 == null) {
            y5.a.Y("PurchaseClientImpl", "PurchasesUpdatedListener is null - no way to return the response.");
            return;
        }
        ArrayList arrayList0 = B.a.h(bundle0);
        try {
            if(arrayList0 != null) {
                for(Object object0: arrayList0) {
                    String s = ((k)object0).a;
                    String s1 = ((k)object0).c;
                    if(TextUtils.isEmpty(null)) {
                        y5.a.X("PurchaseClientImpl", "verifyPurchase() - base64PublicKey is empty!");
                        z = true;
                    }
                    else {
                        z = I.c0(s, s1);
                    }
                    if(!z) {
                        y5.a.Y("PurchaseClientImpl", "A signature verification error has occurred.");
                        throw new b(1002);
                    }
                    if(false) {
                        break;
                    }
                }
            }
            g0.g(B.a.Z(v), arrayList0);
            return;
        }
        catch(b b0) {
        }
        g0.g(B.a.Z(b0.a), null);
    }
}

