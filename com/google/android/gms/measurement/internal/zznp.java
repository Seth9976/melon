package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

final class zznp implements Runnable {
    private final zzns zza;
    private final zzgt zzb;
    private final JobParameters zzc;

    public zznp(zzns zzns0, zzgt zzgt0, JobParameters jobParameters0) {
        this.zza = zzns0;
        this.zzb = zzgt0;
        this.zzc = jobParameters0;
    }

    @Override
    public final void run() {
        this.zza.zzg(this.zzb, this.zzc);
    }
}

