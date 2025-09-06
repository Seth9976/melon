package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzxt implements Iterator {
    private final Iterator zza;

    public zzxt(Iterator iterator0) {
        this.zza = iterator0;
    }

    @Override
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override
    public final Object next() {
        Object object0 = this.zza.next();
        return ((Map.Entry)object0).getValue() instanceof zzxv ? new zzxs(((Map.Entry)object0), null) : ((Map.Entry)object0);
    }

    @Override
    public final void remove() {
        this.zza.remove();
    }
}

