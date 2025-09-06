package com.facebook.appevents.iap;

public final class b implements Runnable {
    public final int a;
    public final InAppPurchaseBillingClientWrapperV2V4 b;
    public final IAPProductType c;
    public final Runnable d;

    public b(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V40, IAPProductType inAppPurchaseUtils$IAPProductType0, Runnable runnable0, int v) {
        this.a = v;
        this.b = inAppPurchaseBillingClientWrapperV2V40;
        this.c = inAppPurchaseUtils$IAPProductType0;
        this.d = runnable0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            InAppPurchaseBillingClientWrapperV2V4.queryPurchases$lambda$0(this.b, this.c, this.d);
            return;
        }
        InAppPurchaseBillingClientWrapperV2V4.queryPurchaseHistory$lambda$2(this.b, this.c, this.d);
    }
}

