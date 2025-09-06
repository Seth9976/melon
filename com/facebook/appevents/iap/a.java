package com.facebook.appevents.iap;

import android.content.Context;

public final class a implements Runnable {
    public final int a;
    public final BillingClientVersion b;
    public final Context c;

    public a(BillingClientVersion inAppPurchaseUtils$BillingClientVersion0, Context context0, int v) {
        this.a = v;
        this.b = inAppPurchaseUtils$BillingClientVersion0;
        this.c = context0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            InAppPurchaseAutoLogger.startIapLogging$lambda$2(this.b, this.c);
            return;
        }
        InAppPurchaseAutoLogger.startIapLogging$lambda$1$lambda$0(this.b, this.c);
    }
}

