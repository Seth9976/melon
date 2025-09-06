package J7;

import L7.d;
import b7.b;

public final class a implements Runnable {
    public final int a;
    public final b b;
    public final d c;

    public a(b b0, d d0, int v) {
        this.a = v;
        this.b = b0;
        this.c = d0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            this.b.a(this.c);
            return;
        }
        this.b.a(this.c);
    }
}

