package o5;

import d5.n;
import i5.c;
import java.util.List;
import ne.a;
import t5.j;
import u5.g;

public final class l {
    public final j a;
    public final List b;
    public final int c;
    public final j d;
    public final g e;
    public final c f;
    public final boolean g;

    public l(j j0, List list0, int v, j j1, g g0, c c0, boolean z) {
        this.a = j0;
        this.b = list0;
        this.c = v;
        this.d = j1;
        this.e = g0;
        this.f = c0;
        this.g = z;
    }

    public final void a(j j0, o5.j j1) {
        j j2 = this.a;
        if(j0.a != j2.a) {
            throw new IllegalStateException(("Interceptor \'" + j1 + "\' cannot modify the request\'s context.").toString());
        }
        if(j0.b == t5.l.b) {
            throw new IllegalStateException(("Interceptor \'" + j1 + "\' cannot set the request\'s data to null.").toString());
        }
        if(j0.c != j2.c) {
            throw new IllegalStateException(("Interceptor \'" + j1 + "\' cannot modify the request\'s target.").toString());
        }
        if(j0.x != j2.x) {
            throw new IllegalStateException(("Interceptor \'" + j1 + "\' cannot modify the request\'s lifecycle.").toString());
        }
        if(j0.y != j2.y) {
            throw new IllegalStateException(("Interceptor \'" + j1 + "\' cannot modify the request\'s size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
        }
    }

    public final Object b(j j0, oe.c c0) {
        l l1;
        o5.j j2;
        k k0;
        if(c0 instanceof k) {
            k0 = (k)c0;
            int v = k0.E;
            if((v & 0x80000000) == 0) {
                k0 = new k(this, c0);
            }
            else {
                k0.E = v ^ 0x80000000;
            }
        }
        else {
            k0 = new k(this, c0);
        }
        Object object0 = k0.B;
        a a0 = a.a;
        switch(k0.E) {
            case 0: {
                n.D(object0);
                List list0 = this.b;
                int v1 = this.c;
                if(v1 > 0) {
                    this.a(j0, ((o5.j)list0.get(v1 - 1)));
                }
                o5.j j1 = (o5.j)list0.get(v1);
                l l0 = new l(this.a, this.b, v1 + 1, j0, this.e, this.f, this.g);
                k0.r = this;
                k0.w = j1;
                k0.E = 1;
                Object object1 = j1.a(l0, k0);
                if(object1 == a0) {
                    return a0;
                }
                object0 = object1;
                j2 = j1;
                l1 = this;
                break;
            }
            case 1: {
                j2 = k0.w;
                l1 = k0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        l1.a(((t5.k)object0).b(), j2);
        return (t5.k)object0;
    }
}

