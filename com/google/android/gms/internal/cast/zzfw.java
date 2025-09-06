package com.google.android.gms.internal.cast;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.collection.V;

public class zzfw extends AnimatorListenerAdapter {
    private final V zza;

    public zzfw() {
        this.zza = new V(0);
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationCancel(Animator animator0) {
        this.zza.put(animator0, Boolean.TRUE);
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationStart(Animator animator0) {
        this.zza.put(animator0, Boolean.FALSE);
    }

    // 去混淆评级： 低(20)
    public final boolean zza(Animator animator0) {
        return this.zza.containsKey(animator0) && ((Boolean)this.zza.get(animator0)).booleanValue();
    }
}

