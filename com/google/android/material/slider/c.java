package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import androidx.lifecycle.b;
import com.google.android.material.internal.B;

public final class c extends AnimatorListenerAdapter {
    public final BaseSlider a;

    public c(BaseSlider baseSlider0) {
        this.a = baseSlider0;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        super.onAnimationEnd(animator0);
        ViewGroup viewGroup0 = B.i(this.a);
        b b0 = viewGroup0 == null ? null : new b(viewGroup0);
        for(Object object0: this.a.l) {
            ((ViewOverlay)b0.b).remove(((F6.b)object0));
        }
    }
}

