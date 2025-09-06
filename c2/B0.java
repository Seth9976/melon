package c2;

import H0.b;
import Ua.h;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.P;
import com.google.android.material.appbar.AppBarLayout;
import com.iloen.melon.fragments.shortform.TrendShortFormFragment;
import java.util.Iterator;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.q;
import we.n;
import z6.i;

public final class b0 implements ValueAnimator.AnimatorUpdateListener {
    public final int a;
    public final Object b;
    public final Object c;

    public b0(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator0) {
        Object object0 = this.c;
        Object object1 = this.b;
        switch(this.a) {
            case 0: {
                ((View)((P)((h)object1).a).d.getParent()).invalidate();
                return;
            }
            case 1: {
                float f = (float)(((Float)valueAnimator0.getAnimatedValue()));
                ((i)object0).l(f);
                Drawable drawable0 = ((AppBarLayout)object1).I;
                if(drawable0 instanceof i) {
                    ((i)drawable0).l(f);
                }
                Iterator iterator0 = ((AppBarLayout)object1).B.iterator();
                if(iterator0.hasNext()) {
                    throw b.b(iterator0);
                }
                return;
            }
            case 2: {
                q.g(valueAnimator0, "it");
                Object object2 = valueAnimator0.getAnimatedValue();
                q.e(object2, "null cannot be cast to non-null type kotlin.Float");
                ((n)object1).invoke(((ImageView)object0), ((Float)object2));
                return;
            }
            default: {
                TrendShortFormFragment.L(((F)object1), ((TrendShortFormFragment)object0), valueAnimator0);
            }
        }
    }
}

