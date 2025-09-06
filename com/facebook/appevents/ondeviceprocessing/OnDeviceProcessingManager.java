package com.facebook.appevents.ondeviceprocessing;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.gps.ara.a;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import e.k;
import java.util.Set;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000B\u001A\u00020\n2\b\u0010\b\u001A\u0004\u0018\u00010\u00072\b\u0010\t\u001A\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u000F\u001A\u00020\n2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\rH\u0007¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0011\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00070\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/facebook/appevents/ondeviceprocessing/OnDeviceProcessingManager;", "", "<init>", "()V", "", "isOnDeviceProcessingEnabled", "()Z", "", "applicationId", "preferencesName", "Lie/H;", "sendInstallEventAsync", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/facebook/appevents/AppEvent;", "event", "sendCustomEventAsync", "(Ljava/lang/String;Lcom/facebook/appevents/AppEvent;)V", "isEventEligibleForOnDeviceProcessing", "(Lcom/facebook/appevents/AppEvent;)Z", "", "ALLOWED_IMPLICIT_EVENTS", "Ljava/util/Set;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class OnDeviceProcessingManager {
    @NotNull
    private static final Set ALLOWED_IMPLICIT_EVENTS;
    @NotNull
    public static final OnDeviceProcessingManager INSTANCE;

    static {
        OnDeviceProcessingManager.INSTANCE = new OnDeviceProcessingManager();
        OnDeviceProcessingManager.ALLOWED_IMPLICIT_EVENTS = n.A0(new String[]{"fb_mobile_purchase", "StartTrial", "Subscribe"});
    }

    public static void b(String s, AppEvent appEvent0) {
        OnDeviceProcessingManager.sendCustomEventAsync$lambda$1(s, appEvent0);
    }

    private final boolean isEventEligibleForOnDeviceProcessing(AppEvent appEvent0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return !appEvent0.isImplicit() || !OnDeviceProcessingManager.ALLOWED_IMPLICIT_EVENTS.contains(appEvent0.getName()) ? !appEvent0.isImplicit() : true;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return false;
    }

    public static final boolean isOnDeviceProcessingEnabled() {
        Class class0 = OnDeviceProcessingManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            if(!FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext()) && !Utility.isDataProcessingRestricted() && RemoteServiceWrapper.isServiceAvailable()) {
                return true;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
        return false;
    }

    public static final void sendCustomEventAsync(@NotNull String s, @NotNull AppEvent appEvent0) {
        Class class0 = OnDeviceProcessingManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(s, "applicationId");
                q.g(appEvent0, "event");
                if(OnDeviceProcessingManager.INSTANCE.isEventEligibleForOnDeviceProcessing(appEvent0)) {
                    FacebookSdk.getExecutor().execute(new a(s, appEvent0, 1));
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private static final void sendCustomEventAsync$lambda$1(String s, AppEvent appEvent0) {
        Class class0 = OnDeviceProcessingManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(s, "$applicationId");
            q.g(appEvent0, "$event");
            RemoteServiceWrapper.sendCustomEvents(s, k.z(appEvent0));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void sendInstallEventAsync(@Nullable String s, @Nullable String s1) {
        Class class0 = OnDeviceProcessingManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                Context context0 = FacebookSdk.getApplicationContext();
                if(context0 != null && s != null && s1 != null) {
                    FacebookSdk.getExecutor().execute(new com.facebook.appevents.ondeviceprocessing.a(context0, s1, s, 0));
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private static final void sendInstallEventAsync$lambda$0(Context context0, String s, String s1) {
        Class class0 = OnDeviceProcessingManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(context0, "$context");
                SharedPreferences sharedPreferences0 = context0.getSharedPreferences(s, 0);
                if(sharedPreferences0.getLong(s1 + "pingForOnDevice", 0L) == 0L) {
                    RemoteServiceWrapper.sendInstallEvent(s1);
                    SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
                    sharedPreferences$Editor0.putLong(s1 + "pingForOnDevice", System.currentTimeMillis());
                    sharedPreferences$Editor0.apply();
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }
}

