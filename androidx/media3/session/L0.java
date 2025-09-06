package androidx.media3.session;

import e3.x;
import java.util.concurrent.Executor;

public final class l0 implements Executor {
    public final int a;
    public final n0 b;

    public l0(n0 n00, int v) {
        this.a = v;
        this.b = n00;
        super();
    }

    @Override
    public final void execute(Runnable runnable0) {
        switch(this.a) {
            case 0: {
                n0.a(this.b, runnable0);
                return;
            }
            case 1: {
                x.P(this.b.l, runnable0);
                return;
            }
            default: {
                x.P(this.b.l, runnable0);
            }
        }
    }
}

