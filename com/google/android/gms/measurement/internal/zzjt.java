package com.google.android.gms.measurement.internal;

import java.util.Objects;

final class zzjt extends zzay {
    final zzli zza;

    public zzjt(zzli zzli0, zzjf zzjf0) {
        Objects.requireNonNull(zzli0);
        this.zza = zzli0;
        super(zzjf0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzay
    public final void zza() {
        zzli zzli0 = this.zza.zzu.zzj();
        Objects.requireNonNull(zzli0);
        new Thread(new zzjs(zzli0)).start();
    }
}

