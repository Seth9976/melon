package com.google.android.gms.internal.common;

import java.util.Objects;

final class zzal extends zzaj {
    static final zzaj zza;
    final transient Object[] zzb;
    private final transient int zzc;

    static {
        zzal.zza = new zzal(new Object[0], 0);
    }

    public zzal(Object[] arr_object, int v) {
        this.zzb = arr_object;
        this.zzc = v;
    }

    @Override
    public final Object get(int v) {
        zzt.zzb(v, this.zzc, "index");
        Object object0 = this.zzb[v];
        Objects.requireNonNull(object0);
        return object0;
    }

    @Override
    public final int size() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.common.zzae
    public final Object[] zzb() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.internal.common.zzae
    public final int zzc() {
        return 0;
    }

    @Override  // com.google.android.gms.internal.common.zzae
    public final int zzd() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.common.zzae
    public final boolean zzf() {
        return false;
    }

    @Override  // com.google.android.gms.internal.common.zzaj
    public final int zzg(Object[] arr_object, int v) {
        System.arraycopy(this.zzb, 0, arr_object, 0, this.zzc);
        return this.zzc;
    }
}

