package h4;

import B3.L;
import B3.N;
import B3.t;
import androidx.recyclerview.widget.b;
import b3.n;
import e3.c;
import e3.p;
import ea.d;
import f3.f;
import f3.j;
import i.n.i.b.a.s.e.Ja;
import i.n.i.b.a.s.e.M4;
import i.n.i.b.a.s.e.M7;
import i.n.i.b.a.s.e.U5;
import i.n.i.b.a.s.e.ie;
import i.n.i.b.a.s.e.ob;
import i.n.i.b.a.s.e.u;
import i.n.i.b.a.s.e.wb;
import java.util.Collections;

public final class s implements i, M4 {
    public String a;
    public boolean b;
    public final boolean[] c;
    public long d;
    public long e;
    public final Object f;
    public Object g;
    public Object h;
    public final Object i;
    public final Object j;
    public final Object k;
    public final Object l;
    public final Object m;
    public final Object n;

    public s(d d0) {
        this.f = d0;
        this.c = new boolean[3];
        this.i = new x(0x20, 1);
        this.j = new x(33, 1);
        this.k = new x(34, 1);
        this.l = new x(39, 1);
        this.m = new x(40, 1);
        this.n = new wb(1, false);
    }

    public s(y8.s s0) {
        this.f = s0;
        this.c = new boolean[3];
        this.i = new x(0x20, 0);
        this.j = new x(33, 0);
        this.k = new x(34, 0);
        this.l = new x(39, 0);
        this.m = new x(40, 0);
        this.e = 0x8000000000000001L;
        this.n = new p();
    }

    @Override  // i.n.i.b.a.s.e.M4
    public void a() {
        this.d = 0L;
        Ja.D(this.c);
        ((x)this.i).d();
        ((x)this.j).d();
        ((x)this.k).d();
        ((x)this.l).d();
        ((x)this.m).d();
        r r0 = (r)this.h;
        if(r0 != null) {
            r0.e = false;
            r0.f = false;
            r0.g = false;
            r0.h = false;
            r0.i = false;
        }
    }

    @Override  // h4.i
    public void a(p p0) {
        int v11;
        b b1;
        long v9;
        x x0 = (x)this.l;
        x x1 = (x)this.m;
        x x2 = (x)this.i;
        x x3 = (x)this.j;
        x x4 = (x)this.k;
        e3.b.k(((L)this.g));
        while(p0.a() > 0) {
            int v = p0.b;
            int v1 = p0.c;
            byte[] arr_b = p0.a;
            this.d += (long)p0.a();
            ((L)this.g).d(p0, p0.a(), 0);
            while(v < v1) {
                int v2 = j.b(arr_b, v, v1, this.c);
                if(v2 == v1) {
                    this.g(arr_b, v, v1);
                    return;
                }
                int v3 = (arr_b[v2 + 3] & 0x7E) >> 1;
                int v4 = v2 - v;
                if(v4 > 0) {
                    this.g(arr_b, v, v2);
                }
                int v5 = v1 - v2;
                long v6 = this.d - ((long)v5);
                int v7 = v4 >= 0 ? 0 : -v4;
                long v8 = this.e;
                b b0 = (b)((y8.s)this.f).c;
                p p1 = (p)this.n;
                r r0 = (r)this.h;
                boolean z = this.b;
                if(!r0.i || !r0.f) {
                    b1 = b0;
                    if(r0.g || r0.f) {
                        if(!z || !r0.h) {
                            v9 = v6;
                        }
                        else {
                            v9 = v6;
                            r0.a(((int)(v9 - r0.a)) + v5);
                        }
                        r0.j = r0.a;
                        r0.k = r0.d;
                        r0.l = r0.b;
                        r0.h = true;
                        goto label_47;
                    }
                }
                else {
                    r0.l = r0.b;
                    r0.i = false;
                    b1 = b0;
                }
                v9 = v6;
            label_47:
                if(this.b) {
                    v11 = v5;
                }
                else {
                    x2.f(v7);
                    x3.f(v7);
                    x4.f(v7);
                    if(x2.c && x3.c && x4.c) {
                        String s = this.a;
                        int v10 = x2.e;
                        byte[] arr_b1 = new byte[x3.e + v10 + x4.e];
                        v11 = v5;
                        System.arraycopy(((byte[])x2.d), 0, arr_b1, 0, v10);
                        System.arraycopy(((byte[])x3.d), 0, arr_b1, x2.e, x3.e);
                        System.arraycopy(((byte[])x4.d), 0, arr_b1, x2.e + x3.e, x4.e);
                        String s1 = null;
                        f f0 = j.g(((byte[])x3.d), 3, x3.e, null);
                        f3.d d0 = f0.a;
                        if(d0 != null) {
                            s1 = c.a(d0.a, d0.b, d0.c, d0.d, d0.e, d0.f);
                        }
                        n n0 = new n();
                        n0.a = s;
                        n0.m = "video/hevc";
                        n0.j = s1;
                        n0.t = f0.d;
                        n0.u = f0.e;
                        n0.A = new b3.i(f0.h, f0.i, f0.j, f0.b + 8, f0.c + 8, null);
                        n0.x = f0.f;
                        n0.o = f0.g;
                        n0.p = Collections.singletonList(arr_b1);
                        androidx.media3.common.b b2 = new androidx.media3.common.b(n0);
                        ((L)this.g).b(b2);
                        int v12 = b2.p;
                        if(v12 == -1) {
                            throw new IllegalStateException();
                        }
                        b1.getClass();
                        e3.b.j(v12 >= 0);
                        b1.a = v12;
                        b1.i(v12);
                        this.b = true;
                    }
                }
                if(x0.f(v7)) {
                    int v13 = j.k(((byte[])x0.d), x0.e);
                    p1.E(((byte[])x0.d), v13);
                    p1.H(5);
                    b1.a(v8, p1);
                }
                if(x1.f(v7)) {
                    int v14 = j.k(((byte[])x1.d), x1.e);
                    p1.E(((byte[])x1.d), v14);
                    p1.H(5);
                    b1.a(v8, p1);
                }
                long v15 = this.e;
                r r1 = (r)this.h;
                boolean z1 = this.b;
                r1.f = false;
                r1.g = false;
                r1.d = v15;
                r1.c = 0;
                r1.a = v9;
                if(v3 >= 0x20 && v3 != 40) {
                    if(r1.h && !r1.i) {
                        if(z1) {
                            r1.a(v11);
                        }
                        r1.h = false;
                    }
                    if(0x20 <= v3 && v3 <= 35 || v3 == 39) {
                        r1.g = !r1.i;
                        r1.i = true;
                    }
                }
                boolean z2 = v3 >= 16 && v3 <= 21;
                r1.b = z2;
                r1.e = z2 || v3 <= 9;
                if(!this.b) {
                    x2.i(v3);
                    x3.i(v3);
                    x4.i(v3);
                }
                x0.i(v3);
                x1.i(v3);
                v = v2 + 3;
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.M4
    public void b() {
    }

    @Override  // h4.i
    public void b(boolean z) {
        e3.b.k(((L)this.g));
        if(z) {
            ((b)((y8.s)this.f).c).i(0);
            r r0 = (r)this.h;
            long v = this.d;
            r0.l = r0.b;
            r0.a(((int)(v - r0.a)));
            r0.j = r0.a;
            r0.a = v;
            r0.a(0);
            r0.h = false;
        }
    }

    @Override  // i.n.i.b.a.s.e.M4
    public void c(wb wb0) {
        x x7;
        boolean z3;
        ie[] arr_ie2;
        int v38;
        float f;
        int v29;
        int v27;
        x x6;
        int v21;
        x x5;
        ie[] arr_ie1;
        long v10;
        byte[] arr_b1;
        x x0 = (x)this.l;
        x x1 = (x)this.m;
        x x2 = (x)this.i;
        x x3 = (x)this.j;
        x x4 = (x)this.k;
        M7.G(((ie)this.g));
        while(wb0.d() > 0) {
            int v = wb0.b;
            int v1 = wb0.c;
            byte[] arr_b = wb0.a;
            this.d += (long)wb0.d();
            ((ie)this.g).b(wb0.d(), wb0);
            while(v < v1) {
                int v2 = Ja.g(arr_b, v, v1, this.c);
                if(v2 == v1) {
                    this.f(arr_b, v, v1);
                    return;
                }
                int v3 = (arr_b[v2 + 3] & 0x7E) >> 1;
                int v4 = v2 - v;
                if(v4 > 0) {
                    this.f(arr_b, v, v2);
                }
                int v5 = v1 - v2;
                long v6 = this.d - ((long)v5);
                int v7 = v4 >= 0 ? 0 : -v4;
                long v8 = this.e;
                ie[] arr_ie = (ie[])((d)this.f).b;
                wb wb1 = (wb)this.n;
                r r0 = (r)this.h;
                boolean z = this.b;
                if(r0.i && r0.f) {
                    r0.l = r0.b;
                    r0.i = false;
                }
                else if(r0.g || r0.f) {
                    if(!z || !r0.h) {
                        arr_b1 = arr_b;
                    }
                    else {
                        arr_b1 = arr_b;
                        ((ie)r0.m).f(r0.k, ((int)r0.l), ((int)(r0.a - r0.j)), v5 + ((int)(v6 - r0.a)), null);
                    }
                    r0.j = r0.a;
                    r0.k = r0.d;
                    r0.l = r0.b;
                    r0.h = true;
                    goto label_45;
                }
                arr_b1 = arr_b;
            label_45:
                if(this.b) {
                    x6 = x4;
                    arr_ie1 = arr_ie;
                    v10 = v6;
                }
                else {
                    x2.b(v7);
                    x3.b(v7);
                    x4.b(v7);
                    if(x2.c && x3.c && x4.c) {
                        ie ie0 = (ie)this.g;
                        String s = this.a;
                        int v9 = x2.e;
                        v10 = v6;
                        byte[] arr_b2 = new byte[x3.e + v9 + x4.e];
                        System.arraycopy(((byte[])x2.d), 0, arr_b2, 0, v9);
                        arr_ie1 = arr_ie;
                        System.arraycopy(((byte[])x3.d), 0, arr_b2, x2.e, x3.e);
                        System.arraycopy(((byte[])x4.d), 0, arr_b2, x2.e + x3.e, x4.e);
                        N n0 = new N(0, x3.e, 7, ((byte[])x3.d));
                        n0.v(44);
                        int v11 = n0.i(3);
                        n0.z();
                        n0.v(88);
                        n0.v(8);
                        int v12 = 0;
                        for(int v13 = 0; v13 < v11; ++v13) {
                            if(n0.q()) {
                                v12 += 89;
                            }
                            if(n0.q()) {
                                v12 += 8;
                            }
                        }
                        n0.v(v12);
                        if(v11 > 0) {
                            n0.v((8 - v11) * 2);
                        }
                        n0.u();
                        int v14 = n0.u();
                        if(v14 == 3) {
                            n0.z();
                        }
                        int v15 = n0.u();
                        int v16 = n0.u();
                        if(n0.q()) {
                            v15 -= (n0.u() + n0.u()) * (v14 == 1 || v14 == 2 ? 2 : 1);
                            v16 -= (n0.u() + n0.u()) * (v14 == 1 ? 2 : 1);
                        }
                        n0.u();
                        n0.u();
                        int v17 = n0.u();
                        for(int v18 = n0.q() ? 0 : v11; v18 <= v11; ++v18) {
                            n0.u();
                            n0.u();
                            n0.u();
                        }
                        n0.u();
                        n0.u();
                        n0.u();
                        n0.u();
                        n0.u();
                        n0.u();
                        if(n0.q() && n0.q()) {
                            for(int v19 = 0; v19 < 4; ++v19) {
                                int v20 = 0;
                                while(v20 < 6) {
                                    if(n0.q()) {
                                        v21 = v20;
                                        x5 = x4;
                                        int v22 = Math.min(0x40, 1 << (v19 << 1) + 4);
                                        if(v19 > 1) {
                                            n0.w();
                                        }
                                        for(int v23 = 0; v23 < v22; ++v23) {
                                            n0.w();
                                        }
                                    }
                                    else {
                                        n0.u();
                                        x5 = x4;
                                        v21 = v20;
                                    }
                                    v20 = v21 + (v19 == 3 ? 3 : 1);
                                    x4 = x5;
                                }
                            }
                        }
                        x6 = x4;
                        n0.v(2);
                        if(n0.q()) {
                            n0.v(8);
                            n0.u();
                            n0.u();
                            n0.z();
                        }
                        int v24 = n0.u();
                        int v25 = 0;
                        int v26 = 0;
                        boolean z1 = false;
                        while(v25 < v24) {
                            if(v25 != 0) {
                                z1 = n0.q();
                            }
                            if(z1) {
                                n0.z();
                                n0.u();
                                v27 = v24;
                                for(int v28 = 0; v28 <= v26; ++v28) {
                                    if(n0.q()) {
                                        n0.z();
                                    }
                                }
                                v29 = v25;
                            }
                            else {
                                v27 = v24;
                                int v30 = n0.u();
                                int v31 = n0.u();
                                v29 = v25;
                                for(int v32 = 0; v32 < v30; ++v32) {
                                    n0.u();
                                    n0.z();
                                }
                                for(int v33 = 0; v33 < v31; ++v33) {
                                    n0.u();
                                    n0.z();
                                }
                                v26 = v30 + v31;
                            }
                            v25 = v29 + 1;
                            v24 = v27;
                        }
                        if(n0.q()) {
                            for(int v34 = 0; v34 < n0.u(); ++v34) {
                                n0.v(v17 + 5);
                            }
                        }
                        n0.v(2);
                        if(n0.q()) {
                            if(n0.q()) {
                                int v35 = n0.i(8);
                                if(v35 == 0xFF) {
                                    int v36 = n0.i(16);
                                    int v37 = n0.i(16);
                                    if(v36 != 0 && v37 != 0) {
                                        f = ((float)v36) / ((float)v37);
                                        goto label_195;
                                    }
                                }
                                else {
                                    float[] arr_f = Ja.v;
                                    if(v35 < 17) {
                                        f = arr_f[v35];
                                        goto label_195;
                                    }
                                    else {
                                        U4.x.u(v35, "Unexpected aspect_ratio_idc value: ", "H265Reader");
                                    }
                                }
                            }
                            f = 1.0f;
                        label_195:
                            if(n0.q()) {
                                n0.z();
                            }
                            if(n0.q()) {
                                n0.v(4);
                                if(n0.q()) {
                                    n0.v(24);
                                }
                            }
                            if(n0.q()) {
                                n0.u();
                                n0.u();
                            }
                            n0.z();
                            if(n0.q()) {
                                v16 *= 2;
                            }
                            v38 = v16;
                        }
                        else {
                            v38 = v16;
                            f = 1.0f;
                        }
                        int v39 = x3.e;
                        n0.d = (byte[])x3.d;
                        n0.c = 0;
                        n0.b = v39;
                        n0.e = 0;
                        n0.b();
                        n0.v(24);
                        String s1 = Ja.q(n0);
                        ob ob0 = new ob();
                        ob0.a = s;
                        ob0.k = "video/hevc";
                        ob0.h = s1;
                        ob0.p = v15;
                        ob0.q = v38;
                        ob0.t = f;
                        ob0.m = Collections.singletonList(arr_b2);
                        ie0.a(new u(ob0));
                        this.b = true;
                    }
                }
                if(x0.b(v7)) {
                    wb1.i(Ja.V(x0.e, ((byte[])x0.d)), ((byte[])x0.d));
                    wb1.o(5);
                    arr_ie2 = arr_ie1;
                    Ja.y(v8, wb1, arr_ie2);
                }
                else {
                    arr_ie2 = arr_ie1;
                }
                if(x1.b(v7)) {
                    wb1.i(Ja.V(x1.e, ((byte[])x1.d)), ((byte[])x1.d));
                    wb1.o(5);
                    Ja.y(v8, wb1, arr_ie2);
                }
                long v40 = this.e;
                r r1 = (r)this.h;
                boolean z2 = this.b;
                r1.f = false;
                r1.g = false;
                r1.d = v40;
                r1.c = 0;
                r1.a = v10;
                if(v3 >= 0x20 && v3 != 40) {
                    if(!r1.h || r1.i) {
                        z3 = false;
                    }
                    else {
                        if(z2) {
                            ((ie)r1.m).f(r1.k, ((int)r1.l), ((int)(v10 - r1.j)), v5, null);
                        }
                        z3 = false;
                        r1.h = false;
                    }
                    if(0x20 <= v3 && v3 <= 35 || v3 == 39) {
                        r1.g = !r1.i;
                        r1.i = true;
                    }
                }
                else {
                    z3 = false;
                }
                boolean z4 = v3 >= 16 && v3 <= 21;
                r1.b = z4;
                if(z4 || v3 <= 9) {
                    z3 = true;
                }
                r1.e = z3;
                if(this.b) {
                    x7 = x6;
                }
                else {
                    x2.e(v3);
                    x3.e(v3);
                    x7 = x6;
                    x7.e(v3);
                }
                x0.e(v3);
                x1.e(v3);
                v = v2 + 3;
                arr_b = arr_b1;
                x4 = x7;
            }
        }
    }

    @Override  // h4.i
    public void d(t t0, G g0) {
        g0.c();
        g0.d();
        this.a = g0.e;
        g0.d();
        L l0 = t0.track(g0.d, 2);
        this.g = l0;
        this.h = new r(l0);
        ((y8.s)this.f).e(t0, g0);
    }

    @Override  // i.n.i.b.a.s.e.M4
    public void e(U5 u50, G g0) {
        g0.a();
        g0.b();
        this.a = g0.e;
        g0.b();
        ie ie0 = u50.i(g0.d, 2);
        this.g = ie0;
        this.h = new r(ie0);
        ((d)this.f).b(u50, g0);
    }

    public void f(byte[] arr_b, int v, int v1) {
        r r0 = (r)this.h;
        if(r0.e) {
            int v2 = r0.c;
            int v3 = v + 2 - v2;
            if(v3 < v1) {
                r0.f = (arr_b[v3] & 0x80) != 0;
                r0.e = false;
            }
            else {
                r0.c = v1 - v + v2;
            }
        }
        if(!this.b) {
            ((x)this.i).a(arr_b, v, v1);
            ((x)this.j).a(arr_b, v, v1);
            ((x)this.k).a(arr_b, v, v1);
        }
        ((x)this.l).a(arr_b, v, v1);
        ((x)this.m).a(arr_b, v, v1);
    }

    public void g(byte[] arr_b, int v, int v1) {
        r r0 = (r)this.h;
        if(r0.e) {
            int v2 = r0.c;
            int v3 = v + 2 - v2;
            if(v3 < v1) {
                r0.f = (arr_b[v3] & 0x80) != 0;
                r0.e = false;
            }
            else {
                r0.c = v1 - v + v2;
            }
        }
        if(!this.b) {
            ((x)this.i).c(arr_b, v, v1);
            ((x)this.j).c(arr_b, v, v1);
            ((x)this.k).c(arr_b, v, v1);
        }
        ((x)this.l).c(arr_b, v, v1);
        ((x)this.m).c(arr_b, v, v1);
    }

    @Override  // i.n.i.b.a.s.e.M4
    public void k(long v, int v1) {
        this.e = v;
    }

    @Override  // h4.i
    public void packetStarted(long v, int v1) {
        this.e = v;
    }

    @Override  // h4.i
    public void seek() {
        this.d = 0L;
        this.e = 0x8000000000000001L;
        j.a(this.c);
        ((x)this.i).h();
        ((x)this.j).h();
        ((x)this.k).h();
        ((x)this.l).h();
        ((x)this.m).h();
        ((b)((y8.s)this.f).c).i(0);
        r r0 = (r)this.h;
        if(r0 != null) {
            r0.e = false;
            r0.f = false;
            r0.g = false;
            r0.h = false;
            r0.i = false;
        }
    }
}

