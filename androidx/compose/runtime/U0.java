package androidx.compose.runtime;

import G.g;
import Ua.h;
import X.k;
import android.util.Log;
import androidx.collection.K;
import androidx.collection.L;
import androidx.compose.foundation.S;
import androidx.compose.foundation.w;
import ea.b;
import ie.H;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import je.u;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import m0.c;
import me.i;
import ne.a;
import p0.d;
import p0.m;

public final class u0 extends s {
    public long a;
    public final e b;
    public final Object c;
    public Job d;
    public Throwable e;
    public final ArrayList f;
    public Object g;
    public L h;
    public final g0.e i;
    public final ArrayList j;
    public final ArrayList k;
    public final K l;
    public final b m;
    public final K n;
    public final K o;
    public ArrayList p;
    public LinkedHashSet q;
    public CancellableContinuationImpl r;
    public h s;
    public boolean t;
    public final MutableStateFlow u;
    public final CompletableJob v;
    public final i w;
    public final V x;
    public static final MutableStateFlow y;
    public static final AtomicReference z;

    static {
        u0.y = StateFlowKt.MutableStateFlow(k0.b.d);
        u0.z = new AtomicReference(Boolean.FALSE);
    }

    public u0(i i0) {
        e e0 = new e(new k(this, 12));
        this.b = e0;
        this.c = new Object();
        this.f = new ArrayList();
        this.h = new L();
        this.i = new g0.e(new v[16]);
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new K();
        this.m = new b(5);
        this.n = new K();
        this.o = new K();
        this.u = StateFlowKt.MutableStateFlow(o0.c);
        new AtomicReference(c.b);
        CompletableJob completableJob0 = JobKt.Job(((Job)i0.get(Job.Key)));
        completableJob0.invokeOnCompletion(new w(this, 7));
        this.v = completableJob0;
        this.w = i0.plus(e0).plus(completableJob0);
        this.x = new V(9);
    }

    public final void A(Throwable throwable0, v v0) {
        h h0;
        if(((Boolean)u0.z.get()).booleanValue() && !(throwable0 instanceof j)) {
            synchronized(this.c) {
                Log.e("ComposeInternal", "Error was captured in composition while live edit was enabled.", throwable0);
                this.j.clear();
                this.i.g();
                this.h = new L();
                this.k.clear();
                this.l.a();
                this.n.a();
                this.s = new h(throwable0);
                if(v0 != null) {
                    this.B(v0);
                }
                this.u();
            }
            return;
        }
        synchronized(this.c) {
            h0 = this.s;
            if(h0 == null) {
                this.s = new h(throwable0);
                throw throwable0;
            }
        }
        throw (Throwable)h0.a;
    }

    public final void B(v v0) {
        ArrayList arrayList0 = this.p;
        if(arrayList0 == null) {
            arrayList0 = new ArrayList();
            this.p = arrayList0;
        }
        if(!arrayList0.contains(v0)) {
            arrayList0.add(v0);
        }
        if(this.f.remove(v0)) {
            this.g = null;
        }
    }

    public final Object C(oe.i i0) {
        r0 r00 = new r0(this, new t0(this, null), androidx.compose.runtime.w.l(i0.getContext()), null);
        H h0 = BuildersKt.withContext(this.b, r00, i0);
        a a0 = a.a;
        H h1 = H.a;
        if(h0 != a0) {
            h0 = h1;
        }
        return h0 == a0 ? h0 : h1;
    }

    @Override  // androidx.compose.runtime.s
    public final void a(v v0, m0.b b0) {
        try {
            boolean z = v0.D.E;
            w w0 = new w(v0, 8);
            S s0 = new S(7, v0, null);
            p0.h h0 = m.k();
            d d0 = h0 instanceof d ? ((d)h0) : null;
            if(d0 == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            d d1 = d0.C(w0, s0);
            if(d1 == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            try {
                p0.h h1 = d1.j();
                try {
                    v0.j(b0);
                }
                catch(Throwable throwable1) {
                    p0.h.q(h1);
                    throw throwable1;
                }
                p0.h.q(h1);
            }
            finally {
                u0.s(d1);
            }
        }
        catch(Throwable throwable0) {
            this.A(throwable0, v0);
            return;
        }
        if(!z) {
            m.k().m();
        }
        synchronized(this.c) {
            if(((o0)this.u.getValue()).compareTo(o0.b) > 0 && !this.x().contains(v0)) {
                this.f.add(v0);
                this.g = null;
            }
        }
        try {
            synchronized(this.c) {
                ArrayList arrayList0 = this.k;
                if(arrayList0.size() > 0) {
                    ((Y)arrayList0.get(0)).getClass();
                    throw null;
                }
            }
        }
        catch(Throwable throwable2) {
            this.A(throwable2, v0);
            return;
        }
        try {
            v0.e();
            v0.g();
        }
        catch(Throwable throwable3) {
            this.A(throwable3, null);
            return;
        }
        if(!z) {
            m.k().m();
        }
    }

    @Override  // androidx.compose.runtime.s
    public final boolean c() {
        return ((Boolean)u0.z.get()).booleanValue();
    }

    @Override  // androidx.compose.runtime.s
    public final boolean d() {
        return false;
    }

    @Override  // androidx.compose.runtime.s
    public final boolean e() {
        return false;
    }

    @Override  // androidx.compose.runtime.s
    public final int g() {
        return 1000;
    }

    @Override  // androidx.compose.runtime.s
    public final i h() {
        return this.w;
    }

    @Override  // androidx.compose.runtime.s
    public final void i(v v0) {
        CancellableContinuation cancellableContinuation0;
        synchronized(this.c) {
            if(this.i.h(v0)) {
                cancellableContinuation0 = null;
            }
            else {
                this.i.b(v0);
                cancellableContinuation0 = this.u();
            }
        }
        if(cancellableContinuation0 != null) {
            cancellableContinuation0.resumeWith(H.a);
        }
    }

    @Override  // androidx.compose.runtime.s
    public final X j(Y y0) {
        synchronized(this.c) {
            return (X)this.n.j(y0);
        }
    }

    @Override  // androidx.compose.runtime.s
    public final void k(Set set0) {
    }

    @Override  // androidx.compose.runtime.s
    public final void m(v v0) {
        synchronized(this.c) {
            LinkedHashSet linkedHashSet0 = this.q;
            if(linkedHashSet0 == null) {
                linkedHashSet0 = new LinkedHashSet();
                this.q = linkedHashSet0;
            }
            linkedHashSet0.add(v0);
        }
    }

    @Override  // androidx.compose.runtime.s
    public final void p(v v0) {
        synchronized(this.c) {
            if(this.f.remove(v0)) {
                this.g = null;
            }
            this.i.j(v0);
            this.j.remove(v0);
        }
    }

    public static final v q(u0 u00, v v0, L l0) {
        boolean z;
        if(!v0.D.E && !v0.E && (u00.q == null || !u00.q.contains(v0))) {
            w w0 = new w(v0, 8);
            S s0 = new S(7, v0, l0);
            p0.h h0 = m.k();
            d d0 = h0 instanceof d ? ((d)h0) : null;
            if(d0 != null) {
                d d1 = d0.C(w0, s0);
                if(d1 != null) {
                    try {
                        p0.h h1 = d1.j();
                        try {
                            if(l0 != null && l0.h()) {
                                g g0 = new g(27, l0, v0);
                                p p0 = v0.D;
                                if(p0.E) {
                                    q.c("Preparing a composition while composing is not supported");
                                }
                                p0.E = true;
                                try {
                                    g0.invoke();
                                }
                                finally {
                                    p0.E = false;
                                }
                            }
                            z = v0.v();
                        }
                        catch(Throwable throwable0) {
                            p0.h.q(h1);
                            throw throwable0;
                        }
                        p0.h.q(h1);
                        return z ? v0 : null;
                    }
                    finally {
                        u0.s(d1);
                    }
                }
            }
            throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
        }
        return null;
    }

    public static final boolean r(u0 u00) {
        List list0;
        g0.h h0;
        boolean z = true;
        synchronized(u00.c) {
            if(u00.h.g()) {
                if(u00.i.c == 0 && !u00.v()) {
                    z = false;
                }
                return z;
            }
            h0 = new g0.h(u00.h);
            u00.h = new L();
        }
        synchronized(u00.c) {
            list0 = u00.x();
        }
        try {
            int v2 = list0.size();
            for(int v3 = 0; v3 < v2; ++v3) {
                ((v)list0.get(v3)).w(h0);
                if(((o0)u00.u.getValue()).compareTo(o0.b) <= 0) {
                    break;
                }
            }
            synchronized(u00.c) {
                u00.h = new L();
            }
            goto label_49;
        }
        catch(Throwable throwable0) {
        }
        synchronized(u00.c) {
            L l0 = u00.h;
            l0.getClass();
            for(Object object2: h0) {
                l0.k(object2);
            }
        }
        throw throwable0;
    label_49:
        synchronized(u00.c) {
            if(u00.u() == null) {
                if(u00.i.c == 0 && !u00.v()) {
                    z = false;
                }
                return z;
            }
        }
        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
    }

    public static void s(d d0) {
        try {
            if(!(d0.w() instanceof p0.i)) {
                return;
            }
        }
        finally {
            d0.c();
        }
        throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.");
    }

    public final void t() {
        synchronized(this.c) {
            if(((o0)this.u.getValue()).compareTo(o0.e) >= 0) {
                this.u.setValue(o0.b);
            }
        }
        DefaultImpls.cancel$default(this.v, null, 1, null);
    }

    public final CancellableContinuation u() {
        o0 o00;
        MutableStateFlow mutableStateFlow0 = this.u;
        int v = ((o0)mutableStateFlow0.getValue()).compareTo(o0.b);
        ArrayList arrayList0 = this.k;
        ArrayList arrayList1 = this.j;
        g0.e e0 = this.i;
        if(v <= 0) {
            this.f.clear();
            this.g = je.w.a;
            this.h = new L();
            e0.g();
            arrayList1.clear();
            arrayList0.clear();
            this.p = null;
            CancellableContinuationImpl cancellableContinuationImpl0 = this.r;
            if(cancellableContinuationImpl0 != null) {
                kotlinx.coroutines.CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuationImpl0, null, 1, null);
            }
            this.r = null;
            this.s = null;
            return null;
        }
        if(this.s != null) {
            o00 = o0.c;
        }
        else if(this.d == null) {
            this.h = new L();
            e0.g();
            o00 = this.v() ? o0.d : o0.c;
        }
        else {
            o00 = e0.c != 0 || this.h.h() || !arrayList1.isEmpty() || !arrayList0.isEmpty() || this.v() ? o0.f : o0.e;
        }
        mutableStateFlow0.setValue(o00);
        if(o00 == o0.f) {
            CancellableContinuation cancellableContinuation0 = this.r;
            this.r = null;
            return cancellableContinuation0;
        }
        return null;
    }

    public final boolean v() {
        return !this.t && this.b.f.get() != 0;
    }

    public final boolean w() {
        synchronized(this.c) {
            return this.h.h() || this.i.c != 0 || this.v();
        }
    }

    public final List x() {
        List list0 = this.g;
        if(list0 == null) {
            ArrayList arrayList0 = this.f;
            list0 = arrayList0.isEmpty() ? je.w.a : new ArrayList(arrayList0);
            this.g = list0;
        }
        return list0;
    }

    public static final void y(ArrayList arrayList0, u0 u00, v v0) {
        arrayList0.clear();
        synchronized(u00.c) {
            Iterator iterator0 = u00.k.iterator();
            if(!iterator0.hasNext()) {
                return;
            }
            Object object1 = iterator0.next();
            ((Y)object1).getClass();
        }
        throw null;
    }

    public final List z(List list0, L l0) {
        ArrayList arrayList1;
        HashMap hashMap0 = new HashMap(list0.size());
        int v = list0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = list0.get(v1);
            ((Y)object0).getClass();
            ArrayList arrayList0 = hashMap0.get(null);
            if(arrayList0 == null) {
                arrayList0 = new ArrayList();
                hashMap0.put(null, arrayList0);
            }
            arrayList0.add(object0);
        }
        for(Object object1: hashMap0.entrySet()) {
            v v2 = (v)((Map.Entry)object1).getKey();
            List list1 = (List)((Map.Entry)object1).getValue();
            if(v2.D.E) {
                q.c("Check failed");
            }
            w w0 = new w(v2, 8);
            S s0 = new S(7, v2, l0);
            p0.h h0 = m.k();
            d d0 = h0 instanceof d ? ((d)h0) : null;
            if(d0 == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            d d1 = d0.C(w0, s0);
            if(d1 == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            try {
                p0.h h1 = d1.j();
                try {
                    synchronized(this.c) {
                        arrayList1 = new ArrayList(list1.size());
                        int v6 = list1.size();
                        for(int v7 = 0; v7 < v6; ++v7) {
                            Y y0 = (Y)list1.get(v7);
                            y0.getClass();
                            Object object3 = g0.a.a(this.l);
                            Y y1 = (Y)object3;
                            arrayList1.add(new ie.m(y0, object3));
                        }
                        int v8 = arrayList1.size();
                        for(int v9 = 0; v9 < v8; ++v9) {
                            ie.m m0 = (ie.m)arrayList1.get(v9);
                            if(m0.b == null) {
                                ((Y)m0.a).getClass();
                                if(((K)this.m.a).b(null)) {
                                    ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
                                    for(Object object4: arrayList1) {
                                        ie.m m1 = (ie.m)object4;
                                        if(m1.b == null) {
                                            b b0 = this.m;
                                            ((Y)m1.a).getClass();
                                            K k0 = (K)b0.a;
                                            c0 c00 = (c0)g0.a.a(k0);
                                            if(k0.i()) {
                                                ((K)b0.b).a();
                                            }
                                        }
                                        arrayList2.add(m1);
                                    }
                                    arrayList1 = arrayList2;
                                    break;
                                }
                            }
                        }
                    }
                    int v10 = arrayList1.size();
                    int v11 = 0;
                label_74:
                    while(v11 < v10) {
                        if(((ie.m)arrayList1.get(v11)).b == null) {
                            ++v11;
                        }
                        else {
                            int v12 = arrayList1.size();
                            int v13 = 0;
                            while(true) {
                                if(v13 >= v12) {
                                    break label_74;
                                }
                                if(((ie.m)arrayList1.get(v13)).b != null) {
                                    ++v13;
                                    continue;
                                }
                                ArrayList arrayList3 = new ArrayList(arrayList1.size());
                                int v14 = arrayList1.size();
                                for(int v15 = 0; v15 < v14; ++v15) {
                                    ie.m m2 = (ie.m)arrayList1.get(v15);
                                    if(m2.b == null) {
                                        Y y2 = (Y)m2.a;
                                    }
                                }
                                synchronized(this.c) {
                                    u.U(this.k, arrayList3);
                                }
                                ArrayList arrayList4 = new ArrayList(arrayList1.size());
                                int v16 = arrayList1.size();
                                for(int v17 = 0; v17 < v16; ++v17) {
                                    Object object6 = arrayList1.get(v17);
                                    if(((ie.m)object6).b != null) {
                                        arrayList4.add(object6);
                                    }
                                }
                                arrayList1 = arrayList4;
                                if(true) {
                                    break label_74;
                                }
                                continue label_74;
                            }
                        }
                    }
                    v2.p(arrayList1);
                }
                finally {
                    p0.h.q(h1);
                }
            }
            finally {
                u0.s(d1);
            }
        }
        return je.p.P0(hashMap0.keySet());
    }
}

