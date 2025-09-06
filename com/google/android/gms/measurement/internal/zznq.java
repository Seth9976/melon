package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

final class zznq implements Runnable {
    private final zzns zza;
    private final JobParameters zzb;

    public zznq(zzns zzns0, JobParameters jobParameters0) {
        this.zza = zzns0;
        this.zzb = jobParameters0;
    }

    @Override
    public final void run() {
        this.zza.zzh(this.zzb);
    }
}

