package G;

import androidx.compose.runtime.O0;
import ie.H;
import kotlin.jvm.internal.r;
import p0.h;
import p0.l;
import p0.m;
import we.k;
import we.n;

public final class d0 extends r implements k {
    public final int f;
    public final r g;

    public d0(int v, k k0) {
        this.f = v;
        switch(v) {
            case 2: {
                this.g = (r)k0;
                super(1);
                return;
            }
            case 3: {
                this.g = (r)k0;
                super(1);
                return;
            }
            default: {
                this.g = (r)k0;
                super(1);
            }
        }
    }

    public d0(n n0) {
        this.f = 0;
        this.g = (r)n0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                Object object1 = ((O0)((G.n)object0).e).getValue();
                ((n)this.g).invoke(object1, ((q)((G.n)object0).f).a);
                return H.a;
            }
            case 1: {
                return ((k)this.g).invoke(((Number)object0).longValue());
            }
            case 2: {
                return ((k)this.g).invoke(((long)(((Number)object0).longValue() / 1000000L)));
            }
            default: {
                h h0 = (h)((k)this.g).invoke(((l)object0));
                synchronized(m.b) {
                    m.c = m.c.g(h0.g());
                    return h0;
                }
            }
        }
    }
}

