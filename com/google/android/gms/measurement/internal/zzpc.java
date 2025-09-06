package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzpc {
    final String zza;
    long zzb;

    private zzpc(zzpf zzpf0, String s) {
        Objects.requireNonNull(zzpf0);
        super();
        this.zza = s;
        this.zzb = zzpf0.zzaZ().elapsedRealtime();
    }

    public zzpc(zzpf zzpf0, String s, byte[] arr_b) {
        this(zzpf0, s);
    }

    public zzpc(zzpf zzpf0, byte[] arr_b) {
        this(zzpf0, zzpf0.zzt().zzaw());
    }
}

