package io.netty.channel;

import io.netty.buffer.AbstractReferenceCountedByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;

public abstract class AbstractCoalescingBufferQueue {
    static final boolean $assertionsDisabled;
    private final ArrayDeque bufAndListenerPairs;
    private static final InternalLogger logger;
    private int readableBytes;
    private final PendingBytesTracker tracker;

    static {
        AbstractCoalescingBufferQueue.logger = InternalLoggerFactory.getInstance(AbstractCoalescingBufferQueue.class);
    }

    public AbstractCoalescingBufferQueue(Channel channel0, int v) {
        this.bufAndListenerPairs = new ArrayDeque(v);
        this.tracker = channel0 == null ? null : PendingBytesTracker.newTracker(channel0);
    }

    public final void add(ByteBuf byteBuf0) {
        this.add(byteBuf0, null);
    }

    public final void add(ByteBuf byteBuf0, ChannelFutureListener channelFutureListener0) {
        this.bufAndListenerPairs.add(byteBuf0);
        if(channelFutureListener0 != null) {
            this.bufAndListenerPairs.add(channelFutureListener0);
        }
        this.incrementReadableBytes(byteBuf0.readableBytes());
    }

    public final void add(ByteBuf byteBuf0, ChannelPromise channelPromise0) {
        this.add(byteBuf0, AbstractCoalescingBufferQueue.toChannelFutureListener(channelPromise0));
    }

    private void addFirst(ByteBuf byteBuf0, ChannelFutureListener channelFutureListener0) {
        if(channelFutureListener0 != null) {
            this.bufAndListenerPairs.addFirst(channelFutureListener0);
        }
        this.bufAndListenerPairs.addFirst(byteBuf0);
        this.incrementReadableBytes(byteBuf0.readableBytes());
    }

    public final void addFirst(ByteBuf byteBuf0, ChannelPromise channelPromise0) {
        this.addFirst(byteBuf0, AbstractCoalescingBufferQueue.toChannelFutureListener(channelPromise0));
    }

    public abstract ByteBuf compose(ByteBufAllocator arg1, ByteBuf arg2, ByteBuf arg3);

    public ByteBuf composeFirst(ByteBufAllocator byteBufAllocator0, ByteBuf byteBuf0) {
        return byteBuf0;
    }

    public final ByteBuf composeIntoComposite(ByteBufAllocator byteBufAllocator0, ByteBuf byteBuf0, ByteBuf byteBuf1) {
        ByteBuf byteBuf2 = byteBufAllocator0.compositeBuffer(this.size() + 2);
        try {
            ((CompositeByteBuf)byteBuf2).addComponent(true, byteBuf0);
            ((CompositeByteBuf)byteBuf2).addComponent(true, byteBuf1);
        }
        catch(Throwable throwable0) {
            ((AbstractReferenceCountedByteBuf)byteBuf2).release();
            ReferenceCountUtil.safeRelease(byteBuf1);
            PlatformDependent.throwException(throwable0);
        }
        return byteBuf2;
    }

    public final ByteBuf copyAndCompose(ByteBufAllocator byteBufAllocator0, ByteBuf byteBuf0, ByteBuf byteBuf1) {
        int v = byteBuf0.readableBytes();
        ByteBuf byteBuf2 = byteBufAllocator0.ioBuffer(byteBuf1.readableBytes() + v);
        try {
            byteBuf2.writeBytes(byteBuf0).writeBytes(byteBuf1);
        }
        catch(Throwable throwable0) {
            byteBuf2.release();
            ReferenceCountUtil.safeRelease(byteBuf1);
            PlatformDependent.throwException(throwable0);
        }
        byteBuf0.release();
        byteBuf1.release();
        return byteBuf2;
    }

    public final void copyTo(AbstractCoalescingBufferQueue abstractCoalescingBufferQueue0) {
        abstractCoalescingBufferQueue0.bufAndListenerPairs.addAll(this.bufAndListenerPairs);
        abstractCoalescingBufferQueue0.incrementReadableBytes(this.readableBytes);
    }

    private void decrementReadableBytes(int v) {
        this.readableBytes -= v;
        PendingBytesTracker pendingBytesTracker0 = this.tracker;
        if(pendingBytesTracker0 != null) {
            pendingBytesTracker0.decrementPendingOutboundBytes(((long)v));
        }
    }

    private void incrementReadableBytes(int v) {
        int v1 = this.readableBytes + v;
        if(v1 < this.readableBytes) {
            throw new IllegalStateException("buffer queue length overflow: " + this.readableBytes + " + " + v);
        }
        this.readableBytes = v1;
        PendingBytesTracker pendingBytesTracker0 = this.tracker;
        if(pendingBytesTracker0 != null) {
            pendingBytesTracker0.incrementPendingOutboundBytes(((long)v));
        }
    }

    public final boolean isEmpty() {
        return this.bufAndListenerPairs.isEmpty();
    }

    public final int readableBytes() {
        return this.readableBytes;
    }

    private void releaseAndCompleteAll(ChannelFuture channelFuture0) {
        Throwable throwable0 = null;
        Object object0;
        while((object0 = this.bufAndListenerPairs.poll()) != null) {
            try {
                if(object0 instanceof ByteBuf) {
                    this.decrementReadableBytes(((ByteBuf)object0).readableBytes());
                    ReferenceCountUtil.safeRelease(((ByteBuf)object0));
                    continue;
                }
                ((ChannelFutureListener)object0).operationComplete(channelFuture0);
                continue;
            label_10:
                if(throwable0 == null) {
                    throwable0 = throwable1;
                    continue;
                }
            }
            catch(Throwable throwable1) {
                goto label_10;
            }
            AbstractCoalescingBufferQueue.logger.info("Throwable being suppressed because Throwable {} is already pending", throwable0, throwable1);
        }
        if(throwable0 != null) {
            throw new IllegalStateException(throwable0);
        }
    }

    public final void releaseAndFailAll(ChannelOutboundInvoker channelOutboundInvoker0, Throwable throwable0) {
        this.releaseAndCompleteAll(channelOutboundInvoker0.newFailedFuture(throwable0));
    }

    public final ByteBuf remove(ByteBufAllocator byteBufAllocator0, int v, ChannelPromise channelPromise0) {
        ByteBuf byteBuf2;
        ObjectUtil.checkPositiveOrZero(v, "bytes");
        ObjectUtil.checkNotNull(channelPromise0, "aggregatePromise");
        if(this.bufAndListenerPairs.isEmpty()) {
            return this.removeEmptyValue();
        }
        int v1 = Math.min(v, this.readableBytes);
        ByteBuf byteBuf0 = null;
        int v2 = v1;
        ByteBuf byteBuf1 = null;
        while(true) {
            try {
            label_8:
                Object object0 = this.bufAndListenerPairs.poll();
                if(object0 == null) {
                    break;
                }
                if(object0 instanceof ChannelFutureListener) {
                    channelPromise0.addListener(((ChannelFutureListener)object0));
                    goto label_8;
                }
                byteBuf2 = (ByteBuf)object0;
            }
            catch(Throwable throwable0) {
                goto label_37;
            }
            try {
                int v3 = byteBuf2.readableBytes();
                if(v3 <= v2) {
                    v2 -= v3;
                    if(byteBuf1 == null) {
                        if(v3 != this.readableBytes) {
                            byteBuf2 = this.composeFirst(byteBufAllocator0, byteBuf2);
                        }
                        byteBuf1 = byteBuf2;
                    }
                    else {
                        byteBuf1 = this.compose(byteBufAllocator0, byteBuf1, byteBuf2);
                    }
                    goto label_8;
                }
                this.bufAndListenerPairs.addFirst(byteBuf2);
                if(v2 <= 0) {
                    break;
                }
                byteBuf0 = byteBuf2.readRetainedSlice(v2);
            }
            catch(Throwable throwable0) {
                byteBuf0 = byteBuf2;
                goto label_37;
            }
            if(byteBuf1 == null) {
                byteBuf1 = byteBuf0;
            }
            else {
                try {
                    byteBuf1 = this.compose(byteBufAllocator0, byteBuf1, byteBuf0);
                    v2 = 0;
                    break;
                }
                catch(Throwable throwable0) {
                }
            label_37:
                ReferenceCountUtil.safeRelease(byteBuf0);
                ReferenceCountUtil.safeRelease(byteBuf1);
                channelPromise0.setFailure(throwable0);
                PlatformDependent.throwException(throwable0);
                break;
            }
            v2 = 0;
            break;
        }
        this.decrementReadableBytes(v1 - v2);
        return byteBuf1;
    }

    public abstract ByteBuf removeEmptyValue();

    public final ByteBuf removeFirst(ChannelPromise channelPromise0) {
        Object object0 = this.bufAndListenerPairs.poll();
        if(object0 == null) {
            return null;
        }
        this.decrementReadableBytes(((ByteBuf)object0).readableBytes());
        Object object1 = this.bufAndListenerPairs.peek();
        if(object1 instanceof ChannelFutureListener) {
            channelPromise0.addListener(((ChannelFutureListener)object1));
            this.bufAndListenerPairs.poll();
        }
        return (ByteBuf)object0;
    }

    public final int size() {
        return this.bufAndListenerPairs.size();
    }

    private static ChannelFutureListener toChannelFutureListener(ChannelPromise channelPromise0) {
        return channelPromise0.isVoid() ? null : new DelegatingChannelPromiseNotifier(channelPromise0);
    }

    @Override
    public String toString() {
        return "bytes: " + this.readableBytes + " buffers: " + (this.size() >> 1);
    }

    public final void writeAndRemoveAll(ChannelHandlerContext channelHandlerContext0) {
        ByteBuf byteBuf0 = null;
        Throwable throwable0 = null;
        while(true) {
            Object object0 = this.bufAndListenerPairs.poll();
            if(object0 == null) {
                goto label_18;
            }
            else {
                try {
                    if(object0 instanceof ByteBuf) {
                        if(byteBuf0 != null) {
                            this.decrementReadableBytes(byteBuf0.readableBytes());
                            channelHandlerContext0.write(byteBuf0, channelHandlerContext0.voidPromise());
                        }
                        byteBuf0 = (ByteBuf)object0;
                    }
                    else {
                        if(object0 instanceof ChannelPromise) {
                            this.decrementReadableBytes(byteBuf0.readableBytes());
                            channelHandlerContext0.write(byteBuf0, ((ChannelPromise)object0));
                        }
                        else {
                            this.decrementReadableBytes(byteBuf0.readableBytes());
                            channelHandlerContext0.write(byteBuf0).addListener(((ChannelFutureListener)object0));
                        }
                        byteBuf0 = null;
                    }
                    continue;
                label_18:
                    if(byteBuf0 == null) {
                        break;
                    }
                    this.decrementReadableBytes(byteBuf0.readableBytes());
                    channelHandlerContext0.write(byteBuf0, channelHandlerContext0.voidPromise());
                    break;
                }
                catch(Throwable throwable1) {
                }
            }
            if(throwable0 == null) {
                throwable0 = throwable1;
            }
            else {
                AbstractCoalescingBufferQueue.logger.info("Throwable being suppressed because Throwable {} is already pending", throwable0, throwable1);
            }
        }
        if(throwable0 != null) {
            throw new IllegalStateException(throwable0);
        }
    }
}

