package X0;

import N0.g0;
import P0.I;
import P0.f;
import P0.j0;
import P0.z0;
import androidx.collection.K;
import com.google.firebase.b;
import g0.e;
import java.util.ArrayList;
import java.util.List;
import je.w;
import we.k;
import x0.c;

public final class p {
    public final r0.p a;
    public final boolean b;
    public final I c;
    public final l d;
    public boolean e;
    public p f;
    public final int g;

    public p(r0.p p0, boolean z, I i0, l l0) {
        this.a = p0;
        this.b = z;
        this.c = i0;
        this.d = l0;
        this.g = i0.b;
    }

    public final p a(i i0, k k0) {
        l l0 = new l();
        l0.c = false;
        l0.d = false;
        k0.invoke(l0);
        p p0 = new p(new o(k0), false, new I(true, this.g + (i0 == null ? 2000000000 : 1000000000)), l0);
        p0.e = true;
        p0.f = this;
        return p0;
    }

    public final void b(I i0, ArrayList arrayList0) {
        e e0 = i0.x();
        Object[] arr_object = e0.a;
        int v = e0.c;
        for(int v1 = 0; v1 < v; ++v1) {
            I i1 = (I)arr_object[v1];
            if(i1.H() && !i1.l0) {
                if(i1.b0.e(8)) {
                    arrayList0.add(b.n(i1, this.b));
                }
                else {
                    this.b(i1, arrayList0);
                }
            }
        }
    }

    public final j0 c() {
        if(this.e) {
            p p0 = this.j();
            return p0 == null ? null : p0.c();
        }
        z0 z00 = b.E(this.c);
        if(z00 == null) {
            z00 = this.a;
        }
        return f.t(z00, 8);
    }

    public final void d(ArrayList arrayList0, ArrayList arrayList1) {
        int v = arrayList0.size();
        this.o(arrayList0, false);
        int v1 = arrayList0.size();
        while(v < v1) {
            p p0 = (p)arrayList0.get(v);
            if(p0.l()) {
                arrayList1.add(p0);
            }
            else if(!p0.d.d) {
                p0.d(arrayList0, arrayList1);
            }
            ++v;
        }
    }

    public final c e() {
        j0 j00 = this.c();
        if(j00 != null) {
            if(!j00.h()) {
                j00 = null;
            }
            return j00 == null ? c.e : g0.g(j00).f(j00, true);
        }
        return c.e;
    }

    public final c f() {
        j0 j00 = this.c();
        if(j00 != null) {
            if(!j00.h()) {
                j00 = null;
            }
            return j00 == null ? c.e : g0.f(j00);
        }
        return c.e;
    }

    public final List g(boolean z, boolean z1) {
        if(!z && this.d.d) {
            return w.a;
        }
        ArrayList arrayList0 = new ArrayList();
        if(this.l()) {
            List list0 = new ArrayList();
            this.d(arrayList0, ((ArrayList)list0));
            return list0;
        }
        return this.o(arrayList0, z1);
    }

    public static List h(int v, p p0) {
        boolean z = false;
        int v1 = (v & 1) == 0 ? 0 : !p0.b;
        if((v & 2) == 0) {
            z = true;
        }
        return p0.g(((boolean)v1), z);
    }

    public final l i() {
        l l0 = this.d;
        if(this.l()) {
            l l1 = l0.b();
            this.n(new ArrayList(), l1);
            return l1;
        }
        return l0;
    }

    public final p j() {
        I i1;
        p p0 = this.f;
        if(p0 != null) {
            return p0;
        }
        I i0 = this.c;
        boolean z = this.b;
        if(z) {
            i1 = i0.u();
            while(i1 != null) {
                l l0 = i1.w();
                if(l0 != null && l0.c) {
                    goto label_13;
                }
                i1 = i1.u();
            }
        }
        i1 = null;
    label_13:
        if(i1 == null) {
            for(I i2 = i0.u(); i2 != null; i2 = i2.u()) {
                if(i2.b0.e(8)) {
                    return i2 == null ? null : b.n(i2, z);
                }
            }
            i1 = null;
        }
        return i1 == null ? null : b.n(i1, z);
    }

    public final l k() {
        return this.d;
    }

    // 去混淆评级： 低(20)
    public final boolean l() {
        return this.b && this.d.c;
    }

    public final boolean m() {
        if(!this.e && p.h(4, this).isEmpty()) {
            I i0;
            for(i0 = this.c.u(); true; i0 = i0.u()) {
                if(i0 == null) {
                    i0 = null;
                    break;
                }
                l l0 = i0.w();
                if(l0 != null && l0.c) {
                    break;
                }
            }
            return i0 == null;
        }
        return false;
    }

    public final void n(ArrayList arrayList0, l l0) {
        if(!this.d.d) {
            int v = arrayList0.size();
            this.o(arrayList0, false);
            int v1 = arrayList0.size();
            while(v < v1) {
                p p0 = (p)arrayList0.get(v);
                if(!p0.l()) {
                    l0.e(p0.d);
                    p0.n(arrayList0, l0);
                }
                ++v;
            }
        }
    }

    public final List o(ArrayList arrayList0, boolean z) {
        if(this.e) {
            return w.a;
        }
        this.b(this.c, arrayList0);
        if(z) {
            l l0 = this.d;
            K k0 = l0.a;
            Object object0 = k0.g(s.v);
            if(object0 == null) {
                object0 = null;
            }
            if(((i)object0) != null && l0.c && !arrayList0.isEmpty()) {
                arrayList0.add(this.a(((i)object0), new B0.b(((i)object0), 26)));
            }
            X0.w w0 = s.a;
            if(k0.c(w0) && !arrayList0.isEmpty() && l0.c) {
                Object object1 = k0.g(w0);
                if(object1 == null) {
                    object1 = null;
                }
                String s = ((List)object1) == null ? null : ((String)je.p.m0(((List)object1)));
                if(s != null) {
                    arrayList0.add(0, this.a(null, new B2.s(s, 1)));
                }
            }
        }
        return arrayList0;
    }
}

