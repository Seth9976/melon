package androidx.slidingpanelayout.widget;

import android.view.View;
import android.view.ViewParent;

public final class b implements Runnable {
    public final View a;
    public final SlidingPaneLayout b;

    public b(SlidingPaneLayout slidingPaneLayout0, View view0) {
        this.b = slidingPaneLayout0;
        this.a = view0;
    }

    @Override
    public final void run() {
        View view0 = this.a;
        ViewParent viewParent0 = view0.getParent();
        SlidingPaneLayout slidingPaneLayout0 = this.b;
        if(viewParent0 == slidingPaneLayout0) {
            view0.setLayerType(0, null);
            view0.setLayerPaint(((LayoutParams)view0.getLayoutParams()).d);
        }
        slidingPaneLayout0.D.remove(this);
    }
}

