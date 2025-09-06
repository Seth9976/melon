package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

final class zzaq implements Iterator {
    final zzas zza;
    private int zzb;

    public zzaq(zzas zzas0) {
        Objects.requireNonNull(zzas0);
        this.zza = zzas0;
        super();
        this.zzb = 0;
    }

    @Override
    public final boolean hasNext() {
        return this.zzb < this.zza.zzb().length();
    }

    @Override
    public final Object next() {
        int v = this.zzb;
        if(v >= this.zza.zzb().length()) {
            throw new NoSuchElementException();
        }
        this.zzb = v + 1;
        return new zzas(String.valueOf(v));
    }
}

