package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import me.i;
import me.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\b\u001A\u00020\u00072\u000E\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001A\u0010\u000B\u001A\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lkotlinx/coroutines/flow/internal/NoOpContinuation;", "Lkotlin/coroutines/Continuation;", "", "<init>", "()V", "Lie/p;", "result", "Lie/H;", "resumeWith", "(Ljava/lang/Object;)V", "Lme/i;", "context", "Lme/i;", "getContext", "()Lme/i;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class NoOpContinuation implements Continuation {
    @NotNull
    public static final NoOpContinuation INSTANCE;
    @NotNull
    private static final i context;

    static {
        NoOpContinuation.INSTANCE = new NoOpContinuation();
        NoOpContinuation.context = j.a;
    }

    @Override  // kotlin.coroutines.Continuation
    @NotNull
    public i getContext() {
        return NoOpContinuation.context;
    }

    @Override  // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object object0) {
    }
}

