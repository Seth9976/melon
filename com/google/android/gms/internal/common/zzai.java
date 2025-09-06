package com.google.android.gms.internal.common;

import java.util.List;
import java.util.Objects;

final class zzai extends zzaj {
    final transient int zza;
    final transient int zzb;
    final zzaj zzc;

    public zzai(zzaj zzaj0, int v, int v1) {
        Objects.requireNonNull(zzaj0);
        this.zzc = zzaj0;
        super();
        this.zza = v;
        this.zzb = v1;
    }

    @Override
    public final Object get(int v) {
        zzt.zzb(v, this.zzb, "index");
        return this.zzc.get(v + this.zza);
    }

    @Override
    public final int size() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.internal.common.zzaj
    public final List subList(int v, int v1) {
        return this.zzi(v, v1);
    }

    @Override  // com.google.android.gms.internal.common.zzae
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    @Override  // com.google.android.gms.internal.common.zzae
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override  // com.google.android.gms.internal.common.zzae
    public final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override  // com.google.android.gms.internal.common.zzae
    public final boolean zzf() {
        return true;
    }

    @Override  // com.google.android.gms.internal.common.zzaj
    public final zzaj zzi(int v, int v1) {
        zzt.zzd(v, v1, this.zzb);
        return this.zzc.zzi(v + this.zza, v1 + this.zza);
    }
}

