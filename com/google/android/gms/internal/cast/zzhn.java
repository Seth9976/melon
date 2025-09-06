package com.google.android.gms.internal.cast;

import java.util.Objects;

final class zzhn extends zzhg {
    static final zzhg zza;
    final transient Object[] zzb;
    private final transient int zzc;

    static {
        zzhn.zza = new zzhn(new Object[0], 0);
    }

    public zzhn(Object[] arr_object, int v) {
        this.zzb = arr_object;
        this.zzc = v;
    }

    @Override
    public final Object get(int v) {
        zzgo.zza(v, this.zzc, "index");
        Object object0 = this.zzb[v];
        Objects.requireNonNull(object0);
        return object0;
    }

    @Override
    public final int size() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.cast.zzhg
    public final int zza(Object[] arr_object, int v) {
        System.arraycopy(this.zzb, 0, arr_object, 0, this.zzc);
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final int zzb() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final int zzc() {
        return 0;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final boolean zzf() {
        return false;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final Object[] zzg() {
        return this.zzb;
    }
}

