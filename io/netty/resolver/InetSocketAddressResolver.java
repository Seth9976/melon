package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.Promise;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

public class InetSocketAddressResolver extends AbstractAddressResolver {
    final NameResolver nameResolver;

    public InetSocketAddressResolver(EventExecutor eventExecutor0, NameResolver nameResolver0) {
        super(eventExecutor0, InetSocketAddress.class);
        this.nameResolver = nameResolver0;
    }

    @Override  // io.netty.resolver.AbstractAddressResolver
    public void close() {
        this.nameResolver.close();
    }

    public boolean doIsResolved(InetSocketAddress inetSocketAddress0) {
        return !inetSocketAddress0.isUnresolved();
    }

    @Override  // io.netty.resolver.AbstractAddressResolver
    public boolean doIsResolved(SocketAddress socketAddress0) {
        return this.doIsResolved(((InetSocketAddress)socketAddress0));
    }

    public void doResolve(InetSocketAddress inetSocketAddress0, Promise promise0) {
        String s = inetSocketAddress0.getHostName();
        this.nameResolver.resolve(s).addListener(new FutureListener() {
            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                if(future0.isSuccess()) {
                    InetSocketAddress inetSocketAddress0 = new InetSocketAddress(((InetAddress)future0.getNow()), inetSocketAddress0.getPort());
                    promise0.setSuccess(inetSocketAddress0);
                    return;
                }
                Throwable throwable0 = future0.cause();
                promise0.setFailure(throwable0);
            }
        });
    }

    @Override  // io.netty.resolver.AbstractAddressResolver
    public void doResolve(SocketAddress socketAddress0, Promise promise0) {
        this.doResolve(((InetSocketAddress)socketAddress0), promise0);
    }

    public void doResolveAll(InetSocketAddress inetSocketAddress0, Promise promise0) {
        String s = inetSocketAddress0.getHostName();
        this.nameResolver.resolveAll(s).addListener(new FutureListener() {
            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                if(future0.isSuccess()) {
                    List list0 = (List)future0.getNow();
                    ArrayList arrayList0 = new ArrayList(list0.size());
                    for(Object object0: list0) {
                        arrayList0.add(new InetSocketAddress(((InetAddress)object0), inetSocketAddress0.getPort()));
                    }
                    promise0.setSuccess(arrayList0);
                    return;
                }
                Throwable throwable0 = future0.cause();
                promise0.setFailure(throwable0);
            }
        });
    }

    @Override  // io.netty.resolver.AbstractAddressResolver
    public void doResolveAll(SocketAddress socketAddress0, Promise promise0) {
        this.doResolveAll(((InetSocketAddress)socketAddress0), promise0);
    }
}

