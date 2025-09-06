package com.google.android.gms.internal.cast;

import java.util.Iterator;

final class zzht extends zzhk {
    static final zzht zza;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private static final Object[] zzd;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] arr_object = new Object[0];
        zzht.zzd = arr_object;
        zzht.zza = new zzht(arr_object, 0, arr_object, 0, 0);
    }

    public zzht(Object[] arr_object, int v, Object[] arr_object1, int v1, int v2) {
        this.zzb = arr_object;
        this.zze = v;
        this.zzc = arr_object1;
        this.zzf = v1;
        this.zzg = v2;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final boolean contains(Object object0) {
        if(object0 != null) {
            Object[] arr_object = this.zzc;
            if(arr_object.length != 0) {
                for(int v = zzgz.zza(object0.hashCode()); true; v = v1 + 1) {
                    int v1 = v & this.zzf;
                    Object object1 = arr_object[v1];
                    if(object1 == null) {
                        return false;
                    }
                    if(object1.equals(object0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override  // com.google.android.gms.internal.cast.zzhk
    public final int hashCode() {
        return this.zze;
    }

    @Override  // com.google.android.gms.internal.cast.zzhk
    public final Iterator iterator() {
        return this.zzd().zzl(0);
    }

    @Override
    public final int size() {
        return this.zzg;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final int zza(Object[] arr_object, int v) {
        System.arraycopy(this.zzb, 0, arr_object, 0, this.zzg);
        return this.zzg;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final int zzb() {
        return this.zzg;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final int zzc() {
        return 0;
    }

    @Override  // com.google.android.gms.internal.cast.zzhk
    public final zzhw zze() {
        return this.zzd().zzl(0);
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final boolean zzf() {
        throw null;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final Object[] zzg() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzhk
    public final zzhg zzi() {
        return zzhg.zzi(this.zzb, this.zzg);
    }

    @Override  // com.google.android.gms.internal.cast.zzhk
    public final boolean zzl() {
        return true;
    }
}

