package com.google.android.gms.measurement.internal;

import java.util.Map;

final class zzll implements Runnable {
    private final zzlm zza;
    private final int zzb;
    private final Exception zzc;
    private final byte[] zzd;
    private final Map zze;

    public zzll(zzlm zzlm0, int v, Exception exception0, byte[] arr_b, Map map0) {
        this.zza = zzlm0;
        this.zzb = v;
        this.zzc = exception0;
        this.zzd = arr_b;
        this.zze = map0;
    }

    @Override
    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
    }
}

