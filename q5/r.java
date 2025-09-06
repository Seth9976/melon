package Q5;

import Q1.c;

public final class r implements Runnable {
    public final int a;
    public final Runnable b;

    public r(Runnable runnable0, int v) {
        this.a = v;
        this.b = runnable0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            this.b.run();
            return;
        }
        try {
            this.b.run();
        }
        catch(Exception exception0) {
            c.u(exception0, "Executor", "Background execution failure.");
        }
    }

    @Override
    public String toString() {
        return this.a == 1 ? this.b.toString() : super.toString();
    }
}

