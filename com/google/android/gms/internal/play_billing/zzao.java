package com.google.android.gms.internal.play_billing;

import java.util.Objects;

final class zzao extends zzai {
    static final zzai zza;
    final transient Object[] zzb;
    private final transient int zzc;

    static {
        zzao.zza = new zzao(new Object[0], 0);
    }

    public zzao(Object[] arr_object, int v) {
        this.zzb = arr_object;
        this.zzc = v;
    }

    @Override
    public final Object get(int v) {
        zzaa.zza(v, this.zzc, "index");
        Object object0 = this.zzb[v];
        Objects.requireNonNull(object0);
        return object0;
    }

    @Override
    public final int size() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzai
    public final int zza(Object[] arr_object, int v) {
        System.arraycopy(this.zzb, 0, arr_object, 0, this.zzc);
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public final int zzb() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public final int zzc() {
        return 0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public final boolean zzf() {
        return false;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public final Object[] zzg() {
        return this.zzb;
    }
}

