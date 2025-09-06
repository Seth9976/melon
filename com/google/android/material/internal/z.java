package com.google.android.material.internal;

import D6.b;
import N4.b0;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import java.util.HashMap;

public final class z extends Transition {
    @Override  // androidx.transition.Transition
    public final void d(b0 b00) {
        View view0 = b00.b;
        if(view0 instanceof TextView) {
            Float float0 = ((TextView)view0).getScaleX();
            b00.a.put("android:textscale:scale", float0);
        }
    }

    @Override  // androidx.transition.Transition
    public final void g(b0 b00) {
        View view0 = b00.b;
        if(view0 instanceof TextView) {
            Float float0 = ((TextView)view0).getScaleX();
            b00.a.put("android:textscale:scale", float0);
        }
    }

    @Override  // androidx.transition.Transition
    public final Animator k(ViewGroup viewGroup0, b0 b00, b0 b01) {
        if(b00 != null && b01 != null && b00.b instanceof TextView) {
            View view0 = b01.b;
            if(view0 instanceof TextView) {
                HashMap hashMap0 = b01.a;
                float f = 1.0f;
                float f1 = b00.a.get("android:textscale:scale") == null ? 1.0f : ((float)(((Float)b00.a.get("android:textscale:scale"))));
                if(hashMap0.get("android:textscale:scale") != null) {
                    f = (float)(((Float)hashMap0.get("android:textscale:scale")));
                }
                if(f1 != f) {
                    Animator animator0 = ValueAnimator.ofFloat(new float[]{f1, f});
                    ((ValueAnimator)animator0).addUpdateListener(new b(((TextView)view0), 3));
                    return animator0;
                }
            }
        }
        return null;
    }
}

