package com.facebook.appevents.iap;

import I7.k;
import android.content.Context;
import com.facebook.appevents.integrity.ProtectedModeManager;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\r\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\r\u0010\u000ER\u0017\u0010\u0010\u001A\u00020\u000F8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseAutoLogger;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;", "billingClientVersion", "Lie/H;", "startIapLogging", "(Landroid/content/Context;Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;)V", "", "packageName", "logPurchase", "(Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;Ljava/lang/String;)V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "failedToCreateWrapper", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getFailedToCreateWrapper", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InAppPurchaseAutoLogger {
    @NotNull
    public static final InAppPurchaseAutoLogger INSTANCE;
    @NotNull
    private static final AtomicBoolean failedToCreateWrapper;

    static {
        InAppPurchaseAutoLogger.INSTANCE = new InAppPurchaseAutoLogger();
        InAppPurchaseAutoLogger.failedToCreateWrapper = new AtomicBoolean(false);
    }

    // 去混淆评级： 低(20)
    @NotNull
    public final AtomicBoolean getFailedToCreateWrapper() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : InAppPurchaseAutoLogger.failedToCreateWrapper;
    }

    private final void logPurchase(BillingClientVersion inAppPurchaseUtils$BillingClientVersion0, String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                boolean z = InAppPurchaseLoggerManager.getIsFirstAppLaunchWithNewIAP();
                if(z) {
                    InAppPurchaseLoggerManager.migrateOldCacheHistory();
                }
                if(inAppPurchaseUtils$BillingClientVersion0 == BillingClientVersion.V2_V4) {
                    InAppPurchaseLoggerManager.filterPurchaseLogging(InAppPurchaseBillingClientWrapperV2V4.Companion.getIapPurchaseDetailsMap(), InAppPurchaseBillingClientWrapperV2V4.Companion.getSkuDetailsMap(), false, s, inAppPurchaseUtils$BillingClientVersion0, z);
                    InAppPurchaseLoggerManager.filterPurchaseLogging(InAppPurchaseBillingClientWrapperV2V4.Companion.getSubsPurchaseDetailsMap(), InAppPurchaseBillingClientWrapperV2V4.Companion.getSkuDetailsMap(), true, s, inAppPurchaseUtils$BillingClientVersion0, z);
                    InAppPurchaseBillingClientWrapperV2V4.Companion.getIapPurchaseDetailsMap().clear();
                    InAppPurchaseBillingClientWrapperV2V4.Companion.getSubsPurchaseDetailsMap().clear();
                }
                else {
                    InAppPurchaseLoggerManager.filterPurchaseLogging(InAppPurchaseBillingClientWrapperV5V7.Companion.getIapPurchaseDetailsMap(), InAppPurchaseBillingClientWrapperV5V7.Companion.getProductDetailsMap(), false, s, inAppPurchaseUtils$BillingClientVersion0, z);
                    InAppPurchaseLoggerManager.filterPurchaseLogging(InAppPurchaseBillingClientWrapperV5V7.Companion.getSubsPurchaseDetailsMap(), InAppPurchaseBillingClientWrapperV5V7.Companion.getProductDetailsMap(), true, s, inAppPurchaseUtils$BillingClientVersion0, z);
                    InAppPurchaseBillingClientWrapperV5V7.Companion.getIapPurchaseDetailsMap().clear();
                    InAppPurchaseBillingClientWrapperV5V7.Companion.getSubsPurchaseDetailsMap().clear();
                }
                if(z) {
                    InAppPurchaseLoggerManager.setAppHasBeenLaunchedWithNewIAP();
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public static final void startIapLogging(@NotNull Context context0, @NotNull BillingClientVersion inAppPurchaseUtils$BillingClientVersion0) {
        synchronized(InAppPurchaseAutoLogger.class) {
            if(CrashShieldHandler.isObjectCrashing(InAppPurchaseAutoLogger.class)) {
                return;
            }
            try {
                q.g(context0, "context");
                q.g(inAppPurchaseUtils$BillingClientVersion0, "billingClientVersion");
                AtomicBoolean atomicBoolean0 = InAppPurchaseAutoLogger.failedToCreateWrapper;
                if(atomicBoolean0.get()) {
                    return;
                }
                H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                BillingClientVersion inAppPurchaseUtils$BillingClientVersion1 = BillingClientVersion.V2_V4;
                if(inAppPurchaseUtils$BillingClientVersion0 == inAppPurchaseUtils$BillingClientVersion1) {
                    h0.a = InAppPurchaseBillingClientWrapperV2V4.Companion.getOrCreateInstance(context0);
                }
                else if(inAppPurchaseUtils$BillingClientVersion0 == BillingClientVersion.V5_V7) {
                    h0.a = InAppPurchaseBillingClientWrapperV5V7.Companion.getOrCreateInstance(context0);
                }
                if(h0.a == null) {
                    atomicBoolean0.set(true);
                    return;
                }
                if(!FeatureManager.isEnabled(Feature.AndroidIAPSubscriptionAutoLogging) || ProtectedModeManager.isEnabled() && inAppPurchaseUtils$BillingClientVersion0 != inAppPurchaseUtils$BillingClientVersion1) {
                    InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper1 = (InAppPurchaseBillingClientWrapper)h0.a;
                    a a0 = new a(inAppPurchaseUtils$BillingClientVersion0, context0, 1);
                    inAppPurchaseBillingClientWrapper1.queryPurchaseHistory(IAPProductType.INAPP, a0);
                }
                else {
                    InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper0 = (InAppPurchaseBillingClientWrapper)h0.a;
                    k k0 = new k(h0, inAppPurchaseUtils$BillingClientVersion0, context0, 20);
                    inAppPurchaseBillingClientWrapper0.queryPurchaseHistory(IAPProductType.INAPP, k0);
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, InAppPurchaseAutoLogger.class);
            }
        }
    }

    private static final void startIapLogging$lambda$1(H h0, BillingClientVersion inAppPurchaseUtils$BillingClientVersion0, Context context0) {
        Class class0 = InAppPurchaseAutoLogger.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(h0, "$billingClientWrapper");
            q.g(inAppPurchaseUtils$BillingClientVersion0, "$billingClientVersion");
            q.g(context0, "$context");
            InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper0 = (InAppPurchaseBillingClientWrapper)h0.a;
            a a0 = new a(inAppPurchaseUtils$BillingClientVersion0, context0, 0);
            inAppPurchaseBillingClientWrapper0.queryPurchaseHistory(IAPProductType.SUBS, a0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private static final void startIapLogging$lambda$1$lambda$0(BillingClientVersion inAppPurchaseUtils$BillingClientVersion0, Context context0) {
        Class class0 = InAppPurchaseAutoLogger.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(inAppPurchaseUtils$BillingClientVersion0, "$billingClientVersion");
            q.g(context0, "$context");
            q.f("com.iloen.melon", "context.packageName");
            InAppPurchaseAutoLogger.INSTANCE.logPurchase(inAppPurchaseUtils$BillingClientVersion0, "com.iloen.melon");
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private static final void startIapLogging$lambda$2(BillingClientVersion inAppPurchaseUtils$BillingClientVersion0, Context context0) {
        Class class0 = InAppPurchaseAutoLogger.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(inAppPurchaseUtils$BillingClientVersion0, "$billingClientVersion");
            q.g(context0, "$context");
            q.f("com.iloen.melon", "context.packageName");
            InAppPurchaseAutoLogger.INSTANCE.logPurchase(inAppPurchaseUtils$BillingClientVersion0, "com.iloen.melon");
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }
}

