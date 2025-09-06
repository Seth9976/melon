package com.google.android.material.search;

import android.animation.AnimatorSet;

public final class j implements Runnable {
    public final int a;
    public final l b;

    public j(l l0, int v) {
        this.a = v;
        this.b = l0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            float f = (float)this.b.c.getHeight();
            this.b.c.setTranslationY(f);
            AnimatorSet animatorSet0 = this.b.h(true);
            animatorSet0.addListener(new k(this.b, 2));
            animatorSet0.start();
            return;
        }
        AnimatorSet animatorSet1 = this.b.d(true);
        animatorSet1.addListener(new k(this.b, 0));
        animatorSet1.start();
    }
}

