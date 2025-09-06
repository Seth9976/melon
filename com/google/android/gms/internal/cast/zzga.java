package com.google.android.gms.internal.cast;

import android.view.Choreographer.FrameCallback;

public final class zzga implements Choreographer.FrameCallback {
    public final zzgc zza;

    public zzga(zzgc zzgc0) {
        this.zza = zzgc0;
    }

    @Override  // android.view.Choreographer$FrameCallback
    public final void doFrame(long v) {
        this.zza.zza(v);
    }
}

