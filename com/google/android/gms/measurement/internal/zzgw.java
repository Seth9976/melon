package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

final class zzgw implements Runnable {
    private final zzgv zza;
    private final int zzb;
    private final Throwable zzc;
    private final byte[] zzd;
    private final String zze;
    private final Map zzf;

    public zzgw(String s, zzgv zzgv0, int v, Throwable throwable0, byte[] arr_b, Map map0, byte[] arr_b1) {
        Preconditions.checkNotNull(zzgv0);
        this.zza = zzgv0;
        this.zzb = v;
        this.zzc = throwable0;
        this.zzd = arr_b;
        this.zze = s;
        this.zzf = map0;
    }

    @Override
    public final void run() {
        this.zza.zza(this.zze, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}

