package androidx.lifecycle;

public final class s0 implements Runnable {
    public final int a;
    public final t b;
    public final t0 c;

    public s0(t t0, t0 t00, int v) {
        this.a = v;
        this.b = t0;
        this.c = t00;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            this.b.c(this.c);
            return;
        }
        this.b.a(this.c);
    }
}

