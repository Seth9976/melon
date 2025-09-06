package io.netty.channel.pool;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReadOnlyIterator;
import java.io.Closeable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

public abstract class AbstractChannelPoolMap implements ChannelPoolMap, Closeable, Iterable {
    private final ConcurrentMap map;

    public AbstractChannelPoolMap() {
        this.map = PlatformDependent.newConcurrentHashMap();
    }

    @Override
    public final void close() {
        for(Object object0: this.map.keySet()) {
            this.removeAsyncIfSupported(object0).syncUninterruptibly();
        }
    }

    @Override  // io.netty.channel.pool.ChannelPoolMap
    public final boolean contains(Object object0) {
        Object object1 = ObjectUtil.checkNotNull(object0, "key");
        return this.map.containsKey(object1);
    }

    @Override  // io.netty.channel.pool.ChannelPoolMap
    public final ChannelPool get(Object object0) {
        Object object1 = ObjectUtil.checkNotNull(object0, "key");
        ChannelPool channelPool0 = (ChannelPool)this.map.get(object1);
        if(channelPool0 == null) {
            channelPool0 = this.newPool(object0);
            ChannelPool channelPool1 = (ChannelPool)this.map.putIfAbsent(object0, channelPool0);
            if(channelPool1 != null) {
                AbstractChannelPoolMap.poolCloseAsyncIfSupported(channelPool0);
                return channelPool1;
            }
        }
        return channelPool0;
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public final Iterator iterator() {
        return new ReadOnlyIterator(this.map.entrySet().iterator());
    }

    public abstract ChannelPool newPool(Object arg1);

    private static Future poolCloseAsyncIfSupported(ChannelPool channelPool0) {
        if(channelPool0 instanceof SimpleChannelPool) {
            return ((SimpleChannelPool)channelPool0).closeAsync();
        }
        try {
            channelPool0.close();
            return GlobalEventExecutor.INSTANCE.newSucceededFuture(null);
        }
        catch(Exception exception0) {
            return GlobalEventExecutor.INSTANCE.newFailedFuture(exception0);
        }
    }

    public final boolean remove(Object object0) {
        Object object1 = ObjectUtil.checkNotNull(object0, "key");
        ChannelPool channelPool0 = (ChannelPool)this.map.remove(object1);
        if(channelPool0 != null) {
            AbstractChannelPoolMap.poolCloseAsyncIfSupported(channelPool0);
            return true;
        }
        return false;
    }

    private Future removeAsyncIfSupported(Object object0) {
        Object object1 = ObjectUtil.checkNotNull(object0, "key");
        ChannelPool channelPool0 = (ChannelPool)this.map.remove(object1);
        if(channelPool0 != null) {
            Future future0 = GlobalEventExecutor.INSTANCE.newPromise();
            AbstractChannelPoolMap.poolCloseAsyncIfSupported(channelPool0).addListener(new GenericFutureListener() {
                @Override  // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future future0) {
                    if(future0.isSuccess()) {
                        ((Promise)future0).setSuccess(Boolean.TRUE);
                        return;
                    }
                    Throwable throwable0 = future0.cause();
                    ((Promise)future0).setFailure(throwable0);
                }
            });
            return future0;
        }
        return GlobalEventExecutor.INSTANCE.newSucceededFuture(Boolean.FALSE);
    }

    public final int size() {
        return this.map.size();
    }
}

