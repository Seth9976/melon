package com.google.android.gms.measurement.internal;

final class zzjb implements Runnable {
    private final zzjc zza;
    private final zzr zzb;

    public zzjb(zzjc zzjc0, zzr zzr0) {
        this.zza = zzjc0;
        this.zzb = zzr0;
    }

    @Override
    public final void run() {
        this.zza.zzF(this.zzb);
    }
}

