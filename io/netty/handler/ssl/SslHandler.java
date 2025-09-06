package io.netty.handler.ssl;

import U4.x;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractCoalescingBufferQueue;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.channel.unix.UnixChannel;
import io.netty.handler.codec.ByteToMessageDecoder.Cumulator;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.ImmediateExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.PromiseNotifier;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult.HandshakeStatus;
import javax.net.ssl.SSLEngineResult.Status;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;

public class SslHandler extends ByteToMessageDecoder implements ChannelOutboundHandler {
    final class AsyncTaskCompletionHandler implements Runnable {
        boolean didRun;
        private final boolean inUnwrap;
        boolean resumeLater;

        public AsyncTaskCompletionHandler(boolean z) {
            this.inUnwrap = z;
        }

        public boolean resumeLater() {
            if(!this.didRun) {
                this.resumeLater = true;
                return true;
            }
            return false;
        }

        @Override
        public void run() {
            this.didRun = true;
            if(this.resumeLater) {
                SslHandler.this.getTaskRunner(this.inUnwrap).runComplete();
            }
        }
    }

    final class LazyChannelPromise extends DefaultPromise {
        private LazyChannelPromise() {
        }

        public LazyChannelPromise(io.netty.handler.ssl.SslHandler.1 sslHandler$10) {
        }

        @Override  // io.netty.util.concurrent.DefaultPromise
        public void checkDeadLock() {
            if(SslHandler.this.ctx == null) {
                return;
            }
            super.checkDeadLock();
        }

        @Override  // io.netty.util.concurrent.DefaultPromise
        public EventExecutor executor() {
            if(SslHandler.this.ctx == null) {
                throw new IllegalStateException();
            }
            return SslHandler.this.ctx.executor();
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    static abstract class SslEngineType extends Enum {
        private static final SslEngineType[] $VALUES;
        public static final enum SslEngineType CONSCRYPT;
        public static final enum SslEngineType JDK;
        public static final enum SslEngineType TCNATIVE;
        final ByteToMessageDecoder.Cumulator cumulator;
        final boolean wantsDirectBuffer;

        static {
            io.netty.handler.ssl.SslHandler.SslEngineType.1 sslHandler$SslEngineType$10 = new SslEngineType("TCNATIVE", 0, true, ByteToMessageDecoder.COMPOSITE_CUMULATOR) {
                @Override  // io.netty.handler.ssl.SslHandler$SslEngineType
                public ByteBuf allocateWrapBuffer(SslHandler sslHandler0, ByteBufAllocator byteBufAllocator0, int v, int v1) {
                    return byteBufAllocator0.directBuffer(((ReferenceCountedOpenSslEngine)sslHandler0.engine).calculateOutNetBufSize(v, v1));
                }

                @Override  // io.netty.handler.ssl.SslHandler$SslEngineType
                public int calculatePendingData(SslHandler sslHandler0, int v) {
                    int v1 = ((ReferenceCountedOpenSslEngine)sslHandler0.engine).sslPending();
                    return v1 <= 0 ? v : v1;
                }

                @Override  // io.netty.handler.ssl.SslHandler$SslEngineType
                public int calculateRequiredOutBufSpace(SslHandler sslHandler0, int v, int v1) {
                    return ((ReferenceCountedOpenSslEngine)sslHandler0.engine).calculateMaxLengthForWrap(v, v1);
                }

                @Override  // io.netty.handler.ssl.SslHandler$SslEngineType
                public boolean jdkCompatibilityMode(SSLEngine sSLEngine0) {
                    return ((ReferenceCountedOpenSslEngine)sSLEngine0).jdkCompatibilityMode;
                }

                @Override  // io.netty.handler.ssl.SslHandler$SslEngineType
                public SSLEngineResult unwrap(SslHandler sslHandler0, ByteBuf byteBuf0, int v, ByteBuf byteBuf1) {
                    SSLEngineResult sSLEngineResult0;
                    int v1 = byteBuf0.nioBufferCount();
                    int v2 = byteBuf1.writerIndex();
                    if(v1 > 1) {
                        try {
                            sslHandler0.singleBuffer[0] = SslHandler.toByteBuffer(byteBuf1, v2, byteBuf1.writableBytes());
                            sSLEngineResult0 = ((ReferenceCountedOpenSslEngine)sslHandler0.engine).unwrap(byteBuf0.nioBuffers(byteBuf0.readerIndex(), v), sslHandler0.singleBuffer);
                        }
                        finally {
                            sslHandler0.singleBuffer[0] = null;
                        }
                    }
                    else {
                        sSLEngineResult0 = sslHandler0.engine.unwrap(SslHandler.toByteBuffer(byteBuf0, byteBuf0.readerIndex(), v), SslHandler.toByteBuffer(byteBuf1, v2, byteBuf1.writableBytes()));
                    }
                    byteBuf1.writerIndex(sSLEngineResult0.bytesProduced() + v2);
                    return sSLEngineResult0;
                }
            };
            SslEngineType.TCNATIVE = sslHandler$SslEngineType$10;
            io.netty.handler.ssl.SslHandler.SslEngineType.2 sslHandler$SslEngineType$20 = new SslEngineType("CONSCRYPT", 1, true, ByteToMessageDecoder.COMPOSITE_CUMULATOR) {
                @Override  // io.netty.handler.ssl.SslHandler$SslEngineType
                public ByteBuf allocateWrapBuffer(SslHandler sslHandler0, ByteBufAllocator byteBufAllocator0, int v, int v1) {
                    return byteBufAllocator0.directBuffer(((ConscryptAlpnSslEngine)sslHandler0.engine).calculateOutNetBufSize(v, v1));
                }

                @Override  // io.netty.handler.ssl.SslHandler$SslEngineType
                public int calculatePendingData(SslHandler sslHandler0, int v) {
                    return v;
                }

                @Override  // io.netty.handler.ssl.SslHandler$SslEngineType
                public int calculateRequiredOutBufSpace(SslHandler sslHandler0, int v, int v1) {
                    return ((ConscryptAlpnSslEngine)sslHandler0.engine).calculateRequiredOutBufSpace(v, v1);
                }

                @Override  // io.netty.handler.ssl.SslHandler$SslEngineType
                public boolean jdkCompatibilityMode(SSLEngine sSLEngine0) {
                    return true;
                }

                @Override  // io.netty.handler.ssl.SslHandler$SslEngineType
                public SSLEngineResult unwrap(SslHandler sslHandler0, ByteBuf byteBuf0, int v, ByteBuf byteBuf1) {
                    SSLEngineResult sSLEngineResult0;
                    int v1 = byteBuf0.nioBufferCount();
                    int v2 = byteBuf1.writerIndex();
                    if(v1 > 1) {
                        try {
                            sslHandler0.singleBuffer[0] = SslHandler.toByteBuffer(byteBuf1, v2, byteBuf1.writableBytes());
                            sSLEngineResult0 = ((ConscryptAlpnSslEngine)sslHandler0.engine).unwrap(byteBuf0.nioBuffers(byteBuf0.readerIndex(), v), sslHandler0.singleBuffer);
                        }
                        finally {
                            sslHandler0.singleBuffer[0] = null;
                        }
                    }
                    else {
                        sSLEngineResult0 = sslHandler0.engine.unwrap(SslHandler.toByteBuffer(byteBuf0, byteBuf0.readerIndex(), v), SslHandler.toByteBuffer(byteBuf1, v2, byteBuf1.writableBytes()));
                    }
                    byteBuf1.writerIndex(sSLEngineResult0.bytesProduced() + v2);
                    return sSLEngineResult0;
                }
            };
            SslEngineType.CONSCRYPT = sslHandler$SslEngineType$20;
            io.netty.handler.ssl.SslHandler.SslEngineType.3 sslHandler$SslEngineType$30 = new SslEngineType("JDK", 2, false, ByteToMessageDecoder.MERGE_CUMULATOR) {
                @Override  // io.netty.handler.ssl.SslHandler$SslEngineType
                public ByteBuf allocateWrapBuffer(SslHandler sslHandler0, ByteBufAllocator byteBufAllocator0, int v, int v1) {
                    return byteBufAllocator0.heapBuffer(Math.max(v, sslHandler0.engine.getSession().getPacketBufferSize()));
                }

                @Override  // io.netty.handler.ssl.SslHandler$SslEngineType
                public int calculatePendingData(SslHandler sslHandler0, int v) {
                    return v;
                }

                @Override  // io.netty.handler.ssl.SslHandler$SslEngineType
                public int calculateRequiredOutBufSpace(SslHandler sslHandler0, int v, int v1) {
                    return sslHandler0.engine.getSession().getPacketBufferSize();
                }

                @Override  // io.netty.handler.ssl.SslHandler$SslEngineType
                public boolean jdkCompatibilityMode(SSLEngine sSLEngine0) {
                    return true;
                }

                @Override  // io.netty.handler.ssl.SslHandler$SslEngineType
                public SSLEngineResult unwrap(SslHandler sslHandler0, ByteBuf byteBuf0, int v, ByteBuf byteBuf1) {
                    int v1 = byteBuf1.writerIndex();
                    ByteBuffer byteBuffer0 = SslHandler.toByteBuffer(byteBuf0, byteBuf0.readerIndex(), v);
                    int v2 = byteBuffer0.position();
                    SSLEngineResult sSLEngineResult0 = sslHandler0.engine.unwrap(byteBuffer0, SslHandler.toByteBuffer(byteBuf1, v1, byteBuf1.writableBytes()));
                    byteBuf1.writerIndex(sSLEngineResult0.bytesProduced() + v1);
                    if(sSLEngineResult0.bytesConsumed() == 0) {
                        int v3 = byteBuffer0.position() - v2;
                        return v3 == sSLEngineResult0.bytesConsumed() ? sSLEngineResult0 : new SSLEngineResult(sSLEngineResult0.getStatus(), sSLEngineResult0.getHandshakeStatus(), v3, sSLEngineResult0.bytesProduced());
                    }
                    return sSLEngineResult0;
                }
            };
            SslEngineType.JDK = sslHandler$SslEngineType$30;
            SslEngineType.$VALUES = new SslEngineType[]{sslHandler$SslEngineType$10, sslHandler$SslEngineType$20, sslHandler$SslEngineType$30};
        }

        private SslEngineType(String s, int v, boolean z, ByteToMessageDecoder.Cumulator byteToMessageDecoder$Cumulator0) {
            super(s, v);
            this.wantsDirectBuffer = z;
            this.cumulator = byteToMessageDecoder$Cumulator0;
        }

        public SslEngineType(String s, int v, boolean z, ByteToMessageDecoder.Cumulator byteToMessageDecoder$Cumulator0, io.netty.handler.ssl.SslHandler.1 sslHandler$10) {
            this(s, v, z, byteToMessageDecoder$Cumulator0);
        }

        public abstract ByteBuf allocateWrapBuffer(SslHandler arg1, ByteBufAllocator arg2, int arg3, int arg4);

        public abstract int calculatePendingData(SslHandler arg1, int arg2);

        public abstract int calculateRequiredOutBufSpace(SslHandler arg1, int arg2, int arg3);

        public static SslEngineType forEngine(SSLEngine sSLEngine0) {
            if(sSLEngine0 instanceof ReferenceCountedOpenSslEngine) {
                return SslEngineType.TCNATIVE;
            }
            return sSLEngine0 instanceof ConscryptAlpnSslEngine ? SslEngineType.CONSCRYPT : SslEngineType.JDK;
        }

        public abstract boolean jdkCompatibilityMode(SSLEngine arg1);

        public abstract SSLEngineResult unwrap(SslHandler arg1, ByteBuf arg2, int arg3, ByteBuf arg4);

        public static SslEngineType valueOf(String s) {
            return (SslEngineType)Enum.valueOf(SslEngineType.class, s);
        }

        public static SslEngineType[] values() {
            return (SslEngineType[])SslEngineType.$VALUES.clone();
        }
    }

    final class SslHandlerCoalescingBufferQueue extends AbstractCoalescingBufferQueue {
        public SslHandlerCoalescingBufferQueue(Channel channel0, int v) {
            super(channel0, v);
        }

        @Override  // io.netty.channel.AbstractCoalescingBufferQueue
        public ByteBuf compose(ByteBufAllocator byteBufAllocator0, ByteBuf byteBuf0, ByteBuf byteBuf1) {
            int v = SslHandler.this.wrapDataSize;
            if(byteBuf0 instanceof CompositeByteBuf) {
                int v1 = ((CompositeByteBuf)byteBuf0).numComponents();
                if(v1 != 0 && SslHandler.attemptCopyToCumulation(((CompositeByteBuf)byteBuf0).internalComponent(v1 - 1), byteBuf1, v)) {
                    return (CompositeByteBuf)byteBuf0;
                }
                ((CompositeByteBuf)byteBuf0).addComponent(true, byteBuf1);
                return (CompositeByteBuf)byteBuf0;
            }
            return SslHandler.attemptCopyToCumulation(byteBuf0, byteBuf1, v) ? byteBuf0 : this.copyAndCompose(byteBufAllocator0, byteBuf0, byteBuf1);
        }

        @Override  // io.netty.channel.AbstractCoalescingBufferQueue
        public ByteBuf composeFirst(ByteBufAllocator byteBufAllocator0, ByteBuf byteBuf0) {
            if(byteBuf0 instanceof CompositeByteBuf) {
                CompositeByteBuf compositeByteBuf0 = (CompositeByteBuf)byteBuf0;
                ByteBuf byteBuf1 = SslHandler.this.engineType.wantsDirectBuffer ? byteBufAllocator0.directBuffer(compositeByteBuf0.readableBytes()) : byteBufAllocator0.heapBuffer(compositeByteBuf0.readableBytes());
                try {
                    byteBuf1.writeBytes(compositeByteBuf0);
                }
                catch(Throwable throwable0) {
                    byteBuf1.release();
                    PlatformDependent.throwException(throwable0);
                }
                compositeByteBuf0.release();
                return byteBuf1;
            }
            return byteBuf0;
        }

        @Override  // io.netty.channel.AbstractCoalescingBufferQueue
        public ByteBuf removeEmptyValue() {
            return null;
        }
    }

    final class SslTasksRunner implements Runnable {
        static final boolean $assertionsDisabled;
        private final boolean inUnwrap;
        private final Runnable runCompleteTask;

        static {
        }

        public SslTasksRunner(boolean z) {
            this.runCompleteTask = () -> {
                SslHandler.this.ctx.executor().execute(() -> {
                    SslHandler.this.clearState(0x80);
                    try {
                        switch(io.netty.handler.ssl.SslHandler.11.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SslHandler.this.engine.getHandshakeStatus().ordinal()]) {
                            case 1: {
                                goto label_30;
                            }
                            case 2: 
                            case 3: {
                                goto label_19;
                            }
                            case 4: {
                                break;
                            }
                            case 5: {
                                try {
                                    SslHandler.this.unwrapNonAppData(SslHandler.this.ctx);
                                }
                                catch(SSLException sSLException0) {
                                    SslHandler.this.handleUnwrapThrowable(SslHandler.this.ctx, sSLException0);
                                    return;
                                }
                                SslTasksRunner.this.tryDecodeAgain();
                                return;
                            }
                            default: {
                                throw new AssertionError();
                            }
                        }
                    }
                    catch(Throwable throwable0) {
                        SslTasksRunner.this.safeExceptionCaught(throwable0);
                        return;
                    }
                    try {
                        if(!SslHandler.this.wrapNonAppData(SslHandler.this.ctx, false) && SslTasksRunner.this.inUnwrap) {
                            SslHandler.this.unwrapNonAppData(SslHandler.this.ctx);
                        }
                        SslHandler.this.forceFlush(SslHandler.this.ctx);
                        goto label_17;
                    }
                    catch(Throwable throwable1) {
                    }
                    try {
                        SslTasksRunner.this.taskError(throwable1);
                        return;
                    label_17:
                        SslTasksRunner.this.tryDecodeAgain();
                        return;
                    label_19:
                        SslHandler.this.setHandshakeSuccess();
                    }
                    catch(Throwable throwable0) {
                        SslTasksRunner.this.safeExceptionCaught(throwable0);
                        return;
                    }
                    try {
                        SslHandler.this.wrap(SslHandler.this.ctx, SslTasksRunner.this.inUnwrap);
                        goto label_25;
                    }
                    catch(Throwable throwable2) {
                        try {
                            SslTasksRunner.this.taskError(throwable2);
                            return;
                        label_25:
                            if(SslTasksRunner.this.inUnwrap) {
                                SslHandler.this.unwrapNonAppData(SslHandler.this.ctx);
                            }
                            SslHandler.this.forceFlush(SslHandler.this.ctx);
                            SslTasksRunner.this.tryDecodeAgain();
                            return;
                        label_30:
                            SslHandler.this.executeDelegatedTask(SslTasksRunner.this);
                            return;
                        }
                        catch(Throwable throwable0) {
                        }
                    }
                    SslTasksRunner.this.safeExceptionCaught(throwable0);
                });

                class io.netty.handler.ssl.SslHandler.SslTasksRunner.2 implements Runnable {
                    @Override
                    public void run() {
                        SslTasksRunner.this.resumeOnEventExecutor();
                    }
                }

            };
            this.inUnwrap = z;
        }

        private void handleException(Throwable throwable0) {
            EventExecutor eventExecutor0 = SslHandler.this.ctx.executor();
            if(eventExecutor0.inEventLoop()) {
                SslHandler.this.clearState(0x80);
                this.safeExceptionCaught(throwable0);
                return;
            }
            try {
                eventExecutor0.execute(new Runnable() {
                    @Override
                    public void run() {
                        SslHandler.this.clearState(0x80);
                        SslTasksRunner.this.safeExceptionCaught(throwable0);
                    }
                });
            }
            catch(RejectedExecutionException unused_ex) {
                SslHandler.this.clearState(0x80);
                SslHandler.this.ctx.fireExceptionCaught(throwable0);
            }
        }

        // 检测为 Lambda 实现
        private void resumeOnEventExecutor() [...]

        @Override
        public void run() {
            try {
                Runnable runnable0 = SslHandler.this.engine.getDelegatedTask();
                if(runnable0 == null) {
                    return;
                }
                if(runnable0 instanceof AsyncRunnable) {
                    ((AsyncRunnable)runnable0).run(this.runCompleteTask);
                    return;
                }
                runnable0.run();
                this.runComplete();
                return;
            }
            catch(Throwable throwable0) {
            }
            this.handleException(throwable0);
        }

        // 检测为 Lambda 实现
        public void runComplete() [...]

        private void safeExceptionCaught(Throwable throwable0) {
            try {
                Throwable throwable2 = this.wrapIfNeeded(throwable0);
                SslHandler.this.exceptionCaught(SslHandler.this.ctx, throwable2);
            }
            catch(Throwable throwable1) {
                SslHandler.this.ctx.fireExceptionCaught(throwable1);
            }
        }

        private void taskError(Throwable throwable0) {
            if(this.inUnwrap) {
                try {
                    SslHandler.this.handleUnwrapThrowable(SslHandler.this.ctx, throwable0);
                }
                catch(Throwable throwable1) {
                    this.safeExceptionCaught(throwable1);
                }
                return;
            }
            SslHandler.this.setHandshakeFailure(SslHandler.this.ctx, throwable0);
            SslHandler.this.forceFlush(SslHandler.this.ctx);
        }

        private void tryDecodeAgain() {
            try {
                SslHandler.this.channelRead(SslHandler.this.ctx, Unpooled.EMPTY_BUFFER);
            }
            catch(Throwable throwable0) {
                this.safeExceptionCaught(throwable0);
            }
            finally {
                SslHandler.this.channelReadComplete0(SslHandler.this.ctx);
            }
        }

        private Throwable wrapIfNeeded(Throwable throwable0) {
            throw null;
        }

        class io.netty.handler.ssl.SslHandler.SslTasksRunner.1 implements Runnable {
            @Override
            public void run() {
                SslTasksRunner.this.runComplete();
            }
        }

    }

    static final boolean $assertionsDisabled = false;
    private static final Pattern IGNORABLE_CLASS_IN_STACK = null;
    private static final Pattern IGNORABLE_ERROR_MESSAGE = null;
    private static final int MAX_PLAINTEXT_LENGTH = 0x4000;
    private static final int STATE_CLOSE_NOTIFY = 0x40;
    private static final int STATE_FIRE_CHANNEL_READ = 0x100;
    private static final int STATE_FLUSHED_BEFORE_HANDSHAKE = 2;
    private static final int STATE_HANDSHAKE_STARTED = 8;
    private static final int STATE_NEEDS_FLUSH = 16;
    private static final int STATE_OUTBOUND_CLOSED = 0x20;
    private static final int STATE_PROCESS_TASK = 0x80;
    private static final int STATE_READ_DURING_HANDSHAKE = 4;
    private static final int STATE_SENT_FIRST_MESSAGE = 1;
    private static final int STATE_UNWRAP_REENTRY = 0x200;
    private volatile long closeNotifyFlushTimeoutMillis;
    private volatile long closeNotifyReadTimeoutMillis;
    private volatile ChannelHandlerContext ctx;
    private final Executor delegatedTaskExecutor;
    private final SSLEngine engine;
    private final SslEngineType engineType;
    private Promise handshakePromise;
    private volatile long handshakeTimeoutMillis;
    private final boolean jdkCompatibilityMode;
    private static final InternalLogger logger;
    private int packetLength;
    private SslHandlerCoalescingBufferQueue pendingUnencryptedWrites;
    private final ByteBuffer[] singleBuffer;
    private final LazyChannelPromise sslClosePromise;
    private final SslTasksRunner sslTaskRunner;
    private final SslTasksRunner sslTaskRunnerForUnwrap;
    private final boolean startTls;
    private short state;
    volatile int wrapDataSize;

    static {
        SslHandler.logger = InternalLoggerFactory.getInstance(SslHandler.class);
        SslHandler.IGNORABLE_CLASS_IN_STACK = Pattern.compile("^.*(?:Socket|Datagram|Sctp|Udt)Channel.*$");
        SslHandler.IGNORABLE_ERROR_MESSAGE = Pattern.compile("^.*(?:connection.*(?:reset|closed|abort|broken)|broken.*pipe).*$", 2);
    }

    public SslHandler(SSLEngine sSLEngine0) {
        this(sSLEngine0, false);
    }

    public SslHandler(SSLEngine sSLEngine0, Executor executor0) {
        this(sSLEngine0, false, executor0);
    }

    public SslHandler(SSLEngine sSLEngine0, boolean z) {
        this(sSLEngine0, z, ImmediateExecutor.INSTANCE);
    }

    public SslHandler(SSLEngine sSLEngine0, boolean z, Executor executor0) {
        this.singleBuffer = new ByteBuffer[1];
        this.sslTaskRunnerForUnwrap = new SslTasksRunner(this, true);
        this.sslTaskRunner = new SslTasksRunner(this, false);
        this.handshakePromise = new LazyChannelPromise(this, null);
        this.sslClosePromise = new LazyChannelPromise(this, null);
        this.handshakeTimeoutMillis = 10000L;
        this.closeNotifyFlushTimeoutMillis = 3000L;
        this.wrapDataSize = 0x4000;
        this.engine = (SSLEngine)ObjectUtil.checkNotNull(sSLEngine0, "engine");
        this.delegatedTaskExecutor = (Executor)ObjectUtil.checkNotNull(executor0, "delegatedTaskExecutor");
        SslEngineType sslHandler$SslEngineType0 = SslEngineType.forEngine(sSLEngine0);
        this.engineType = sslHandler$SslEngineType0;
        this.startTls = z;
        this.jdkCompatibilityMode = sslHandler$SslEngineType0.jdkCompatibilityMode(sSLEngine0);
        this.setCumulator(sslHandler$SslEngineType0.cumulator);
    }

    private static void addCloseListener(ChannelFuture channelFuture0, ChannelPromise channelPromise0) {
        PromiseNotifier.cascade(false, channelFuture0, channelPromise0);
    }

    private ByteBuf allocate(ChannelHandlerContext channelHandlerContext0, int v) {
        ByteBufAllocator byteBufAllocator0 = channelHandlerContext0.alloc();
        return this.engineType.wantsDirectBuffer ? byteBufAllocator0.directBuffer(v) : byteBufAllocator0.buffer(v);
    }

    private ByteBuf allocateOutNetBuf(ChannelHandlerContext channelHandlerContext0, int v, int v1) {
        ByteBufAllocator byteBufAllocator0 = channelHandlerContext0.alloc();
        return this.engineType.allocateWrapBuffer(this, byteBufAllocator0, v, v1);
    }

    public String applicationProtocol() {
        SSLEngine sSLEngine0 = this.engine();
        return sSLEngine0 instanceof ApplicationProtocolAccessor ? ((ApplicationProtocolAccessor)sSLEngine0).getNegotiatedApplicationProtocol() : null;
    }

    private void applyHandshakeTimeout() {
        Promise promise0 = this.handshakePromise;
        long v = this.handshakeTimeoutMillis;
        if(v > 0L && !promise0.isDone()) {
            promise0.addListener(new FutureListener() {
                @Override  // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future future0) {
                    this.ctx.executor().schedule(new io.netty.handler.ssl.SslHandler.7(this, promise0, v), v, TimeUnit.MILLISECONDS).cancel(false);
                }
            });
        }

        class io.netty.handler.ssl.SslHandler.7 implements Runnable {
            public io.netty.handler.ssl.SslHandler.7(Promise promise0, long v) {
            }

            @Override
            public void run() {
                if(this.val$localHandshakePromise.isDone()) {
                    return;
                }
                StringBuilder stringBuilder0 = new StringBuilder("handshake timed out after ");
                SslHandshakeTimeoutException sslHandshakeTimeoutException0 = new SslHandshakeTimeoutException(x.h(this.val$handshakeTimeoutMillis, "ms", stringBuilder0));
                try {
                    if(this.val$localHandshakePromise.tryFailure(sslHandshakeTimeoutException0)) {
                        SslUtils.handleHandshakeFailure(SslHandler.this.ctx, sslHandshakeTimeoutException0, true);
                    }
                }
                finally {
                    SslHandler.this.releaseAndFailAll(SslHandler.this.ctx, sslHandshakeTimeoutException0);
                }
            }
        }

    }

    private static boolean attemptCopyToCumulation(ByteBuf byteBuf0, ByteBuf byteBuf1, int v) {
        int v1 = byteBuf1.readableBytes();
        int v2 = byteBuf0.capacity();
        if(v - byteBuf0.readableBytes() >= v1 && (byteBuf0.isWritable(v1) && v2 >= v || v2 < v && ByteBufUtil.ensureWritableSuccess(byteBuf0.ensureWritable(v1, false)))) {
            byteBuf0.writeBytes(byteBuf1);
            byteBuf1.release();
            return true;
        }
        return false;
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0, ChannelPromise channelPromise0) {
        channelHandlerContext0.bind(socketAddress0, channelPromise0);
    }

    public void channelActive(ChannelHandlerContext channelHandlerContext0) {
        this.setOpensslEngineSocketFd(channelHandlerContext0.channel());
        if(!this.startTls) {
            this.startHandshakeProcessing(true);
        }
        channelHandlerContext0.fireChannelActive();
    }

    public void channelInactive(ChannelHandlerContext channelHandlerContext0) {
        boolean z = this.handshakePromise.cause() != null;
        ClosedChannelException closedChannelException0 = new ClosedChannelException();
        if(this.isStateSet(8) && !this.handshakePromise.isDone()) {
            ThrowableUtil.addSuppressed(closedChannelException0, StacklessSSLHandshakeException.newInstance("Connection closed while SSL/TLS handshake was in progress", SslHandler.class, "channelInactive"));
        }
        this.setHandshakeFailure(channelHandlerContext0, closedChannelException0, !this.isStateSet(0x20), this.isStateSet(8), false);
        this.notifyClosePromise(closedChannelException0);
        try {
            super.channelInactive(channelHandlerContext0);
        }
        catch(DecoderException decoderException0) {
            if(!z || !(decoderException0.getCause() instanceof SSLException)) {
                throw decoderException0;
            }
        }
    }

    public void channelReadComplete(ChannelHandlerContext channelHandlerContext0) {
        this.channelReadComplete0(channelHandlerContext0);
    }

    private void channelReadComplete0(ChannelHandlerContext channelHandlerContext0) {
        this.discardSomeReadBytes();
        this.flushIfNeeded(channelHandlerContext0);
        this.readIfNeeded(channelHandlerContext0);
        this.clearState(0x100);
        channelHandlerContext0.fireChannelReadComplete();
    }

    private void clearState(int v) {
        this.state = (short)(~v & this.state);
    }

    @Deprecated
    public ChannelFuture close() {
        return this.closeOutbound();
    }

    @Deprecated
    public ChannelFuture close(ChannelPromise channelPromise0) {
        return this.closeOutbound(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        this.closeOutboundAndChannel(channelHandlerContext0, channelPromise0, false);
    }

    public ChannelFuture closeOutbound() {
        return this.closeOutbound(this.ctx.newPromise());
    }

    public ChannelFuture closeOutbound(ChannelPromise channelPromise0) {
        ChannelHandlerContext channelHandlerContext0 = this.ctx;
        if(channelHandlerContext0.executor().inEventLoop()) {
            this.closeOutbound0(channelPromise0);
            return channelPromise0;
        }
        channelHandlerContext0.executor().execute(() -> {
            SslHandler.this.setState(0x20);
            SslHandler.this.engine.closeOutbound();
            try {
                SslHandler.this.flush(SslHandler.this.ctx, this.val$promise);
            }
            catch(Exception exception0) {
                if(!this.val$promise.tryFailure(exception0)) {
                    Channel channel0 = SslHandler.this.ctx.channel();
                    SslHandler.logger.warn("{} flush() raised a masked exception.", channel0, exception0);
                }
            }
        });
        return channelPromise0;

        class io.netty.handler.ssl.SslHandler.1 implements Runnable {
            public io.netty.handler.ssl.SslHandler.1(ChannelPromise channelPromise0) {
            }

            @Override
            public void run() {
                SslHandler.this.closeOutbound0(this.val$promise);
            }
        }

    }

    // 检测为 Lambda 实现
    private void closeOutbound0(ChannelPromise channelPromise0) [...]

    private void closeOutboundAndChannel(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0, boolean z) {
        this.setState(0x20);
        this.engine.closeOutbound();
        if(!channelHandlerContext0.channel().isActive()) {
            if(z) {
                channelHandlerContext0.disconnect(channelPromise0);
                return;
            }
            channelHandlerContext0.close(channelPromise0);
            return;
        }
        ChannelPromise channelPromise1 = channelHandlerContext0.newPromise();
        try {
            this.flush(channelHandlerContext0, channelPromise1);
        }
        catch(Throwable throwable0) {
            if(this.isStateSet(0x40)) {
                io.netty.handler.ssl.SslHandler.5 sslHandler$50 = new FutureListener() {
                    @Override  // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future future0) {
                        channelPromise0.setSuccess();
                    }
                };
                this.sslClosePromise.addListener(sslHandler$50);
            }
            else {
                this.setState(0x40);
                this.safeClose(channelHandlerContext0, channelPromise1, ((ChannelPromise)PromiseNotifier.cascade(false, channelHandlerContext0.newPromise(), channelPromise0)));
            }
            throw throwable0;
        }
        if(!this.isStateSet(0x40)) {
            this.setState(0x40);
            this.safeClose(channelHandlerContext0, channelPromise1, ((ChannelPromise)PromiseNotifier.cascade(false, channelHandlerContext0.newPromise(), channelPromise0)));
            return;
        }
        io.netty.handler.ssl.SslHandler.5 sslHandler$51 = new FutureListener() {
            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                channelPromise0.setSuccess();
            }
        };
        this.sslClosePromise.addListener(sslHandler$51);
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
        channelHandlerContext0.connect(socketAddress0, socketAddress1, channelPromise0);
    }

    public void decode(ChannelHandlerContext channelHandlerContext0, ByteBuf byteBuf0, List list0) {
        if(this.isStateSet(0x80)) {
            return;
        }
        if(this.jdkCompatibilityMode) {
            this.decodeJdkCompatible(channelHandlerContext0, byteBuf0);
            return;
        }
        this.decodeNonJdkCompatible(channelHandlerContext0, byteBuf0);
    }

    private void decodeJdkCompatible(ChannelHandlerContext channelHandlerContext0, ByteBuf byteBuf0) {
        int v = this.packetLength;
        if(v > 0) {
            if(byteBuf0.readableBytes() >= v) {
                goto label_17;
            }
            return;
        }
        int v1 = byteBuf0.readableBytes();
        if(v1 >= 5) {
            int v2 = SslUtils.getEncryptedPacketLength(byteBuf0, byteBuf0.readerIndex());
            switch(v2) {
                case -2: {
                    NotSslRecordException notSslRecordException0 = new NotSslRecordException("not an SSL/TLS record: " + ByteBufUtil.hexDump(byteBuf0));
                    byteBuf0.skipBytes(byteBuf0.readableBytes());
                    this.setHandshakeFailure(channelHandlerContext0, notSslRecordException0);
                    throw notSslRecordException0;
                label_13:
                    if(v2 > v1) {
                        this.packetLength = v2;
                        return;
                    }
                    v = v2;
                    try {
                    label_17:
                        this.packetLength = 0;
                        this.unwrap(channelHandlerContext0, byteBuf0, v);
                    }
                    catch(Throwable throwable0) {
                        this.handleUnwrapThrowable(channelHandlerContext0, throwable0);
                    }
                    return;
                }
                case -1: {
                    break;
                }
                default: {
                    goto label_13;
                }
            }
        }
    }

    private void decodeNonJdkCompatible(ChannelHandlerContext channelHandlerContext0, ByteBuf byteBuf0) {
        try {
            this.unwrap(channelHandlerContext0, byteBuf0, byteBuf0.readableBytes());
        }
        catch(Throwable throwable0) {
            this.handleUnwrapThrowable(channelHandlerContext0, throwable0);
        }
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        channelHandlerContext0.deregister(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        this.closeOutboundAndChannel(channelHandlerContext0, channelPromise0, true);
    }

    public SSLEngine engine() {
        return this.engine;
    }

    @Override  // io.netty.channel.ChannelHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
        if(this.ignoreException(throwable0)) {
            InternalLogger internalLogger0 = SslHandler.logger;
            if(internalLogger0.isDebugEnabled()) {
                internalLogger0.debug("{} Swallowing a harmless \'connection reset by peer / broken pipe\' error that occurred while writing close_notify in response to the peer\'s close_notify", channelHandlerContext0.channel(), throwable0);
            }
            if(channelHandlerContext0.channel().isActive()) {
                channelHandlerContext0.close();
            }
            return;
        }
        channelHandlerContext0.fireExceptionCaught(throwable0);
    }

    private void executeChannelRead(ChannelHandlerContext channelHandlerContext0, ByteBuf byteBuf0) {
        try {
            channelHandlerContext0.executor().execute(new Runnable() {
                @Override
                public void run() {
                    channelHandlerContext0.fireChannelRead(byteBuf0);
                }
            });
        }
        catch(RejectedExecutionException rejectedExecutionException0) {
            byteBuf0.release();
            throw rejectedExecutionException0;
        }
    }

    private void executeDelegatedTask(SslTasksRunner sslHandler$SslTasksRunner0) {
        this.setState(0x80);
        try {
            this.delegatedTaskExecutor.execute(sslHandler$SslTasksRunner0);
        }
        catch(RejectedExecutionException rejectedExecutionException0) {
            this.clearState(0x80);
            throw rejectedExecutionException0;
        }
    }

    private void executeDelegatedTask(boolean z) {
        this.executeDelegatedTask(this.getTaskRunner(z));
    }

    private void executeNotifyClosePromise(ChannelHandlerContext channelHandlerContext0) {
        try {
            channelHandlerContext0.executor().execute(() -> if(null == null) {
                Channel channel0 = SslHandler.this.ctx.channel();
                if(SslHandler.this.sslClosePromise.trySuccess(channel0)) {
                    SslHandler.this.ctx.fireUserEventTriggered(SslCloseCompletionEvent.SUCCESS);
                }
            }
            else if(SslHandler.this.sslClosePromise.tryFailure(null)) {
                SslHandler.this.ctx.fireUserEventTriggered(new SslCloseCompletionEvent(null));
            });
        }
        catch(RejectedExecutionException rejectedExecutionException0) {
            this.notifyClosePromise(rejectedExecutionException0);
        }

        class io.netty.handler.ssl.SslHandler.3 implements Runnable {
            @Override
            public void run() {
                SslHandler.this.notifyClosePromise(null);
            }
        }

    }

    private void flush(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        SslHandlerCoalescingBufferQueue sslHandler$SslHandlerCoalescingBufferQueue0 = this.pendingUnencryptedWrites;
        if(sslHandler$SslHandlerCoalescingBufferQueue0 == null) {
            channelPromise0.setFailure(SslHandler.newPendingWritesNullException());
        }
        else {
            sslHandler$SslHandlerCoalescingBufferQueue0.add(Unpooled.EMPTY_BUFFER, channelPromise0);
        }
        this.flush(channelHandlerContext0);
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext0) {
        if(this.startTls && !this.isStateSet(1)) {
            this.setState(1);
            this.pendingUnencryptedWrites.writeAndRemoveAll(channelHandlerContext0);
            this.forceFlush(channelHandlerContext0);
            this.startHandshakeProcessing(true);
            return;
        }
        if(this.isStateSet(0x80)) {
            return;
        }
        try {
            this.wrapAndFlush(channelHandlerContext0);
        }
        catch(Throwable throwable0) {
            this.setHandshakeFailure(channelHandlerContext0, throwable0);
            PlatformDependent.throwException(throwable0);
        }
    }

    private void flushIfNeeded(ChannelHandlerContext channelHandlerContext0) {
        if(this.isStateSet(16)) {
            this.forceFlush(channelHandlerContext0);
        }
    }

    private void forceFlush(ChannelHandlerContext channelHandlerContext0) {
        this.clearState(16);
        channelHandlerContext0.flush();
    }

    public final long getCloseNotifyFlushTimeoutMillis() {
        return this.closeNotifyFlushTimeoutMillis;
    }

    public final long getCloseNotifyReadTimeoutMillis() {
        return this.closeNotifyReadTimeoutMillis;
    }

    @Deprecated
    public long getCloseNotifyTimeoutMillis() {
        return this.getCloseNotifyFlushTimeoutMillis();
    }

    public long getHandshakeTimeoutMillis() {
        return this.handshakeTimeoutMillis;
    }

    // 去混淆评级： 低(20)
    private SslTasksRunner getTaskRunner(boolean z) {
        return z ? this.sslTaskRunnerForUnwrap : this.sslTaskRunner;
    }

    private void handleUnwrapThrowable(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
        try {
            if(this.handshakePromise.tryFailure(throwable0)) {
                channelHandlerContext0.fireUserEventTriggered(new SslHandshakeCompletionEvent(throwable0));
            }
            if(this.pendingUnencryptedWrites != null) {
                this.wrapAndFlush(channelHandlerContext0);
            }
        }
        catch(SSLException sSLException0) {
            SslHandler.logger.debug("SSLException during trying to call SSLEngine.wrap(...) because of an previous SSLException, ignoring...", sSLException0);
        }
        finally {
            this.setHandshakeFailure(channelHandlerContext0, throwable0, true, false, true);
        }
        PlatformDependent.throwException(throwable0);
    }

    @Override  // io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext0) {
        this.ctx = channelHandlerContext0;
        Channel channel0 = channelHandlerContext0.channel();
        this.pendingUnencryptedWrites = new SslHandlerCoalescingBufferQueue(this, channel0, 16);
        this.setOpensslEngineSocketFd(channel0);
        Object object0 = channel0.config().getOption(ChannelOption.TCP_FASTOPEN_CONNECT);
        boolean z = Boolean.TRUE.equals(object0);
        boolean z1 = channel0.isActive();
        if(z1 || z) {
            this.startHandshakeProcessing(z1);
            if(z) {
                ChannelOutboundBuffer channelOutboundBuffer0 = channel0.unsafe().outboundBuffer();
                if(channelOutboundBuffer0 == null || channelOutboundBuffer0.totalPendingWriteBytes() > 0L) {
                    this.setState(16);
                }
            }
        }
    }

    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext0) {
        try {
            if(this.pendingUnencryptedWrites != null && !this.pendingUnencryptedWrites.isEmpty()) {
                this.pendingUnencryptedWrites.releaseAndFailAll(channelHandlerContext0, new ChannelException("Pending write on removal of SslHandler"));
            }
            SSLException sSLException0 = null;
            this.pendingUnencryptedWrites = null;
            if(!this.handshakePromise.isDone()) {
                sSLException0 = new SSLHandshakeException("SslHandler removed before handshake completed");
                if(this.handshakePromise.tryFailure(sSLException0)) {
                    channelHandlerContext0.fireUserEventTriggered(new SslHandshakeCompletionEvent(sSLException0));
                }
            }
            if(!this.sslClosePromise.isDone()) {
                if(sSLException0 == null) {
                    sSLException0 = new SSLException("SslHandler removed before SSLEngine was closed");
                }
                this.notifyClosePromise(sSLException0);
            }
        }
        finally {
            ReferenceCountUtil.release(this.engine);
        }
    }

    private void handshake(boolean z) {
        ChannelHandlerContext channelHandlerContext0;
        if(this.engine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING && !this.handshakePromise.isDone()) {
            try {
                channelHandlerContext0 = this.ctx;
                this.engine.beginHandshake();
                this.wrapNonAppData(channelHandlerContext0, false);
            }
            catch(Throwable throwable0) {
                try {
                    this.setHandshakeFailure(channelHandlerContext0, throwable0);
                }
                catch(Throwable throwable1) {
                    if(z) {
                        this.forceFlush(channelHandlerContext0);
                    }
                    throw throwable1;
                }
                if(z) {
                    this.forceFlush(channelHandlerContext0);
                    return;
                }
                return;
            }
            if(z) {
                this.forceFlush(channelHandlerContext0);
            }
        }
    }

    public Future handshakeFuture() {
        return this.handshakePromise;
    }

    private boolean ignoreException(Throwable throwable0) {
        if(!(throwable0 instanceof SSLException) && throwable0 instanceof IOException && this.sslClosePromise.isDone()) {
            String s = throwable0.getMessage();
            if(s != null && SslHandler.IGNORABLE_ERROR_MESSAGE.matcher(s).matches()) {
                return true;
            }
            StackTraceElement[] arr_stackTraceElement = throwable0.getStackTrace();
            for(int v = 0; v < arr_stackTraceElement.length; ++v) {
                StackTraceElement stackTraceElement0 = arr_stackTraceElement[v];
                String s1 = stackTraceElement0.getClassName();
                if(!s1.startsWith("io.netty.") && "read".equals(stackTraceElement0.getMethodName())) {
                    if(SslHandler.IGNORABLE_CLASS_IN_STACK.matcher(s1).matches()) {
                        return true;
                    }
                    try {
                        Class class0 = PlatformDependent.getClassLoader(this.getClass()).loadClass(s1);
                        if(SocketChannel.class.isAssignableFrom(class0) || DatagramChannel.class.isAssignableFrom(class0)) {
                            return true;
                        }
                    }
                    catch(Throwable throwable1) {
                        InternalLogger internalLogger0 = SslHandler.logger;
                        if(internalLogger0.isDebugEnabled()) {
                            internalLogger0.debug("Unexpected exception while loading class {} classname {}", new Object[]{this.getClass(), s1, throwable1});
                        }
                    }
                }
            }
        }
        return false;
    }

    // 去混淆评级： 低(20)
    private static boolean inEventLoop(Executor executor0) {
        return executor0 instanceof EventExecutor && ((EventExecutor)executor0).inEventLoop();
    }

    public static boolean isEncrypted(ByteBuf byteBuf0) {
        if(byteBuf0.readableBytes() < 5) {
            throw new IllegalArgumentException("buffer must have at least 5 readable bytes");
        }
        return SslUtils.getEncryptedPacketLength(byteBuf0, byteBuf0.readerIndex()) != -2;
    }

    private boolean isStateSet(int v) {
        return (this.state & v) == v;
    }

    private static IllegalStateException newPendingWritesNullException() {
        return new IllegalStateException("pendingUnencryptedWrites is null, handlerRemoved0 called?");
    }

    // 检测为 Lambda 实现
    private void notifyClosePromise(Throwable throwable0) [...]

    @Override  // io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext0) {
        if(!this.handshakePromise.isDone()) {
            this.setState(4);
        }
        channelHandlerContext0.read();
    }

    private void readIfNeeded(ChannelHandlerContext channelHandlerContext0) {
        if(!channelHandlerContext0.channel().config().isAutoRead() && (!this.isStateSet(0x100) || !this.handshakePromise.isDone())) {
            channelHandlerContext0.read();
        }
    }

    private void releaseAndFailAll(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
        SslHandlerCoalescingBufferQueue sslHandler$SslHandlerCoalescingBufferQueue0 = this.pendingUnencryptedWrites;
        if(sslHandler$SslHandlerCoalescingBufferQueue0 != null) {
            sslHandler$SslHandlerCoalescingBufferQueue0.releaseAndFailAll(channelHandlerContext0, throwable0);
        }
    }

    public Future renegotiate() {
        ChannelHandlerContext channelHandlerContext0 = this.ctx;
        if(channelHandlerContext0 == null) {
            throw new IllegalStateException();
        }
        return this.renegotiate(channelHandlerContext0.executor().newPromise());
    }

    public Future renegotiate(Promise promise0) {
        ObjectUtil.checkNotNull(promise0, "promise");
        ChannelHandlerContext channelHandlerContext0 = this.ctx;
        if(channelHandlerContext0 == null) {
            throw new IllegalStateException();
        }
        EventExecutor eventExecutor0 = channelHandlerContext0.executor();
        if(!eventExecutor0.inEventLoop()) {
            eventExecutor0.execute(() -> {
                Promise promise1 = SslHandler.this.handshakePromise;
                if(!promise1.isDone()) {
                    PromiseNotifier.cascade(promise1, this.val$promise);
                    return;
                }
                SslHandler.this.handshakePromise = this.val$promise;
                SslHandler.this.handshake(true);
                SslHandler.this.applyHandshakeTimeout();
            });
            return promise0;
        }
        this.renegotiateOnEventLoop(promise0);
        return promise0;

        class io.netty.handler.ssl.SslHandler.6 implements Runnable {
            public io.netty.handler.ssl.SslHandler.6(Promise promise0) {
            }

            @Override
            public void run() {
                SslHandler.this.renegotiateOnEventLoop(this.val$promise);
            }
        }

    }

    // 检测为 Lambda 实现
    private void renegotiateOnEventLoop(Promise promise0) [...]

    private boolean runDelegatedTasks(boolean z) {
        if(this.delegatedTaskExecutor != ImmediateExecutor.INSTANCE && !SslHandler.inEventLoop(this.delegatedTaskExecutor)) {
            this.executeDelegatedTask(z);
            return false;
        }
        while(true) {
            Runnable runnable0 = this.engine.getDelegatedTask();
            if(runnable0 == null) {
                return true;
            }
            this.setState(0x80);
            if(runnable0 instanceof AsyncRunnable) {
                try {
                    AsyncTaskCompletionHandler sslHandler$AsyncTaskCompletionHandler0 = new AsyncTaskCompletionHandler(this, z);
                    ((AsyncRunnable)runnable0).run(sslHandler$AsyncTaskCompletionHandler0);
                    if(sslHandler$AsyncTaskCompletionHandler0.resumeLater()) {
                        return false;
                    }
                }
                catch(Throwable throwable0) {
                    this.clearState(0x80);
                    throw throwable0;
                }
            }
            else {
                try {
                    runnable0.run();
                }
                catch(Throwable throwable1) {
                    this.clearState(0x80);
                    throw throwable1;
                }
            }
            this.clearState(0x80);
        }
    }

    private void safeClose(ChannelHandlerContext channelHandlerContext0, ChannelFuture channelFuture0, ChannelPromise channelPromise0) {
        Future future0 = null;
        if(!channelHandlerContext0.channel().isActive()) {
            channelHandlerContext0.close(channelPromise0);
            return;
        }
        if(!channelFuture0.isDone()) {
            long v = this.closeNotifyFlushTimeoutMillis;
            if(v > 0L) {
                future0 = channelHandlerContext0.executor().schedule(new Runnable() {
                    @Override
                    public void run() {
                        if(!channelFuture0.isDone()) {
                            SslHandler.logger.warn("{} Last write attempt timed out; force-closing the connection.", channelHandlerContext0.channel());
                            ChannelPromise channelPromise0 = channelHandlerContext0.newPromise();
                            SslHandler.addCloseListener(channelHandlerContext0.close(channelPromise0), channelPromise0);
                        }
                    }
                }, v, TimeUnit.MILLISECONDS);
            }
        }
        channelFuture0.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture0) {
                Future future0 = future0;
                if(future0 != null) {
                    future0.cancel(false);
                }
                long v = SslHandler.this.closeNotifyReadTimeoutMillis;
                if(v <= 0L) {
                    ChannelPromise channelPromise0 = channelHandlerContext0.newPromise();
                    SslHandler.addCloseListener(channelHandlerContext0.close(channelPromise0), channelPromise0);
                    return;
                }
                io.netty.handler.ssl.SslHandler.10.2 sslHandler$10$20 = new FutureListener() {
                    @Override  // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future future0) {
                        Future future1 = (SslHandler.this.sslClosePromise.isDone() ? null : this.val$ctx.executor().schedule(new io.netty.handler.ssl.SslHandler.10.1(this, v), v, TimeUnit.MILLISECONDS));
                        if(future1 != null) {
                            future1.cancel(false);
                        }
                        ChannelPromise channelPromise0 = io.netty.handler.ssl.SslHandler.10.this.val$ctx.newPromise();
                        SslHandler.addCloseListener(io.netty.handler.ssl.SslHandler.10.this.val$ctx.close(channelPromise0), io.netty.handler.ssl.SslHandler.10.this.val$promise);
                    }
                };
                SslHandler.this.sslClosePromise.addListener(sslHandler$10$20);

                class io.netty.handler.ssl.SslHandler.10.1 implements Runnable {
                    public io.netty.handler.ssl.SslHandler.10.1(long v) {
                    }

                    @Override
                    public void run() {
                        if(!SslHandler.this.sslClosePromise.isDone()) {
                            SslHandler.logger.debug("{} did not receive close_notify in {}ms; force-closing the connection.", io.netty.handler.ssl.SslHandler.10.this.val$ctx.channel(), this.val$closeNotifyReadTimeout);
                            ChannelPromise channelPromise0 = io.netty.handler.ssl.SslHandler.10.this.val$ctx.newPromise();
                            SslHandler.addCloseListener(io.netty.handler.ssl.SslHandler.10.this.val$ctx.close(channelPromise0), io.netty.handler.ssl.SslHandler.10.this.val$promise);
                        }
                    }
                }

            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        });
    }

    public final void setCloseNotifyFlushTimeout(long v, TimeUnit timeUnit0) {
        this.setCloseNotifyFlushTimeoutMillis(timeUnit0.toMillis(v));
    }

    public final void setCloseNotifyFlushTimeoutMillis(long v) {
        this.closeNotifyFlushTimeoutMillis = ObjectUtil.checkPositiveOrZero(v, "closeNotifyFlushTimeoutMillis");
    }

    public final void setCloseNotifyReadTimeout(long v, TimeUnit timeUnit0) {
        this.setCloseNotifyReadTimeoutMillis(timeUnit0.toMillis(v));
    }

    public final void setCloseNotifyReadTimeoutMillis(long v) {
        this.closeNotifyReadTimeoutMillis = ObjectUtil.checkPositiveOrZero(v, "closeNotifyReadTimeoutMillis");
    }

    @Deprecated
    public void setCloseNotifyTimeout(long v, TimeUnit timeUnit0) {
        this.setCloseNotifyFlushTimeout(v, timeUnit0);
    }

    @Deprecated
    public void setCloseNotifyTimeoutMillis(long v) {
        this.setCloseNotifyFlushTimeoutMillis(v);
    }

    private void setHandshakeFailure(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
        this.setHandshakeFailure(channelHandlerContext0, throwable0, true, true, false);
    }

    private void setHandshakeFailure(ChannelHandlerContext channelHandlerContext0, Throwable throwable0, boolean z, boolean z1, boolean z2) {
        try {
            this.setState(0x20);
            this.engine.closeOutbound();
            if(z) {
                try {
                    this.engine.closeInbound();
                }
                catch(SSLException sSLException0) {
                    InternalLogger internalLogger0 = SslHandler.logger;
                    if(internalLogger0.isDebugEnabled()) {
                        String s = sSLException0.getMessage();
                        if(s == null || !s.contains("possible truncation attack") && !s.contains("closing inbound before receiving peer\'s close_notify")) {
                            internalLogger0.debug("{} SSLEngine.closeInbound() raised an exception.", channelHandlerContext0.channel(), sSLException0);
                        }
                    }
                }
            }
            if(this.handshakePromise.tryFailure(throwable0) || z2) {
                SslUtils.handleHandshakeFailure(channelHandlerContext0, throwable0, z1);
            }
        }
        finally {
            this.releaseAndFailAll(channelHandlerContext0, throwable0);
        }
    }

    private void setHandshakeFailureTransportFailure(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
        try {
            SSLException sSLException0 = new SSLException("failure when writing TLS control frames", throwable0);
            this.releaseAndFailAll(channelHandlerContext0, sSLException0);
            if(this.handshakePromise.tryFailure(sSLException0)) {
                channelHandlerContext0.fireUserEventTriggered(new SslHandshakeCompletionEvent(sSLException0));
            }
        }
        finally {
            channelHandlerContext0.close();
        }
    }

    private boolean setHandshakeSuccess() {
        boolean z = !this.handshakePromise.isDone() && this.handshakePromise.trySuccess(this.ctx.channel());
        if(z) {
            InternalLogger internalLogger0 = SslHandler.logger;
            if(internalLogger0.isDebugEnabled()) {
                SSLSession sSLSession0 = this.engine.getSession();
                internalLogger0.debug("{} HANDSHAKEN: protocol:{} cipher suite:{}", new Object[]{this.ctx.channel(), sSLSession0.getProtocol(), sSLSession0.getCipherSuite()});
            }
            this.ctx.fireUserEventTriggered(SslHandshakeCompletionEvent.SUCCESS);
        }
        if(this.isStateSet(4)) {
            this.clearState(4);
            if(!this.ctx.channel().config().isAutoRead()) {
                this.ctx.read();
            }
        }
        return z;
    }

    private boolean setHandshakeSuccessUnwrapMarkReentry() {
        boolean z1;
        boolean z = this.isStateSet(0x200);
        if(!z) {
            this.setState(0x200);
        }
        try {
            z1 = this.setHandshakeSuccess();
        }
        catch(Throwable throwable0) {
            if(!z) {
                this.clearState(0x200);
            }
            throw throwable0;
        }
        if(!z) {
            this.clearState(0x200);
        }
        return z1;
    }

    public void setHandshakeTimeout(long v, TimeUnit timeUnit0) {
        ObjectUtil.checkNotNull(timeUnit0, "unit");
        this.setHandshakeTimeoutMillis(timeUnit0.toMillis(v));
    }

    public void setHandshakeTimeoutMillis(long v) {
        this.handshakeTimeoutMillis = ObjectUtil.checkPositiveOrZero(v, "handshakeTimeoutMillis");
    }

    private void setOpensslEngineSocketFd(Channel channel0) {
        if(channel0 instanceof UnixChannel) {
            SSLEngine sSLEngine0 = this.engine;
            if(sSLEngine0 instanceof ReferenceCountedOpenSslEngine) {
                ((ReferenceCountedOpenSslEngine)sSLEngine0).bioSetFd(((UnixChannel)channel0).fd().intValue());
            }
        }
    }

    private void setState(int v) {
        this.state = (short)(v | this.state);
    }

    public final void setWrapDataSize(int v) {
        this.wrapDataSize = v;
    }

    public Future sslCloseFuture() {
        return this.sslClosePromise;
    }

    private void startHandshakeProcessing(boolean z) {
        if(!this.isStateSet(8)) {
            this.setState(8);
            if(this.engine.getUseClientMode()) {
                this.handshake(z);
            }
            this.applyHandshakeTimeout();
            return;
        }
        if(this.isStateSet(16)) {
            this.forceFlush(this.ctx);
        }
    }

    private static ByteBuffer toByteBuffer(ByteBuf byteBuf0, int v, int v1) {
        return byteBuf0.nioBufferCount() == 1 ? byteBuf0.internalNioBuffer(v, v1) : byteBuf0.nioBuffer(v, v1);
    }

    private int unwrap(ChannelHandlerContext channelHandlerContext0, ByteBuf byteBuf0, int v) {
        int v5;
        ByteBuf byteBuf1 = this.allocate(channelHandlerContext0, v);
        int v1 = v;
        int v2 = 0;
        boolean z = false;
        boolean z1 = false;
        try {
            do {
                SSLEngineResult sSLEngineResult0 = this.engineType.unwrap(this, byteBuf0, v1, byteBuf1);
                SSLEngineResult.Status sSLEngineResult$Status0 = sSLEngineResult0.getStatus();
                SSLEngineResult.HandshakeStatus sSLEngineResult$HandshakeStatus0 = sSLEngineResult0.getHandshakeStatus();
                int v3 = sSLEngineResult0.bytesProduced();
                int v4 = sSLEngineResult0.bytesConsumed();
                byteBuf0.skipBytes(v4);
                v1 -= v4;
                SSLEngineResult.HandshakeStatus sSLEngineResult$HandshakeStatus1 = SSLEngineResult.HandshakeStatus.FINISHED;
                if(sSLEngineResult$HandshakeStatus0 == sSLEngineResult$HandshakeStatus1 || sSLEngineResult$HandshakeStatus0 == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
                    if(byteBuf1.isReadable()) {
                        if(this.setHandshakeSuccessUnwrapMarkReentry()) {
                            goto label_21;
                        }
                        else {
                            goto label_18;
                        }
                        goto label_17;
                    }
                    else {
                    label_17:
                        if(!this.setHandshakeSuccess()) {
                        label_18:
                            if(sSLEngineResult$HandshakeStatus0 != sSLEngineResult$HandshakeStatus1) {
                                v5 = 0;
                                goto label_22;
                            }
                        }
                    }
                label_21:
                    v5 = 1;
                label_22:
                    v2 |= v5;
                }
                if(byteBuf1.isReadable()) {
                    this.setState(0x100);
                    if(this.isStateSet(0x200)) {
                        z1 = true;
                        this.executeChannelRead(channelHandlerContext0, byteBuf1);
                    }
                    else {
                        channelHandlerContext0.fireChannelRead(byteBuf1);
                    }
                    byteBuf1 = null;
                }
                if(sSLEngineResult$Status0 == SSLEngineResult.Status.CLOSED) {
                    z = true;
                }
                else if(sSLEngineResult$Status0 == SSLEngineResult.Status.BUFFER_OVERFLOW) {
                    if(byteBuf1 != null) {
                        byteBuf1.release();
                    }
                    int v6 = this.engine.getSession().getApplicationBufferSize();
                    SslEngineType sslHandler$SslEngineType0 = this.engineType;
                    if(v6 >= v3) {
                        v6 -= v3;
                    }
                    byteBuf1 = this.allocate(channelHandlerContext0, sslHandler$SslEngineType0.calculatePendingData(this, v6));
                    continue;
                }
                SSLEngineResult.HandshakeStatus sSLEngineResult$HandshakeStatus2 = SSLEngineResult.HandshakeStatus.NEED_TASK;
                if(sSLEngineResult$HandshakeStatus0 != sSLEngineResult$HandshakeStatus2) {
                    if(sSLEngineResult$HandshakeStatus0 != SSLEngineResult.HandshakeStatus.NEED_WRAP || !this.wrapNonAppData(channelHandlerContext0, true) || v1 != 0) {
                        goto label_49;
                    }
                    break;
                }
                else if(!this.runDelegatedTasks(true)) {
                    v2 = 0;
                    break;
                }
            label_49:
                if(sSLEngineResult$Status0 == SSLEngineResult.Status.BUFFER_UNDERFLOW || sSLEngineResult$HandshakeStatus0 != sSLEngineResult$HandshakeStatus2 && (v4 == 0 && v3 == 0 || v1 == 0 && sSLEngineResult$HandshakeStatus0 == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING)) {
                    goto label_54;
                }
                if(byteBuf1 == null) {
                    byteBuf1 = this.allocate(channelHandlerContext0, v1);
                }
            }
            while(!channelHandlerContext0.isRemoved());
            goto label_56;
        label_54:
            if(sSLEngineResult$HandshakeStatus0 == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                this.readIfNeeded(channelHandlerContext0);
            }
        label_56:
            if(this.isStateSet(2) && this.handshakePromise.isDone()) {
                this.clearState(2);
                v2 = 1;
            }
            if(v2 != 0) {
                this.wrap(channelHandlerContext0, true);
                goto label_71;
            label_63:
                if(byteBuf1 != null) {
                    goto label_64;
                }
                goto label_65;
            }
            goto label_71;
        }
        catch(Throwable throwable0) {
            goto label_63;
        }
    label_64:
        byteBuf1.release();
    label_65:
        if(z) {
            if(z1) {
                this.executeNotifyClosePromise(channelHandlerContext0);
            }
            else {
                this.notifyClosePromise(null);
            }
        }
        throw throwable0;
    label_71:
        if(byteBuf1 != null) {
            byteBuf1.release();
        }
        if(z) {
            if(z1) {
                this.executeNotifyClosePromise(channelHandlerContext0);
                return v - v1;
            }
            this.notifyClosePromise(null);
        }
        return v - v1;
    }

    private int unwrapNonAppData(ChannelHandlerContext channelHandlerContext0) {
        return this.unwrap(channelHandlerContext0, Unpooled.EMPTY_BUFFER, 0);
    }

    private SSLEngineResult wrap(ByteBufAllocator byteBufAllocator0, SSLEngine sSLEngine0, ByteBuf byteBuf0, ByteBuf byteBuf1) {
        SSLEngineResult sSLEngineResult0;
        ByteBuf byteBuf2;
        ByteBuffer[] arr_byteBuffer;
        int v1;
        int v;
        try {
            v = byteBuf0.readerIndex();
            v1 = byteBuf0.readableBytes();
            if(byteBuf0.isDirect() || !this.engineType.wantsDirectBuffer) {
                if(byteBuf0 instanceof CompositeByteBuf || byteBuf0.nioBufferCount() != 1) {
                    arr_byteBuffer = byteBuf0.nioBuffers();
                }
                else {
                    this.singleBuffer[0] = byteBuf0.internalNioBuffer(v, v1);
                    arr_byteBuffer = this.singleBuffer;
                }
                byteBuf2 = null;
            }
            else {
                byteBuf2 = byteBufAllocator0.directBuffer(v1);
                goto label_15;
            }
            goto label_18;
        }
        catch(Throwable throwable0) {
            byteBuf2 = null;
            goto label_25;
        }
        try {
        label_15:
            byteBuf2.writeBytes(byteBuf0, v, v1);
            arr_byteBuffer = this.singleBuffer;
            arr_byteBuffer[0] = byteBuf2.internalNioBuffer(byteBuf2.readerIndex(), v1);
            while(true) {
            label_18:
                sSLEngineResult0 = sSLEngine0.wrap(arr_byteBuffer, SslHandler.toByteBuffer(byteBuf1, byteBuf1.writerIndex(), byteBuf1.writableBytes()));
                byteBuf0.skipBytes(sSLEngineResult0.bytesConsumed());
                byteBuf1.writerIndex(byteBuf1.writerIndex() + sSLEngineResult0.bytesProduced());
                if(sSLEngineResult0.getStatus() != SSLEngineResult.Status.BUFFER_OVERFLOW) {
                    goto label_29;
                }
                byteBuf1.ensureWritable(sSLEngine0.getSession().getPacketBufferSize());
            }
        }
        catch(Throwable throwable0) {
        }
    label_25:
        this.singleBuffer[0] = null;
        if(byteBuf2 != null) {
            byteBuf2.release();
        }
        throw throwable0;
    label_29:
        this.singleBuffer[0] = null;
        if(byteBuf2 != null) {
            byteBuf2.release();
        }
        return sSLEngineResult0;
    }

    private void wrap(ChannelHandlerContext channelHandlerContext0, boolean z) {
        SSLEngineResult sSLEngineResult0;
        ChannelPromise channelPromise0;
        ReferenceCounted referenceCounted1;
        int v;
        ByteBufAllocator byteBufAllocator0 = channelHandlerContext0.alloc();
        ReferenceCounted referenceCounted0 = null;
        try {
            v = this.wrapDataSize;
            referenceCounted1 = null;
        }
        catch(Throwable throwable0) {
            goto label_61;
        }
        try {
            while(true) {
            label_4:
                if(channelHandlerContext0.isRemoved()) {
                    goto label_71;
                }
                channelPromise0 = channelHandlerContext0.newPromise();
                ByteBuf byteBuf0 = v <= 0 ? this.pendingUnencryptedWrites.removeFirst(channelPromise0) : this.pendingUnencryptedWrites.remove(byteBufAllocator0, v, channelPromise0);
                if(byteBuf0 == null) {
                    goto label_71;
                }
                if(byteBuf0.readableBytes() > 0x4000) {
                    int v1 = byteBuf0.readableBytes();
                    int v2 = v1 % 0x4000 == 0 ? v1 / 0x4000 : v1 / 0x4000 + 1;
                    if(referenceCounted1 == null) {
                        referenceCounted1 = this.allocateOutNetBuf(channelHandlerContext0, v1, byteBuf0.nioBufferCount() + v2);
                    }
                    sSLEngineResult0 = this.wrapMultiple(byteBufAllocator0, this.engine, byteBuf0, ((ByteBuf)referenceCounted1));
                }
                else {
                    if(referenceCounted1 == null) {
                        referenceCounted1 = this.allocateOutNetBuf(channelHandlerContext0, byteBuf0.readableBytes(), byteBuf0.nioBufferCount());
                    }
                    sSLEngineResult0 = this.wrap(byteBufAllocator0, this.engine, byteBuf0, ((ByteBuf)referenceCounted1));
                }
                if(byteBuf0.isReadable()) {
                    this.pendingUnencryptedWrites.addFirst(byteBuf0, channelPromise0);
                    channelPromise0 = null;
                }
                else {
                    byteBuf0.release();
                }
                if(((ByteBuf)referenceCounted1).isReadable()) {
                    break;
                }
                else if(channelPromise0 != null) {
                    channelHandlerContext0.write(Unpooled.EMPTY_BUFFER, channelPromise0);
                }
                goto label_35;
            }
        }
        catch(Throwable throwable0) {
            goto label_60;
        }
        try {
            if(channelPromise0 == null) {
                channelHandlerContext0.write(referenceCounted1);
            }
            else {
                channelHandlerContext0.write(referenceCounted1, channelPromise0);
            }
        }
        catch(Throwable throwable0) {
            goto label_61;
        }
        referenceCounted1 = null;
        try {
        label_35:
            if(sSLEngineResult0.getStatus() == SSLEngineResult.Status.CLOSED) {
                goto label_51;
            }
            switch(io.netty.handler.ssl.SslHandler.11.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[sSLEngineResult0.getHandshakeStatus().ordinal()]) {
                case 1: {
                    goto label_49;
                }
                case 2: 
                case 3: {
                    goto label_47;
                }
                case 4: {
                    goto label_44;
                }
                case 5: {
                    this.readIfNeeded(channelHandlerContext0);
                    if(referenceCounted1 != null) {
                        break;
                    }
                    goto label_41;
                }
                default: {
                    throw new IllegalStateException("Unknown handshake status: " + sSLEngineResult0.getHandshakeStatus());
                }
            }
        }
        catch(Throwable throwable0) {
            goto label_60;
        }
        referenceCounted1.release();
    label_41:
        if(z) {
            this.setState(16);
            return;
            try {
            label_44:
                if(sSLEngineResult0.bytesProduced() <= 0 || !this.pendingUnencryptedWrites.isEmpty()) {
                    goto label_4;
                }
                this.pendingUnencryptedWrites.add(Unpooled.EMPTY_BUFFER);
                goto label_4;
            label_47:
                this.setHandshakeSuccess();
                goto label_4;
            label_49:
                if(this.runDelegatedTasks(z)) {
                    goto label_4;
                }
                goto label_71;
            label_51:
                if(!this.pendingUnencryptedWrites.isEmpty()) {
                    Throwable throwable1 = this.handshakePromise.cause();
                    if(throwable1 == null) {
                        throwable1 = this.sslClosePromise.cause();
                        if(throwable1 == null) {
                            throwable1 = new SslClosedEngineException("SSLEngine closed already");
                        }
                    }
                    this.pendingUnencryptedWrites.releaseAndFailAll(channelHandlerContext0, throwable1);
                }
                goto label_66;
            }
            catch(Throwable throwable0) {
            label_60:
                referenceCounted0 = referenceCounted1;
            }
        label_61:
            if(referenceCounted0 != null) {
                referenceCounted0.release();
            }
            if(z) {
                this.setState(16);
            }
            throw throwable0;
        label_66:
            if(referenceCounted1 != null) {
                referenceCounted1.release();
            }
            if(z) {
                this.setState(16);
                return;
            label_71:
                if(referenceCounted1 != null) {
                    referenceCounted1.release();
                }
                if(z) {
                    this.setState(16);
                }
            }
        }
    }

    private void wrapAndFlush(ChannelHandlerContext channelHandlerContext0) {
        if(this.pendingUnencryptedWrites.isEmpty()) {
            SslHandlerCoalescingBufferQueue sslHandler$SslHandlerCoalescingBufferQueue0 = this.pendingUnencryptedWrites;
            ChannelPromise channelPromise0 = channelHandlerContext0.newPromise();
            sslHandler$SslHandlerCoalescingBufferQueue0.add(Unpooled.EMPTY_BUFFER, channelPromise0);
        }
        if(!this.handshakePromise.isDone()) {
            this.setState(2);
        }
        try {
            this.wrap(channelHandlerContext0, false);
        }
        finally {
            this.forceFlush(channelHandlerContext0);
        }
    }

    private SSLEngineResult wrapMultiple(ByteBufAllocator byteBufAllocator0, SSLEngine sSLEngine0, ByteBuf byteBuf0, ByteBuf byteBuf1) {
        SSLEngineResult sSLEngineResult1;
        for(SSLEngineResult sSLEngineResult0 = null; true; sSLEngineResult0 = sSLEngineResult1) {
            int v = Math.min(0x4000, byteBuf0.readableBytes());
            int v1 = byteBuf0.nioBufferCount();
            int v2 = this.engineType.calculateRequiredOutBufSpace(this, v, v1);
            if(!byteBuf1.isWritable(v2)) {
                if(sSLEngineResult0 != null) {
                    return sSLEngineResult0;
                }
                byteBuf1.ensureWritable(v2);
            }
            ByteBuf byteBuf2 = byteBuf0.readSlice(v);
            sSLEngineResult1 = this.wrap(byteBufAllocator0, sSLEngine0, byteBuf2, byteBuf1);
            if(sSLEngineResult1.getStatus() == SSLEngineResult.Status.CLOSED) {
                break;
            }
            if(byteBuf2.isReadable()) {
                byteBuf0.readerIndex(byteBuf0.readerIndex() - byteBuf2.readableBytes());
            }
            if(byteBuf0.readableBytes() <= 0) {
                break;
            }
        }
        return sSLEngineResult1;
    }

    private boolean wrapNonAppData(ChannelHandlerContext channelHandlerContext0, boolean z) {
        ByteBufAllocator byteBufAllocator0 = channelHandlerContext0.alloc();
        ByteBuf byteBuf0 = null;
        while(true) {
            try {
                if(channelHandlerContext0.isRemoved()) {
                    break;
                }
                if(byteBuf0 == null) {
                    byteBuf0 = this.allocateOutNetBuf(channelHandlerContext0, 0x800, 1);
                }
                SSLEngineResult sSLEngineResult0 = this.wrap(byteBufAllocator0, this.engine, Unpooled.EMPTY_BUFFER, byteBuf0);
                if(sSLEngineResult0.bytesProduced() > 0) {
                    channelHandlerContext0.write(byteBuf0).addListener(new ChannelFutureListener() {
                        public void operationComplete(ChannelFuture channelFuture0) {
                            Throwable throwable0 = channelFuture0.cause();
                            if(throwable0 != null) {
                                SslHandler.this.setHandshakeFailureTransportFailure(channelHandlerContext0, throwable0);
                            }
                        }

                        @Override  // io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(Future future0) {
                            this.operationComplete(((ChannelFuture)future0));
                        }
                    });
                    if(z) {
                        this.setState(16);
                    }
                    byteBuf0 = null;
                }
                SSLEngineResult.HandshakeStatus sSLEngineResult$HandshakeStatus0 = sSLEngineResult0.getHandshakeStatus();
                switch(io.netty.handler.ssl.SslHandler.11.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[sSLEngineResult$HandshakeStatus0.ordinal()]) {
                    case 1: {
                        goto label_30;
                    }
                    case 2: {
                        goto label_21;
                    }
                    case 3: {
                        if(this.setHandshakeSuccess() && z && !this.pendingUnencryptedWrites.isEmpty()) {
                            this.wrap(channelHandlerContext0, true);
                        }
                        if(!z) {
                            this.unwrapNonAppData(channelHandlerContext0);
                        }
                        break;
                    }
                    case 4: {
                        goto label_31;
                    }
                    case 5: {
                        goto label_26;
                    }
                    default: {
                        throw new IllegalStateException("Unknown handshake status: " + sSLEngineResult0.getHandshakeStatus());
                    }
                }
            }
            catch(Throwable throwable0) {
                goto label_34;
            }
            if(byteBuf0 != null) {
                byteBuf0.release();
            }
            return true;
            try {
            label_21:
                if(this.setHandshakeSuccess() && z && !this.pendingUnencryptedWrites.isEmpty()) {
                    this.wrap(channelHandlerContext0, true);
                }
            }
            catch(Throwable throwable0) {
                goto label_34;
            }
            if(byteBuf0 != null) {
                byteBuf0.release();
            }
            return false;
            try {
            label_26:
                if(z || this.unwrapNonAppData(channelHandlerContext0) <= 0) {
                    goto label_27;
                }
                goto label_31;
            }
            catch(Throwable throwable0) {
                goto label_34;
            }
        label_27:
            if(byteBuf0 != null) {
                byteBuf0.release();
            }
            return false;
            try {
            label_30:
                if(!this.runDelegatedTasks(z)) {
                    break;
                }
            label_31:
                if(sSLEngineResult0.bytesProduced() == 0 && sSLEngineResult$HandshakeStatus0 != SSLEngineResult.HandshakeStatus.NEED_TASK || sSLEngineResult0.bytesConsumed() == 0 && sSLEngineResult0.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
                    break;
                label_34:
                    if(byteBuf0 == null) {
                        throw throwable0;
                    }
                    goto label_35;
                }
                continue;
            }
            catch(Throwable throwable0) {
                goto label_34;
            }
        label_35:
            byteBuf0.release();
            throw throwable0;
        }
        if(byteBuf0 != null) {
            byteBuf0.release();
        }
        return false;
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext0, Object object0, ChannelPromise channelPromise0) {
        if(!(object0 instanceof ByteBuf)) {
            UnsupportedMessageTypeException unsupportedMessageTypeException0 = new UnsupportedMessageTypeException(object0, new Class[]{ByteBuf.class});
            ReferenceCountUtil.safeRelease(object0);
            channelPromise0.setFailure(((Throwable)unsupportedMessageTypeException0));
            return;
        }
        SslHandlerCoalescingBufferQueue sslHandler$SslHandlerCoalescingBufferQueue0 = this.pendingUnencryptedWrites;
        if(sslHandler$SslHandlerCoalescingBufferQueue0 == null) {
            ReferenceCountUtil.safeRelease(object0);
            channelPromise0.setFailure(SslHandler.newPendingWritesNullException());
            return;
        }
        sslHandler$SslHandlerCoalescingBufferQueue0.add(((ByteBuf)object0), channelPromise0);
    }

    class io.netty.handler.ssl.SslHandler.11 {
        static final int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus;

        static {
            int[] arr_v = new int[SSLEngineResult.HandshakeStatus.values().length];
            io.netty.handler.ssl.SslHandler.11.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = arr_v;
            try {
                arr_v[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.handler.ssl.SslHandler.11.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.handler.ssl.SslHandler.11.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.handler.ssl.SslHandler.11.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.handler.ssl.SslHandler.11.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

