package androidx.media3.session;

import M6.x;

public final class m0 implements Runnable {
    public final int a;
    public final n0 b;
    public final x c;
    public final w0 d;

    public m0(n0 n00, x x0, w0 w00, int v) {
        this.a = v;
        this.b = n00;
        this.c = x0;
        this.d = w00;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            n0 n00 = this.b;
            n00.getClass();
            r r0 = (r)n0.H(this.c);
            if(r0 != null) {
                n00.n(this.d, r0);
            }
            return;
        }
        n0 n01 = this.b;
        n01.getClass();
        r r1 = (r)n0.H(this.c);
        if(r1 != null) {
            n01.n(this.d, r1);
        }
    }
}

