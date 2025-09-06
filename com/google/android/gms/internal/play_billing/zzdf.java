package com.google.android.gms.internal.play_billing;

import java.util.Map.Entry;

final class zzdf implements Map.Entry {
    private final Map.Entry zza;

    public zzdf(Map.Entry map$Entry0, zzde zzde0) {
        this.zza = map$Entry0;
    }

    @Override
    public final Object getKey() {
        return this.zza.getKey();
    }

    @Override
    public final Object getValue() {
        if(((zzdh)this.zza.getValue()) != null) {
            throw null;
        }
        return null;
    }

    @Override
    public final Object setValue(Object object0) {
        if(!(object0 instanceof zzec)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return ((zzdh)this.zza.getValue()).zzc(((zzec)object0));
    }

    public final zzdh zza() {
        return (zzdh)this.zza.getValue();
    }
}

