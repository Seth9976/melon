package kotlinx.coroutines.flow.internal;

import e1.u;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
import me.i;
import oe.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A-\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001AZ\u0010\u000E\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00028\u00012\b\b\u0002\u0010\n\u001A\u00020\t2\"\u0010\r\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000BH\u0080@¢\u0006\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lme/i;", "emitContext", "withUndispatchedContextCollector", "(Lkotlinx/coroutines/flow/FlowCollector;Lme/i;)Lkotlinx/coroutines/flow/FlowCollector;", "V", "newContext", "value", "", "countOrElement", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "block", "withContextUndispatched", "(Lme/i;Ljava/lang/Object;Ljava/lang/Object;Lwe/n;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class ChannelFlowKt {
    @Nullable
    public static final Object withContextUndispatched(@NotNull i i0, Object object0, @NotNull Object object1, @NotNull n n0, @NotNull Continuation continuation0) {
        Object object3;
        Object object2 = ThreadContextKt.updateThreadContext(i0, object1);
        try {
            StackFrameContinuation stackFrameContinuation0 = new StackFrameContinuation(continuation0, i0);
            if(n0 instanceof a) {
                N.e(2, n0);
                object3 = n0.invoke(object0, stackFrameContinuation0);
            }
            else {
                object3 = u.X(n0, object0, stackFrameContinuation0);
            }
        }
        finally {
            ThreadContextKt.restoreThreadContext(i0, object2);
        }
        if(object3 == ne.a.a) {
            q.g(continuation0, "frame");
        }
        return object3;
    }

    public static Object withContextUndispatched$default(i i0, Object object0, Object object1, n n0, Continuation continuation0, int v, Object object2) {
        if((v & 4) != 0) {
            object1 = ThreadContextKt.threadContextElements(i0);
        }
        return ChannelFlowKt.withContextUndispatched(i0, object0, object1, n0, continuation0);
    }

    private static final FlowCollector withUndispatchedContextCollector(FlowCollector flowCollector0, i i0) {
        return flowCollector0 instanceof SendingCollector || flowCollector0 instanceof NopCollector ? flowCollector0 : new UndispatchedContextCollector(flowCollector0, i0);
    }
}

