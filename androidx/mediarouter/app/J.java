package androidx.mediarouter.app;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public final class j extends Animation {
    public final int a;
    public final int b;
    public final int c;
    public final View d;

    public j(View view0, int v, int v1, int v2) {
        this.a = v2;
        this.b = v;
        this.c = v1;
        this.d = view0;
        super();
    }

    public j(SwipeRefreshLayout swipeRefreshLayout0, int v, int v1) {
        this.a = 2;
        this.d = swipeRefreshLayout0;
        this.b = v;
        this.c = v1;
        super();
    }

    @Override  // android.view.animation.Animation
    public final void applyTransformation(float f, Transformation transformation0) {
        int v = this.c;
        int v1 = this.b;
        View view0 = this.d;
        switch(this.a) {
            case 0: {
                MediaRouteControllerDialog.l(view0, v1 - ((int)(((float)(v1 - v)) * f)));
                return;
            }
            case 1: {
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
                viewGroup$LayoutParams0.height = v + ((int)(((float)(v1 - v)) * f));
                view0.setLayoutParams(viewGroup$LayoutParams0);
                return;
            }
            default: {
                ((SwipeRefreshLayout)view0).V.setAlpha(((int)(((float)(v - v1)) * f + ((float)v1))));
            }
        }
    }
}

