package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class zzd extends AnimatorListenerAdapter {
    final zzh zza;

    public zzd(zzh zzh0) {
        this.zza = zzh0;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        Animator animator1 = zzh.zza(this.zza);
        this.zza.zza = animator1;
        animator1.start();
    }
}

