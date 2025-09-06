package kotlinx.coroutines.flow;

import e1.u;
import ie.H;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.internal.Concurrent_commonKt;
import kotlinx.coroutines.internal.Symbol;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001B\u0010\u0007\u001A\u00020\u00062\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\n0\t2\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000E\u001A\u00020\u000B¢\u0006\u0004\b\u000E\u0010\u0004J\r\u0010\u000F\u001A\u00020\u0006¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u000BH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u0016\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0014`\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/StateFlowImpl;", "<init>", "()V", "flow", "", "allocateLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)Z", "", "Lkotlin/coroutines/Continuation;", "Lie/H;", "freeLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "makePending", "takePending", "()Z", "awaitPending", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Lkotlinx/coroutines/internal/WorkaroundAtomicReference;", "_state", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class StateFlowSlot extends AbstractSharedFlowSlot {
    @NotNull
    private final AtomicReference _state;

    public StateFlowSlot() {
        this._state = new AtomicReference(null);
    }

    @Override  // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public boolean allocateLocked(Object object0) {
        return this.allocateLocked(((StateFlowImpl)object0));
    }

    public boolean allocateLocked(@NotNull StateFlowImpl stateFlowImpl0) {
        if(Concurrent_commonKt.getValue(this._state) != null) {
            return false;
        }
        Concurrent_commonKt.setValue(this._state, StateFlowKt.NONE);
        return true;
    }

    @Nullable
    public final Object awaitPending(@NotNull Continuation continuation0) {
        H h0;
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        AtomicReference atomicReference0 = this._state;
        Symbol symbol0 = StateFlowKt.NONE;
        while(true) {
            boolean z = atomicReference0.compareAndSet(symbol0, cancellableContinuationImpl0);
            h0 = H.a;
            if(z) {
                break;
            }
            if(atomicReference0.get() != symbol0) {
                cancellableContinuationImpl0.resumeWith(h0);
                break;
            }
        }
        Object object0 = cancellableContinuationImpl0.getResult();
        return object0 == a.a ? object0 : h0;
    }

    @Override  // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public Continuation[] freeLocked(Object object0) {
        return this.freeLocked(((StateFlowImpl)object0));
    }

    @NotNull
    public Continuation[] freeLocked(@NotNull StateFlowImpl stateFlowImpl0) {
        Concurrent_commonKt.setValue(this._state, null);
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }

    public final void makePending() {
        AtomicReference atomicReference0 = this._state;
        while(true) {
            Object object0 = Concurrent_commonKt.getValue(atomicReference0);
            if(object0 == null || object0 == StateFlowKt.PENDING) {
                return;
            }
            if(object0 == StateFlowKt.NONE) {
                AtomicReference atomicReference1 = this._state;
                Symbol symbol0 = StateFlowKt.PENDING;
                do {
                    if(atomicReference1.compareAndSet(object0, symbol0)) {
                        return;
                    }
                }
                while(atomicReference1.get() == object0);
            }
            else {
                AtomicReference atomicReference2 = this._state;
                Symbol symbol1 = StateFlowKt.NONE;
                do {
                    if(atomicReference2.compareAndSet(object0, symbol1)) {
                        ((CancellableContinuationImpl)object0).resumeWith(H.a);
                        return;
                    }
                }
                while(atomicReference2.get() == object0);
            }
        }
    }

    public final boolean takePending() {
        Object object0 = this._state.getAndSet(StateFlowKt.NONE);
        q.d(object0);
        return object0 == StateFlowKt.PENDING;
    }
}

