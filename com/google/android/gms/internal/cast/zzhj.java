package com.google.android.gms.internal.cast;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public abstract class zzhj implements Serializable, Map {
    private transient zzhk zza;
    private transient zzhk zzb;
    private transient zzhc zzc;

    @Override
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean containsKey(Object object0) {
        return this.get(object0) != null;
    }

    @Override
    public final boolean containsValue(Object object0) {
        return this.zzb().contains(object0);
    }

    @Override
    public final Set entrySet() {
        return this.zzg();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Map ? this.entrySet().equals(((Map)object0).entrySet()) : false;
    }

    @Override
    public abstract Object get(Object arg1);

    @Override
    public final Object getOrDefault(Object object0, Object object1) {
        Object object2 = this.get(object0);
        return object2 == null ? object1 : object2;
    }

    @Override
    public final int hashCode() {
        return zzhu.zza(this.zzg());
    }

    @Override
    public final boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public final Set keySet() {
        zzhk zzhk0 = this.zzb;
        if(zzhk0 == null) {
            zzhk0 = this.zzf();
            this.zzb = zzhk0;
        }
        return zzhk0;
    }

    @Override
    @Deprecated
    public final Object put(Object object0, Object object1) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final void putAll(Map map0) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final Object remove(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final String toString() {
        int v = this.size();
        if(v < 0) {
            throw new IllegalArgumentException("size cannot be negative but was: " + v);
        }
        StringBuilder stringBuilder0 = new StringBuilder(((int)Math.min(((long)v) * 8L, 0x40000000L)));
        stringBuilder0.append('{');
        boolean z = true;
        for(Object object0: this.entrySet()) {
            if(!z) {
                stringBuilder0.append(", ");
            }
            stringBuilder0.append(((Map.Entry)object0).getKey());
            stringBuilder0.append('=');
            stringBuilder0.append(((Map.Entry)object0).getValue());
            z = false;
        }
        stringBuilder0.append('}');
        return stringBuilder0.toString();
    }

    @Override
    public final Collection values() {
        return this.zzb();
    }

    public abstract zzhc zza();

    public final zzhc zzb() {
        zzhc zzhc0 = this.zzc;
        if(zzhc0 == null) {
            zzhc0 = this.zza();
            this.zzc = zzhc0;
        }
        return zzhc0;
    }

    public static zzhj zzc(Iterable iterable0) {
        zzhi zzhi0 = new zzhi((iterable0 instanceof Collection ? ((Collection)iterable0).size() : 4));
        zzhi0.zza(iterable0);
        zzhh zzhh0 = zzhi0.zzc;
        if(zzhh0 != null) {
            throw zzhh0.zza();
        }
        zzhj zzhj0 = zzhs.zzh(zzhi0.zzb, zzhi0.zza, zzhi0);
        zzhh zzhh1 = zzhi0.zzc;
        if(zzhh1 != null) {
            throw zzhh1.zza();
        }
        return zzhj0;
    }

    public static zzhj zzd() {
        return zzhs.zza;
    }

    public abstract zzhk zze();

    public abstract zzhk zzf();

    public final zzhk zzg() {
        zzhk zzhk0 = this.zza;
        if(zzhk0 == null) {
            zzhk0 = this.zze();
            this.zza = zzhk0;
        }
        return zzhk0;
    }
}

