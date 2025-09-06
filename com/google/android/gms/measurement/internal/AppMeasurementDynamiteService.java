package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.collection.f;
import b3.Z;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzcq;
import com.google.android.gms.internal.measurement.zzcu;
import com.google.android.gms.internal.measurement.zzcx;
import com.google.android.gms.internal.measurement.zzda;
import com.google.android.gms.internal.measurement.zzdc;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.internal.measurement.zzdf;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@DynamiteApi
public class AppMeasurementDynamiteService extends zzcq {
    zzib zza;
    private final Map zzb;

    public AppMeasurementDynamiteService() {
        this.zza = null;
        this.zzb = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void beginAdUnitExposure(String s, long v) {
        this.zzb();
        this.zza.zzw().zza(s, v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void clearConditionalUserProperty(String s, String s1, Bundle bundle0) {
        this.zzb();
        this.zza.zzj().zzab(s, s1, bundle0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void clearMeasurementEnabled(long v) {
        this.zzb();
        this.zza.zzj().zzn(null);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void endAdUnitExposure(String s, long v) {
        this.zzb();
        this.zza.zzw().zzb(s, v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void generateEventId(zzcu zzcu0) {
        this.zzb();
        long v = this.zza.zzk().zzd();
        this.zzb();
        this.zza.zzk().zzam(zzcu0, v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void getAppInstanceId(zzcu zzcu0) {
        this.zzb();
        this.zza.zzaW().zzj(new zzi(this, zzcu0));
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void getCachedAppInstanceId(zzcu zzcu0) {
        this.zzb();
        this.zzc(zzcu0, this.zza.zzj().zzQ());
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void getConditionalUserProperties(String s, String s1, zzcu zzcu0) {
        this.zzb();
        this.zza.zzaW().zzj(new zzm(this, zzcu0, s, s1));
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void getCurrentScreenClass(zzcu zzcu0) {
        this.zzb();
        this.zzc(zzcu0, this.zza.zzj().zzae());
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void getCurrentScreenName(zzcu zzcu0) {
        this.zzb();
        this.zzc(zzcu0, this.zza.zzj().zzad());
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void getGmpAppId(zzcu zzcu0) {
        String s;
        this.zzb();
        zzli zzli0 = this.zza.zzj();
        try {
            s = zzls.zza(zzli0.zzu.zzaY(), "google_app_id", zzli0.zzu.zzq());
        }
        catch(IllegalStateException illegalStateException0) {
            zzli0.zzu.zzaV().zzb().zzb("getGoogleAppId failed with exception", illegalStateException0);
            s = null;
        }
        this.zzc(zzcu0, s);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void getMaxUserProperties(String s, zzcu zzcu0) {
        this.zzb();
        this.zza.zzj().zzY(s);
        this.zzb();
        this.zza.zzk().zzan(zzcu0, 25);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void getSessionId(zzcu zzcu0) {
        this.zzb();
        zzli zzli0 = this.zza.zzj();
        zzli0.zzu.zzaW().zzj(new zzkl(zzli0, zzcu0));
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void getTestFlag(zzcu zzcu0, int v) {
        this.zzb();
        switch(v) {
            case 0: {
                this.zza.zzk().zzal(zzcu0, this.zza.zzj().zzj());
                return;
            }
            case 1: {
                this.zza.zzk().zzam(zzcu0, ((long)this.zza.zzj().zzk()));
                return;
            }
            case 2: {
                zzpo zzpo0 = this.zza.zzk();
                double f = (double)this.zza.zzj().zzm();
                Bundle bundle0 = new Bundle();
                bundle0.putDouble("r", f);
                try {
                    zzcu0.zzb(bundle0);
                }
                catch(RemoteException remoteException0) {
                    zzpo0.zzu.zzaV().zze().zzb("Error returning double value to wrapper", remoteException0);
                }
                return;
            }
            case 3: {
                this.zza.zzk().zzan(zzcu0, ((int)this.zza.zzj().zzl()));
                return;
            }
            case 4: {
                this.zza.zzk().zzap(zzcu0, this.zza.zzj().zzi().booleanValue());
            }
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void getUserProperties(String s, String s1, boolean z, zzcu zzcu0) {
        this.zzb();
        this.zza.zzaW().zzj(new zzk(this, zzcu0, s, s1, z));
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void initForTests(Map map0) {
        this.zzb();
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void initialize(IObjectWrapper iObjectWrapper0, zzdd zzdd0, long v) {
        zzib zzib0 = this.zza;
        if(zzib0 == null) {
            this.zza = zzib.zzy(((Context)Preconditions.checkNotNull(((Context)ObjectWrapper.unwrap(iObjectWrapper0)))), zzdd0, v);
            return;
        }
        Z.A(zzib0, "Attempting to initialize multiple times");
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void isDataCollectionEnabled(zzcu zzcu0) {
        this.zzb();
        this.zza.zzaW().zzj(new zzn(this, zzcu0));
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void logEvent(String s, String s1, Bundle bundle0, boolean z, boolean z1, long v) {
        this.zzb();
        this.zza.zzj().zzC(s, s1, bundle0, z, z1, v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void logEventAndBundle(String s, String s1, Bundle bundle0, zzcu zzcu0, long v) {
        this.zzb();
        Preconditions.checkNotEmpty(s1);
        (bundle0 == null ? new Bundle() : new Bundle(bundle0)).putString("_o", "app");
        zzbg zzbg0 = new zzbg(s1, new zzbe(bundle0), "app", v);
        this.zza.zzaW().zzj(new zzj(this, zzcu0, zzbg0, s));
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void logHealthData(int v, String s, IObjectWrapper iObjectWrapper0, IObjectWrapper iObjectWrapper1, IObjectWrapper iObjectWrapper2) {
        this.zzb();
        Object object0 = null;
        Object object1 = iObjectWrapper0 == null ? null : ObjectWrapper.unwrap(iObjectWrapper0);
        Object object2 = iObjectWrapper1 == null ? null : ObjectWrapper.unwrap(iObjectWrapper1);
        if(iObjectWrapper2 != null) {
            object0 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        this.zza.zzaV().zzm(v, true, false, s, object1, object2, object0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void onActivityCreated(IObjectWrapper iObjectWrapper0, Bundle bundle0, long v) {
        this.zzb();
        this.onActivityCreatedByScionActivityInfo(zzdf.zza(((Activity)Preconditions.checkNotNull(((Activity)ObjectWrapper.unwrap(iObjectWrapper0))))), bundle0, v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void onActivityCreatedByScionActivityInfo(zzdf zzdf0, Bundle bundle0, long v) {
        this.zzb();
        zzkx zzkx0 = this.zza.zzj().zza;
        if(zzkx0 != null) {
            this.zza.zzj().zzh();
            zzkx0.zza(zzdf0, bundle0);
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper0, long v) {
        this.zzb();
        this.onActivityDestroyedByScionActivityInfo(zzdf.zza(((Activity)Preconditions.checkNotNull(((Activity)ObjectWrapper.unwrap(iObjectWrapper0))))), v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void onActivityDestroyedByScionActivityInfo(zzdf zzdf0, long v) {
        this.zzb();
        zzkx zzkx0 = this.zza.zzj().zza;
        if(zzkx0 != null) {
            this.zza.zzj().zzh();
            zzkx0.zzb(zzdf0);
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void onActivityPaused(IObjectWrapper iObjectWrapper0, long v) {
        this.zzb();
        this.onActivityPausedByScionActivityInfo(zzdf.zza(((Activity)Preconditions.checkNotNull(((Activity)ObjectWrapper.unwrap(iObjectWrapper0))))), v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void onActivityPausedByScionActivityInfo(zzdf zzdf0, long v) {
        this.zzb();
        zzkx zzkx0 = this.zza.zzj().zza;
        if(zzkx0 != null) {
            this.zza.zzj().zzh();
            zzkx0.zzc(zzdf0);
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void onActivityResumed(IObjectWrapper iObjectWrapper0, long v) {
        this.zzb();
        this.onActivityResumedByScionActivityInfo(zzdf.zza(((Activity)Preconditions.checkNotNull(((Activity)ObjectWrapper.unwrap(iObjectWrapper0))))), v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void onActivityResumedByScionActivityInfo(zzdf zzdf0, long v) {
        this.zzb();
        zzkx zzkx0 = this.zza.zzj().zza;
        if(zzkx0 != null) {
            this.zza.zzj().zzh();
            zzkx0.zzd(zzdf0);
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper0, zzcu zzcu0, long v) {
        this.zzb();
        this.onActivitySaveInstanceStateByScionActivityInfo(zzdf.zza(((Activity)Preconditions.checkNotNull(((Activity)ObjectWrapper.unwrap(iObjectWrapper0))))), zzcu0, v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void onActivitySaveInstanceStateByScionActivityInfo(zzdf zzdf0, zzcu zzcu0, long v) {
        this.zzb();
        zzkx zzkx0 = this.zza.zzj().zza;
        Bundle bundle0 = new Bundle();
        if(zzkx0 != null) {
            this.zza.zzj().zzh();
            zzkx0.zze(zzdf0, bundle0);
        }
        try {
            zzcu0.zzb(bundle0);
        }
        catch(RemoteException remoteException0) {
            this.zza.zzaV().zze().zzb("Error returning bundle value to wrapper", remoteException0);
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStarted(IObjectWrapper iObjectWrapper0, long v) {
        this.zzb();
        this.onActivityStartedByScionActivityInfo(zzdf.zza(((Activity)Preconditions.checkNotNull(((Activity)ObjectWrapper.unwrap(iObjectWrapper0))))), v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStartedByScionActivityInfo(zzdf zzdf0, long v) {
        this.zzb();
        if(this.zza.zzj().zza != null) {
            this.zza.zzj().zzh();
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStopped(IObjectWrapper iObjectWrapper0, long v) {
        this.zzb();
        this.onActivityStoppedByScionActivityInfo(zzdf.zza(((Activity)Preconditions.checkNotNull(((Activity)ObjectWrapper.unwrap(iObjectWrapper0))))), v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void onActivityStoppedByScionActivityInfo(zzdf zzdf0, long v) {
        this.zzb();
        if(this.zza.zzj().zza != null) {
            this.zza.zzj().zzh();
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void performAction(Bundle bundle0, zzcu zzcu0, long v) {
        this.zzb();
        zzcu0.zzb(null);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void registerOnMeasurementEventListener(zzda zzda0) {
        zzjp zzjp0;
        this.zzb();
        Map map0 = this.zzb;
        synchronized(map0) {
            zzjp0 = (zzjp)map0.get(zzda0.zzf());
            if(zzjp0 == null) {
                zzjp0 = new zzq(this, zzda0);
                map0.put(zzda0.zzf(), zzjp0);
            }
        }
        this.zza.zzj().zzW(zzjp0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void resetAnalyticsData(long v) {
        this.zzb();
        this.zza.zzj().zzT(v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void retrieveAndUploadBatches(zzcx zzcx0) {
        this.zzb();
        this.zza.zzj().zzt(new zzo(this, zzcx0));
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void setConditionalUserProperty(Bundle bundle0, long v) {
        this.zzb();
        if(bundle0 == null) {
            Z.u(this.zza, "Conditional user property must not be null");
            return;
        }
        this.zza.zzj().zzaa(bundle0, v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void setConsent(Bundle bundle0, long v) {
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void setConsentThirdParty(Bundle bundle0, long v) {
        this.zzb();
        this.zza.zzj().zzp(bundle0, -20, v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void setCurrentScreen(IObjectWrapper iObjectWrapper0, String s, String s1, long v) {
        this.zzb();
        this.setCurrentScreenByScionActivityInfo(zzdf.zza(((Activity)Preconditions.checkNotNull(((Activity)ObjectWrapper.unwrap(iObjectWrapper0))))), s, s1, v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void setCurrentScreenByScionActivityInfo(zzdf zzdf0, String s, String s1, long v) {
        this.zzb();
        this.zza.zzs().zzk(zzdf0, s, s1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void setDataCollectionEnabled(boolean z) {
        this.zzb();
        zzli zzli0 = this.zza.zzj();
        zzli0.zzb();
        zzli0.zzu.zzaW().zzj(new zzjx(zzli0, z));
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void setDefaultEventParameters(Bundle bundle0) {
        this.zzb();
        zzli zzli0 = this.zza.zzj();
        Bundle bundle1 = bundle0 == null ? new Bundle() : new Bundle(bundle0);
        zzli0.zzu.zzaW().zzj(new zzle(zzli0, bundle1));
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void setEventInterceptor(zzda zzda0) {
        this.zzb();
        zzp zzp0 = new zzp(this, zzda0);
        if(this.zza.zzaW().zze()) {
            this.zza.zzj().zzV(zzp0);
            return;
        }
        this.zza.zzaW().zzj(new zzl(this, zzp0));
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void setInstanceIdProvider(zzdc zzdc0) {
        this.zzb();
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void setMeasurementEnabled(boolean z, long v) {
        this.zzb();
        this.zza.zzj().zzn(Boolean.valueOf(z));
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void setMinimumSessionDuration(long v) {
        this.zzb();
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void setSessionTimeoutDuration(long v) {
        this.zzb();
        zzli zzli0 = this.zza.zzj();
        zzli0.zzu.zzaW().zzj(new zzjz(zzli0, v));
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void setSgtmDebugInfo(Intent intent0) {
        this.zzb();
        zzli zzli0 = this.zza.zzj();
        Uri uri0 = intent0.getData();
        if(uri0 == null) {
            zzli0.zzu.zzaV().zzi().zza("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String s = uri0.getQueryParameter("sgtm_debug_enable");
        if(s != null && s.equals("1")) {
            String s1 = uri0.getQueryParameter("sgtm_preview_key");
            if(!TextUtils.isEmpty(s1)) {
                zzli0.zzu.zzaV().zzi().zzb("[sgtm] Preview Mode was enabled. Using the sgtmPreviewKey: ", s1);
                zzli0.zzu.zzc().zzy(s1);
            }
            return;
        }
        zzli0.zzu.zzaV().zzi().zza("[sgtm] Preview Mode was not enabled.");
        zzli0.zzu.zzc().zzy(null);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void setUserId(String s, long v) {
        this.zzb();
        zzli zzli0 = this.zza.zzj();
        if(s != null && TextUtils.isEmpty(s)) {
            Z.A(zzli0.zzu, "User ID must be non-empty or null");
            return;
        }
        zzli0.zzu.zzaW().zzj(new zzlf(zzli0, s));
        zzli0.zzL(null, "_id", s, true, v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void setUserProperty(String s, String s1, IObjectWrapper iObjectWrapper0, boolean z, long v) {
        this.zzb();
        Object object0 = ObjectWrapper.unwrap(iObjectWrapper0);
        this.zza.zzj().zzL(s, s1, object0, z, v);
    }

    @Override  // com.google.android.gms.internal.measurement.zzcr
    public void unregisterOnMeasurementEventListener(zzda zzda0) {
        zzjp zzjp0;
        this.zzb();
        synchronized(this.zzb) {
            zzjp0 = (zzjp)this.zzb.remove(zzda0.zzf());
        }
        if(zzjp0 == null) {
            zzjp0 = new zzq(this, zzda0);
        }
        this.zza.zzj().zzX(zzjp0);
    }

    @EnsuresNonNull({"scion"})
    private final void zzb() {
        if(this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void zzc(zzcu zzcu0, String s) {
        this.zzb();
        this.zza.zzk().zzal(zzcu0, s);
    }
}

