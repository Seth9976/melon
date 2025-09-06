package androidx.appcompat.app;

import E9.w;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import c2.K;
import d5.v;

public final class N extends w {
    public final int g;
    public final P h;

    public N(P p0, int v) {
        this.g = v;
        this.h = p0;
        super();
    }

    @Override  // c2.d0
    public final void onAnimationEnd() {
        P p0 = this.h;
        if(this.g != 0) {
            p0.t = null;
            p0.d.requestLayout();
            return;
        }
        if(p0.o) {
            View view0 = p0.g;
            if(view0 != null) {
                view0.setTranslationY(0.0f);
                p0.d.setTranslationY(0.0f);
            }
        }
        p0.d.setVisibility(8);
        p0.d.setTransitioning(false);
        p0.t = null;
        v v0 = p0.k;
        if(v0 != null) {
            v0.e(p0.j);
            p0.j = null;
            p0.k = null;
        }
        ActionBarOverlayLayout actionBarOverlayLayout0 = p0.c;
        if(actionBarOverlayLayout0 != null) {
            K.c(actionBarOverlayLayout0);
        }
    }
}

