package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import me.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001A\u0010\t\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/internal/ContextScope;", "Lkotlinx/coroutines/CoroutineScope;", "Lme/i;", "context", "<init>", "(Lme/i;)V", "", "toString", "()Ljava/lang/String;", "coroutineContext", "Lme/i;", "getCoroutineContext", "()Lme/i;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class ContextScope implements CoroutineScope {
    @NotNull
    private final i coroutineContext;

    public ContextScope(@NotNull i i0) {
        this.coroutineContext = i0;
    }

    @Override  // kotlinx.coroutines.CoroutineScope
    @NotNull
    public i getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override
    @NotNull
    public String toString() {
        return "CoroutineScope(coroutineContext=" + this.getCoroutineContext() + ')';
    }
}

