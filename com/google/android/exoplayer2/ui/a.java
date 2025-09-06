package com.google.android.exoplayer2.ui;

import S1.c;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.e;
import com.google.android.material.textfield.h;
import com.iloen.melon.custom.VideoOverlayDoubleTapView;
import com.kakao.emoticon.ui.widget.EmoticonSlidePreview;
import kotlin.jvm.internal.q;

public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final int a;
    public final Object b;

    public a(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator0) {
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                ((DefaultTimeBar)object0).lambda$new$1(valueAnimator0);
                return;
            }
            case 1: {
                float f1 = valueAnimator0.getAnimatedFraction();
                ((DrawerLayout)object0).setScrimColor(c.k(0x99000000, e6.a.c(com.google.android.material.navigation.a.a, 0, f1)));
                return;
            }
            case 2: {
                float f2 = (float)(((Float)valueAnimator0.getAnimatedValue()));
                if(((DrawerArrowDrawable)object0).i != f2) {
                    ((DrawerArrowDrawable)object0).i = f2;
                    ((DrawerArrowDrawable)object0).invalidateSelf();
                }
                return;
            }
            case 3: {
                ((e)object0).a(((float)(((Float)valueAnimator0.getAnimatedValue()))));
                return;
            }
            case 4: {
                ((h)object0).getClass();
                float f3 = (float)(((Float)valueAnimator0.getAnimatedValue()));
                ((h)object0).d.setAlpha(f3);
                return;
            }
            case 5: {
                q.g(valueAnimator0, "it");
                Object object1 = valueAnimator0.getAnimatedValue();
                q.e(object1, "null cannot be cast to non-null type kotlin.Float");
                ((VideoOverlayDoubleTapView)object0).i = ((float)(((VideoOverlayDoubleTapView)object0).k - ((VideoOverlayDoubleTapView)object0).j)) * ((float)(((Float)object1))) + ((float)((VideoOverlayDoubleTapView)object0).j);
                ((VideoOverlayDoubleTapView)object0).invalidate();
                return;
            }
            case 6: {
                EmoticonSlidePreview.a(((EmoticonSlidePreview)object0), valueAnimator0);
                return;
            }
            case 7: {
                ((j6.c)object0).getClass();
                float f4 = (float)(((Float)valueAnimator0.getAnimatedValue()));
                ((j6.c)object0).j.setAlpha(((int)(255.0f * f4)));
                ((j6.c)object0).x = f4;
                return;
            }
            default: {
                float f = (float)(((Float)valueAnimator0.getAnimatedValue()));
                ((ClippableRoundedCornerLayout)object0).a(((float)((ClippableRoundedCornerLayout)object0).getLeft()), ((float)((ClippableRoundedCornerLayout)object0).getTop()), ((float)((ClippableRoundedCornerLayout)object0).getRight()), ((float)((ClippableRoundedCornerLayout)object0).getBottom()), f);
            }
        }
    }
}

