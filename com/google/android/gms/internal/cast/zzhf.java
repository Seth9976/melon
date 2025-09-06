package com.google.android.gms.internal.cast;

import java.util.List;

final class zzhf extends zzhg {
    final transient int zza;
    final transient int zzb;
    final zzhg zzc;

    public zzhf(zzhg zzhg0, int v, int v1) {
        this.zzc = zzhg0;
        super();
        this.zza = v;
        this.zzb = v1;
    }

    @Override
    public final Object get(int v) {
        zzgo.zza(v, this.zzb, "index");
        return this.zzc.get(v + this.zza);
    }

    @Override
    public final int size() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzhg
    public final List subList(int v, int v1) {
        return this.zzh(v, v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final boolean zzf() {
        return true;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override  // com.google.android.gms.internal.cast.zzhg
    public final zzhg zzh(int v, int v1) {
        zzgo.zzd(v, v1, this.zzb);
        return this.zzc.zzh(v + this.zza, v1 + this.zza);
    }
}

