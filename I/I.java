package I;

import B7.b;
import Ce.g;
import N0.L;
import O.F;
import O.j;
import O.k;
import P0.j0;
import Q.w;
import Q0.X0;
import Q0.Y0;
import U.u;
import Y.Q;
import android.net.ConnectivityManager;
import androidx.collection.z;
import androidx.compose.runtime.A0;
import androidx.compose.runtime.E;
import androidx.compose.runtime.Y;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AbstractComposeView;
import d5.f;
import g0.e;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import we.a;
import x0.c;
import x1.m;
import x1.s;

public final class i extends r implements a {
    public final int f;
    public final Object g;
    public final Object h;
    public final Object i;

    public i(p p0, f0.a a0, A0 a00, Y y0) {
        this.f = 8;
        this.g = p0;
        this.h = a0;
        this.i = a00;
        super(0);
    }

    public i(Object object0, Object object1, Object object2, int v) {
        this.f = v;
        this.g = object0;
        this.h = object1;
        this.i = object2;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                H h1 = H.a;
                l l0 = (l)this.g;
                I.a a0 = l0.e;
                while(true) {
                    e e0 = a0.a;
                    int v2 = e0.c;
                    if(v2 == 0) {
                        break;
                    }
                    c c0 = (c)((h)e0.a[v2 - 1]).a.invoke();
                    if(!(c0 == null ? true : l0.o0(c0, l0.i))) {
                        break;
                    }
                    ((h)a0.a.k(a0.a.c - 1)).b.resumeWith(h1);
                }
                if(l0.g) {
                    c c1 = l0.n0();
                    if(c1 != null && l0.o0(c1, l0.i)) {
                        l0.g = false;
                    }
                }
                ((K1)this.h).e = l.m0(l0, ((d)this.i));
                return h1;
            }
            case 1: {
                j j1 = (j)((E)this.g).getValue();
                b b0 = new b(((g)((F)this.h).d.f.getValue()), j1);
                return new k(((F)this.h), j1, ((O.d)this.i), b0);
            }
            case 2: {
                return new w(((we.p)((b0)this.g).getValue()), ((we.k)((b0)this.h).getValue()), ((Number)((a)this.i).invoke()).intValue());
            }
            case 3: {
                ((AbstractComposeView)this.g).removeOnAttachStateChangeListener(((X0)this.h));
                q.g(((Y0)this.i), "listener");
                e.k.t(((AbstractComposeView)this.g)).a.remove(((Y0)this.i));
                return H.a;
            }
            case 4: {
                R.h h2 = (R.h)this.g;
                c c2 = R.h.m0(h2, ((j0)this.h), ((G.g)this.i));
                if(c2 != null) {
                    l l1 = h2.a;
                    if(r1.l.b(l1.i, 0L)) {
                        L.a.c("Expected BringIntoViewRequester to not be used before parents are placed.");
                    }
                    return c2.h(l1.q0(c2, l1.i) ^ 0x8000000080000000L);
                }
                return null;
            }
            case 5: {
                u u0 = new u(((b0)this.h), ((Q)this.i), null);
                BuildersKt__Builders_commonKt.launch$default(((CoroutineScope)this.g), null, CoroutineStart.UNDISPATCHED, u0, 1, null);
                return H.a;
            }
            case 6: {
                if(((C)this.g).a) {
                    U4.w.e().a("WM-WorkConstraintsTrack", "NetworkRequestConstraintController unregister callback");
                    ((ConnectivityManager)this.h).unregisterNetworkCallback(((Z4.d)this.i));
                }
                return H.a;
            }
            case 7: {
                Object object1 = Z4.k.b;
                ConnectivityManager connectivityManager0 = (ConnectivityManager)this.h;
                Z4.k k0 = (Z4.k)this.i;
                synchronized(object1) {
                    Z4.k.c.remove(((Z4.e)this.g));
                    if(Z4.k.c.isEmpty()) {
                        U4.w.e().a("WM-WorkConstraintsTrack", "NetworkRequestConstraintController unregister shared callback");
                        connectivityManager0.unregisterNetworkCallback(k0);
                    }
                    return H.a;
                }
            }
            case 8: {
                p p0 = (p)this.g;
                f0.b b1 = p0.L;
                f0.a a1 = (f0.a)this.h;
                A0 a00 = (A0)this.i;
                f0.a a2 = b1.b;
                try {
                    b1.b = a1;
                    A0 a01 = p0.F;
                    int[] arr_v = p0.n;
                    z z0 = p0.u;
                    p0.n = null;
                    p0.u = null;
                    try {
                        p0.F = a00;
                        boolean z1 = b1.e;
                        try {
                            b1.e = false;
                            throw null;
                        }
                        catch(Throwable throwable2) {
                            b1.e = z1;
                            throw throwable2;
                        }
                    }
                    catch(Throwable throwable1) {
                        p0.F = a01;
                        p0.n = arr_v;
                        p0.u = z0;
                        throw throwable1;
                    }
                }
                catch(Throwable throwable0) {
                    b1.b = a2;
                    throw throwable0;
                }
            }
            default: {
                List list0 = (List)this.g;
                m m0 = (m)this.h;
                x1.j j0 = m0.a;
                int v = list0.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    Object object0 = ((L)list0.get(v1)).q();
                    x1.h h0 = object0 instanceof x1.h ? ((x1.h)object0) : null;
                    if(h0 != null) {
                        B1.g g0 = j0.a(h0.a);
                        x1.d d0 = new x1.d(h0.a.c, g0);
                        h0.b.invoke(d0);
                    }
                    m0.f.add(h0);
                }
                d5.m m1 = new d5.m(1);
                f.S(j0.a, ((s)this.i), m1);
                return H.a;
            }
        }
    }
}

