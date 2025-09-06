package kotlinx.coroutines.flow;

import d5.n;
import ie.H;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import me.i;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006B\u000F\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u00A2\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001A\u00020\f2\b\u0010\n\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u000B\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00028\u00002\u0006\u0010\u0010\u001A\u00028\u0000H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u000EJ\u0017\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00028\u0000H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0012\u001A\u00028\u0000H\u0096@\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001E\u0010\u001D\u001A\u00020\u001C2\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\u001AH\u0096@\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u00020\u0003H\u0014\u00A2\u0006\u0004\b\u001F\u0010 J\u001F\u0010$\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030#2\u0006\u0010\"\u001A\u00020!H\u0014\u00A2\u0006\u0004\b$\u0010%J-\u0010,\u001A\b\u0012\u0004\u0012\u00028\u00000+2\u0006\u0010\'\u001A\u00020&2\u0006\u0010(\u001A\u00020!2\u0006\u0010*\u001A\u00020)H\u0016\u00A2\u0006\u0004\b,\u0010-R\u0016\u0010.\u001A\u00020!8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b.\u0010/R$\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0012\u001A\u00028\u00008V@VX\u0096\u000E\u00A2\u0006\f\u001A\u0004\b0\u00101\"\u0004\b2\u0010\tR\u0011\u00104\u001A\b\u0012\u0004\u0012\u00020\u0005038\u0002X\u0082\u0004\u00A8\u00065"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "initialState", "<init>", "(Ljava/lang/Object;)V", "expectedState", "newState", "", "updateState", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "expect", "update", "compareAndSet", "value", "tryEmit", "(Ljava/lang/Object;)Z", "Lie/H;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetReplayCache", "()V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "Lme/i;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "sequence", "I", "getValue", "()Ljava/lang/Object;", "setValue", "Lkotlinx/atomicfu/AtomicRef;", "_state", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class StateFlowImpl extends AbstractSharedFlow implements Flow, MutableStateFlow, FusibleFlow {
    private volatile Object _state$volatile;
    private static final AtomicReferenceFieldUpdater _state$volatile$FU;
    private int sequence;

    static {
        StateFlowImpl._state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state$volatile");
    }

    public StateFlowImpl(@NotNull Object object0) {
        this._state$volatile = object0;
    }

    @Override  // kotlinx.coroutines.flow.Flow, kotlinx.coroutines.flow.SharedFlow
    @Nullable
    public Object collect(@NotNull FlowCollector flowCollector0, @NotNull Continuation continuation0) {
        FlowCollector flowCollector1;
        Job job0;
        Object object1;
        StateFlowImpl stateFlowImpl0;
        StateFlowSlot stateFlowSlot0;
        kotlinx.coroutines.flow.StateFlowImpl.collect.1 stateFlowImpl$collect$10;
        if(continuation0 instanceof kotlinx.coroutines.flow.StateFlowImpl.collect.1) {
            stateFlowImpl$collect$10 = (kotlinx.coroutines.flow.StateFlowImpl.collect.1)continuation0;
            int v = stateFlowImpl$collect$10.label;
            if((v & 0x80000000) == 0) {
                stateFlowImpl$collect$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.collect(null, this);
                    }
                };
            }
            else {
                stateFlowImpl$collect$10.label = v ^ 0x80000000;
            }
        }
        else {
            stateFlowImpl$collect$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.collect(null, this);
                }
            };
        }
        Object object0 = stateFlowImpl$collect$10.result;
        a a0 = a.a;
        int v1 = stateFlowImpl$collect$10.label;
        if(v1 == 0) {
            n.D(object0);
            stateFlowImpl0 = this;
            stateFlowSlot0 = (StateFlowSlot)this.allocateSlot();
            try {
            label_37:
                flowCollector1 = flowCollector0;
                job0 = (Job)stateFlowImpl$collect$10.getContext().get(Job.Key);
                object1 = null;
            alab1:
                while(true) {
                    while(true) {
                    label_40:
                        Object object2 = StateFlowImpl._state$volatile$FU.get(stateFlowImpl0);
                        if(job0 != null) {
                            JobKt.ensureActive(job0);
                        }
                        if(object1 == null || !object1.equals(object2)) {
                            stateFlowImpl$collect$10.L$0 = stateFlowImpl0;
                            stateFlowImpl$collect$10.L$1 = flowCollector1;
                            stateFlowImpl$collect$10.L$2 = stateFlowSlot0;
                            stateFlowImpl$collect$10.L$3 = job0;
                            stateFlowImpl$collect$10.L$4 = object2;
                            stateFlowImpl$collect$10.label = 2;
                            if(flowCollector1.emit((object2 == NullSurrogateKt.NULL ? null : object2), stateFlowImpl$collect$10) == a0) {
                                break alab1;
                            }
                            object1 = object2;
                        }
                    label_52:
                        if(stateFlowSlot0.takePending()) {
                            break;
                        }
                        stateFlowImpl$collect$10.L$0 = stateFlowImpl0;
                        stateFlowImpl$collect$10.L$1 = flowCollector1;
                        stateFlowImpl$collect$10.L$2 = stateFlowSlot0;
                        stateFlowImpl$collect$10.L$3 = job0;
                        stateFlowImpl$collect$10.L$4 = object1;
                        stateFlowImpl$collect$10.label = 3;
                        if(stateFlowSlot0.awaitPending(stateFlowImpl$collect$10) != a0) {
                            break;
                        }
                        break alab1;
                    }
                }
                return a0;
            }
            catch(Throwable throwable0) {
                stateFlowImpl0.freeSlot(stateFlowSlot0);
                throw throwable0;
            }
        }
        else {
            switch(v1) {
                case 1: {
                    stateFlowSlot0 = (StateFlowSlot)stateFlowImpl$collect$10.L$2;
                    flowCollector0 = (FlowCollector)stateFlowImpl$collect$10.L$1;
                    stateFlowImpl0 = (StateFlowImpl)stateFlowImpl$collect$10.L$0;
                    try {
                        n.D(object0);
                        goto label_37;
                    }
                    catch(Throwable throwable0) {
                        stateFlowImpl0.freeSlot(stateFlowSlot0);
                        throw throwable0;
                    }
                }
                case 2: {
                    object1 = stateFlowImpl$collect$10.L$4;
                    job0 = (Job)stateFlowImpl$collect$10.L$3;
                    stateFlowSlot0 = (StateFlowSlot)stateFlowImpl$collect$10.L$2;
                    flowCollector1 = (FlowCollector)stateFlowImpl$collect$10.L$1;
                    stateFlowImpl0 = (StateFlowImpl)stateFlowImpl$collect$10.L$0;
                    try {
                        n.D(object0);
                        goto label_52;
                    }
                    catch(Throwable throwable0) {
                        stateFlowImpl0.freeSlot(stateFlowSlot0);
                        throw throwable0;
                    }
                }
                case 3: {
                    object1 = stateFlowImpl$collect$10.L$4;
                    job0 = (Job)stateFlowImpl$collect$10.L$3;
                    stateFlowSlot0 = (StateFlowSlot)stateFlowImpl$collect$10.L$2;
                    flowCollector1 = (FlowCollector)stateFlowImpl$collect$10.L$1;
                    stateFlowImpl0 = (StateFlowImpl)stateFlowImpl$collect$10.L$0;
                    try {
                        n.D(object0);
                        break;
                    }
                    catch(Throwable throwable0) {
                        stateFlowImpl0.freeSlot(stateFlowSlot0);
                        throw throwable0;
                    }
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
        }
        goto label_40;
    }

    @Override  // kotlinx.coroutines.flow.MutableStateFlow
    public boolean compareAndSet(Object object0, Object object1) {
        if(object0 == null) {
            object0 = NullSurrogateKt.NULL;
        }
        if(object1 == null) {
            object1 = NullSurrogateKt.NULL;
        }
        return this.updateState(object0, object1);
    }

    @NotNull
    public StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    @Override  // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public AbstractSharedFlowSlot createSlot() {
        return this.createSlot();
    }

    @NotNull
    public StateFlowSlot[] createSlotArray(int v) {
        return new StateFlowSlot[v];
    }

    @Override  // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public AbstractSharedFlowSlot[] createSlotArray(int v) {
        return this.createSlotArray(v);
    }

    @Override  // kotlinx.coroutines.flow.MutableSharedFlow
    @Nullable
    public Object emit(Object object0, @NotNull Continuation continuation0) {
        this.setValue(object0);
        return H.a;
    }

    @Override  // kotlinx.coroutines.flow.internal.FusibleFlow
    @NotNull
    public Flow fuse(@NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        return StateFlowKt.fuseStateFlow(this, i0, v, bufferOverflow0);
    }

    @Override  // kotlinx.coroutines.flow.MutableStateFlow
    public Object getValue() {
        Object object0 = StateFlowImpl._state$volatile$FU.get(this);
        return object0 == NullSurrogateKt.NULL ? null : object0;
    }

    @Override  // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override  // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(Object object0) {
        if(object0 == null) {
            object0 = NullSurrogateKt.NULL;
        }
        this.updateState(null, object0);
    }

    @Override  // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(Object object0) {
        this.setValue(object0);
        return true;
    }

    private final boolean updateState(Object object0, Object object1) {
        int v4;
        AbstractSharedFlowSlot[] arr_abstractSharedFlowSlot;
        int v1;
        int v;
        synchronized(this) {
            Object object2 = StateFlowImpl._state$volatile$FU.get(this);
            if(object0 == null || q.b(object2, object0)) {
                if(!q.b(object2, object1)) {
                    StateFlowImpl._state$volatile$FU.set(this, object1);
                    v = this.sequence;
                    if((v & 1) == 0) {
                        v1 = v + 1;
                        this.sequence = v1;
                        arr_abstractSharedFlowSlot = this.getSlots();
                        goto label_10;
                    }
                    this.sequence = v + 2;
                    return true;
                }
                return true;
            }
            return false;
        }
    label_10:
        while(true) {
            StateFlowSlot[] arr_stateFlowSlot = (StateFlowSlot[])arr_abstractSharedFlowSlot;
            if(arr_stateFlowSlot != null) {
                int v2 = arr_stateFlowSlot.length;
                for(int v3 = 0; v3 < v2; ++v3) {
                    StateFlowSlot stateFlowSlot0 = arr_stateFlowSlot[v3];
                    if(stateFlowSlot0 != null) {
                        stateFlowSlot0.makePending();
                    }
                }
            }
            synchronized(this) {
                v4 = this.sequence;
                if(v4 == v1) {
                    break;
                }
            }
            arr_abstractSharedFlowSlot = this.getSlots();
            v1 = v4;
        }
        this.sequence = v1 + 1;
        return true;
    }
}

