package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.BlockingOperationException;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ImmediateEventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;

final class DefaultChannelGroupFuture extends DefaultPromise implements ChannelGroupFuture {
    static final class DefaultEntry implements Map.Entry {
        private final Object key;
        private final Object value;

        public DefaultEntry(Object object0, Object object1) {
            this.key = object0;
            this.value = object1;
        }

        @Override
        public Object getKey() {
            return this.key;
        }

        @Override
        public Object getValue() {
            return this.value;
        }

        @Override
        public Object setValue(Object object0) {
            throw new UnsupportedOperationException("read-only");
        }
    }

    private final ChannelFutureListener childListener;
    private int failureCount;
    private final Map futures;
    private final ChannelGroup group;
    private int successCount;

    public DefaultChannelGroupFuture(ChannelGroup channelGroup0, Collection collection0, EventExecutor eventExecutor0) {
        super(eventExecutor0);
        this.childListener = new ChannelFutureListener() {
            static final boolean $assertionsDisabled;

            public void operationComplete(ChannelFuture channelFuture0) {
                boolean z = channelFuture0.isSuccess();
                synchronized(DefaultChannelGroupFuture.this) {
                    if(z) {
                        DefaultChannelGroupFuture.access$008(DefaultChannelGroupFuture.this);
                    }
                    else {
                        DefaultChannelGroupFuture.access$108(DefaultChannelGroupFuture.this);
                    }
                }
                if(DefaultChannelGroupFuture.this.successCount + DefaultChannelGroupFuture.this.failureCount == DefaultChannelGroupFuture.this.futures.size()) {
                    if(DefaultChannelGroupFuture.this.failureCount > 0) {
                        ArrayList arrayList0 = new ArrayList(DefaultChannelGroupFuture.this.failureCount);
                        for(Object object0: DefaultChannelGroupFuture.this.futures.values()) {
                            ChannelFuture channelFuture1 = (ChannelFuture)object0;
                            if(!channelFuture1.isSuccess()) {
                                arrayList0.add(new DefaultEntry(channelFuture1.channel(), channelFuture1.cause()));
                            }
                        }
                        ChannelGroupException channelGroupException0 = new ChannelGroupException(arrayList0);
                        DefaultChannelGroupFuture.this.setFailure0(channelGroupException0);
                        return;
                    }
                    DefaultChannelGroupFuture.this.setSuccess0();
                }
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        };
        this.group = (ChannelGroup)ObjectUtil.checkNotNull(channelGroup0, "group");
        ObjectUtil.checkNotNull(collection0, "futures");
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        for(Object object0: collection0) {
            linkedHashMap0.put(((ChannelFuture)object0).channel(), ((ChannelFuture)object0));
        }
        Map map0 = Collections.unmodifiableMap(linkedHashMap0);
        this.futures = map0;
        for(Object object1: map0.values()) {
            ((ChannelFuture)object1).addListener(this.childListener);
        }
        if(this.futures.isEmpty()) {
            this.setSuccess0();
        }
    }

    public DefaultChannelGroupFuture(ChannelGroup channelGroup0, Map map0, EventExecutor eventExecutor0) {
        super(eventExecutor0);
        this.childListener = new ChannelFutureListener() {
            static final boolean $assertionsDisabled;

            public void operationComplete(ChannelFuture channelFuture0) {
                boolean z = channelFuture0.isSuccess();
                synchronized(DefaultChannelGroupFuture.this) {
                    if(z) {
                        DefaultChannelGroupFuture.access$008(DefaultChannelGroupFuture.this);
                    }
                    else {
                        DefaultChannelGroupFuture.access$108(DefaultChannelGroupFuture.this);
                    }
                }
                if(DefaultChannelGroupFuture.this.successCount + DefaultChannelGroupFuture.this.failureCount == DefaultChannelGroupFuture.this.futures.size()) {
                    if(DefaultChannelGroupFuture.this.failureCount > 0) {
                        ArrayList arrayList0 = new ArrayList(DefaultChannelGroupFuture.this.failureCount);
                        for(Object object0: DefaultChannelGroupFuture.this.futures.values()) {
                            ChannelFuture channelFuture1 = (ChannelFuture)object0;
                            if(!channelFuture1.isSuccess()) {
                                arrayList0.add(new DefaultEntry(channelFuture1.channel(), channelFuture1.cause()));
                            }
                        }
                        ChannelGroupException channelGroupException0 = new ChannelGroupException(arrayList0);
                        DefaultChannelGroupFuture.this.setFailure0(channelGroupException0);
                        return;
                    }
                    DefaultChannelGroupFuture.this.setSuccess0();
                }
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        };
        this.group = channelGroup0;
        Map map1 = Collections.unmodifiableMap(map0);
        this.futures = map1;
        for(Object object0: map1.values()) {
            ((ChannelFuture)object0).addListener(this.childListener);
        }
        if(this.futures.isEmpty()) {
            this.setSuccess0();
        }
    }

    public static int access$008(DefaultChannelGroupFuture defaultChannelGroupFuture0) {
        int v = defaultChannelGroupFuture0.successCount;
        defaultChannelGroupFuture0.successCount = v + 1;
        return v;
    }

    public static int access$108(DefaultChannelGroupFuture defaultChannelGroupFuture0) {
        int v = defaultChannelGroupFuture0.failureCount;
        defaultChannelGroupFuture0.failureCount = v + 1;
        return v;
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    public DefaultChannelGroupFuture addListener(GenericFutureListener genericFutureListener0) {
        super.addListener(genericFutureListener0);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public Promise addListener(GenericFutureListener genericFutureListener0) {
        return this.addListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    public DefaultChannelGroupFuture addListeners(GenericFutureListener[] arr_genericFutureListener) {
        super.addListeners(arr_genericFutureListener);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public Promise addListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.addListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture await() {
        return this.await();
    }

    public DefaultChannelGroupFuture await() {
        super.await();
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future await() {
        return this.await();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public Promise await() {
        return this.await();
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    public DefaultChannelGroupFuture awaitUninterruptibly() {
        super.awaitUninterruptibly();
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public Promise awaitUninterruptibly() {
        return this.awaitUninterruptibly();
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupException cause() {
        return (ChannelGroupException)super.cause();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Throwable cause() {
        return this.cause();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public void checkDeadLock() {
        EventExecutor eventExecutor0 = this.executor();
        if(eventExecutor0 != null && eventExecutor0 != ImmediateEventExecutor.INSTANCE && eventExecutor0.inEventLoop()) {
            throw new BlockingOperationException();
        }
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelFuture find(Channel channel0) {
        return (ChannelFuture)this.futures.get(channel0);
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroup group() {
        return this.group;
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public boolean isPartialFailure() {
        synchronized(this) {
            return this.failureCount != 0 && this.failureCount != this.futures.size();
        }
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public boolean isPartialSuccess() {
        synchronized(this) {
            return this.successCount != 0 && this.successCount != this.futures.size();
        }
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public Iterator iterator() {
        return this.futures.values().iterator();
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    public DefaultChannelGroupFuture removeListener(GenericFutureListener genericFutureListener0) {
        super.removeListener(genericFutureListener0);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public Promise removeListener(GenericFutureListener genericFutureListener0) {
        return this.removeListener(genericFutureListener0);
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    public DefaultChannelGroupFuture removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        super.removeListeners(arr_genericFutureListener);
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public Promise removeListeners(GenericFutureListener[] arr_genericFutureListener) {
        return this.removeListeners(arr_genericFutureListener);
    }

    public DefaultChannelGroupFuture setFailure(Throwable throwable0) {
        throw new IllegalStateException();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public Promise setFailure(Throwable throwable0) {
        return this.setFailure(throwable0);
    }

    private void setFailure0(ChannelGroupException channelGroupException0) {
        super.setFailure(channelGroupException0);
    }

    public DefaultChannelGroupFuture setSuccess(Void void0) {
        throw new IllegalStateException();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public Promise setSuccess(Object object0) {
        return this.setSuccess(((Void)object0));
    }

    private void setSuccess0() {
        super.setSuccess(null);
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture sync() {
        return this.sync();
    }

    public DefaultChannelGroupFuture sync() {
        super.sync();
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future sync() {
        return this.sync();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public Promise sync() {
        return this.sync();
    }

    @Override  // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroupFuture syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    public DefaultChannelGroupFuture syncUninterruptibly() {
        super.syncUninterruptibly();
        return this;
    }

    @Override  // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public Promise syncUninterruptibly() {
        return this.syncUninterruptibly();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public boolean tryFailure(Throwable throwable0) {
        throw new IllegalStateException();
    }

    @Override  // io.netty.util.concurrent.DefaultPromise
    public boolean trySuccess(Object object0) {
        return this.trySuccess(((Void)object0));
    }

    public boolean trySuccess(Void void0) {
        throw new IllegalStateException();
    }
}

