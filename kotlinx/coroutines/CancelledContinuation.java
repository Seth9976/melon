package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\f\u001A\u00020\u0007R\t\u0010\n\u001A\u00020\u000BX\u0082\u0004¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlinx/coroutines/CompletedExceptionally;", "continuation", "Lkotlin/coroutines/Continuation;", "cause", "", "handled", "", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;Z)V", "_resumed", "Lkotlinx/atomicfu/AtomicBoolean;", "makeResumed", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class CancelledContinuation extends CompletedExceptionally {
    private volatile int _resumed$volatile;
    private static final AtomicIntegerFieldUpdater _resumed$volatile$FU;

    static {
        CancelledContinuation._resumed$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(CancelledContinuation.class, "_resumed$volatile");
    }

    public CancelledContinuation(@NotNull Continuation continuation0, @Nullable Throwable throwable0, boolean z) {
        if(throwable0 == null) {
            throwable0 = new CancellationException("Continuation " + continuation0 + " was cancelled normally");
        }
        super(throwable0, z);
    }

    private static final AtomicIntegerFieldUpdater get_resumed$volatile$FU() {
        return CancelledContinuation._resumed$volatile$FU;
    }

    public final boolean makeResumed() {
        return CancelledContinuation.get_resumed$volatile$FU().compareAndSet(this, 0, 1);
    }
}

