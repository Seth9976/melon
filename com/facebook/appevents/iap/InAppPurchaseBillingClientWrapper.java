package com.facebook.appevents.iap;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\t\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\f\u001A\u00020\u00018&X¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\r"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;", "", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;", "productType", "Ljava/lang/Runnable;", "completionHandler", "Lie/H;", "queryPurchases", "(Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;Ljava/lang/Runnable;)V", "queryPurchaseHistory", "getBillingClient", "()Ljava/lang/Object;", "billingClient", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface InAppPurchaseBillingClientWrapper {
    @NotNull
    Object getBillingClient();

    void queryPurchaseHistory(@NotNull IAPProductType arg1, @NotNull Runnable arg2);

    void queryPurchases(@NotNull IAPProductType arg1, @NotNull Runnable arg2);
}

