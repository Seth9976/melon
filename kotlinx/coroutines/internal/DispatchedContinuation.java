package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ThreadLocalEventLoop;
import me.i;
import oe.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B\u001D\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0000\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u0012\u001A\u00020\u000FH\u0000\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0014\u001A\u00020\u000FH\u0000\u00A2\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0018\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015H\u0000\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u001D\u0010\u001D\u001A\u0004\u0018\u00010\u001A2\n\u0010\b\u001A\u0006\u0012\u0002\b\u00030\u0019H\u0000\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010!\u001A\u00020\u000B2\u0006\u0010\u001E\u001A\u00020\u001AH\u0000\u00A2\u0006\u0004\b\u001F\u0010 J\u0011\u0010%\u001A\u0004\u0018\u00010\"H\u0010\u00A2\u0006\u0004\b#\u0010$J\u001D\u0010(\u001A\u00020\u000F2\f\u0010\'\u001A\b\u0012\u0004\u0012\u00028\u00000&H\u0016\u00A2\u0006\u0004\b(\u0010)J\u001F\u0010/\u001A\u00020\u000F2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00028\u0000H\u0000\u00A2\u0006\u0004\b-\u0010.J\u000F\u00101\u001A\u000200H\u0016\u00A2\u0006\u0004\b1\u00102R\u0014\u0010\u0007\u001A\u00020\u00068\u0000X\u0081\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u00103R\u001A\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\b\u00104R\u001E\u00105\u001A\u0004\u0018\u00010\"8\u0000@\u0000X\u0081\u000E\u00A2\u0006\f\n\u0004\b5\u00106\u0012\u0004\b7\u0010\u0011R\u0014\u00108\u001A\u00020\"8\u0000X\u0081\u0004\u00A2\u0006\u0006\n\u0004\b8\u00106R\u001A\u0010:\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00158BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b9\u0010\u0017R\u001C\u0010=\u001A\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b;\u0010<R\u001A\u0010@\u001A\b\u0012\u0004\u0012\u00028\u00000\u00058PX\u0090\u0004\u00A2\u0006\u0006\u001A\u0004\b>\u0010?R\u0014\u0010+\u001A\u00020*8\u0016X\u0096\u0005\u00A2\u0006\u0006\u001A\u0004\bA\u0010BR\u0013\u0010D\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\"0C8\u0002X\u0082\u0004\u00A8\u0006E"}, d2 = {"Lkotlinx/coroutines/internal/DispatchedContinuation;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Loe/d;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "", "isReusable$kotlinx_coroutines_core", "()Z", "isReusable", "Lie/H;", "awaitReusability$kotlinx_coroutines_core", "()V", "awaitReusability", "release$kotlinx_coroutines_core", "release", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation$kotlinx_coroutines_core", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "tryReleaseClaimedContinuation$kotlinx_coroutines_core", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "tryReleaseClaimedContinuation", "cause", "postponeCancellation$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)Z", "postponeCancellation", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "Lie/p;", "result", "resumeWith", "(Ljava/lang/Object;)V", "Lme/i;", "context", "value", "dispatchYield$kotlinx_coroutines_core", "(Lme/i;Ljava/lang/Object;)V", "dispatchYield", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/Continuation;", "_state", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "countOrElement", "getReusableCancellableContinuation", "reusableCancellableContinuation", "getCallerFrame", "()Loe/d;", "callerFrame", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "getContext", "()Lme/i;", "Lkotlinx/atomicfu/AtomicRef;", "_reusableCancellableContinuation", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class DispatchedContinuation extends DispatchedTask implements Continuation, d {
    private volatile Object _reusableCancellableContinuation$volatile;
    private static final AtomicReferenceFieldUpdater _reusableCancellableContinuation$volatile$FU;
    @Nullable
    public Object _state;
    @NotNull
    public final Continuation continuation;
    @NotNull
    public final Object countOrElement;
    @NotNull
    public final CoroutineDispatcher dispatcher;

    static {
        DispatchedContinuation._reusableCancellableContinuation$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation$volatile");
    }

    public DispatchedContinuation(@NotNull CoroutineDispatcher coroutineDispatcher0, @NotNull Continuation continuation0) {
        super(-1);
        this.dispatcher = coroutineDispatcher0;
        this.continuation = continuation0;
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        this.countOrElement = ThreadContextKt.threadContextElements(this.getContext());
    }

    public final void awaitReusability$kotlinx_coroutines_core() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = DispatchedContinuation._reusableCancellableContinuation$volatile$FU;
        while(atomicReferenceFieldUpdater0.get(this) == DispatchedContinuationKt.REUSABLE_CLAIMED) {
        }
    }

    @Nullable
    public final CancellableContinuationImpl claimReusableCancellableContinuation$kotlinx_coroutines_core() {
        Object object0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = DispatchedContinuation._reusableCancellableContinuation$volatile$FU;
        while(true) {
            object0 = atomicReferenceFieldUpdater0.get(this);
            if(object0 == null) {
                DispatchedContinuation._reusableCancellableContinuation$volatile$FU.set(this, DispatchedContinuationKt.REUSABLE_CLAIMED);
                return null;
            }
            if(object0 instanceof CancellableContinuationImpl) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = DispatchedContinuation._reusableCancellableContinuation$volatile$FU;
                Symbol symbol0 = DispatchedContinuationKt.REUSABLE_CLAIMED;
                do {
                    if(atomicReferenceFieldUpdater1.compareAndSet(this, object0, symbol0)) {
                        return (CancellableContinuationImpl)object0;
                    }
                }
                while(atomicReferenceFieldUpdater1.get(this) == object0);
            }
            else if(object0 != DispatchedContinuationKt.REUSABLE_CLAIMED && !(object0 instanceof Throwable)) {
                break;
            }
        }
        throw new IllegalStateException(("Inconsistent state " + object0).toString());
    }

    public final void dispatchYield$kotlinx_coroutines_core(@NotNull i i0, Object object0) {
        this._state = object0;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(i0, this);
    }

    // 去混淆评级： 低(20)
    @Override  // oe.d
    @Nullable
    public d getCallerFrame() {
        return this.continuation instanceof d ? ((d)this.continuation) : null;
    }

    @Override  // kotlin.coroutines.Continuation
    @NotNull
    public i getContext() {
        return this.continuation.getContext();
    }

    @Override  // kotlinx.coroutines.DispatchedTask
    @NotNull
    public Continuation getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    private final CancellableContinuationImpl getReusableCancellableContinuation() {
        Object object0 = DispatchedContinuation._reusableCancellableContinuation$volatile$FU.get(this);
        return object0 instanceof CancellableContinuationImpl ? ((CancellableContinuationImpl)object0) : null;
    }

    public final boolean isReusable$kotlinx_coroutines_core() {
        return DispatchedContinuation._reusableCancellableContinuation$volatile$FU.get(this) != null;
    }

    public final boolean postponeCancellation$kotlinx_coroutines_core(@NotNull Throwable throwable0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = DispatchedContinuation._reusableCancellableContinuation$volatile$FU;
        while(true) {
            Object object0 = atomicReferenceFieldUpdater0.get(this);
            Symbol symbol0 = DispatchedContinuationKt.REUSABLE_CLAIMED;
            if(q.b(object0, symbol0)) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = DispatchedContinuation._reusableCancellableContinuation$volatile$FU;
                do {
                    if(atomicReferenceFieldUpdater1.compareAndSet(this, symbol0, throwable0)) {
                        return true;
                    }
                }
                while(atomicReferenceFieldUpdater1.get(this) == symbol0);
            }
            else {
                if(object0 instanceof Throwable) {
                    return true;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = DispatchedContinuation._reusableCancellableContinuation$volatile$FU;
                do {
                    if(atomicReferenceFieldUpdater2.compareAndSet(this, object0, null)) {
                        return false;
                    }
                }
                while(atomicReferenceFieldUpdater2.get(this) == object0);
            }
        }
    }

    public final void release$kotlinx_coroutines_core() {
        this.awaitReusability$kotlinx_coroutines_core();
        CancellableContinuationImpl cancellableContinuationImpl0 = this.getReusableCancellableContinuation();
        if(cancellableContinuationImpl0 != null) {
            cancellableContinuationImpl0.detachChild$kotlinx_coroutines_core();
        }
    }

    @Override  // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object object0) {
        Object object1 = CompletionStateKt.toState(object0);
        i i0 = this.getContext();
        if(DispatchedContinuationKt.safeIsDispatchNeeded(this.dispatcher, i0)) {
            this._state = object1;
            this.resumeMode = 0;
            i i1 = this.getContext();
            DispatchedContinuationKt.safeDispatch(this.dispatcher, i1, this);
            return;
        }
        EventLoop eventLoop0 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if(eventLoop0.isUnconfinedLoopActive()) {
            this._state = object1;
            this.resumeMode = 0;
            eventLoop0.dispatchUnconfined(this);
            return;
        }
        eventLoop0.incrementUseCount(true);
        try {
            i i2 = this.getContext();
            Object object2 = ThreadContextKt.updateThreadContext(i2, this.countOrElement);
            try {
                this.continuation.resumeWith(object0);
            }
            finally {
                ThreadContextKt.restoreThreadContext(i2, object2);
            }
            while(eventLoop0.processUnconfinedEvent()) {
            }
        }
        catch(Throwable throwable0) {
            this.handleFatalException$kotlinx_coroutines_core(throwable0);
        }
        finally {
            eventLoop0.decrementUseCount(true);
        }
    }

    @Override  // kotlinx.coroutines.DispatchedTask
    @Nullable
    public Object takeState$kotlinx_coroutines_core() {
        Object object0 = this._state;
        this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
        return object0;
    }

    @Override
    @NotNull
    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + DebugStringsKt.toDebugString(this.continuation) + ']';
    }

    @Nullable
    public final Throwable tryReleaseClaimedContinuation$kotlinx_coroutines_core(@NotNull CancellableContinuation cancellableContinuation0) {
        Object object0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = DispatchedContinuation._reusableCancellableContinuation$volatile$FU;
        while(true) {
            object0 = atomicReferenceFieldUpdater0.get(this);
            Symbol symbol0 = DispatchedContinuationKt.REUSABLE_CLAIMED;
            if(object0 != symbol0) {
                break;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = DispatchedContinuation._reusableCancellableContinuation$volatile$FU;
            do {
                if(atomicReferenceFieldUpdater1.compareAndSet(this, symbol0, cancellableContinuation0)) {
                    return null;
                }
            }
            while(atomicReferenceFieldUpdater1.get(this) == symbol0);
        }
        if(!(object0 instanceof Throwable)) {
            throw new IllegalStateException(("Inconsistent state " + object0).toString());
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = DispatchedContinuation._reusableCancellableContinuation$volatile$FU;
        do {
            if(atomicReferenceFieldUpdater2.compareAndSet(this, object0, null)) {
                return (Throwable)object0;
            }
        }
        while(atomicReferenceFieldUpdater2.get(this) == object0);
        throw new IllegalArgumentException("Failed requirement.");
    }
}

