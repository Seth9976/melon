package W;

import B0.b;
import F.g;
import I.l0;
import U.E;
import a1.Q;
import a1.T;
import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.ExtractedText;
import f1.j;
import f1.p;
import f1.x;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import x0.c;
import ye.a;

public final class f extends t {
    public Job b;
    public w c;
    public MutableSharedFlow d;

    @Override  // f1.r
    public final void a() {
        this.k(null);
    }

    @Override  // f1.r
    public final void b() {
        Job job0 = this.b;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        this.b = null;
        MutableSharedFlow mutableSharedFlow0 = this.j();
        if(mutableSharedFlow0 != null) {
            mutableSharedFlow0.resetReplayCache();
        }
    }

    @Override  // f1.r
    public final void c(c c0) {
        w w0 = this.c;
        if(w0 != null) {
            w0.l = new Rect(a.V(c0.a), a.V(c0.b), a.V(c0.c), a.V(c0.d));
            if(w0.j.isEmpty()) {
                Rect rect0 = w0.l;
                if(rect0 != null) {
                    Rect rect1 = new Rect(rect0);
                    w0.a.requestRectangleOnScreen(rect1);
                }
            }
        }
    }

    @Override  // f1.r
    public final void e(x x0, p p0, Q q0, b b0, c c0, c c1) {
        w w0 = this.c;
        if(w0 != null) {
            s s0 = w0.m;
            synchronized(s0.c) {
                s0.j = x0;
                s0.l = p0;
                s0.k = q0;
                s0.m = c0;
                s0.n = c1;
                if(s0.e || s0.d) {
                    s0.a();
                }
            }
        }
    }

    @Override  // f1.r
    public final void f(x x0, j j0, g g0, E e0) {
        this.k(new l0(x0, this, j0, g0, e0, 2));
    }

    @Override  // f1.r
    public final void h(x x0, x x1) {
        w w0 = this.c;
        if(w0 != null) {
            boolean z = !T.a(w0.h.b, x1.b) || !q.b(w0.h.c, x1.c);
            w0.h = x1;
            int v1 = w0.j.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                W.x x2 = (W.x)((WeakReference)w0.j.get(v2)).get();
                if(x2 != null) {
                    x2.g = x1;
                }
            }
            synchronized(w0.m.c) {
                w0.m.j = null;
                w0.m.l = null;
                w0.m.k = null;
                w0.m.m = null;
                w0.m.n = null;
            }
            int v3 = -1;
            if(!q.b(x0, x1)) {
                if(x0 != null && (!q.b(x0.a.b, x1.a.b) || T.a(x0.b, x1.b) && !q.b(x0.c, x1.c))) {
                    w0.b.g().restartInput(((View)w0.b.a));
                    return;
                }
                int v7 = w0.j.size();
                for(int v = 0; v < v7; ++v) {
                    W.x x3 = (W.x)((WeakReference)w0.j.get(v)).get();
                    if(x3 != null) {
                        x x4 = w0.h;
                        W.p p1 = w0.b;
                        if(x3.k) {
                            x3.g = x4;
                            if(x3.i) {
                                int v8 = x3.h;
                                ExtractedText extractedText0 = B.a.i(x4);
                                p1.g().updateExtractedText(((View)p1.a), v8, extractedText0);
                            }
                            p1.g().updateSelection(((View)p1.a), T.e(x4.b), T.d(x4.b), (x4.c == null ? -1 : T.e(x4.c.a)), (x4.c == null ? -1 : T.d(x4.c.a)));
                        }
                    }
                }
            }
            else if(z) {
                W.p p0 = w0.b;
                int v4 = T.e(x1.b);
                int v5 = T.d(x1.b);
                T t0 = w0.h.c;
                int v6 = t0 == null ? -1 : T.e(t0.a);
                T t1 = w0.h.c;
                if(t1 != null) {
                    v3 = T.d(t1.a);
                }
                p0.g().updateSelection(((View)p0.a), v4, v5, v6, v3);
            }
        }
    }

    public final MutableSharedFlow j() {
        MutableSharedFlow mutableSharedFlow0 = this.d;
        if(mutableSharedFlow0 != null) {
            return mutableSharedFlow0;
        }
        if(!V.c.a) {
            return null;
        }
        MutableSharedFlow mutableSharedFlow1 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_LATEST, 2, null);
        this.d = mutableSharedFlow1;
        return mutableSharedFlow1;
    }

    public final void k(l0 l00) {
        r r0 = this.a;
        if(r0 == null) {
            return;
        }
        Job job0 = null;
        e e0 = new e(l00, this, r0, null);
        if(r0.isAttached()) {
            CoroutineScope coroutineScope0 = r0.getCoroutineScope();
            W.q q0 = new W.q(r0, e0, null);
            job0 = BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, CoroutineStart.UNDISPATCHED, q0, 1, null);
        }
        this.b = job0;
    }
}

