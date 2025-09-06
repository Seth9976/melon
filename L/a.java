package l;

import java.util.concurrent.Executor;

public final class a implements Executor {
    public final int a;

    public a(int v) {
        this.a = v;
        super();
    }

    private final void a(Runnable runnable0) {
    }

    @Override
    public final void execute(Runnable runnable0) {
        switch(this.a) {
            case 0: {
                b.P().g.h.execute(runnable0);
                return;
            }
            case 1: {
                runnable0.run();
            }
        }
    }
}

