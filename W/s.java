package W;

import Gd.e;
import N0.v;
import P4.a;
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
import androidx.compose.runtime.O0;
import f1.x;
import kotlin.jvm.internal.q;
import l1.j;
import y0.F;
import y0.M;

public final class s {
    public final c a;
    public final p b;
    public final Object c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public x j;
    public Q k;
    public f1.p l;
    public x0.c m;
    public x0.c n;
    public final CursorAnchorInfo.Builder o;
    public final float[] p;
    public final Matrix q;

    public s(c c0, p p0) {
        this.a = c0;
        this.b = p0;
        this.c = new Object();
        this.o = new CursorAnchorInfo.Builder();
        this.p = F.a();
        this.q = new Matrix();
    }

    public final void a() {
        CursorAnchorInfo.Builder cursorAnchorInfo$Builder1;
        p p0 = this.b;
        InputMethodManager inputMethodManager0 = p0.g();
        View view0 = (View)p0.a;
        if(inputMethodManager0.isActive(view0) && this.j != null && this.l != null && this.k != null && this.m != null && this.n != null) {
            float[] arr_f = this.p;
            F.d(arr_f);
            v v0 = (v)((O0)this.a.b.d).getValue();
            if(v0 != null) {
                if(!v0.h()) {
                    v0 = null;
                }
                if(v0 != null) {
                    v0.K(arr_f);
                }
            }
            x0.c c0 = this.n;
            q.d(c0);
            x0.c c1 = this.n;
            q.d(c1);
            F.f(arr_f, -c0.a, -c1.b);
            M.r(this.q, arr_f);
            x x0 = this.j;
            q.d(x0);
            f1.p p1 = this.l;
            q.d(p1);
            Q q0 = this.k;
            q.d(q0);
            y y0 = q0.b;
            x0.c c2 = this.m;
            q.d(c2);
            float f = c2.d;
            float f1 = c2.b;
            x0.c c3 = this.n;
            q.d(c3);
            boolean z = this.f;
            boolean z1 = this.g;
            boolean z2 = this.h;
            boolean z3 = this.i;
            CursorAnchorInfo.Builder cursorAnchorInfo$Builder0 = this.o;
            cursorAnchorInfo$Builder0.reset();
            cursorAnchorInfo$Builder0.setMatrix(this.q);
            T t0 = x0.c;
            int v1 = T.e(x0.b);
            cursorAnchorInfo$Builder0.setSelectionRange(v1, T.d(x0.b));
            if(z && v1 >= 0) {
                int v2 = p1.t(v1);
                x0.c c4 = q0.c(v2);
                float f2 = a.i(c4.a, 0.0f, ((int)(q0.c >> 0x20)));
                boolean z4 = ye.a.x(c2, f2, c4.b);
                boolean z5 = ye.a.x(c2, f2, c4.d);
                boolean z6 = q0.a(v2) == j.b;
                int v3 = z4 || z5 ? 1 : 0;
                if(!z4 || !z5) {
                    v3 |= 2;
                }
                if(z6) {
                    v3 |= 4;
                }
                cursorAnchorInfo$Builder0.setInsertionMarkerLocation(f2, c4.b, c4.d, c4.d, v3);
            }
            cursorAnchorInfo$Builder1 = cursorAnchorInfo$Builder0;
            int v4 = -1;
            if(z1) {
                int v5 = t0 == null ? -1 : T.e(t0.a);
                if(t0 != null) {
                    v4 = T.d(t0.a);
                }
                if(v5 >= 0 && v5 < v4) {
                    cursorAnchorInfo$Builder1.setComposingText(v5, x0.a.b.subSequence(v5, v4));
                    int v6 = p1.t(v5);
                    int v7 = p1.t(v4);
                    float[] arr_f1 = new float[(v7 - v6) * 4];
                    y0.a(t.b(v6, v7), arr_f1);
                    while(v5 < v4) {
                        int v8 = p1.t(v5);
                        int v9 = (v8 - v6) * 4;
                        float f3 = arr_f1[v9];
                        float f4 = arr_f1[v9 + 1];
                        float f5 = arr_f1[v9 + 2];
                        float f6 = arr_f1[v9 + 3];
                        int v10 = c2.a < f5 ? 1 : 0;
                        int v11 = f3 < c2.c ? 1 : 0;
                        int v12 = f1 < f6 ? 1 : 0;
                        int v13 = f4 < f ? 1 : 0;
                        int v14 = ye.a.x(c2, f3, f4) && ye.a.x(c2, f5, f6) ? v10 & v11 & v12 & v13 : v10 & v11 & v12 & v13 | 2;
                        if(q0.a(v8) == j.b) {
                            v14 |= 4;
                        }
                        cursorAnchorInfo$Builder1.addCharacterBounds(v5, f3, f4, f5, f6, v14);
                        ++v5;
                    }
                }
            }
            int v15 = Build.VERSION.SDK_INT;
            if(v15 >= 33 && z2) {
                cursorAnchorInfo$Builder1.setEditorBoundsInfo(e.i().setEditorBounds(M.x(c3)).setHandwritingBounds(M.x(c3)).build());
            }
            if(v15 >= 34 && z3 && !c2.e()) {
                int v16 = y0.e(f1);
                int v17 = y0.e(f);
                if(v16 <= v17) {
                    while(true) {
                        cursorAnchorInfo$Builder1.addVisibleLineBounds(q0.e(v16), y0.f(v16), q0.f(v16), y0.b(v16));
                        if(v16 == v17) {
                            break;
                        }
                        ++v16;
                    }
                }
            }
            CursorAnchorInfo cursorAnchorInfo0 = cursorAnchorInfo$Builder1.build();
            p0.g().updateCursorAnchorInfo(view0, cursorAnchorInfo0);
            this.e = false;
        }
    }
}

