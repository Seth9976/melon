package Cc;

import M.y;
import N0.M;
import P0.h;
import P0.i;
import P0.j;
import P0.k;
import androidx.compose.foundation.Q0;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.E;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.utils.shortcut.ShortCutItem;
import ie.H;
import ie.f;
import ie.m;
import java.util.List;
import r0.q;
import rd.S;
import wc.u;
import we.a;
import we.n;
import y0.e;
import y0.s;

public final class c2 implements n {
    public final int a;
    public final float b;
    public final float c;
    public final Object d;
    public final Object e;
    public final f f;
    public final Object g;

    public c2(float f, float f1, b0 b00, List list0, n n0, b0 b01) {
        this.a = 1;
        super();
        this.b = f;
        this.c = f1;
        this.d = b00;
        this.e = list0;
        this.f = n0;
        this.g = b01;
    }

    public c2(e e0, a a0, float f, float f1, a a1, a a2, int v) {
        this.a = 0;
        super();
        this.d = e0;
        this.e = a0;
        this.b = f;
        this.c = f1;
        this.f = a1;
        this.g = a2;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            b0 b00 = (b0)this.d;
            List list0 = (List)this.e;
            n n0 = (n)this.f;
            b0 b01 = (b0)this.g;
            int v = (int)(((Integer)object1));
            p p0 = (p)(((l)object0));
            if(p0.Q(v & 1, (v & 3) != 2)) {
                r0.n n1 = r0.n.a;
                q q0 = d.j(androidx.compose.foundation.layout.a.n(n1, 0.0f, 0.0f, 0.0f, this.b, 7), 0.0f, this.c, 1);
                M m0 = M.p.d(r0.d.a, false);
                int v1 = p0.P;
                i0 i00 = p0.m();
                q q1 = r0.a.d(p0, q0);
                k.y.getClass();
                i i0 = j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                h h0 = j.f;
                w.x(p0, m0, h0);
                h h1 = j.e;
                w.x(p0, i00, h1);
                h h2 = j.g;
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v1)) {
                    A7.d.q(v1, p0, v1, h2);
                }
                h h3 = j.d;
                w.x(p0, q1, h3);
                Q0 q00 = androidx.compose.foundation.q.t(p0);
                E e0 = p0.N();
                V v2 = androidx.compose.runtime.k.a;
                if(e0 == v2) {
                    e0 = w.i(new S(q00, 4));
                    p0.l0(e0);
                }
                q q2 = androidx.compose.foundation.q.x(d.f(n1, 1.0f), q00, false, 14);
                vd.k k0 = p0.N();
                if(k0 == v2) {
                    k0 = new vd.k(b00, 5);
                    p0.l0(k0);
                }
                q q3 = androidx.compose.ui.layout.a.f(q2, k0);
                y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
                int v3 = p0.P;
                i0 i01 = p0.m();
                q q4 = r0.a.d(p0, q3);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, y0, h0);
                w.x(p0, i01, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h2);
                }
                w.x(p0, q4, h3);
                p0.a0(0x69476BCF);
                for(Object object2: list0) {
                    m m1 = (m)object2;
                    ShortCutItem shortCutItem0 = (ShortCutItem)m1.a;
                    boolean z = ((Boolean)m1.b).booleanValue();
                    boolean z1 = p0.g(n0);
                    boolean z2 = p0.i(m1);
                    m9.l l0 = p0.N();
                    if(z1 || z2 || l0 == v2) {
                        l0 = new m9.l(20, n0, m1);
                        p0.l0(l0);
                    }
                    d8.d.k(shortCutItem0, z, l0, p0, 0);
                }
                p0.p(false);
                p0.p(true);
                if(!((Boolean)b01.getValue()).booleanValue() || !((Boolean)e0.getValue()).booleanValue()) {
                    p0.a0(0xC6EE4BB6);
                }
                else {
                    p0.a0(-948508747);
                    q q5 = androidx.compose.foundation.q.e(d.h(d.f(n1, 1.0f), 22.0f), u.f(e.k.A(new s[]{new s(e0.T(p0, 0x7F06048A)), new s(e0.T(p0, 0x7F0604AB))}), 0.0f, 0.0f, 14), null, 6);  // color:transparent
                    M.p.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q5, r0.d.h), p0, 0);
                }
                p0.p(false);
                p0.p(true);
                return H.a;
            }
            p0.T();
            return H.a;
        }
        ((Integer)object1).getClass();
        u2.b(((e)this.d), ((a)this.e), this.b, this.c, ((a)this.f), ((a)this.g), ((l)object0), 1);
        return H.a;
    }
}

