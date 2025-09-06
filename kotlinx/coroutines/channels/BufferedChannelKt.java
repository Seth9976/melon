package kotlinx.coroutines.channels;

import De.g;
import kotlin.Metadata;
import kotlin.jvm.internal.n;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;
import we.o;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u001A3\u0010\u0004\u001A \u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0001\"\u0004\b\u0000\u0010\u0000H\u0000\u00A2\u0006\u0004\b\u0004\u0010\u0005\u001A1\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0006\u001A\u00020\u00022\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002\u00A2\u0006\u0004\b\b\u0010\t\u001AK\u0010\u0013\u001A\u00020\u0012\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\u000B2\u0006\u0010\f\u001A\u00028\u00002\"\b\u0002\u0010\u0011\u001A\u001C\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rH\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014\u001A\u0017\u0010\u0017\u001A\u00020\u00022\u0006\u0010\u0016\u001A\u00020\u0015H\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0018\u001A\u001F\u0010\u001B\u001A\u00020\u00022\u0006\u0010\u0019\u001A\u00020\u00022\u0006\u0010\u001A\u001A\u00020\u0015H\u0002\u00A2\u0006\u0004\b\u001B\u0010\u001C\u001A\u001F\u0010\u001E\u001A\u00020\u00022\u0006\u0010\u0019\u001A\u00020\u00022\u0006\u0010\u001D\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b\u001E\u0010\u001F\"\u001C\u0010!\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u00038\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b!\u0010\"\"\u0014\u0010#\u001A\u00020\u00158\u0000X\u0081\u0004\u00A2\u0006\u0006\n\u0004\b#\u0010$\"\u0014\u0010%\u001A\u00020\u00158\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b%\u0010$\"\u0014\u0010\'\u001A\u00020&8\u0000X\u0081\u0004\u00A2\u0006\u0006\n\u0004\b\'\u0010(\"\u0014\u0010)\u001A\u00020&8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b)\u0010(\"\u0014\u0010*\u001A\u00020&8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b*\u0010(\"\u0014\u0010+\u001A\u00020&8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b+\u0010(\"\u0014\u0010,\u001A\u00020&8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b,\u0010(\"\u0014\u0010-\u001A\u00020&8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b-\u0010(\"\u0014\u0010.\u001A\u00020&8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b.\u0010(\"\u0014\u0010/\u001A\u00020&8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b/\u0010(\"\u001A\u00100\u001A\u00020&8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b0\u0010(\u001A\u0004\b1\u00102\"\u0014\u00103\u001A\u00020&8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b3\u0010(\"\u0014\u00104\u001A\u00020&8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b4\u0010(\"\u0014\u00105\u001A\u00020&8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b5\u0010(\"\u0014\u00106\u001A\u00020&8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b6\u0010(\"\u0014\u00107\u001A\u00020&8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b7\u0010(\"\u0014\u00108\u001A\u00020&8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b8\u0010(\"\u0014\u00109\u001A\u00020&8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b9\u0010(\u00A8\u0006:"}, d2 = {"E", "Lkotlin/reflect/KFunction2;", "", "Lkotlinx/coroutines/channels/ChannelSegment;", "createSegmentFunction", "()LDe/g;", "id", "prev", "createSegment", "(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", "T", "Lkotlinx/coroutines/CancellableContinuation;", "value", "Lkotlin/Function3;", "", "Lme/i;", "Lie/H;", "onCancellation", "", "tryResume0", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;Lwe/o;)Z", "", "capacity", "initialBufferEnd", "(I)J", "counter", "closeStatus", "constructSendersAndCloseStatus", "(JI)J", "pauseEB", "constructEBCompletedAndPauseFlag", "(JZ)J", "", "NULL_SEGMENT", "Lkotlinx/coroutines/channels/ChannelSegment;", "SEGMENT_SIZE", "I", "EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS", "Lkotlinx/coroutines/internal/Symbol;", "BUFFERED", "Lkotlinx/coroutines/internal/Symbol;", "IN_BUFFER", "RESUMING_BY_RCV", "RESUMING_BY_EB", "POISONED", "DONE_RCV", "INTERRUPTED_SEND", "INTERRUPTED_RCV", "CHANNEL_CLOSED", "getCHANNEL_CLOSED", "()Lkotlinx/coroutines/internal/Symbol;", "SUSPEND", "SUSPEND_NO_WAITER", "FAILED", "NO_RECEIVE_RESULT", "CLOSE_HANDLER_CLOSED", "CLOSE_HANDLER_INVOKED", "NO_CLOSE_CAUSE", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class BufferedChannelKt {
    @NotNull
    public static final Symbol BUFFERED;
    @NotNull
    private static final Symbol CHANNEL_CLOSED;
    @NotNull
    private static final Symbol CLOSE_HANDLER_CLOSED;
    @NotNull
    private static final Symbol CLOSE_HANDLER_INVOKED;
    @NotNull
    private static final Symbol DONE_RCV;
    private static final int EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
    @NotNull
    private static final Symbol FAILED;
    @NotNull
    private static final Symbol INTERRUPTED_RCV;
    @NotNull
    private static final Symbol INTERRUPTED_SEND;
    @NotNull
    private static final Symbol IN_BUFFER;
    @NotNull
    private static final Symbol NO_CLOSE_CAUSE;
    @NotNull
    private static final Symbol NO_RECEIVE_RESULT;
    @NotNull
    private static final ChannelSegment NULL_SEGMENT;
    @NotNull
    private static final Symbol POISONED;
    @NotNull
    private static final Symbol RESUMING_BY_EB;
    @NotNull
    private static final Symbol RESUMING_BY_RCV;
    public static final int SEGMENT_SIZE;
    @NotNull
    private static final Symbol SUSPEND;
    @NotNull
    private static final Symbol SUSPEND_NO_WAITER;

    static {
        BufferedChannelKt.NULL_SEGMENT = new ChannelSegment(-1L, null, null, 0);
        BufferedChannelKt.SEGMENT_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.bufferedChannel.segmentSize", 0x20, 0, 0, 12, null);
        BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS = SystemPropsKt.systemProp$default("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);
        BufferedChannelKt.BUFFERED = new Symbol("BUFFERED");
        BufferedChannelKt.IN_BUFFER = new Symbol("SHOULD_BUFFER");
        BufferedChannelKt.RESUMING_BY_RCV = new Symbol("S_RESUMING_BY_RCV");
        BufferedChannelKt.RESUMING_BY_EB = new Symbol("RESUMING_BY_EB");
        BufferedChannelKt.POISONED = new Symbol("POISONED");
        BufferedChannelKt.DONE_RCV = new Symbol("DONE_RCV");
        BufferedChannelKt.INTERRUPTED_SEND = new Symbol("INTERRUPTED_SEND");
        BufferedChannelKt.INTERRUPTED_RCV = new Symbol("INTERRUPTED_RCV");
        BufferedChannelKt.CHANNEL_CLOSED = new Symbol("CHANNEL_CLOSED");
        BufferedChannelKt.SUSPEND = new Symbol("SUSPEND");
        BufferedChannelKt.SUSPEND_NO_WAITER = new Symbol("SUSPEND_NO_WAITER");
        BufferedChannelKt.FAILED = new Symbol("FAILED");
        BufferedChannelKt.NO_RECEIVE_RESULT = new Symbol("NO_RECEIVE_RESULT");
        BufferedChannelKt.CLOSE_HANDLER_CLOSED = new Symbol("CLOSE_HANDLER_CLOSED");
        BufferedChannelKt.CLOSE_HANDLER_INVOKED = new Symbol("CLOSE_HANDLER_INVOKED");
        BufferedChannelKt.NO_CLOSE_CAUSE = new Symbol("NO_CLOSE_CAUSE");
    }

    public static final long access$constructSendersAndCloseStatus(long v, int v1) {
        return (((long)v1) << 60) + v;
    }

    public static final int access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p() [...] // 潜在的解密器

    public static final long access$initialBufferEnd(int v) {
        return BufferedChannelKt.initialBufferEnd(v);
    }

    // 去混淆评级： 低(20)
    private static final long constructEBCompletedAndPauseFlag(long v, boolean z) {
        return z ? v + 0x4000000000000000L : v;
    }

    private static final long constructSendersAndCloseStatus(long v, int v1) [...] // Inlined contents

    private static final ChannelSegment createSegment(long v, ChannelSegment channelSegment0) {
        return new ChannelSegment(v, channelSegment0, channelSegment0.getChannel(), 0);
    }

    @NotNull
    public static final g createSegmentFunction() {
        return kotlinx.coroutines.channels.BufferedChannelKt.createSegmentFunction.1.INSTANCE;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
        final class kotlinx.coroutines.channels.BufferedChannelKt.createSegmentFunction.1 extends n implements we.n {
            public static final kotlinx.coroutines.channels.BufferedChannelKt.createSegmentFunction.1 INSTANCE;

            static {
                kotlinx.coroutines.channels.BufferedChannelKt.createSegmentFunction.1.INSTANCE = new kotlinx.coroutines.channels.BufferedChannelKt.createSegmentFunction.1();
            }

            public kotlinx.coroutines.channels.BufferedChannelKt.createSegmentFunction.1() {
                super(2, BufferedChannelKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((Number)object0).longValue(), ((ChannelSegment)object1));
            }

            public final ChannelSegment invoke(long v, ChannelSegment channelSegment0) {
                return BufferedChannelKt.createSegment(v, channelSegment0);
            }
        }

    }

    @NotNull
    public static final Symbol getCHANNEL_CLOSED() {
        return BufferedChannelKt.CHANNEL_CLOSED;
    }

    private static final long initialBufferEnd(int v) {
        switch(v) {
            case 0: {
                return 0L;
            }
            case 0x7FFFFFFF: {
                return 0x7FFFFFFFFFFFFFFFL;
            }
            default: {
                return (long)v;
            }
        }
    }

    private static final boolean tryResume0(CancellableContinuation cancellableContinuation0, Object object0, o o0) {
        Object object1 = cancellableContinuation0.tryResume(object0, null, o0);
        if(object1 != null) {
            cancellableContinuation0.completeResume(object1);
            return true;
        }
        return false;
    }

    public static boolean tryResume0$default(CancellableContinuation cancellableContinuation0, Object object0, o o0, int v, Object object1) {
        if((v & 2) != 0) {
            o0 = null;
        }
        return BufferedChannelKt.tryResume0(cancellableContinuation0, object0, o0);
    }
}

