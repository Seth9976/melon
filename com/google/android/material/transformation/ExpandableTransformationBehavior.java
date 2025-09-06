package com.google.android.material.transformation;

import A6.h;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    public AnimatorSet b;

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    @Override  // com.google.android.material.transformation.ExpandableBehavior
    public void w(View view0, View view1, boolean z, boolean z1) {
        AnimatorSet animatorSet0 = this.b;
        if(animatorSet0 != null) {
            animatorSet0.cancel();
        }
        AnimatorSet animatorSet1 = this.x(view0, view1, z, animatorSet0 != null);
        this.b = animatorSet1;
        animatorSet1.addListener(new h(this, 1));
        this.b.start();
        if(!z1) {
            this.b.end();
        }
    }

    public abstract AnimatorSet x(View arg1, View arg2, boolean arg3, boolean arg4);
}

