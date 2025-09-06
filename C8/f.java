package C8;

import Rc.W;
import ie.H;
import we.a;
import we.k;

public final class f implements a {
    public final int a;
    public final k b;
    public final int c;

    public f(k k0, int v, int v1) {
        this.a = v1;
        this.b = k0;
        this.c = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            W w0 = new W(this.c);
            this.b.invoke(w0);
            return H.a;
        }
        this.b.invoke(this.c);
        return H.a;
    }
}

