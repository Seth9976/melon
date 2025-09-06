package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelProgressivePromise;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;

public class ChunkedWriteHandler extends ChannelDuplexHandler {
    static final class PendingWrite {
        final Object msg;
        final ChannelPromise promise;

        public PendingWrite(Object object0, ChannelPromise channelPromise0) {
            this.msg = object0;
            this.promise = channelPromise0;
        }

        public void fail(Throwable throwable0) {
            ReferenceCountUtil.release(this.msg);
            this.promise.tryFailure(throwable0);
        }

        public void progress(long v, long v1) {
            ChannelPromise channelPromise0 = this.promise;
            if(channelPromise0 instanceof ChannelProgressivePromise) {
                ((ChannelProgressivePromise)channelPromise0).tryProgress(v, v1);
            }
        }

        public void success(long v) {
            if(this.promise.isDone()) {
                return;
            }
            this.progress(v, v);
            this.promise.trySuccess();
        }
    }

    private volatile ChannelHandlerContext ctx;
    private static final InternalLogger logger;
    private final Queue queue;

    static {
        ChunkedWriteHandler.logger = InternalLoggerFactory.getInstance(ChunkedWriteHandler.class);
    }

    public ChunkedWriteHandler() {
        this.queue = new ArrayDeque();
    }

    @Deprecated
    public ChunkedWriteHandler(int v) {
        this.queue = new ArrayDeque();
        ObjectUtil.checkPositive(v, "maxPendingWrites");
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelInactive(ChannelHandlerContext channelHandlerContext0) {
        this.doFlush(channelHandlerContext0);
        channelHandlerContext0.fireChannelInactive();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext0) {
        if(channelHandlerContext0.channel().isWritable()) {
            this.doFlush(channelHandlerContext0);
        }
        channelHandlerContext0.fireChannelWritabilityChanged();
    }

    private static void closeInput(ChunkedInput chunkedInput0) {
        try {
            chunkedInput0.close();
        }
        catch(Throwable throwable0) {
            if(ChunkedWriteHandler.logger.isWarnEnabled()) {
                ChunkedWriteHandler.logger.warn("Failed to close a chunked input.", throwable0);
            }
        }
    }

    private void discard(Throwable throwable0) {
        long v;
        PendingWrite chunkedWriteHandler$PendingWrite0;
        while((chunkedWriteHandler$PendingWrite0 = (PendingWrite)this.queue.poll()) != null) {
            Object object0 = chunkedWriteHandler$PendingWrite0.msg;
            if(object0 instanceof ChunkedInput) {
                ChunkedInput chunkedInput0 = (ChunkedInput)object0;
                try {
                    boolean z = chunkedInput0.isEndOfInput();
                    v = chunkedInput0.length();
                    ChunkedWriteHandler.closeInput(chunkedInput0);
                }
                catch(Exception exception0) {
                    ChunkedWriteHandler.closeInput(chunkedInput0);
                    chunkedWriteHandler$PendingWrite0.fail(exception0);
                    InternalLogger internalLogger0 = ChunkedWriteHandler.logger;
                    if(!internalLogger0.isWarnEnabled()) {
                        continue;
                    }
                    internalLogger0.warn("ChunkedInput failed", exception0);
                    continue;
                }
                if(z) {
                    chunkedWriteHandler$PendingWrite0.success(v);
                }
                else {
                    if(throwable0 == null) {
                        throwable0 = new ClosedChannelException();
                    }
                    chunkedWriteHandler$PendingWrite0.fail(throwable0);
                }
            }
            else {
                if(throwable0 == null) {
                    throwable0 = new ClosedChannelException();
                }
                chunkedWriteHandler$PendingWrite0.fail(throwable0);
            }
        }
    }

    private void doFlush(ChannelHandlerContext channelHandlerContext0) {
        boolean z1;
        ByteBuf byteBuf1;
        Channel channel0 = channelHandlerContext0.channel();
        ByteBuf byteBuf0 = null;
        if(!channel0.isActive()) {
            this.discard(null);
            return;
        }
        ByteBufAllocator byteBufAllocator0 = channelHandlerContext0.alloc();
        boolean z = true;
        while(channel0.isWritable()) {
            PendingWrite chunkedWriteHandler$PendingWrite0 = (PendingWrite)this.queue.peek();
            if(chunkedWriteHandler$PendingWrite0 == null) {
                break;
            }
            if(chunkedWriteHandler$PendingWrite0.promise.isDone()) {
                this.queue.remove();
            }
            else {
                Object object0 = chunkedWriteHandler$PendingWrite0.msg;
                if(object0 instanceof ChunkedInput) {
                    ChunkedInput chunkedInput0 = (ChunkedInput)object0;
                    try {
                        byteBuf1 = chunkedInput0.readChunk(byteBufAllocator0);
                    }
                    catch(Throwable throwable0) {
                        goto label_24;
                    }
                    try {
                        z1 = chunkedInput0.isEndOfInput();
                        goto label_30;
                    }
                    catch(Throwable throwable0) {
                        byteBuf0 = byteBuf1;
                    }
                label_24:
                    this.queue.remove();
                    if(byteBuf0 != null) {
                        ReferenceCountUtil.release(byteBuf0);
                    }
                    ChunkedWriteHandler.closeInput(chunkedInput0);
                    chunkedWriteHandler$PendingWrite0.fail(throwable0);
                    break;
                label_30:
                    int v = byteBuf1 == null ? !z1 : 0;
                    if(v != 0) {
                        break;
                    }
                    if(byteBuf1 == null) {
                        byteBuf1 = Unpooled.EMPTY_BUFFER;
                    }
                    if(z1) {
                        this.queue.remove();
                    }
                    ChannelFuture channelFuture0 = channelHandlerContext0.writeAndFlush(byteBuf1);
                    if(!z1) {
                        int v1 = !channel0.isWritable();
                        if(channelFuture0.isDone()) {
                            this.handleFuture(channelFuture0, chunkedWriteHandler$PendingWrite0, ((boolean)v1));
                        }
                        else {
                            channelFuture0.addListener(new ChannelFutureListener() {
                                public void operationComplete(ChannelFuture channelFuture0) {
                                    ChunkedWriteHandler.this.handleFuture(channelFuture0, chunkedWriteHandler$PendingWrite0, ((boolean)v1));
                                }

                                @Override  // io.netty.util.concurrent.GenericFutureListener
                                public void operationComplete(Future future0) {
                                    this.operationComplete(((ChannelFuture)future0));
                                }
                            });
                        }
                    }
                    else if(channelFuture0.isDone()) {
                        ChunkedWriteHandler.handleEndOfInputFuture(channelFuture0, chunkedWriteHandler$PendingWrite0);
                    }
                    else {
                        channelFuture0.addListener(new ChannelFutureListener() {
                            public void operationComplete(ChannelFuture channelFuture0) {
                                ChunkedWriteHandler.handleEndOfInputFuture(channelFuture0, chunkedWriteHandler$PendingWrite0);
                            }

                            @Override  // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(Future future0) {
                                this.operationComplete(((ChannelFuture)future0));
                            }
                        });
                    }
                    z = false;
                }
                else {
                    this.queue.remove();
                    channelHandlerContext0.write(object0, chunkedWriteHandler$PendingWrite0.promise);
                    z = true;
                }
                if(!channel0.isActive()) {
                    this.discard(new ClosedChannelException());
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
        if(z) {
            channelHandlerContext0.flush();
        }
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void flush(ChannelHandlerContext channelHandlerContext0) {
        this.doFlush(channelHandlerContext0);
    }

    private static void handleEndOfInputFuture(ChannelFuture channelFuture0, PendingWrite chunkedWriteHandler$PendingWrite0) {
        ChunkedInput chunkedInput0 = (ChunkedInput)chunkedWriteHandler$PendingWrite0.msg;
        if(!channelFuture0.isSuccess()) {
            ChunkedWriteHandler.closeInput(chunkedInput0);
            chunkedWriteHandler$PendingWrite0.fail(channelFuture0.cause());
            return;
        }
        long v = chunkedInput0.progress();
        long v1 = chunkedInput0.length();
        ChunkedWriteHandler.closeInput(chunkedInput0);
        chunkedWriteHandler$PendingWrite0.progress(v, v1);
        chunkedWriteHandler$PendingWrite0.success(v1);
    }

    private void handleFuture(ChannelFuture channelFuture0, PendingWrite chunkedWriteHandler$PendingWrite0, boolean z) {
        ChunkedInput chunkedInput0 = (ChunkedInput)chunkedWriteHandler$PendingWrite0.msg;
        if(!channelFuture0.isSuccess()) {
            ChunkedWriteHandler.closeInput(chunkedInput0);
            chunkedWriteHandler$PendingWrite0.fail(channelFuture0.cause());
            return;
        }
        chunkedWriteHandler$PendingWrite0.progress(chunkedInput0.progress(), chunkedInput0.length());
        if(z && channelFuture0.channel().isWritable()) {
            this.resumeTransfer();
        }
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext0) {
        this.ctx = channelHandlerContext0;
    }

    public void resumeTransfer() {
        ChannelHandlerContext channelHandlerContext0 = this.ctx;
        if(channelHandlerContext0 == null) {
            return;
        }
        if(channelHandlerContext0.executor().inEventLoop()) {
            this.resumeTransfer0(channelHandlerContext0);
            return;
        }
        channelHandlerContext0.executor().execute(() -> try {
            ChunkedWriteHandler.this.doFlush(this.val$ctx);
        }
        catch(Exception exception0) {
            ChunkedWriteHandler.logger.warn("Unexpected exception while sending chunks.", exception0);
        });

        class io.netty.handler.stream.ChunkedWriteHandler.1 implements Runnable {
            public io.netty.handler.stream.ChunkedWriteHandler.1(ChannelHandlerContext channelHandlerContext0) {
            }

            @Override
            public void run() {
                ChunkedWriteHandler.this.resumeTransfer0(this.val$ctx);
            }
        }

    }

    // 检测为 Lambda 实现
    private void resumeTransfer0(ChannelHandlerContext channelHandlerContext0) [...]

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void write(ChannelHandlerContext channelHandlerContext0, Object object0, ChannelPromise channelPromise0) {
        PendingWrite chunkedWriteHandler$PendingWrite0 = new PendingWrite(object0, channelPromise0);
        this.queue.add(chunkedWriteHandler$PendingWrite0);
    }
}

