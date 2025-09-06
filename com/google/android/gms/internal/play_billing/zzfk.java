package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
public final class zzfk extends AbstractList implements zzdk, RandomAccess {
    private final zzdk zza;

    public zzfk(zzdk zzdk0) {
        this.zza = zzdk0;
    }

    @Override
    public final Object get(int v) {
        return ((zzdj)this.zza).zzg(v);
    }

    @Override
    public final Iterator iterator() {
        return new zzfj(this);
    }

    @Override
    public final ListIterator listIterator(int v) {
        return new zzfi(this, v);
    }

    @Override
    public final int size() {
        return this.zza.size();
    }

    public static zzdk zza(zzfk zzfk0) {
        return zzfk0.zza;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdk
    public final zzdk zze() {
        return this;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdk
    public final Object zzf(int v) {
        return this.zza.zzf(v);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdk
    public final List zzh() {
        return this.zza.zzh();
    }
}

