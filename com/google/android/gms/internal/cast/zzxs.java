package com.google.android.gms.internal.cast;

import java.util.Map.Entry;

final class zzxs implements Map.Entry {
    private final Map.Entry zza;

    public zzxs(Map.Entry map$Entry0, zzxu zzxu0) {
        this.zza = map$Entry0;
    }

    @Override
    public final Object getKey() {
        return this.zza.getKey();
    }

    @Override
    public final Object getValue() {
        if(((zzxv)this.zza.getValue()) != null) {
            throw null;
        }
        return null;
    }

    @Override
    public final Object setValue(Object object0) {
        if(!(object0 instanceof zzyl)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return ((zzxv)this.zza.getValue()).zzc(((zzyl)object0));
    }

    public final zzxv zza() {
        return (zzxv)this.zza.getValue();
    }
}

