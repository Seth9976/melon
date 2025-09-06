package com.google.android.gms.internal.play_billing;

import java.util.Objects;

final class zzas extends zzai {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    public zzas(Object[] arr_object, int v, int v1) {
        this.zza = arr_object;
        this.zzb = v;
        this.zzc = v1;
    }

    @Override
    public final Object get(int v) {
        zzaa.zza(v, this.zzc, "index");
        Object object0 = this.zza[v + v + this.zzb];
        Objects.requireNonNull(object0);
        return object0;
    }

    @Override
    public final int size() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public final boolean zzf() {
        return true;
    }
}

