package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.PlatformDependent;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundRobinInetAddressResolver extends InetNameResolver {
    private final NameResolver nameResolver;

    public RoundRobinInetAddressResolver(EventExecutor eventExecutor0, NameResolver nameResolver0) {
        super(eventExecutor0);
        this.nameResolver = nameResolver0;
    }

    @Override  // io.netty.resolver.SimpleNameResolver
    public void close() {
        this.nameResolver.close();
    }

    @Override  // io.netty.resolver.SimpleNameResolver
    public void doResolve(String s, Promise promise0) {
        this.nameResolver.resolveAll(s).addListener(new FutureListener() {
            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                if(future0.isSuccess()) {
                    List list0 = (List)future0.getNow();
                    int v = list0.size();
                    if(v > 0) {
                        Object object0 = list0.get(RoundRobinInetAddressResolver.randomIndex(v));
                        promise0.setSuccess(object0);
                        return;
                    }
                    UnknownHostException unknownHostException0 = new UnknownHostException(s);
                    promise0.setFailure(unknownHostException0);
                    return;
                }
                Throwable throwable0 = future0.cause();
                promise0.setFailure(throwable0);
            }
        });
    }

    @Override  // io.netty.resolver.SimpleNameResolver
    public void doResolveAll(String s, Promise promise0) {
        this.nameResolver.resolveAll(s).addListener(new FutureListener() {
            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                if(future0.isSuccess()) {
                    List list0 = (List)future0.getNow();
                    if(!list0.isEmpty()) {
                        ArrayList arrayList0 = new ArrayList(list0);
                        Collections.rotate(arrayList0, RoundRobinInetAddressResolver.randomIndex(list0.size()));
                        promise0.setSuccess(arrayList0);
                        return;
                    }
                    promise0.setSuccess(list0);
                    return;
                }
                Throwable throwable0 = future0.cause();
                promise0.setFailure(throwable0);
            }
        });
    }

    private static int randomIndex(int v) {
        return v == 1 ? 0 : PlatformDependent.threadLocalRandom().nextInt(v);
    }
}

