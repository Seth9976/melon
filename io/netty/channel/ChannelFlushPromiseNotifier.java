package io.netty.channel;

import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Queue;

public final class ChannelFlushPromiseNotifier {
    static class DefaultFlushCheckpoint implements FlushCheckpoint {
        private long checkpoint;
        private final ChannelPromise future;

        public DefaultFlushCheckpoint(long v, ChannelPromise channelPromise0) {
            this.checkpoint = v;
            this.future = channelPromise0;
        }

        @Override  // io.netty.channel.ChannelFlushPromiseNotifier$FlushCheckpoint
        public long flushCheckpoint() {
            return this.checkpoint;
        }

        @Override  // io.netty.channel.ChannelFlushPromiseNotifier$FlushCheckpoint
        public void flushCheckpoint(long v) {
            this.checkpoint = v;
        }

        @Override  // io.netty.channel.ChannelFlushPromiseNotifier$FlushCheckpoint
        public ChannelPromise promise() {
            return this.future;
        }
    }

    interface FlushCheckpoint {
        long flushCheckpoint();

        void flushCheckpoint(long arg1);

        ChannelPromise promise();
    }

    private final Queue flushCheckpoints;
    private final boolean tryNotify;
    private long writeCounter;

    public ChannelFlushPromiseNotifier() {
        this(false);
    }

    public ChannelFlushPromiseNotifier(boolean z) {
        this.flushCheckpoints = new ArrayDeque();
        this.tryNotify = z;
    }

    @Deprecated
    public ChannelFlushPromiseNotifier add(ChannelPromise channelPromise0, int v) {
        return this.add(channelPromise0, ((long)v));
    }

    public ChannelFlushPromiseNotifier add(ChannelPromise channelPromise0, long v) {
        ObjectUtil.checkNotNull(channelPromise0, "promise");
        ObjectUtil.checkPositiveOrZero(v, "pendingDataSize");
        long v1 = this.writeCounter + v;
        if(channelPromise0 instanceof FlushCheckpoint) {
            ((FlushCheckpoint)channelPromise0).flushCheckpoint(v1);
            this.flushCheckpoints.add(((FlushCheckpoint)channelPromise0));
            return this;
        }
        DefaultFlushCheckpoint channelFlushPromiseNotifier$DefaultFlushCheckpoint0 = new DefaultFlushCheckpoint(v1, channelPromise0);
        this.flushCheckpoints.add(channelFlushPromiseNotifier$DefaultFlushCheckpoint0);
        return this;
    }

    public ChannelFlushPromiseNotifier increaseWriteCounter(long v) {
        ObjectUtil.checkPositiveOrZero(v, "delta");
        this.writeCounter += v;
        return this;
    }

    @Deprecated
    public ChannelFlushPromiseNotifier notifyFlushFutures() {
        return this.notifyPromises();
    }

    @Deprecated
    public ChannelFlushPromiseNotifier notifyFlushFutures(Throwable throwable0) {
        return this.notifyPromises(throwable0);
    }

    @Deprecated
    public ChannelFlushPromiseNotifier notifyFlushFutures(Throwable throwable0, Throwable throwable1) {
        return this.notifyPromises(throwable0, throwable1);
    }

    public ChannelFlushPromiseNotifier notifyPromises() {
        this.notifyPromises0(null);
        return this;
    }

    public ChannelFlushPromiseNotifier notifyPromises(Throwable throwable0) {
        this.notifyPromises();
        FlushCheckpoint channelFlushPromiseNotifier$FlushCheckpoint0;
        while((channelFlushPromiseNotifier$FlushCheckpoint0 = (FlushCheckpoint)this.flushCheckpoints.poll()) != null) {
            if(this.tryNotify) {
                channelFlushPromiseNotifier$FlushCheckpoint0.promise().tryFailure(throwable0);
            }
            else {
                channelFlushPromiseNotifier$FlushCheckpoint0.promise().setFailure(throwable0);
            }
        }
        return this;
    }

    public ChannelFlushPromiseNotifier notifyPromises(Throwable throwable0, Throwable throwable1) {
        this.notifyPromises0(throwable0);
        FlushCheckpoint channelFlushPromiseNotifier$FlushCheckpoint0;
        while((channelFlushPromiseNotifier$FlushCheckpoint0 = (FlushCheckpoint)this.flushCheckpoints.poll()) != null) {
            if(this.tryNotify) {
                channelFlushPromiseNotifier$FlushCheckpoint0.promise().tryFailure(throwable1);
            }
            else {
                channelFlushPromiseNotifier$FlushCheckpoint0.promise().setFailure(throwable1);
            }
        }
        return this;
    }

    private void notifyPromises0(Throwable throwable0) {
        if(this.flushCheckpoints.isEmpty()) {
            this.writeCounter = 0L;
            return;
        }
        long v = this.writeCounter;
        while(true) {
            FlushCheckpoint channelFlushPromiseNotifier$FlushCheckpoint0 = (FlushCheckpoint)this.flushCheckpoints.peek();
            if(channelFlushPromiseNotifier$FlushCheckpoint0 == null) {
                this.writeCounter = 0L;
            }
            else if(channelFlushPromiseNotifier$FlushCheckpoint0.flushCheckpoint() <= v) {
                goto label_21;
            }
            else if(v > 0L && this.flushCheckpoints.size() == 1) {
                this.writeCounter = 0L;
                channelFlushPromiseNotifier$FlushCheckpoint0.flushCheckpoint(channelFlushPromiseNotifier$FlushCheckpoint0.flushCheckpoint() - v);
            }
            long v1 = this.writeCounter;
            if(v1 >= 0x8000000000L) {
                this.writeCounter = 0L;
                for(Object object0: this.flushCheckpoints) {
                    ((FlushCheckpoint)object0).flushCheckpoint(((FlushCheckpoint)object0).flushCheckpoint() - v1);
                }
            }
            return;
        label_21:
            this.flushCheckpoints.remove();
            ChannelPromise channelPromise0 = channelFlushPromiseNotifier$FlushCheckpoint0.promise();
            if(throwable0 == null) {
                if(this.tryNotify) {
                    channelPromise0.trySuccess();
                }
                else {
                    channelPromise0.setSuccess();
                }
            }
            else if(this.tryNotify) {
                channelPromise0.tryFailure(throwable0);
            }
            else {
                channelPromise0.setFailure(throwable0);
            }
        }
    }

    public long writeCounter() {
        return this.writeCounter;
    }
}

