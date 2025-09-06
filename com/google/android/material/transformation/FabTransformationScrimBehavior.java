package com.google.android.material.transformation;

import G6.e;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d5.n;
import e6.g;
import java.util.ArrayList;

@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    public final g c;
    public final g d;

    public FabTransformationScrimBehavior() {
        this.c = new g(75L);
        this.d = new g(0L);
    }

    public FabTransformationScrimBehavior(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.c = new g(75L);
        this.d = new g(0L);
    }

    @Override  // com.google.android.material.transformation.ExpandableBehavior
    public final boolean f(View view0, View view1) {
        return view1 instanceof FloatingActionButton;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final boolean v(CoordinatorLayout coordinatorLayout0, View view0, MotionEvent motionEvent0) {
        return false;
    }

    @Override  // com.google.android.material.transformation.ExpandableTransformationBehavior
    public final AnimatorSet x(View view0, View view1, boolean z, boolean z1) {
        ObjectAnimator objectAnimator0;
        ArrayList arrayList0 = new ArrayList();
        new ArrayList();
        g g0 = z ? this.c : this.d;
        if(z) {
            if(!z1) {
                view1.setAlpha(0.0f);
            }
            objectAnimator0 = ObjectAnimator.ofFloat(view1, View.ALPHA, new float[]{1.0f});
        }
        else {
            objectAnimator0 = ObjectAnimator.ofFloat(view1, View.ALPHA, new float[]{0.0f});
        }
        g0.a(objectAnimator0);
        arrayList0.add(objectAnimator0);
        AnimatorSet animatorSet0 = new AnimatorSet();
        n.y(animatorSet0, arrayList0);
        animatorSet0.addListener(new e(view1, z));
        return animatorSet0;
    }
}

