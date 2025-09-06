package com.google.android.gms.cast.internal;

final class zzs implements Runnable {
    final zzx zza;
    final int zzb;

    public zzs(zzw zzw0, zzx zzx0, int v) {
        this.zza = zzx0;
        this.zzb = v;
        super();
    }

    @Override
    public final void run() {
        zzx.zzu(this.zza).onApplicationDisconnected(this.zzb);
    }
}

