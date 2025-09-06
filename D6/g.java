package D6;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.internal.B;

public final class g implements ValueAnimator.AnimatorUpdateListener {
    public final int a;
    public final View b;
    public final View c;
    public final Object d;

    public g(h h0, View view0, View view1) {
        this.a = 0;
        super();
        this.d = h0;
        this.b = view0;
        this.c = view1;
    }

    public g(ActionMenuView actionMenuView0, ActionMenuView actionMenuView1) {
        this.a = 1;
        super();
        this.b = actionMenuView0;
        this.c = actionMenuView1;
        this.d = new float[2];
    }

    @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator0) {
        if(this.a != 0) {
            float f = (float)(((Float)valueAnimator0.getAnimatedValue()));
            float[] arr_f = (float[])this.d;
            B.a(arr_f, f);
            View view0 = this.b;
            if(view0 != null) {
                view0.setAlpha(arr_f[0]);
            }
            View view1 = this.c;
            if(view1 != null) {
                view1.setAlpha(arr_f[1]);
            }
            return;
        }
        float f1 = valueAnimator0.getAnimatedFraction();
        ((h)this.d).c(this.b, this.c, f1);
    }
}

