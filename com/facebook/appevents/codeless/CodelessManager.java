package com.facebook.appevents.codeless;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import androidx.media3.session.H0;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.a;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\bJ\u000F\u0010\u000B\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\u000B\u0010\u0003J\u000F\u0010\f\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\u0003J\u0019\u0010\u000F\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0016\u001A\u00020\rH\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0018\u001A\u00020\u0011H\u0001¢\u0006\u0004\b\u0017\u0010\u0013J\u0017\u0010\u001C\u001A\u00020\u00062\u0006\u0010\u0019\u001A\u00020\u0011H\u0001¢\u0006\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001E\u001A\u00020\u001D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001E\u0010\u001FR\u0018\u0010!\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001A\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001A\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b&\u0010\'R\u0014\u0010)\u001A\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001A\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010*R\u0016\u0010,\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/facebook/appevents/codeless/CodelessManager;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "Lie/H;", "onActivityResumed", "(Landroid/app/Activity;)V", "onActivityPaused", "onActivityDestroyed", "enable", "disable", "", "applicationId", "checkCodelessSession", "(Ljava/lang/String;)V", "", "isDebugOnEmulator", "()Z", "getCurrentDeviceSessionID$facebook_core_release", "()Ljava/lang/String;", "getCurrentDeviceSessionID", "getIsAppIndexingEnabled$facebook_core_release", "getIsAppIndexingEnabled", "appIndexingEnabled", "updateAppIndexing$facebook_core_release", "(Z)V", "updateAppIndexing", "Lcom/facebook/appevents/codeless/ViewIndexingTrigger;", "viewIndexingTrigger", "Lcom/facebook/appevents/codeless/ViewIndexingTrigger;", "Landroid/hardware/SensorManager;", "sensorManager", "Landroid/hardware/SensorManager;", "Lcom/facebook/appevents/codeless/ViewIndexer;", "viewIndexer", "Lcom/facebook/appevents/codeless/ViewIndexer;", "deviceSessionID", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isCodelessEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isAppIndexingEnabled", "isCheckingSession", "Z", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CodelessManager {
    @NotNull
    public static final CodelessManager INSTANCE;
    @Nullable
    private static String deviceSessionID;
    @NotNull
    private static final AtomicBoolean isAppIndexingEnabled;
    private static volatile boolean isCheckingSession;
    @NotNull
    private static final AtomicBoolean isCodelessEnabled;
    @Nullable
    private static SensorManager sensorManager;
    @Nullable
    private static ViewIndexer viewIndexer;
    @NotNull
    private static final ViewIndexingTrigger viewIndexingTrigger;

    static {
        CodelessManager.INSTANCE = new CodelessManager();
        CodelessManager.viewIndexingTrigger = new ViewIndexingTrigger();
        CodelessManager.isCodelessEnabled = new AtomicBoolean(true);
        CodelessManager.isAppIndexingEnabled = new AtomicBoolean(false);
    }

    public static void a(String s) {
        CodelessManager.checkCodelessSession$lambda$1(s);
    }

    public static void b(FetchedAppSettings fetchedAppSettings0, String s) {
        CodelessManager.onActivityResumed$lambda$0(fetchedAppSettings0, s);
    }

    private final void checkCodelessSession(String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                if(!CodelessManager.isCheckingSession) {
                    CodelessManager.isCheckingSession = true;
                    FacebookSdk.getExecutor().execute(new a(s, 1));
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private static final void checkCodelessSession$lambda$1(String s) {
        String s1 = "0";
        Class class0 = CodelessManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            Bundle bundle0 = new Bundle();
            Context context0 = FacebookSdk.getApplicationContext();
            AttributionIdentifiers attributionIdentifiers0 = AttributionIdentifiers.Companion.getAttributionIdentifiers(context0);
            JSONArray jSONArray0 = new JSONArray();
            jSONArray0.put((Build.MODEL == null ? "" : Build.MODEL));
            if((attributionIdentifiers0 == null ? null : attributionIdentifiers0.getAndroidAdvertiserId()) == null) {
                jSONArray0.put("");
            }
            else {
                jSONArray0.put(attributionIdentifiers0.getAndroidAdvertiserId());
            }
            jSONArray0.put("0");
            if(AppEventUtility.isEmulator()) {
                s1 = "1";
            }
            jSONArray0.put(s1);
            Locale locale0 = Utility.getCurrentLocale();
            jSONArray0.put(locale0.getLanguage() + '_' + locale0.getCountry());
            String s2 = jSONArray0.toString();
            q.f(s2, "extInfoArray.toString()");
            bundle0.putString("device_session_id", "785ad2a1-ecf0-477c-b782-26c630ac9290");
            bundle0.putString("extinfo", s2);
            boolean z = true;
            String s3 = String.format(Locale.US, "%s/app_indexing_session", Arrays.copyOf(new Object[]{s}, 1));
            JSONObject jSONObject0 = GraphRequest.Companion.newPostRequestWithBundle(null, s3, bundle0, null).executeAndWait().getJSONObject();
            AtomicBoolean atomicBoolean0 = CodelessManager.isAppIndexingEnabled;
            if(jSONObject0 == null || !jSONObject0.optBoolean("is_app_indexing_enabled", false)) {
                z = false;
            }
            atomicBoolean0.set(z);
            if(atomicBoolean0.get()) {
                ViewIndexer viewIndexer0 = CodelessManager.viewIndexer;
                if(viewIndexer0 != null) {
                    viewIndexer0.schedule();
                }
            }
            else {
                CodelessManager.deviceSessionID = null;
            }
            CodelessManager.isCheckingSession = false;
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public static final void disable() {
        Class class0 = CodelessManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            CodelessManager.isCodelessEnabled.set(false);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void enable() {
        Class class0 = CodelessManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            CodelessManager.isCodelessEnabled.set(true);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    @NotNull
    public static final String getCurrentDeviceSessionID$facebook_core_release() [...] // 潜在的解密器

    public static final boolean getIsAppIndexingEnabled$facebook_core_release() {
        Class class0 = CodelessManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            return CodelessManager.isAppIndexingEnabled.get();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return false;
        }
    }

    private final boolean isDebugOnEmulator() {
        CrashShieldHandler.isObjectCrashing(this);
        return false;
    }

    public static final void onActivityDestroyed(@NotNull Activity activity0) {
        Class class0 = CodelessManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(activity0, "activity");
            CodelessMatcher.Companion.getInstance().destroy(activity0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void onActivityPaused(@NotNull Activity activity0) {
        Class class0 = CodelessManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(activity0, "activity");
                if(CodelessManager.isCodelessEnabled.get()) {
                    CodelessMatcher.Companion.getInstance().remove(activity0);
                    ViewIndexer viewIndexer0 = CodelessManager.viewIndexer;
                    if(viewIndexer0 != null) {
                        viewIndexer0.unschedule();
                    }
                    SensorManager sensorManager0 = CodelessManager.sensorManager;
                    if(sensorManager0 != null) {
                        sensorManager0.unregisterListener(CodelessManager.viewIndexingTrigger);
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public static final void onActivityResumed(@NotNull Activity activity0) {
        Class class0 = CodelessManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(activity0, "activity");
                if(CodelessManager.isCodelessEnabled.get()) {
                    CodelessMatcher.Companion.getInstance().add(activity0);
                    Context context0 = activity0.getApplicationContext();
                    String s = FacebookSdk.getApplicationId();
                    FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(s);
                    if((fetchedAppSettings0 == null || !fetchedAppSettings0.getCodelessEventsEnabled()) && !CodelessManager.INSTANCE.isDebugOnEmulator()) {
                    label_20:
                        CodelessManager codelessManager0 = CodelessManager.INSTANCE;
                        if(codelessManager0.isDebugOnEmulator() && !CodelessManager.isAppIndexingEnabled.get()) {
                            codelessManager0.checkCodelessSession(s);
                        }
                    }
                    else {
                        SensorManager sensorManager0 = (SensorManager)context0.getSystemService("sensor");
                        if(sensorManager0 != null) {
                            CodelessManager.sensorManager = sensorManager0;
                            Sensor sensor0 = sensorManager0.getDefaultSensor(1);
                            ViewIndexer viewIndexer0 = new ViewIndexer(activity0);
                            CodelessManager.viewIndexer = viewIndexer0;
                            H0 h00 = new H0(7, fetchedAppSettings0, s);
                            CodelessManager.viewIndexingTrigger.setOnShakeListener(h00);
                            sensorManager0.registerListener(CodelessManager.viewIndexingTrigger, sensor0, 2);
                            if(fetchedAppSettings0 != null && fetchedAppSettings0.getCodelessEventsEnabled()) {
                                viewIndexer0.schedule();
                            }
                            goto label_20;
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

    private static final void onActivityResumed$lambda$0(FetchedAppSettings fetchedAppSettings0, String s) {
        Class class0 = CodelessManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(s, "$appId");
                if(fetchedAppSettings0 != null && fetchedAppSettings0.getCodelessEventsEnabled() && FacebookSdk.getCodelessSetupEnabled()) {
                    CodelessManager.INSTANCE.checkCodelessSession(s);
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public static final void updateAppIndexing$facebook_core_release(boolean z) {
        Class class0 = CodelessManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            CodelessManager.isAppIndexingEnabled.set(z);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }
}

