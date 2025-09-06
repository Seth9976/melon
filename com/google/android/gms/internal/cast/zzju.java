package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzju implements Iterator {
    final zzjv zza;
    private int zzb;

    public zzju(zzjv zzjv0) {
        this.zza = zzjv0;
        super();
        this.zzb = 0;
    }

    @Override
    public final boolean hasNext() {
        return this.zzb < this.zza.zza() - this.zza.zzb();
    }

    @Override
    public final Object next() {
        int v = this.zzb;
        zzjv zzjv0 = this.zza;
        if(v >= zzjv0.zza() - zzjv0.zzb()) {
            throw new NoSuchElementException();
        }
        int v1 = zzjv0.zzb();
        this.zzb = v + 1;
        return zzjw.zzc(zzjv0.zzb)[v1 + v];
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

