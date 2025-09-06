package com.facebook.appevents.gps.ara;

import Q0.W0;
import Sf.a;
import Sf.n;
import Tf.o;
import android.adservices.measurement.MeasurementManager;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.OutcomeReceiver;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.gps.GpsDebugLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.net.URLEncoder;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import n4.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import we.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000E\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\tH\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ\u001D\u0010\u0011\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0007¢\u0006\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001A\u00020\u000B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001A\u00020\u000B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001A\u00020\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0018\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001B\u001A\u00020\u001A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0016\u0010\u001D\u001A\u00020\u000B8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001D\u0010\u0015¨\u0006\u001E"}, d2 = {"Lcom/facebook/appevents/gps/ara/GpsAraTriggersManager;", "", "<init>", "()V", "Lie/H;", "enable", "", "canRegisterTrigger", "()Z", "Lcom/facebook/appevents/AppEvent;", "event", "", "getEventParameters", "(Lcom/facebook/appevents/AppEvent;)Ljava/lang/String;", "isValidEvent", "(Lcom/facebook/appevents/AppEvent;)Z", "applicationId", "registerTriggerAsync", "(Ljava/lang/String;Lcom/facebook/appevents/AppEvent;)V", "registerTrigger", "GPS_PREFIX", "Ljava/lang/String;", "REPLACEMENT_STRING", "TAG", "enabled", "Z", "Lcom/facebook/appevents/gps/GpsDebugLogger;", "gpsDebugLogger", "Lcom/facebook/appevents/gps/GpsDebugLogger;", "serverUri", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class GpsAraTriggersManager {
    @NotNull
    private static final String GPS_PREFIX = "gps";
    @NotNull
    public static final GpsAraTriggersManager INSTANCE = null;
    @NotNull
    private static final String REPLACEMENT_STRING = "_removed_";
    @NotNull
    private static final String TAG;
    private static boolean enabled;
    private static GpsDebugLogger gpsDebugLogger;
    private static String serverUri;

    static {
        GpsAraTriggersManager.INSTANCE = new GpsAraTriggersManager();
        String s = GpsAraTriggersManager.class.toString();
        q.f(s, "GpsAraTriggersManager::class.java.toString()");
        GpsAraTriggersManager.TAG = s;
    }

    // 去混淆评级： 低(20)
    public static final GpsDebugLogger access$getGpsDebugLogger$p() {
        return CrashShieldHandler.isObjectCrashing(GpsAraTriggersManager.class) ? null : GpsAraTriggersManager.gpsDebugLogger;
    }

    // 去混淆评级： 低(20)
    public static final String access$getTAG$p() {
        return CrashShieldHandler.isObjectCrashing(GpsAraTriggersManager.class) ? null : GpsAraTriggersManager.TAG;
    }

    private final boolean canRegisterTrigger() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        if(!GpsAraTriggersManager.enabled) {
            return false;
        }
        try {
            try {
                Class.forName("android.adservices.measurement.MeasurementManager");
                return true;
            }
            catch(Exception exception0) {
                Log.i(GpsAraTriggersManager.TAG, "FAILURE_NO_MEASUREMENT_MANAGER_CLASS");
                GpsDebugLogger gpsDebugLogger0 = GpsAraTriggersManager.gpsDebugLogger;
                if(gpsDebugLogger0 != null) {
                    Bundle bundle0 = new Bundle();
                    bundle0.putString("gps_ara_failed_reason", exception0.toString());
                    gpsDebugLogger0.log("gps_ara_failed", bundle0);
                    return false;
                }
                q.m("gpsDebugLogger");
                throw null;
            }
            catch(Error error0) {
                Log.i(GpsAraTriggersManager.TAG, "FAILURE_NO_MEASUREMENT_MANAGER_CLASS");
                GpsDebugLogger gpsDebugLogger1 = GpsAraTriggersManager.gpsDebugLogger;
                if(gpsDebugLogger1 != null) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("gps_ara_failed_reason", error0.toString());
                    gpsDebugLogger1.log("gps_ara_failed", bundle1);
                    return false;
                }
                q.m("gpsDebugLogger");
                throw null;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return false;
        }
    }

    public static final void enable() {
        Class class0 = GpsAraTriggersManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            GpsAraTriggersManager.enabled = true;
            GpsAraTriggersManager.gpsDebugLogger = new GpsDebugLogger(FacebookSdk.getApplicationContext());
            GpsAraTriggersManager.serverUri = "https://www." + FacebookSdk.getFacebookDomain() + "/privacy_sandbox/mobile/register/trigger";
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private final String getEventParameters(AppEvent appEvent0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            JSONObject jSONObject0 = appEvent0.getJSONObject();
            if(jSONObject0 != null && jSONObject0.length() != 0) {
                Iterator iterator0 = jSONObject0.keys();
                q.f(iterator0, "params.keys()");
                return n.m0(n.o0(new a(new W0(iterator0, 2)), new k() {
                    final JSONObject $params;

                    {
                        this.$params = jSONObject0;
                        super(1);
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        return this.invoke(((String)object0));
                    }

                    @Nullable
                    public final String invoke(String s) {
                        Object object0 = this.$params.opt(s);
                        if(object0 == null) {
                            return null;
                        }
                        try {
                            return URLEncoder.encode(s, "UTF-8") + '=' + URLEncoder.encode(object0.toString(), "UTF-8");
                        }
                        catch(Exception unused_ex) {
                            return null;
                        }
                    }
                }), "&");
            }
            return "";
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    private final boolean isValidEvent(AppEvent appEvent0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        else {
            try {
                String s = appEvent0.getJSONObject().getString("_eventName");
                if(!q.b(s, "_removed_")) {
                    q.f(s, "eventName");
                    if(!o.v0(s, "gps", false)) {
                        return true;
                    }
                }
                return false;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return false;
    }

    @TargetApi(34)
    public final void registerTrigger(@NotNull String s, @NotNull AppEvent appEvent0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                q.g(s, "applicationId");
                q.g(appEvent0, "event");
                if(!this.isValidEvent(appEvent0) || !this.canRegisterTrigger()) {
                    return;
                }
                else {
                    Context context0 = FacebookSdk.getApplicationContext();
                    try {
                        MeasurementManager measurementManager0 = b.n(context0.getSystemService(b.D()));
                        if(measurementManager0 == null) {
                            measurementManager0 = b.m(context0.getApplicationContext());
                        }
                        if(measurementManager0 == null) {
                            Log.w(GpsAraTriggersManager.TAG, "FAILURE_GET_MEASUREMENT_MANAGER");
                            GpsDebugLogger gpsDebugLogger0 = GpsAraTriggersManager.gpsDebugLogger;
                            if(gpsDebugLogger0 != null) {
                                Bundle bundle0 = new Bundle();
                                bundle0.putString("gps_ara_failed_reason", "Failed to get measurement manager");
                                gpsDebugLogger0.log("gps_ara_failed", bundle0);
                                return;
                            }
                            q.m("gpsDebugLogger");
                            throw null;
                        }
                        String s1 = this.getEventParameters(appEvent0);
                        StringBuilder stringBuilder0 = new StringBuilder();
                        String s2 = GpsAraTriggersManager.serverUri;
                        if(s2 != null) {
                            stringBuilder0.append(s2);
                            stringBuilder0.append("?app_id=");
                            stringBuilder0.append(s);
                            stringBuilder0.append('&');
                            stringBuilder0.append(s1);
                            Uri uri0 = Uri.parse(stringBuilder0.toString());
                            q.f(uri0, "parse(\"$serverUri?$appId…=$applicationId&$params\")");
                            com.facebook.appevents.gps.ara.GpsAraTriggersManager.registerTrigger.outcomeReceiver.1 gpsAraTriggersManager$registerTrigger$outcomeReceiver$10 = new com.facebook.appevents.gps.ara.GpsAraTriggersManager.registerTrigger.outcomeReceiver.1();
                            measurementManager0.registerTrigger(uri0, FacebookSdk.getExecutor(), gpsAraTriggersManager$registerTrigger$outcomeReceiver$10);
                            return;
                        }
                        q.m("serverUri");
                        throw null;
                    }
                    catch(Exception exception0) {
                    }
                    catch(Error error0) {
                        goto label_49;
                    }
                }
                Log.w(GpsAraTriggersManager.TAG, "FAILURE_TRIGGER_REGISTRATION_FAILED");
                GpsDebugLogger gpsDebugLogger1 = GpsAraTriggersManager.gpsDebugLogger;
                if(gpsDebugLogger1 != null) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("gps_ara_failed_reason", exception0.toString());
                    gpsDebugLogger1.log("gps_ara_failed", bundle1);
                    return;
                }
                q.m("gpsDebugLogger");
                throw null;
            label_49:
                Log.w(GpsAraTriggersManager.TAG, "FAILURE_TRIGGER_REGISTRATION_FAILED");
                GpsDebugLogger gpsDebugLogger2 = GpsAraTriggersManager.gpsDebugLogger;
                if(gpsDebugLogger2 != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("gps_ara_failed_reason", error0.toString());
                    gpsDebugLogger2.log("gps_ara_failed", bundle2);
                    return;
                }
                q.m("gpsDebugLogger");
                throw null;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);

        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001B\u0010\n\u001A\u00020\u00062\n\u0010\t\u001A\u00060\u0003j\u0002`\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"com/facebook/appevents/gps/ara/GpsAraTriggersManager$registerTrigger$outcomeReceiver$1", "Landroid/os/OutcomeReceiver;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "result", "Lie/H;", "onResult", "(Ljava/lang/Object;)V", "error", "onError", "(Ljava/lang/Exception;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public final class com.facebook.appevents.gps.ara.GpsAraTriggersManager.registerTrigger.outcomeReceiver.1 implements OutcomeReceiver {
            public void onError(@NotNull Exception exception0) {
                q.g(exception0, "error");
                Log.d(GpsAraTriggersManager.access$getTAG$p(), "OUTCOME_RECEIVER_TRIGGER_FAILURE");
                GpsDebugLogger gpsDebugLogger0 = GpsAraTriggersManager.access$getGpsDebugLogger$p();
                if(gpsDebugLogger0 != null) {
                    Bundle bundle0 = new Bundle();
                    bundle0.putString("gps_ara_failed_reason", exception0.toString());
                    gpsDebugLogger0.log("gps_ara_failed", bundle0);
                    return;
                }
                q.m("gpsDebugLogger");
                throw null;
            }

            @Override  // android.os.OutcomeReceiver
            public void onError(Throwable throwable0) {
                this.onError(((Exception)throwable0));
            }

            @Override  // android.os.OutcomeReceiver
            public void onResult(@NotNull Object object0) {
                q.g(object0, "result");
                Log.d(GpsAraTriggersManager.access$getTAG$p(), "OUTCOME_RECEIVER_TRIGGER_SUCCESS");
                GpsDebugLogger gpsDebugLogger0 = GpsAraTriggersManager.access$getGpsDebugLogger$p();
                if(gpsDebugLogger0 != null) {
                    gpsDebugLogger0.log("gps_ara_succeed", null);
                    return;
                }
                q.m("gpsDebugLogger");
                throw null;
            }
        }

    }

    public final void registerTriggerAsync(@NotNull String s, @NotNull AppEvent appEvent0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(s, "applicationId");
            q.g(appEvent0, "event");
            FacebookSdk.getExecutor().execute(new com.facebook.appevents.gps.ara.a(s, appEvent0, 0));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private static final void registerTriggerAsync$lambda$0(String s, AppEvent appEvent0) {
        Class class0 = GpsAraTriggersManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(s, "$applicationId");
            q.g(appEvent0, "$event");
            GpsAraTriggersManager.INSTANCE.registerTrigger(s, appEvent0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }
}

