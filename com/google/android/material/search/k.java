package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public final class k extends AnimatorListenerAdapter {
    public final int a;
    public final l b;

    public k(l l0, int v) {
        this.a = v;
        this.b = l0;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationEnd(Animator animator0) {
        switch(this.a) {
            case 0: {
                l l1 = this.b;
                if(!l1.a.g()) {
                    l1.a.i();
                }
                l1.a.setTransitionState(h.d);
                return;
            }
            case 1: {
                l l2 = this.b;
                l2.c.setVisibility(8);
                if(!l2.a.g()) {
                    l2.a.f();
                }
                l2.a.setTransitionState(h.b);
                return;
            }
            case 2: {
                l l3 = this.b;
                if(!l3.a.g()) {
                    l3.a.i();
                }
                l3.a.setTransitionState(h.d);
                return;
            }
            default: {
                l l0 = this.b;
                l0.c.setVisibility(8);
                if(!l0.a.g()) {
                    l0.a.f();
                }
                l0.a.setTransitionState(h.b);
            }
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public final void onAnimationStart(Animator animator0) {
        switch(this.a) {
            case 0: {
                this.b.c.setVisibility(0);
                SearchBar searchBar0 = this.b.o;
                searchBar0.w0.getClass();
                View view0 = searchBar0.getCenterView();
                if(view0 != null) {
                    view0.setAlpha(0.0f);
                }
                return;
            }
            case 1: {
                this.b.a.setTransitionState(h.a);
                return;
            }
            case 2: {
                this.b.c.setVisibility(0);
                this.b.a.setTransitionState(h.c);
                return;
            }
            default: {
                this.b.a.setTransitionState(h.a);
            }
        }
    }
}

