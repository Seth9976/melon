package androidx.transition;

import N4.b0;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

public class ChangeScroll extends Transition {
    public static final String[] b0;

    static {
        ChangeScroll.b0 = new String[]{"android:changeScroll:x", "android:changeScroll:y"};
    }

    public ChangeScroll(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public static void O(b0 b00) {
        Integer integer0 = b00.b.getScrollX();
        b00.a.put("android:changeScroll:x", integer0);
        Integer integer1 = b00.b.getScrollY();
        b00.a.put("android:changeScroll:y", integer1);
    }

    @Override  // androidx.transition.Transition
    public final void d(b0 b00) {
        ChangeScroll.O(b00);
    }

    @Override  // androidx.transition.Transition
    public final void g(b0 b00) {
        ChangeScroll.O(b00);
    }

    @Override  // androidx.transition.Transition
    public final Animator k(ViewGroup viewGroup0, b0 b00, b0 b01) {
        Animator animator1;
        Animator animator0 = null;
        if(b00 != null) {
            HashMap hashMap0 = b00.a;
            if(b01 != null) {
                View view0 = b01.b;
                int v = (int)(((Integer)hashMap0.get("android:changeScroll:x")));
                int v1 = (int)(((Integer)b01.a.get("android:changeScroll:x")));
                int v2 = (int)(((Integer)hashMap0.get("android:changeScroll:y")));
                int v3 = (int)(((Integer)b01.a.get("android:changeScroll:y")));
                if(v == v1) {
                    animator1 = null;
                }
                else {
                    view0.setScrollX(v);
                    animator1 = ObjectAnimator.ofInt(view0, "scrollX", new int[]{v, v1});
                }
                if(v2 != v3) {
                    view0.setScrollY(v2);
                    animator0 = ObjectAnimator.ofInt(view0, "scrollY", new int[]{v2, v3});
                }
                if(animator1 == null) {
                    return animator0;
                }
                if(animator0 == null) {
                    return animator1;
                }
                Animator animator2 = new AnimatorSet();
                ((AnimatorSet)animator2).playTogether(new Animator[]{animator1, animator0});
                return animator2;
            }
        }
        return null;
    }

    @Override  // androidx.transition.Transition
    public final String[] q() {
        return ChangeScroll.b0;
    }

    @Override  // androidx.transition.Transition
    public final boolean t() {
        return true;
    }
}

