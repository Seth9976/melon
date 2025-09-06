package androidx.compose.foundation.text.modifiers;

import A7.d;
import P0.a0;
import P0.f;
import Q0.x0;
import U4.x;
import X.h;
import a1.U;
import a1.g;
import e1.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import we.k;
import y0.u;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringElement;", "LP0/a0;", "LX/h;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TextAnnotatedStringElement extends a0 {
    public final g a;
    public final U b;
    public final i c;
    public final k d;
    public final int e;
    public final boolean f;
    public final int g;
    public final int h;
    public final List i;
    public final k j;
    public final u k;
    public final k l;

    public TextAnnotatedStringElement(g g0, U u0, i i0, k k0, int v, boolean z, int v1, int v2, List list0, k k1, u u1, k k2) {
        this.a = g0;
        this.b = u0;
        this.c = i0;
        this.d = k0;
        this.e = v;
        this.f = z;
        this.g = v1;
        this.h = v2;
        this.i = list0;
        this.j = k1;
        this.k = u1;
        this.l = k2;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new h();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        p0.c = this.c;
        p0.d = this.d;
        p0.e = this.e;
        p0.f = this.f;
        p0.g = this.g;
        p0.h = this.h;
        p0.i = this.i;
        p0.j = this.j;
        p0.k = this.k;
        p0.l = this.l;
        return p0;
    }

    // 去混淆评级： 中等(70)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof TextAnnotatedStringElement && q.b(this.k, ((TextAnnotatedStringElement)object0).k) && q.b(this.a, ((TextAnnotatedStringElement)object0).a) && q.b(this.b, ((TextAnnotatedStringElement)object0).b) && q.b(this.i, ((TextAnnotatedStringElement)object0).i) && q.b(this.c, ((TextAnnotatedStringElement)object0).c) && this.d == ((TextAnnotatedStringElement)object0).d && this.l == ((TextAnnotatedStringElement)object0).l && this.e == ((TextAnnotatedStringElement)object0).e && this.f == ((TextAnnotatedStringElement)object0).f && this.g == ((TextAnnotatedStringElement)object0).g && this.h == ((TextAnnotatedStringElement)object0).h && this.j == ((TextAnnotatedStringElement)object0).j;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = ((d.e(d.b(this.e, ((this.c.hashCode() + x.a(this.a.hashCode() * 0x1F, 0x1F, this.b)) * 0x1F + (this.d == null ? 0 : this.d.hashCode())) * 0x1F, 0x1F), 0x1F, this.f) + this.g) * 0x1F + this.h) * 0x1F;
        int v2 = this.i == null ? 0 : this.i.hashCode();
        int v3 = this.j == null ? 0 : this.j.hashCode();
        int v4 = this.k == null ? 0 : this.k.hashCode();
        k k0 = this.l;
        if(k0 != null) {
            v = k0.hashCode();
        }
        return (((v1 + v2) * 0x1F + v3) * 961 + v4) * 0x1F + v;
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
    }

    @Override  // P0.a0
    public final void update(p p0) {
        int v6;
        boolean z1;
        h h0 = (h)p0;
        boolean z = q.b(this.k, h0.k);
        h0.k = this.k;
        if(z) {
            U u0 = h0.b;
            U u1 = this.b;
            if(u1 == u0) {
                u1.getClass();
                z1 = false;
            }
            else if(!u1.a.b(u0.a)) {
                z1 = true;
            }
            else {
                z1 = false;
            }
        }
        else {
            z1 = true;
        }
        g g0 = this.a;
        boolean z2 = q.b(h0.a.b, g0.b);
        boolean z3 = !z2 || !q.b(h0.a.a, g0.a);
        if(z3) {
            h0.a = g0;
        }
        if(!z2) {
            h0.r = null;
        }
        int v = 1;
        int v1 = !h0.b.c(this.b);
        h0.b = this.b;
        List list0 = this.i;
        if(!q.b(h0.i, list0)) {
            h0.i = list0;
            v1 = 1;
        }
        int v2 = this.h;
        if(h0.h != v2) {
            h0.h = v2;
            v1 = 1;
        }
        int v3 = this.g;
        if(h0.g != v3) {
            h0.g = v3;
            v1 = 1;
        }
        boolean z4 = this.f;
        if(h0.f != z4) {
            h0.f = z4;
            v1 = 1;
        }
        i i0 = this.c;
        if(!q.b(h0.c, i0)) {
            h0.c = i0;
            v1 = 1;
        }
        int v4 = this.e;
        if(h0.e == v4) {
            v = v1;
        }
        else {
            h0.e = v4;
        }
        k k0 = this.d;
        int v5 = 1;
        if(h0.d == k0) {
            v6 = 0;
        }
        else {
            h0.d = k0;
            v6 = 1;
        }
        k k1 = this.j;
        if(h0.j != k1) {
            h0.j = k1;
            v6 = 1;
        }
        k k2 = this.l;
        if(h0.l == k2) {
            v5 = v6;
        }
        else {
            h0.l = k2;
        }
        if(z3 || v != 0 || v5 != 0) {
            X.d d0 = h0.n0();
            U u2 = h0.b;
            i i1 = h0.c;
            int v7 = h0.e;
            boolean z5 = h0.f;
            int v8 = h0.g;
            int v9 = h0.h;
            List list1 = h0.i;
            d0.a = h0.a;
            boolean z6 = u2.c(d0.k);
            d0.k = u2;
            if(!z6) {
                d0.l = null;
                d0.n = null;
                d0.p = -1;
                d0.o = -1;
            }
            d0.b = i1;
            d0.c = v7;
            d0.d = z5;
            d0.e = v8;
            d0.f = v9;
            d0.g = list1;
            d0.l = null;
            d0.n = null;
            d0.p = -1;
            d0.o = -1;
        }
        if(h0.isAttached()) {
            if(z3 || z1 && h0.o != null) {
                f.v(h0).E();
            }
            if(z3 || v != 0 || v5 != 0) {
                f.v(h0).D();
                f.m(h0);
            }
            if(z1) {
                f.m(h0);
            }
        }
    }
}

