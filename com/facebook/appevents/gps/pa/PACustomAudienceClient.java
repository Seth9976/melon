package com.facebook.appevents.gps.pa;

import B5.a;
import Tf.o;
import android.adservices.common.AdData.Builder;
import android.adservices.common.AdData;
import android.adservices.customaudience.CustomAudience.Builder;
import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.CustomAudienceManager;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData.Builder;
import android.adservices.customaudience.TrustedBiddingData;
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
import e.k;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import n4.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J#\u0010\t\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\b\u001A\u0004\u0018\u00010\u0006H\u0003¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000B\u001A\u0004\u0018\u00010\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\b\u001A\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000B\u0010\fJ!\u0010\r\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\b\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\nJ!\u0010\r\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E¢\u0006\u0004\b\r\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001A\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001A\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001A\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001A\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0016\u0010\u0019\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u0016\u0010\u001B\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u001AR\u0018\u0010\u001D\u001A\u0004\u0018\u00010\u001C8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0016\u0010 \u001A\u00020\u001F8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001A\u00020\u00068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010\u0012¨\u0006#"}, d2 = {"Lcom/facebook/appevents/gps/pa/PACustomAudienceClient;", "", "<init>", "()V", "Lie/H;", "enable", "", "appId", "eventName", "joinCustomAudienceImpl", "(Ljava/lang/String;Ljava/lang/String;)V", "validateAndCreateCAName", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "joinCustomAudience", "Lcom/facebook/appevents/AppEvent;", "event", "(Ljava/lang/String;Lcom/facebook/appevents/AppEvent;)V", "TAG", "Ljava/lang/String;", "BUYER", "DELIMITER", "GPS_PREFIX", "EVENT_NAME_CONFIG_VERSION", "REPLACEMENT_STRING", "", "enabled", "Z", "isInitialized", "Landroid/adservices/customaudience/CustomAudienceManager;", "customAudienceManager", "Landroid/adservices/customaudience/CustomAudienceManager;", "Lcom/facebook/appevents/gps/GpsDebugLogger;", "gpsDebugLogger", "Lcom/facebook/appevents/gps/GpsDebugLogger;", "baseUri", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class PACustomAudienceClient {
    @NotNull
    private static final String BUYER = "facebook.com";
    @NotNull
    private static final String DELIMITER = "@";
    @NotNull
    private static final String EVENT_NAME_CONFIG_VERSION = "1";
    @NotNull
    private static final String GPS_PREFIX = "gps";
    @NotNull
    public static final PACustomAudienceClient INSTANCE = null;
    @NotNull
    private static final String REPLACEMENT_STRING = "_removed_";
    @NotNull
    private static final String TAG;
    private static String baseUri;
    @Nullable
    private static CustomAudienceManager customAudienceManager;
    private static boolean enabled;
    private static GpsDebugLogger gpsDebugLogger;
    private static boolean isInitialized;

    static {
        PACustomAudienceClient.INSTANCE = new PACustomAudienceClient();
        PACustomAudienceClient.TAG = "Fledge: PACustomAudienceClient";
    }

    // 去混淆评级： 低(20)
    public static final GpsDebugLogger access$getGpsDebugLogger$p() {
        return CrashShieldHandler.isObjectCrashing(PACustomAudienceClient.class) ? null : PACustomAudienceClient.gpsDebugLogger;
    }

    // 去混淆评级： 低(40)
    public static final String access$getTAG$p() [...] // 潜在的解密器

    @TargetApi(34)
    public static final void enable() {
        String s;
        Class class0 = PACustomAudienceClient.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                PACustomAudienceClient.isInitialized = true;
                Context context0 = FacebookSdk.getApplicationContext();
                PACustomAudienceClient.gpsDebugLogger = new GpsDebugLogger(context0);
                PACustomAudienceClient.baseUri = "https://www." + FacebookSdk.getFacebookDomain() + "/privacy_sandbox/pa/logic";
                try {
                    CustomAudienceManager customAudienceManager0 = b.k(context0);
                    PACustomAudienceClient.customAudienceManager = customAudienceManager0;
                    if(customAudienceManager0 != null) {
                        PACustomAudienceClient.enabled = true;
                    }
                    s = null;
                }
                catch(Exception exception0) {
                    s = exception0.toString();
                    Log.w("Fledge: PACustomAudienceClient", "Failed to get CustomAudienceManager: " + exception0);
                }
                catch(Error error0) {
                    s = error0.toString();
                    Log.w("Fledge: PACustomAudienceClient", "Failed to get CustomAudienceManager: " + error0);
                }
                if(!PACustomAudienceClient.enabled) {
                    GpsDebugLogger gpsDebugLogger0 = PACustomAudienceClient.gpsDebugLogger;
                    if(gpsDebugLogger0 != null) {
                        Bundle bundle0 = new Bundle();
                        bundle0.putString("gps_pa_failed_reason", s);
                        gpsDebugLogger0.log("gps_pa_failed", bundle0);
                        return;
                    }
                    q.m("gpsDebugLogger");
                    throw null;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public final void joinCustomAudience(@Nullable String s, @Nullable AppEvent appEvent0) {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if(!PACustomAudienceClient.isInitialized) {
                    PACustomAudienceClient.enable();
                }
                String s1 = null;
                if(PACustomAudienceClient.enabled) {
                    if(appEvent0 != null) {
                        try {
                            JSONObject jSONObject0 = appEvent0.getJSONObject();
                            if(jSONObject0 != null) {
                                s1 = jSONObject0.getString("_eventName");
                            }
                        }
                        catch(JSONException unused_ex) {
                            Log.w("Fledge: PACustomAudienceClient", "Failed to get event name from event.");
                        }
                    }
                    this.joinCustomAudienceImpl(s, s1);
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void joinCustomAudience(@Nullable String s, @Nullable String s1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                if(!PACustomAudienceClient.isInitialized) {
                    PACustomAudienceClient.enable();
                }
                if(PACustomAudienceClient.enabled) {
                    this.joinCustomAudienceImpl(s, s1);
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    @TargetApi(34)
    private final void joinCustomAudienceImpl(String s, String s1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                String s2 = this.validateAndCreateCAName(s, s1);
                if(s2 == null) {
                    return;
                }
                else {
                    try {
                        com.facebook.appevents.gps.pa.PACustomAudienceClient.joinCustomAudienceImpl.callback.1 pACustomAudienceClient$joinCustomAudienceImpl$callback$10 = new com.facebook.appevents.gps.pa.PACustomAudienceClient.joinCustomAudienceImpl.callback.1();
                        AdData.Builder adData$Builder0 = a.b();
                        String s3 = PACustomAudienceClient.baseUri;
                        if(s3 == null) {
                            q.m("baseUri");
                            throw null;
                        }
                        Uri uri0 = Uri.parse((s3 + "/ad"));
                        q.c(uri0);
                        AdData adData0 = a.c(adData$Builder0.setRenderUri(uri0)).build();
                        q.f(adData0, "Builder()\n              …\n                .build()");
                        TrustedBiddingData.Builder trustedBiddingData$Builder0 = a.s();
                        String s4 = PACustomAudienceClient.baseUri;
                        if(s4 == null) {
                            q.m("baseUri");
                            throw null;
                        }
                        Uri uri1 = Uri.parse((s4 + "?trusted_bidding"));
                        q.c(uri1);
                        TrustedBiddingData trustedBiddingData0 = trustedBiddingData$Builder0.setTrustedBiddingUri(uri1).setTrustedBiddingKeys(k.z("")).build();
                        q.f(trustedBiddingData0, "Builder()\n              …\n                .build()");
                        CustomAudience.Builder customAudience$Builder0 = a.h().setName(s2).setBuyer(a.g());
                        StringBuilder stringBuilder0 = new StringBuilder();
                        String s5 = PACustomAudienceClient.baseUri;
                        if(s5 == null) {
                            q.m("baseUri");
                            throw null;
                        }
                        stringBuilder0.append(s5);
                        stringBuilder0.append("?daily&app_id=");
                        stringBuilder0.append(s);
                        Uri uri2 = Uri.parse(stringBuilder0.toString());
                        q.c(uri2);
                        CustomAudience.Builder customAudience$Builder1 = customAudience$Builder0.setDailyUpdateUri(uri2);
                        String s6 = PACustomAudienceClient.baseUri;
                        if(s6 == null) {
                            q.m("baseUri");
                            throw null;
                        }
                        Uri uri3 = Uri.parse((s6 + "?bidding"));
                        q.c(uri3);
                        CustomAudience customAudience0 = customAudience$Builder1.setBiddingLogicUri(uri3).setTrustedBiddingData(trustedBiddingData0).setUserBiddingSignals(a.f()).setAds(k.z(adData0)).build();
                        q.f(customAudience0, "Builder()\n              …(listOf(dummyAd)).build()");
                        JoinCustomAudienceRequest joinCustomAudienceRequest0 = a.p().setCustomAudience(customAudience0).build();
                        q.f(joinCustomAudienceRequest0, "Builder().setCustomAudience(ca).build()");
                        CustomAudienceManager customAudienceManager0 = PACustomAudienceClient.customAudienceManager;
                        if(customAudienceManager0 != null) {
                            customAudienceManager0.joinCustomAudience(joinCustomAudienceRequest0, Executors.newSingleThreadExecutor(), pACustomAudienceClient$joinCustomAudienceImpl$callback$10);
                            return;
                        }
                        return;
                    }
                    catch(Exception exception0) {
                    }
                    catch(Error error0) {
                        goto label_63;
                    }
                }
                Log.w("Fledge: PACustomAudienceClient", "Failed to join Custom Audience: " + exception0);
                GpsDebugLogger gpsDebugLogger0 = PACustomAudienceClient.gpsDebugLogger;
                if(gpsDebugLogger0 != null) {
                    Bundle bundle0 = new Bundle();
                    bundle0.putString("gps_pa_failed_reason", exception0.toString());
                    gpsDebugLogger0.log("gps_pa_failed", bundle0);
                    return;
                }
                q.m("gpsDebugLogger");
                throw null;
            label_63:
                Log.w("Fledge: PACustomAudienceClient", "Failed to join Custom Audience: " + error0);
                GpsDebugLogger gpsDebugLogger1 = PACustomAudienceClient.gpsDebugLogger;
                if(gpsDebugLogger1 != null) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("gps_pa_failed_reason", error0.toString());
                    gpsDebugLogger1.log("gps_pa_failed", bundle1);
                    return;
                }
                q.m("gpsDebugLogger");
                throw null;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);

        @Metadata(d1 = {"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001B\u0010\n\u001A\u00020\u00062\n\u0010\t\u001A\u00060\u0003j\u0002`\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"com/facebook/appevents/gps/pa/PACustomAudienceClient$joinCustomAudienceImpl$callback$1", "Landroid/os/OutcomeReceiver;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "result", "Lie/H;", "onResult", "(Ljava/lang/Object;)V", "error", "onError", "(Ljava/lang/Exception;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public final class com.facebook.appevents.gps.pa.PACustomAudienceClient.joinCustomAudienceImpl.callback.1 implements OutcomeReceiver {
            public void onError(@NotNull Exception exception0) {
                q.g(exception0, "error");
                Log.e("Fledge: PACustomAudienceClient", exception0.toString());
                GpsDebugLogger gpsDebugLogger0 = PACustomAudienceClient.access$getGpsDebugLogger$p();
                if(gpsDebugLogger0 != null) {
                    Bundle bundle0 = new Bundle();
                    bundle0.putString("gps_pa_failed_reason", exception0.toString());
                    gpsDebugLogger0.log("gps_pa_failed", bundle0);
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
                Log.i("Fledge: PACustomAudienceClient", "Successfully joined custom audience");
                GpsDebugLogger gpsDebugLogger0 = PACustomAudienceClient.access$getGpsDebugLogger$p();
                if(gpsDebugLogger0 != null) {
                    gpsDebugLogger0.log("gps_pa_succeed", null);
                    return;
                }
                q.m("gpsDebugLogger");
                throw null;
            }
        }

    }

    private final String validateAndCreateCAName(String s, String s1) {
        if(!CrashShieldHandler.isObjectCrashing(this) && s != null && s1 != null) {
            try {
                if(!s1.equals("_removed_") && !o.v0(s1, "gps", false)) {
                    return s + '@' + s1 + '@' + System.currentTimeMillis() / 1000L + "@1";
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
        return null;
    }
}

