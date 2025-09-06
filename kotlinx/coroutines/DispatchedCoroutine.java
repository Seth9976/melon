package kotlinx.coroutines;

import e1.u;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import me.i;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001D\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000BJ\u0019\u0010\u0010\u001A\u00020\u000F2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001A\u00020\u000F2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u0012\u0010\u0011J\u0011\u0010\u0015\u001A\u0004\u0018\u00010\rH\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u000B\u0010\u0017\u001A\u00020\u00168\u0002X\u0082\u0004¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lme/i;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lme/i;Lkotlin/coroutines/Continuation;)V", "", "trySuspend", "()Z", "tryResume", "", "state", "Lie/H;", "afterCompletion", "(Ljava/lang/Object;)V", "afterResume", "getResult$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getResult", "Lkotlinx/atomicfu/AtomicInt;", "_decision", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class DispatchedCoroutine extends ScopeCoroutine {
    private volatile int _decision$volatile;
    private static final AtomicIntegerFieldUpdater _decision$volatile$FU;

    static {
        DispatchedCoroutine._decision$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, "_decision$volatile");
    }

    public DispatchedCoroutine(@NotNull i i0, @NotNull Continuation continuation0) {
        super(i0, continuation0);
    }

    @Override  // kotlinx.coroutines.internal.ScopeCoroutine
    public void afterCompletion(@Nullable Object object0) {
        this.afterResume(object0);
    }

    @Override  // kotlinx.coroutines.internal.ScopeCoroutine
    public void afterResume(@Nullable Object object0) {
        if(this.tryResume()) {
            return;
        }
        DispatchedContinuationKt.resumeCancellableWith(u.D(this.uCont), CompletionStateKt.recoverResult(object0, this.uCont));
    }

    @Nullable
    public final Object getResult$kotlinx_coroutines_core() {
        if(this.trySuspend()) {
            return a.a;
        }
        Object object0 = JobSupportKt.unboxState(this.getState$kotlinx_coroutines_core());
        if(object0 instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally)object0).cause;
        }
        return object0;
    }

    private final boolean tryResume() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater0 = DispatchedCoroutine._decision$volatile$FU;
    alab1:
        while(true) {
            switch(atomicIntegerFieldUpdater0.get(this)) {
                case 0: {
                    if(!DispatchedCoroutine._decision$volatile$FU.compareAndSet(this, 0, 2)) {
                        break;
                    }
                    break alab1;
                }
                case 1: {
                    return false;
                }
                default: {
                    throw new IllegalStateException("Already resumed");
                }
            }
        }
        return true;
    }

    private final boolean trySuspend() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater0 = DispatchedCoroutine._decision$volatile$FU;
    alab1:
        while(true) {
            switch(atomicIntegerFieldUpdater0.get(this)) {
                case 0: {
                    if(!DispatchedCoroutine._decision$volatile$FU.compareAndSet(this, 0, 1)) {
                        break;
                    }
                    break alab1;
                }
                case 2: {
                    return false;
                }
                default: {
                    throw new IllegalStateException("Already suspended");
                }
            }
        }
        return true;
    }
}

