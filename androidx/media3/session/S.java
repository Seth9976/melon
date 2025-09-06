package androidx.media3.session;

import M6.a;

public final class s implements Runnable {
    public final int a;
    public final x b;
    public final v c;

    public s(x x0, v v0, int v1) {
        this.a = v1;
        this.b = x0;
        this.c = v0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            v v0 = this.c;
            if(this.b.a instanceof a) {
                v0.release();
            }
            return;
        }
        x x0 = this.b;
        v v1 = this.c;
        x0.i = v1;
        if(x0.j) {
            x0.k(v1);
        }
        x0.addListener(new s(x0, v1, 1), new w(x0, 0));
    }
}

