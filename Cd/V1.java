package cd;

import androidx.compose.runtime.b0;
import ie.H;
import we.a;

public final class v1 implements a {
    public final int a;
    public final B1 b;
    public final b0 c;

    public v1(B1 b10, b0 b00, int v) {
        this.a = v;
        this.b = b10;
        this.c = b00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            cd.a a0 = (cd.a)this.c.getValue();
            E1 e10 = new E1(this.b, a0);
            this.b.d.invoke(e10);
            return H.a;
        }
        cd.a a1 = (cd.a)this.c.getValue();
        D1 d10 = new D1(this.b, a1);
        this.b.d.invoke(d10);
        return H.a;
    }
}

