package z3;

import b3.z0;

public final class c implements Runnable {
    public final int a;
    public final p b;

    public c(d d0, p p0, int v) {
        this.a = v;
        this.b = p0;
        super();
    }

    public c(d d0, p p0, z0 z00) {
        this.a = 0;
        super();
        this.b = p0;
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                this.b.getClass();
                return;
            }
            case 1: {
                this.b.a();
                return;
            }
            default: {
                this.b.c();
            }
        }
    }
}

