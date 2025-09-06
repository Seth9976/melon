package androidx.compose.foundation.text.modifiers;

import A7.d;
import P0.a0;
import P0.f;
import Q0.x0;
import U4.x;
import X.e;
import X.l;
import a1.U;
import e1.i;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import r0.p;
import y0.u;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextStringSimpleElement;", "LP0/a0;", "LX/l;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TextStringSimpleElement extends a0 {
    public final String a;
    public final U b;
    public final i c;
    public final int d;
    public final boolean e;
    public final int f;
    public final int g;
    public final u h;

    public TextStringSimpleElement(String s, U u0, i i0, int v, boolean z, int v1, int v2, u u1) {
        this.a = s;
        this.b = u0;
        this.c = i0;
        this.d = v;
        this.e = z;
        this.f = v1;
        this.g = v2;
        this.h = u1;
    }

    @Override  // P0.a0
    public final p create() {
        p p0 = new l();  // 初始化器: Lr0/p;-><init>()V
        p0.a = this.a;
        p0.b = this.b;
        p0.c = this.c;
        p0.d = this.d;
        p0.e = this.e;
        p0.f = this.f;
        p0.g = this.g;
        p0.h = this.h;
        return p0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TextStringSimpleElement)) {
            return false;
        }
        if(!q.b(this.h, ((TextStringSimpleElement)object0).h)) {
            return false;
        }
        if(!q.b(this.a, ((TextStringSimpleElement)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((TextStringSimpleElement)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((TextStringSimpleElement)object0).c)) {
            return false;
        }
        if(this.d != ((TextStringSimpleElement)object0).d || this.e != ((TextStringSimpleElement)object0).e) {
            return false;
        }
        return this.f == ((TextStringSimpleElement)object0).f ? this.g == ((TextStringSimpleElement)object0).g : false;
    }

    @Override
    public final int hashCode() {
        int v = ((d.e(d.b(this.d, (this.c.hashCode() + x.a(this.a.hashCode() * 0x1F, 0x1F, this.b)) * 0x1F, 0x1F), 0x1F, this.e) + this.f) * 0x1F + this.g) * 0x1F;
        return this.h == null ? v : v + this.h.hashCode();
    }

    @Override  // P0.a0
    public final void inspectableProperties(x0 x00) {
    }

    @Override  // P0.a0
    public final void update(p p0) {
        boolean z2;
        l l0 = (l)p0;
        boolean z = q.b(this.h, l0.h);
        l0.h = this.h;
        boolean z1 = false;
        int v = 1;
        U u0 = this.b;
        if(z) {
            U u1 = l0.b;
            if(u0 == u1) {
                u0.getClass();
                z2 = false;
            }
            else if(!u0.a.b(u1.a)) {
                z2 = true;
            }
            else {
                z2 = false;
            }
        }
        else {
            z2 = true;
        }
        String s = this.a;
        if(!q.b(l0.a, s)) {
            l0.a = s;
            l0.l = null;
            z1 = true;
        }
        int v1 = !l0.b.c(u0);
        l0.b = u0;
        int v2 = this.g;
        if(l0.g != v2) {
            l0.g = v2;
            v1 = 1;
        }
        int v3 = this.f;
        if(l0.f != v3) {
            l0.f = v3;
            v1 = 1;
        }
        boolean z3 = this.e;
        if(l0.e != z3) {
            l0.e = z3;
            v1 = 1;
        }
        i i0 = this.c;
        if(!q.b(l0.c, i0)) {
            l0.c = i0;
            v1 = 1;
        }
        int v4 = this.d;
        if(l0.d == v4) {
            v = v1;
        }
        else {
            l0.d = v4;
        }
        if(z1 || v != 0) {
            e e0 = l0.n0();
            e0.a = l0.a;
            e0.b = l0.b;
            e0.c = l0.c;
            e0.d = l0.d;
            e0.e = l0.e;
            e0.f = l0.f;
            e0.g = l0.g;
            e0.b();
        }
        if(l0.isAttached()) {
            if(z1 || z2 && l0.k != null) {
                f.v(l0).E();
            }
            if(z1 || v != 0) {
                f.v(l0).D();
                f.m(l0);
            }
            if(z2) {
                f.m(l0);
            }
        }
    }
}

