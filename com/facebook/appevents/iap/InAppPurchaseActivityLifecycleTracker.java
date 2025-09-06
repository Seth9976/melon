package com.facebook.appevents.iap;

import A5.a;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000F\u0010\n\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J7\u0010\u0013\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u000B2\u0016\u0010\u0010\u001A\u0012\u0012\u0004\u0012\u00020\u000E0\rj\b\u0012\u0004\u0012\u00020\u000E`\u000F2\u0006\u0010\u0012\u001A\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001C\u0010\u0016\u001A\n \u0015*\u0004\u0018\u00010\u000E0\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\u000E8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001A\u00020\u000E8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001B\u001A\u00020\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0018\u0010\u001D\u001A\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0018\u0010\u001F\u001A\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001F\u0010\u001ER\u0016\u0010!\u001A\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001A\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\'\u001A\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\'\u0010(R\u0018\u0010)\u001A\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0005\u0010+¨\u0006,"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseActivityLifecycleTracker;", "", "<init>", "()V", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;", "billingClientVersion", "Lie/H;", "startIapLogging", "(Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;)V", "initializeIfNotInitialized", "startTracking", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "purchases", "", "isSubscription", "logPurchase", "(Landroid/content/Context;Ljava/util/ArrayList;Z)V", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "SERVICE_INTERFACE_NAME", "BILLING_ACTIVITY_NAME", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isTracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasBillingService", "Ljava/lang/Boolean;", "hasBillingActivity", "Landroid/content/ServiceConnection;", "serviceConnection", "Landroid/content/ServiceConnection;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "callbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/content/Intent;", "intent", "Landroid/content/Intent;", "inAppBillingObj", "Ljava/lang/Object;", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InAppPurchaseActivityLifecycleTracker {
    @NotNull
    private static final String BILLING_ACTIVITY_NAME = "com.android.billingclient.api.ProxyBillingActivity";
    @NotNull
    public static final InAppPurchaseActivityLifecycleTracker INSTANCE = null;
    @NotNull
    private static final String SERVICE_INTERFACE_NAME = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String TAG;
    @Nullable
    private static BillingClientVersion billingClientVersion;
    private static Application.ActivityLifecycleCallbacks callbacks;
    @Nullable
    private static Boolean hasBillingActivity;
    @Nullable
    private static Boolean hasBillingService;
    @Nullable
    private static Object inAppBillingObj;
    private static Intent intent;
    @NotNull
    private static final AtomicBoolean isTracking;
    private static ServiceConnection serviceConnection;

    static {
        InAppPurchaseActivityLifecycleTracker.INSTANCE = new InAppPurchaseActivityLifecycleTracker();
        InAppPurchaseActivityLifecycleTracker.TAG = InAppPurchaseActivityLifecycleTracker.class.getCanonicalName();
        InAppPurchaseActivityLifecycleTracker.isTracking = new AtomicBoolean(false);
    }

    private final void initializeIfNotInitialized() {
        boolean z = false;
        if(InAppPurchaseActivityLifecycleTracker.hasBillingService == null) {
            Boolean boolean0 = Boolean.valueOf(InAppPurchaseUtils.getClass("com.android.vending.billing.IInAppBillingService$Stub") != null);
            InAppPurchaseActivityLifecycleTracker.hasBillingService = boolean0;
            if(!q.b(boolean0, Boolean.FALSE)) {
                if(InAppPurchaseUtils.getClass("com.android.billingclient.api.ProxyBillingActivity") != null) {
                    z = true;
                }
                InAppPurchaseActivityLifecycleTracker.hasBillingActivity = Boolean.valueOf(z);
                InAppPurchaseEventManager.clearSkuDetailsCache();
                Intent intent0 = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
                q.f(intent0, "Intent(\"com.android.vend…ge(\"com.android.vending\")");
                InAppPurchaseActivityLifecycleTracker.intent = intent0;
                InAppPurchaseActivityLifecycleTracker.serviceConnection = new com.facebook.appevents.iap.InAppPurchaseActivityLifecycleTracker.initializeIfNotInitialized.1();
                InAppPurchaseActivityLifecycleTracker.callbacks = new com.facebook.appevents.iap.InAppPurchaseActivityLifecycleTracker.initializeIfNotInitialized.2();
            }
        }

        @Metadata(d1 = {"\u0000\u001D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"com/facebook/appevents/iap/InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$1", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "Lie/H;", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public final class com.facebook.appevents.iap.InAppPurchaseActivityLifecycleTracker.initializeIfNotInitialized.1 implements ServiceConnection {
            @Override  // android.content.ServiceConnection
            public void onServiceConnected(@NotNull ComponentName componentName0, @NotNull IBinder iBinder0) {
                q.g(componentName0, "name");
                q.g(iBinder0, "service");
                InAppPurchaseActivityLifecycleTracker.inAppBillingObj = InAppPurchaseEventManager.asInterface(FacebookSdk.getApplicationContext(), iBinder0);
            }

            @Override  // android.content.ServiceConnection
            public void onServiceDisconnected(@NotNull ComponentName componentName0) {
                q.g(componentName0, "name");
            }
        }


        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000B\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u000B\u0010\u0006J\u0017\u0010\f\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u001F\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u000F\u0010\nJ\u0017\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"com/facebook/appevents/iap/InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "activity", "Lie/H;", "onActivityResumed", "(Landroid/app/Activity;)V", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityStarted", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public final class com.facebook.appevents.iap.InAppPurchaseActivityLifecycleTracker.initializeIfNotInitialized.2 implements Application.ActivityLifecycleCallbacks {
            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityCreated(@NotNull Activity activity0, @Nullable Bundle bundle0) {
                q.g(activity0, "activity");
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NotNull Activity activity0) {
                q.g(activity0, "activity");
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityPaused(@NotNull Activity activity0) {
                q.g(activity0, "activity");
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityResumed(@NotNull Activity activity0) {
                q.g(activity0, "activity");
                try {
                    FacebookSdk.getExecutor().execute(new a(15));
                }
                catch(Exception unused_ex) {
                }
            }

            private static final void onActivityResumed$lambda$0() {
                Context context0 = FacebookSdk.getApplicationContext();
                ArrayList arrayList0 = InAppPurchaseEventManager.getPurchasesInapp(context0, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
                InAppPurchaseActivityLifecycleTracker.INSTANCE.logPurchase(context0, arrayList0, false);
                ArrayList arrayList1 = InAppPurchaseEventManager.getPurchasesSubs(context0, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
                InAppPurchaseActivityLifecycleTracker.INSTANCE.logPurchase(context0, arrayList1, true);
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@NotNull Activity activity0, @NotNull Bundle bundle0) {
                q.g(activity0, "activity");
                q.g(bundle0, "outState");
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityStarted(@NotNull Activity activity0) {
                q.g(activity0, "activity");
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityStopped(@NotNull Activity activity0) {
                q.g(activity0, "activity");
                try {
                    if(q.b(InAppPurchaseActivityLifecycleTracker.hasBillingActivity, Boolean.TRUE) && q.b(activity0.getLocalClassName(), "com.android.billingclient.api.ProxyBillingActivity")) {
                        FacebookSdk.getExecutor().execute(new a(14));
                    }
                }
                catch(Exception unused_ex) {
                }
            }

            private static final void onActivityStopped$lambda$1() {
                Context context0 = FacebookSdk.getApplicationContext();
                ArrayList arrayList0 = InAppPurchaseEventManager.getPurchasesInapp(context0, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
                if(arrayList0.isEmpty()) {
                    arrayList0 = InAppPurchaseEventManager.getPurchaseHistoryInapp(context0, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
                }
                InAppPurchaseActivityLifecycleTracker.INSTANCE.logPurchase(context0, arrayList0, false);
            }
        }

    }

    private final void logPurchase(Context context0, ArrayList arrayList0, boolean z) {
        if(!arrayList0.isEmpty()) {
            HashMap hashMap0 = new HashMap();
            ArrayList arrayList1 = new ArrayList();
            for(Object object0: arrayList0) {
                String s = (String)object0;
                try {
                    String s1 = new JSONObject(s).getString("productId");
                    q.f(s1, "sku");
                    q.f(s, "purchase");
                    hashMap0.put(s1, s);
                    arrayList1.add(s1);
                }
                catch(JSONException jSONException0) {
                    Log.e(InAppPurchaseActivityLifecycleTracker.TAG, "Error parsing in-app purchase data.", jSONException0);
                }
            }
            for(Object object1: InAppPurchaseEventManager.getSkuDetails(context0, arrayList1, InAppPurchaseActivityLifecycleTracker.inAppBillingObj, z).entrySet()) {
                String s2 = (String)((Map.Entry)object1).getKey();
                String s3 = (String)((Map.Entry)object1).getValue();
                String s4 = (String)hashMap0.get(s2);
                if(s4 != null) {
                    AutomaticAnalyticsLogger.logPurchase$default(s4, s3, z, InAppPurchaseActivityLifecycleTracker.billingClientVersion, false, 16, null);
                }
            }
        }
    }

    public static final void startIapLogging(@NotNull BillingClientVersion inAppPurchaseUtils$BillingClientVersion0) {
        q.g(inAppPurchaseUtils$BillingClientVersion0, "billingClientVersion");
        InAppPurchaseActivityLifecycleTracker inAppPurchaseActivityLifecycleTracker0 = InAppPurchaseActivityLifecycleTracker.INSTANCE;
        inAppPurchaseActivityLifecycleTracker0.initializeIfNotInitialized();
        if(!q.b(InAppPurchaseActivityLifecycleTracker.hasBillingService, Boolean.FALSE) && AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            InAppPurchaseActivityLifecycleTracker.billingClientVersion = inAppPurchaseUtils$BillingClientVersion0;
            inAppPurchaseActivityLifecycleTracker0.startTracking();
        }
    }

    private final void startTracking() {
        if(InAppPurchaseActivityLifecycleTracker.isTracking.compareAndSet(false, true)) {
            Context context0 = FacebookSdk.getApplicationContext();
            if(context0 instanceof Application) {
                Application.ActivityLifecycleCallbacks application$ActivityLifecycleCallbacks0 = InAppPurchaseActivityLifecycleTracker.callbacks;
                if(application$ActivityLifecycleCallbacks0 != null) {
                    ((Application)context0).registerActivityLifecycleCallbacks(application$ActivityLifecycleCallbacks0);
                    Intent intent0 = InAppPurchaseActivityLifecycleTracker.intent;
                    if(intent0 != null) {
                        ServiceConnection serviceConnection0 = InAppPurchaseActivityLifecycleTracker.serviceConnection;
                        if(serviceConnection0 != null) {
                            context0.bindService(intent0, serviceConnection0, 1);
                            return;
                        }
                        q.m("serviceConnection");
                        throw null;
                    }
                    q.m("intent");
                    throw null;
                }
                q.m("callbacks");
                throw null;
            }
        }
    }
}

