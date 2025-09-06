package Cc;

import androidx.compose.runtime.l;
import hd.d;
import ie.H;
import we.a;
import we.n;

public final class y implements n {
    public final int a;
    public final boolean b;
    public final float c;
    public final Object d;

    public y(float f, String s, int v, boolean z) {
        this.a = 1;
        super();
        this.d = s;
        this.b = z;
        this.c = f;
    }

    public y(d d0, float f, boolean z, int v) {
        this.a = 2;
        super();
        this.d = d0;
        this.c = f;
        this.b = z;
    }

    public y(boolean z, float f, a a0, int v) {
        this.a = 0;
        super();
        this.b = z;
        this.c = f;
        this.d = a0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                e0.j(this.b, this.c, ((a)this.d), ((l)object0), 1);
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                Rc.a.A(((String)this.d), this.b, this.c, ((l)object0), 1);
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                hd.H.a(((d)this.d), this.c, this.b, ((l)object0), 1);
                return H.a;
            }
        }
    }
}

