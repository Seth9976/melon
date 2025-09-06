package kotlinx.coroutines;

import e1.u;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import me.i;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0010\u0010\u0001\u001A\u00020\u0000H\u0086@¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lie/H;", "yield", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class YieldKt {
    @Nullable
    public static final Object yield(@NotNull Continuation continuation0) {
        a a0;
        i i0 = continuation0.getContext();
        JobKt.ensureActive(i0);
        Continuation continuation1 = u.D(continuation0);
        DispatchedContinuation dispatchedContinuation0 = continuation1 instanceof DispatchedContinuation ? ((DispatchedContinuation)continuation1) : null;
        H h0 = H.a;
        if(dispatchedContinuation0 == null) {
            a0 = h0;
        }
        else if(DispatchedContinuationKt.safeIsDispatchNeeded(dispatchedContinuation0.dispatcher, i0)) {
            dispatchedContinuation0.dispatchYield$kotlinx_coroutines_core(i0, h0);
            a0 = a.a;
        }
        else {
            YieldContext yieldContext0 = new YieldContext();
            dispatchedContinuation0.dispatchYield$kotlinx_coroutines_core(i0.plus(yieldContext0), h0);
            if(!yieldContext0.dispatcherWasUnconfined) {
                a0 = a.a;
            }
            else if(DispatchedContinuationKt.yieldUndispatched(dispatchedContinuation0)) {
                a0 = a.a;
            }
            else {
                a0 = h0;
            }
        }
        return a0 == a.a ? a0 : h0;
    }
}

