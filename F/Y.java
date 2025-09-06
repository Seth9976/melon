package F;

import G.P;
import androidx.compose.animation.a;
import androidx.compose.animation.b;
import androidx.compose.runtime.l;
import ie.H;
import ie.f;
import kotlin.jvm.internal.r;
import r0.e;
import r0.q;
import we.k;
import we.n;

public final class y extends r implements n {
    public final int f;
    public final Object g;
    public final q h;
    public final Object i;
    public final Object j;
    public final String k;
    public final f l;

    public y(Object object0, q q0, Object object1, Object object2, String s, f f0, int v, int v1) {
        this.f = v1;
        this.g = object0;
        this.h = q0;
        this.i = object1;
        this.j = object2;
        this.k = s;
        this.l = f0;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.f) {
            case 0: {
                ((Number)object1).intValue();
                b.e(((P)this.g), this.h, ((X)this.i), ((Y)this.j), this.k, ((m0.b)this.l), ((l)object0), 0x180C07);
                return H.a;
            }
            case 1: {
                ((Number)object1).intValue();
                b.b(((P)this.g), this.h, ((X)this.i), ((Y)this.j), this.k, ((m0.b)this.l), ((l)object0), 0x30001);
                return H.a;
            }
            default: {
                ((Number)object1).intValue();
                a.b(this.g, this.h, ((k)this.i), ((e)this.j), this.k, ((k)this.l), ((l)object0), 0x186181);
                return H.a;
            }
        }
    }
}

