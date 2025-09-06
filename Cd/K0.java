package cd;

import ie.H;
import we.a;

public final class k0 implements a {
    public final int a;
    public final d0 b;

    public k0(d0 d00, int v) {
        this.a = v;
        this.b = d00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            f0 f00 = new f0(this.b);
            this.b.b.invoke(f00);
            return H.a;
        }
        e0 e00 = new e0(this.b);
        this.b.b.invoke(e00);
        return H.a;
    }
}

