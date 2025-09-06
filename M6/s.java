package M6;

import java.util.concurrent.Executor;

public enum s implements Executor {
    INSTANCE;

    @Override
    public final void execute(Runnable runnable0) {
        runnable0.run();
    }

    @Override
    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}

