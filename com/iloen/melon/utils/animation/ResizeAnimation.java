package com.iloen.melon.utils.animation;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ResizeAnimation extends Animation {
    public final int a;
    public final int b;
    public final View c;

    public ResizeAnimation(View view0, int v) {
        this.c = view0;
        this.b = v;
        this.a = view0.getHeight();
    }

    @Override  // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation0) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.c.getLayoutParams();
        viewGroup$LayoutParams0.height = (int)(((float)(this.b - this.a)) * f + ((float)this.a));
        this.c.requestLayout();
    }

    @Override  // android.view.animation.Animation
    public void initialize(int v, int v1, int v2, int v3) {
        super.initialize(v, v1, v2, v3);
    }

    @Override  // android.view.animation.Animation
    public boolean willChangeBounds() {
        return true;
    }
}

