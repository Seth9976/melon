package com.google.android.gms.internal.cast;

public final class zzgb implements Runnable {
    public final zzgc zza;

    public zzgb(zzgc zzgc0) {
        this.zza = zzgc0;
    }

    @Override
    public final void run() {
        this.zza.zza(System.nanoTime());
    }
}

