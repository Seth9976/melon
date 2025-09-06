package h4;

import B3.L;
import B3.N;
import B3.t;
import android.util.SparseArray;
import b3.n;
import e3.b;
import e3.p;
import ea.d;
import f3.h;
import f3.j;
import i.n.i.b.a.s.e.E6;
import i.n.i.b.a.s.e.Ja;
import i.n.i.b.a.s.e.M4;
import i.n.i.b.a.s.e.M7;
import i.n.i.b.a.s.e.Nb;
import i.n.i.b.a.s.e.Ob;
import i.n.i.b.a.s.e.U5;
import i.n.i.b.a.s.e.ie;
import i.n.i.b.a.s.e.ob;
import i.n.i.b.a.s.e.u;
import i.n.i.b.a.s.e.wb;
import java.util.ArrayList;
import java.util.Arrays;
import y8.s;

public final class q implements i, M4 {
    public final boolean a;
    public final boolean b;
    public long c;
    public final boolean[] d;
    public String e;
    public boolean f;
    public long g;
    public boolean h;
    public final Object i;
    public final Object j;
    public final Object k;
    public final Object l;
    public Object m;
    public Object n;
    public final Object o;

    public q(d d0, boolean z, boolean z1) {
        this.i = d0;
        this.a = z;
        this.b = z1;
        this.d = new boolean[3];
        this.j = new x(7, 1);
        this.k = new x(8, 1);
        this.l = new x(6, 1);
        this.o = new wb(1, false);
    }

    public q(s s0, boolean z, boolean z1) {
        this.i = s0;
        this.a = z;
        this.b = z1;
        this.d = new boolean[3];
        this.j = new x(7, 0);
        this.k = new x(8, 0);
        this.l = new x(6, 0);
        this.g = 0x8000000000000001L;
        this.o = new p();
    }

    @Override  // i.n.i.b.a.s.e.M4
    public void a() {
        this.c = 0L;
        this.h = false;
        Ja.D(this.d);
        ((x)this.j).d();
        ((x)this.k).d();
        ((x)this.l).d();
        E6 e60 = (E6)this.n;
        if(e60 != null) {
            e60.k = false;
            e60.o = false;
            e60.n.b = false;
            e60.n.a = false;
        }
    }

    @Override  // h4.i
    public void a(p p0) {
        int v22;
        long v12;
        int v11;
        long v10;
        int v9;
        x x0 = (x)this.j;
        x x1 = (x)this.k;
        x x2 = (x)this.l;
        b.k(((L)this.m));
        int v = p0.b;
        int v1 = p0.c;
        byte[] arr_b = p0.a;
        this.c += (long)p0.a();
        ((L)this.m).d(p0, p0.a(), 0);
        int v2;
        while((v2 = j.b(arr_b, v, v1, this.d)) != v1) {
            int v3 = arr_b[v2 + 3] & 0x1F;
            int v4 = v2 - v;
            if(v4 > 0) {
                this.g(arr_b, v, v2);
            }
            int v5 = v1 - v2;
            long v6 = this.c - ((long)v5);
            int v7 = v4 >= 0 ? 0 : -v4;
            long v8 = this.g;
            p p1 = (p)this.o;
            androidx.recyclerview.widget.b b0 = (androidx.recyclerview.widget.b)((s)this.i).c;
            if(!this.f || ((h4.p)this.n).c) {
                x0.f(v7);
                x1.f(v7);
                if(this.f) {
                label_61:
                    v9 = v2 + 3;
                    v11 = v3;
                    v10 = v6;
                    v12 = v8;
                    if(x0.c) {
                        f3.i i1 = j.i(((byte[])x0.d), 3, x0.e);
                        b0.getClass();
                        b.j(i1.s >= 0);
                        b0.a = i1.s;
                        b0.i(i1.s);
                        ((h4.p)this.n).d.append(i1.d, i1);
                        x0.h();
                    }
                    else if(x1.c) {
                        N n2 = new N(4, x1.e, 3, ((byte[])x1.d));
                        int v15 = n2.H();
                        int v16 = n2.H();
                        n2.N();
                        h h1 = new h(v15, v16, n2.C());
                        ((h4.p)this.n).e.append(v15, h1);
                        x1.h();
                    }
                }
                else {
                    if(!x0.c || !x1.c) {
                        goto label_83;
                    }
                    else {
                        ArrayList arrayList0 = new ArrayList();
                        arrayList0.add(Arrays.copyOf(((byte[])x0.d), x0.e));
                        arrayList0.add(Arrays.copyOf(((byte[])x1.d), x1.e));
                        v9 = v2 + 3;
                        f3.i i0 = j.i(((byte[])x0.d), 3, x0.e);
                        v10 = v6;
                        v11 = v3;
                        v12 = v8;
                        N n0 = new N(4, x1.e, 3, ((byte[])x1.d));
                        int v13 = n0.H();
                        int v14 = n0.H();
                        n0.N();
                        h h0 = new h(v13, v14, n0.C());
                        L l0 = (L)this.m;
                        n n1 = new n();
                        n1.a = this.e;
                        n1.m = "video/avc";
                        n1.j = String.format("avc1.%02X%02X%02X", i0.a, i0.b, i0.c);
                        n1.t = i0.e;
                        n1.u = i0.f;
                        n1.A = new b3.i(i0.p, i0.q, i0.r, i0.h + 8, i0.i + 8, null);
                        n1.x = i0.g;
                        n1.p = arrayList0;
                        n1.o = i0.s;
                        l0.b(new androidx.media3.common.b(n1));
                        this.f = true;
                        b0.getClass();
                        b.j(i0.s >= 0);
                        b0.a = i0.s;
                        b0.i(i0.s);
                        ((h4.p)this.n).d.append(i0.d, i0);
                        ((h4.p)this.n).e.append(v13, h0);
                        x0.h();
                        x1.h();
                        goto label_87;
                    }
                    goto label_61;
                }
            }
            else {
            label_83:
                v9 = v2 + 3;
                v11 = v3;
                v10 = v6;
                v12 = v8;
            }
        label_87:
            if(x2.f(v7)) {
                int v17 = j.k(((byte[])x2.d), x2.e);
                p1.E(((byte[])x2.d), v17);
                p1.G(4);
                b0.a(v12, p1);
            }
            h4.p p2 = (h4.p)this.n;
            boolean z = this.f;
            if(p2.i == 9) {
            label_105:
                if(z && p2.o) {
                    long v18 = p2.j;
                    int v19 = v5 + ((int)(v10 - v18));
                    long v20 = p2.q;
                    if(v20 != 0x8000000000000001L) {
                        p2.a.c(v20, ((int)p2.r), ((int)(v18 - p2.p)), v19, null);
                    }
                }
                p2.p = p2.j;
                p2.q = p2.l;
                p2.r = false;
                p2.o = true;
            }
            else if(p2.c) {
                o o0 = p2.n;
                o o1 = p2.m;
                if(o0.a) {
                    if(o1.a) {
                        f3.i i2 = (f3.i)o0.p;
                        b.k(i2);
                        f3.i i3 = (f3.i)o1.p;
                        b.k(i3);
                        if(o0.e != o1.e || o0.f != o1.f || o0.g != o1.g || o0.h && o1.h && o0.i != o1.i || o0.c != o1.c && (o0.c == 0 || o1.c == 0) || (i2.m == 0 && i3.m == 0 && (o0.l != o1.l || o0.m != o1.m) || i2.m == 1 && i3.m == 1 && (o0.n != o1.n || o0.o != o1.o)) || (o0.j != o1.j || o0.j && o0.k != o1.k)) {
                            goto label_105;
                        }
                    }
                    else {
                        goto label_105;
                    }
                }
            }
            p2.a();
            if(p2.r) {
                this.h = false;
            }
            long v21 = this.g;
            if(this.f && !((h4.p)this.n).c) {
                v22 = v11;
            }
            else {
                v22 = v11;
                x0.i(v22);
                x1.i(v22);
            }
            x2.i(v22);
            h4.p p3 = (h4.p)this.n;
            p3.i = v22;
            p3.l = v21;
            p3.j = v10;
            p3.s = this.h;
            if(p3.b && v22 == 1 || p3.c && (v22 == 1 || v22 == 2 || v22 == 5)) {
                o o2 = p3.m;
                p3.m = p3.n;
                p3.n = o2;
                o2.b = false;
                o2.a = false;
                p3.h = 0;
                p3.k = true;
            }
            v = v9;
        }
        this.g(arr_b, v, v1);
    }

    @Override  // i.n.i.b.a.s.e.M4
    public void b() {
    }

    @Override  // h4.i
    public void b(boolean z) {
        b.k(((L)this.m));
        if(z) {
            ((androidx.recyclerview.widget.b)((s)this.i).c).i(0);
            h4.p p0 = (h4.p)this.n;
            long v = this.c;
            p0.a();
            p0.j = v;
            long v1 = p0.q;
            if(Long.compare(v1, 0x8000000000000001L) != 0) {
                p0.a.c(v1, ((int)p0.r), ((int)(v - p0.p)), 0, null);
            }
            p0.o = false;
        }
    }

    @Override  // i.n.i.b.a.s.e.M4
    public void c(wb wb0) {
        int v18;
        int v13;
        long v10;
        int v9;
        x x0 = (x)this.j;
        x x1 = (x)this.k;
        x x2 = (x)this.l;
        M7.G(((ie)this.m));
        int v = wb0.b;
        int v1 = wb0.c;
        byte[] arr_b = wb0.a;
        this.c += (long)wb0.d();
        ((ie)this.m).b(wb0.d(), wb0);
        int v2;
        while((v2 = Ja.g(arr_b, v, v1, this.d)) != v1) {
            int v3 = arr_b[v2 + 3] & 0x1F;
            int v4 = v2 - v;
            if(v4 > 0) {
                this.f(arr_b, v, v2);
            }
            int v5 = v1 - v2;
            long v6 = this.c - ((long)v5);
            int v7 = v4 >= 0 ? 0 : -v4;
            long v8 = this.g;
            wb wb1 = (wb)this.o;
            if(!this.f || ((E6)this.n).c) {
                x0.b(v7);
                x1.b(v7);
                if(this.f) {
                label_54:
                    v9 = v2 + 3;
                    v13 = v3;
                    v10 = v6;
                    if(x0.c) {
                        Ob ob2 = Ja.W(((byte[])x0.d), 3, x0.e);
                        ((E6)this.n).d.append(ob2.d, ob2);
                        x0.d();
                    }
                    else if(x1.c) {
                        N n1 = new N(3, x1.e, 7, ((byte[])x1.d));
                        n1.v(8);
                        int v14 = n1.u();
                        int v15 = n1.u();
                        n1.z();
                        Nb nb1 = new Nb(v14, v15, n1.q());
                        ((E6)this.n).e.append(v14, nb1);
                        x1.d();
                    }
                }
                else {
                    if(!x0.c || !x1.c) {
                        goto label_72;
                    }
                    else {
                        ArrayList arrayList0 = new ArrayList();
                        arrayList0.add(Arrays.copyOf(((byte[])x0.d), x0.e));
                        arrayList0.add(Arrays.copyOf(((byte[])x1.d), x1.e));
                        Ob ob0 = Ja.W(((byte[])x0.d), 3, x0.e);
                        v9 = v2 + 3;
                        v10 = v6;
                        N n0 = new N(3, x1.e, 7, ((byte[])x1.d));
                        n0.v(8);
                        int v11 = n0.u();
                        int v12 = n0.u();
                        n0.z();
                        Nb nb0 = new Nb(v11, v12, n0.q());
                        ie ie0 = (ie)this.m;
                        ob ob1 = new ob();
                        v13 = v3;
                        ob1.a = this.e;
                        ob1.k = "video/avc";
                        ob1.h = String.format("avc1.%02X%02X%02X", ob0.a, ob0.b, ob0.c);
                        ob1.p = ob0.e;
                        ob1.q = ob0.f;
                        ob1.t = ob0.g;
                        ob1.m = arrayList0;
                        ie0.a(new u(ob1));
                        this.f = true;
                        ((E6)this.n).d.append(ob0.d, ob0);
                        ((E6)this.n).e.append(v11, nb0);
                        x0.d();
                        x1.d();
                        goto label_75;
                    }
                    goto label_54;
                }
            }
            else {
            label_72:
                v9 = v2 + 3;
                v13 = v3;
                v10 = v6;
            }
        label_75:
            if(x2.b(v7)) {
                wb1.i(Ja.V(x2.e, ((byte[])x2.d)), ((byte[])x2.d));
                wb1.n(4);
                Ja.y(v8, wb1, ((ie[])((d)this.i).b));
            }
            E6 e60 = (E6)this.n;
            boolean z = this.f;
            boolean z1 = this.h;
            if(e60.i == 9) {
            label_93:
                if(z && e60.o) {
                    e60.a.f(e60.q, ((int)e60.r), ((int)(e60.j - e60.p)), v5 + ((int)(v10 - e60.j)), null);
                }
                e60.p = e60.j;
                e60.q = e60.l;
                e60.r = false;
                e60.o = true;
            }
            else if(e60.c) {
                o o0 = e60.n;
                o o1 = e60.m;
                if(o0.a) {
                    if(o1.a) {
                        Ob ob3 = (Ob)o0.p;
                        M7.G(ob3);
                        Ob ob4 = (Ob)o1.p;
                        M7.G(ob4);
                        if(o0.e != o1.e || o0.f != o1.f || o0.g != o1.g || o0.h && o1.h && o0.i != o1.i || o0.c != o1.c && (o0.c == 0 || o1.c == 0) || (ob3.k == 0 && ob4.k == 0 && (o0.l != o1.l || o0.m != o1.m) || ob3.k == 1 && ob4.k == 1 && (o0.n != o1.n || o0.o != o1.o)) || (o0.j != o1.j || o0.j && o0.k != o1.k)) {
                            goto label_93;
                        }
                    }
                    else {
                        goto label_93;
                    }
                }
            }
            if(e60.b) {
                z1 = e60.n.b && (e60.n.d == 2 || e60.n.d == 7);
            }
            int v16 = e60.r | (e60.i == 5 || z1 && e60.i == 1);
            e60.r = v16;
            if(v16 != 0) {
                this.h = false;
            }
            long v17 = this.g;
            if(this.f && !((E6)this.n).c) {
                v18 = v13;
            }
            else {
                v18 = v13;
                x0.e(v18);
                x1.e(v18);
            }
            x2.e(v18);
            E6 e61 = (E6)this.n;
            e61.i = v18;
            e61.l = v17;
            e61.j = v10;
            if(e61.b && v18 == 1 || e61.c && (v18 == 1 || v18 == 2 || v18 == 5)) {
                o o2 = e61.m;
                e61.m = e61.n;
                e61.n = o2;
                o2.b = false;
                o2.a = false;
                e61.h = 0;
                e61.k = true;
            }
            v = v9;
        }
        this.f(arr_b, v, v1);
    }

    @Override  // h4.i
    public void d(t t0, G g0) {
        g0.c();
        g0.d();
        this.e = g0.e;
        g0.d();
        L l0 = t0.track(g0.d, 2);
        this.m = l0;
        this.n = new h4.p(l0, this.a, this.b);
        ((s)this.i).e(t0, g0);
    }

    @Override  // i.n.i.b.a.s.e.M4
    public void e(U5 u50, G g0) {
        g0.a();
        g0.b();
        this.e = g0.e;
        g0.b();
        ie ie0 = u50.i(g0.d, 2);
        this.m = ie0;
        this.n = new E6(ie0, this.a, this.b);
        ((d)this.i).b(u50, g0);
    }

    public void f(byte[] arr_b, int v, int v1) {
        boolean z3;
        boolean z2;
        boolean z1;
        int v11;
        int v16;
        int v15;
        int v14;
        int v13;
        if(!this.f || ((E6)this.n).c) {
            ((x)this.j).a(arr_b, v, v1);
            ((x)this.k).a(arr_b, v, v1);
        }
        ((x)this.l).a(arr_b, v, v1);
        E6 e60 = (E6)this.n;
        SparseArray sparseArray0 = e60.e;
        N n0 = e60.f;
        if(e60.k) {
            int v2 = v1 - v;
            byte[] arr_b1 = e60.g;
            int v3 = e60.h + v2;
            if(arr_b1.length < v3) {
                e60.g = Arrays.copyOf(arr_b1, v3 * 2);
            }
            System.arraycopy(arr_b, v, e60.g, e60.h, v2);
            int v4 = e60.h + v2;
            e60.h = v4;
            n0.d = e60.g;
            n0.c = 0;
            n0.b = v4;
            n0.e = 0;
            n0.b();
            if(n0.d(8)) {
                n0.z();
                int v5 = n0.i(2);
                n0.v(5);
                if(n0.l()) {
                    n0.u();
                    if(n0.l()) {
                        int v6 = n0.u();
                        if(!e60.c) {
                            e60.k = false;
                            e60.n.d = v6;
                            e60.n.b = true;
                            return;
                        }
                        if(n0.l()) {
                            int v7 = n0.u();
                            if(sparseArray0.indexOfKey(v7) < 0) {
                                e60.k = false;
                                return;
                            }
                            Nb nb0 = (Nb)sparseArray0.get(v7);
                            boolean z = nb0.b;
                            Ob ob0 = (Ob)e60.d.get(nb0.a);
                            int v8 = ob0.l;
                            int v9 = ob0.j;
                            if(!ob0.h) {
                            label_47:
                                if(n0.d(v9)) {
                                    int v10 = n0.i(v9);
                                    if(ob0.i) {
                                        z1 = false;
                                        z2 = false;
                                        z3 = false;
                                    label_63:
                                        boolean z4 = e60.i == 5;
                                        if(!z4) {
                                            v11 = 0;
                                        label_69:
                                            int v12 = ob0.k;
                                            if(v12 != 0) {
                                                if(v12 != 1 || ob0.m) {
                                                    goto label_95;
                                                }
                                                if(n0.l()) {
                                                    int v17 = n0.w();
                                                    if(!z || z1) {
                                                        v16 = v17;
                                                        v14 = 0;
                                                        v15 = 0;
                                                        v13 = 0;
                                                        goto label_99;
                                                    label_95:
                                                        v14 = 0;
                                                        v15 = 0;
                                                        v13 = 0;
                                                        v16 = 0;
                                                    label_99:
                                                        o o0 = e60.n;
                                                        o0.p = ob0;
                                                        o0.c = v5;
                                                        o0.d = v6;
                                                        o0.e = v10;
                                                        o0.f = v7;
                                                        o0.g = z1;
                                                        o0.h = z3;
                                                        o0.i = z2;
                                                        o0.j = z4;
                                                        o0.k = v11;
                                                        o0.l = v13;
                                                        o0.m = v14;
                                                        o0.n = v16;
                                                        o0.o = v15;
                                                        o0.a = true;
                                                        o0.b = true;
                                                        e60.k = false;
                                                    }
                                                    else if(n0.l()) {
                                                        v15 = n0.w();
                                                        v16 = v17;
                                                        v14 = 0;
                                                        v13 = 0;
                                                        goto label_99;
                                                    }
                                                }
                                            }
                                            else if(n0.d(v8)) {
                                                v13 = n0.i(v8);
                                                if(!z || z1) {
                                                    v14 = 0;
                                                    v15 = 0;
                                                    v16 = 0;
                                                    goto label_99;
                                                }
                                                else if(n0.l()) {
                                                    v14 = n0.w();
                                                    v15 = 0;
                                                    v16 = 0;
                                                    goto label_99;
                                                }
                                            }
                                        }
                                        else if(n0.l()) {
                                            v11 = n0.u();
                                            goto label_69;
                                        }
                                    }
                                    else if(n0.d(1)) {
                                        z1 = n0.q();
                                        if(!z1) {
                                            z2 = false;
                                            z3 = false;
                                            goto label_63;
                                        }
                                        else if(n0.d(1)) {
                                            z2 = n0.q();
                                            z3 = true;
                                            goto label_63;
                                        }
                                    }
                                }
                            }
                            else if(n0.d(2)) {
                                n0.v(2);
                                goto label_47;
                            }
                        }
                    }
                }
            }
        }
    }

    public void g(byte[] arr_b, int v, int v1) {
        boolean z3;
        boolean z2;
        boolean z1;
        int v11;
        int v16;
        int v15;
        int v14;
        int v13;
        if(!this.f || ((h4.p)this.n).c) {
            ((x)this.j).c(arr_b, v, v1);
            ((x)this.k).c(arr_b, v, v1);
        }
        ((x)this.l).c(arr_b, v, v1);
        h4.p p0 = (h4.p)this.n;
        SparseArray sparseArray0 = p0.e;
        N n0 = p0.f;
        if(p0.k) {
            int v2 = v1 - v;
            byte[] arr_b1 = p0.g;
            int v3 = p0.h + v2;
            if(arr_b1.length < v3) {
                p0.g = Arrays.copyOf(arr_b1, v3 * 2);
            }
            System.arraycopy(arr_b, v, p0.g, p0.h, v2);
            int v4 = p0.h + v2;
            p0.h = v4;
            n0.d = p0.g;
            n0.c = 0;
            n0.b = v4;
            n0.e = 0;
            n0.g();
            if(n0.s(8)) {
                n0.N();
                int v5 = n0.D(2);
                n0.O(5);
                if(n0.t()) {
                    n0.H();
                    if(n0.t()) {
                        int v6 = n0.H();
                        if(!p0.c) {
                            p0.k = false;
                            p0.n.d = v6;
                            p0.n.b = true;
                            return;
                        }
                        if(n0.t()) {
                            int v7 = n0.H();
                            if(sparseArray0.indexOfKey(v7) < 0) {
                                p0.k = false;
                                return;
                            }
                            h h0 = (h)sparseArray0.get(v7);
                            boolean z = h0.b;
                            f3.i i0 = (f3.i)p0.d.get(h0.a);
                            int v8 = i0.n;
                            int v9 = i0.l;
                            if(!i0.j) {
                            label_47:
                                if(n0.s(v9)) {
                                    int v10 = n0.D(v9);
                                    if(i0.k) {
                                        z1 = false;
                                        z2 = false;
                                        z3 = false;
                                    label_63:
                                        boolean z4 = p0.i == 5;
                                        if(!z4) {
                                            v11 = 0;
                                        label_69:
                                            int v12 = i0.m;
                                            if(v12 != 0) {
                                                if(v12 != 1 || i0.o) {
                                                    goto label_95;
                                                }
                                                if(n0.t()) {
                                                    int v17 = n0.I();
                                                    if(!z || z1) {
                                                        v16 = v17;
                                                        v14 = 0;
                                                        v15 = 0;
                                                        v13 = 0;
                                                        goto label_99;
                                                    label_95:
                                                        v14 = 0;
                                                        v15 = 0;
                                                        v13 = 0;
                                                        v16 = 0;
                                                    label_99:
                                                        o o0 = p0.n;
                                                        o0.p = i0;
                                                        o0.c = v5;
                                                        o0.d = v6;
                                                        o0.e = v10;
                                                        o0.f = v7;
                                                        o0.g = z1;
                                                        o0.h = z3;
                                                        o0.i = z2;
                                                        o0.j = z4;
                                                        o0.k = v11;
                                                        o0.l = v13;
                                                        o0.m = v14;
                                                        o0.n = v16;
                                                        o0.o = v15;
                                                        o0.a = true;
                                                        o0.b = true;
                                                        p0.k = false;
                                                    }
                                                    else if(n0.t()) {
                                                        v15 = n0.I();
                                                        v16 = v17;
                                                        v14 = 0;
                                                        v13 = 0;
                                                        goto label_99;
                                                    }
                                                }
                                            }
                                            else if(n0.s(v8)) {
                                                v13 = n0.D(v8);
                                                if(!z || z1) {
                                                    v14 = 0;
                                                    v15 = 0;
                                                    v16 = 0;
                                                    goto label_99;
                                                }
                                                else if(n0.t()) {
                                                    v14 = n0.I();
                                                    v15 = 0;
                                                    v16 = 0;
                                                    goto label_99;
                                                }
                                            }
                                        }
                                        else if(n0.t()) {
                                            v11 = n0.H();
                                            goto label_69;
                                        }
                                    }
                                    else if(n0.s(1)) {
                                        z1 = n0.C();
                                        if(!z1) {
                                            z2 = false;
                                            z3 = false;
                                            goto label_63;
                                        }
                                        else if(n0.s(1)) {
                                            z2 = n0.C();
                                            z3 = true;
                                            goto label_63;
                                        }
                                    }
                                }
                            }
                            else if(n0.s(2)) {
                                n0.O(2);
                                goto label_47;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.M4
    public void k(long v, int v1) {
        this.g = v;
        this.h |= (v1 & 2) != 0;
    }

    @Override  // h4.i
    public void packetStarted(long v, int v1) {
        this.g = v;
        this.h |= (v1 & 2) != 0;
    }

    @Override  // h4.i
    public void seek() {
        this.c = 0L;
        this.h = false;
        this.g = 0x8000000000000001L;
        j.a(this.d);
        ((x)this.j).h();
        ((x)this.k).h();
        ((x)this.l).h();
        ((androidx.recyclerview.widget.b)((s)this.i).c).i(0);
        h4.p p0 = (h4.p)this.n;
        if(p0 != null) {
            p0.k = false;
            p0.o = false;
            p0.n.b = false;
            p0.n.a = false;
        }
    }
}

