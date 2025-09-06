package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u00028\u0000H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\f\u001A\u00028\u0000H\u0096@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/DeferredCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlinx/coroutines/Deferred;", "Lme/i;", "parentContext", "", "active", "<init>", "(Lme/i;Z)V", "getCompleted", "()Ljava/lang/Object;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
class DeferredCoroutine extends AbstractCoroutine implements Deferred {
    public DeferredCoroutine(@NotNull i i0, boolean z) {
        super(i0, true, z);
    }

    @Override  // kotlinx.coroutines.Deferred
    @Nullable
    public Object await(@NotNull Continuation continuation0) {
        return DeferredCoroutine.await$suspendImpl(this, continuation0);
    }

    public static Object await$suspendImpl(DeferredCoroutine deferredCoroutine0, Continuation continuation0) {
        return deferredCoroutine0.awaitInternal(continuation0);
    }

    @Override  // kotlinx.coroutines.Deferred
    public Object getCompleted() {
        return this.getCompletedInternal$kotlinx_coroutines_core();
    }
}

