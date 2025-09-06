package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class zze extends AnimatorListenerAdapter {
    final Runnable zza;
    final zzh zzb;

    public zze(zzh zzh0, Runnable runnable0) {
        this.zza = runnable0;
        this.zzb = zzh0;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        this.zzb.setVisibility(8);
        this.zzb.zza = null;
        this.zza.run();
    }
}

