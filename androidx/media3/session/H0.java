package androidx.media3.session;

import M6.B;
import M6.H;
import M6.a;

public final class h0 implements Runnable {
    public final int a;
    public final H b;
    public final B c;

    public h0(H h0, B b0, int v) {
        this.a = v;
        this.b = h0;
        this.c = b0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            B b0 = this.c;
            if(this.b.a instanceof a) {
                b0.cancel(false);
            }
            return;
        }
        B b1 = this.c;
        if(this.b.a instanceof a) {
            b1.cancel(false);
        }
    }
}

