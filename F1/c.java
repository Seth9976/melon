package f1;

import Gd.e;
import P4.a;
import Q0.u;
import a1.Q;
import a1.T;
import a1.t;
import a1.y;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo.Builder;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.InputMethodManager;
import d5.m;
import ie.j;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.k;
import y0.F;
import y0.M;

public final class c {
    public final u a;
    public final m b;
    public final Object c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public x j;
    public Q k;
    public p l;
    public r m;
    public x0.c n;
    public x0.c o;
    public final CursorAnchorInfo.Builder p;
    public final float[] q;
    public final Matrix r;

    public c(u u0, m m0) {
        this.a = u0;
        this.b = m0;
        this.c = new Object();
        this.m = b.h;
        this.p = new CursorAnchorInfo.Builder();
        this.q = F.a();
        this.r = new Matrix();
    }

    public final void a() {
        CursorAnchorInfo.Builder cursorAnchorInfo$Builder1;
        Object object0 = this.b.c;
        InputMethodManager inputMethodManager0 = (InputMethodManager)((j)object0).getValue();
        View view0 = (View)this.b.b;
        if(!inputMethodManager0.isActive(((View)this.b.b))) {
            return;
        }
        ((k)this.m).invoke(new F(this.q));
        this.a.s(this.q);
        M.r(this.r, this.q);
        x x0 = this.j;
        q.d(x0);
        p p0 = this.l;
        q.d(p0);
        Q q0 = this.k;
        q.d(q0);
        y y0 = q0.b;
        x0.c c0 = this.n;
        q.d(c0);
        float f = c0.d;
        float f1 = c0.b;
        x0.c c1 = this.o;
        q.d(c1);
        boolean z = this.f;
        boolean z1 = this.g;
        boolean z2 = this.h;
        boolean z3 = this.i;
        CursorAnchorInfo.Builder cursorAnchorInfo$Builder0 = this.p;
        cursorAnchorInfo$Builder0.reset();
        cursorAnchorInfo$Builder0.setMatrix(this.r);
        T t0 = x0.c;
        int v = T.e(x0.b);
        cursorAnchorInfo$Builder0.setSelectionRange(v, T.d(x0.b));
        if(z && v >= 0) {
            int v1 = p0.t(v);
            x0.c c2 = q0.c(v1);
            float f2 = a.i(c2.a, 0.0f, ((int)(q0.c >> 0x20)));
            boolean z4 = e1.u.p(c0, f2, c2.b);
            boolean z5 = e1.u.p(c0, f2, c2.d);
            boolean z6 = q0.a(v1) == l1.j.b;
            int v2 = z4 || z5 ? 1 : 0;
            if(!z4 || !z5) {
                v2 |= 2;
            }
            if(z6) {
                v2 |= 4;
            }
            cursorAnchorInfo$Builder0.setInsertionMarkerLocation(f2, c2.b, c2.d, c2.d, v2);
        }
        cursorAnchorInfo$Builder1 = cursorAnchorInfo$Builder0;
        int v3 = -1;
        if(z1) {
            int v4 = t0 == null ? -1 : T.e(t0.a);
            if(t0 != null) {
                v3 = T.d(t0.a);
            }
            if(v4 >= 0 && v4 < v3) {
                cursorAnchorInfo$Builder1.setComposingText(v4, x0.a.b.subSequence(v4, v3));
                int v5 = p0.t(v4);
                int v6 = p0.t(v3);
                float[] arr_f = new float[(v6 - v5) * 4];
                y0.a(t.b(v5, v6), arr_f);
                while(v4 < v3) {
                    int v7 = p0.t(v4);
                    int v8 = (v7 - v5) * 4;
                    float f3 = arr_f[v8];
                    float f4 = arr_f[v8 + 1];
                    float f5 = arr_f[v8 + 2];
                    float f6 = arr_f[v8 + 3];
                    int v9 = c0.a < f5 ? 1 : 0;
                    int v10 = f3 < c0.c ? 1 : 0;
                    int v11 = f1 < f6 ? 1 : 0;
                    int v12 = f4 < f ? 1 : 0;
                    int v13 = e1.u.p(c0, f3, f4) && e1.u.p(c0, f5, f6) ? v9 & v10 & v11 & v12 : v9 & v10 & v11 & v12 | 2;
                    if(q0.a(v7) == l1.j.b) {
                        v13 |= 4;
                    }
                    cursorAnchorInfo$Builder1.addCharacterBounds(v4, f3, f4, f5, f6, v13);
                    ++v4;
                }
            }
        }
        int v14 = Build.VERSION.SDK_INT;
        if(v14 >= 33 && z2) {
            cursorAnchorInfo$Builder1.setEditorBoundsInfo(e.i().setEditorBounds(M.x(c1)).setHandwritingBounds(M.x(c1)).build());
        }
        if(v14 >= 34 && z3 && !c0.e()) {
            int v15 = y0.e(f1);
            int v16 = y0.e(f);
            if(v15 <= v16) {
                while(true) {
                    cursorAnchorInfo$Builder1.addVisibleLineBounds(q0.e(v15), y0.f(v15), q0.f(v15), y0.b(v15));
                    if(v15 == v16) {
                        break;
                    }
                    ++v15;
                }
            }
        }
        CursorAnchorInfo cursorAnchorInfo0 = cursorAnchorInfo$Builder1.build();
        ((InputMethodManager)((j)object0).getValue()).updateCursorAnchorInfo(view0, cursorAnchorInfo0);
        this.e = false;
    }
}

