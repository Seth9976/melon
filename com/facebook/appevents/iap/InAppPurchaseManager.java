package com.facebook.appevents.iap;

import Tf.o;
import Tf.v;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.OperationalData;
import com.facebook.appevents.OperationalDataEnum;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import ie.m;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00C7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0007H\u0003\u00A2\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000B\u001A\u0004\u0018\u00010\u0007H\u0007\u00A2\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJM\u0010\u001B\u001A\u0004\u0018\u00010\u00182\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u00152\u001C\u0010\u001A\u001A\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00170\u0010H\u0007\u00A2\u0006\u0004\b\u001B\u0010\u001CJI\u0010#\u001A\u0004\u0018\u00010\u00072\b\u0010\u001D\u001A\u0004\u0018\u00010\u00182\b\u0010\u001E\u001A\u0004\u0018\u00010\u00192\b\u0010\u001F\u001A\u0004\u0018\u00010\u00182\b\u0010 \u001A\u0004\u0018\u00010\u00192\u0006\u0010!\u001A\u00020\u00152\b\b\u0002\u0010\"\u001A\u00020\u0015\u00A2\u0006\u0004\b#\u0010$RB\u0010\'\u001A0\u0012\u0004\u0012\u00020\u0011\u0012&\u0012$\u0012 \u0012\u001E\u0012\u0004\u0012\u00020\u0013\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00170\u00170&0%8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\'\u0010(RB\u0010)\u001A0\u0012\u0004\u0012\u00020\u0011\u0012&\u0012$\u0012 \u0012\u001E\u0012\u0004\u0012\u00020\u0013\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00170\u00170&0%8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b)\u0010(R\u0018\u0010*\u001A\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001A\u00020\u00078\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010.\u001A\u00020-8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b.\u0010/\u00A8\u00060"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseManager;", "", "<init>", "()V", "Lie/H;", "enableAutoLogging", "startTracking", "", "version", "setSpecificBillingLibraryVersion", "(Ljava/lang/String;)V", "getSpecificBillingLibraryVersion", "()Ljava/lang/String;", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;", "getBillingClientVersion", "()Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;", "", "Lcom/facebook/appevents/iap/InAppPurchase;", "purchases", "", "time", "", "isImplicitlyLogged", "Lie/m;", "Landroid/os/Bundle;", "Lcom/facebook/appevents/OperationalData;", "purchaseParameters", "performDedupe", "(Ljava/util/List;JZLjava/util/List;)Landroid/os/Bundle;", "newPurchaseParameters", "newPurchaseOperationalData", "oldPurchaseParameters", "oldPurchaseOperationalData", "dedupingWithImplicitlyLoggedHistory", "withTestDedupeKeys", "getDedupeParameter", "(Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;ZZ)Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "timesOfManualPurchases", "Ljava/util/concurrent/ConcurrentHashMap;", "timesOfImplicitPurchases", "specificBillingLibraryVersion", "Ljava/lang/String;", "GOOGLE_BILLINGCLIENT_VERSION", "Ljava/util/concurrent/atomic/AtomicBoolean;", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class InAppPurchaseManager {
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[BillingClientVersion.values().length];
            try {
                arr_v[BillingClientVersion.NONE.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[BillingClientVersion.V1.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[BillingClientVersion.V2_V4.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[BillingClientVersion.V5_V7.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @NotNull
    private static final String GOOGLE_BILLINGCLIENT_VERSION = "com.google.android.play.billingclient.version";
    @NotNull
    public static final InAppPurchaseManager INSTANCE;
    @NotNull
    private static final AtomicBoolean enabled;
    @Nullable
    private static String specificBillingLibraryVersion;
    @NotNull
    private static final ConcurrentHashMap timesOfImplicitPurchases;
    @NotNull
    private static final ConcurrentHashMap timesOfManualPurchases;

    static {
        InAppPurchaseManager.INSTANCE = new InAppPurchaseManager();
        InAppPurchaseManager.timesOfManualPurchases = new ConcurrentHashMap();
        InAppPurchaseManager.timesOfImplicitPurchases = new ConcurrentHashMap();
        InAppPurchaseManager.enabled = new AtomicBoolean(false);
    }

    public static final void enableAutoLogging() {
        Class class0 = InAppPurchaseManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            if(!AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
                InAppPurchaseLoggerManager.updateLatestPossiblePurchaseTime();
                return;
            }
            InAppPurchaseManager.enabled.set(true);
            InAppPurchaseManager.startTracking();
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private final BillingClientVersion getBillingClientVersion() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo0 = FacebookSdk.getApplicationContext().getPackageManager().getApplicationInfo("com.iloen.melon", 0x80);
            q.f(applicationInfo0, "context.packageManager.g…TA_DATA\n                )");
            String s = applicationInfo0.metaData.getString("com.google.android.play.billingclient.version");
            if(s == null) {
                return BillingClientVersion.NONE;
            }
            List list0 = o.R0(s, new String[]{"."}, 3, 2);
            if(s.length() == 0) {
                return BillingClientVersion.V5_V7;
            }
            InAppPurchaseManager.setSpecificBillingLibraryVersion(("GPBL." + s));
            Integer integer0 = v.t0(((String)list0.get(0)));
            if(integer0 != null) {
                int v = (int)integer0;
                if(v == 1) {
                    return BillingClientVersion.V1;
                }
                return v >= 5 ? BillingClientVersion.V5_V7 : BillingClientVersion.V2_V4;
            }
            return BillingClientVersion.V5_V7;
        }
        catch(Exception unused_ex) {
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
        return BillingClientVersion.V5_V7;
    }

    @Nullable
    public final String getDedupeParameter(@Nullable Bundle bundle0, @Nullable OperationalData operationalData0, @Nullable Bundle bundle1, @Nullable OperationalData operationalData1, boolean z, boolean z1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            List list0 = z1 ? InAppPurchaseDedupeConfig.INSTANCE.getTestDedupeParameters(z) : InAppPurchaseDedupeConfig.INSTANCE.getDedupeParameters(z);
            if(list0 == null) {
                return null;
            }
            for(Object object0: list0) {
                m m0 = (m)object0;
                Object object1 = OperationalData.Companion.getParameter(OperationalDataEnum.IAPParameters, ((String)m0.a), bundle0, operationalData0);
                String s = object1 instanceof String ? ((String)object1) : null;
                if(s != null && s.length() != 0) {
                    for(Object object2: ((List)m0.b)) {
                        String s1 = (String)object2;
                        Object object3 = OperationalData.Companion.getParameter(OperationalDataEnum.IAPParameters, s1, bundle1, operationalData1);
                        String s2 = object3 instanceof String ? ((String)object3) : null;
                        if(s2 != null && s2.length() != 0 && q.b(s2, s)) {
                            return z ? ((String)m0.a) : s1;
                        }
                        if(false) {
                            break;
                        }
                    }
                    if(false) {
                        break;
                    }
                }
            }
            return null;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    public static String getDedupeParameter$default(InAppPurchaseManager inAppPurchaseManager0, Bundle bundle0, OperationalData operationalData0, Bundle bundle1, OperationalData operationalData1, boolean z, boolean z1, int v, Object object0) {
        Class class0 = InAppPurchaseManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return inAppPurchaseManager0.getDedupeParameter(bundle0, operationalData0, bundle1, operationalData1, z, ((v & 0x20) == 0 ? z1 : false));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    // 去混淆评级： 低(20)
    @Nullable
    public static final String getSpecificBillingLibraryVersion() {
        return CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class) ? null : InAppPurchaseManager.specificBillingLibraryVersion;
    }

    @Nullable
    public static final Bundle performDedupe(@NotNull List list0, long v, boolean z, @NotNull List list1) {
        boolean z1;
        Bundle bundle4;
        Bundle bundle3;
        Bundle bundle2;
        synchronized(InAppPurchaseManager.class) {
            if(CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
                return null;
            }
            try {
                q.g(list0, "purchases");
                q.g(list1, "purchaseParameters");
                if(list1.isEmpty()) {
                    return null;
                }
                if(list0.size() != list1.size()) {
                    return null;
                }
                ArrayList arrayList0 = new ArrayList();
                int v2 = list0.size();
                Bundle bundle0 = null;
                for(int v3 = 0; true; ++v3) {
                    if(v3 >= v2) {
                        for(Object object0: arrayList0) {
                            m m0 = (m)object0;
                            List list2 = z ? ((List)InAppPurchaseManager.timesOfManualPurchases.get(m0.a)) : ((List)InAppPurchaseManager.timesOfImplicitPurchases.get(m0.a));
                            if(list2 != null) {
                                int v4 = 0;
                                for(Object object1: list2) {
                                    if(((Number)((m)object1).a).longValue() == ((Number)m0.b).longValue()) {
                                        list2.remove(v4);
                                        if(true) {
                                            break;
                                        }
                                    }
                                    else {
                                        ++v4;
                                    }
                                }
                                if(z) {
                                    if(list2.isEmpty()) {
                                        InAppPurchaseManager.timesOfManualPurchases.remove(m0.a);
                                    }
                                    else {
                                        InAppPurchaseManager.timesOfManualPurchases.put(m0.a, list2);
                                    }
                                }
                                else if(list2.isEmpty()) {
                                    InAppPurchaseManager.timesOfImplicitPurchases.remove(m0.a);
                                }
                                else {
                                    InAppPurchaseManager.timesOfImplicitPurchases.put(m0.a, list2);
                                }
                            }
                        }
                        return bundle0;
                    }
                    InAppPurchase inAppPurchase0 = (InAppPurchase)list0.get(v3);
                    m m1 = (m)list1.get(v3);
                    Bundle bundle1 = (Bundle)m1.a;
                    OperationalData operationalData0 = (OperationalData)m1.b;
                    InAppPurchase inAppPurchase1 = new InAppPurchase(inAppPurchase0.getEventName(), new BigDecimal(String.valueOf(inAppPurchase0.getAmount())).setScale(2, RoundingMode.HALF_UP).doubleValue(), inAppPurchase0.getCurrency());
                    List list3 = z ? ((List)InAppPurchaseManager.timesOfManualPurchases.get(inAppPurchase1)) : ((List)InAppPurchaseManager.timesOfImplicitPurchases.get(inAppPurchase1));
                    if(list3 == null || list3.isEmpty()) {
                        bundle2 = null;
                        bundle3 = null;
                        bundle4 = null;
                        z1 = false;
                    }
                    else {
                        bundle2 = null;
                        bundle3 = null;
                        bundle4 = null;
                        z1 = false;
                        for(Object object2: list3) {
                            long v5 = ((Number)((m)object2).a).longValue();
                            Bundle bundle5 = (Bundle)((m)((m)object2).b).a;
                            OperationalData operationalData1 = (OperationalData)((m)((m)object2).b).b;
                            if(Math.abs(v - v5) <= InAppPurchaseDedupeConfig.INSTANCE.getDedupeWindow() && (bundle3 == null || v5 < ((long)(((Long)bundle3))))) {
                                bundle4 = InAppPurchaseManager.getDedupeParameter$default(InAppPurchaseManager.INSTANCE, bundle1, operationalData0, bundle5, operationalData1, !z, false, 0x20, null);
                                String s = InAppPurchaseManager.INSTANCE.getDedupeParameter(bundle1, operationalData0, bundle5, operationalData1, !z, true);
                                if(s != null) {
                                    bundle2 = s;
                                }
                                if(bundle4 != null) {
                                    bundle3 = v5;
                                    arrayList0.add(new m(inAppPurchase1, v5));
                                    z1 = true;
                                }
                            }
                        }
                    }
                    if(bundle2 != null) {
                        if(bundle0 == null) {
                            bundle0 = new Bundle();
                        }
                        bundle0.putString("fb_iap_test_dedup_result", "1");
                        bundle0.putString("fb_iap_test_dedup_key_used", ((String)bundle2));
                    }
                    if(z1) {
                        if(bundle0 == null) {
                            bundle0 = new Bundle();
                        }
                        bundle0.putString("fb_iap_non_deduped_event_time", String.valueOf((bundle3 == null ? 0L : ((long)(((Long)bundle3))) / 1000L)));
                        bundle0.putString("fb_iap_actual_dedup_result", "1");
                        bundle0.putString("fb_iap_actual_dedup_key_used", ((String)bundle4));
                    }
                    if(z && !z1) {
                        ConcurrentHashMap concurrentHashMap0 = InAppPurchaseManager.timesOfImplicitPurchases;
                        if(concurrentHashMap0.get(inAppPurchase1) == null) {
                            concurrentHashMap0.put(inAppPurchase1, new ArrayList());
                        }
                        List list4 = (List)concurrentHashMap0.get(inAppPurchase1);
                        if(list4 != null) {
                            list4.add(new m(v, new m(bundle1, operationalData0)));
                        }
                    }
                    else if(!z && !z1) {
                        ConcurrentHashMap concurrentHashMap1 = InAppPurchaseManager.timesOfManualPurchases;
                        if(concurrentHashMap1.get(inAppPurchase1) == null) {
                            concurrentHashMap1.put(inAppPurchase1, new ArrayList());
                        }
                        List list5 = (List)concurrentHashMap1.get(inAppPurchase1);
                        if(list5 != null) {
                            list5.add(new m(v, new m(bundle1, operationalData0)));
                        }
                    }
                }
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, InAppPurchaseManager.class);
            return null;
        }
    }

    private static final void setSpecificBillingLibraryVersion(String s) {
        if(CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return;
        }
        InAppPurchaseManager.specificBillingLibraryVersion = s;
    }

    public static final void startTracking() {
        Class class0 = InAppPurchaseManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                if(InAppPurchaseManager.enabled.get()) {
                    BillingClientVersion inAppPurchaseUtils$BillingClientVersion0 = InAppPurchaseManager.INSTANCE.getBillingClientVersion();
                    switch(WhenMappings.$EnumSwitchMapping$0[inAppPurchaseUtils$BillingClientVersion0.ordinal()]) {
                        case 2: {
                            InAppPurchaseActivityLifecycleTracker.startIapLogging(BillingClientVersion.V1);
                            return;
                        }
                        case 3: {
                            if(FeatureManager.isEnabled(Feature.IapLoggingLib2)) {
                                InAppPurchaseAutoLogger.startIapLogging(FacebookSdk.getApplicationContext(), inAppPurchaseUtils$BillingClientVersion0);
                                return;
                            }
                            InAppPurchaseActivityLifecycleTracker.startIapLogging(BillingClientVersion.V2_V4);
                            return;
                        }
                        case 4: {
                            if(FeatureManager.isEnabled(Feature.IapLoggingLib5To7)) {
                                InAppPurchaseAutoLogger.startIapLogging(FacebookSdk.getApplicationContext(), inAppPurchaseUtils$BillingClientVersion0);
                                return;
                            }
                            break;
                        }
                        default: {
                            return;
                        }
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }
}

