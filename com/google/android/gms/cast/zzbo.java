package com.google.android.gms.cast;

public final class zzbo implements Runnable {
    public final zzbq zza;
    public final int zzb;

    public zzbo(zzbq zzbq0, int v) {
        this.zza = zzbq0;
        this.zzb = v;
    }

    @Override
    public final void run() {
        zzbr.zzp(this.zza.zza).onApplicationDisconnected(this.zzb);
    }
}

