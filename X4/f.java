package X4;

public final class f implements Runnable {
    public final int a;
    public final g b;

    public f(g g0, int v) {
        this.a = v;
        this.b = g0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            g.c(this.b);
            return;
        }
        g.b(this.b);
    }
}

