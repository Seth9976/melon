package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public final class b extends AnimatorListenerAdapter {
    public final int a;
    public final c b;

    public b(c c0, int v) {
        this.a = v;
        this.b = c0;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationEnd(Animator animator0) {
        if(this.a != 1) {
            super.onAnimationEnd(animator0);
            return;
        }
        this.b.b.h(false);
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationStart(Animator animator0) {
        if(this.a != 0) {
            super.onAnimationStart(animator0);
            return;
        }
        this.b.b.h(true);
    }
}

