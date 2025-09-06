package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzkf extends zzay {
    final zzli zza;

    public zzkf(zzli zzli0, zzjf zzjf0) {
        Objects.requireNonNull(zzli0);
        this.zza = zzli0;
        super(zzjf0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzay
    public final void zza() {
        zzli zzli0 = this.zza;
        if(zzli0.zzu.zzI()) {
            zzli0.zzao().zzb(2000L);
        }
    }
}

