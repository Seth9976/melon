package com.google.android.gms.internal.location;

import java.util.Objects;

final class zzey extends zzex {
    static final zzex zza;
    final transient Object[] zzb;
    private final transient int zzc;

    static {
        zzey.zza = new zzey(new Object[0], 0);
    }

    public zzey(Object[] arr_object, int v) {
        this.zzb = arr_object;
        this.zzc = v;
    }

    @Override
    public final Object get(int v) {
        zzer.zzc(v, this.zzc, "index");
        Object object0 = this.zzb[v];
        Objects.requireNonNull(object0);
        return object0;
    }

    @Override
    public final int size() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.location.zzeu
    public final Object[] zzb() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.internal.location.zzeu
    public final int zzc() {
        return 0;
    }

    @Override  // com.google.android.gms.internal.location.zzeu
    public final int zzd() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.location.zzeu
    public final boolean zzf() {
        return false;
    }

    @Override  // com.google.android.gms.internal.location.zzex
    public final int zzg(Object[] arr_object, int v) {
        System.arraycopy(this.zzb, 0, arr_object, 0, this.zzc);
        return this.zzc;
    }
}

