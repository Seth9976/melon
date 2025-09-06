package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

final class zzfj implements Iterator {
    final Iterator zza;
    final zzfk zzb;

    public zzfj(zzfk zzfk0) {
        this.zzb = zzfk0;
        super();
        this.zza = zzfk.zza(zzfk0).iterator();
    }

    @Override
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override
    public final Object next() {
        return this.zza.next();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

