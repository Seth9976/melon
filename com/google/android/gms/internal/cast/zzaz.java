package com.google.android.gms.internal.cast;

import l4.O;
import w1.j;
import w1.k;

public final class zzaz implements k {
    public final zzbb zza;
    public final O zzb;
    public final O zzc;

    public zzaz(zzbb zzbb0, O o0, O o1) {
        this.zza = zzbb0;
        this.zzb = o0;
        this.zzc = o1;
    }

    @Override  // w1.k
    public final Object attachCompleter(j j0) {
        return zzbb.zza(this.zza, this.zzb, this.zzc, j0);
    }
}

