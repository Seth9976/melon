package d2;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import com.google.android.material.internal.F;
import com.iloen.melon.utils.player.a;

public final class c {
    public final Object a;
    public final int b;
    public final Class c;
    public final n d;
    public static final c e;
    public static final c f;
    public static final c g;
    public static final c h;
    public static final c i;
    public static final c j;
    public static final c k;
    public static final c l;
    public static final c m;
    public static final c n;
    public static final c o;
    public static final c p;
    public static final c q;
    public static final c r;
    public static final c s;
    public static final c t;
    public static final c u;

    static {
        AccessibilityNodeInfo.AccessibilityAction accessibilityNodeInfo$AccessibilityAction0 = null;
        c.e = new c(1, null);
        c.f = new c(2, null);
        new c(4, null);
        new c(8, null);
        c.g = new c(16, null);
        new c(0x20, null);
        c.h = new c(0x40, null);
        c.i = new c(0x80, null);
        new c(0x100, g.class);
        new c(0x200, g.class);
        new c(0x400, h.class);
        new c(0x800, h.class);
        c.j = new c(0x1000, null);
        c.k = new c(0x2000, null);
        new c(0x4000, null);
        new c(0x8000, null);
        new c(0x10000, null);
        new c(0x20000, l.class);
        c.l = new c(0x40000, null);
        c.m = new c(0x80000, null);
        c.n = new c(0x100000, null);
        new c(0x200000, m.class);
        int v = Build.VERSION.SDK_INT;
        new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, 0x1020036, null, null, null);
        c.o = new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, 0x1020037, null, null, j.class);
        c.p = new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, 0x1020038, null, null, null);
        c.q = new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, 0x1020039, null, null, null);
        c.r = new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, 0x102003A, null, null, null);
        c.s = new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, 0x102003B, null, null, null);
        new c((v < 29 ? null : a.h()), 0x1020046, null, null, null);
        new c((v < 29 ? null : a.x()), 0x1020047, null, null, null);
        new c((v < 29 ? null : a.C()), 0x1020048, null, null, null);
        new c((v < 29 ? null : a.D()), 0x1020049, null, null, null);
        new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, 0x102003C, null, null, null);
        c.t = new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, 0x102003D, null, null, k.class);
        new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, 0x1020042, null, null, i.class);
        new c((v < 28 ? null : com.iloen.melon.utils.system.a.k()), 0x1020044, null, null, null);
        new c((v < 28 ? null : com.iloen.melon.utils.system.a.z()), 0x1020045, null, null, null);
        new c((v < 30 ? null : F.m()), 0x102004A, null, null, null);
        new c((v < 30 ? null : F.A()), 0x1020054, null, null, null);
        new c((v < 0x20 ? null : AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START), 0x1020055, null, null, null);
        new c((v < 0x20 ? null : AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP), 0x1020056, null, null, null);
        new c((v < 0x20 ? null : AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL), 0x1020057, null, null, null);
        new c((v < 33 ? null : com.kakao.sdk.common.util.a.f()), 0x1020058, null, null, null);
        if(v >= 34) {
            accessibilityNodeInfo$AccessibilityAction0 = androidx.core.widget.l.b();
        }
        c.u = new c(accessibilityNodeInfo$AccessibilityAction0, 0x102005E, null, null, null);
    }

    public c(int v, Class class0) {
        this(null, v, null, null, class0);
    }

    public c(int v, String s) {
        this(null, v, s, null, null);
    }

    public c(Object object0, int v, CharSequence charSequence0, n n0, Class class0) {
        this.b = v;
        this.d = n0;
        this.a = object0 == null ? new AccessibilityNodeInfo.AccessibilityAction(v, charSequence0) : object0;
        this.c = class0;
    }

    public final int a() {
        return ((AccessibilityNodeInfo.AccessibilityAction)this.a).getId();
    }

    @Override
    public final boolean equals(Object object0) {
        if(!(object0 instanceof c)) {
            return false;
        }
        Object object1 = ((c)object0).a;
        return this.a == null ? object1 == null : this.a.equals(object1);
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("AccessibilityActionCompat: ");
        String s = d.d(this.b);
        if(s.equals("ACTION_UNKNOWN")) {
            Object object0 = this.a;
            if(((AccessibilityNodeInfo.AccessibilityAction)object0).getLabel() != null) {
                s = ((AccessibilityNodeInfo.AccessibilityAction)object0).getLabel().toString();
            }
        }
        stringBuilder0.append(s);
        return stringBuilder0.toString();
    }
}

