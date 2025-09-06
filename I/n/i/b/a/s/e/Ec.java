package i.n.i.b.a.s.e;

public final class ec implements Runnable {
    public final int a;
    public final jc b;

    public ec(jc jc0, int v) {
        this.a = v;
        this.b = jc0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            this.b.w(false);
            return;
        }
        this.b.z();
    }
}

