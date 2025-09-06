package io.netty.channel;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.PromiseCombiner;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public final class PendingWriteQueue {
    static final class PendingWrite {
        private static final ObjectPool RECYCLER;
        private final Handle handle;
        private Object msg;
        private PendingWrite next;
        private ChannelPromise promise;
        private long size;

        static {
            PendingWrite.RECYCLER = ObjectPool.newPool(new ObjectCreator() {
                public PendingWrite newObject(Handle objectPool$Handle0) {
                    return new PendingWrite(objectPool$Handle0, null);
                }

                @Override  // io.netty.util.internal.ObjectPool$ObjectCreator
                public Object newObject(Handle objectPool$Handle0) {
                    return this.newObject(objectPool$Handle0);
                }
            });
        }

        private PendingWrite(Handle objectPool$Handle0) {
            this.handle = objectPool$Handle0;
        }

        public PendingWrite(Handle objectPool$Handle0, io.netty.channel.PendingWriteQueue.1 pendingWriteQueue$10) {
            this(objectPool$Handle0);
        }

        public static PendingWrite access$000(PendingWrite pendingWriteQueue$PendingWrite0) {
            return pendingWriteQueue$PendingWrite0.next;
        }

        public static PendingWrite access$002(PendingWrite pendingWriteQueue$PendingWrite0, PendingWrite pendingWriteQueue$PendingWrite1) {
            pendingWriteQueue$PendingWrite0.next = pendingWriteQueue$PendingWrite1;
            return pendingWriteQueue$PendingWrite1;
        }

        public static long access$100(PendingWrite pendingWriteQueue$PendingWrite0) {
            return pendingWriteQueue$PendingWrite0.size;
        }

        public static Object access$200(PendingWrite pendingWriteQueue$PendingWrite0) {
            return pendingWriteQueue$PendingWrite0.msg;
        }

        public static ChannelPromise access$300(PendingWrite pendingWriteQueue$PendingWrite0) {
            return pendingWriteQueue$PendingWrite0.promise;
        }

        public static void access$400(PendingWrite pendingWriteQueue$PendingWrite0) {
            pendingWriteQueue$PendingWrite0.recycle();
        }

        public static PendingWrite newInstance(Object object0, int v, ChannelPromise channelPromise0) {
            PendingWrite pendingWriteQueue$PendingWrite0 = (PendingWrite)PendingWrite.RECYCLER.get();
            pendingWriteQueue$PendingWrite0.size = (long)v;
            pendingWriteQueue$PendingWrite0.msg = object0;
            pendingWriteQueue$PendingWrite0.promise = channelPromise0;
            return pendingWriteQueue$PendingWrite0;
        }

        private void recycle() {
            this.size = 0L;
            this.next = null;
            this.msg = null;
            this.promise = null;
            this.handle.recycle(this);
        }
    }

    static final boolean $assertionsDisabled;
    private static final int PENDING_WRITE_OVERHEAD;
    private long bytes;
    private final EventExecutor executor;
    private PendingWrite head;
    private final ChannelOutboundInvoker invoker;
    private static final InternalLogger logger;
    private int size;
    private PendingWrite tail;
    private final PendingBytesTracker tracker;

    static {
        PendingWriteQueue.logger = InternalLoggerFactory.getInstance(PendingWriteQueue.class);
        PendingWriteQueue.PENDING_WRITE_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.pendingWriteSizeOverhead", 0x40);
    }

    public PendingWriteQueue(Channel channel0) {
        this.tracker = PendingBytesTracker.newTracker(channel0);
        this.invoker = channel0;
        this.executor = channel0.eventLoop();
    }

    public PendingWriteQueue(ChannelHandlerContext channelHandlerContext0) {
        this.tracker = PendingBytesTracker.newTracker(channelHandlerContext0.channel());
        this.invoker = channelHandlerContext0;
        this.executor = channelHandlerContext0.executor();
    }

    public void add(Object object0, ChannelPromise channelPromise0) {
        ObjectUtil.checkNotNull(object0, "msg");
        ObjectUtil.checkNotNull(channelPromise0, "promise");
        int v = this.size(object0);
        PendingWrite pendingWriteQueue$PendingWrite0 = PendingWrite.newInstance(object0, v, channelPromise0);
        PendingWrite pendingWriteQueue$PendingWrite1 = this.tail;
        if(pendingWriteQueue$PendingWrite1 == null) {
            this.head = pendingWriteQueue$PendingWrite0;
        }
        else {
            PendingWrite.access$002(pendingWriteQueue$PendingWrite1, pendingWriteQueue$PendingWrite0);
        }
        this.tail = pendingWriteQueue$PendingWrite0;
        ++this.size;
        this.bytes += (long)v;
        this.tracker.incrementPendingOutboundBytes(PendingWrite.access$100(pendingWriteQueue$PendingWrite0));
    }

    private void assertEmpty() {
    }

    public long bytes() {
        return this.bytes;
    }

    public Object current() {
        return this.head == null ? null : PendingWrite.access$200(this.head);
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    private void recycle(PendingWrite pendingWriteQueue$PendingWrite0, boolean z) {
        PendingWrite pendingWriteQueue$PendingWrite1 = PendingWrite.access$000(pendingWriteQueue$PendingWrite0);
        long v = PendingWrite.access$100(pendingWriteQueue$PendingWrite0);
        if(z) {
            if(pendingWriteQueue$PendingWrite1 == null) {
                this.tail = null;
                this.head = null;
                this.size = 0;
                this.bytes = 0L;
            }
            else {
                this.head = pendingWriteQueue$PendingWrite1;
                --this.size;
                this.bytes -= v;
            }
        }
        PendingWrite.access$400(pendingWriteQueue$PendingWrite0);
        this.tracker.decrementPendingOutboundBytes(v);
    }

    public ChannelPromise remove() {
        PendingWrite pendingWriteQueue$PendingWrite0 = this.head;
        if(pendingWriteQueue$PendingWrite0 == null) {
            return null;
        }
        ReferenceCountUtil.safeRelease(PendingWrite.access$200(pendingWriteQueue$PendingWrite0));
        this.recycle(pendingWriteQueue$PendingWrite0, true);
        return PendingWrite.access$300(pendingWriteQueue$PendingWrite0);
    }

    public void removeAndFail(Throwable throwable0) {
        ObjectUtil.checkNotNull(throwable0, "cause");
        PendingWrite pendingWriteQueue$PendingWrite0 = this.head;
        if(pendingWriteQueue$PendingWrite0 == null) {
            return;
        }
        ReferenceCountUtil.safeRelease(PendingWrite.access$200(pendingWriteQueue$PendingWrite0));
        PendingWriteQueue.safeFail(PendingWrite.access$300(pendingWriteQueue$PendingWrite0), throwable0);
        this.recycle(pendingWriteQueue$PendingWrite0, true);
    }

    public void removeAndFailAll(Throwable throwable0) {
        ObjectUtil.checkNotNull(throwable0, "cause");
        PendingWrite pendingWriteQueue$PendingWrite0;
        while((pendingWriteQueue$PendingWrite0 = this.head) != null) {
            this.tail = null;
            this.head = null;
            this.size = 0;
            this.bytes = 0L;
            while(pendingWriteQueue$PendingWrite0 != null) {
                ReferenceCountUtil.safeRelease(PendingWrite.access$200(pendingWriteQueue$PendingWrite0));
                this.recycle(pendingWriteQueue$PendingWrite0, false);
                PendingWriteQueue.safeFail(PendingWrite.access$300(pendingWriteQueue$PendingWrite0), throwable0);
                pendingWriteQueue$PendingWrite0 = PendingWrite.access$000(pendingWriteQueue$PendingWrite0);
            }
        }
    }

    public ChannelFuture removeAndWrite() {
        PendingWrite pendingWriteQueue$PendingWrite0 = this.head;
        if(pendingWriteQueue$PendingWrite0 == null) {
            return null;
        }
        this.recycle(pendingWriteQueue$PendingWrite0, true);
        return this.invoker.write(PendingWrite.access$200(pendingWriteQueue$PendingWrite0), PendingWrite.access$300(pendingWriteQueue$PendingWrite0));
    }

    public ChannelFuture removeAndWriteAll() {
        if(this.isEmpty()) {
            return null;
        }
        ChannelFuture channelFuture0 = this.invoker.newPromise();
        PromiseCombiner promiseCombiner0 = new PromiseCombiner(this.executor);
        try {
            PendingWrite pendingWriteQueue$PendingWrite0;
            while((pendingWriteQueue$PendingWrite0 = this.head) != null) {
                this.tail = null;
                this.head = null;
                this.size = 0;
                this.bytes = 0L;
                while(pendingWriteQueue$PendingWrite0 != null) {
                    PendingWrite pendingWriteQueue$PendingWrite1 = PendingWrite.access$000(pendingWriteQueue$PendingWrite0);
                    Object object0 = PendingWrite.access$200(pendingWriteQueue$PendingWrite0);
                    ChannelPromise channelPromise0 = PendingWrite.access$300(pendingWriteQueue$PendingWrite0);
                    this.recycle(pendingWriteQueue$PendingWrite0, false);
                    if(!(channelPromise0 instanceof VoidChannelPromise)) {
                        promiseCombiner0.add(channelPromise0);
                    }
                    this.invoker.write(object0, channelPromise0);
                    pendingWriteQueue$PendingWrite0 = pendingWriteQueue$PendingWrite1;
                }
            }
            promiseCombiner0.finish(((Promise)channelFuture0));
            return channelFuture0;
        }
        catch(Throwable throwable0) {
        }
        ((ChannelPromise)channelFuture0).setFailure(throwable0);
        return channelFuture0;
    }

    private static void safeFail(ChannelPromise channelPromise0, Throwable throwable0) {
        if(!(channelPromise0 instanceof VoidChannelPromise) && !channelPromise0.tryFailure(throwable0)) {
            PendingWriteQueue.logger.warn("Failed to mark a promise as failure because it\'s done already: {}", channelPromise0, throwable0);
        }
    }

    private int size(Object object0) {
        int v = this.tracker.size(object0);
        if(v < 0) {
            v = 0;
        }
        return v + PendingWriteQueue.PENDING_WRITE_OVERHEAD;
    }

    public int size() {
        return this.size;
    }

    class io.netty.channel.PendingWriteQueue.1 {
    }

}

