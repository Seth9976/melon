package com.facebook.appevents.iap;

public final class c implements Runnable {
    public final int a;
    public final InAppPurchaseBillingClientWrapperV5V7 b;
    public final IAPProductType c;
    public final Runnable d;

    public c(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V70, IAPProductType inAppPurchaseUtils$IAPProductType0, Runnable runnable0, int v) {
        this.a = v;
        this.b = inAppPurchaseBillingClientWrapperV5V70;
        this.c = inAppPurchaseUtils$IAPProductType0;
        this.d = runnable0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            InAppPurchaseBillingClientWrapperV5V7.queryPurchaseHistory$lambda$1(this.b, this.c, this.d);
            return;
        }
        InAppPurchaseBillingClientWrapperV5V7.queryPurchases$lambda$0(this.b, this.c, this.d);
    }
}

