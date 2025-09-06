package y3;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import t9.B;

public final class a implements Executor {
    public final Executor a;
    public final B b;

    public a(ExecutorService executorService0, B b0) {
        this.a = executorService0;
        this.b = b0;
    }

    @Override
    public final void execute(Runnable runnable0) {
        this.a.execute(runnable0);
    }
}

