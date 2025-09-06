package androidx.transition;

import N4.G;
import N4.b0;
import N4.e0;
import N4.g;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

public class ChangeClipBounds extends Transition {
    public static final String[] b0;
    public static final Rect c0;

    static {
        ChangeClipBounds.b0 = new String[]{"android:clipBounds:clip"};
        ChangeClipBounds.c0 = new Rect();
    }

    public ChangeClipBounds(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public static void O(b0 b00, boolean z) {
        Rect rect0 = null;
        View view0 = b00.b;
        HashMap hashMap0 = b00.a;
        if(view0.getVisibility() != 8) {
            Rect rect1 = z ? ((Rect)view0.getTag(0x7F0A0BDE)) : null;  // id:transition_clip
            if(rect1 == null) {
                rect1 = view0.getClipBounds();
            }
            if(rect1 != ChangeClipBounds.c0) {
                rect0 = rect1;
            }
            hashMap0.put("android:clipBounds:clip", rect0);
            if(rect0 == null) {
                hashMap0.put("android:clipBounds:bounds", new Rect(0, 0, view0.getWidth(), view0.getHeight()));
            }
        }
    }

    @Override  // androidx.transition.Transition
    public final void d(b0 b00) {
        ChangeClipBounds.O(b00, false);
    }

    @Override  // androidx.transition.Transition
    public final void g(b0 b00) {
        ChangeClipBounds.O(b00, true);
    }

    @Override  // androidx.transition.Transition
    public final Animator k(ViewGroup viewGroup0, b0 b00, b0 b01) {
        if(b00 != null) {
            HashMap hashMap0 = b00.a;
            if(b01 != null) {
                View view0 = b01.b;
                HashMap hashMap1 = b01.a;
                if(hashMap0.containsKey("android:clipBounds:clip") && hashMap1.containsKey("android:clipBounds:clip")) {
                    Rect rect0 = (Rect)hashMap0.get("android:clipBounds:clip");
                    Rect rect1 = (Rect)hashMap1.get("android:clipBounds:clip");
                    if(rect0 != null || rect1 != null) {
                        Rect rect2 = rect0 == null ? ((Rect)hashMap0.get("android:clipBounds:bounds")) : rect0;
                        Rect rect3 = rect1 == null ? ((Rect)hashMap1.get("android:clipBounds:bounds")) : rect1;
                        if(!rect2.equals(rect3)) {
                            view0.setClipBounds(rect0);
                            Rect rect4 = new Rect();
                            G g0 = new G();
                            g0.b = rect4;
                            Animator animator0 = ObjectAnimator.ofObject(view0, e0.c, g0, new Rect[]{rect2, rect3});
                            g g1 = new g(view0, rect0, rect1);
                            animator0.addListener(g1);
                            this.a(g1);
                            return animator0;
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override  // androidx.transition.Transition
    public final String[] q() {
        return ChangeClipBounds.b0;
    }

    @Override  // androidx.transition.Transition
    public final boolean t() {
        return true;
    }
}

