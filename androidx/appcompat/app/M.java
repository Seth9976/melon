package androidx.appcompat.app;

import java.util.concurrent.Executor;

public final class m implements Executor {
    @Override
    public final void execute(Runnable runnable0) {
        new Thread(runnable0).start();
    }
}

