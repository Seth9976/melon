package cd;

import androidx.compose.runtime.b0;
import ie.H;
import we.a;

public final class z1 implements a {
    public final int a;
    public final q1 b;
    public final int c;
    public final b0 d;

    public z1(q1 q10, int v, b0 b00, int v1) {
        this.a = v1;
        this.b = q10;
        this.c = v;
        this.d = b00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                cd.a a1 = (cd.a)this.d.getValue();
                r1 r10 = new r1(this.b, this.c, a1);
                this.b.b.invoke(r10);
                return H.a;
            }
            case 1: {
                cd.a a2 = (cd.a)this.d.getValue();
                t1 t10 = new t1(this.b, this.c, a2);
                this.b.b.invoke(t10);
                return H.a;
            }
            default: {
                cd.a a0 = (cd.a)this.d.getValue();
                s1 s10 = new s1(this.b, this.c, a0);
                this.b.b.invoke(s10);
                return H.a;
            }
        }
    }
}

