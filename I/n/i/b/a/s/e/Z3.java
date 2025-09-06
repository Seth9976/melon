package i.n.i.b.a.s.e;

public final class z3 implements Runnable {
    public final int a;
    public final D3 b;

    public z3(D3 d30, int v) {
        this.a = v;
        this.b = d30;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            this.b.Z = true;
            this.b.x();
            return;
        }
        this.b.x();
    }
}

