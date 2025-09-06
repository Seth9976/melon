package A6;

import E9.h;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.material.sidesheet.SideSheetBehavior;
import e6.a;

public final class f implements ValueAnimator.AnimatorUpdateListener {
    public final SideSheetBehavior a;
    public final ViewGroup.MarginLayoutParams b;
    public final int c;
    public final View d;

    public f(SideSheetBehavior sideSheetBehavior0, ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v, View view0) {
        this.a = sideSheetBehavior0;
        this.b = viewGroup$MarginLayoutParams0;
        this.c = v;
        this.d = view0;
    }

    @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator0) {
        h h0 = this.a.a;
        float f = valueAnimator0.getAnimatedFraction();
        h0.c0(this.b, a.c(this.c, 0, f));
        this.d.requestLayout();
    }
}

