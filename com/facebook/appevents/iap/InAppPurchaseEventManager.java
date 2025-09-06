package com.facebook.appevents.iap;

import Tf.o;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001A\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00C7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0007\u00A2\u0006\u0004\b\b\u0010\tJM\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B0\u00112\u0006\u0010\u0005\u001A\u00020\u00042\u0016\u0010\r\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\nj\b\u0012\u0004\u0012\u00020\u000B`\f2\b\u0010\u000E\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001A\u00020\u000FH\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0013JM\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B0\u00112\u0006\u0010\u0005\u001A\u00020\u00042\u0016\u0010\r\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\nj\b\u0012\u0004\u0012\u00020\u000B`\f2\b\u0010\u000E\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0013J3\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B0\u00152\u0016\u0010\r\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\nj\b\u0012\u0004\u0012\u00020\u000B`\fH\u0002\u00A2\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001A\u001A\u00020\u00192\u0012\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B0\u0011H\u0002\u00A2\u0006\u0004\b\u001A\u0010\u001BJ)\u0010\u001D\u001A\u00020\u000F2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u000E\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u001C\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u001D\u0010\u001EJ1\u0010\u001F\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\nj\b\u0012\u0004\u0012\u00020\u000B`\f2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001H\u0007\u00A2\u0006\u0004\b\u001F\u0010 J1\u0010!\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\nj\b\u0012\u0004\u0012\u00020\u000B`\f2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001H\u0007\u00A2\u0006\u0004\b!\u0010 J9\u0010\"\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\nj\b\u0012\u0004\u0012\u00020\u000B`\f2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u000E\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u001C\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\"\u0010#J1\u0010$\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\nj\b\u0012\u0004\u0012\u00020\u000B`\f2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001H\u0007\u00A2\u0006\u0004\b$\u0010 J7\u0010%\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\nj\b\u0012\u0004\u0012\u00020\u000B`\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u001C\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b%\u0010#J7\u0010\'\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\nj\b\u0012\u0004\u0012\u00020\u000B`\f2\u0016\u0010&\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\nj\b\u0012\u0004\u0012\u00020\u000B`\fH\u0002\u00A2\u0006\u0004\b\'\u0010(J%\u0010-\u001A\u0004\u0018\u00010,2\n\u0010*\u001A\u0006\u0012\u0002\b\u00030)2\u0006\u0010+\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b-\u0010.J%\u00100\u001A\b\u0012\u0002\b\u0003\u0018\u00010)2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010/\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b0\u00101JC\u00105\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010/\u001A\u00020\u000B2\u0006\u0010+\u001A\u00020\u000B2\b\u00102\u001A\u0004\u0018\u00010\u00012\u000E\u00104\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000103H\u0002\u00A2\u0006\u0004\b5\u00106J\u000F\u00107\u001A\u00020\u0019H\u0007\u00A2\u0006\u0004\b7\u0010\u0003J\u0015\u00109\u001A\u00020\u000F2\u0006\u00108\u001A\u00020\u000B\u00A2\u0006\u0004\b9\u0010:R0\u0010=\u001A\u001E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020,0;j\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020,`<8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b=\u0010>R8\u0010?\u001A&\u0012\u0004\u0012\u00020\u000B\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0;j\u0012\u0012\u0004\u0012\u00020\u000B\u0012\b\u0012\u0006\u0012\u0002\b\u00030)`<8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b?\u0010>R\u0014\u0010A\u001A\u00020@8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010C\u001A\u00020@8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bC\u0010BR\u0014\u0010D\u001A\u00020\u000B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010F\u001A\u00020\u000B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bF\u0010ER\u0014\u0010G\u001A\u00020@8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bG\u0010BR\u0014\u0010H\u001A\u00020@8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bH\u0010BR\u0014\u0010I\u001A\u00020@8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bI\u0010BR\u0014\u0010J\u001A\u00020\u000B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bJ\u0010ER\u0014\u0010K\u001A\u00020\u000B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bK\u0010ER\u0014\u0010L\u001A\u00020\u000B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bL\u0010ER\u0014\u0010M\u001A\u00020\u000B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bM\u0010ER\u0014\u0010N\u001A\u00020\u000B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bN\u0010ER\u0014\u0010O\u001A\u00020\u000B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bO\u0010ER\u0014\u0010P\u001A\u00020\u000B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bP\u0010ER\u0014\u0010Q\u001A\u00020\u000B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bQ\u0010ER\u0014\u0010R\u001A\u00020\u000B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bR\u0010ER\u0014\u0010S\u001A\u00020\u000B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bS\u0010ER\u0014\u0010T\u001A\u00020\u000B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bT\u0010ER\u0014\u0010U\u001A\u00020\u000B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bU\u0010ER\u0014\u0010V\u001A\u00020\u000B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bV\u0010ER\u001C\u0010X\u001A\n W*\u0004\u0018\u00010\u000B0\u000B8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bX\u0010ER\u0014\u0010Y\u001A\u00020\u000B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bY\u0010ER\u0014\u0010Z\u001A\u00020\u000B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bZ\u0010ER\u001C\u0010\\\u001A\n W*\u0004\u0018\u00010[0[8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\\\u0010]R\u001C\u0010^\u001A\n W*\u0004\u0018\u00010[0[8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b^\u0010]\u00A8\u0006_"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseEventManager;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/os/IBinder;", "service", "asInterface", "(Landroid/content/Context;Landroid/os/IBinder;)Ljava/lang/Object;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "skuList", "inAppBillingObj", "", "isSubscription", "", "getSkuDetails", "(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/Object;Z)Ljava/util/Map;", "getSkuDetailsFromGoogle", "", "readSkuDetailsFromCache", "(Ljava/util/ArrayList;)Ljava/util/Map;", "skuDetailsMap", "Lie/H;", "writeSkuDetailsToCache", "(Ljava/util/Map;)V", "type", "isBillingSupported", "(Landroid/content/Context;Ljava/lang/Object;Ljava/lang/String;)Z", "getPurchasesInapp", "(Landroid/content/Context;Ljava/lang/Object;)Ljava/util/ArrayList;", "getPurchasesSubs", "getPurchases", "(Landroid/content/Context;Ljava/lang/Object;Ljava/lang/String;)Ljava/util/ArrayList;", "getPurchaseHistoryInapp", "getPurchaseHistory", "purchases", "filterPurchases", "(Ljava/util/ArrayList;)Ljava/util/ArrayList;", "Ljava/lang/Class;", "classObj", "methodName", "Ljava/lang/reflect/Method;", "getMethod", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Method;", "className", "getClass", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Class;", "obj", "", "args", "invokeMethod", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "clearSkuDetailsCache", "skuDetail", "hasFreeTrialPeirod", "(Ljava/lang/String;)Z", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "methodMap", "Ljava/util/HashMap;", "classMap", "", "CACHE_CLEAR_TIME_LIMIT_SEC", "I", "SKU_DETAIL_EXPIRE_TIME_SEC", "SUBSCRIPTION", "Ljava/lang/String;", "INAPP", "PURCHASE_EXPIRE_TIME_SEC", "PURCHASE_STOP_QUERY_TIME_SEC", "MAX_QUERY_PURCHASE_NUM", "IN_APP_BILLING_SERVICE_STUB", "IN_APP_BILLING_SERVICE", "AS_INTERFACE", "GET_SKU_DETAILS", "GET_PURCHASES", "GET_PURCHASE_HISTORY", "IS_BILLING_SUPPORTED", "ITEM_ID_LIST", "RESPONSE_CODE", "DETAILS_LIST", "INAPP_PURCHASE_DATA_LIST", "INAPP_CONTINUATION_TOKEN", "LAST_CLEARED_TIME", "kotlin.jvm.PlatformType", "PACKAGE_NAME", "SKU_DETAILS_STORE", "PURCHASE_INAPP_STORE", "Landroid/content/SharedPreferences;", "skuDetailSharedPrefs", "Landroid/content/SharedPreferences;", "purchaseInappSharedPrefs", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InAppPurchaseEventManager {
    @NotNull
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    @NotNull
    private static final String DETAILS_LIST = "DETAILS_LIST";
    @NotNull
    private static final String GET_PURCHASES = "getPurchases";
    @NotNull
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
    @NotNull
    private static final String GET_SKU_DETAILS = "getSkuDetails";
    @NotNull
    private static final String INAPP = "inapp";
    @NotNull
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    @NotNull
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    @NotNull
    public static final InAppPurchaseEventManager INSTANCE = null;
    @NotNull
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    @NotNull
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    @NotNull
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";
    @NotNull
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    @NotNull
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final String PACKAGE_NAME = null;
    private static final int PURCHASE_EXPIRE_TIME_SEC = 86400;
    @NotNull
    private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
    @NotNull
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    @NotNull
    private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
    @NotNull
    private static final String SUBSCRIPTION = "subs";
    @NotNull
    private static final HashMap classMap;
    @NotNull
    private static final HashMap methodMap;
    private static final SharedPreferences purchaseInappSharedPrefs;
    private static final SharedPreferences skuDetailSharedPrefs;

    static {
        InAppPurchaseEventManager.INSTANCE = new InAppPurchaseEventManager();
        InAppPurchaseEventManager.methodMap = new HashMap();
        InAppPurchaseEventManager.classMap = new HashMap();
        InAppPurchaseEventManager.PACKAGE_NAME = "com.iloen.melon";
        InAppPurchaseEventManager.skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
        InAppPurchaseEventManager.purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
    }

    @Nullable
    public static final Object asInterface(@NotNull Context context0, @Nullable IBinder iBinder0) {
        Class class0 = InAppPurchaseEventManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(context0, "context");
            return InAppPurchaseEventManager.INSTANCE.invokeMethod(context0, "com.android.vending.billing.IInAppBillingService$Stub", "asInterface", null, new Object[]{iBinder0});
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public static final void clearSkuDetailsCache() {
        Class class0 = InAppPurchaseEventManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                long v = System.currentTimeMillis();
                SharedPreferences sharedPreferences0 = InAppPurchaseEventManager.skuDetailSharedPrefs;
                long v1 = sharedPreferences0.getLong("LAST_CLEARED_TIME", 0L);
                if(v1 == 0L) {
                    sharedPreferences0.edit().putLong("LAST_CLEARED_TIME", v / 1000L).apply();
                    return;
                }
                if(v / 1000L - v1 > 604800L) {
                    sharedPreferences0.edit().clear().putLong("LAST_CLEARED_TIME", v / 1000L).apply();
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private final ArrayList filterPurchases(ArrayList arrayList0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList1 = new ArrayList();
            SharedPreferences.Editor sharedPreferences$Editor0 = InAppPurchaseEventManager.purchaseInappSharedPrefs.edit();
            long v = System.currentTimeMillis();
            Iterator iterator0 = arrayList0.iterator();
            while(true) {
                if(!iterator0.hasNext()) {
                    sharedPreferences$Editor0.apply();
                    return arrayList1;
                }
                Object object0 = iterator0.next();
                String s = (String)object0;
                try {
                    JSONObject jSONObject0 = new JSONObject(s);
                    String s1 = jSONObject0.getString("productId");
                    long v1 = jSONObject0.getLong("purchaseTime");
                    String s2 = jSONObject0.getString("purchaseToken");
                    if(v / 1000L - v1 / 1000L > 86400L || q.b(InAppPurchaseEventManager.purchaseInappSharedPrefs.getString(s1, ""), s2)) {
                        continue;
                    }
                    sharedPreferences$Editor0.putString(s1, s2);
                    arrayList1.add(s);
                }
                catch(JSONException unused_ex) {
                }
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    private final Class getClass(Context context0, String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap hashMap0 = InAppPurchaseEventManager.classMap;
            Class class0 = (Class)hashMap0.get(s);
            if(class0 != null) {
                return class0;
            }
            Class class1 = InAppPurchaseUtils.getClassFromContext$facebook_core_release(context0, s);
            if(class1 != null) {
                hashMap0.put(s, class1);
                return class1;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
        return null;
    }

    private final Method getMethod(Class class0, String s) {
        Class[] arr_class;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap hashMap0 = InAppPurchaseEventManager.methodMap;
            Method method0 = (Method)hashMap0.get(s);
            if(method0 != null) {
                return method0;
            }
            Class class1 = Bundle.class;
            Class class2 = Integer.TYPE;
            Class class3 = String.class;
            switch(s) {
                case "asInterface": {
                    arr_class = new Class[]{IBinder.class};
                    break;
                }
                case "getPurchaseHistory": {
                    q.f(class2, "TYPE");
                    arr_class = new Class[]{class2, class3, class3, class3, class1};
                    break;
                }
                case "getPurchases": {
                    q.f(class2, "TYPE");
                    arr_class = new Class[]{class2, class3, class3, class3};
                    break;
                }
                case "getSkuDetails": {
                    q.f(class2, "TYPE");
                    arr_class = new Class[]{class2, class3, class3, class1};
                    break;
                }
                case "isBillingSupported": {
                    q.f(class2, "TYPE");
                    arr_class = new Class[]{class2, class3, class3};
                    break;
                }
                default: {
                    arr_class = null;
                }
            }
            Method method1 = arr_class == null ? InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(class0, s, new Class[]{0}) : InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(class0, s, ((Class[])Arrays.copyOf(arr_class, arr_class.length)));
            if(method1 != null) {
                hashMap0.put(s, method1);
            }
            return method1;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    private final ArrayList getPurchaseHistory(Context context0, Object object0, String s) {
        String s2;
        int v;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList0 = new ArrayList();
            if(this.isBillingSupported(context0, object0, s)) {
                v = 0;
                String s1 = null;
                boolean z = false;
                while(true) {
                    Bundle bundle0 = new Bundle();
                    Object object1 = this.invokeMethod(context0, "com.android.vending.billing.IInAppBillingService", "getPurchaseHistory", object0, new Object[]{6, InAppPurchaseEventManager.PACKAGE_NAME, s, s1, bundle0});
                    if(object1 == null) {
                        s1 = null;
                    }
                    else {
                        long v1 = System.currentTimeMillis() / 1000L;
                        if(((Bundle)object1).getInt("RESPONSE_CODE") == 0) {
                            ArrayList arrayList1 = ((Bundle)object1).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                            if(arrayList1 == null) {
                                s1 = null;
                            }
                            else {
                                Iterator iterator0 = arrayList1.iterator();
                            label_21:
                                if(iterator0.hasNext()) {
                                    Object object2 = iterator0.next();
                                    s2 = (String)object2;
                                    try {
                                        if(v1 - new JSONObject(s2).getLong("purchaseTime") / 1000L > 1200L) {
                                            z = true;
                                        }
                                        else {
                                            goto label_29;
                                        }
                                    }
                                    catch(JSONException unused_ex) {
                                        goto label_21;
                                    }
                                }
                                s1 = ((Bundle)object1).getString("INAPP_CONTINUATION_TOKEN");
                            }
                        }
                        else {
                            s1 = null;
                        }
                    }
                    if(v >= 30 || s1 == null || z) {
                        break;
                    }
                }
            }
            return arrayList0;
            try {
            label_29:
                arrayList0.add(s2);
                ++v;
            }
            catch(JSONException unused_ex) {
            }
            goto label_21;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @NotNull
    public static final ArrayList getPurchaseHistoryInapp(@NotNull Context context0, @Nullable Object object0) {
        Class class0 = InAppPurchaseEventManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(context0, "context");
            ArrayList arrayList0 = new ArrayList();
            if(object0 != null) {
                Class class1 = InAppPurchaseEventManager.INSTANCE.getClass(context0, "com.android.vending.billing.IInAppBillingService");
                return class1 != null && InAppPurchaseEventManager.INSTANCE.getMethod(class1, "getPurchaseHistory") != null ? InAppPurchaseEventManager.INSTANCE.filterPurchases(InAppPurchaseEventManager.INSTANCE.getPurchaseHistory(context0, object0, "inapp")) : arrayList0;
            }
            return arrayList0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    private final ArrayList getPurchases(Context context0, Object object0, String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList0 = new ArrayList();
            if(object0 != null && this.isBillingSupported(context0, object0, s)) {
                int v = 0;
                String s1 = null;
                while(true) {
                    Object object1 = this.invokeMethod(context0, "com.android.vending.billing.IInAppBillingService", "getPurchases", object0, new Object[]{3, InAppPurchaseEventManager.PACKAGE_NAME, s, s1});
                    if(object1 == null || ((Bundle)object1).getInt("RESPONSE_CODE") != 0) {
                        s1 = null;
                    }
                    else {
                        ArrayList arrayList1 = ((Bundle)object1).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                        if(arrayList1 == null) {
                            break;
                        }
                        v += arrayList1.size();
                        arrayList0.addAll(arrayList1);
                        s1 = ((Bundle)object1).getString("INAPP_CONTINUATION_TOKEN");
                    }
                    if(v >= 30 || s1 == null) {
                        break;
                    }
                }
            }
            return arrayList0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @NotNull
    public static final ArrayList getPurchasesInapp(@NotNull Context context0, @Nullable Object object0) {
        Class class0 = InAppPurchaseEventManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(context0, "context");
            ArrayList arrayList0 = InAppPurchaseEventManager.INSTANCE.getPurchases(context0, object0, "inapp");
            return InAppPurchaseEventManager.INSTANCE.filterPurchases(arrayList0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @NotNull
    public static final ArrayList getPurchasesSubs(@NotNull Context context0, @Nullable Object object0) {
        Class class0 = InAppPurchaseEventManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(context0, "context");
            ArrayList arrayList0 = InAppPurchaseEventManager.INSTANCE.getPurchases(context0, object0, "subs");
            return InAppPurchaseEventManager.INSTANCE.filterPurchases(arrayList0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @NotNull
    public static final Map getSkuDetails(@NotNull Context context0, @NotNull ArrayList arrayList0, @Nullable Object object0, boolean z) {
        Class class0 = InAppPurchaseEventManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(context0, "context");
            q.g(arrayList0, "skuList");
            Map map0 = InAppPurchaseEventManager.INSTANCE.readSkuDetailsFromCache(arrayList0);
            ArrayList arrayList1 = new ArrayList();
            for(Object object1: arrayList0) {
                String s = (String)object1;
                if(!map0.containsKey(s)) {
                    arrayList1.add(s);
                }
            }
            map0.putAll(InAppPurchaseEventManager.INSTANCE.getSkuDetailsFromGoogle(context0, arrayList1, object0, z));
            return map0;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    private final Map getSkuDetailsFromGoogle(Context context0, ArrayList arrayList0, Object object0, boolean z) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Map map0 = new LinkedHashMap();
            if(object0 != null && !arrayList0.isEmpty()) {
                Bundle bundle0 = new Bundle();
                bundle0.putStringArrayList("ITEM_ID_LIST", arrayList0);
                Object object1 = this.invokeMethod(context0, "com.android.vending.billing.IInAppBillingService", "getSkuDetails", object0, new Object[]{3, InAppPurchaseEventManager.PACKAGE_NAME, (z ? "subs" : "inapp"), bundle0});
                if(object1 != null && ((Bundle)object1).getInt("RESPONSE_CODE") == 0) {
                    ArrayList arrayList1 = ((Bundle)object1).getStringArrayList("DETAILS_LIST");
                    if(arrayList1 != null && arrayList0.size() == arrayList1.size()) {
                        int v = arrayList0.size();
                        for(int v1 = 0; v1 < v; ++v1) {
                            Object object2 = arrayList0.get(v1);
                            q.f(object2, "skuList[i]");
                            Object object3 = arrayList1.get(v1);
                            q.f(object3, "skuDetailsList[i]");
                            map0.put(object2, object3);
                        }
                    }
                    this.writeSkuDetailsToCache(map0);
                    return map0;
                }
            }
            return map0;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    public final boolean hasFreeTrialPeirod(@NotNull String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            q.g(s, "skuDetail");
            try {
                String s1 = new JSONObject(s).optString("freeTrialPeriod");
                if(s1 != null && s1.length() > 0) {
                    return true;
                }
            }
            catch(JSONException unused_ex) {
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
        return false;
    }

    private final Object invokeMethod(Context context0, String s, String s1, Object object0, Object[] arr_object) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Class class0 = this.getClass(context0, s);
            if(class0 == null) {
                return null;
            }
            Method method0 = this.getMethod(class0, s1);
            return method0 == null ? null : InAppPurchaseUtils.invokeMethod(class0, method0, object0, Arrays.copyOf(arr_object, arr_object.length));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    private final boolean isBillingSupported(Context context0, Object object0, String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        if(object0 == null) {
            return false;
        }
        try {
            Object object1 = this.invokeMethod(context0, "com.android.vending.billing.IInAppBillingService", "isBillingSupported", object0, new Object[]{3, InAppPurchaseEventManager.PACKAGE_NAME, s});
            if(object1 != null && ((int)(((Integer)object1))) == 0) {
                return true;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
        return false;
    }

    private final Map readSkuDetailsFromCache(ArrayList arrayList0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Map map0 = new LinkedHashMap();
            long v = System.currentTimeMillis();
            for(Object object0: arrayList0) {
                String s = (String)object0;
                String s1 = InAppPurchaseEventManager.skuDetailSharedPrefs.getString(s, null);
                if(s1 != null) {
                    List list0 = o.R0(s1, new String[]{";"}, 2, 2);
                    if(v / 1000L - Long.parseLong(((String)list0.get(0))) < 43200L) {
                        q.f(s, "sku");
                        map0.put(s, list0.get(1));
                    }
                }
            }
            return map0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    private final void writeSkuDetailsToCache(Map map0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            long v = System.currentTimeMillis();
            SharedPreferences.Editor sharedPreferences$Editor0 = InAppPurchaseEventManager.skuDetailSharedPrefs.edit();
            for(Object object0: map0.entrySet()) {
                sharedPreferences$Editor0.putString(((String)((Map.Entry)object0).getKey()), v / 1000L + ';' + ((String)((Map.Entry)object0).getValue()));
            }
            sharedPreferences$Editor0.apply();
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }
}

