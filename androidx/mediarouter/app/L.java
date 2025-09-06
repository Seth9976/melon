package androidx.mediarouter.app;

import android.view.animation.Animation.AnimationListener;
import android.view.animation.Animation;

public final class l implements Animation.AnimationListener {
    public final int a;
    public final Object b;

    public l(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    private final void a(Animation animation0) {
    }

    private final void b(Animation animation0) {
    }

    private final void c(Animation animation0) {
    }

    private final void d(Animation animation0) {
    }

    private final void e(Animation animation0) {
    }

    @Override  // android.view.animation.Animation$AnimationListener
    public final void onAnimationEnd(Animation animation0) {
        switch(this.a) {
            case 0: {
                break;
            }
            case 1: {
                ((MediaRouteControllerDialog)this.b).h(true);
                break;
            }
            default: {
                ((J)this.b).j.S = false;
                ((J)this.b).j.l();
            }
        }
    }

    @Override  // android.view.animation.Animation$AnimationListener
    public final void onAnimationRepeat(Animation animation0) {
    }

    @Override  // android.view.animation.Animation$AnimationListener
    public final void onAnimationStart(Animation animation0) {
        switch(this.a) {
            case 0: {
                MediaRouteControllerDialog mediaRouteControllerDialog0 = (MediaRouteControllerDialog)this.b;
                OverlayListView overlayListView0 = mediaRouteControllerDialog0.Z;
                for(Object object0: overlayListView0.a) {
                    L l0 = (L)object0;
                    if(!l0.j) {
                        l0.i = overlayListView0.getDrawingTime();
                        l0.j = true;
                    }
                }
                mediaRouteControllerDialog0.Z.postDelayed(mediaRouteControllerDialog0.K0, ((long)mediaRouteControllerDialog0.D0));
                return;
            }
            case 1: {
                break;
            }
            default: {
                ((J)this.b).j.S = true;
                break;
            }
        }
    }
}

