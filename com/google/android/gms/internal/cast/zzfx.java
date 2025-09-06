package com.google.android.gms.internal.cast;

import android.animation.Animator;

final class zzfx extends zzgc {
    final zzfy zza;

    public zzfx(zzfy zzfy0) {
        this.zza = zzfy0;
        super();
    }

    @Override  // com.google.android.gms.internal.cast.zzgc
    public final void zza(long v) {
        ++this.zza.zzc;
        Animator animator0 = this.zza.zza;
        if(!this.zza.zza(animator0) && !animator0.isStarted() && !zzfy.zze(this.zza)) {
            animator0.start();
        }
    }
}

