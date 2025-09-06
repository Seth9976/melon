package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;

public abstract class SimpleNameResolver implements NameResolver {
    private final EventExecutor executor;

    public SimpleNameResolver(EventExecutor eventExecutor0) {
        this.executor = (EventExecutor)ObjectUtil.checkNotNull(eventExecutor0, "executor");
    }

    @Override  // io.netty.resolver.NameResolver
    public void close() {
    }

    public abstract void doResolve(String arg1, Promise arg2);

    public abstract void doResolveAll(String arg1, Promise arg2);

    public EventExecutor executor() {
        return this.executor;
    }

    @Override  // io.netty.resolver.NameResolver
    public final Future resolve(String s) {
        return this.resolve(s, this.executor().newPromise());
    }

    @Override  // io.netty.resolver.NameResolver
    public Future resolve(String s, Promise promise0) {
        ObjectUtil.checkNotNull(promise0, "promise");
        try {
            this.doResolve(s, promise0);
            return promise0;
        }
        catch(Exception exception0) {
            return promise0.setFailure(exception0);
        }
    }

    @Override  // io.netty.resolver.NameResolver
    public final Future resolveAll(String s) {
        return this.resolveAll(s, this.executor().newPromise());
    }

    @Override  // io.netty.resolver.NameResolver
    public Future resolveAll(String s, Promise promise0) {
        ObjectUtil.checkNotNull(promise0, "promise");
        try {
            this.doResolveAll(s, promise0);
            return promise0;
        }
        catch(Exception exception0) {
            return promise0.setFailure(exception0);
        }
    }
}

