package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.ScopeCoroutine;
import me.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001D\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/SupervisorCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lme/i;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lme/i;Lkotlin/coroutines/Continuation;)V", "", "cause", "", "childCancelled", "(Ljava/lang/Throwable;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class SupervisorCoroutine extends ScopeCoroutine {
    public SupervisorCoroutine(@NotNull i i0, @NotNull Continuation continuation0) {
        super(i0, continuation0);
    }

    @Override  // kotlinx.coroutines.JobSupport
    public boolean childCancelled(@NotNull Throwable throwable0) {
        return false;
    }
}

