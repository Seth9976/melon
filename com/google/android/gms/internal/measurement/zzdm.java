package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzdm extends zzeq {
    final zzdf zza;
    final String zzb;
    final String zzc;
    final zzfb zzd;

    public zzdm(zzfb zzfb0, zzdf zzdf0, String s, String s1) {
        this.zza = zzdf0;
        this.zzb = s;
        this.zzc = s1;
        Objects.requireNonNull(zzfb0);
        this.zzd = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzd.zzQ())).setCurrentScreenByScionActivityInfo(this.zza, this.zzb, this.zzc, this.zzh);
    }
}

