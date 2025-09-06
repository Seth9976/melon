package com.google.android.gms.internal.measurement;

import java.util.Iterator;

final class zzaj implements Iterator {
    final Iterator zza;

    public zzaj(Iterator iterator0) {
        this.zza = iterator0;
        super();
    }

    @Override
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override
    public final Object next() {
        Object object0 = this.zza.next();
        return new zzas(((String)object0));
    }
}

