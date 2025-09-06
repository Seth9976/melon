package kotlinx.coroutines.flow;

import d5.n;
import e1.u;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;
import me.i;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b1\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006:\u0001pB\u001F\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\t\u001A\u00020\u0007\u0012\u0006\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\f\u0010\rJ\u001E\u0010\u0011\u001A\u00020\u00102\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EH\u0096@\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0013\u001A\u00028\u0000H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0013\u001A\u00028\u0000H\u0096@\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001D\u001A\u00020\u001AH\u0000\u00A2\u0006\u0004\b\u001B\u0010\u001CJ%\u0010#\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010 0\u001F2\u0006\u0010\u001E\u001A\u00020\u001AH\u0000\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010$\u001A\u00020\u0003H\u0014\u00A2\u0006\u0004\b$\u0010%J\u001F\u0010\'\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001F2\u0006\u0010&\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\'\u0010(J\u000F\u0010)\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b)\u0010*J-\u0010/\u001A\b\u0012\u0004\u0012\u00028\u00000.2\u0006\u0010,\u001A\u00020+2\u0006\u0010-\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b/\u00100J\u0017\u00101\u001A\u00020\u00142\u0006\u0010\u0013\u001A\u00028\u0000H\u0002\u00A2\u0006\u0004\b1\u0010\u0016J\u0017\u00102\u001A\u00020\u00142\u0006\u0010\u0013\u001A\u00028\u0000H\u0002\u00A2\u0006\u0004\b2\u0010\u0016J\u000F\u00103\u001A\u00020\u0017H\u0002\u00A2\u0006\u0004\b3\u0010*J\u0017\u00105\u001A\u00020\u00172\u0006\u00104\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b5\u00106J\u0019\u00108\u001A\u00020\u00172\b\u00107\u001A\u0004\u0018\u00010\u0005H\u0002\u00A2\u0006\u0004\b8\u00109J9\u0010=\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001F2\u0010\u0010:\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001F2\u0006\u0010;\u001A\u00020\u00072\u0006\u0010<\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b=\u0010>J\u0018\u0010?\u001A\u00020\u00172\u0006\u0010\u0013\u001A\u00028\u0000H\u0082@\u00A2\u0006\u0004\b?\u0010\u0019J\u0017\u0010B\u001A\u00020\u00172\u0006\u0010A\u001A\u00020@H\u0002\u00A2\u0006\u0004\bB\u0010CJ/\u0010H\u001A\u00020\u00172\u0006\u0010D\u001A\u00020\u001A2\u0006\u0010E\u001A\u00020\u001A2\u0006\u0010F\u001A\u00020\u001A2\u0006\u0010G\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\bH\u0010IJ\u000F\u0010J\u001A\u00020\u0017H\u0002\u00A2\u0006\u0004\bJ\u0010*J\u0019\u0010L\u001A\u0004\u0018\u00010\u00052\u0006\u0010K\u001A\u00020\u0003H\u0002\u00A2\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001A\u00020\u001A2\u0006\u0010K\u001A\u00020\u0003H\u0002\u00A2\u0006\u0004\bN\u0010OJ\u0019\u0010Q\u001A\u0004\u0018\u00010\u00052\u0006\u0010P\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\bQ\u0010RJ\u0018\u0010S\u001A\u00020\u00172\u0006\u0010K\u001A\u00020\u0003H\u0082@\u00A2\u0006\u0004\bS\u0010TJ3\u0010V\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010 0\u001F2\u0014\u0010U\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010 0\u001FH\u0002\u00A2\u0006\u0004\bV\u0010WR\u0014\u0010\b\u001A\u00020\u00078\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\b\u0010XR\u0014\u0010\t\u001A\u00020\u00078\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\t\u0010XR\u0014\u0010\u000B\u001A\u00020\n8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u000B\u0010YR \u0010Z\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001A\u00020\u001A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010^\u001A\u00020\u001A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b^\u0010]R\u0016\u0010_\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b_\u0010XR\u0016\u0010`\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b`\u0010XR\u001A\u0010d\u001A\u00028\u00008DX\u0084\u0004\u00A2\u0006\f\u0012\u0004\bc\u0010*\u001A\u0004\ba\u0010bR\u0014\u0010f\u001A\u00020\u001A8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\be\u0010\u001CR\u0014\u0010i\u001A\u00020\u00078BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bg\u0010hR\u0014\u0010k\u001A\u00020\u00078BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bj\u0010hR\u0014\u0010m\u001A\u00020\u001A8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bl\u0010\u001CR\u0014\u0010o\u001A\u00020\u001A8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bn\u0010\u001C\u00A8\u0006q"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "", "replay", "bufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", "tryEmit", "(Ljava/lang/Object;)Z", "Lie/H;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "()J", "updateNewCollectorIndexLocked", "oldIndex", "", "Lkotlin/coroutines/Continuation;", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateCollectorIndexLocked", "createSlot", "()Lkotlinx/coroutines/flow/SharedFlowSlot;", "size", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "resetReplayCache", "()V", "Lme/i;", "context", "capacity", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "tryEmitLocked", "tryEmitNoCollectorsLocked", "dropOldestLocked", "newHead", "correctCollectorIndexesOnDropOldest", "(J)V", "item", "enqueueLocked", "(Ljava/lang/Object;)V", "curBuffer", "curSize", "newSize", "growBuffer", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "emitSuspend", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "emitter", "cancelEmitter", "(Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;)V", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "updateBufferLocked", "(JJJJ)V", "cleanupTailLocked", "slot", "tryTakeValue", "(Lkotlinx/coroutines/flow/SharedFlowSlot;)Ljava/lang/Object;", "tryPeekLocked", "(Lkotlinx/coroutines/flow/SharedFlowSlot;)J", "index", "getPeekedValueLockedAt", "(J)Ljava/lang/Object;", "awaitValue", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resumesIn", "findSlotsToResumeLocked", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "I", "Lkotlinx/coroutines/channels/BufferOverflow;", "buffer", "[Ljava/lang/Object;", "replayIndex", "J", "minCollectorIndex", "bufferSize", "queueSize", "getLastReplayedLocked", "()Ljava/lang/Object;", "getLastReplayedLocked$annotations", "lastReplayedLocked", "getHead", "head", "getReplaySize", "()I", "replaySize", "getTotalSize", "totalSize", "getBufferEndIndex", "bufferEndIndex", "getQueueEndIndex", "queueEndIndex", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class SharedFlowImpl extends AbstractSharedFlow implements Flow, MutableSharedFlow, FusibleFlow {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u0018\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000FR\u0016\u0010\u0005\u001A\u00020\u00048\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0016\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u001A\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "flow", "", "index", "", "value", "Lkotlin/coroutines/Continuation;", "Lie/H;", "cont", "<init>", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "()V", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "J", "Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    static final class Emitter implements DisposableHandle {
        @NotNull
        public final Continuation cont;
        @NotNull
        public final SharedFlowImpl flow;
        public long index;
        @Nullable
        public final Object value;

        public Emitter(@NotNull SharedFlowImpl sharedFlowImpl0, long v, @Nullable Object object0, @NotNull Continuation continuation0) {
            this.flow = sharedFlowImpl0;
            this.index = v;
            this.value = object0;
            this.cont = continuation0;
        }

        @Override  // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            this.flow.cancelEmitter(this);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
    public abstract class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[BufferOverflow.values().length];
            try {
                arr_v[BufferOverflow.SUSPEND.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @Nullable
    private Object[] buffer;
    private final int bufferCapacity;
    private int bufferSize;
    private long minCollectorIndex;
    @NotNull
    private final BufferOverflow onBufferOverflow;
    private int queueSize;
    private final int replay;
    private long replayIndex;

    public SharedFlowImpl(int v, int v1, @NotNull BufferOverflow bufferOverflow0) {
        this.replay = v;
        this.bufferCapacity = v1;
        this.onBufferOverflow = bufferOverflow0;
    }

    private final Object awaitValue(SharedFlowSlot sharedFlowSlot0, Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        synchronized(this) {
            if(this.tryPeekLocked(sharedFlowSlot0) < 0L) {
                sharedFlowSlot0.cont = cancellableContinuationImpl0;
            }
            else {
                cancellableContinuationImpl0.resumeWith(H.a);
            }
        }
        Object object0 = cancellableContinuationImpl0.getResult();
        return object0 == a.a ? object0 : H.a;
    }

    // 检测为 Lambda 实现
    private final void cancelEmitter(Emitter sharedFlowImpl$Emitter0) [...]

    private final void cleanupTailLocked() {
        if(this.bufferCapacity != 0 || this.queueSize > 1) {
            Object[] arr_object = this.buffer;
            q.d(arr_object);
            while(this.queueSize > 0 && SharedFlowKt.access$getBufferAt(arr_object, this.getHead() + ((long)this.getTotalSize()) - 1L) == SharedFlowKt.NO_VALUE) {
                --this.queueSize;
                SharedFlowKt.access$setBufferAt(arr_object, this.getHead() + ((long)this.getTotalSize()), null);
            }
        }
    }

    @Override  // kotlinx.coroutines.flow.Flow, kotlinx.coroutines.flow.SharedFlow
    @Nullable
    public Object collect(@NotNull FlowCollector flowCollector0, @NotNull Continuation continuation0) {
        return SharedFlowImpl.collect$suspendImpl(this, flowCollector0, continuation0);
    }

    public static Object collect$suspendImpl(SharedFlowImpl sharedFlowImpl0, FlowCollector flowCollector0, Continuation continuation0) {
        FlowCollector flowCollector3;
        Job job0;
        SharedFlowImpl sharedFlowImpl2;
        FlowCollector flowCollector2;
        SharedFlowSlot sharedFlowSlot0;
        Job job1;
        kotlinx.coroutines.flow.SharedFlowImpl.collect.1 sharedFlowImpl$collect$10;
        if(continuation0 instanceof kotlinx.coroutines.flow.SharedFlowImpl.collect.1) {
            sharedFlowImpl$collect$10 = (kotlinx.coroutines.flow.SharedFlowImpl.collect.1)continuation0;
            int v = sharedFlowImpl$collect$10.label;
            if((v & 0x80000000) == 0) {
                sharedFlowImpl$collect$10 = new c(continuation0) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return SharedFlowImpl.collect$suspendImpl(sharedFlowImpl0, null, this);
                    }
                };
            }
            else {
                sharedFlowImpl$collect$10.label = v ^ 0x80000000;
            }
        }
        else {
            sharedFlowImpl$collect$10 = new c(continuation0) {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return SharedFlowImpl.collect$suspendImpl(sharedFlowImpl0, null, this);
                }
            };
        }
        Object object0 = sharedFlowImpl$collect$10.result;
        a a0 = a.a;
        int v1 = sharedFlowImpl$collect$10.label;
        if(v1 == 0) {
            n.D(object0);
            flowCollector2 = flowCollector0;
            sharedFlowSlot0 = (SharedFlowSlot)sharedFlowImpl0.allocateSlot();
            try {
                job1 = (Job)sharedFlowImpl$collect$10.getContext().get(Job.Key);
                goto label_47;
            }
            catch(Throwable throwable1) {
                sharedFlowImpl2 = sharedFlowImpl0;
                throwable0 = throwable1;
            }
            sharedFlowImpl2.freeSlot(sharedFlowSlot0);
            throw throwable0;
        }
        else {
            switch(v1) {
                case 1: {
                    sharedFlowSlot0 = (SharedFlowSlot)sharedFlowImpl$collect$10.L$2;
                    FlowCollector flowCollector1 = (FlowCollector)sharedFlowImpl$collect$10.L$1;
                    SharedFlowImpl sharedFlowImpl1 = (SharedFlowImpl)sharedFlowImpl$collect$10.L$0;
                    try {
                        n.D(object0);
                        flowCollector2 = flowCollector1;
                        sharedFlowImpl0 = sharedFlowImpl1;
                        job1 = (Job)sharedFlowImpl$collect$10.getContext().get(Job.Key);
                        break;
                    }
                    catch(Throwable throwable0) {
                        sharedFlowImpl2 = sharedFlowImpl1;
                        sharedFlowImpl2.freeSlot(sharedFlowSlot0);
                        throw throwable0;
                    }
                }
                case 2: {
                    job0 = (Job)sharedFlowImpl$collect$10.L$3;
                    sharedFlowSlot0 = (SharedFlowSlot)sharedFlowImpl$collect$10.L$2;
                    flowCollector3 = (FlowCollector)sharedFlowImpl$collect$10.L$1;
                    sharedFlowImpl2 = (SharedFlowImpl)sharedFlowImpl$collect$10.L$0;
                    try {
                        n.D(object0);
                        goto label_50;
                    }
                    catch(Throwable throwable0) {
                        sharedFlowImpl2.freeSlot(sharedFlowSlot0);
                        throw throwable0;
                    }
                }
                case 3: {
                    job0 = (Job)sharedFlowImpl$collect$10.L$3;
                    sharedFlowSlot0 = (SharedFlowSlot)sharedFlowImpl$collect$10.L$2;
                    flowCollector3 = (FlowCollector)sharedFlowImpl$collect$10.L$1;
                    sharedFlowImpl2 = (SharedFlowImpl)sharedFlowImpl$collect$10.L$0;
                    try {
                        n.D(object0);
                        goto label_73;
                    }
                    catch(Throwable throwable0) {
                        sharedFlowImpl2.freeSlot(sharedFlowSlot0);
                        throw throwable0;
                    }
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
        }
        while(true) {
        label_47:
            sharedFlowImpl2 = sharedFlowImpl0;
            job0 = job1;
            flowCollector3 = flowCollector2;
            try {
                while(true) {
                label_50:
                    Object object1 = sharedFlowImpl2.tryTakeValue(sharedFlowSlot0);
                    if(object1 != SharedFlowKt.NO_VALUE) {
                        break;
                    }
                    sharedFlowImpl$collect$10.L$0 = sharedFlowImpl2;
                    sharedFlowImpl$collect$10.L$1 = flowCollector3;
                    sharedFlowImpl$collect$10.L$2 = sharedFlowSlot0;
                    sharedFlowImpl$collect$10.L$3 = job0;
                    sharedFlowImpl$collect$10.label = 2;
                    if(sharedFlowImpl2.awaitValue(sharedFlowSlot0, sharedFlowImpl$collect$10) == a0) {
                        return a0;
                    }
                }
                if(job0 != null) {
                    JobKt.ensureActive(job0);
                }
                sharedFlowImpl$collect$10.L$0 = sharedFlowImpl2;
                sharedFlowImpl$collect$10.L$1 = flowCollector3;
                sharedFlowImpl$collect$10.L$2 = sharedFlowSlot0;
                sharedFlowImpl$collect$10.L$3 = job0;
                sharedFlowImpl$collect$10.label = 3;
                if(flowCollector3.emit(object1, sharedFlowImpl$collect$10) == a0) {
                    return a0;
                }
            }
            catch(Throwable throwable0) {
                sharedFlowImpl2.freeSlot(sharedFlowSlot0);
                throw throwable0;
            }
        label_73:
            flowCollector2 = flowCollector3;
            job1 = job0;
            sharedFlowImpl0 = sharedFlowImpl2;
        }
    }

    private final void correctCollectorIndexesOnDropOldest(long v) {
        if(this.nCollectors != 0) {
            AbstractSharedFlowSlot[] arr_abstractSharedFlowSlot = this.slots;
            if(arr_abstractSharedFlowSlot != null) {
                for(int v1 = 0; v1 < arr_abstractSharedFlowSlot.length; ++v1) {
                    AbstractSharedFlowSlot abstractSharedFlowSlot0 = arr_abstractSharedFlowSlot[v1];
                    if(abstractSharedFlowSlot0 != null) {
                        long v2 = ((SharedFlowSlot)abstractSharedFlowSlot0).index;
                        if(v2 >= 0L && v2 < v) {
                            ((SharedFlowSlot)abstractSharedFlowSlot0).index = v;
                        }
                    }
                }
            }
        }
        this.minCollectorIndex = v;
    }

    @NotNull
    public SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    @Override  // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public AbstractSharedFlowSlot createSlot() {
        return this.createSlot();
    }

    @NotNull
    public SharedFlowSlot[] createSlotArray(int v) {
        return new SharedFlowSlot[v];
    }

    @Override  // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public AbstractSharedFlowSlot[] createSlotArray(int v) {
        return this.createSlotArray(v);
    }

    private final void dropOldestLocked() {
        Object[] arr_object = this.buffer;
        q.d(arr_object);
        SharedFlowKt.setBufferAt(arr_object, this.getHead(), null);
        --this.bufferSize;
        long v = this.getHead();
        if(this.replayIndex < v + 1L) {
            this.replayIndex = v + 1L;
        }
        if(this.minCollectorIndex < v + 1L) {
            this.correctCollectorIndexesOnDropOldest(v + 1L);
        }
    }

    @Override  // kotlinx.coroutines.flow.MutableSharedFlow
    @Nullable
    public Object emit(Object object0, @NotNull Continuation continuation0) {
        return SharedFlowImpl.emit$suspendImpl(this, object0, continuation0);
    }

    public static Object emit$suspendImpl(SharedFlowImpl sharedFlowImpl0, Object object0, Continuation continuation0) {
        boolean z = sharedFlowImpl0.tryEmit(object0);
        H h0 = H.a;
        if(z) {
            return h0;
        }
        Object object1 = sharedFlowImpl0.emitSuspend(object0, continuation0);
        return object1 == a.a ? object1 : h0;
    }

    private final Object emitSuspend(Object object0, Continuation continuation0) {
        Throwable throwable1;
        DisposableHandle disposableHandle0;
        Continuation[] arr_continuation1;
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        Continuation[] arr_continuation = AbstractSharedFlowKt.EMPTY_RESUMES;
        __monitor_enter(this);
        try {
            if(this.tryEmitLocked(object0)) {
                goto label_16;
            }
            else {
                Emitter sharedFlowImpl$Emitter0 = () -> synchronized(this) {
                    if(this.index < this.getHead()) {
                        return;
                    }
                    Object[] arr_object = this.buffer;
                    q.d(arr_object);
                    if(SharedFlowKt.access$getBufferAt(arr_object, this.index) != this) {
                        return;
                    }
                    SharedFlowKt.access$setBufferAt(arr_object, this.index, SharedFlowKt.NO_VALUE);
                    this.cleanupTailLocked();
                };
                this.enqueueLocked(sharedFlowImpl$Emitter0);
                ++this.queueSize;
                if(this.bufferCapacity == 0) {
                    arr_continuation = this.findSlotsToResumeLocked(arr_continuation);
                }
                arr_continuation1 = arr_continuation;
                disposableHandle0 = sharedFlowImpl$Emitter0;
            }
            goto label_24;
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            __monitor_exit(this);
            throw throwable1;
        }
        try {
        label_16:
            cancellableContinuationImpl0.resumeWith(H.a);
            arr_continuation1 = this.findSlotsToResumeLocked(arr_continuation);
            disposableHandle0 = null;
        }
        catch(Throwable throwable2) {
            throwable1 = throwable2;
            __monitor_exit(this);
            throw throwable1;
        }
    label_24:
        __monitor_exit(this);
        if(disposableHandle0 != null) {
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl0, disposableHandle0);
        }
        for(int v = 0; v < arr_continuation1.length; ++v) {
            Continuation continuation1 = arr_continuation1[v];
            if(continuation1 != null) {
                continuation1.resumeWith(H.a);
            }
        }
        Object object1 = cancellableContinuationImpl0.getResult();
        return object1 == a.a ? object1 : H.a;
    }

    private final void enqueueLocked(Object object0) {
        int v = this.getTotalSize();
        Object[] arr_object = this.buffer;
        if(arr_object == null) {
            arr_object = this.growBuffer(null, 0, 2);
        }
        else if(v >= arr_object.length) {
            arr_object = this.growBuffer(arr_object, v, arr_object.length * 2);
        }
        SharedFlowKt.setBufferAt(arr_object, this.getHead() + ((long)v), object0);
    }

    private final Continuation[] findSlotsToResumeLocked(Continuation[] arr_continuation) {
        int v = arr_continuation.length;
        if(this.nCollectors != 0) {
            AbstractSharedFlowSlot[] arr_abstractSharedFlowSlot = this.slots;
            if(arr_abstractSharedFlowSlot != null) {
                for(int v1 = 0; v1 < arr_abstractSharedFlowSlot.length; ++v1) {
                    AbstractSharedFlowSlot abstractSharedFlowSlot0 = arr_abstractSharedFlowSlot[v1];
                    if(abstractSharedFlowSlot0 != null) {
                        Continuation continuation0 = ((SharedFlowSlot)abstractSharedFlowSlot0).cont;
                        if(continuation0 != null && this.tryPeekLocked(((SharedFlowSlot)abstractSharedFlowSlot0)) >= 0L) {
                            if(v >= arr_continuation.length) {
                                arr_continuation = Arrays.copyOf(arr_continuation, Math.max(2, arr_continuation.length * 2));
                                q.f(arr_continuation, "copyOf(...)");
                            }
                            arr_continuation[v] = continuation0;
                            ((SharedFlowSlot)abstractSharedFlowSlot0).cont = null;
                            ++v;
                        }
                    }
                }
            }
        }
        return arr_continuation;
    }

    @Override  // kotlinx.coroutines.flow.internal.FusibleFlow
    @NotNull
    public Flow fuse(@NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        return SharedFlowKt.fuseSharedFlow(this, i0, v, bufferOverflow0);
    }

    private final long getBufferEndIndex() {
        return this.getHead() + ((long)this.bufferSize);
    }

    private final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    public final Object getLastReplayedLocked() {
        Object[] arr_object = this.buffer;
        q.d(arr_object);
        return SharedFlowKt.getBufferAt(arr_object, this.replayIndex + ((long)this.getReplaySize()) - 1L);
    }

    private final Object getPeekedValueLockedAt(long v) {
        Object[] arr_object = this.buffer;
        q.d(arr_object);
        Object object0 = SharedFlowKt.getBufferAt(arr_object, v);
        return object0 instanceof Emitter ? ((Emitter)object0).value : object0;
    }

    private final long getQueueEndIndex() {
        return this.getHead() + ((long)this.bufferSize) + ((long)this.queueSize);
    }

    private final int getReplaySize() {
        return (int)(this.getHead() + ((long)this.bufferSize) - this.replayIndex);
    }

    private final int getTotalSize() {
        return this.bufferSize + this.queueSize;
    }

    private final Object[] growBuffer(Object[] arr_object, int v, int v1) {
        if(v1 <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] arr_object1 = new Object[v1];
        this.buffer = arr_object1;
        if(arr_object != null) {
            long v2 = this.getHead();
            for(int v3 = 0; v3 < v; ++v3) {
                long v4 = ((long)v3) + v2;
                SharedFlowKt.setBufferAt(arr_object1, v4, SharedFlowKt.getBufferAt(arr_object, v4));
            }
        }
        return arr_object1;
    }

    @Override  // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        synchronized(this) {
            this.updateBufferLocked(this.getBufferEndIndex(), this.minCollectorIndex, this.getBufferEndIndex(), this.getQueueEndIndex());
        }
    }

    @Override  // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(Object object0) {
        boolean z;
        Continuation[] arr_continuation = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized(this) {
            if(this.tryEmitLocked(object0)) {
                arr_continuation = this.findSlotsToResumeLocked(arr_continuation);
                z = true;
            }
            else {
                z = false;
            }
        }
        for(int v = 0; v < arr_continuation.length; ++v) {
            Continuation continuation0 = arr_continuation[v];
            if(continuation0 != null) {
                continuation0.resumeWith(H.a);
            }
        }
        return z;
    }

    private final boolean tryEmitLocked(Object object0) {
        if(this.getNCollectors() == 0) {
            return this.tryEmitNoCollectorsLocked(object0);
        }
        if(this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            switch(WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()]) {
                case 1: {
                    return false;
                }
                case 2: {
                    return true;
                }
                case 3: {
                    break;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
        this.enqueueLocked(object0);
        int v = this.bufferSize + 1;
        this.bufferSize = v;
        if(v > this.bufferCapacity) {
            this.dropOldestLocked();
        }
        if(this.getReplaySize() > this.replay) {
            this.updateBufferLocked(this.replayIndex + 1L, this.minCollectorIndex, this.getBufferEndIndex(), this.getQueueEndIndex());
        }
        return true;
    }

    private final boolean tryEmitNoCollectorsLocked(Object object0) {
        if(this.replay == 0) {
            return true;
        }
        this.enqueueLocked(object0);
        int v = this.bufferSize + 1;
        this.bufferSize = v;
        if(v > this.replay) {
            this.dropOldestLocked();
        }
        this.minCollectorIndex = this.getHead() + ((long)this.bufferSize);
        return true;
    }

    private final long tryPeekLocked(SharedFlowSlot sharedFlowSlot0) {
        long v = sharedFlowSlot0.index;
        if(v >= this.getBufferEndIndex()) {
            if(this.bufferCapacity > 0) {
                return -1L;
            }
            if(v > this.getHead()) {
                return -1L;
            }
            return this.queueSize == 0 ? -1L : v;
        }
        return v;
    }

    private final Object tryTakeValue(SharedFlowSlot sharedFlowSlot0) {
        Symbol symbol0;
        Continuation[] arr_continuation = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized(this) {
            long v1 = this.tryPeekLocked(sharedFlowSlot0);
            if(v1 < 0L) {
                symbol0 = SharedFlowKt.NO_VALUE;
            }
            else {
                long v2 = sharedFlowSlot0.index;
                Object object0 = this.getPeekedValueLockedAt(v1);
                sharedFlowSlot0.index = v1 + 1L;
                arr_continuation = this.updateCollectorIndexLocked$kotlinx_coroutines_core(v2);
                symbol0 = object0;
            }
        }
        for(int v3 = 0; v3 < arr_continuation.length; ++v3) {
            Continuation continuation0 = arr_continuation[v3];
            if(continuation0 != null) {
                continuation0.resumeWith(H.a);
            }
        }
        return symbol0;
    }

    private final void updateBufferLocked(long v, long v1, long v2, long v3) {
        long v4 = Math.min(v1, v);
        for(long v5 = this.getHead(); v5 < v4; ++v5) {
            Object[] arr_object = this.buffer;
            q.d(arr_object);
            SharedFlowKt.setBufferAt(arr_object, v5, null);
        }
        this.replayIndex = v;
        this.minCollectorIndex = v1;
        this.bufferSize = (int)(v2 - v4);
        this.queueSize = (int)(v3 - v2);
    }

    @NotNull
    public final Continuation[] updateCollectorIndexLocked$kotlinx_coroutines_core(long v) {
        long v11;
        long v10;
        if(v > this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long v1 = this.getHead();
        long v2 = this.bufferCapacity != 0 || this.queueSize <= 0 ? ((long)this.bufferSize) + v1 : ((long)this.bufferSize) + v1 + 1L;
        if(this.nCollectors != 0) {
            AbstractSharedFlowSlot[] arr_abstractSharedFlowSlot = this.slots;
            if(arr_abstractSharedFlowSlot != null) {
                for(int v3 = 0; v3 < arr_abstractSharedFlowSlot.length; ++v3) {
                    AbstractSharedFlowSlot abstractSharedFlowSlot0 = arr_abstractSharedFlowSlot[v3];
                    if(abstractSharedFlowSlot0 != null) {
                        long v4 = ((SharedFlowSlot)abstractSharedFlowSlot0).index;
                        if(v4 >= 0L && v4 < v2) {
                            v2 = v4;
                        }
                    }
                }
            }
        }
        if(v2 <= this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long v5 = this.getBufferEndIndex();
        int v6 = this.getNCollectors() <= 0 ? this.queueSize : Math.min(this.queueSize, this.bufferCapacity - ((int)(v5 - v2)));
        Continuation[] arr_continuation = AbstractSharedFlowKt.EMPTY_RESUMES;
        long v7 = ((long)this.queueSize) + v5;
        if(v6 > 0) {
            arr_continuation = new Continuation[v6];
            Object[] arr_object = this.buffer;
            q.d(arr_object);
            long v8 = v5;
            int v9 = 0;
            while(v5 < v7) {
                Object object0 = SharedFlowKt.getBufferAt(arr_object, v5);
                v10 = v1;
                Symbol symbol0 = SharedFlowKt.NO_VALUE;
                if(object0 == symbol0) {
                    v11 = v2;
                }
                else {
                    q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    v11 = v2;
                    arr_continuation[v9] = ((Emitter)object0).cont;
                    SharedFlowKt.setBufferAt(arr_object, v5, symbol0);
                    SharedFlowKt.setBufferAt(arr_object, v8, ((Emitter)object0).value);
                    if(v9 + 1 < v6) {
                        ++v9;
                        ++v8;
                        goto label_45;
                    }
                    v5 = v8 + 1L;
                    goto label_55;
                }
            label_45:
                ++v5;
                v1 = v10;
                v2 = v11;
            }
            v10 = v1;
            v11 = v2;
            v5 = v8;
        }
        else {
            v10 = v1;
            v11 = v2;
        }
    label_55:
        long v12 = this.getNCollectors() == 0 ? v5 : v11;
        long v13 = Math.max(this.replayIndex, v5 - ((long)Math.min(this.replay, ((int)(v5 - v10)))));
        if(this.bufferCapacity == 0 && v13 < v7) {
            Object[] arr_object1 = this.buffer;
            q.d(arr_object1);
            if(q.b(SharedFlowKt.getBufferAt(arr_object1, v13), SharedFlowKt.NO_VALUE)) {
                ++v5;
                ++v13;
            }
        }
        this.updateBufferLocked(v13, v12, v5, v7);
        this.cleanupTailLocked();
        return arr_continuation.length == 0 ? arr_continuation : this.findSlotsToResumeLocked(arr_continuation);
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long v = this.replayIndex;
        if(v < this.minCollectorIndex) {
            this.minCollectorIndex = v;
        }
        return v;
    }
}

