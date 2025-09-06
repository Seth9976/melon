package com.google.android.gms.internal.cast;

import l4.G;

public final class zzbd implements Runnable {
    public final zzbf zza;
    public final G zzb;

    public zzbd(zzbf zzbf0, G g0) {
        this.zza = zzbf0;
        this.zzb = g0;
    }

    @Override
    public final void run() {
        zzbf.zzq(this.zza, this.zzb);
    }
}

