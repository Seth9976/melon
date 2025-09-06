package com.google.android.material.appbar;

import E9.h;
import android.view.View;
import com.google.android.material.internal.c;

public final class f implements e {
    public final CollapsingToolbarLayout a;

    public f(CollapsingToolbarLayout collapsingToolbarLayout0) {
        this.a = collapsingToolbarLayout0;
    }

    @Override  // com.google.android.material.appbar.e
    public final void onOffsetChanged(AppBarLayout appBarLayout0, int v) {
        CollapsingToolbarLayout collapsingToolbarLayout0 = this.a;
        c c0 = collapsingToolbarLayout0.k;
        collapsingToolbarLayout0.S = v;
        int v1 = collapsingToolbarLayout0.V == null ? 0 : collapsingToolbarLayout0.V.d();
        int v2 = collapsingToolbarLayout0.getChildCount();
        for(int v3 = 0; v3 < v2; ++v3) {
            View view0 = collapsingToolbarLayout0.getChildAt(v3);
            LayoutParams collapsingToolbarLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
            i i0 = CollapsingToolbarLayout.b(view0);
            switch(collapsingToolbarLayout$LayoutParams0.a) {
                case 1: {
                    i i1 = CollapsingToolbarLayout.b(view0);
                    LayoutParams collapsingToolbarLayout$LayoutParams1 = (LayoutParams)view0.getLayoutParams();
                    i0.b(h.r(-v, 0, collapsingToolbarLayout0.getHeight() - i1.b - view0.getHeight() - collapsingToolbarLayout$LayoutParams1.bottomMargin));
                    break;
                }
                case 2: {
                    i0.b(Math.round(((float)(-v)) * collapsingToolbarLayout$LayoutParams0.b));
                }
            }
        }
        collapsingToolbarLayout0.d();
        if(collapsingToolbarLayout0.r != null && v1 > 0) {
            collapsingToolbarLayout0.postInvalidateOnAnimation();
        }
        int v4 = collapsingToolbarLayout0.getHeight();
        int v5 = v4 - collapsingToolbarLayout0.getMinimumHeight() - v1;
        float f = Math.min(1.0f, ((float)(v4 - collapsingToolbarLayout0.getScrimVisibleHeightTrigger())) / ((float)v5));
        c0.d = f;
        c0.e = (1.0f - f) * 0.5f + f;
        c0.f = collapsingToolbarLayout0.S + v5;
        c0.p(((float)Math.abs(v)) / ((float)v5));
    }
}

