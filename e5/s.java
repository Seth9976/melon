package e5;

import U4.w;
import X4.f;
import X4.g;
import d5.j;

public final class s implements Runnable {
    public final t a;
    public final j b;

    public s(t t0, j j0) {
        this.a = t0;
        this.b = j0;
    }

    @Override
    public final void run() {
        synchronized(this.a.d) {
            if(((s)this.a.b.remove(this.b)) == null) {
                w.e().a("WrkTimerRunnable", "Timer with " + this.b + " is already marked as complete.");
            }
            else {
                r r0 = (r)this.a.c.remove(this.b);
                if(r0 != null) {
                    w.e().a("WM-DelayMetCommandHandl", "Exceeded time limits on execution for " + this.b);
                    f f0 = new f(((g)r0), 0);
                    ((g)r0).h.execute(f0);
                }
            }
        }
    }
}

