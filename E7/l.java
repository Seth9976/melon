package e7;

import A1.g;

public final class l implements Runnable {
    public final int a;
    public final o b;
    public final g c;

    public l(o o0, g g0, int v) {
        this.a = v;
        this.b = o0;
        this.c = g0;
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

