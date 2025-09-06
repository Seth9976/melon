package u6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.util.Property;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;

public final class i extends a {
    public final float g;
    public final float h;
    public final float i;

    public i(View view0) {
        super(view0);
        Resources resources0 = view0.getResources();
        this.g = resources0.getDimension(0x7F070159);  // dimen:m3_back_progress_side_container_max_scale_x_distance_shrink
        this.h = resources0.getDimension(0x7F070158);  // dimen:m3_back_progress_side_container_max_scale_x_distance_grow
        this.i = resources0.getDimension(0x7F07015A);  // dimen:m3_back_progress_side_container_max_scale_y_distance
    }

    public final void b() {
        if(this.a() == null) {
            return;
        }
        AnimatorSet animatorSet0 = new AnimatorSet();
        View view0 = this.b;
        animatorSet0.playTogether(new Animator[]{ObjectAnimator.ofFloat(view0, View.SCALE_X, new float[]{1.0f}), ObjectAnimator.ofFloat(view0, View.SCALE_Y, new float[]{1.0f})});
        if(view0 instanceof ViewGroup) {
            for(int v = 0; v < ((ViewGroup)view0).getChildCount(); ++v) {
                animatorSet0.playTogether(new Animator[]{ObjectAnimator.ofFloat(((ViewGroup)view0).getChildAt(v), View.SCALE_Y, new float[]{1.0f})});
            }
        }
        animatorSet0.setDuration(((long)this.e));
        animatorSet0.start();
    }

    public final void c(b.a a0, int v, AnimatorListenerAdapter animatorListenerAdapter0, ValueAnimator.AnimatorUpdateListener valueAnimator$AnimatorUpdateListener0) {
        int v1;
        boolean z = a0.d == 0;
        View view0 = this.b;
        boolean z1 = (Gravity.getAbsoluteGravity(v, view0.getLayoutDirection()) & 3) == 3;
        float f = (float)view0.getWidth();
        float f1 = view0.getScaleX();
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(!(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams)) {
            v1 = 0;
        }
        else if(z1) {
            v1 = ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).leftMargin;
        }
        else {
            v1 = ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin;
        }
        float f2 = f1 * f + ((float)v1);
        Property property0 = View.TRANSLATION_X;
        if(z1) {
            f2 = -f2;
        }
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(view0, property0, new float[]{f2});
        if(valueAnimator$AnimatorUpdateListener0 != null) {
            objectAnimator0.addUpdateListener(valueAnimator$AnimatorUpdateListener0);
        }
        objectAnimator0.setInterpolator(new P2.a(1));
        objectAnimator0.setDuration(((long)e6.a.c(this.c, this.d, a0.c)));
        objectAnimator0.addListener(new h(this, z, v));
        objectAnimator0.addListener(animatorListenerAdapter0);
        objectAnimator0.start();
    }

    public final void d(int v, boolean z, float f) {
        float f8;
        float f1 = this.a.getInterpolation(f);
        View view0 = this.b;
        boolean z1 = true;
        boolean z2 = (Gravity.getAbsoluteGravity(v, view0.getLayoutDirection()) & 3) == 3;
        if(z != z2) {
            z1 = false;
        }
        int v2 = view0.getWidth();
        int v3 = view0.getHeight();
        float f2 = (float)v2;
        if(f2 > 0.0f && ((float)v3) > 0.0f) {
            float f3 = this.g / f2;
            float f4 = this.h / f2;
            float f5 = this.i / ((float)v3);
            if(z2) {
                f2 = 0.0f;
            }
            view0.setPivotX(f2);
            if(!z1) {
                f4 = -f3;
            }
            float f6 = e6.a.a(0.0f, f4, f1);
            view0.setScaleX(f6 + 1.0f);
            float f7 = e6.a.a(0.0f, f5, f1);
            view0.setScaleY(1.0f - f7);
            if(view0 instanceof ViewGroup) {
                for(int v1 = 0; v1 < ((ViewGroup)view0).getChildCount(); ++v1) {
                    View view1 = ((ViewGroup)view0).getChildAt(v1);
                    if(z2) {
                        int v4 = view1.getRight();
                        f8 = (float)(view1.getWidth() + (v2 - v4));
                    }
                    else {
                        f8 = (float)(-view1.getLeft());
                    }
                    view1.setPivotX(f8);
                    view1.setPivotY(((float)(-view1.getTop())));
                    float f9 = z1 ? 1.0f - f6 : 1.0f;
                    view1.setScaleX(f9);
                    view1.setScaleY((1.0f - f7 == 0.0f ? 1.0f : (f6 + 1.0f) / (1.0f - f7) * f9));
                }
            }
        }
    }
}

