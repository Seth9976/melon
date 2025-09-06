package l4;

public final class c implements Runnable {
    public final int a;
    public final d b;
    public final int c;

    public c(d d0, int v, int v1) {
        this.a = v1;
        this.b = d0;
        this.c = v;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            O o0 = this.b.g.c.d;
            if(o0 != null) {
                o0.k(this.c);
            }
            return;
        }
        O o1 = this.b.g.c.d;
        if(o1 != null) {
            o1.j(this.c);
        }
    }
}

