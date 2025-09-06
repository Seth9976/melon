package com.facebook.appevents.iap;

import D5.a;
import Tf.v;
import android.content.Context;
import android.util.Log;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import ie.H;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import je.n;
import jeb.synthetic.FIN;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u0000 02\u00020\u0001:\u000510234B\u00A5\u0001\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0006\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\b\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\t\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\n\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\r\u001A\u00020\f\u0012\u0006\u0010\u000E\u001A\u00020\f\u0012\u0006\u0010\u000F\u001A\u00020\f\u0012\u0006\u0010\u0010\u001A\u00020\f\u0012\u0006\u0010\u0011\u001A\u00020\f\u0012\u0006\u0010\u0012\u001A\u00020\f\u0012\u0006\u0010\u0013\u001A\u00020\f\u0012\u0006\u0010\u0015\u001A\u00020\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J/\u0010 \u001A\u00020\u001F2\u0006\u0010\u0019\u001A\u00020\u00182\u000E\u0010\u001C\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001B0\u001A2\u0006\u0010\u001E\u001A\u00020\u001DH\u0002\u00A2\u0006\u0004\b \u0010!J\u0017\u0010#\u001A\u00020\u001F2\u0006\u0010\"\u001A\u00020\u001DH\u0002\u00A2\u0006\u0004\b#\u0010$J\u0019\u0010%\u001A\u00020\u001F2\b\u0010\"\u001A\u0004\u0018\u00010\u001DH\u0002\u00A2\u0006\u0004\b%\u0010$J\u001F\u0010\'\u001A\u00020\u001F2\u0006\u0010&\u001A\u00020\u00182\u0006\u0010\u001E\u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b\'\u0010(J\u001F\u0010)\u001A\u00020\u001F2\u0006\u0010&\u001A\u00020\u00182\u0006\u0010\u001E\u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b)\u0010(R\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0003\u0010*\u001A\u0004\b+\u0010,R\u0018\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010-R\u0018\u0010\u0006\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0006\u0010-R\u0018\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010-R\u0018\u0010\b\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\b\u0010-R\u0018\u0010\t\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\t\u0010-R\u0018\u0010\n\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\n\u0010-R\u0018\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u000B\u0010-R\u0014\u0010\r\u001A\u00020\f8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\r\u0010.R\u0014\u0010\u000E\u001A\u00020\f8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u000E\u0010.R\u0014\u0010\u000F\u001A\u00020\f8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u000F\u0010.R\u0014\u0010\u0010\u001A\u00020\f8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0010\u0010.R\u0014\u0010\u0011\u001A\u00020\f8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0011\u0010.R\u0014\u0010\u0012\u001A\u00020\f8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0012\u0010.R\u0014\u0010\u0013\u001A\u00020\f8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0013\u0010.R\u0014\u0010\u0015\u001A\u00020\u00148\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0015\u0010/\u00A8\u00065"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV2V4;", "Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;", "", "billingClient", "Ljava/lang/Class;", "billingClientClazz", "purchaseResultClazz", "purchaseClazz", "skuDetailsClazz", "purchaseHistoryRecordClazz", "skuDetailsResponseListenerClazz", "purchaseHistoryResponseListenerClazz", "Ljava/lang/reflect/Method;", "queryPurchasesMethod", "getPurchaseListMethod", "getOriginalJsonMethod", "getOriginalJsonSkuMethod", "getOriginalJsonPurchaseHistoryMethod", "querySkuDetailsAsyncMethod", "queryPurchaseHistoryAsyncMethod", "Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;", "inAppPurchaseSkuDetailsWrapper", "<init>", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;)V", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;", "skuType", "", "", "skuIDs", "Ljava/lang/Runnable;", "completionHandler", "Lie/H;", "querySkuDetailsAsync", "(Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;Ljava/util/List;Ljava/lang/Runnable;)V", "runnable", "executeServiceRequest", "(Ljava/lang/Runnable;)V", "startConnection", "productType", "queryPurchases", "(Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;Ljava/lang/Runnable;)V", "queryPurchaseHistory", "Ljava/lang/Object;", "getBillingClient", "()Ljava/lang/Object;", "Ljava/lang/Class;", "Ljava/lang/reflect/Method;", "Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;", "Companion", "BillingClientStateListenerWrapper", "PurchaseHistoryResponseListenerWrapper", "PurchasesUpdatedListenerWrapper", "SkuDetailsResponseListenerWrapper", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InAppPurchaseBillingClientWrapperV2V4 implements InAppPurchaseBillingClientWrapper {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\t2\u000E\u0010\n\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000BH\u0096\u0002¢\u0006\u0002\u0010\fR\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV2V4$BillingClientStateListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "runnable", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;)V", "invoke", "", "proxy", "m", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class BillingClientStateListenerWrapper implements InvocationHandler {
        @Nullable
        private final Runnable runnable;

        public BillingClientStateListenerWrapper(@Nullable Runnable runnable0) {
            this.runnable = runnable0;
        }

        @Override
        @Nullable
        public Object invoke(@NotNull Object object0, @NotNull Method method0, @Nullable Object[] arr_object) {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            else {
                try {
                    q.g(object0, "proxy");
                    q.g(method0, "m");
                    if(q.b(method0.getName(), "onBillingSetupFinished")) {
                        Object object1 = arr_object == null ? null : n.n0(0, arr_object);
                        Class class0 = InAppPurchaseUtils.getClass("com.android.billingclient.api.BillingResult");
                        if(class0 != null) {
                            Method method1 = InAppPurchaseUtils.getMethod(class0, "getResponseCode", new Class[0]);
                            if(method1 != null && q.b(InAppPurchaseUtils.invokeMethod(class0, method1, object1, new Object[0]), 0)) {
                                InAppPurchaseBillingClientWrapperV2V4.Companion.isServiceConnected().set(true);
                                Runnable runnable0 = this.runnable;
                                if(runnable0 != null) {
                                    runnable0.run();
                                    return null;
                                }
                            }
                        }
                    }
                    else {
                        String s = method0.getName();
                        q.f(s, "m.name");
                        if(v.i0(s, "onBillingServiceDisconnected", false)) {
                            InAppPurchaseBillingClientWrapperV2V4.Companion.isServiceConnected().set(false);
                        }
                    }
                    return null;
                }
                catch(Throwable throwable0) {
                }
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0014\u001A\u0004\u0018\u00010\u00012\b\u0010\u0015\u001A\u0004\u0018\u00010\u00162\n\u0010\u0017\u001A\u0006\u0012\u0002\b\u00030\u0018H\u0002J\u0012\u0010\u0019\u001A\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001A\u00020\u0016H\u0002J\u0012\u0010\u001A\u001A\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001A\u00020\u0016H\u0007R\u0016\u0010\u0003\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001D\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000FR\u001D\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\nR\u001D\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\n¨\u0006\u001B"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV2V4$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "iapPurchaseDetailsMap", "", "Lorg/json/JSONObject;", "getIapPurchaseDetailsMap", "()Ljava/util/Map;", "instance", "Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV2V4;", "isServiceConnected", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "skuDetailsMap", "getSkuDetailsMap", "subsPurchaseDetailsMap", "getSubsPurchaseDetailsMap", "createBillingClient", "context", "Landroid/content/Context;", "billingClientClazz", "Ljava/lang/Class;", "createInstance", "getOrCreateInstance", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final Object createBillingClient(Context context0, Class class0) {
            Class class1 = InAppPurchaseUtils.getClass("com.android.billingclient.api.BillingClient$Builder");
            Class class2 = InAppPurchaseUtils.getClass("com.android.billingclient.api.PurchasesUpdatedListener");
            if(class1 != null && class2 != null) {
                Method method0 = InAppPurchaseUtils.getMethod(class0, "newBuilder", new Class[]{Context.class});
                Method method1 = InAppPurchaseUtils.getMethod(class1, "enablePendingPurchases", new Class[0]);
                Method method2 = InAppPurchaseUtils.getMethod(class1, "setListener", new Class[]{class2});
                Method method3 = InAppPurchaseUtils.getMethod(class1, "build", new Class[0]);
                if(method0 != null && method1 != null && method2 != null && method3 != null) {
                    Object object0 = InAppPurchaseUtils.invokeMethod(class0, method0, null, new Object[]{context0});
                    if(object0 == null) {
                        return null;
                    }
                    PurchasesUpdatedListenerWrapper inAppPurchaseBillingClientWrapperV2V4$PurchasesUpdatedListenerWrapper0 = new PurchasesUpdatedListenerWrapper();
                    Object object1 = InAppPurchaseUtils.invokeMethod(class1, method2, object0, new Object[]{Proxy.newProxyInstance(class2.getClassLoader(), new Class[]{class2}, inAppPurchaseBillingClientWrapperV2V4$PurchasesUpdatedListenerWrapper0)});
                    if(object1 == null) {
                        return null;
                    }
                    Object object2 = InAppPurchaseUtils.invokeMethod(class1, method1, object1, new Object[0]);
                    return object2 == null ? null : InAppPurchaseUtils.invokeMethod(class1, method3, object2, new Object[0]);
                }
            }
            return null;
        }

        private final InAppPurchaseBillingClientWrapperV2V4 createInstance(Context context0) {
            InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper0 = InAppPurchaseSkuDetailsWrapper.Companion.getOrCreateInstance();
            if(inAppPurchaseSkuDetailsWrapper0 == null) {
                return null;
            }
            Class class0 = InAppPurchaseUtils.getClass("com.android.billingclient.api.BillingClient");
            Class class1 = InAppPurchaseUtils.getClass("com.android.billingclient.api.Purchase");
            Class class2 = InAppPurchaseUtils.getClass("com.android.billingclient.api.Purchase$PurchasesResult");
            Class class3 = InAppPurchaseUtils.getClass("com.android.billingclient.api.SkuDetails");
            Class class4 = InAppPurchaseUtils.getClass("com.android.billingclient.api.PurchaseHistoryRecord");
            Class class5 = InAppPurchaseUtils.getClass("com.android.billingclient.api.SkuDetailsResponseListener");
            Class class6 = InAppPurchaseUtils.getClass("com.android.billingclient.api.PurchaseHistoryResponseListener");
            if(class0 == null || class2 == null || class1 == null || class3 == null || class5 == null || class4 == null || class6 == null) {
                Log.w(InAppPurchaseBillingClientWrapperV2V4.access$getTAG$cp(), "Failed to create Google Play billing library wrapper for in-app purchase auto-logging");
                return null;
            }
            Method method0 = InAppPurchaseUtils.getMethod(class0, "queryPurchases", new Class[]{String.class});
            Method method1 = InAppPurchaseUtils.getMethod(class2, "getPurchasesList", new Class[0]);
            Method method2 = InAppPurchaseUtils.getMethod(class1, "getOriginalJson", new Class[0]);
            Method method3 = InAppPurchaseUtils.getMethod(class3, "getOriginalJson", new Class[0]);
            Method method4 = InAppPurchaseUtils.getMethod(class4, "getOriginalJson", new Class[0]);
            Method method5 = InAppPurchaseUtils.getMethod(class0, "querySkuDetailsAsync", new Class[]{inAppPurchaseSkuDetailsWrapper0.getSkuDetailsParamsClazz(), class5});
            Method method6 = InAppPurchaseUtils.getMethod(class0, "queryPurchaseHistoryAsync", new Class[]{String.class, class6});
            if(method0 != null && method1 != null && method2 != null && method3 != null && method4 != null && method5 != null && method6 != null) {
                Object object0 = this.createBillingClient(context0, class0);
                if(object0 == null) {
                    Log.w(InAppPurchaseBillingClientWrapperV2V4.access$getTAG$cp(), "Failed to build a Google Play billing library wrapper for in-app purchase auto-logging");
                    return null;
                }
                InAppPurchaseBillingClientWrapperV2V4.access$setInstance$cp(new InAppPurchaseBillingClientWrapperV2V4(object0, class0, class2, class1, class3, class4, class5, class6, method0, method1, method2, method3, method4, method5, method6, inAppPurchaseSkuDetailsWrapper0, null));
                return InAppPurchaseBillingClientWrapperV2V4.access$getInstance$cp();
            }
            Log.w(InAppPurchaseBillingClientWrapperV2V4.access$getTAG$cp(), "Failed to create Google Play billing library wrapper for in-app purchase auto-logging");
            return null;
        }

        @NotNull
        public final Map getIapPurchaseDetailsMap() {
            return InAppPurchaseBillingClientWrapperV2V4.access$getIapPurchaseDetailsMap$cp();
        }

        @Nullable
        public final InAppPurchaseBillingClientWrapperV2V4 getOrCreateInstance(@NotNull Context context0) {
            synchronized(this) {
                q.g(context0, "context");
                InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V40 = InAppPurchaseBillingClientWrapperV2V4.access$getInstance$cp();
                if(inAppPurchaseBillingClientWrapperV2V40 == null) {
                    inAppPurchaseBillingClientWrapperV2V40 = this.createInstance(context0);
                }
                return inAppPurchaseBillingClientWrapperV2V40;
            }
        }

        @NotNull
        public final Map getSkuDetailsMap() {
            return InAppPurchaseBillingClientWrapperV2V4.access$getSkuDetailsMap$cp();
        }

        @NotNull
        public final Map getSubsPurchaseDetailsMap() {
            return InAppPurchaseBillingClientWrapperV2V4.access$getSubsPurchaseDetailsMap$cp();
        }

        @NotNull
        public final AtomicBoolean isServiceConnected() {
            return InAppPurchaseBillingClientWrapperV2V4.access$isServiceConnected$cp();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u000E\u0010\r\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0016\u0010\u0005\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV2V4$PurchaseHistoryResponseListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;", "skuType", "Ljava/lang/Runnable;", "completionHandler", "<init>", "(Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV2V4;Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;Ljava/lang/Runnable;)V", "", "proxy", "Ljava/lang/reflect/Method;", "method", "", "args", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)V", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;", "Ljava/lang/Runnable;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public final class PurchaseHistoryResponseListenerWrapper implements InvocationHandler {
        @NotNull
        private Runnable completionHandler;
        @NotNull
        private IAPProductType skuType;

        public PurchaseHistoryResponseListenerWrapper(@NotNull IAPProductType inAppPurchaseUtils$IAPProductType0, @NotNull Runnable runnable0) {
            q.g(inAppPurchaseUtils$IAPProductType0, "skuType");
            q.g(runnable0, "completionHandler");
            InAppPurchaseBillingClientWrapperV2V4.this = inAppPurchaseBillingClientWrapperV2V40;
            super();
            this.skuType = inAppPurchaseUtils$IAPProductType0;
            this.completionHandler = runnable0;
        }

        @Override
        public Object invoke(Object object0, Method method0, Object[] arr_object) {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                this.invoke(object0, method0, arr_object);
                return H.a;
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
                return null;
            }
        }

        public void invoke(@NotNull Object object0, @NotNull Method method0, @Nullable Object[] arr_object) {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            else {
                try {
                    q.g(object0, "proxy");
                    q.g(method0, "method");
                    if(q.b(method0.getName(), "onPurchaseHistoryResponse")) {
                        Object object1 = arr_object == null ? null : n.n0(1, arr_object);
                        if(object1 != null && object1 instanceof List) {
                            ArrayList arrayList0 = new ArrayList();
                            Iterator iterator0 = ((List)object1).iterator();
                            while(true) {
                                if(!iterator0.hasNext()) {
                                    if(!arrayList0.isEmpty()) {
                                        InAppPurchaseBillingClientWrapperV2V4.access$querySkuDetailsAsync(InAppPurchaseBillingClientWrapperV2V4.this, this.skuType, arrayList0, this.completionHandler);
                                        return;
                                    }
                                    this.completionHandler.run();
                                    return;
                                }
                                Object object2 = iterator0.next();
                                try {
                                    Object object3 = InAppPurchaseUtils.invokeMethod(InAppPurchaseBillingClientWrapperV2V4.access$getPurchaseHistoryRecordClazz$p(InAppPurchaseBillingClientWrapperV2V4.this), InAppPurchaseBillingClientWrapperV2V4.access$getGetOriginalJsonPurchaseHistoryMethod$p(InAppPurchaseBillingClientWrapperV2V4.this), object2, new Object[0]);
                                    String s = object3 instanceof String ? ((String)object3) : null;
                                    if(s == null) {
                                        continue;
                                    }
                                    JSONObject jSONObject0 = new JSONObject(s);
                                    if(!jSONObject0.has("productId")) {
                                        continue;
                                    }
                                    String s1 = jSONObject0.getString("productId");
                                    q.f(s1, "skuID");
                                    arrayList0.add(s1);
                                    if(this.skuType == IAPProductType.INAPP) {
                                        InAppPurchaseBillingClientWrapperV2V4.Companion.getIapPurchaseDetailsMap().put(s1, jSONObject0);
                                        continue;
                                    }
                                    InAppPurchaseBillingClientWrapperV2V4.Companion.getSubsPurchaseDetailsMap().put(s1, jSONObject0);
                                }
                                catch(Exception unused_ex) {
                                }
                            }
                        }
                    }
                    return;
                }
                catch(Throwable throwable0) {
                }
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00072\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0002\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV2V4$PurchasesUpdatedListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "()V", "invoke", "", "proxy", "m", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class PurchasesUpdatedListenerWrapper implements InvocationHandler {
        @Override
        @Nullable
        public Object invoke(@NotNull Object object0, @NotNull Method method0, @Nullable Object[] arr_object) {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                q.g(object0, "proxy");
                q.g(method0, "m");
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\r\u001A\u00020\f2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u000E\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000ER\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0003\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV2V4$SkuDetailsResponseListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "Ljava/lang/Runnable;", "completionHandler", "<init>", "(Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV2V4;Ljava/lang/Runnable;)V", "", "proxy", "Ljava/lang/reflect/Method;", "m", "", "args", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)V", "Ljava/lang/Runnable;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public final class SkuDetailsResponseListenerWrapper implements InvocationHandler {
        @NotNull
        private Runnable completionHandler;

        public SkuDetailsResponseListenerWrapper(@NotNull Runnable runnable0) {
            q.g(runnable0, "completionHandler");
            InAppPurchaseBillingClientWrapperV2V4.this = inAppPurchaseBillingClientWrapperV2V40;
            super();
            this.completionHandler = runnable0;
        }

        @Override
        public Object invoke(Object object0, Method method0, Object[] arr_object) {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                this.invoke(object0, method0, arr_object);
                return H.a;
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
                return null;
            }
        }

        public void invoke(@NotNull Object object0, @NotNull Method method0, @Nullable Object[] arr_object) {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            else {
                try {
                    q.g(object0, "proxy");
                    q.g(method0, "m");
                    if(q.b(method0.getName(), "onSkuDetailsResponse")) {
                        Object object1 = arr_object == null ? null : n.n0(1, arr_object);
                        if(object1 != null && object1 instanceof List) {
                            Iterator iterator0 = ((List)object1).iterator();
                            while(true) {
                                if(!iterator0.hasNext()) {
                                    this.completionHandler.run();
                                    return;
                                }
                                Object object2 = iterator0.next();
                                try {
                                    Object object3 = InAppPurchaseUtils.invokeMethod(InAppPurchaseBillingClientWrapperV2V4.access$getSkuDetailsClazz$p(InAppPurchaseBillingClientWrapperV2V4.this), InAppPurchaseBillingClientWrapperV2V4.access$getGetOriginalJsonSkuMethod$p(InAppPurchaseBillingClientWrapperV2V4.this), object2, new Object[0]);
                                    String s = object3 instanceof String ? ((String)object3) : null;
                                    if(s == null) {
                                        continue;
                                    }
                                    JSONObject jSONObject0 = new JSONObject(s);
                                    if(!jSONObject0.has("productId")) {
                                        continue;
                                    }
                                    String s1 = jSONObject0.getString("productId");
                                    Map map0 = InAppPurchaseBillingClientWrapperV2V4.Companion.getSkuDetailsMap();
                                    q.f(s1, "skuID");
                                    map0.put(s1, jSONObject0);
                                }
                                catch(Exception unused_ex) {
                                }
                            }
                        }
                    }
                    return;
                }
                catch(Throwable throwable0) {
                }
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    @NotNull
    public static final Companion Companion;
    private static final String TAG;
    @NotNull
    private final Object billingClient;
    @NotNull
    private final Class billingClientClazz;
    @NotNull
    private final Method getOriginalJsonMethod;
    @NotNull
    private final Method getOriginalJsonPurchaseHistoryMethod;
    @NotNull
    private final Method getOriginalJsonSkuMethod;
    @NotNull
    private final Method getPurchaseListMethod;
    @NotNull
    private static final Map iapPurchaseDetailsMap;
    @NotNull
    private final InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper;
    @Nullable
    private static InAppPurchaseBillingClientWrapperV2V4 instance;
    @NotNull
    private static final AtomicBoolean isServiceConnected;
    @NotNull
    private final Class purchaseClazz;
    @NotNull
    private final Class purchaseHistoryRecordClazz;
    @NotNull
    private final Class purchaseHistoryResponseListenerClazz;
    @NotNull
    private final Class purchaseResultClazz;
    @NotNull
    private final Method queryPurchaseHistoryAsyncMethod;
    @NotNull
    private final Method queryPurchasesMethod;
    @NotNull
    private final Method querySkuDetailsAsyncMethod;
    @NotNull
    private final Class skuDetailsClazz;
    @NotNull
    private static final Map skuDetailsMap;
    @NotNull
    private final Class skuDetailsResponseListenerClazz;
    @NotNull
    private static final Map subsPurchaseDetailsMap;

    static {
        InAppPurchaseBillingClientWrapperV2V4.Companion = new Companion(null);
        InAppPurchaseBillingClientWrapperV2V4.TAG = InAppPurchaseBillingClientWrapperV2V4.class.getCanonicalName();
        InAppPurchaseBillingClientWrapperV2V4.isServiceConnected = new AtomicBoolean(false);
        InAppPurchaseBillingClientWrapperV2V4.iapPurchaseDetailsMap = new ConcurrentHashMap();
        InAppPurchaseBillingClientWrapperV2V4.subsPurchaseDetailsMap = new ConcurrentHashMap();
        InAppPurchaseBillingClientWrapperV2V4.skuDetailsMap = new ConcurrentHashMap();
    }

    private InAppPurchaseBillingClientWrapperV2V4(Object object0, Class class0, Class class1, Class class2, Class class3, Class class4, Class class5, Class class6, Method method0, Method method1, Method method2, Method method3, Method method4, Method method5, Method method6, InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper0) {
        this.billingClient = object0;
        this.billingClientClazz = class0;
        this.purchaseResultClazz = class1;
        this.purchaseClazz = class2;
        this.skuDetailsClazz = class3;
        this.purchaseHistoryRecordClazz = class4;
        this.skuDetailsResponseListenerClazz = class5;
        this.purchaseHistoryResponseListenerClazz = class6;
        this.queryPurchasesMethod = method0;
        this.getPurchaseListMethod = method1;
        this.getOriginalJsonMethod = method2;
        this.getOriginalJsonSkuMethod = method3;
        this.getOriginalJsonPurchaseHistoryMethod = method4;
        this.querySkuDetailsAsyncMethod = method5;
        this.queryPurchaseHistoryAsyncMethod = method6;
        this.inAppPurchaseSkuDetailsWrapper = inAppPurchaseSkuDetailsWrapper0;
    }

    public InAppPurchaseBillingClientWrapperV2V4(Object object0, Class class0, Class class1, Class class2, Class class3, Class class4, Class class5, Class class6, Method method0, Method method1, Method method2, Method method3, Method method4, Method method5, Method method6, InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(object0, class0, class1, class2, class3, class4, class5, class6, method0, method1, method2, method3, method4, method5, method6, inAppPurchaseSkuDetailsWrapper0);
    }

    // 去混淆评级： 低(20)
    public static final Method access$getGetOriginalJsonPurchaseHistoryMethod$p(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V40) {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class) ? null : inAppPurchaseBillingClientWrapperV2V40.getOriginalJsonPurchaseHistoryMethod;
    }

    // 去混淆评级： 低(20)
    public static final Method access$getGetOriginalJsonSkuMethod$p(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V40) {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class) ? null : inAppPurchaseBillingClientWrapperV2V40.getOriginalJsonSkuMethod;
    }

    // 去混淆评级： 低(20)
    public static final Map access$getIapPurchaseDetailsMap$cp() {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class) ? null : InAppPurchaseBillingClientWrapperV2V4.iapPurchaseDetailsMap;
    }

    // 去混淆评级： 低(20)
    public static final InAppPurchaseBillingClientWrapperV2V4 access$getInstance$cp() {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class) ? null : InAppPurchaseBillingClientWrapperV2V4.instance;
    }

    // 去混淆评级： 低(20)
    public static final Class access$getPurchaseHistoryRecordClazz$p(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V40) {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class) ? null : inAppPurchaseBillingClientWrapperV2V40.purchaseHistoryRecordClazz;
    }

    // 去混淆评级： 低(20)
    public static final Class access$getSkuDetailsClazz$p(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V40) {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class) ? null : inAppPurchaseBillingClientWrapperV2V40.skuDetailsClazz;
    }

    // 去混淆评级： 低(20)
    public static final Map access$getSkuDetailsMap$cp() {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class) ? null : InAppPurchaseBillingClientWrapperV2V4.skuDetailsMap;
    }

    // 去混淆评级： 低(20)
    public static final Map access$getSubsPurchaseDetailsMap$cp() {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class) ? null : InAppPurchaseBillingClientWrapperV2V4.subsPurchaseDetailsMap;
    }

    // 去混淆评级： 低(20)
    public static final String access$getTAG$cp() {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class) ? null : InAppPurchaseBillingClientWrapperV2V4.TAG;
    }

    // 去混淆评级： 低(20)
    public static final AtomicBoolean access$isServiceConnected$cp() {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class) ? null : InAppPurchaseBillingClientWrapperV2V4.isServiceConnected;
    }

    public static final void access$querySkuDetailsAsync(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V40, IAPProductType inAppPurchaseUtils$IAPProductType0, List list0, Runnable runnable0) {
        Class class0 = InAppPurchaseBillingClientWrapperV2V4.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV2V40.querySkuDetailsAsync(inAppPurchaseUtils$IAPProductType0, list0, runnable0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void access$setInstance$cp(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V40) {
        if(CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            return;
        }
        InAppPurchaseBillingClientWrapperV2V4.instance = inAppPurchaseBillingClientWrapperV2V40;
    }

    private final void executeServiceRequest(Runnable runnable0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if(InAppPurchaseBillingClientWrapperV2V4.isServiceConnected.get()) {
                runnable0.run();
                return;
            }
            this.startConnection(runnable0);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    // 去混淆评级： 低(20)
    @Override  // com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper
    @NotNull
    public Object getBillingClient() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : this.billingClient;
    }

    @Nullable
    public static final InAppPurchaseBillingClientWrapperV2V4 getOrCreateInstance(@NotNull Context context0) {
        Class class0 = InAppPurchaseBillingClientWrapperV2V4.class;
        __monitor_enter(class0);
        int v = FIN.finallyOpen$NT();
        if(CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            FIN.finallyCodeBegin$NT(v);
            __monitor_exit(class0);
            FIN.finallyCodeEnd$NT(v);
            return null;
        }
        try {
            InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V40 = InAppPurchaseBillingClientWrapperV2V4.Companion.getOrCreateInstance(context0);
            FIN.finallyExec$NT(v);
            return inAppPurchaseBillingClientWrapperV2V40;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, InAppPurchaseBillingClientWrapperV2V4.class);
            FIN.finallyExec$NT(v);
            return null;
        }
    }

    @Override  // com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper
    public void queryPurchaseHistory(@NotNull IAPProductType inAppPurchaseUtils$IAPProductType0, @NotNull Runnable runnable0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(inAppPurchaseUtils$IAPProductType0, "productType");
            q.g(runnable0, "completionHandler");
            this.executeServiceRequest(new b(this, inAppPurchaseUtils$IAPProductType0, runnable0, 0));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private static final void queryPurchaseHistory$lambda$2(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V40, IAPProductType inAppPurchaseUtils$IAPProductType0, Runnable runnable0) {
        Class class0 = InAppPurchaseBillingClientWrapperV2V4.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(inAppPurchaseBillingClientWrapperV2V40, "this$0");
            q.g(inAppPurchaseUtils$IAPProductType0, "$productType");
            q.g(runnable0, "$completionHandler");
            PurchaseHistoryResponseListenerWrapper inAppPurchaseBillingClientWrapperV2V4$PurchaseHistoryResponseListenerWrapper0 = new PurchaseHistoryResponseListenerWrapper(inAppPurchaseBillingClientWrapperV2V40, inAppPurchaseUtils$IAPProductType0, runnable0);
            Object object0 = Proxy.newProxyInstance(inAppPurchaseBillingClientWrapperV2V40.purchaseHistoryResponseListenerClazz.getClassLoader(), new Class[]{inAppPurchaseBillingClientWrapperV2V40.purchaseHistoryResponseListenerClazz}, inAppPurchaseBillingClientWrapperV2V4$PurchaseHistoryResponseListenerWrapper0);
            Object object1 = inAppPurchaseBillingClientWrapperV2V40.getBillingClient();
            InAppPurchaseUtils.invokeMethod(inAppPurchaseBillingClientWrapperV2V40.billingClientClazz, inAppPurchaseBillingClientWrapperV2V40.queryPurchaseHistoryAsyncMethod, object1, new Object[]{inAppPurchaseUtils$IAPProductType0.getType(), object0});
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    @Override  // com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper
    public void queryPurchases(@NotNull IAPProductType inAppPurchaseUtils$IAPProductType0, @NotNull Runnable runnable0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(inAppPurchaseUtils$IAPProductType0, "productType");
            q.g(runnable0, "completionHandler");
            this.executeServiceRequest(new b(this, inAppPurchaseUtils$IAPProductType0, runnable0, 1));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private static final void queryPurchases$lambda$0(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V40, IAPProductType inAppPurchaseUtils$IAPProductType0, Runnable runnable0) {
        Class class0 = InAppPurchaseBillingClientWrapperV2V4.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                q.g(inAppPurchaseBillingClientWrapperV2V40, "this$0");
                q.g(inAppPurchaseUtils$IAPProductType0, "$productType");
                q.g(runnable0, "$completionHandler");
                Object object0 = inAppPurchaseBillingClientWrapperV2V40.getBillingClient();
                Object object1 = InAppPurchaseUtils.invokeMethod(inAppPurchaseBillingClientWrapperV2V40.billingClientClazz, inAppPurchaseBillingClientWrapperV2V40.queryPurchasesMethod, object0, new Object[]{inAppPurchaseUtils$IAPProductType0.getType()});
                Object object2 = InAppPurchaseUtils.invokeMethod(inAppPurchaseBillingClientWrapperV2V40.purchaseResultClazz, inAppPurchaseBillingClientWrapperV2V40.getPurchaseListMethod, object1, new Object[0]);
                List list0 = object2 instanceof List ? ((List)object2) : null;
                try {
                    ArrayList arrayList0 = new ArrayList();
                    if(list0 != null) {
                        for(Object object3: list0) {
                            Object object4 = InAppPurchaseUtils.invokeMethod(inAppPurchaseBillingClientWrapperV2V40.purchaseClazz, inAppPurchaseBillingClientWrapperV2V40.getOriginalJsonMethod, object3, new Object[0]);
                            String s = object4 instanceof String ? ((String)object4) : null;
                            if(s != null) {
                                JSONObject jSONObject0 = new JSONObject(s);
                                if(jSONObject0.has("productId")) {
                                    String s1 = jSONObject0.getString("productId");
                                    arrayList0.add(s1);
                                    if(inAppPurchaseUtils$IAPProductType0 == IAPProductType.INAPP) {
                                        q.f(s1, "skuID");
                                        InAppPurchaseBillingClientWrapperV2V4.iapPurchaseDetailsMap.put(s1, jSONObject0);
                                    }
                                    else {
                                        q.f(s1, "skuID");
                                        InAppPurchaseBillingClientWrapperV2V4.subsPurchaseDetailsMap.put(s1, jSONObject0);
                                    }
                                }
                            }
                        }
                        inAppPurchaseBillingClientWrapperV2V40.querySkuDetailsAsync(inAppPurchaseUtils$IAPProductType0, arrayList0, runnable0);
                    }
                }
                catch(JSONException unused_ex) {
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
            }
        }
    }

    private final void querySkuDetailsAsync(IAPProductType inAppPurchaseUtils$IAPProductType0, List list0, Runnable runnable0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.executeServiceRequest(new a(this, runnable0, inAppPurchaseUtils$IAPProductType0, list0, 17));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private static final void querySkuDetailsAsync$lambda$1(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V40, Runnable runnable0, IAPProductType inAppPurchaseUtils$IAPProductType0, List list0) {
        Class class0 = InAppPurchaseBillingClientWrapperV2V4.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(inAppPurchaseBillingClientWrapperV2V40, "this$0");
            q.g(runnable0, "$completionHandler");
            q.g(inAppPurchaseUtils$IAPProductType0, "$skuType");
            q.g(list0, "$skuIDs");
            SkuDetailsResponseListenerWrapper inAppPurchaseBillingClientWrapperV2V4$SkuDetailsResponseListenerWrapper0 = new SkuDetailsResponseListenerWrapper(inAppPurchaseBillingClientWrapperV2V40, runnable0);
            Object object0 = Proxy.newProxyInstance(inAppPurchaseBillingClientWrapperV2V40.skuDetailsResponseListenerClazz.getClassLoader(), new Class[]{inAppPurchaseBillingClientWrapperV2V40.skuDetailsResponseListenerClazz}, inAppPurchaseBillingClientWrapperV2V4$SkuDetailsResponseListenerWrapper0);
            Object object1 = inAppPurchaseBillingClientWrapperV2V40.inAppPurchaseSkuDetailsWrapper.getSkuDetailsParams(inAppPurchaseUtils$IAPProductType0, list0);
            Object object2 = inAppPurchaseBillingClientWrapperV2V40.getBillingClient();
            InAppPurchaseUtils.invokeMethod(inAppPurchaseBillingClientWrapperV2V40.billingClientClazz, inAppPurchaseBillingClientWrapperV2V40.querySkuDetailsAsyncMethod, object2, new Object[]{object1, object0});
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private final void startConnection(Runnable runnable0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                Class class0 = InAppPurchaseUtils.getClass("com.android.billingclient.api.BillingClientStateListener");
                if(class0 != null) {
                    Method method0 = InAppPurchaseUtils.getMethod(this.billingClientClazz, "startConnection", new Class[]{class0});
                    if(method0 != null) {
                        BillingClientStateListenerWrapper inAppPurchaseBillingClientWrapperV2V4$BillingClientStateListenerWrapper0 = new BillingClientStateListenerWrapper(runnable0);
                        Object object0 = Proxy.newProxyInstance(class0.getClassLoader(), new Class[]{class0}, inAppPurchaseBillingClientWrapperV2V4$BillingClientStateListenerWrapper0);
                        Object object1 = this.getBillingClient();
                        InAppPurchaseUtils.invokeMethod(this.billingClientClazz, method0, object1, new Object[]{object0});
                        return;
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }
}

