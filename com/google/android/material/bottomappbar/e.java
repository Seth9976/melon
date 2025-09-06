package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;

public final class e extends AnimatorListenerAdapter {
    public boolean a;
    public final ActionMenuView b;
    public final int c;
    public final boolean d;
    public final BottomAppBar e;

    public e(BottomAppBar bottomAppBar0, ActionMenuView actionMenuView0, int v, boolean z) {
        this.e = bottomAppBar0;
        this.b = actionMenuView0;
        this.c = v;
        this.d = z;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationCancel(Animator animator0) {
        this.a = true;
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        if(!this.a) {
            this.e.K(this.b, this.c, this.d, false);
        }
    }
}

