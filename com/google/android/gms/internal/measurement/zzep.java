package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzep extends zzeq {
    final Long zza;
    final String zzb;
    final String zzc;
    final Bundle zzd;
    final boolean zze;
    final boolean zzf;
    final zzfb zzg;

    public zzep(zzfb zzfb0, Long long0, String s, String s1, Bundle bundle0, boolean z, boolean z1) {
        this.zza = long0;
        this.zzb = s;
        this.zzc = s1;
        this.zzd = bundle0;
        this.zze = z;
        this.zzf = z1;
        Objects.requireNonNull(zzfb0);
        this.zzg = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzg.zzQ())).logEvent(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, (this.zza == null ? this.zzh : ((long)this.zza)));
    }
}

