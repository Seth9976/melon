package Z1;

import java.util.concurrent.ThreadFactory;

public final class k implements ThreadFactory {
    @Override
    public final Thread newThread(Runnable runnable0) {
        return new j(runnable0);
    }
}

