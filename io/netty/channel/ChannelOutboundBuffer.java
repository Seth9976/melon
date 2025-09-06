package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.Recycler.EnhancedHandle;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public final class ChannelOutboundBuffer {
    static final class Entry {
        private static final ObjectPool RECYCLER;
        ByteBuffer buf;
        ByteBuffer[] bufs;
        boolean cancelled;
        int count;
        private final EnhancedHandle handle;
        Object msg;
        Entry next;
        int pendingSize;
        long progress;
        ChannelPromise promise;
        long total;

        static {
            Entry.RECYCLER = ObjectPool.newPool(new ObjectCreator() {
                public Entry newObject(Handle objectPool$Handle0) {
                    return new Entry(objectPool$Handle0, null);
                }

                @Override  // io.netty.util.internal.ObjectPool$ObjectCreator
                public Object newObject(Handle objectPool$Handle0) {
                    return this.newObject(objectPool$Handle0);
                }
            });
        }

        private Entry(Handle objectPool$Handle0) {
            this.count = -1;
            this.handle = (EnhancedHandle)objectPool$Handle0;
        }

        public Entry(Handle objectPool$Handle0, io.netty.channel.ChannelOutboundBuffer.1 channelOutboundBuffer$10) {
            this(objectPool$Handle0);
        }

        public int cancel() {
            if(!this.cancelled) {
                this.cancelled = true;
                int v = this.pendingSize;
                ReferenceCountUtil.safeRelease(this.msg);
                this.msg = Unpooled.EMPTY_BUFFER;
                this.pendingSize = 0;
                this.total = 0L;
                this.progress = 0L;
                this.bufs = null;
                this.buf = null;
                return v;
            }
            return 0;
        }

        public static Entry newInstance(Object object0, int v, long v1, ChannelPromise channelPromise0) {
            Entry channelOutboundBuffer$Entry0 = (Entry)Entry.RECYCLER.get();
            channelOutboundBuffer$Entry0.msg = object0;
            channelOutboundBuffer$Entry0.pendingSize = v + ChannelOutboundBuffer.CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD;
            channelOutboundBuffer$Entry0.total = v1;
            channelOutboundBuffer$Entry0.promise = channelPromise0;
            return channelOutboundBuffer$Entry0;
        }

        public void unguardedRecycle() {
            this.next = null;
            this.bufs = null;
            this.buf = null;
            this.msg = null;
            this.promise = null;
            this.progress = 0L;
            this.total = 0L;
            this.pendingSize = 0;
            this.count = -1;
            this.cancelled = false;
            this.handle.unguardedRecycle(this);
        }

        public Entry unguardedRecycleAndGetNext() {
            Entry channelOutboundBuffer$Entry0 = this.next;
            this.unguardedRecycle();
            return channelOutboundBuffer$Entry0;
        }
    }

    public interface MessageProcessor {
        boolean processMessage(Object arg1);
    }

    static final boolean $assertionsDisabled;
    static final int CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD;
    private static final FastThreadLocal NIO_BUFFERS;
    private static final AtomicLongFieldUpdater TOTAL_PENDING_SIZE_UPDATER;
    private static final AtomicIntegerFieldUpdater UNWRITABLE_UPDATER;
    private final Channel channel;
    private volatile Runnable fireChannelWritabilityChangedTask;
    private int flushed;
    private Entry flushedEntry;
    private boolean inFail;
    private static final InternalLogger logger;
    private int nioBufferCount;
    private long nioBufferSize;
    private Entry tailEntry;
    private volatile long totalPendingSize;
    private Entry unflushedEntry;
    private volatile int unwritable;

    static {
        ChannelOutboundBuffer.CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.outboundBufferEntrySizeOverhead", 0x60);
        ChannelOutboundBuffer.logger = InternalLoggerFactory.getInstance(ChannelOutboundBuffer.class);
        ChannelOutboundBuffer.NIO_BUFFERS = new FastThreadLocal() {
            @Override  // io.netty.util.concurrent.FastThreadLocal
            public Object initialValue() {
                return this.initialValue();
            }

            public ByteBuffer[] initialValue() {
                return new ByteBuffer[0x400];
            }
        };
        ChannelOutboundBuffer.TOTAL_PENDING_SIZE_UPDATER = AtomicLongFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "totalPendingSize");
        ChannelOutboundBuffer.UNWRITABLE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "unwritable");
    }

    public ChannelOutboundBuffer(AbstractChannel abstractChannel0) {
        this.channel = abstractChannel0;
    }

    public void addFlush() {
        Entry channelOutboundBuffer$Entry0 = this.unflushedEntry;
        if(channelOutboundBuffer$Entry0 != null) {
            if(this.flushedEntry == null) {
                this.flushedEntry = channelOutboundBuffer$Entry0;
            }
            do {
                ++this.flushed;
                if(!channelOutboundBuffer$Entry0.promise.setUncancellable()) {
                    this.decrementPendingOutboundBytes(((long)channelOutboundBuffer$Entry0.cancel()), false, true);
                }
                channelOutboundBuffer$Entry0 = channelOutboundBuffer$Entry0.next;
            }
            while(channelOutboundBuffer$Entry0 != null);
            this.unflushedEntry = null;
        }
    }

    public void addMessage(Object object0, int v, ChannelPromise channelPromise0) {
        Entry channelOutboundBuffer$Entry0 = Entry.newInstance(object0, v, ChannelOutboundBuffer.total(object0), channelPromise0);
        Entry channelOutboundBuffer$Entry1 = this.tailEntry;
        if(channelOutboundBuffer$Entry1 == null) {
            this.flushedEntry = null;
        }
        else {
            channelOutboundBuffer$Entry1.next = channelOutboundBuffer$Entry0;
        }
        this.tailEntry = channelOutboundBuffer$Entry0;
        if(this.unflushedEntry == null) {
            this.unflushedEntry = channelOutboundBuffer$Entry0;
        }
        this.incrementPendingOutboundBytes(((long)channelOutboundBuffer$Entry0.pendingSize), false);
    }

    public long bytesBeforeUnwritable() {
        long v = ((long)this.channel.config().getWriteBufferHighWaterMark()) - this.totalPendingSize + 1L;
        return v <= 0L || !this.isWritable() ? 0L : v;
    }

    public long bytesBeforeWritable() {
        long v = this.totalPendingSize - ((long)this.channel.config().getWriteBufferLowWaterMark()) + 1L;
        return v <= 0L || this.isWritable() ? 0L : v;
    }

    private void clearNioBuffers() {
        int v = this.nioBufferCount;
        if(v > 0) {
            this.nioBufferCount = 0;
            Arrays.fill(((Object[])ChannelOutboundBuffer.NIO_BUFFERS.get()), 0, v, null);
        }
    }

    private void clearUserDefinedWritability(int v) {
        int v1 = ChannelOutboundBuffer.writabilityMask(v);
        do {
            int v2 = this.unwritable;
            int v3 = v2 | v1;
        }
        while(!ChannelOutboundBuffer.UNWRITABLE_UPDATER.compareAndSet(this, v2, v3));
        if(v2 == 0 && v3 != 0) {
            this.fireChannelWritabilityChanged(true);
        }
    }

    // 检测为 Lambda 实现
    public void close(Throwable throwable0, boolean z) [...]

    public void close(ClosedChannelException closedChannelException0) {
        this.close(closedChannelException0, false);
    }

    public Object current() {
        return this.flushedEntry == null ? null : this.flushedEntry.msg;
    }

    public long currentProgress() {
        return this.flushedEntry == null ? 0L : this.flushedEntry.progress;
    }

    private void decrementPendingOutboundBytes(long v, boolean z, boolean z1) {
        if(v != 0L && (z1 && ChannelOutboundBuffer.TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -v) < ((long)this.channel.config().getWriteBufferLowWaterMark()))) {
            this.setWritable(z);
        }
    }

    public void decrementPendingOutboundBytes(long v) {
        this.decrementPendingOutboundBytes(v, true, true);
    }

    private static ByteBuffer[] expandNioBufferArray(ByteBuffer[] arr_byteBuffer, int v, int v1) {
        int v2 = arr_byteBuffer.length;
        while(true) {
            v2 <<= 1;
            if(v2 < 0) {
                break;
            }
            if(v <= v2) {
                ByteBuffer[] arr_byteBuffer1 = new ByteBuffer[v2];
                System.arraycopy(arr_byteBuffer, 0, arr_byteBuffer1, 0, v1);
                return arr_byteBuffer1;
            }
        }
        throw new IllegalStateException();
    }

    public void failFlushed(Throwable throwable0, boolean z) {
        if(this.inFail) {
            return;
        }
        try {
            this.inFail = true;
            while(this.remove0(throwable0, z)) {
            }
        }
        finally {
            this.inFail = false;
        }
    }

    private void fireChannelWritabilityChanged(boolean z) {
        ChannelPipeline channelPipeline0 = this.channel.pipeline();
        if(z) {
            Runnable runnable0 = this.fireChannelWritabilityChangedTask;
            if(runnable0 == null) {
                runnable0 = new Runnable() {
                    @Override
                    public void run() {
                        channelPipeline0.fireChannelWritabilityChanged();
                    }
                };
                this.fireChannelWritabilityChangedTask = runnable0;
            }
            this.channel.eventLoop().execute(runnable0);
            return;
        }
        channelPipeline0.fireChannelWritabilityChanged();
    }

    public void forEachFlushedMessage(MessageProcessor channelOutboundBuffer$MessageProcessor0) {
        ObjectUtil.checkNotNull(channelOutboundBuffer$MessageProcessor0, "processor");
        Entry channelOutboundBuffer$Entry0 = this.flushedEntry;
        if(channelOutboundBuffer$Entry0 != null) {
            while(channelOutboundBuffer$Entry0.cancelled || channelOutboundBuffer$MessageProcessor0.processMessage(channelOutboundBuffer$Entry0.msg)) {
                channelOutboundBuffer$Entry0 = channelOutboundBuffer$Entry0.next;
                if(!this.isFlushedEntry(channelOutboundBuffer$Entry0)) {
                    break;
                }
            }
        }
    }

    public boolean getUserDefinedWritability(int v) {
        int v1 = this.unwritable;
        return (ChannelOutboundBuffer.writabilityMask(v) & v1) == 0;
    }

    private void incrementPendingOutboundBytes(long v, boolean z) {
        if(v != 0L && ChannelOutboundBuffer.TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, v) > ((long)this.channel.config().getWriteBufferHighWaterMark())) {
            this.setUnwritable(z);
        }
    }

    public void incrementPendingOutboundBytes(long v) {
        this.incrementPendingOutboundBytes(v, true);
    }

    public boolean isEmpty() {
        return this.flushed == 0;
    }

    private boolean isFlushedEntry(Entry channelOutboundBuffer$Entry0) {
        return channelOutboundBuffer$Entry0 != null && channelOutboundBuffer$Entry0 != this.unflushedEntry;
    }

    public boolean isWritable() {
        return this.unwritable == 0;
    }

    public int nioBufferCount() {
        return this.nioBufferCount;
    }

    public long nioBufferSize() {
        return this.nioBufferSize;
    }

    private static int nioBuffers(Entry channelOutboundBuffer$Entry0, ByteBuf byteBuf0, ByteBuffer[] arr_byteBuffer, int v, int v1) {
        ByteBuffer[] arr_byteBuffer1 = channelOutboundBuffer$Entry0.bufs;
        if(arr_byteBuffer1 == null) {
            arr_byteBuffer1 = byteBuf0.nioBuffers();
            channelOutboundBuffer$Entry0.bufs = arr_byteBuffer1;
        }
        for(int v2 = 0; v2 < arr_byteBuffer1.length && v < v1; ++v2) {
            ByteBuffer byteBuffer0 = arr_byteBuffer1[v2];
            if(byteBuffer0 == null) {
                break;
            }
            if(byteBuffer0.hasRemaining()) {
                arr_byteBuffer[v] = byteBuffer0;
                ++v;
            }
        }
        return v;
    }

    public ByteBuffer[] nioBuffers() {
        return this.nioBuffers(0x7FFFFFFF, 0x7FFFFFFFL);
    }

    public ByteBuffer[] nioBuffers(int v, long v1) {
        InternalThreadLocalMap internalThreadLocalMap0 = InternalThreadLocalMap.get();
        ByteBuffer[] arr_byteBuffer = (ByteBuffer[])ChannelOutboundBuffer.NIO_BUFFERS.get(internalThreadLocalMap0);
        Entry channelOutboundBuffer$Entry0 = this.flushedEntry;
        long v2 = 0L;
        int v3 = 0;
        while(this.isFlushedEntry(channelOutboundBuffer$Entry0)) {
            Object object0 = channelOutboundBuffer$Entry0.msg;
            if(!(object0 instanceof ByteBuf)) {
                break;
            }
            if(!channelOutboundBuffer$Entry0.cancelled) {
                int v4 = ((ByteBuf)object0).readerIndex();
                int v5 = ((ByteBuf)object0).writerIndex() - v4;
                if(v5 > 0) {
                    if(v1 - ((long)v5) < v2 && v3 != 0) {
                        break;
                    }
                    v2 += (long)v5;
                    int v6 = channelOutboundBuffer$Entry0.count;
                    if(v6 == -1) {
                        v6 = ((ByteBuf)object0).nioBufferCount();
                        channelOutboundBuffer$Entry0.count = v6;
                    }
                    int v7 = Math.min(v, v3 + v6);
                    if(v7 > arr_byteBuffer.length) {
                        arr_byteBuffer = ChannelOutboundBuffer.expandNioBufferArray(arr_byteBuffer, v7, v3);
                        ChannelOutboundBuffer.NIO_BUFFERS.set(internalThreadLocalMap0, arr_byteBuffer);
                    }
                    if(v6 == 1) {
                        ByteBuffer byteBuffer0 = channelOutboundBuffer$Entry0.buf;
                        if(byteBuffer0 == null) {
                            byteBuffer0 = ((ByteBuf)object0).internalNioBuffer(v4, v5);
                            channelOutboundBuffer$Entry0.buf = byteBuffer0;
                        }
                        arr_byteBuffer[v3] = byteBuffer0;
                        ++v3;
                    }
                    else {
                        v3 = ChannelOutboundBuffer.nioBuffers(channelOutboundBuffer$Entry0, ((ByteBuf)object0), arr_byteBuffer, v3, v);
                    }
                    if(v3 < v) {
                        goto label_32;
                    }
                    break;
                }
            }
        label_32:
            channelOutboundBuffer$Entry0 = channelOutboundBuffer$Entry0.next;
        }
        this.nioBufferCount = v3;
        this.nioBufferSize = v2;
        return arr_byteBuffer;
    }

    public void progress(long v) {
        Entry channelOutboundBuffer$Entry0 = this.flushedEntry;
        ChannelPromise channelPromise0 = channelOutboundBuffer$Entry0.promise;
        long v1 = channelOutboundBuffer$Entry0.progress + v;
        channelOutboundBuffer$Entry0.progress = v1;
        Class class0 = channelPromise0.getClass();
        if(class0 != VoidChannelPromise.class && class0 != DefaultChannelPromise.class) {
            if(channelPromise0 instanceof DefaultChannelProgressivePromise) {
                ((DefaultChannelProgressivePromise)channelPromise0).tryProgress(v1, channelOutboundBuffer$Entry0.total);
                return;
            }
            if(channelPromise0 instanceof ChannelProgressivePromise) {
                ((ChannelProgressivePromise)channelPromise0).tryProgress(v1, channelOutboundBuffer$Entry0.total);
            }
        }
    }

    @Deprecated
    public void recycle() {
    }

    public boolean remove() {
        Entry channelOutboundBuffer$Entry0 = this.flushedEntry;
        if(channelOutboundBuffer$Entry0 == null) {
            this.clearNioBuffers();
            return false;
        }
        Object object0 = channelOutboundBuffer$Entry0.msg;
        ChannelPromise channelPromise0 = channelOutboundBuffer$Entry0.promise;
        int v = channelOutboundBuffer$Entry0.pendingSize;
        this.removeEntry(channelOutboundBuffer$Entry0);
        if(!channelOutboundBuffer$Entry0.cancelled) {
            ReferenceCountUtil.safeRelease(object0);
            ChannelOutboundBuffer.safeSuccess(channelPromise0);
            this.decrementPendingOutboundBytes(((long)v), false, true);
        }
        channelOutboundBuffer$Entry0.unguardedRecycle();
        return true;
    }

    public boolean remove(Throwable throwable0) {
        return this.remove0(throwable0, true);
    }

    private boolean remove0(Throwable throwable0, boolean z) {
        Entry channelOutboundBuffer$Entry0 = this.flushedEntry;
        if(channelOutboundBuffer$Entry0 == null) {
            this.clearNioBuffers();
            return false;
        }
        Object object0 = channelOutboundBuffer$Entry0.msg;
        ChannelPromise channelPromise0 = channelOutboundBuffer$Entry0.promise;
        int v = channelOutboundBuffer$Entry0.pendingSize;
        this.removeEntry(channelOutboundBuffer$Entry0);
        if(!channelOutboundBuffer$Entry0.cancelled) {
            ReferenceCountUtil.safeRelease(object0);
            ChannelOutboundBuffer.safeFail(channelPromise0, throwable0);
            this.decrementPendingOutboundBytes(((long)v), false, z);
        }
        channelOutboundBuffer$Entry0.unguardedRecycle();
        return true;
    }

    public void removeBytes(long v) {
        while(true) {
            Object object0 = this.current();
            if(!(object0 instanceof ByteBuf)) {
                break;
            }
            int v1 = ((ByteBuf)object0).readerIndex();
            long v2 = (long)(((ByteBuf)object0).writerIndex() - v1);
            if(Long.compare(v2, v) > 0) {
                if(v == 0L) {
                    break;
                }
                ((ByteBuf)object0).readerIndex(v1 + ((int)v));
                this.progress(v);
                break;
            }
            if(v != 0L) {
                this.progress(v2);
                v -= v2;
            }
            this.remove();
        }
        this.clearNioBuffers();
    }

    private void removeEntry(Entry channelOutboundBuffer$Entry0) {
        int v = this.flushed - 1;
        this.flushed = v;
        if(v == 0) {
            this.flushedEntry = null;
            if(channelOutboundBuffer$Entry0 == this.tailEntry) {
                this.tailEntry = null;
                this.unflushedEntry = null;
            }
            return;
        }
        this.flushedEntry = channelOutboundBuffer$Entry0.next;
    }

    private static void safeFail(ChannelPromise channelPromise0, Throwable throwable0) {
        PromiseNotificationUtil.tryFailure(channelPromise0, throwable0, (channelPromise0 instanceof VoidChannelPromise ? null : ChannelOutboundBuffer.logger));
    }

    private static void safeSuccess(ChannelPromise channelPromise0) {
        PromiseNotificationUtil.trySuccess(channelPromise0, null, (channelPromise0 instanceof VoidChannelPromise ? null : ChannelOutboundBuffer.logger));
    }

    private void setUnwritable(boolean z) {
        do {
            int v = this.unwritable;
        }
        while(!ChannelOutboundBuffer.UNWRITABLE_UPDATER.compareAndSet(this, v, v | 1));
        if(v == 0) {
            this.fireChannelWritabilityChanged(z);
        }
    }

    private void setUserDefinedWritability(int v) {
        int v1 = ChannelOutboundBuffer.writabilityMask(v);
        do {
            int v2 = this.unwritable;
            int v3 = v2 & ~v1;
        }
        while(!ChannelOutboundBuffer.UNWRITABLE_UPDATER.compareAndSet(this, v2, v3));
        if(v2 != 0 && v3 == 0) {
            this.fireChannelWritabilityChanged(true);
        }
    }

    public void setUserDefinedWritability(int v, boolean z) {
        if(z) {
            this.setUserDefinedWritability(v);
            return;
        }
        this.clearUserDefinedWritability(v);
    }

    private void setWritable(boolean z) {
        do {
            int v = this.unwritable;
            int v1 = v & -2;
        }
        while(!ChannelOutboundBuffer.UNWRITABLE_UPDATER.compareAndSet(this, v, v1));
        if(v != 0 && v1 == 0) {
            this.fireChannelWritabilityChanged(z);
        }
    }

    public int size() {
        return this.flushed;
    }

    private static long total(Object object0) {
        if(object0 instanceof ByteBuf) {
            return (long)((ByteBuf)object0).readableBytes();
        }
        if(object0 instanceof FileRegion) {
            return ((FileRegion)object0).count();
        }
        return object0 instanceof ByteBufHolder ? ((long)((ByteBufHolder)object0).content().readableBytes()) : -1L;
    }

    public long totalPendingWriteBytes() {
        return this.totalPendingSize;
    }

    private static int writabilityMask(int v) {
        if(v < 1 || v > 0x1F) {
            throw new IllegalArgumentException("index: " + v + " (expected: 1~31)");
        }
        return 1 << v;
    }
}

