package e7;

import g7.d;

public final class m implements Runnable {
    public final int a;
    public final o b;
    public final long c;
    public final String d;

    public m(o o0, long v, String s, int v1) {
        this.a = v1;
        this.b = o0;
        this.c = v;
        this.d = s;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            k k0 = this.b.g;
            if(k0.n == null || !k0.n.e.get()) {
                ((d)k0.i.b).k(this.c, this.d);
            }
            return;
        }
        m m0 = new m(this.b, this.c, this.d, 1);
        this.b.o.b.a(m0);
    }
}

