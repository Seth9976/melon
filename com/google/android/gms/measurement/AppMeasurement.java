package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.measurement.internal.zzib;
import com.google.android.gms.measurement.internal.zzjg;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzlj;
import com.google.android.gms.measurement.internal.zzls;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@KeepForSdk
@ShowFirstParty
@Deprecated
public class AppMeasurement {
    @KeepForSdk
    @ShowFirstParty
    public static class ConditionalUserProperty {
        @Keep
        @KeepForSdk
        @ShowFirstParty
        public boolean mActive;
        @Keep
        @KeepForSdk
        @ShowFirstParty
        public String mAppId;
        @Keep
        @KeepForSdk
        @ShowFirstParty
        public long mCreationTimestamp;
        @Keep
        public String mExpiredEventName;
        @Keep
        public Bundle mExpiredEventParams;
        @Keep
        @KeepForSdk
        @ShowFirstParty
        public String mName;
        @Keep
        @KeepForSdk
        @ShowFirstParty
        public String mOrigin;
        @Keep
        @KeepForSdk
        @ShowFirstParty
        public long mTimeToLive;
        @Keep
        public String mTimedOutEventName;
        @Keep
        public Bundle mTimedOutEventParams;
        @Keep
        @KeepForSdk
        @ShowFirstParty
        public String mTriggerEventName;
        @Keep
        @KeepForSdk
        @ShowFirstParty
        public long mTriggerTimeout;
        @Keep
        public String mTriggeredEventName;
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        @KeepForSdk
        @ShowFirstParty
        public long mTriggeredTimestamp;
        @Keep
        @KeepForSdk
        @ShowFirstParty
        public Object mValue;

        @KeepForSdk
        public ConditionalUserProperty() {
        }

        public ConditionalUserProperty(Bundle bundle0) {
            Preconditions.checkNotNull(bundle0);
            this.mAppId = (String)zzjg.zzb(bundle0, "app_id", String.class, null);
            this.mOrigin = (String)zzjg.zzb(bundle0, "origin", String.class, null);
            this.mName = (String)zzjg.zzb(bundle0, "name", String.class, null);
            this.mValue = zzjg.zzb(bundle0, "value", Object.class, null);
            this.mTriggerEventName = (String)zzjg.zzb(bundle0, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = (long)(((Long)zzjg.zzb(bundle0, "trigger_timeout", Long.class, 0L)));
            this.mTimedOutEventName = (String)zzjg.zzb(bundle0, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle)zzjg.zzb(bundle0, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String)zzjg.zzb(bundle0, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle)zzjg.zzb(bundle0, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = (long)(((Long)zzjg.zzb(bundle0, "time_to_live", Long.class, 0L)));
            this.mExpiredEventName = (String)zzjg.zzb(bundle0, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle)zzjg.zzb(bundle0, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean)zzjg.zzb(bundle0, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = (long)(((Long)zzjg.zzb(bundle0, "creation_timestamp", Long.class, 0L)));
            this.mTriggeredTimestamp = (long)(((Long)zzjg.zzb(bundle0, "triggered_timestamp", Long.class, 0L)));
        }

        @KeepForSdk
        public ConditionalUserProperty(ConditionalUserProperty appMeasurement$ConditionalUserProperty0) {
            Preconditions.checkNotNull(appMeasurement$ConditionalUserProperty0);
            this.mAppId = appMeasurement$ConditionalUserProperty0.mAppId;
            this.mOrigin = appMeasurement$ConditionalUserProperty0.mOrigin;
            this.mCreationTimestamp = appMeasurement$ConditionalUserProperty0.mCreationTimestamp;
            this.mName = appMeasurement$ConditionalUserProperty0.mName;
            Object object0 = appMeasurement$ConditionalUserProperty0.mValue;
            if(object0 != null) {
                Object object1 = zzls.zzb(object0);
                this.mValue = object1;
                if(object1 == null) {
                    this.mValue = appMeasurement$ConditionalUserProperty0.mValue;
                }
            }
            this.mActive = appMeasurement$ConditionalUserProperty0.mActive;
            this.mTriggerEventName = appMeasurement$ConditionalUserProperty0.mTriggerEventName;
            this.mTriggerTimeout = appMeasurement$ConditionalUserProperty0.mTriggerTimeout;
            this.mTimedOutEventName = appMeasurement$ConditionalUserProperty0.mTimedOutEventName;
            Bundle bundle0 = appMeasurement$ConditionalUserProperty0.mTimedOutEventParams;
            if(bundle0 != null) {
                this.mTimedOutEventParams = new Bundle(bundle0);
            }
            this.mTriggeredEventName = appMeasurement$ConditionalUserProperty0.mTriggeredEventName;
            Bundle bundle1 = appMeasurement$ConditionalUserProperty0.mTriggeredEventParams;
            if(bundle1 != null) {
                this.mTriggeredEventParams = new Bundle(bundle1);
            }
            this.mTriggeredTimestamp = appMeasurement$ConditionalUserProperty0.mTriggeredTimestamp;
            this.mTimeToLive = appMeasurement$ConditionalUserProperty0.mTimeToLive;
            this.mExpiredEventName = appMeasurement$ConditionalUserProperty0.mExpiredEventName;
            Bundle bundle2 = appMeasurement$ConditionalUserProperty0.mExpiredEventParams;
            if(bundle2 != null) {
                this.mExpiredEventParams = new Bundle(bundle2);
            }
        }
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

    @KeepForSdk
    @ShowFirstParty
    public static final String CRASH_ORIGIN = "crash";
    @KeepForSdk
    @ShowFirstParty
    public static final String FCM_ORIGIN = "fcm";
    @KeepForSdk
    @ShowFirstParty
    public static final String FIAM_ORIGIN = "fiam";
    private static volatile AppMeasurement zza;
    private final zzc zzb;

    public AppMeasurement(zzib zzib0) {
        this.zzb = new zza(zzib0);
    }

    public AppMeasurement(zzlj zzlj0) {
        this.zzb = new zzb(zzlj0);
    }

    @Keep
    public void beginAdUnitExposure(String s) {
        this.zzb.zzm(s);
    }

    @Keep
    @KeepForSdk
    @ShowFirstParty
    public void clearConditionalUserProperty(String s, String s1, Bundle bundle0) {
        this.zzb.zzp(s, s1, bundle0);
    }

    @Keep
    public void endAdUnitExposure(String s) {
        this.zzb.zzn(s);
    }

    @Keep
    public long generateEventId() {
        return this.zzb.zzl();
    }

    @Keep
    public String getAppInstanceId() {
        return this.zzb.zzj();
    }

    @KeepForSdk
    public Boolean getBoolean() {
        return this.zzb.zzs();
    }

    @Keep
    @KeepForSdk
    @ShowFirstParty
    public List getConditionalUserProperties(String s, String s1) {
        List list0 = this.zzb.zzq(s, s1);
        List list1 = new ArrayList((list0 == null ? 0 : list0.size()));
        for(Object object0: list0) {
            ((ArrayList)list1).add(new ConditionalUserProperty(((Bundle)object0)));
        }
        return list1;
    }

    @Keep
    public String getCurrentScreenClass() {
        return this.zzb.zzi();
    }

    @Keep
    public String getCurrentScreenName() {
        return this.zzb.zzh();
    }

    @KeepForSdk
    public Double getDouble() {
        return this.zzb.zzw();
    }

    @Keep
    public String getGmpAppId() {
        return this.zzb.zzk();
    }

    @Keep
    @KeepForSdk
    @ShowFirstParty
    @Deprecated
    public static AppMeasurement getInstance(Context context0) {
        zzlj zzlj0;
        if(AppMeasurement.zza == null) {
            Class class0 = AppMeasurement.class;
            __monitor_enter(class0);
            if(AppMeasurement.zza == null) {
                try {
                    zzlj0 = null;
                    zzlj0 = FirebaseAnalytics.getScionFrontendApiImplementation(context0, null);
                }
                catch(Exception unused_ex) {
                }
                AppMeasurement.zza = zzlj0 == null ? new AppMeasurement(zzib.zzy(context0, new zzdd(0L, 0L, true, null, null), null)) : new AppMeasurement(zzlj0);
            }
            __monitor_exit(class0);
            return AppMeasurement.zza;
        }
        return AppMeasurement.zza;
    }

    @KeepForSdk
    public Integer getInteger() {
        return this.zzb.zzt();
    }

    @KeepForSdk
    public Long getLong() {
        return this.zzb.zzv();
    }

    @Keep
    @KeepForSdk
    @ShowFirstParty
    public int getMaxUserProperties(String s) {
        return this.zzb.zzr(s);
    }

    @KeepForSdk
    public String getString() {
        return this.zzb.zzu();
    }

    @Keep
    public Map getUserProperties(String s, String s1, boolean z) {
        return this.zzb.zzd(s, s1, z);
    }

    @KeepForSdk
    @ShowFirstParty
    public Map getUserProperties(boolean z) {
        return this.zzb.zzc(z);
    }

    @Keep
    @ShowFirstParty
    public void logEventInternal(String s, String s1, Bundle bundle0) {
        this.zzb.zza(s, s1, bundle0);
    }

    @KeepForSdk
    @ShowFirstParty
    public void logEventInternalNoInterceptor(String s, String s1, Bundle bundle0, long v) {
        this.zzb.zzb(s, s1, bundle0, v);
    }

    @KeepForSdk
    @ShowFirstParty
    public void registerOnMeasurementEventListener(OnEventListener appMeasurement$OnEventListener0) {
        this.zzb.zzf(appMeasurement$OnEventListener0);
    }

    @Keep
    @KeepForSdk
    @ShowFirstParty
    public void setConditionalUserProperty(ConditionalUserProperty appMeasurement$ConditionalUserProperty0) {
        Preconditions.checkNotNull(appMeasurement$ConditionalUserProperty0);
        Bundle bundle0 = new Bundle();
        String s = appMeasurement$ConditionalUserProperty0.mAppId;
        if(s != null) {
            bundle0.putString("app_id", s);
        }
        String s1 = appMeasurement$ConditionalUserProperty0.mOrigin;
        if(s1 != null) {
            bundle0.putString("origin", s1);
        }
        String s2 = appMeasurement$ConditionalUserProperty0.mName;
        if(s2 != null) {
            bundle0.putString("name", s2);
        }
        Object object0 = appMeasurement$ConditionalUserProperty0.mValue;
        if(object0 != null) {
            zzjg.zza(bundle0, object0);
        }
        String s3 = appMeasurement$ConditionalUserProperty0.mTriggerEventName;
        if(s3 != null) {
            bundle0.putString("trigger_event_name", s3);
        }
        bundle0.putLong("trigger_timeout", appMeasurement$ConditionalUserProperty0.mTriggerTimeout);
        String s4 = appMeasurement$ConditionalUserProperty0.mTimedOutEventName;
        if(s4 != null) {
            bundle0.putString("timed_out_event_name", s4);
        }
        Bundle bundle1 = appMeasurement$ConditionalUserProperty0.mTimedOutEventParams;
        if(bundle1 != null) {
            bundle0.putBundle("timed_out_event_params", bundle1);
        }
        String s5 = appMeasurement$ConditionalUserProperty0.mTriggeredEventName;
        if(s5 != null) {
            bundle0.putString("triggered_event_name", s5);
        }
        Bundle bundle2 = appMeasurement$ConditionalUserProperty0.mTriggeredEventParams;
        if(bundle2 != null) {
            bundle0.putBundle("triggered_event_params", bundle2);
        }
        bundle0.putLong("time_to_live", appMeasurement$ConditionalUserProperty0.mTimeToLive);
        String s6 = appMeasurement$ConditionalUserProperty0.mExpiredEventName;
        if(s6 != null) {
            bundle0.putString("expired_event_name", s6);
        }
        Bundle bundle3 = appMeasurement$ConditionalUserProperty0.mExpiredEventParams;
        if(bundle3 != null) {
            bundle0.putBundle("expired_event_params", bundle3);
        }
        bundle0.putLong("creation_timestamp", appMeasurement$ConditionalUserProperty0.mCreationTimestamp);
        bundle0.putBoolean("active", appMeasurement$ConditionalUserProperty0.mActive);
        bundle0.putLong("triggered_timestamp", appMeasurement$ConditionalUserProperty0.mTriggeredTimestamp);
        this.zzb.zzo(bundle0);
    }

    @KeepForSdk
    @ShowFirstParty
    public void setEventInterceptor(EventInterceptor appMeasurement$EventInterceptor0) {
        this.zzb.zze(appMeasurement$EventInterceptor0);
    }

    @KeepForSdk
    @ShowFirstParty
    public void unregisterOnMeasurementEventListener(OnEventListener appMeasurement$OnEventListener0) {
        this.zzb.zzg(appMeasurement$OnEventListener0);
    }
}

