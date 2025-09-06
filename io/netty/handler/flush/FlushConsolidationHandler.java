package io.netty.handler.flush;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.Future;

public class FlushConsolidationHandler extends ChannelDuplexHandler {
    public static final int DEFAULT_EXPLICIT_FLUSH_AFTER_FLUSHES = 0x100;
    private final boolean consolidateWhenNoReadInProgress;
    private ChannelHandlerContext ctx;
    private final int explicitFlushAfterFlushes;
    private int flushPendingCount;
    private final Runnable flushTask;
    private Future nextScheduledFlush;
    private boolean readInProgress;

    public FlushConsolidationHandler() {
        this(0x100, false);
    }

    public FlushConsolidationHandler(int v) {
        this(v, false);
    }

    public FlushConsolidationHandler(int v, boolean z) {
        this.explicitFlushAfterFlushes = ObjectUtil.checkPositive(v, "explicitFlushAfterFlushes");
        this.consolidateWhenNoReadInProgress = z;
        this.flushTask = z ? new Runnable() {
            @Override
            public void run() {
                if(FlushConsolidationHandler.this.flushPendingCount > 0 && !FlushConsolidationHandler.this.readInProgress) {
                    FlushConsolidationHandler.this.flushPendingCount = 0;
                    FlushConsolidationHandler.this.nextScheduledFlush = null;
                    FlushConsolidationHandler.this.ctx.flush();
                }
            }
        } : null;
    }

    private void cancelScheduledFlush() {
        Future future0 = this.nextScheduledFlush;
        if(future0 != null) {
            future0.cancel(false);
            this.nextScheduledFlush = null;
        }
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelRead(ChannelHandlerContext channelHandlerContext0, Object object0) {
        this.readInProgress = true;
        channelHandlerContext0.fireChannelRead(object0);
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext0) {
        this.resetReadAndFlushIfNeeded(channelHandlerContext0);
        channelHandlerContext0.fireChannelReadComplete();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext0) {
        if(!channelHandlerContext0.channel().isWritable()) {
            this.flushIfNeeded(channelHandlerContext0);
        }
        channelHandlerContext0.fireChannelWritabilityChanged();
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void close(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        this.resetReadAndFlushIfNeeded(channelHandlerContext0);
        channelHandlerContext0.close(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        this.resetReadAndFlushIfNeeded(channelHandlerContext0);
        channelHandlerContext0.disconnect(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
        this.resetReadAndFlushIfNeeded(channelHandlerContext0);
        channelHandlerContext0.fireExceptionCaught(throwable0);
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void flush(ChannelHandlerContext channelHandlerContext0) {
        if(this.readInProgress) {
            int v = this.flushPendingCount + 1;
            this.flushPendingCount = v;
            if(v == this.explicitFlushAfterFlushes) {
                this.flushNow(channelHandlerContext0);
            }
            return;
        }
        if(this.consolidateWhenNoReadInProgress) {
            int v1 = this.flushPendingCount + 1;
            this.flushPendingCount = v1;
            if(v1 == this.explicitFlushAfterFlushes) {
                this.flushNow(channelHandlerContext0);
                return;
            }
            this.scheduleFlush(channelHandlerContext0);
            return;
        }
        this.flushNow(channelHandlerContext0);
    }

    private void flushIfNeeded(ChannelHandlerContext channelHandlerContext0) {
        if(this.flushPendingCount > 0) {
            this.flushNow(channelHandlerContext0);
        }
    }

    private void flushNow(ChannelHandlerContext channelHandlerContext0) {
        this.cancelScheduledFlush();
        this.flushPendingCount = 0;
        channelHandlerContext0.flush();
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext0) {
        this.ctx = channelHandlerContext0;
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext0) {
        this.flushIfNeeded(channelHandlerContext0);
    }

    private void resetReadAndFlushIfNeeded(ChannelHandlerContext channelHandlerContext0) {
        this.readInProgress = false;
        this.flushIfNeeded(channelHandlerContext0);
    }

    private void scheduleFlush(ChannelHandlerContext channelHandlerContext0) {
        if(this.nextScheduledFlush == null) {
            this.nextScheduledFlush = channelHandlerContext0.channel().eventLoop().submit(this.flushTask);
        }
    }
}

