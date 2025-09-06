package com.google.android.gms.internal.cast;

import android.annotation.TargetApi;
import android.view.Choreographer.FrameCallback;

public abstract class zzgc {
    private Runnable zza;
    private Choreographer.FrameCallback zzb;

    public abstract void zza(long arg1);

    @TargetApi(16)
    public final Choreographer.FrameCallback zzb() {
        if(this.zzb == null) {
            this.zzb = new zzga(this);
        }
        return this.zzb;
    }

    public final Runnable zzc() {
        if(this.zza == null) {
            this.zza = new zzgb(this);
        }
        return this.zza;
    }
}

