package Q0;

import P0.I;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import c2.b;
import d2.d;
import u1.i;

public final class k extends b {
    public final u a;
    public final I b;
    public final u c;

    public k(u u0, I i0, u u1) {
        this.a = u0;
        this.b = i0;
        this.c = u1;
        super();
    }

    @Override  // c2.b
    public final void onInitializeAccessibilityNodeInfo(View view0, d d0) {
        Integer integer0;
        super.onInitializeAccessibilityNodeInfo(view0, d0);
        AccessibilityNodeInfo accessibilityNodeInfo0 = d0.a;
        u u0 = this.a;
        C c0 = u0.r;
        if(c0.l()) {
            accessibilityNodeInfo0.setVisibleToUser(false);
        }
        I i0 = this.b;
        I i1;
        for(i1 = i0.u(); true; i1 = i1.u()) {
            integer0 = null;
            if(i1 == null) {
                i1 = null;
                break;
            }
            if(i1.b0.e(8)) {
                break;
            }
        }
        if(i1 != null) {
            integer0 = i1.b;
        }
        if(integer0 == null || ((int)integer0) == u0.getSemanticsOwner().a().g) {
            integer0 = -1;
        }
        int v = (int)integer0;
        d0.b = v;
        u u1 = this.c;
        accessibilityNodeInfo0.setParent(u1, v);
        int v1 = i0.b;
        int v2 = c0.B.d(v1);
        if(v2 != -1) {
            i i2 = N.v(u0.getAndroidViewsHandler$ui_release(), v2);
            if(i2 == null) {
                accessibilityNodeInfo0.setTraversalBefore(u1, v2);
            }
            else {
                accessibilityNodeInfo0.setTraversalBefore(i2);
            }
            u.b(u0, v1, accessibilityNodeInfo0, c0.D);
        }
        int v3 = c0.C.d(v1);
        if(v3 != -1) {
            i i3 = N.v(u0.getAndroidViewsHandler$ui_release(), v3);
            if(i3 == null) {
                accessibilityNodeInfo0.setTraversalAfter(u1, v3);
            }
            else {
                accessibilityNodeInfo0.setTraversalAfter(i3);
            }
            u.b(u0, v1, accessibilityNodeInfo0, c0.E);
        }
    }
}

