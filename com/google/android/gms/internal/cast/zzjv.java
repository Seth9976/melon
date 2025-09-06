package com.google.android.gms.internal.cast;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;

final class zzjv extends AbstractSet {
    final int zza;
    final zzjw zzb;

    public zzjv(zzjw zzjw0, int v) {
        this.zzb = zzjw0;
        super();
        this.zza = -1;
    }

    @Override
    public final boolean contains(Object object0) {
        int v = this.zzb();
        int v1 = this.zza();
        return Arrays.binarySearch(zzjw.zzc(this.zzb), v, v1, object0, (this.zza == -1 ? zzjw.zza() : zzjy.zzb())) >= 0;
    }

    @Override
    public final Iterator iterator() {
        return new zzju(this);
    }

    @Override
    public final int size() {
        return this.zza() - this.zzb();
    }

    public final int zza() {
        return zzjw.zzb(this.zzb)[this.zza + 1];
    }

    public final int zzb() {
        return this.zza == -1 ? 0 : zzjw.zzb(this.zzb)[0];
    }
}

