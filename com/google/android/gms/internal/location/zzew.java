package com.google.android.gms.internal.location;

import java.util.List;
import javax.annotation.CheckForNull;

final class zzew extends zzex {
    final transient int zza;
    final transient int zzb;
    final zzex zzc;

    public zzew(zzex zzex0, int v, int v1) {
        this.zzc = zzex0;
        super();
        this.zza = v;
        this.zzb = v1;
    }

    @Override
    public final Object get(int v) {
        zzer.zzc(v, this.zzb, "index");
        return this.zzc.get(v + this.zza);
    }

    @Override
    public final int size() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.internal.location.zzex
    public final List subList(int v, int v1) {
        return this.zzh(v, v1);
    }

    @Override  // com.google.android.gms.internal.location.zzeu
    @CheckForNull
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    @Override  // com.google.android.gms.internal.location.zzeu
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override  // com.google.android.gms.internal.location.zzeu
    public final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override  // com.google.android.gms.internal.location.zzeu
    public final boolean zzf() {
        return true;
    }

    @Override  // com.google.android.gms.internal.location.zzex
    public final zzex zzh(int v, int v1) {
        zzer.zze(v, v1, this.zzb);
        return this.zzc.zzh(v + this.zza, v1 + this.zza);
    }
}

