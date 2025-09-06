package com.google.android.gms.internal.cast;

import java.util.Iterator;

final class zzhq extends zzhk {
    private final transient zzhj zza;
    private final transient zzhg zzb;

    public zzhq(zzhj zzhj0, zzhg zzhg0) {
        this.zza = zzhj0;
        this.zzb = zzhg0;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final boolean contains(Object object0) {
        return this.zza.get(object0) != null;
    }

    @Override  // com.google.android.gms.internal.cast.zzhk
    public final Iterator iterator() {
        return this.zzb.zzl(0);
    }

    @Override
    public final int size() {
        return this.zza.size();
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final int zza(Object[] arr_object, int v) {
        return this.zzb.zza(arr_object, 0);
    }

    @Override  // com.google.android.gms.internal.cast.zzhk
    public final zzhg zzd() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzhk
    public final zzhw zze() {
        return this.zzb.zzl(0);
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final boolean zzf() {
        throw null;
    }
}

