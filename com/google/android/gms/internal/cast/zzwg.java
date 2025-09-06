package com.google.android.gms.internal.cast;

import java.util.NoSuchElementException;

final class zzwg extends zzwh {
    final zzwn zza;
    private int zzb;
    private final int zzc;

    public zzwg(zzwn zzwn0) {
        this.zza = zzwn0;
        super();
        this.zzb = 0;
        this.zzc = zzwn0.zzd();
    }

    @Override
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override  // com.google.android.gms.internal.cast.zzwj
    public final byte zza() {
        int v = this.zzb;
        if(v >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = v + 1;
        return this.zza.zzb(v);
    }
}

