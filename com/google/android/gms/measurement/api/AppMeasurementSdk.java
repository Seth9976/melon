package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.android.gms.measurement.internal.zzjp;
import java.util.List;
import java.util.Map;

@KeepForSdk
@ShowFirstParty
public class AppMeasurementSdk {
    @KeepForSdk
    public static final class ConditionalUserProperty {
        @KeepForSdk
        public static final String ACTIVE = "active";
        @KeepForSdk
        public static final String CREATION_TIMESTAMP = "creation_timestamp";
        @KeepForSdk
        public static final String EXPIRED_EVENT_NAME = "expired_event_name";
        @KeepForSdk
        public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";
        @KeepForSdk
        public static final String NAME = "name";
        @KeepForSdk
        public static final String ORIGIN = "origin";
        @KeepForSdk
        public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";
        @KeepForSdk
        public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";
        @KeepForSdk
        public static final String TIME_TO_LIVE = "time_to_live";
        @KeepForSdk
        public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";
        @KeepForSdk
        public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";
        @KeepForSdk
        public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";
        @KeepForSdk
        public static final String TRIGGER_EVENT_NAME = "trigger_event_name";
        @KeepForSdk
        public static final String TRIGGER_TIMEOUT = "trigger_timeout";
        @KeepForSdk
        public static final String VALUE = "value";

    }

    @KeepForSdk
    @ShowFirstParty
    public interface EventInterceptor extends zzjo {
        @Override  // com.google.android.gms.measurement.internal.zzjo
        @KeepForSdk
        @ShowFirstParty
        void interceptEvent(String arg1, String arg2, Bundle arg3, long arg4);
    }

    @KeepForSdk
    @ShowFirstParty
    public interface OnEventListener extends zzjp {
        @Override  // com.google.android.gms.measurement.internal.zzjp
        @KeepForSdk
        @ShowFirstParty
        void onEvent(String arg1, String arg2, Bundle arg3, long arg4);
    }

    private final zzfb zza;

    public AppMeasurementSdk(zzfb zzfb0) {
        this.zza = zzfb0;
    }

    @KeepForSdk
    public void beginAdUnitExposure(String s) {
        this.zza.zzu(s);
    }

    @KeepForSdk
    public void clearConditionalUserProperty(String s, String s1, Bundle bundle0) {
        this.zza.zzm(s, s1, bundle0);
    }

    @KeepForSdk
    public void endAdUnitExposure(String s) {
        this.zza.zzv(s);
    }

    @KeepForSdk
    public long generateEventId() {
        return this.zza.zzz();
    }

    @KeepForSdk
    public String getAppIdOrigin() {
        return this.zza.zzI();
    }

    @KeepForSdk
    public String getAppInstanceId() {
        return this.zza.zzy();
    }

    @KeepForSdk
    public List getConditionalUserProperties(String s, String s1) {
        return this.zza.zzn(s, s1);
    }

    @KeepForSdk
    public String getCurrentScreenClass() {
        return this.zza.zzB();
    }

    @KeepForSdk
    public String getCurrentScreenName() {
        return this.zza.zzA();
    }

    @KeepForSdk
    public String getGmpAppId() {
        return this.zza.zzx();
    }

    @KeepForSdk
    @ShowFirstParty
    public static AppMeasurementSdk getInstance(Context context0) {
        return zzfb.zza(context0, null).zzb();
    }

    @KeepForSdk
    @Deprecated
    public static AppMeasurementSdk getInstance(Context context0, String s, String s1, String s2, Bundle bundle0) {
        return zzfb.zza(context0, bundle0).zzb();
    }

    @KeepForSdk
    public int getMaxUserProperties(String s) {
        return this.zza.zzF(s);
    }

    @KeepForSdk
    public Map getUserProperties(String s, String s1, boolean z) {
        return this.zza.zzC(s, s1, z);
    }

    @KeepForSdk
    public void logEvent(String s, String s1, Bundle bundle0) {
        this.zza.zzi(s, s1, bundle0);
    }

    @KeepForSdk
    public void logEventNoInterceptor(String s, String s1, Bundle bundle0, long v) {
        this.zza.zzj(s, s1, bundle0, v);
    }

    @KeepForSdk
    public void performAction(Bundle bundle0) {
        this.zza.zzE(bundle0, false);
    }

    @KeepForSdk
    public Bundle performActionWithResponse(Bundle bundle0) {
        return this.zza.zzE(bundle0, true);
    }

    @KeepForSdk
    @ShowFirstParty
    public void registerOnMeasurementEventListener(OnEventListener appMeasurementSdk$OnEventListener0) {
        this.zza.zzf(appMeasurementSdk$OnEventListener0);
    }

    @KeepForSdk
    public void setConditionalUserProperty(Bundle bundle0) {
        this.zza.zzl(bundle0);
    }

    @KeepForSdk
    @Deprecated
    public void setConsent(Bundle bundle0) {
    }

    @KeepForSdk
    public void setCurrentScreen(Activity activity0, String s, String s1) {
        zzdf zzdf0 = zzdf.zza(activity0);
        this.zza.zzp(zzdf0, s, s1);
    }

    @KeepForSdk
    @ShowFirstParty
    public void setEventInterceptor(EventInterceptor appMeasurementSdk$EventInterceptor0) {
        this.zza.zzd(appMeasurementSdk$EventInterceptor0);
    }

    @KeepForSdk
    @Deprecated
    public void setMeasurementEnabled(Boolean boolean0) {
    }

    @KeepForSdk
    @Deprecated
    public void setMeasurementEnabled(boolean z) {
    }

    @KeepForSdk
    public void setUserProperty(String s, String s1, Object object0) {
        this.zza.zzk(s, s1, object0, true);
    }

    @KeepForSdk
    @ShowFirstParty
    public void unregisterOnMeasurementEventListener(OnEventListener appMeasurementSdk$OnEventListener0) {
        this.zza.zzg(appMeasurementSdk$OnEventListener0);
    }

    public final void zza(boolean z) {
        this.zza.zzK(z);
    }
}

