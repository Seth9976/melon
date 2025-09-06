package com.google.android.gms.measurement.internal;

final class zziw implements Runnable {
    private final zzjc zza;
    private final zzr zzb;

    public zziw(zzjc zzjc0, zzr zzr0) {
        this.zza = zzjc0;
        this.zzb = zzr0;
    }

    @Override
    public final void run() {
        this.zza.zzG(this.zzb);
    }
}

