package com.google.android.gms.internal.cast;

import java.util.NoSuchElementException;

final class zzhl extends zzhw {
    private final Object zza;
    private boolean zzb;

    public zzhl(Object object0) {
        this.zza = object0;
    }

    @Override
    public final boolean hasNext() {
        return !this.zzb;
    }

    @Override
    public final Object next() {
        if(this.zzb) {
            throw new NoSuchElementException();
        }
        this.zzb = true;
        return this.zza;
    }
}

