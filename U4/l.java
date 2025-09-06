package U4;

import java.util.concurrent.Executor;
import kotlin.jvm.internal.q;

public enum l implements Executor {
    INSTANCE;

    @Override
    public final void execute(Runnable runnable0) {
        q.g(runnable0, "command");
        runnable0.run();
    }

    @Override
    public final String toString() {
        return "DirectExecutor";
    }
}

