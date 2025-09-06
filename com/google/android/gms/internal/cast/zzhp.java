package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzhp extends zzhk {
    private final transient zzhj zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    public zzhp(zzhj zzhj0, Object[] arr_object, int v, int v1) {
        this.zza = zzhj0;
        this.zzb = arr_object;
        this.zzc = v1;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final boolean contains(Object object0) {
        if(object0 instanceof Map.Entry) {
            Object object1 = ((Map.Entry)object0).getKey();
            Object object2 = ((Map.Entry)object0).getValue();
            return object2 != null && object2.equals(this.zza.get(object1));
        }
        return false;
    }

    @Override  // com.google.android.gms.internal.cast.zzhk
    public final Iterator iterator() {
        return this.zzd().zzl(0);
    }

    @Override
    public final int size() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final int zza(Object[] arr_object, int v) {
        return this.zzd().zza(arr_object, 0);
    }

    @Override  // com.google.android.gms.internal.cast.zzhk
    public final zzhw zze() {
        return this.zzd().zzl(0);
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final boolean zzf() {
        throw null;
    }

    @Override  // com.google.android.gms.internal.cast.zzhk
    public final zzhg zzi() {
        return new zzho(this);
    }

    public static int zzm(zzhp zzhp0) {
        return zzhp0.zzc;
    }

    public static Object[] zzn(zzhp zzhp0) {
        return zzhp0.zzb;
    }
}

