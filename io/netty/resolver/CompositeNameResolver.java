package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import k8.Y;

public final class CompositeNameResolver extends SimpleNameResolver {
    private final NameResolver[] resolvers;

    public CompositeNameResolver(EventExecutor eventExecutor0, NameResolver[] arr_nameResolver) {
        super(eventExecutor0);
        ObjectUtil.checkNotNull(arr_nameResolver, "resolvers");
        for(int v = 0; v < arr_nameResolver.length; ++v) {
            ObjectUtil.checkNotNull(arr_nameResolver[v], "resolvers[" + v + ']');
        }
        if(arr_nameResolver.length < 2) {
            throw new IllegalArgumentException(Y.m(new StringBuilder("resolvers: "), Arrays.asList(arr_nameResolver), " (expected: at least 2 resolvers)"));
        }
        this.resolvers = (NameResolver[])arr_nameResolver.clone();
    }

    @Override  // io.netty.resolver.SimpleNameResolver
    public void doResolve(String s, Promise promise0) {
        this.doResolveRec(s, promise0, 0, null);
    }

    @Override  // io.netty.resolver.SimpleNameResolver
    public void doResolveAll(String s, Promise promise0) {
        this.doResolveAllRec(s, promise0, 0, null);
    }

    private void doResolveAllRec(String s, Promise promise0, int v, Throwable throwable0) {
        NameResolver[] arr_nameResolver = this.resolvers;
        if(v >= arr_nameResolver.length) {
            promise0.setFailure(throwable0);
            return;
        }
        arr_nameResolver[v].resolveAll(s).addListener(new FutureListener() {
            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                if(future0.isSuccess()) {
                    Object object0 = future0.getNow();
                    promise0.setSuccess(object0);
                    return;
                }
                Throwable throwable0 = future0.cause();
                CompositeNameResolver.this.doResolveAllRec(s, promise0, v + 1, throwable0);
            }
        });
    }

    private void doResolveRec(String s, Promise promise0, int v, Throwable throwable0) {
        NameResolver[] arr_nameResolver = this.resolvers;
        if(v >= arr_nameResolver.length) {
            promise0.setFailure(throwable0);
            return;
        }
        arr_nameResolver[v].resolve(s).addListener(new FutureListener() {
            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                if(future0.isSuccess()) {
                    Object object0 = future0.getNow();
                    promise0.setSuccess(object0);
                    return;
                }
                Throwable throwable0 = future0.cause();
                CompositeNameResolver.this.doResolveRec(s, promise0, v + 1, throwable0);
            }
        });
    }
}

