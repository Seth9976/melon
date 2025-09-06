package com.google.android.gms.measurement.internal;

final class zzni implements Runnable {
    private final zznk zza;
    private final zzr zzb;
    private final zzaf zzc;

    public zzni(zznk zznk0, zzr zzr0, zzaf zzaf0) {
        this.zza = zznk0;
        this.zzb = zzr0;
        this.zzc = zzaf0;
    }

    @Override
    public final void run() {
        this.zza.zzU(this.zzb, this.zzc);
    }
}

