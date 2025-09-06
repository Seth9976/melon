package A6;

import O4.c;
import O4.f;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.media3.session.legacy.V;
import androidx.transition.Transition;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import ie.H;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuationImpl;
import r6.a;

public final class h extends AnimatorListenerAdapter {
    public final int a;
    public final Object b;

    public h(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationCancel(Animator animator0) {
        switch(this.a) {
            case 5: {
                ((ActionBarOverlayLayout)this.b).M = null;
                ((ActionBarOverlayLayout)this.b).j = false;
                return;
            }
            case 10: {
                ((a)this.b).d();
                return;
            }
            default: {
                super.onAnimationCancel(animator0);
            }
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationEnd(Animator animator0) {
        switch(this.a) {
            case 0: {
                SideSheetBehavior sideSheetBehavior0 = (SideSheetBehavior)this.b;
                sideSheetBehavior0.x(5);
                if(sideSheetBehavior0.r != null && sideSheetBehavior0.r.get() != null) {
                    ((View)sideSheetBehavior0.r.get()).requestLayout();
                }
                return;
            }
            case 1: {
                ((ExpandableTransformationBehavior)this.b).b = null;
                return;
            }
            case 2: {
                ((Transition)this.b).m();
                animator0.removeListener(this);
                return;
            }
            case 3: {
                q.g(animator0, "animation");
                ((CancellableContinuationImpl)this.b).resumeWith(H.a);
                return;
            }
            case 4: {
                f f0 = (f)this.b;
                ArrayList arrayList0 = new ArrayList(f0.e);
                int v = arrayList0.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    ((c)arrayList0.get(v1)).a(f0);
                }
                return;
            }
            case 5: {
                ((ActionBarOverlayLayout)this.b).M = null;
                ((ActionBarOverlayLayout)this.b).j = false;
                return;
            }
            case 6: {
                V v2 = (V)this.b;
                if(((ValueAnimator)v2.a) == animator0) {
                    v2.a = null;
                }
                return;
            }
            case 7: {
                ((com.google.android.material.textfield.h)this.b).q();
                ((com.google.android.material.textfield.h)this.b).r.start();
                return;
            }
            case 8: {
                ((HideBottomViewOnScrollBehavior)this.b).i = null;
                return;
            }
            case 9: {
                BottomSheetBehavior bottomSheetBehavior0 = (BottomSheetBehavior)this.b;
                bottomSheetBehavior0.N(5);
                if(bottomSheetBehavior0.q0 != null && bottomSheetBehavior0.q0.get() != null) {
                    ((View)bottomSheetBehavior0.q0.get()).requestLayout();
                }
                return;
            }
            case 10: {
                ((a)this.b).e();
                return;
            }
            case 11: {
                ((u6.f)this.b).b.setTranslationY(0.0f);
                ((u6.f)this.b).c(0.0f);
                return;
            }
            case 12: {
                View view0 = (View)this.b;
                if(view0 != null) {
                    view0.setVisibility(0);
                }
                return;
            }
            default: {
                super.onAnimationEnd(animator0);
            }
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationRepeat(Animator animator0) {
        if(this.a != 13) {
            super.onAnimationRepeat(animator0);
            return;
        }
        super.onAnimationRepeat(animator0);
        ((v6.q)this.b).f = (((v6.q)this.b).f + 1) % ((v6.q)this.b).e.c.length;
        ((v6.q)this.b).g = true;
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationStart(Animator animator0) {
        switch(this.a) {
            case 4: {
                f f0 = (f)this.b;
                ArrayList arrayList0 = new ArrayList(f0.e);
                int v = arrayList0.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    ((c)arrayList0.get(v1)).b(f0);
                }
                return;
            }
            case 10: {
                ((a)this.b).f(animator0);
                return;
            }
            default: {
                super.onAnimationStart(animator0);
            }
        }
    }
}

