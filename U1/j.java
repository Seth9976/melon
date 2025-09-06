package u1;

import F.Q;
import F.i;
import J2.f;
import P0.v;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.foundation.w;
import androidx.compose.runtime.V;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import e1.F;
import gd.y1;
import r0.n;
import r0.q;
import w0.u;
import we.k;
import we.o;
import x0.c;

public abstract class j {
    public static final F a;

    static {
        j.a = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static final void a(o o0, q q0, k k0, l l0, int v, int v1) {
        k k2;
        q q2;
        ((p)l0).c0(-1985291610);
        int v2 = (v & 6) == 0 ? v | (((p)l0).i(o0) ? 4 : 2) : v;
        if((v1 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((v & 0x30) == 0) {
            v2 |= (((p)l0).g(q0) ? 0x20 : 16);
        }
        int v3 = (v1 & 4) == 0 ? v2 | (((p)l0).i(k0) ? 0x100 : 0x80) : v2 | 0x180;
        if(((p)l0).Q(v3 & 1, (v3 & 0x93) != 0x92)) {
            q q1 = (v1 & 2) == 0 ? q0 : n.a;
            k k1 = (v1 & 4) == 0 ? k0 : a.g;
            j.b(o0, q1, null, k1, ((p)l0), v3 & 14 | 0x180 | v3 & 0x70 | v3 << 6 & 0xE000);
            q2 = q1;
            k2 = k1;
        }
        else {
            ((p)l0).T();
            q2 = q0;
            k2 = k0;
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new f(v, v1, 3, k2, o0, q2);
        }
    }

    public static final void b(o o0, q q0, k k0, k k1, l l0, int v) {
        k k2;
        p p0 = (p)l0;
        p0.c0(509101952);
        int v1 = (v & 6) == 0 ? (p0.i(o0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.g(q0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.i(null) ? 0x100 : 0x80);
        }
        int v2 = (v & 0x6000) == 0 ? v1 | 0xC00 | (p0.i(k1) ? 0x4000 : 0x2000) : v1 | 0xC00;
        boolean z = false;
        if(p0.Q(v2 & 1, (v2 & 9363) != 9362)) {
            k2 = a.h;
            View view0 = (View)p0.k(AndroidCompositionLocals_androidKt.f);
            boolean z1 = p0.g(view0);
            I i0 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(z1 || i0 == v3) {
                try {
                    I i1 = l0.F(view0);
                    i0 = null;
                    if(i1 != null) {
                        i0 = i1;
                    }
                }
                catch(IllegalStateException unused_ex) {
                }
                p0.l0(i0);
            }
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            boolean z2 = p0.i(i0);
            y1 y10 = p0.N();
            if((v2 & 14) == 4 || z2 || y10 == v3) {
                y10 = new y1(26, i0, o0);
                p0.l0(y10);
            }
            p0.a0(0x5AFB85A8);
            p0.p(false);
            boolean z3 = p0.i(i0);
            boolean z4 = p0.i(context0);
            y1 y11 = p0.N();
            if(((v2 & 0x1C00) == 0x800 | z3 | z4) != 0 || y11 == v3) {
                y11 = new y1(27, i0, context0);
                p0.l0(y11);
            }
            if((0xE000 & v2) == 0x4000) {
                z = true;
            }
            Q q1 = p0.N();
            if(z || q1 == v3) {
                q1 = new Q(4, k1);
                p0.l0(q1);
            }
            androidx.compose.ui.viewinterop.a.b(y10, q0, null, y11, q1, p0, v2 & 0x70, 0);
        }
        else {
            p0.T();
            k2 = k0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new i(o0, q0, k2, k1, v, 4);
        }
    }

    public static final boolean c(View view0, View view1) {
        for(ViewParent viewParent0 = view1.getParent(); viewParent0 != null; viewParent0 = viewParent0.getParent()) {
            if(viewParent0 == view0.getParent()) {
                return true;
            }
        }
        return false;
    }

    public static final Rect d(w0.j j0, View view0, View view1) {
        int[] arr_v = new int[2];
        view0.getLocationOnScreen(arr_v);
        int[] arr_v1 = new int[2];
        view1.getLocationOnScreen(arr_v1);
        u u0 = w0.f.g(((w0.k)j0).f);
        c c0 = u0 == null ? null : w0.f.j(u0);
        if(c0 == null) {
            return null;
        }
        int v = arr_v[0];
        int v1 = arr_v1[0];
        int v2 = arr_v[1];
        return new Rect(((int)c0.a) + v - v1, ((int)c0.b) + v2 - arr_v1[1], ((int)c0.c) + v - v1, ((int)c0.d) + v2 - arr_v1[1]);
    }

    public static final View e(r0.p p0) {
        u1.o o0 = P0.f.v(p0.getNode()).o;
        View view0 = o0 == null ? null : o0.getInteropView();
        if(view0 == null) {
            throw new IllegalStateException("Could not fetch interop view");
        }
        return view0;
    }

    public static final void f(u1.o o0, P0.I i0) {
        long v = ((v)i0.b0.c).j0(0L);
        int v1 = Math.round(Float.intBitsToFloat(((int)(v >> 0x20))));
        int v2 = Math.round(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))));
        o0.layout(v1, v2, o0.getMeasuredWidth() + v1, o0.getMeasuredHeight() + v2);
    }

    public static final void g(ViewGroup viewGroup0, w w0) {
        if(viewGroup0 instanceof FragmentContainerView) {
            w0.invoke(viewGroup0);
            return;
        }
        int v = viewGroup0.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = viewGroup0.getChildAt(v1);
            if(view0 instanceof ViewGroup) {
                j.g(((ViewGroup)view0), w0);
            }
        }
    }
}

