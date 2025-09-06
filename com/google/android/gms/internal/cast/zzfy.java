package com.google.android.gms.internal.cast;

import android.animation.Animator;

public final class zzfy extends zzfw {
    protected final Animator zza;
    private final int zzb;
    private int zzc;
    private final zzgc zzd;

    private zzfy(Animator animator0, int v, Runnable runnable0) {
        this.zzd = new zzfx(this);
        this.zza = animator0;
        this.zzb = -1;
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        if(!this.zza(animator0)) {
            zzgf.zzb().zza(this.zzd);
        }
    }

    public static void zzd(Animator animator0, int v, Runnable runnable0) {
        animator0.addListener(new zzfy(animator0, -1, null));
    }

    public static boolean zze(zzfy zzfy0) {
        return zzfy0.zzb != -1 && zzfy0.zzc >= 0;
    }
}

