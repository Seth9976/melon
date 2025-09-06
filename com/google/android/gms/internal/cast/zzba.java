package com.google.android.gms.internal.cast;

import l4.O;
import w1.j;

public final class zzba implements Runnable {
    public final zzbb zza;
    public final O zzb;
    public final O zzc;
    public final j zzd;

    public zzba(zzbb zzbb0, O o0, O o1, j j0) {
        this.zza = zzbb0;
        this.zzb = o0;
        this.zzc = o1;
        this.zzd = j0;
    }

    @Override
    public final void run() {
        zzbb.zzb(this.zza, this.zzb, this.zzc, this.zzd);
    }
}

