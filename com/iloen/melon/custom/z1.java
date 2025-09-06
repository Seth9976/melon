package com.iloen.melon.custom;

import android.animation.Animator.AnimatorListener;
import android.animation.Animator;
import com.melon.ui.popup.AnimationPopupDialogFragment;
import kotlin.jvm.internal.q;
import we.a;

public final class z1 implements Animator.AnimatorListener {
    public final int a;
    public final Object b;

    public z1(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    private final void a(Animator animator0) {
    }

    private final void b(Animator animator0) {
    }

    private final void c(Animator animator0) {
    }

    @Override  // android.animation.Animator$AnimatorListener
    public final void onAnimationCancel(Animator animator0) {
        if(this.a != 1) {
            q.g(animator0, "animation");
        }
    }

    @Override  // android.animation.Animator$AnimatorListener
    public final void onAnimationEnd(Animator animator0) {
        switch(this.a) {
            case 0: {
                q.g(animator0, "animation");
                VideoOverlayDoubleTapView videoOverlayDoubleTapView0 = (VideoOverlayDoubleTapView)this.b;
                if(!videoOverlayDoubleTapView0.m) {
                    videoOverlayDoubleTapView0.getPerformAtEnd().invoke();
                }
                return;
            }
            case 1: {
                ((a)this.b).invoke();
                return;
            }
            default: {
                q.g(animator0, "animation");
                ((AnimationPopupDialogFragment)this.b).dismiss();
            }
        }
    }

    @Override  // android.animation.Animator$AnimatorListener
    public final void onAnimationRepeat(Animator animator0) {
        if(this.a != 1) {
            q.g(animator0, "animation");
        }
    }

    @Override  // android.animation.Animator$AnimatorListener
    public final void onAnimationStart(Animator animator0) {
        if(this.a != 1) {
            q.g(animator0, "animation");
        }
    }
}

