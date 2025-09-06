package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

final class zzar implements Iterator {
    final zzas zza;
    private int zzb;

    public zzar(zzas zzas0) {
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
        zzas zzas0 = this.zza;
        int v = this.zzb;
        if(v >= zzas0.zzb().length()) {
            throw new NoSuchElementException();
        }
        this.zzb = v + 1;
        return new zzas(String.valueOf(zzas0.zzb().charAt(v)));
    }
}

