package X;

import P0.f;
import Q0.d1;
import Z4.c;
import a0.b;
import android.os.Trace;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.collection.G;
import androidx.collection.K;
import androidx.collection.L;
import androidx.compose.foundation.E0;
import androidx.compose.foundation.I;
import androidx.compose.foundation.R0;
import androidx.compose.foundation.U;
import androidx.compose.foundation.j;
import androidx.compose.foundation.m;
import androidx.compose.foundation.n;
import androidx.compose.foundation.q0;
import androidx.compose.foundation.v0;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.Q;
import androidx.compose.runtime.S;
import androidx.compose.runtime.Y;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.h0;
import androidx.compose.runtime.o0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.u0;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.tooling.ComposeViewAdapter;
import androidx.lifecycle.r0;
import e3.o;
import f1.A;
import ie.H;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import jd.v;
import k1.d;
import kg.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.flow.Flow;
import ld.h;
import og.g;
import p0.s;
import w0.u;
import we.a;
import x0.e;

public final class k extends r implements a {
    public final int f;
    public final Object g;

    public k(p p0, Y y0) {
        this.f = 10;
        this.g = p0;
        super(0);
    }

    public k(Object object0, int v) {
        this.f = v;
        this.g = object0;
        super(0);
    }

    public k(kg.p p0, long v, q q0, String s) {
        this.f = 20;
        this.g = q0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        long[] arr_v;
        s s3;
        long v17;
        int v16;
        int v15;
        Object[] arr_object1;
        we.k k1;
        L l2;
        Long long0;
        m m0 = null;
        switch(this.f) {
            case 0: {
                ((l)this.g).l = null;
                l.m0(((l)this.g));
                return true;
            }
            case 1: {
                ((Y0.a)this.g).g = null;
                Trace.beginSection("OnPositionedDispatch");
                try {
                    ((Y0.a)this.g).a();
                    return H.a;
                }
                finally {
                    Trace.endSection();
                }
            }
            case 2: {
                return new c[((Flow[])this.g).length];
            }
            case 3: {
                Boolean boolean0 = Boolean.valueOf(!((Boolean)((O0)((a0.a)this.g).i).getValue()).booleanValue());
                ((O0)((a0.a)this.g).i).setValue(boolean0);
                return H.a;
            }
            case 4: {
                f.m(((b)this.g));
                return H.a;
            }
            case 5: {
                ((j)this.g).h.invoke();
                return true;
            }
            case 6: {
                a a0 = ((I)this.g).G;
                if(a0 != null) {
                    a0.invoke();
                }
                return true;
            }
            case 7: {
                return Boolean.valueOf(u.r0(((U)this.g).h));
            }
            case 8: {
                v0 v00 = (v0)this.g;
                if(v00.n0() > v00.m0()) {
                    ((q0)((O0)v00.k).getValue()).getClass();
                    int v1 = v00.n0();
                    return (float)(v00.p0() + v1);
                }
                return null;
            }
            case 9: {
                R0 r00 = (R0)this.g;
                n n0 = (n)f.i(r00, E0.a);
                r00.n = n0;
                if(n0 != null) {
                    m0 = new m(n0.a, n0.b, n0.c, n0.d);
                }
                r00.o = m0;
                return H.a;
            }
            case 10: {
                throw null;
            }
            case 11: {
                ArrayList arrayList0 = ((h0)this.g).a;
                K k0 = new K(arrayList0.size());
                int v2 = arrayList0.size();
                for(int v3 = 0; v3 < v2; ++v3) {
                    S s0 = (S)arrayList0.get(v3);
                    int v4 = s0.a;
                    Q q0 = s0.b == null ? v4 : new Q(v4, s0.b);
                    int v5 = k0.f(q0);
                    Object object0 = v5 >= 0 ? null : k0.c[v5];
                    if(object0 != null) {
                        if(object0 instanceof G) {
                            ((G)object0).a(s0);
                            s0 = (G)object0;
                        }
                        else {
                            G g0 = new G(2);
                            g0.a(object0);
                            g0.a(s0);
                            s0 = g0;
                        }
                    }
                    if(v5 < 0) {
                        k0.b[~v5] = q0;
                        k0.c[~v5] = s0;
                    }
                    else {
                        k0.c[v5] = s0;
                    }
                }
                return new g0.a(k0);
            }
            case 12: {
                u0 u00 = (u0)this.g;
                synchronized(u00.c) {
                    CancellableContinuation cancellableContinuation0 = u00.u();
                    if(((o0)u00.u.getValue()).compareTo(o0.b) > 0) {
                        if(cancellableContinuation0 != null) {
                            cancellableContinuation0.resumeWith(H.a);
                        }
                        return H.a;
                    }
                }
                throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", u00.e);
            }
            case 13: {
                b0.Q q1 = (b0.Q)this.g;
                if(!((Boolean)((O0)q1.j).getValue()).booleanValue()) {
                    a a1 = q1.a;
                    if(a1 != null) {
                        a1.invoke();
                    }
                }
                return H.a;
            }
            case 14: {
                return ((Number)((d0.s)(((d0.q)this.g))).a.d()).floatValue();
            }
            case 15: {
                Object object2 = ((View)((d5.m)this.g).b).getContext().getSystemService("input_method");
                kotlin.jvm.internal.q.e(object2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                return (InputMethodManager)object2;
            }
            case 16: {
                return new BaseInputConnection(((A)this.g).a, false);
            }
            case 17: {
                return (r0)((ed.f)this.g).invoke();
            }
            case 18: {
                return (r0)((v)this.g).invoke();
            }
            case 19: {
                d d0 = (d)this.g;
                b0 b00 = d0.c;
                if(((e)((O0)b00).getValue()).a != 0x7FC000007FC00000L && !e.e(((e)((O0)b00).getValue()).a)) {
                    long v7 = ((e)((O0)b00).getValue()).a;
                    return d0.a.b(v7);
                }
                return null;
            }
            case 20: {
                q q2 = (q)this.g;
                throw null;
            }
            case 21: {
                synchronized(l2.Q.e) {
                    String s1 = ((File)this.g).getAbsolutePath();
                    l2.Q.d.remove(s1);
                    return H.a;
                }
            }
            case 22: {
                return (r0)((h)this.g).invoke();
            }
            case 23: {
                View view0 = ((ComposeViewAdapter)this.g).getChildAt(0);
                kotlin.jvm.internal.q.e(view0, "null cannot be cast to non-null type androidx.compose.ui.platform.ComposeView");
                View view1 = ((ComposeView)view0).getChildAt(0);
                if(view1 instanceof d1) {
                    m0 = (d1)view1;
                }
                if(m0 != null) {
                    Q0.u.n(((Q0.u)m0).getRoot());
                }
                synchronized(p0.m.b) {
                    L l0 = p0.m.i.h;
                    boolean z = l0 != null && l0.h();
                }
                if(z) {
                    p0.m.a();
                }
                return H.a;
            }
            case 24: {
                n1.q q3 = (n1.q)this.g;
                Iterator iterator0 = je.p.A0(je.p.A0(je.p.A0(q3.a.values(), q3.b.values()), q3.c.values()), q3.e.values()).iterator();
                if(iterator0.hasNext()) {
                    Object object3 = iterator0.next();
                    long0 = ((o1.b)object3).a();
                    while(iterator0.hasNext()) {
                        Object object4 = iterator0.next();
                        Long long1 = ((o1.b)object4).a();
                        if(long0.compareTo(long1) < 0) {
                            long0 = long1;
                        }
                    }
                }
                else {
                    long0 = null;
                }
                long v10 = 0L;
                long v11 = long0 == null ? 0L : ((long)long0);
                Iterator iterator1 = q3.d.values().iterator();
                if(iterator1.hasNext()) {
                    Object object5 = iterator1.next();
                    Long long2 = ((o1.c)object5).c();
                    while(true) {
                        m0 = long2;
                    label_153:
                        if(!iterator1.hasNext()) {
                            break;
                        }
                        Object object6 = iterator1.next();
                        Long long3 = ((o1.c)object6).c();
                        if(((Long)m0).compareTo(long3) < 0) {
                            long2 = long3;
                            continue;
                        }
                        if(false) {
                            break;
                        }
                        goto label_153;
                    }
                }
                if(m0 != null) {
                    v10 = (long)(((Long)m0));
                }
                return Math.max(v11, v10);
            }
            case 25: {
                o0.b b0 = (o0.b)this.g;
                o0.l l1 = b0.a;
                Object object7 = b0.d;
                if(object7 == null) {
                    throw new IllegalArgumentException("Value should be initialized");
                }
                return l1.a(b0, object7);
            }
            case 26: {
                jg.e e0 = new jg.e("GET", "", "HTTP/1.1");
                o o0 = new o(e0, new mg.d(e0, null));
                mg.f f0 = new mg.f(o0, new mg.e(o0, null));
                e0.a = "M-SEARCH";
                e0.b = "*";
                f0.h("HOST", ((g)this.g).c.f.c);
                f0.h("MAN", "\"ssdp:discover\"");
                f0.h("MX", "1");
                f0.h("ST", "ssdp:all");
                return f0;
            }
            case 27: {
                do {
                    s s2 = (s)this.g;
                    Object object8 = s2.g;
                    synchronized(object8) {
                        if(!s2.c) {
                            s2.c = true;
                            Object[] arr_object = s2.f.a;
                            int v13 = s2.f.c;
                            int v14 = 0;
                            while(v14 < v13) {
                                try {
                                    p0.r r0 = (p0.r)arr_object[v14];
                                    l2 = r0.g;
                                    k1 = r0.a;
                                    arr_object1 = l2.b;
                                    arr_v = l2.a;
                                    v15 = arr_v.length - 2;
                                    if(v15 >= 0) {
                                        v16 = 0;
                                        while(true) {
                                            v17 = arr_v[v16];
                                            s3 = s2;
                                            goto label_203;
                                        }
                                    }
                                    else {
                                        goto label_217;
                                    }
                                    goto label_218;
                                }
                                catch(Throwable throwable0) {
                                    s3 = s2;
                                    s3.c = false;
                                    throw throwable0;
                                }
                            label_203:
                                if((~v17 << 7 & v17 & 0x8080808080808080L) == 0x8080808080808080L) {
                                    goto label_213;
                                }
                                int v18 = 8 - (~(v16 - v15) >>> 0x1F);
                                try {
                                    for(int v19 = 0; v19 < v18; ++v19) {
                                        if((v17 & 0xFFL) < 0x80L) {
                                            k1.invoke(arr_object1[(v16 << 3) + v19]);
                                        }
                                        v17 >>= 8;
                                    }
                                    if(v18 == 8) {
                                    label_213:
                                        if(v16 != v15) {
                                            ++v16;
                                            s2 = s3;
                                            v17 = arr_v[v16];
                                            s3 = s2;
                                            goto label_203;
                                        label_217:
                                            s3 = s2;
                                        }
                                    }
                                label_218:
                                    l2.b();
                                    ++v14;
                                    s2 = s3;
                                    continue;
                                }
                                catch(Throwable throwable0) {
                                }
                                s3.c = false;
                                throw throwable0;
                            }
                            s2.c = false;
                        }
                    }
                }
                while(s.a(((s)this.g)));
                return H.a;
            }
            case 28: {
                v1.m m1 = (v1.m)this.g;
                N0.v v20 = m1.getParentLayoutCoordinates();
                if(v20 != null && v20.h()) {
                    m0 = v20;
                }
                return m0 == null || m1.getPopupContentSize-bOM6tXw() == null ? false : true;
            }
            default: {
                ((u)this.g).n0();
                return H.a;
            }
        }
    }
}

