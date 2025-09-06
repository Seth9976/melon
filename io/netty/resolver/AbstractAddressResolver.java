package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.TypeParameterMatcher;
import java.net.SocketAddress;
import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Collections;
import java.util.List;

public abstract class AbstractAddressResolver implements AddressResolver {
    private final EventExecutor executor;
    private final TypeParameterMatcher matcher;

    public AbstractAddressResolver(EventExecutor eventExecutor0) {
        this.executor = (EventExecutor)ObjectUtil.checkNotNull(eventExecutor0, "executor");
        this.matcher = TypeParameterMatcher.find(this, AbstractAddressResolver.class, "T");
    }

    public AbstractAddressResolver(EventExecutor eventExecutor0, Class class0) {
        this.executor = (EventExecutor)ObjectUtil.checkNotNull(eventExecutor0, "executor");
        this.matcher = TypeParameterMatcher.get(class0);
    }

    @Override  // io.netty.resolver.AddressResolver
    public void close() {
    }

    public abstract boolean doIsResolved(SocketAddress arg1);

    public abstract void doResolve(SocketAddress arg1, Promise arg2);

    public abstract void doResolveAll(SocketAddress arg1, Promise arg2);

    public EventExecutor executor() {
        return this.executor;
    }

    @Override  // io.netty.resolver.AddressResolver
    public final boolean isResolved(SocketAddress socketAddress0) {
        if(!this.isSupported(socketAddress0)) {
            throw new UnsupportedAddressTypeException();
        }
        return this.doIsResolved(socketAddress0);
    }

    @Override  // io.netty.resolver.AddressResolver
    public boolean isSupported(SocketAddress socketAddress0) {
        return this.matcher.match(socketAddress0);
    }

    @Override  // io.netty.resolver.AddressResolver
    public final Future resolve(SocketAddress socketAddress0) {
        if(!this.isSupported(((SocketAddress)ObjectUtil.checkNotNull(socketAddress0, "address")))) {
            return this.executor().newFailedFuture(new UnsupportedAddressTypeException());
        }
        if(this.isResolved(socketAddress0)) {
            return this.executor.newSucceededFuture(socketAddress0);
        }
        try {
            Future future0 = this.executor().newPromise();
            this.doResolve(socketAddress0, ((Promise)future0));
            return future0;
        }
        catch(Exception exception0) {
            return this.executor().newFailedFuture(exception0);
        }
    }

    @Override  // io.netty.resolver.AddressResolver
    public final Future resolve(SocketAddress socketAddress0, Promise promise0) {
        ObjectUtil.checkNotNull(socketAddress0, "address");
        ObjectUtil.checkNotNull(promise0, "promise");
        if(!this.isSupported(socketAddress0)) {
            return promise0.setFailure(new UnsupportedAddressTypeException());
        }
        if(this.isResolved(socketAddress0)) {
            return promise0.setSuccess(socketAddress0);
        }
        try {
            this.doResolve(socketAddress0, promise0);
            return promise0;
        }
        catch(Exception exception0) {
            return promise0.setFailure(exception0);
        }
    }

    @Override  // io.netty.resolver.AddressResolver
    public final Future resolveAll(SocketAddress socketAddress0) {
        if(!this.isSupported(((SocketAddress)ObjectUtil.checkNotNull(socketAddress0, "address")))) {
            return this.executor().newFailedFuture(new UnsupportedAddressTypeException());
        }
        if(this.isResolved(socketAddress0)) {
            List list0 = Collections.singletonList(socketAddress0);
            return this.executor.newSucceededFuture(list0);
        }
        try {
            Future future0 = this.executor().newPromise();
            this.doResolveAll(socketAddress0, ((Promise)future0));
            return future0;
        }
        catch(Exception exception0) {
            return this.executor().newFailedFuture(exception0);
        }
    }

    @Override  // io.netty.resolver.AddressResolver
    public final Future resolveAll(SocketAddress socketAddress0, Promise promise0) {
        ObjectUtil.checkNotNull(socketAddress0, "address");
        ObjectUtil.checkNotNull(promise0, "promise");
        if(!this.isSupported(socketAddress0)) {
            return promise0.setFailure(new UnsupportedAddressTypeException());
        }
        if(this.isResolved(socketAddress0)) {
            return promise0.setSuccess(Collections.singletonList(socketAddress0));
        }
        try {
            this.doResolveAll(socketAddress0, promise0);
            return promise0;
        }
        catch(Exception exception0) {
            return promise0.setFailure(exception0);
        }
    }
}

