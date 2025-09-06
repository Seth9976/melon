package com.google.android.gms.internal.play_billing;

import java.util.NoSuchElementException;

final class zzbg extends zzbi {
    final zzbq zza;
    private int zzb;
    private final int zzc;

    public zzbg(zzbq zzbq0) {
        this.zza = zzbq0;
        super();
        this.zzb = 0;
        this.zzc = zzbq0.zzd();
    }

    @Override
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbk
    public final byte zza() {
        int v = this.zzb;
        if(v >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = v + 1;
        return this.zza.zzb(v);
    }
}

