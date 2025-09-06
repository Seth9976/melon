package androidx.mediarouter.app;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import l4.O;

public final class e implements ViewTreeObserver.OnGlobalLayoutListener {
    public final MediaRouteControllerDialog a;

    public e(MediaRouteControllerDialog mediaRouteControllerDialog0) {
        this.a = mediaRouteControllerDialog0;
    }

    @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public final void onGlobalLayout() {
        MediaRouteControllerDialog mediaRouteControllerDialog0 = this.a;
        mediaRouteControllerDialog0.Z.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if(mediaRouteControllerDialog0.d0 != null && mediaRouteControllerDialog0.d0.size() != 0) {
            l l0 = new l(mediaRouteControllerDialog0, 1);
            int v = mediaRouteControllerDialog0.Z.getFirstVisiblePosition();
            boolean z = false;
            for(int v1 = 0; v1 < mediaRouteControllerDialog0.Z.getChildCount(); ++v1) {
                View view0 = mediaRouteControllerDialog0.Z.getChildAt(v1);
                O o0 = (O)mediaRouteControllerDialog0.b0.getItem(v + v1);
                if(mediaRouteControllerDialog0.d0.contains(o0)) {
                    AlphaAnimation alphaAnimation0 = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation0.setDuration(((long)mediaRouteControllerDialog0.E0));
                    alphaAnimation0.setFillEnabled(true);
                    alphaAnimation0.setFillAfter(true);
                    if(!z) {
                        alphaAnimation0.setAnimationListener(l0);
                        z = true;
                    }
                    view0.clearAnimation();
                    view0.startAnimation(alphaAnimation0);
                }
            }
            return;
        }
        mediaRouteControllerDialog0.h(true);
    }
}

