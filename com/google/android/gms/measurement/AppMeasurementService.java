package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzno;
import com.google.android.gms.measurement.internal.zzns;

public final class AppMeasurementService extends Service implements zzno {
    private zzns zza;

    @Override  // android.app.Service
    public IBinder onBind(Intent intent0) {
        return this.zzd().zzd(intent0);
    }

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

    @Override  // android.app.Service
    public int onStartCommand(Intent intent0, int v, int v1) {
        this.zzd().zzc(intent0, v, v1);
        return 2;
    }

    @Override  // android.app.Service
    public boolean onUnbind(Intent intent0) {
        this.zzd();
        zzns.zzj(intent0);
        return true;
    }

    @Override  // com.google.android.gms.measurement.internal.zzno
    public final boolean zza(int v) {
        return this.stopSelfResult(v);
    }

    @Override  // com.google.android.gms.measurement.internal.zzno
    public final void zzb(JobParameters jobParameters0, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override  // com.google.android.gms.measurement.internal.zzno
    public final void zzc(Intent intent0) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent0);
    }

    private final zzns zzd() {
        if(this.zza == null) {
            this.zza = new zzns(this);
        }
        return this.zza;
    }
}

