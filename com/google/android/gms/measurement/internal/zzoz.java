package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzoz implements Runnable {
    final String zza;
    final String zzb;
    final Bundle zzc;
    final zzpa zzd;

    public zzoz(zzpa zzpa0, String s, String s1, Bundle bundle0) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = bundle0;
        Objects.requireNonNull(zzpa0);
        this.zzd = zzpa0;
        super();
    }

    @Override
    public final void run() {
        zzpo zzpo0 = this.zzd.zza.zzt();
        long v = this.zzd.zza.zzaZ().currentTimeMillis();
        zzbg zzbg0 = (zzbg)Preconditions.checkNotNull(zzpo0.zzac(this.zza, this.zzb, this.zzc, "auto", v, false, true));
        this.zzd.zza.zzD(zzbg0, this.zza);
    }
}

