package com.google.android.gms.internal.cast;

import U4.x;
import java.util.Iterator;

final class zzhv extends zzhk {
    final transient Object zza;

    public zzhv(Object object0) {
        object0.getClass();
        this.zza = object0;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final boolean contains(Object object0) {
        return this.zza.equals(object0);
    }

    @Override  // com.google.android.gms.internal.cast.zzhk
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override  // com.google.android.gms.internal.cast.zzhk
    public final Iterator iterator() {
        return new zzhl(this.zza);
    }

    @Override
    public final int size() {
        return 1;
    }

    @Override
    public final String toString() {
        return x.k("[", this.zza.toString(), "]");
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final int zza(Object[] arr_object, int v) {
        arr_object[0] = this.zza;
        return 1;
    }

    @Override  // com.google.android.gms.internal.cast.zzhk
    public final zzhg zzd() {
        Object[] arr_object = {this.zza};
        zzhm.zzb(arr_object, 1);
        return zzhg.zzi(arr_object, 1);
    }

    @Override  // com.google.android.gms.internal.cast.zzhk
    public final zzhw zze() {
        return new zzhl(this.zza);
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final boolean zzf() {
        throw null;
    }
}

