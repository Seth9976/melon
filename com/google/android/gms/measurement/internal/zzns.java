package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfb;
import java.util.Objects;

public final class zzns {
    private final Context zza;

    public zzns(Context context0) {
        Preconditions.checkNotNull(context0);
        this.zza = context0;
    }

    public final void zza() {
        Log.v("FA", this.zza.getClass().getSimpleName() + " is starting up.");
    }

    public final void zzb() {
        Log.v("FA", this.zza.getClass().getSimpleName() + " is shutting down.");
    }

    public final int zzc(Intent intent0, int v, int v1) {
        if(intent0 == null) {
            Log.w("FA", "AppMeasurementService started with null intent");
            return 2;
        }
        Context context0 = this.zza;
        zzgt zzgt0 = zzib.zzy(context0, null, null).zzaV();
        String s = intent0.getAction();
        zzgt0.zzk().zzc("Local AppMeasurementService called. startId, action", v1, s);
        if("com.google.android.gms.measurement.UPLOAD".equals(s)) {
            zznr zznr0 = () -> {
                Context context0 = this.zza;
                if(((zzno)context0).zza(v1)) {
                    zzgt0.zzk().zzb("Local AppMeasurementService processed last upload request. StartId", v1);
                    zzib.zzy(context0, null, null).zzaV().zzk().zza("Completed wakeful intent.");
                    ((zzno)context0).zzc(intent0);
                }
            };
            this.zzk(zzpf.zza(context0), zznr0);
        }
        return 2;
    }

    public final IBinder zzd(Intent intent0) {
        if(intent0 == null) {
            Log.e("FA", "onBind called with null intent");
            return null;
        }
        String s = intent0.getAction();
        if("com.google.android.gms.measurement.START".equals(s)) {
            return new zzjc(zzpf.zza(this.zza), null);
        }
        Log.w("FA", "onBind received unknown action: " + s);
        return null;
    }

    @TargetApi(24)
    public final boolean zze(JobParameters jobParameters0) {
        String s = jobParameters0.getExtras().getString("action");
        Log.v("FA", "onStartJob received action: " + s);
        if(Objects.equals(s, "com.google.android.gms.measurement.UPLOAD")) {
            String s1 = (String)Preconditions.checkNotNull(s);
            zzpf zzpf0 = zzpf.zza(this.zza);
            zzgt zzgt0 = zzpf0.zzaV();
            zzgt0.zzk().zzb("Local AppMeasurementJobService called. action", s1);
            this.zzk(zzpf0, () -> {
                zzgt0.zzk().zza("AppMeasurementJobService processed last upload request.");
                ((zzno)this.zza).zzb(jobParameters0, false);
            });
        }
        if(Objects.equals(s, "com.google.android.gms.measurement.SCION_UPLOAD")) {
            String s2 = (String)Preconditions.checkNotNull(s);
            zzfb.zza(this.zza, null).zzw(() -> {
                Log.v("FA", "[sgtm] AppMeasurementJobService processed last Scion upload request.");
                ((zzno)this.zza).zzb(jobParameters0, false);
            });
        }
        return true;
    }

    // 检测为 Lambda 实现
    public final void zzf(int v, zzgt zzgt0, Intent intent0) [...]

    // 检测为 Lambda 实现
    public final void zzg(zzgt zzgt0, JobParameters jobParameters0) [...]

    // 检测为 Lambda 实现
    public final void zzh(JobParameters jobParameters0) [...]

    public static final void zzi(Intent intent0) {
        if(intent0 == null) {
            Log.e("FA", "onRebind called with null intent");
            return;
        }
        Log.v("FA", "onRebind called. action: " + intent0.getAction());
    }

    public static final boolean zzj(Intent intent0) {
        if(intent0 == null) {
            Log.e("FA", "onUnbind called with null intent");
            return true;
        }
        Log.v("FA", "onUnbind called for intent. action: " + intent0.getAction());
        return true;
    }

    private final void zzk(zzpf zzpf0, Runnable runnable0) {
        zzpf0.zzaW().zzj(new zznn(this, zzpf0, runnable0));
    }
}

