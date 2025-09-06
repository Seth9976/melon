package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;
import java.util.Objects;

final class zzov implements zzgv {
    final String zza;
    final List zzb;
    final zzpf zzc;

    public zzov(zzpf zzpf0, String s, List list0) {
        this.zza = s;
        this.zzb = list0;
        Objects.requireNonNull(zzpf0);
        this.zzc = zzpf0;
        super();
    }

    @Override  // com.google.android.gms.measurement.internal.zzgv
    public final void zza(String s, int v, Throwable throwable0, byte[] arr_b, Map map0) {
        this.zzc.zzU(true, v, throwable0, arr_b, this.zza, this.zzb);
    }
}

