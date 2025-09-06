package io.netty.handler.timeout;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

public class WriteTimeoutHandler extends ChannelOutboundHandlerAdapter {
    final class WriteTimeoutTask implements ChannelFutureListener, Runnable {
        static final boolean $assertionsDisabled;
        private final ChannelHandlerContext ctx;
        WriteTimeoutTask next;
        WriteTimeoutTask prev;
        private final ChannelPromise promise;
        Future scheduledFuture;

        public WriteTimeoutTask(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
            this.ctx = channelHandlerContext0;
            this.promise = channelPromise0;
        }

        public static ChannelHandlerContext access$000(WriteTimeoutTask writeTimeoutHandler$WriteTimeoutTask0) {
            return writeTimeoutHandler$WriteTimeoutTask0.ctx;
        }

        public void operationComplete(ChannelFuture channelFuture0) {
            this.scheduledFuture.cancel(false);
            if(this.ctx.executor().inEventLoop()) {
                WriteTimeoutHandler.this.removeWriteTimeoutTask(this);
                return;
            }
            this.ctx.executor().execute(this);
        }

        @Override  // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(Future future0) {
            this.operationComplete(((ChannelFuture)future0));
        }

        @Override
        public void run() {
            if(!this.promise.isDone()) {
                try {
                    WriteTimeoutHandler.this.writeTimedOut(this.ctx);
                }
                catch(Throwable throwable0) {
                    this.ctx.fireExceptionCaught(throwable0);
                }
            }
            WriteTimeoutHandler.this.removeWriteTimeoutTask(this);
        }
    }

    static final boolean $assertionsDisabled;
    private static final long MIN_TIMEOUT_NANOS;
    private boolean closed;
    private WriteTimeoutTask lastTask;
    private final long timeoutNanos;

    static {
        WriteTimeoutHandler.MIN_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(1L);
    }

    public WriteTimeoutHandler(int v) {
        this(((long)v), TimeUnit.SECONDS);
    }

    public WriteTimeoutHandler(long v, TimeUnit timeUnit0) {
        ObjectUtil.checkNotNull(timeUnit0, "unit");
        if(v <= 0L) {
            this.timeoutNanos = 0L;
            return;
        }
        this.timeoutNanos = Math.max(timeUnit0.toNanos(v), WriteTimeoutHandler.MIN_TIMEOUT_NANOS);
    }

    private void addWriteTimeoutTask(WriteTimeoutTask writeTimeoutHandler$WriteTimeoutTask0) {
        WriteTimeoutTask writeTimeoutHandler$WriteTimeoutTask1 = this.lastTask;
        if(writeTimeoutHandler$WriteTimeoutTask1 != null) {
            writeTimeoutHandler$WriteTimeoutTask1.next = writeTimeoutHandler$WriteTimeoutTask0;
            writeTimeoutHandler$WriteTimeoutTask0.prev = writeTimeoutHandler$WriteTimeoutTask1;
        }
        this.lastTask = writeTimeoutHandler$WriteTimeoutTask0;
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext0) {
        WriteTimeoutTask writeTimeoutHandler$WriteTimeoutTask0 = this.lastTask;
        this.lastTask = null;
        while(writeTimeoutHandler$WriteTimeoutTask0 != null) {
            writeTimeoutHandler$WriteTimeoutTask0.scheduledFuture.cancel(false);
            WriteTimeoutTask writeTimeoutHandler$WriteTimeoutTask1 = writeTimeoutHandler$WriteTimeoutTask0.prev;
            writeTimeoutHandler$WriteTimeoutTask0.prev = null;
            writeTimeoutHandler$WriteTimeoutTask0.next = null;
            writeTimeoutHandler$WriteTimeoutTask0 = writeTimeoutHandler$WriteTimeoutTask1;
        }
    }

    private void removeWriteTimeoutTask(WriteTimeoutTask writeTimeoutHandler$WriteTimeoutTask0) {
        WriteTimeoutTask writeTimeoutHandler$WriteTimeoutTask1 = this.lastTask;
        if(writeTimeoutHandler$WriteTimeoutTask0 == writeTimeoutHandler$WriteTimeoutTask1) {
            WriteTimeoutTask writeTimeoutHandler$WriteTimeoutTask2 = writeTimeoutHandler$WriteTimeoutTask1.prev;
            this.lastTask = writeTimeoutHandler$WriteTimeoutTask2;
            if(writeTimeoutHandler$WriteTimeoutTask2 != null) {
                writeTimeoutHandler$WriteTimeoutTask2.next = null;
            }
        }
        else {
            WriteTimeoutTask writeTimeoutHandler$WriteTimeoutTask3 = writeTimeoutHandler$WriteTimeoutTask0.prev;
            if(writeTimeoutHandler$WriteTimeoutTask3 == null && writeTimeoutHandler$WriteTimeoutTask0.next == null) {
                return;
            }
            if(writeTimeoutHandler$WriteTimeoutTask3 == null) {
                writeTimeoutHandler$WriteTimeoutTask0.next.prev = null;
            }
            else {
                writeTimeoutHandler$WriteTimeoutTask3.next = writeTimeoutHandler$WriteTimeoutTask0.next;
                writeTimeoutHandler$WriteTimeoutTask0.next.prev = writeTimeoutHandler$WriteTimeoutTask3;
            }
        }
        writeTimeoutHandler$WriteTimeoutTask0.prev = null;
        writeTimeoutHandler$WriteTimeoutTask0.next = null;
    }

    private void scheduleTimeout(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        WriteTimeoutTask writeTimeoutHandler$WriteTimeoutTask0 = new WriteTimeoutTask(this, channelHandlerContext0, channelPromise0);
        ScheduledFuture scheduledFuture0 = channelHandlerContext0.executor().schedule(writeTimeoutHandler$WriteTimeoutTask0, this.timeoutNanos, TimeUnit.NANOSECONDS);
        writeTimeoutHandler$WriteTimeoutTask0.scheduledFuture = scheduledFuture0;
        if(!scheduledFuture0.isDone()) {
            this.addWriteTimeoutTask(writeTimeoutHandler$WriteTimeoutTask0);
            channelPromise0.addListener(writeTimeoutHandler$WriteTimeoutTask0);
        }
    }

    @Override  // io.netty.channel.ChannelOutboundHandlerAdapter
    public void write(ChannelHandlerContext channelHandlerContext0, Object object0, ChannelPromise channelPromise0) {
        if(this.timeoutNanos > 0L) {
            channelPromise0 = channelPromise0.unvoid();
            this.scheduleTimeout(channelHandlerContext0, channelPromise0);
        }
        channelHandlerContext0.write(object0, channelPromise0);
    }

    public void writeTimedOut(ChannelHandlerContext channelHandlerContext0) {
        if(!this.closed) {
            channelHandlerContext0.fireExceptionCaught(WriteTimeoutException.INSTANCE);
            channelHandlerContext0.close();
            this.closed = true;
        }
    }
}

