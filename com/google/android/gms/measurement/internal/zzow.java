package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Objects;

final class zzow implements zzgv {
    final String zza;
    final zzpi zzb;
    final zzpf zzc;

    public zzow(zzpf zzpf0, String s, zzpi zzpi0) {
        this.zza = s;
        this.zzb = zzpi0;
        Objects.requireNonNull(zzpf0);
        this.zzc = zzpf0;
        super();
    }

    @Override  // com.google.android.gms.measurement.internal.zzgv
    public final void zza(String s, int v, Throwable throwable0, byte[] arr_b, Map map0) {
        this.zzc.zzQ(this.zza, v, throwable0, arr_b, this.zzb);
    }
}

