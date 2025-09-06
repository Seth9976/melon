package k3;

public final class i implements Runnable {
    public final int a;
    public final k b;
    public final Object c;

    public i(k k0, l l0, int v) {
        this.a = v;
        this.b = k0;
        this.c = l0;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                ((l)this.c).e(this.b.a, this.b.b);
                return;
            }
            case 1: {
                ((l)this.c).d(this.b.a, this.b.b);
                return;
            }
            default: {
                ((l)this.c).g(this.b.a, this.b.b);
            }
        }
    }
}

