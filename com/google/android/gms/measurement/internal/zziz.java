package com.google.android.gms.measurement.internal;

final class zziz implements Runnable {
    private final zzjc zza;
    private final zzr zzb;
    private final zzaf zzc;

    public zziz(zzjc zzjc0, zzr zzr0, zzaf zzaf0) {
        this.zza = zzjc0;
        this.zzb = zzr0;
        this.zzc = zzaf0;
    }

    @Override
    public final void run() {
        this.zza.zzJ(this.zzb, this.zzc);
    }
}

