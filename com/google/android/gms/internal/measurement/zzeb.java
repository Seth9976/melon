package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzeb extends zzeq {
    final String zza;
    final String zzb;
    final boolean zzc;
    final zzco zzd;
    final zzfb zze;

    public zzeb(zzfb zzfb0, String s, String s1, boolean z, zzco zzco0) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = z;
        this.zzd = zzco0;
        Objects.requireNonNull(zzfb0);
        this.zze = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zze.zzQ())).getUserProperties(this.zza, this.zzb, this.zzc, this.zzd);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zzb() {
        this.zzd.zzb(null);
    }
}

