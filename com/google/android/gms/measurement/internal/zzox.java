package com.google.android.gms.measurement.internal;

import android.content.Intent;
import java.util.Objects;

final class zzox extends zzay {
    final zzpf zza;

    public zzox(zzpf zzpf0, zzjf zzjf0) {
        Objects.requireNonNull(zzpf0);
        this.zza = zzpf0;
        super(zzjf0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzay
    public final void zza() {
        zzpf zzpf0 = this.zza;
        zzpf0.zzaW().zzg();
        String s = (String)zzpf0.zzax().pollFirst();
        if(s != null) {
            zzpf0.zzay(zzpf0.zzaZ().elapsedRealtime());
            zzpf0.zzaV().zzk().zzb("Sending trigger URI notification to app", s);
            Intent intent0 = new Intent();
            intent0.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            intent0.setPackage(s);
            zzpf.zzav(zzpf0.zzaY(), intent0);
        }
        zzpf0.zzau();
    }
}

