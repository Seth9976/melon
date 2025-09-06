package com.google.android.gms.measurement.internal;

import java.util.Iterator;
import java.util.Objects;

final class zzbd implements Iterator {
    final Iterator zza;
    final zzbe zzb;

    public zzbd(zzbe zzbe0) {
        Objects.requireNonNull(zzbe0);
        this.zzb = zzbe0;
        super();
        this.zza = zzbe0.zzg().keySet().iterator();
    }

    @Override
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override
    public final Object next() {
        return this.zza();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    public final String zza() {
        return this.zza.next();
    }
}

