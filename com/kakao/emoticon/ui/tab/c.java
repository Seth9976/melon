package com.kakao.emoticon.ui.tab;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;

public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final int a;
    public final TabItemTouchController b;

    public c(TabItemTouchController tabItemTouchController0, int v) {
        this.a = v;
        this.b = tabItemTouchController0;
        super();
    }

    @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator0) {
        switch(this.a) {
            case 0: {
                this.b.lambda$onTrashHover$1(valueAnimator0);
                return;
            }
            case 1: {
                this.b.lambda$onTrashHover$2(valueAnimator0);
                return;
            }
            default: {
                this.b.lambda$onItemSelected$0(valueAnimator0);
            }
        }
    }
}

