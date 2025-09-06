package com.google.android.gms.internal.measurement;

import java.util.Map.Entry;
import java.util.Objects;
import k8.Y;

final class zzoa implements Comparable, Map.Entry {
    final zzod zza;
    private final Comparable zzb;
    private Object zzc;

    public zzoa(zzod zzod0, Comparable comparable0, Object object0) {
        Objects.requireNonNull(zzod0);
        this.zza = zzod0;
        super();
        this.zzb = comparable0;
        this.zzc = object0;
    }

    @Override
    public final int compareTo(Object object0) {
        return this.zzb.compareTo(((zzoa)object0).zzb);
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof Map.Entry)) {
            return false;
        }
        Object object1 = ((Map.Entry)object0).getKey();
        return zzoa.zzb(this.zzb, object1) && zzoa.zzb(this.zzc, ((Map.Entry)object0).getValue());
    }

    @Override
    public final Object getKey() {
        return this.zzb;
    }

    @Override
    public final Object getValue() {
        return this.zzc;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.zzb == null ? 0 : this.zzb.hashCode();
        Object object0 = this.zzc;
        if(object0 != null) {
            v = object0.hashCode();
        }
        return v1 ^ v;
    }

    @Override
    public final Object setValue(Object object0) {
        this.zza.zzh();
        Object object1 = this.zzc;
        this.zzc = object0;
        return object1;
    }

    @Override
    public final String toString() {
        String s = String.valueOf(this.zzb);
        String s1 = String.valueOf(this.zzc);
        return Y.l(new StringBuilder(s.length() + 1 + s1.length()), s, "=", s1);
    }

    public final Comparable zza() {
        return this.zzb;
    }

    private static final boolean zzb(Object object0, Object object1) {
        return object0 == null ? object1 == null : object0.equals(object1);
    }
}

