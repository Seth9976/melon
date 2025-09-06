package androidx.mediarouter.app;

public final class f implements Runnable {
    public final int a;
    public final Object b;

    public f(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            MediaRouteControllerDialog mediaRouteControllerDialog0 = ((p)this.b).b;
            if(mediaRouteControllerDialog0.i0 != null) {
                mediaRouteControllerDialog0.i0 = null;
                if(mediaRouteControllerDialog0.y0) {
                    mediaRouteControllerDialog0.n(mediaRouteControllerDialog0.z0);
                }
            }
            return;
        }
        ((MediaRouteControllerDialog)this.b).g(true);
        ((MediaRouteControllerDialog)this.b).Z.requestLayout();
        ((MediaRouteControllerDialog)this.b).Z.getViewTreeObserver().addOnGlobalLayoutListener(new e(((MediaRouteControllerDialog)this.b)));
    }
}

