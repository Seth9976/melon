package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

final class zzdj extends zzeq {
    final String zza;
    final String zzb;
    final Bundle zzc;
    final zzfb zzd;

    public zzdj(zzfb zzfb0, String s, String s1, Bundle bundle0) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = bundle0;
        Objects.requireNonNull(zzfb0);
        this.zzd = zzfb0;
        super(zzfb0, true);
    }

    @Override  // com.google.android.gms.internal.measurement.zzeq
    public final void zza() {
        ((zzcr)Preconditions.checkNotNull(this.zzd.zzQ())).clearConditionalUserProperty(this.zza, this.zzb, this.zzc);
    }
}

