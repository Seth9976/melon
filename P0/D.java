package p0;

import androidx.collection.L;
import androidx.compose.runtime.j0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import je.p;
import je.w;
import we.k;
import we.n;

public class d extends h {
    public final k e;
    public final k f;
    public int g;
    public L h;
    public ArrayList i;
    public l j;
    public int[] k;
    public int l;
    public boolean m;
    public static final int[] n;

    static {
        d.n = new int[0];
    }

    public d(long v, l l0, k k0, k k1) {
        super(v, l0);
        this.e = k0;
        this.f = k1;
        this.j = l.e;
        this.k = d.n;
        this.l = 1;
    }

    public final void A(long v) {
        synchronized(m.b) {
            this.j = this.j.g(v);
        }
    }

    public void B(L l0) {
        this.h = l0;
    }

    public d C(k k0, k k1) {
        d d0;
        if(this.c) {
            j0.a("Cannot use a disposed snapshot");
        }
        if(this.m && this.d < 0) {
            j0.b("Unsupported operation on a disposed or applied snapshot");
        }
        this.A(this.g());
        Object object0 = m.b;
        synchronized(object0) {
            long v = m.d;
            m.d = v + 1L;
            m.c = m.c.g(v);
            l l0 = this.d();
            this.r(l0.g(v));
            d0 = new e(v, m.e(l0, this.g() + 1L, v), m.l(k0, this.y(), true), m.b(k1, this.i()), this);
        }
        if(!this.m && !this.c) {
            long v1 = this.g();
            synchronized(object0) {
                long v2 = m.d;
                m.d = v2 + 1L;
                this.s(v2);
                m.c = m.c.g(this.g());
            }
            this.r(m.e(this.d(), v1 + 1L, this.g()));
            return d0;
        }
        return d0;
    }

    @Override  // p0.h
    public final void b() {
        m.c = m.c.b(this.g()).a(this.j);
    }

    @Override  // p0.h
    public void c() {
        if(!this.c) {
            this.c = true;
            synchronized(m.b) {
                this.o();
            }
            this.l();
        }
    }

    @Override  // p0.h
    public k e() {
        return this.y();
    }

    @Override  // p0.h
    public boolean f() {
        return false;
    }

    @Override  // p0.h
    public int h() {
        return this.g;
    }

    @Override  // p0.h
    public k i() {
        return this.f;
    }

    @Override  // p0.h
    public void k() {
        ++this.l;
    }

    @Override  // p0.h
    public void l() {
        if(this.l <= 0) {
            j0.a("no pending nested snapshots");
        }
        int v = this.l - 1;
        this.l = v;
        if(v == 0 && !this.m) {
            L l0 = this.x();
            if(l0 != null) {
                if(this.m) {
                    j0.b("Unsupported operation on a snapshot that has been applied");
                }
                this.B(null);
                long v1 = this.g();
                Object[] arr_object = l0.b;
                long[] arr_v = l0.a;
                int v2 = arr_v.length - 2;
                if(v2 >= 0) {
                    for(int v3 = 0; true; ++v3) {
                        long v4 = arr_v[v3];
                        if((~v4 << 7 & v4 & 0x8080808080808080L) != 0x8080808080808080L) {
                            int v5 = 8 - (~(v3 - v2) >>> 0x1F);
                            for(int v6 = 0; v6 < v5; ++v6) {
                                if((0xFFL & v4) < 0x80L) {
                                    for(v v7 = ((t)arr_object[(v3 << 3) + v6]).e(); v7 != null; v7 = v7.b) {
                                        if(v7.a == v1 || p.d0(this.j, v7.a)) {
                                            v7.a = 0L;
                                        }
                                    }
                                }
                                v4 >>= 8;
                            }
                            if(v5 != 8) {
                                this.a();
                                return;
                            }
                        }
                        if(v3 == v2) {
                            break;
                        }
                    }
                    this.a();
                    return;
                }
                this.a();
                return;
            }
            this.a();
        }
    }

    @Override  // p0.h
    public void m() {
        if(!this.m && !this.c) {
            this.v();
        }
    }

    @Override  // p0.h
    public void n(t t0) {
        L l0 = this.x();
        if(l0 == null) {
            l0 = new L();
            this.B(l0);
        }
        l0.a(t0);
    }

    @Override  // p0.h
    public final void p() {
        for(int v = 0; v < this.k.length; ++v) {
            m.u(this.k[v]);
        }
        this.o();
    }

    @Override  // p0.h
    public void t(int v) {
        this.g = v;
    }

    @Override  // p0.h
    public h u(k k0) {
        h h0;
        if(this.c) {
            j0.a("Cannot use a disposed snapshot");
        }
        if(this.m && this.d < 0) {
            j0.b("Unsupported operation on a disposed or applied snapshot");
        }
        long v = this.g();
        this.A(this.g());
        Object object0 = m.b;
        synchronized(object0) {
            long v1 = m.d;
            m.d = v1 + 1L;
            m.c = m.c.g(v1);
            h0 = new f(v1, m.e(this.d(), v + 1L, v1), m.l(k0, this.y(), true), this);
        }
        if(!this.m && !this.c) {
            long v2 = this.g();
            synchronized(object0) {
                long v3 = m.d;
                m.d = v3 + 1L;
                this.s(v3);
                m.c = m.c.g(this.g());
            }
            this.r(m.e(this.d(), v2 + 1L, this.g()));
            return h0;
        }
        return h0;
    }

    public final void v() {
        this.A(this.g());
        if(!this.m && !this.c) {
            long v = this.g();
            synchronized(m.b) {
                long v2 = m.d;
                m.d = v2 + 1L;
                this.s(v2);
                m.c = m.c.g(this.g());
            }
            this.r(m.e(this.d(), v + 1L, this.g()));
        }
    }

    public q w() {
        L l3;
        w w1;
        L l1;
        q q0;
        HashMap hashMap0;
        L l0 = this.x();
        if(l0 == null) {
            hashMap0 = null;
        }
        else {
            long v = m.i.b;
            hashMap0 = m.c(v, this, m.c.b(v));
        }
        w w0 = w.a;
        synchronized(m.b) {
            m.d(this);
            if(l0 == null || l0.d == 0) {
                goto label_34;
            }
            else {
                c c0 = m.i;
                q0 = this.z(m.d, l0, hashMap0, m.c.b(c0.b));
                if(q0.equals(j.b)) {
                    this.b();
                    l1 = c0.h;
                    long v1 = c0.b;
                    m.c.b(v1);
                    long v2 = m.d;
                    m.d = v2 + 1L;
                    l l2 = m.c.b(v1);
                    m.c = l2;
                    c0.b = v2;
                    c0.a = l2;
                    c0.g = 0;
                    c0.h = null;
                    c0.o();
                    m.c = m.c.g(v2);
                    this.B(null);
                    c0.h = null;
                    w1 = m.g;
                    goto label_58;
                }
                return q0;
            }
            goto label_58;
        }
        return q0;
        try {
        label_34:
            this.b();
            l3 = m.i.h;
            long v3 = m.i.b;
            m.c.b(v3);
            long v4 = m.d;
            m.d = v4 + 1L;
            l l4 = m.c.b(v3);
            m.c = l4;
            m.i.b = v4;
            m.i.a = l4;
            m.i.g = 0;
            m.i.h = null;
            m.i.o();
            m.c = m.c.g(v4);
            if(l3 == null || !l3.h()) {
                goto label_56;
            }
            else {
                w1 = m.g;
                l1 = l3;
            }
            goto label_58;
        }
        catch(Throwable throwable0) {
        }
        throw throwable0;
    label_56:
        w1 = w0;
        l1 = null;
    label_58:
        this.m = true;
        if(l1 != null) {
            g0.h h0 = new g0.h(l1);
            if(!l1.g()) {
                int v5 = w1.size();
                for(int v6 = 0; v6 < v5; ++v6) {
                    ((n)w1.get(v6)).invoke(h0, this);
                }
            }
        }
        if(l0 != null && l0.h()) {
            g0.h h1 = new g0.h(l0);
            int v7 = w1.size();
            for(int v8 = 0; v8 < v7; ++v8) {
                ((n)w1.get(v8)).invoke(h1, this);
            }
        }
        synchronized(m.b) {
            this.p();
            m.g();
            if(l1 == null) {
            label_102:
                if(l0 == null) {
                label_122:
                    ArrayList arrayList0 = this.i;
                    if(arrayList0 != null) {
                        int v20 = arrayList0.size();
                        for(int v21 = 0; v21 < v20; ++v21) {
                            m.q(((t)arrayList0.get(v21)));
                        }
                    }
                }
                else {
                    Object[] arr_object1 = l0.b;
                    long[] arr_v1 = l0.a;
                    int v15 = arr_v1.length - 2;
                    if(v15 >= 0) {
                        int v16 = 0;
                        while(true) {
                            long v17 = arr_v1[v16];
                            if((~v17 << 7 & v17 & 0x8080808080808080L) == 0x8080808080808080L) {
                                goto label_119;
                            }
                            int v18 = 8 - (~(v16 - v15) >>> 0x1F);
                            for(int v19 = 0; v19 < v18; ++v19) {
                                if((v17 & 0xFFL) < 0x80L) {
                                    m.q(((t)arr_object1[(v16 << 3) + v19]));
                                }
                                v17 >>= 8;
                            }
                            if(v18 == 8) {
                            label_119:
                                if(v16 != v15) {
                                    ++v16;
                                    continue;
                                }
                            }
                            goto label_122;
                        }
                    }
                    else {
                        goto label_122;
                    }
                }
            }
            else {
                Object[] arr_object = l1.b;
                long[] arr_v = l1.a;
                int v10 = arr_v.length - 2;
                if(v10 >= 0) {
                    int v11 = 0;
                    while(true) {
                        long v12 = arr_v[v11];
                        if((~v12 << 7 & v12 & 0x8080808080808080L) == 0x8080808080808080L) {
                            goto label_99;
                        }
                        int v13 = 8 - (~(v11 - v10) >>> 0x1F);
                        for(int v14 = 0; v14 < v13; ++v14) {
                            if((v12 & 0xFFL) < 0x80L) {
                                m.q(((t)arr_object[(v11 << 3) + v14]));
                            }
                            v12 >>= 8;
                        }
                        if(v13 == 8) {
                        label_99:
                            if(v11 != v10) {
                                ++v11;
                                continue;
                            }
                        }
                        goto label_102;
                    }
                }
                else {
                    goto label_102;
                }
            }
            this.i = null;
            return j.b;
        }
    }

    public L x() {
        return this.h;
    }

    public k y() {
        return this.e;
    }

    public final q z(long v, L l0, HashMap hashMap0, l l1) {
        v v13;
        long v9;
        Collection collection1;
        l l3;
        int v7;
        long[] arr_v1;
        Object[] arr_object1;
        ArrayList arrayList0;
        Collection collection0;
        l l2 = this.d().g(this.g()).e(this.j);
        Object[] arr_object = l0.b;
        long[] arr_v = l0.a;
        int v1 = arr_v.length - 2;
        if(v1 >= 0) {
            int v2 = 0;
            collection0 = null;
            arrayList0 = null;
            while(true) {
                long v3 = arr_v[v2];
                if((~v3 << 7 & v3 & 0x8080808080808080L) == 0x8080808080808080L) {
                    goto label_81;
                }
                int v4 = 8 - (~(v2 - v1) >>> 0x1F);
                int v5 = 0;
                while(v5 < v4) {
                    if((v3 & 0xFFL) < 0x80L) {
                        arr_object1 = arr_object;
                        t t0 = (t)arr_object[(v2 << 3) + v5];
                        arr_v1 = arr_v;
                        v v6 = t0.e();
                        v7 = v5;
                        v v8 = m.s(v6, v, l1);
                        if(v8 == null) {
                            l3 = l2;
                            collection1 = arrayList0;
                            v9 = v3;
                        }
                        else {
                            collection1 = arrayList0;
                            v9 = v3;
                            v v10 = m.s(v6, this.g(), l2);
                            if(v10 == null) {
                                l3 = l2;
                            }
                            else {
                                l3 = l2;
                                if(v10.a != 1L && !v8.equals(v10)) {
                                    v v11 = m.s(v6, this.g(), this.d());
                                    if(v11 == null) {
                                        m.r();
                                        throw null;
                                    }
                                    if(hashMap0 == null) {
                                        v13 = t0.a(v10, v8, v11);
                                    }
                                    else {
                                        v v12 = (v)hashMap0.get(v8);
                                        if(v12 != null) {
                                            v13 = v12;
                                        }
                                    }
                                    if(v13 == null) {
                                        return new i(this);
                                    }
                                    if(!v13.equals(v11)) {
                                        if(v13.equals(v8)) {
                                            Collection collection2 = collection0 == null ? new ArrayList() : collection0;
                                            ((List)collection2).add(new ie.m(t0, v8.b(this.g())));
                                            arrayList0 = collection1 == null ? new ArrayList() : collection1;
                                            arrayList0.add(t0);
                                            collection0 = collection2;
                                            goto label_70;
                                        }
                                        else {
                                            if(collection0 == null) {
                                                collection0 = new ArrayList();
                                            }
                                            ((List)collection0).add((v13.equals(v10) ? new ie.m(t0, v10.b(this.g())) : new ie.m(t0, v13)));
                                            goto label_63;
                                        }
                                        m.r();
                                        throw null;
                                    }
                                }
                            }
                        }
                    label_63:
                        arrayList0 = collection1;
                    }
                    else {
                        l3 = l2;
                        arr_object1 = arr_object;
                        arr_v1 = arr_v;
                        v7 = v5;
                        v9 = v3;
                    }
                label_70:
                    v3 = v9 >> 8;
                    v5 = v7 + 1;
                    arr_v = arr_v1;
                    arr_object = arr_object1;
                    l2 = l3;
                }
                l l4 = l2;
                Object[] arr_object2 = arr_object;
                long[] arr_v2 = arr_v;
                if(v4 == 8) {
                    goto label_84;
                label_81:
                    l4 = l2;
                    arr_object2 = arr_object;
                    arr_v2 = arr_v;
                label_84:
                    if(v2 != v1) {
                        ++v2;
                        arr_v = arr_v2;
                        arr_object = arr_object2;
                        l2 = l4;
                        continue;
                    }
                }
                break;
            }
        }
        else {
            arrayList0 = null;
            collection0 = null;
        }
        if(collection0 != null) {
            this.v();
            int v14 = collection0.size();
            for(int v15 = 0; v15 < v14; ++v15) {
                ie.m m0 = (ie.m)((List)collection0).get(v15);
                ((v)m0.b).a = v;
                synchronized(m.b) {
                    ((v)m0.b).b = ((t)m0.a).e();
                    ((t)m0.a).b(((v)m0.b));
                }
            }
        }
        if(arrayList0 != null) {
            int v17 = arrayList0.size();
            for(int v18 = 0; v18 < v17; ++v18) {
                l0.l(((t)arrayList0.get(v18)));
            }
            ArrayList arrayList1 = this.i;
            if(arrayList1 != null) {
                arrayList0 = p.A0(arrayList1, arrayList0);
            }
            this.i = arrayList0;
        }
        return j.b;
    }
}

