package com.google.android.gms.internal.measurement;

import com.iloen.melon.utils.a;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

final class zzad implements Iterator {
    final zzae zza;
    private int zzb;

    public zzad(zzae zzae0) {
        Objects.requireNonNull(zzae0);
        this.zza = zzae0;
        super();
        this.zzb = 0;
    }

    @Override
    public final boolean hasNext() {
        return this.zzb < this.zza.zzh();
    }

    @Override
    public final Object next() {
        zzae zzae0 = this.zza;
        if(this.zzb >= zzae0.zzh()) {
            throw new NoSuchElementException(a.k(this.zzb, "Out of bounds index: ", new StringBuilder(String.valueOf(this.zzb).length() + 21)));
        }
        int v = this.zzb;
        this.zzb = v + 1;
        return zzae0.zzl(v);
    }
}

