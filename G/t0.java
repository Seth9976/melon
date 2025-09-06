package G;

import F.v;
import androidx.compose.runtime.E;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.J;
import androidx.compose.runtime.M0;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.w;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import p0.p;

public final class t0 {
    public final P a;
    public final t0 b;
    public final String c;
    public final b0 d;
    public final b0 e;
    public final M0 f;
    public final M0 g;
    public final b0 h;
    public final p i;
    public final p j;
    public final b0 k;
    public final E l;

    public t0(P p0, t0 t00, String s) {
        this.a = p0;
        this.b = t00;
        this.c = s;
        this.d = w.s(this.c());
        this.e = w.s(new n0(this.c(), this.c()));
        this.f = w.q(0L);
        this.g = w.q(0x8000000000000000L);
        this.h = w.s(Boolean.FALSE);
        this.i = new p();
        this.j = new p();
        this.k = w.s(Boolean.FALSE);
        this.l = w.i(new v(this, 1));
        p0.getClass();
    }

    public final void a(Object object0, l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xA6F9B301);
        int v1 = (v & 6) == 0 ? (((v & 8) == 0 ? p0.g(object0) : p0.i(object0)) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.g(this) ? 0x20 : 16);
        }
        boolean z = true;
        if(!p0.Q(v1 & 1, (v1 & 19) != 18)) {
            p0.T();
        }
        else if(!this.g()) {
            p0.a0(1822801203);
            this.k(object0);
            if(!q.b(object0, this.c()) || (this.g.m() != 0x8000000000000000L || ((Boolean)((O0)this.h).getValue()).booleanValue())) {
                p0.a0(1823032494);
                CoroutineScope coroutineScope0 = p0.N();
                V v2 = k.a;
                if(coroutineScope0 == v2) {
                    coroutineScope0 = J.i(p0);
                    p0.l0(coroutineScope0);
                }
                boolean z1 = p0.i(coroutineScope0);
                if((v1 & 0x70) != 0x20) {
                    z = false;
                }
                Ac.J j0 = p0.N();
                if(z1 || z || j0 == v2) {
                    j0 = new Ac.J(13, coroutineScope0, this);
                    p0.l0(j0);
                }
                J.a(coroutineScope0, this, j0, p0);
            }
            else {
                p0.a0(1824275067);
            }
            p0.p(false);
            p0.p(false);
        }
        else {
            p0.a0(0x6CBC613B);
            p0.p(false);
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new s0(this, object0, v, 0);
        }
    }

    public final long b() {
        p p0 = this.i;
        int v = p0.size();
        long v1 = 0L;
        for(int v3 = 0; v3 < v; ++v3) {
            v1 = Math.max(v1, ((o0)p0.get(v3)).j.m());
        }
        p p1 = this.j;
        int v4 = p1.size();
        for(int v2 = 0; v2 < v4; ++v2) {
            v1 = Math.max(v1, ((t0)p1.get(v2)).b());
        }
        return v1;
    }

    public final Object c() {
        return ((O0)this.a.b).getValue();
    }

    public final boolean d() {
        p p0 = this.i;
        int v = p0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            ((o0)p0.get(v1)).getClass();
        }
        p p1 = this.j;
        int v2 = p1.size();
        for(int v3 = 0; v3 < v2; ++v3) {
            if(((t0)p1.get(v3)).d()) {
                return true;
            }
        }
        return false;
    }

    public final long e() {
        return this.b == null ? this.f.m() : this.b.e();
    }

    public final m0 f() {
        return (m0)((O0)this.e).getValue();
    }

    public final boolean g() {
        return ((Boolean)((O0)this.k).getValue()).booleanValue();
    }

    public final void h(long v, boolean z) {
        M0 m00 = this.g;
        int v1 = Long.compare(m00.m(), 0x8000000000000000L);
        P p0 = this.a;
        if(v1 == 0) {
            m00.n(v);
            ((O0)p0.a).setValue(Boolean.TRUE);
        }
        else if(!((Boolean)((O0)p0.a).getValue()).booleanValue()) {
            ((O0)p0.a).setValue(Boolean.TRUE);
        }
        ((O0)this.h).setValue(Boolean.FALSE);
        p p1 = this.i;
        int v2 = p1.size();
        boolean z1 = true;
        for(int v3 = 0; v3 < v2; ++v3) {
            o0 o00 = (o0)p1.get(v3);
            b0 b00 = o00.e;
            if(!((Boolean)((O0)o00.e).getValue()).booleanValue()) {
                long v4 = z ? o00.a().e() : v;
                Object object0 = o00.a().g(v4);
                ((O0)o00.h).setValue(object0);
                o00.i = o00.a().c(v4);
                if(o00.a().d(v4)) {
                    ((O0)b00).setValue(Boolean.TRUE);
                }
            }
            if(!((Boolean)((O0)b00).getValue()).booleanValue()) {
                z1 = false;
            }
        }
        p p2 = this.j;
        int v5 = p2.size();
        for(int v6 = 0; v6 < v5; ++v6) {
            t0 t00 = (t0)p2.get(v6);
            if(!q.b(((O0)t00.d).getValue(), t00.c())) {
                t00.h(v, z);
            }
            if(!q.b(((O0)t00.d).getValue(), t00.c())) {
                z1 = false;
            }
        }
        if(z1) {
            this.i();
        }
    }

    public final void i() {
        this.g.n(0x8000000000000000L);
        P p0 = this.a;
        if(p0 instanceof P) {
            Object object0 = ((O0)this.d).getValue();
            ((O0)p0.b).setValue(object0);
        }
        if(this.b == null) {
            this.f.n(0L);
        }
        ((O0)p0.a).setValue(Boolean.FALSE);
        p p1 = this.j;
        int v = p1.size();
        for(int v1 = 0; v1 < v; ++v1) {
            ((t0)p1.get(v1)).i();
        }
    }

    public final void j(Object object0, Object object1) {
        this.g.n(0x8000000000000000L);
        P p0 = this.a;
        ((O0)p0.a).setValue(Boolean.FALSE);
        boolean z = this.g();
        b0 b00 = this.d;
        if(!z || !q.b(this.c(), object0) || !q.b(((O0)b00).getValue(), object1)) {
            if(!q.b(this.c(), object0) && p0 instanceof P) {
                ((O0)p0.b).setValue(object0);
            }
            ((O0)b00).setValue(object1);
            ((O0)this.k).setValue(Boolean.TRUE);
            n0 n00 = new n0(object0, object1);
            ((O0)this.e).setValue(n00);
        }
        p p1 = this.j;
        int v = p1.size();
        for(int v2 = 0; v2 < v; ++v2) {
            t0 t00 = (t0)p1.get(v2);
            q.e(t00, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Any>");
            if(t00.g()) {
                t00.j(t00.c(), ((O0)t00.d).getValue());
            }
        }
        p p2 = this.i;
        int v3 = p2.size();
        for(int v1 = 0; v1 < v3; ++v1) {
            ((o0)p2.get(v1)).e();
        }
    }

    public final void k(Object object0) {
        b0 b00 = this.d;
        if(!q.b(((O0)b00).getValue(), object0)) {
            n0 n00 = new n0(((O0)b00).getValue(), object0);
            ((O0)this.e).setValue(n00);
            if(!q.b(this.c(), ((O0)b00).getValue())) {
                Object object1 = ((O0)b00).getValue();
                ((O0)this.a.b).setValue(object1);
            }
            ((O0)b00).setValue(object0);
            if(this.g.m() == 0x8000000000000000L) {
                ((O0)this.h).setValue(Boolean.TRUE);
            }
            p p0 = this.i;
            int v = p0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                ((I0)((o0)p0.get(v1)).f).n(-2.0f);
            }
        }
    }

    @Override
    public final String toString() {
        p p0 = this.i;
        int v = p0.size();
        String s = "Transition animation values: ";
        for(int v1 = 0; v1 < v; ++v1) {
            s = s + ((o0)p0.get(v1)) + ", ";
        }
        return s;
    }
}

