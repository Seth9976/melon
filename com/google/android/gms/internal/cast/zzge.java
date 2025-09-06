package com.google.android.gms.internal.cast;

import android.annotation.TargetApi;
import android.view.Choreographer.FrameCallback;
import android.view.Choreographer;

@TargetApi(16)
final class zzge extends zzgf {
    private final Choreographer zza;

    public zzge() {
        this.zza = Choreographer.getInstance();
    }

    @Override  // com.google.android.gms.internal.cast.zzgf
    public final void zza(zzgc zzgc0) {
        Choreographer.FrameCallback choreographer$FrameCallback0 = zzgc0.zzb();
        this.zza.postFrameCallback(choreographer$FrameCallback0);
    }
}

