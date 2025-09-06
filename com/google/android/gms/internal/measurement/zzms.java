package com.google.android.gms.internal.measurement;

import java.util.Map.Entry;

final class zzms implements Map.Entry {
    private final Map.Entry zza;

    public zzms(Map.Entry map$Entry0, byte[] arr_b) {
        this.zza = map$Entry0;
    }

    @Override
    public final Object getKey() {
        return this.zza.getKey();
    }

    @Override
    public final Object getValue() {
        if(((zzmu)this.zza.getValue()) != null) {
            throw null;
        }
        return null;
    }

    @Override
    public final Object setValue(Object object0) {
        if(!(object0 instanceof zznl)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return ((zzmu)this.zza.getValue()).zza(((zznl)object0));
    }

    public final zzmu zza() {
        return (zzmu)this.zza.getValue();
    }
}

