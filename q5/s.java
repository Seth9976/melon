package Q5;

import f5.a;
import java.util.concurrent.Executor;

public final class s implements Executor {
    public final int a;
    public final Object b;

    public s(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override
    public final void execute(Runnable runnable0) {
        if(this.a != 0) {
            ((a)this.b).c.post(runnable0);
            return;
        }
        r r0 = new r(runnable0, 0);
        ((Executor)this.b).execute(r0);
    }
}

