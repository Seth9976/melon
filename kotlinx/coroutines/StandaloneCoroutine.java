package kotlinx.coroutines;

import kotlin.Metadata;
import me.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\tH\u0014¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/StandaloneCoroutine;", "Lkotlinx/coroutines/AbstractCoroutine;", "Lie/H;", "Lme/i;", "parentContext", "", "active", "<init>", "(Lme/i;Z)V", "", "exception", "handleJobException", "(Ljava/lang/Throwable;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
class StandaloneCoroutine extends AbstractCoroutine {
    public StandaloneCoroutine(@NotNull i i0, boolean z) {
        super(i0, true, z);
    }

    @Override  // kotlinx.coroutines.JobSupport
    public boolean handleJobException(@NotNull Throwable throwable0) {
        CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), throwable0);
        return true;
    }
}

