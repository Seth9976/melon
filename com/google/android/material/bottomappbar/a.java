package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public final class a extends AnimatorListenerAdapter {
    public final int a;
    public final BottomAppBar b;

    public a(BottomAppBar bottomAppBar0, int v) {
        this.a = v;
        this.b = bottomAppBar0;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationEnd(Animator animator0) {
        BottomAppBar bottomAppBar0 = this.b;
        switch(this.a) {
            case 1: {
                bottomAppBar0.v0 = null;
                return;
            }
            case 2: {
                bottomAppBar0.I0 = false;
                bottomAppBar0.w0 = null;
                return;
            }
            default: {
                super.onAnimationEnd(animator0);
            }
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationStart(Animator animator0) {
        BottomAppBar bottomAppBar0 = this.b;
        switch(this.a) {
            case 0: {
                if(!bottomAppBar0.I0) {
                    bottomAppBar0.G(bottomAppBar0.x0, bottomAppBar0.J0);
                }
                return;
            }
            case 1: {
                return;
            }
            case 2: {
                return;
            }
            default: {
                bottomAppBar0.O0.onAnimationStart(animator0);
                View view0 = bottomAppBar0.C();
                FloatingActionButton floatingActionButton0 = view0 instanceof FloatingActionButton ? ((FloatingActionButton)view0) : null;
                if(floatingActionButton0 != null) {
                    floatingActionButton0.setTranslationX(bottomAppBar0.getFabTranslationX());
                }
            }
        }
    }
}

