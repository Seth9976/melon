package com.facebook.appevents.iap;

import Tf.o;
import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import je.C;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\r\b\u00C7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\b\u001A\u00020\u0007H\u0007\u00A2\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\n\u0010\u0003J\u000F\u0010\u000B\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u000B\u0010\u0003JY\u0010\u0017\u001A\u00020\u00042\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\f2\u0014\u0010\u0011\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\u00102\u0006\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00020\u0007H\u0007\u00A2\u0006\u0004\b\u0017\u0010\u0018J;\u0010\u0019\u001A\u00020\u00042\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00102\u0006\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u0019\u0010\u001AJ7\u0010\u001D\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\u00102\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\f2\u0006\u0010\u0012\u001A\u00020\u0007H\u0001\u00A2\u0006\u0004\b\u001B\u0010\u001CJM\u0010 \u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00102\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E0\u00102\u0014\u0010\u0011\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\u00102\u0006\u0010\u0013\u001A\u00020\rH\u0001\u00A2\u0006\u0004\b\u001E\u0010\u001FR\u0014\u0010\"\u001A\u00020!8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001A\u00020$8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\'\u001A\u00020\r8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\'\u0010(R\u0014\u0010)\u001A\u00020\r8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001A\u00020\r8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010+\u001A\u00020\r8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b+\u0010(R\u0014\u0010,\u001A\u00020\r8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b,\u0010(R\u0014\u0010-\u001A\u00020\r8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b-\u0010(R\u0014\u0010.\u001A\u00020\r8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b.\u0010(R\u0014\u0010/\u001A\u00020\r8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b/\u0010(R\u0014\u00100\u001A\u00020\r8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b0\u0010(\u00A8\u00061"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseLoggerManager;", "", "<init>", "()V", "Lie/H;", "migrateOldCacheHistory", "deleteOldCacheHistory", "", "getIsFirstAppLaunchWithNewIAP", "()Z", "setAppHasBeenLaunchedWithNewIAP", "updateLatestPossiblePurchaseTime", "", "", "Lorg/json/JSONObject;", "purchaseDetailsMap", "", "skuDetailsMap", "isSubscription", "packageName", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;", "billingClientVersion", "isFirstAppLaunch", "filterPurchaseLogging", "(Ljava/util/Map;Ljava/util/Map;ZLjava/lang/String;Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;Z)V", "logPurchases", "(Ljava/util/Map;ZLcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;Z)V", "cacheDeDupPurchase$facebook_core_release", "(Ljava/util/Map;Z)Ljava/util/Map;", "cacheDeDupPurchase", "constructLoggingReadyMap$facebook_core_release", "(Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)Ljava/util/Map;", "constructLoggingReadyMap", "", "APPROXIMATE_IAP_ENHANCEMENT_RELEASE_TIME", "J", "", "MILLISECONDS_IN_SECONDS", "D", "PURCHASE_TIME", "Ljava/lang/String;", "IAP_SKU_CACHE_GPBLV1", "IAP_PURCHASE_CACHE_GPBLV1", "IAP_CACHE_OLD", "IAP_CACHE_GPBLV2V7", "CACHED_PURCHASES_KEY", "APP_HAS_BEEN_LAUNCHED_KEY", "TIME_OF_LAST_LOGGED_PURCHASE_KEY", "TIME_OF_LAST_LOGGED_SUBSCRIPTION_KEY", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InAppPurchaseLoggerManager {
    private static final long APPROXIMATE_IAP_ENHANCEMENT_RELEASE_TIME = 1736528400000L;
    @NotNull
    private static final String APP_HAS_BEEN_LAUNCHED_KEY = "APP_HAS_BEEN_LAUNCHED_KEY";
    @NotNull
    private static final String CACHED_PURCHASES_KEY = "PURCHASE_DETAILS_SET";
    @NotNull
    private static final String IAP_CACHE_GPBLV2V7 = "com.facebook.internal.iap.IAP_CACHE_GPBLV2V7";
    @NotNull
    private static final String IAP_CACHE_OLD = "com.facebook.internal.iap.PRODUCT_DETAILS";
    @NotNull
    private static final String IAP_PURCHASE_CACHE_GPBLV1 = "com.facebook.internal.PURCHASE";
    @NotNull
    private static final String IAP_SKU_CACHE_GPBLV1 = "com.facebook.internal.SKU_DETAILS";
    @NotNull
    public static final InAppPurchaseLoggerManager INSTANCE = null;
    private static final double MILLISECONDS_IN_SECONDS = 1000.0;
    @NotNull
    private static final String PURCHASE_TIME = "purchaseTime";
    @NotNull
    private static final String TIME_OF_LAST_LOGGED_PURCHASE_KEY = "TIME_OF_LAST_LOGGED_PURCHASE";
    @NotNull
    private static final String TIME_OF_LAST_LOGGED_SUBSCRIPTION_KEY = "TIME_OF_LAST_LOGGED_SUBSCRIPTION";

    static {
        InAppPurchaseLoggerManager.INSTANCE = new InAppPurchaseLoggerManager();
    }

    @NotNull
    public final Map cacheDeDupPurchase$facebook_core_release(@NotNull Map map0, boolean z) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            q.g(map0, "purchaseDetailsMap");
            SharedPreferences sharedPreferences0 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.iap.IAP_CACHE_GPBLV2V7", 0);
            long v = z ? sharedPreferences0.getLong("TIME_OF_LAST_LOGGED_SUBSCRIPTION", 1736528400000L) : sharedPreferences0.getLong("TIME_OF_LAST_LOGGED_PURCHASE", 1736528400000L);
            Iterator iterator0 = C.Z(map0).entrySet().iterator();
            long v1 = 0L;
            while(true) {
                if(!iterator0.hasNext()) {
                    if(v1 >= v) {
                        if(z) {
                            sharedPreferences0.edit().putLong("TIME_OF_LAST_LOGGED_SUBSCRIPTION", v1).apply();
                        }
                        else {
                            sharedPreferences0.edit().putLong("TIME_OF_LAST_LOGGED_PURCHASE", v1).apply();
                        }
                    }
                    return new HashMap(map0);
                }
                Object object0 = iterator0.next();
                String s = (String)((Map.Entry)object0).getKey();
                JSONObject jSONObject0 = (JSONObject)((Map.Entry)object0).getValue();
                try {
                    if(!jSONObject0.has("purchaseToken") || !jSONObject0.has("purchaseTime")) {
                        continue;
                    }
                    long v2 = jSONObject0.getLong("purchaseTime");
                    if(v2 <= v) {
                        map0.remove(s);
                    }
                    v1 = Math.max(v1, v2);
                }
                catch(Exception unused_ex) {
                }
            }
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    @NotNull
    public final Map constructLoggingReadyMap$facebook_core_release(@NotNull Map map0, @NotNull Map map1, @NotNull String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            q.g(map0, "purchaseDetailsMap");
            q.g(map1, "skuDetailsMap");
            q.g(s, "packageName");
            Map map2 = new LinkedHashMap();
            Iterator iterator0 = map0.entrySet().iterator();
            while(true) {
                if(!iterator0.hasNext()) {
                    return map2;
                }
                Object object0 = iterator0.next();
                String s1 = (String)((Map.Entry)object0).getKey();
                JSONObject jSONObject0 = (JSONObject)((Map.Entry)object0).getValue();
                JSONObject jSONObject1 = (JSONObject)map1.get(s1);
                try {
                    jSONObject0.put("packageName", s);
                    if(jSONObject1 == null) {
                        continue;
                    }
                    String s2 = jSONObject0.toString();
                    q.f(s2, "purchaseDetail.toString()");
                    String s3 = jSONObject1.toString();
                    q.f(s3, "skuDetail.toString()");
                    map2.put(s2, s3);
                }
                catch(Exception unused_ex) {
                }
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    public static final void deleteOldCacheHistory() {
        Class class0 = InAppPurchaseLoggerManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences0 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
            SharedPreferences sharedPreferences1 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
            sharedPreferences0.edit().clear().apply();
            sharedPreferences1.edit().clear().apply();
            FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.iap.PRODUCT_DETAILS", 0).edit().clear().apply();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void filterPurchaseLogging(@NotNull Map map0, @NotNull Map map1, boolean z, @NotNull String s, @NotNull BillingClientVersion inAppPurchaseUtils$BillingClientVersion0, boolean z1) {
        Class class0 = InAppPurchaseLoggerManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(map0, "purchaseDetailsMap");
            q.g(map1, "skuDetailsMap");
            q.g(s, "packageName");
            q.g(inAppPurchaseUtils$BillingClientVersion0, "billingClientVersion");
            Map map2 = InAppPurchaseLoggerManager.INSTANCE.cacheDeDupPurchase$facebook_core_release(map0, z);
            Map map3 = InAppPurchaseLoggerManager.INSTANCE.constructLoggingReadyMap$facebook_core_release(map2, map1, s);
            InAppPurchaseLoggerManager.INSTANCE.logPurchases(map3, z, inAppPurchaseUtils$BillingClientVersion0, z1);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final boolean getIsFirstAppLaunchWithNewIAP() {
        Class class0 = InAppPurchaseLoggerManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            return !FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.iap.IAP_CACHE_GPBLV2V7", 0).contains("APP_HAS_BEEN_LAUNCHED_KEY");
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return false;
        }
    }

    private final void logPurchases(Map map0, boolean z, BillingClientVersion inAppPurchaseUtils$BillingClientVersion0, boolean z1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                for(Object object0: map0.entrySet()) {
                    AutomaticAnalyticsLogger.logPurchase(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()), z, inAppPurchaseUtils$BillingClientVersion0, z1);
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public static final void migrateOldCacheHistory() {
        Class class0 = InAppPurchaseLoggerManager.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                SharedPreferences sharedPreferences0 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.iap.IAP_CACHE_GPBLV2V7", 0);
                long v = Math.max(Math.max(sharedPreferences0.getLong("TIME_OF_LAST_LOGGED_PURCHASE", 0L), sharedPreferences0.getLong("TIME_OF_LAST_LOGGED_SUBSCRIPTION", 0L)), 1736528400000L);
                CopyOnWriteArraySet copyOnWriteArraySet0 = new CopyOnWriteArraySet();
                SharedPreferences sharedPreferences1 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.iap.PRODUCT_DETAILS", 0);
                if(!sharedPreferences1.contains("PURCHASE_DETAILS_SET")) {
                    sharedPreferences0.edit().putLong("TIME_OF_LAST_LOGGED_SUBSCRIPTION", v).apply();
                    sharedPreferences0.edit().putLong("TIME_OF_LAST_LOGGED_PURCHASE", v).apply();
                    InAppPurchaseLoggerManager.deleteOldCacheHistory();
                    return;
                }
                Set set0 = sharedPreferences1.getStringSet("PURCHASE_DETAILS_SET", new HashSet());
                Collection collection0 = set0 == null ? new HashSet() : set0;
                copyOnWriteArraySet0.addAll(collection0);
                Iterator iterator0 = copyOnWriteArraySet0.iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        sharedPreferences0.edit().putLong("TIME_OF_LAST_LOGGED_SUBSCRIPTION", v).apply();
                        sharedPreferences0.edit().putLong("TIME_OF_LAST_LOGGED_PURCHASE", v).apply();
                        InAppPurchaseLoggerManager.deleteOldCacheHistory();
                        return;
                    }
                    Object object0 = iterator0.next();
                    String s = (String)object0;
                    try {
                        long v1 = Long.parseLong(((String)o.R0(s, new String[]{";"}, 2, 2).get(1))) * 1000L;
                        if(((double)Math.abs(String.valueOf(v1).length() - 13)) >= 3.0) {
                            continue;
                        }
                        v = Math.max(v, v1);
                    }
                    catch(Exception unused_ex) {
                    }
                }
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void setAppHasBeenLaunchedWithNewIAP() {
        Class class0 = InAppPurchaseLoggerManager.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                SharedPreferences sharedPreferences0 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.iap.IAP_CACHE_GPBLV2V7", 0);
                try {
                    sharedPreferences0.edit().putBoolean("APP_HAS_BEEN_LAUNCHED_KEY", true).apply();
                }
                catch(Exception unused_ex) {
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
            }
        }
    }

    public static final void updateLatestPossiblePurchaseTime() {
        Class class0 = InAppPurchaseLoggerManager.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                InAppPurchaseLoggerManager.setAppHasBeenLaunchedWithNewIAP();
                try {
                    SharedPreferences sharedPreferences0 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.iap.IAP_CACHE_GPBLV2V7", 0);
                    long v = System.currentTimeMillis();
                    sharedPreferences0.edit().putLong("TIME_OF_LAST_LOGGED_SUBSCRIPTION", v).apply();
                    sharedPreferences0.edit().putLong("TIME_OF_LAST_LOGGED_PURCHASE", v).apply();
                }
                catch(Exception unused_ex) {
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
            }
        }
    }
}

