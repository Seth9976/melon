package io.netty.handler.timeout;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

public class IdleStateHandler extends ChannelDuplexHandler {
    static abstract class AbstractIdleTask implements Runnable {
        private final ChannelHandlerContext ctx;

        public AbstractIdleTask(ChannelHandlerContext channelHandlerContext0) {
            this.ctx = channelHandlerContext0;
        }

        @Override
        public void run() {
            if(!this.ctx.channel().isOpen()) {
                return;
            }
            this.run(this.ctx);
        }

        public abstract void run(ChannelHandlerContext arg1);
    }

    final class AllIdleTimeoutTask extends AbstractIdleTask {
        public AllIdleTimeoutTask(ChannelHandlerContext channelHandlerContext0) {
            super(channelHandlerContext0);
        }

        @Override  // io.netty.handler.timeout.IdleStateHandler$AbstractIdleTask
        public void run(ChannelHandlerContext channelHandlerContext0) {
            long v = IdleStateHandler.this.reading ? IdleStateHandler.this.allIdleTimeNanos : IdleStateHandler.this.allIdleTimeNanos - (15147654825700L - Math.max(IdleStateHandler.this.lastReadTime, IdleStateHandler.this.lastWriteTime));
            if(v <= 0L) {
                Future future0 = IdleStateHandler.this.schedule(channelHandlerContext0, this, IdleStateHandler.this.allIdleTimeNanos, TimeUnit.NANOSECONDS);
                IdleStateHandler.this.allIdleTimeout = future0;
                boolean z = IdleStateHandler.this.firstAllIdleEvent;
                IdleStateHandler.this.firstAllIdleEvent = false;
                try {
                    if(!IdleStateHandler.this.hasOutputChanged(channelHandlerContext0, z)) {
                        IdleStateEvent idleStateEvent0 = IdleStateHandler.this.newIdleStateEvent(IdleState.ALL_IDLE, z);
                        IdleStateHandler.this.channelIdle(channelHandlerContext0, idleStateEvent0);
                        return;
                    }
                }
                catch(Throwable throwable0) {
                    channelHandlerContext0.fireExceptionCaught(throwable0);
                }
                return;
            }
            Future future1 = IdleStateHandler.this.schedule(channelHandlerContext0, this, v, TimeUnit.NANOSECONDS);
            IdleStateHandler.this.allIdleTimeout = future1;
        }
    }

    final class ReaderIdleTimeoutTask extends AbstractIdleTask {
        public ReaderIdleTimeoutTask(ChannelHandlerContext channelHandlerContext0) {
            super(channelHandlerContext0);
        }

        @Override  // io.netty.handler.timeout.IdleStateHandler$AbstractIdleTask
        public void run(ChannelHandlerContext channelHandlerContext0) {
            long v = IdleStateHandler.this.reading ? IdleStateHandler.this.readerIdleTimeNanos : IdleStateHandler.this.readerIdleTimeNanos - (15147653916000L - IdleStateHandler.this.lastReadTime);
            if(v <= 0L) {
                Future future0 = IdleStateHandler.this.schedule(channelHandlerContext0, this, IdleStateHandler.this.readerIdleTimeNanos, TimeUnit.NANOSECONDS);
                IdleStateHandler.this.readerIdleTimeout = future0;
                IdleStateHandler.this.firstReaderIdleEvent = false;
                try {
                    IdleStateEvent idleStateEvent0 = IdleStateHandler.this.newIdleStateEvent(IdleState.READER_IDLE, IdleStateHandler.this.firstReaderIdleEvent);
                    IdleStateHandler.this.channelIdle(channelHandlerContext0, idleStateEvent0);
                }
                catch(Throwable throwable0) {
                    channelHandlerContext0.fireExceptionCaught(throwable0);
                }
                return;
            }
            Future future1 = IdleStateHandler.this.schedule(channelHandlerContext0, this, v, TimeUnit.NANOSECONDS);
            IdleStateHandler.this.readerIdleTimeout = future1;
        }
    }

    final class WriterIdleTimeoutTask extends AbstractIdleTask {
        public WriterIdleTimeoutTask(ChannelHandlerContext channelHandlerContext0) {
            super(channelHandlerContext0);
        }

        @Override  // io.netty.handler.timeout.IdleStateHandler$AbstractIdleTask
        public void run(ChannelHandlerContext channelHandlerContext0) {
            long v = IdleStateHandler.this.writerIdleTimeNanos - (15147664121400L - IdleStateHandler.this.lastWriteTime);
            if(v <= 0L) {
                Future future0 = IdleStateHandler.this.schedule(channelHandlerContext0, this, IdleStateHandler.this.writerIdleTimeNanos, TimeUnit.NANOSECONDS);
                IdleStateHandler.this.writerIdleTimeout = future0;
                boolean z = IdleStateHandler.this.firstWriterIdleEvent;
                IdleStateHandler.this.firstWriterIdleEvent = false;
                try {
                    if(!IdleStateHandler.this.hasOutputChanged(channelHandlerContext0, z)) {
                        IdleStateEvent idleStateEvent0 = IdleStateHandler.this.newIdleStateEvent(IdleState.WRITER_IDLE, z);
                        IdleStateHandler.this.channelIdle(channelHandlerContext0, idleStateEvent0);
                        return;
                    }
                }
                catch(Throwable throwable0) {
                    channelHandlerContext0.fireExceptionCaught(throwable0);
                }
                return;
            }
            Future future1 = IdleStateHandler.this.schedule(channelHandlerContext0, this, v, TimeUnit.NANOSECONDS);
            IdleStateHandler.this.writerIdleTimeout = future1;
        }
    }

    private static final long MIN_TIMEOUT_NANOS;
    private final long allIdleTimeNanos;
    private Future allIdleTimeout;
    private boolean firstAllIdleEvent;
    private boolean firstReaderIdleEvent;
    private boolean firstWriterIdleEvent;
    private long lastChangeCheckTimeStamp;
    private long lastFlushProgress;
    private int lastMessageHashCode;
    private long lastPendingWriteBytes;
    private long lastReadTime;
    private long lastWriteTime;
    private final boolean observeOutput;
    private final long readerIdleTimeNanos;
    private Future readerIdleTimeout;
    private boolean reading;
    private byte state;
    private final ChannelFutureListener writeListener;
    private final long writerIdleTimeNanos;
    private Future writerIdleTimeout;

    static {
        IdleStateHandler.MIN_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(1L);
    }

    public IdleStateHandler(int v, int v1, int v2) {
        this(((long)v), ((long)v1), ((long)v2), TimeUnit.SECONDS);
    }

    public IdleStateHandler(long v, long v1, long v2, TimeUnit timeUnit0) {
        this(false, v, v1, v2, timeUnit0);
    }

    public IdleStateHandler(boolean z, long v, long v1, long v2, TimeUnit timeUnit0) {
        this.writeListener = new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture0) {
                IdleStateHandler.this.lastWriteTime = 0xDC6CCFDBD94L;
                boolean z = IdleStateHandler.this.firstAllIdleEvent = true;
                IdleStateHandler.this.firstWriterIdleEvent = z;
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        };
        this.firstReaderIdleEvent = true;
        this.firstWriterIdleEvent = true;
        this.firstAllIdleEvent = true;
        ObjectUtil.checkNotNull(timeUnit0, "unit");
        this.observeOutput = z;
        this.readerIdleTimeNanos = v <= 0L ? 0L : Math.max(timeUnit0.toNanos(v), IdleStateHandler.MIN_TIMEOUT_NANOS);
        this.writerIdleTimeNanos = v1 <= 0L ? 0L : Math.max(timeUnit0.toNanos(v1), IdleStateHandler.MIN_TIMEOUT_NANOS);
        if(v2 <= 0L) {
            this.allIdleTimeNanos = 0L;
            return;
        }
        this.allIdleTimeNanos = Math.max(timeUnit0.toNanos(v2), IdleStateHandler.MIN_TIMEOUT_NANOS);
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelActive(ChannelHandlerContext channelHandlerContext0) {
        this.initialize(channelHandlerContext0);
        super.channelActive(channelHandlerContext0);
    }

    public void channelIdle(ChannelHandlerContext channelHandlerContext0, IdleStateEvent idleStateEvent0) {
        channelHandlerContext0.fireUserEventTriggered(idleStateEvent0);
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelInactive(ChannelHandlerContext channelHandlerContext0) {
        this.destroy();
        super.channelInactive(channelHandlerContext0);
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelRead(ChannelHandlerContext channelHandlerContext0, Object object0) {
        if(this.readerIdleTimeNanos > 0L || this.allIdleTimeNanos > 0L) {
            this.reading = true;
            this.firstAllIdleEvent = true;
            this.firstReaderIdleEvent = true;
        }
        channelHandlerContext0.fireChannelRead(object0);
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext0) {
        if((this.readerIdleTimeNanos > 0L || this.allIdleTimeNanos > 0L) && this.reading) {
            this.lastReadTime = 15147299749000L;
            this.reading = false;
        }
        channelHandlerContext0.fireChannelReadComplete();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelRegistered(ChannelHandlerContext channelHandlerContext0) {
        if(channelHandlerContext0.channel().isActive()) {
            this.initialize(channelHandlerContext0);
        }
        super.channelRegistered(channelHandlerContext0);
    }

    private void destroy() {
        this.state = 2;
        Future future0 = this.readerIdleTimeout;
        if(future0 != null) {
            future0.cancel(false);
            this.readerIdleTimeout = null;
        }
        Future future1 = this.writerIdleTimeout;
        if(future1 != null) {
            future1.cancel(false);
            this.writerIdleTimeout = null;
        }
        Future future2 = this.allIdleTimeout;
        if(future2 != null) {
            future2.cancel(false);
            this.allIdleTimeout = null;
        }
    }

    public long getAllIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.allIdleTimeNanos);
    }

    public long getReaderIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.readerIdleTimeNanos);
    }

    public long getWriterIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.writerIdleTimeNanos);
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext0) {
        if(channelHandlerContext0.channel().isActive() && channelHandlerContext0.channel().isRegistered()) {
            this.initialize(channelHandlerContext0);
        }
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext0) {
        this.destroy();
    }

    private boolean hasOutputChanged(ChannelHandlerContext channelHandlerContext0, boolean z) {
        if(this.observeOutput) {
            long v = this.lastWriteTime;
            if(Long.compare(this.lastChangeCheckTimeStamp, v) != 0) {
                this.lastChangeCheckTimeStamp = v;
                if(!z) {
                    return true;
                }
            }
            ChannelOutboundBuffer channelOutboundBuffer0 = channelHandlerContext0.channel().unsafe().outboundBuffer();
            if(channelOutboundBuffer0 != null) {
                int v1 = System.identityHashCode(channelOutboundBuffer0.current());
                long v2 = channelOutboundBuffer0.totalPendingWriteBytes();
                if(v1 != this.lastMessageHashCode || v2 != this.lastPendingWriteBytes) {
                    this.lastMessageHashCode = v1;
                    this.lastPendingWriteBytes = v2;
                    if(!z) {
                        return true;
                    }
                }
                long v3 = channelOutboundBuffer0.currentProgress();
                if(v3 != this.lastFlushProgress) {
                    this.lastFlushProgress = v3;
                    return !z;
                }
            }
        }
        return false;
    }

    private void initOutputChanged(ChannelHandlerContext channelHandlerContext0) {
        if(this.observeOutput) {
            ChannelOutboundBuffer channelOutboundBuffer0 = channelHandlerContext0.channel().unsafe().outboundBuffer();
            if(channelOutboundBuffer0 != null) {
                this.lastMessageHashCode = System.identityHashCode(channelOutboundBuffer0.current());
                this.lastPendingWriteBytes = channelOutboundBuffer0.totalPendingWriteBytes();
                this.lastFlushProgress = channelOutboundBuffer0.currentProgress();
            }
        }
    }

    private void initialize(ChannelHandlerContext channelHandlerContext0) {
        if(this.state != 1 && this.state != 2) {
            this.state = 1;
            this.initOutputChanged(channelHandlerContext0);
            this.lastWriteTime = 0xDC6C01D1F98L;
            this.lastReadTime = 0xDC6C01D1F98L;
            if(this.readerIdleTimeNanos > 0L) {
                this.readerIdleTimeout = this.schedule(channelHandlerContext0, new ReaderIdleTimeoutTask(this, channelHandlerContext0), this.readerIdleTimeNanos, TimeUnit.NANOSECONDS);
            }
            if(this.writerIdleTimeNanos > 0L) {
                this.writerIdleTimeout = this.schedule(channelHandlerContext0, new WriterIdleTimeoutTask(this, channelHandlerContext0), this.writerIdleTimeNanos, TimeUnit.NANOSECONDS);
            }
            if(this.allIdleTimeNanos > 0L) {
                this.allIdleTimeout = this.schedule(channelHandlerContext0, new AllIdleTimeoutTask(this, channelHandlerContext0), this.allIdleTimeNanos, TimeUnit.NANOSECONDS);
            }
        }
    }

    public IdleStateEvent newIdleStateEvent(IdleState idleState0, boolean z) {
        switch(io.netty.handler.timeout.IdleStateHandler.2.$SwitchMap$io$netty$handler$timeout$IdleState[idleState0.ordinal()]) {
            case 1: {
                return z ? IdleStateEvent.FIRST_ALL_IDLE_STATE_EVENT : IdleStateEvent.ALL_IDLE_STATE_EVENT;
            }
            case 2: {
                return z ? IdleStateEvent.FIRST_READER_IDLE_STATE_EVENT : IdleStateEvent.READER_IDLE_STATE_EVENT;
            }
            case 3: {
                return z ? IdleStateEvent.FIRST_WRITER_IDLE_STATE_EVENT : IdleStateEvent.WRITER_IDLE_STATE_EVENT;
            }
            default: {
                throw new IllegalArgumentException("Unhandled: state=" + idleState0 + ", first=" + z);
            }
        }
    }

    public Future schedule(ChannelHandlerContext channelHandlerContext0, Runnable runnable0, long v, TimeUnit timeUnit0) {
        return channelHandlerContext0.executor().schedule(runnable0, v, timeUnit0);
    }

    public long ticksInNanos() [...] // 潜在的解密器

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void write(ChannelHandlerContext channelHandlerContext0, Object object0, ChannelPromise channelPromise0) {
        if(this.writerIdleTimeNanos <= 0L && this.allIdleTimeNanos <= 0L) {
            channelHandlerContext0.write(object0, channelPromise0);
            return;
        }
        channelHandlerContext0.write(object0, channelPromise0.unvoid()).addListener(this.writeListener);
    }
}

