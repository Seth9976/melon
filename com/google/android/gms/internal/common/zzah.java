package com.google.android.gms.internal.common;

import java.util.List;

final class zzah extends zzaj {
    private final transient zzaj zza;

    public zzah(zzaj zzaj0) {
        this.zza = zzaj0;
    }

    @Override  // com.google.android.gms.internal.common.zzaj
    public final boolean contains(Object object0) {
        return this.zza.contains(object0);
    }

    @Override
    public final Object get(int v) {
        zzt.zzb(v, this.zza.size(), "index");
        int v1 = this.zzs(v);
        return this.zza.get(v1);
    }

    @Override  // com.google.android.gms.internal.common.zzaj
    public final int indexOf(Object object0) {
        int v = this.zza.lastIndexOf(object0);
        return v < 0 ? -1 : this.zzs(v);
    }

    @Override  // com.google.android.gms.internal.common.zzaj
    public final int lastIndexOf(Object object0) {
        int v = this.zza.indexOf(object0);
        return v < 0 ? -1 : this.zzs(v);
    }

    @Override
    public final int size() {
        return this.zza.size();
    }

    @Override  // com.google.android.gms.internal.common.zzaj
    public final List subList(int v, int v1) {
        return this.zzi(v, v1);
    }

    @Override  // com.google.android.gms.internal.common.zzae
    public final boolean zzf() {
        return this.zza.zzf();
    }

    @Override  // com.google.android.gms.internal.common.zzaj
    public final zzaj zzh() {
        return this.zza;
    }

    @Override  // com.google.android.gms.internal.common.zzaj
    public final zzaj zzi(int v, int v1) {
        zzt.zzd(v, v1, this.zza.size());
        return this.zza.zzi(this.zza.size() - v1, this.zza.size() - v).zzh();
    }

    private final int zzs(int v) {
        return this.zza.size() - 1 - v;
    }
}

