package com.google.android.gms.internal.cast;

import l4.G;

public final class zzbe implements Runnable {
    public final zzbf zza;
    public final G zzb;
    public final int zzc;

    public zzbe(zzbf zzbf0, G g0, int v) {
        this.zza = zzbf0;
        this.zzb = g0;
        this.zzc = v;
    }

    @Override
    public final void run() {
        zzbf.zzo(this.zza, this.zzb, this.zzc);
    }
}

