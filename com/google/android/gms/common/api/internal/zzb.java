package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import java.util.Objects;

final class zzb implements Runnable {
    final LifecycleCallback zza;
    final String zzb;
    final zzc zzc;

    public zzb(zzc zzc0, LifecycleCallback lifecycleCallback0, String s) {
        this.zza = lifecycleCallback0;
        this.zzb = s;
        Objects.requireNonNull(zzc0);
        this.zzc = zzc0;
        super();
    }

    @Override
    public final void run() {
        zzc zzc0 = this.zzc;
        if(zzc0.zzm() > 0) {
            Bundle bundle0 = zzc0.zzn() == null ? null : zzc0.zzn().getBundle(this.zzb);
            this.zza.onCreate(bundle0);
        }
        if(zzc0.zzm() >= 2) {
            this.zza.onStart();
        }
        if(zzc0.zzm() >= 3) {
            this.zza.onResume();
        }
        if(zzc0.zzm() >= 4) {
            this.zza.onStop();
        }
        if(zzc0.zzm() >= 5) {
            this.zza.onDestroy();
        }
    }
}

