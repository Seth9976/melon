package D6;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;
import z6.i;

public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final int a;
    public final Object b;

    public b(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator0) {
        switch(this.a) {
            case 0: {
                int v = (int)(((Integer)valueAnimator0.getAnimatedValue()));
                ((TabLayout)this.b).scrollTo(v, 0);
                return;
            }
            case 1: {
                ((View)this.b).invalidate();
                return;
            }
            case 2: {
                int v1 = (int)(((Integer)valueAnimator0.getAnimatedValue()));
                ((CollapsingToolbarLayout)this.b).setScrimAlpha(v1);
                return;
            }
            case 3: {
                float f1 = (float)(((Float)valueAnimator0.getAnimatedValue()));
                ((TextView)this.b).setScaleX(f1);
                ((TextView)this.b).setScaleY(f1);
                return;
            }
            case 4: {
                float f2 = (float)(((Float)valueAnimator0.getAnimatedValue()));
                ((TextInputLayout)this.b).R0.p(f2);
                return;
            }
            default: {
                float f = (float)(((Float)valueAnimator0.getAnimatedValue()));
                i i0 = ((BottomSheetBehavior)this.b).i;
                if(i0 != null) {
                    i0.n(f);
                }
            }
        }
    }
}

