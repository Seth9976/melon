package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.Closeable;
import java.util.IdentityHashMap;
import java.util.Map.Entry;
import java.util.Map;

public abstract class AddressResolverGroup implements Closeable {
    private final Map executorTerminationListeners;
    private static final InternalLogger logger;
    private final Map resolvers;

    static {
        AddressResolverGroup.logger = InternalLoggerFactory.getInstance(AddressResolverGroup.class);
    }

    public AddressResolverGroup() {
        this.resolvers = new IdentityHashMap();
        this.executorTerminationListeners = new IdentityHashMap();
    }

    @Override
    public void close() {
        Map.Entry[] arr_map$Entry;
        AddressResolver[] arr_addressResolver;
        synchronized(this.resolvers) {
            arr_addressResolver = (AddressResolver[])this.resolvers.values().toArray(new AddressResolver[0]);
            this.resolvers.clear();
            arr_map$Entry = (Map.Entry[])this.executorTerminationListeners.entrySet().toArray(new Map.Entry[0]);
            this.executorTerminationListeners.clear();
        }
        for(int v2 = 0; v2 < arr_map$Entry.length; ++v2) {
            Map.Entry map$Entry0 = arr_map$Entry[v2];
            ((EventExecutor)map$Entry0.getKey()).terminationFuture().removeListener(((GenericFutureListener)map$Entry0.getValue()));
        }
        for(int v1 = 0; v1 < arr_addressResolver.length; ++v1) {
            AddressResolver addressResolver0 = arr_addressResolver[v1];
            try {
                addressResolver0.close();
            }
            catch(Throwable throwable0) {
                AddressResolverGroup.logger.warn("Failed to close a resolver:", throwable0);
            }
        }
    }

    public AddressResolver getResolver(EventExecutor eventExecutor0) {
        ObjectUtil.checkNotNull(eventExecutor0, "executor");
        if(!eventExecutor0.isShuttingDown()) {
            synchronized(this.resolvers) {
                AddressResolver addressResolver0 = (AddressResolver)this.resolvers.get(eventExecutor0);
                if(addressResolver0 == null) {
                    try {
                        addressResolver0 = this.newResolver(eventExecutor0);
                    }
                    catch(Exception exception0) {
                        throw new IllegalStateException("failed to create a new resolver", exception0);
                    }
                    this.resolvers.put(eventExecutor0, addressResolver0);
                    io.netty.resolver.AddressResolverGroup.1 addressResolverGroup$10 = new FutureListener() {
                        @Override  // io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(Future future0) {
                            synchronized(AddressResolverGroup.this.resolvers) {
                                AddressResolverGroup.this.resolvers.remove(eventExecutor0);
                                AddressResolverGroup.this.executorTerminationListeners.remove(eventExecutor0);
                            }
                            addressResolver0.close();
                        }
                    };
                    this.executorTerminationListeners.put(eventExecutor0, addressResolverGroup$10);
                    eventExecutor0.terminationFuture().addListener(addressResolverGroup$10);
                }
                return addressResolver0;
            }
        }
        throw new IllegalStateException("executor not accepting a task");
    }

    public abstract AddressResolver newResolver(EventExecutor arg1);
}

