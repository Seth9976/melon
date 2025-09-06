package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzno;
import com.google.android.gms.measurement.internal.zzns;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements zzno {
    private zzns zza;

    @Override  // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.zzd().zza();
    }

    @Override  // android.app.Service
    public void onDestroy() {
        this.zzd().zzb();
        super.onDestroy();
    }

    @Override  // android.app.Service
    public void onRebind(Intent intent0) {
        this.zzd();
        zzns.zzi(intent0);
    }

    @Override  // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters0) {
        this.zzd().zze(jobParameters0);
        return true;
    }

    @Override  // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters0) {
        return false;
    }

    @Override  // android.app.Service
    public boolean onUnbind(Intent intent0) {
        this.zzd();
        zzns.zzj(intent0);
        return true;
    }

    @Override  // com.google.android.gms.measurement.internal.zzno
    public final boolean zza(int v) {
        throw new UnsupportedOperationException();
    }

    @Override  // com.google.android.gms.measurement.internal.zzno
    @TargetApi(24)
    public final void zzb(JobParameters jobParameters0, boolean z) {
        this.jobFinished(jobParameters0, false);
    }

    @Override  // com.google.android.gms.measurement.internal.zzno
    public final void zzc(Intent intent0) {
    }

    private final zzns zzd() {
        if(this.zza == null) {
            this.zza = new zzns(this);
        }
        return this.zza;
    }
}

