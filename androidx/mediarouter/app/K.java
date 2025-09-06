package androidx.mediarouter.app;

import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import d5.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Map;
import l4.O;

public final class k implements ViewTreeObserver.OnGlobalLayoutListener {
    public final Map a;
    public final Map b;
    public final MediaRouteControllerDialog c;

    public k(MediaRouteControllerDialog mediaRouteControllerDialog0, HashMap hashMap0, HashMap hashMap1) {
        this.c = mediaRouteControllerDialog0;
        this.a = hashMap0;
        this.b = hashMap1;
    }

    @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public final void onGlobalLayout() {
        L l1;
        O o1;
        Map map0;
        MediaRouteControllerDialog mediaRouteControllerDialog0 = this.c;
        mediaRouteControllerDialog0.Z.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        HashSet hashSet0 = mediaRouteControllerDialog0.d0;
        if(hashSet0 != null && mediaRouteControllerDialog0.e0 != null) {
            int v = hashSet0.size() - mediaRouteControllerDialog0.e0.size();
            l l0 = new l(mediaRouteControllerDialog0, 0);
            int v1 = mediaRouteControllerDialog0.Z.getFirstVisiblePosition();
            boolean z = false;
            for(int v2 = 0; true; ++v2) {
                int v3 = mediaRouteControllerDialog0.Z.getChildCount();
                map0 = this.a;
                Map map1 = this.b;
                if(v2 >= v3) {
                    break;
                }
                View view0 = mediaRouteControllerDialog0.Z.getChildAt(v2);
                O o0 = (O)mediaRouteControllerDialog0.b0.getItem(v1 + v2);
                Rect rect0 = (Rect)map0.get(o0);
                int v4 = view0.getTop();
                int v5 = rect0 == null ? mediaRouteControllerDialog0.k0 * v + v4 : rect0.top;
                AnimationSet animationSet0 = new AnimationSet(true);
                if(mediaRouteControllerDialog0.d0 == null || !mediaRouteControllerDialog0.d0.contains(o0)) {
                    o1 = o0;
                }
                else {
                    AlphaAnimation alphaAnimation0 = new AlphaAnimation(0.0f, 0.0f);
                    o1 = o0;
                    alphaAnimation0.setDuration(((long)mediaRouteControllerDialog0.E0));
                    animationSet0.addAnimation(alphaAnimation0);
                    v5 = v4;
                }
                TranslateAnimation translateAnimation0 = new TranslateAnimation(0.0f, 0.0f, ((float)(v5 - v4)), 0.0f);
                translateAnimation0.setDuration(((long)mediaRouteControllerDialog0.D0));
                animationSet0.addAnimation(translateAnimation0);
                animationSet0.setFillAfter(true);
                animationSet0.setFillEnabled(true);
                animationSet0.setInterpolator(mediaRouteControllerDialog0.G0);
                if(!z) {
                    animationSet0.setAnimationListener(l0);
                    z = true;
                }
                view0.clearAnimation();
                view0.startAnimation(animationSet0);
                map0.remove(o1);
                map1.remove(o1);
            }
            for(Object object0: map1.entrySet()) {
                O o2 = (O)((Map.Entry)object0).getKey();
                BitmapDrawable bitmapDrawable0 = (BitmapDrawable)((Map.Entry)object0).getValue();
                Rect rect1 = (Rect)map0.get(o2);
                if(mediaRouteControllerDialog0.e0.contains(o2)) {
                    l1 = new L(bitmapDrawable0, rect1);
                    l1.h = 0.0f;
                    l1.e = (long)mediaRouteControllerDialog0.F0;
                    l1.d = mediaRouteControllerDialog0.G0;
                }
                else {
                    int v6 = mediaRouteControllerDialog0.k0 * v;
                    L l2 = new L(bitmapDrawable0, rect1);
                    l2.g = v6;
                    l2.e = (long)mediaRouteControllerDialog0.D0;
                    l2.d = mediaRouteControllerDialog0.G0;
                    l2.l = new c(mediaRouteControllerDialog0, o2, false, 6);
                    mediaRouteControllerDialog0.f0.add(o2);
                    l1 = l2;
                }
                mediaRouteControllerDialog0.Z.a.add(l1);
            }
        }
    }
}

