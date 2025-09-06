package i.n.i.b.a.s.e;

public final class r5 implements Runnable {
    public final int a;
    public final v5 b;

    public r5(v5 v50, int v) {
        this.a = v;
        this.b = v50;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            v5 v50 = this.b;
            if(!v50.g0) {
                u0 u00 = v50.r;
                u00.getClass();
                u00.b(v50);
            }
            return;
        }
        this.b.u();
    }
}

