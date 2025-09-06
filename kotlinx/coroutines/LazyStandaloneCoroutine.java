package kotlinx.coroutines;

import e1.u;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.intrinsics.CancellableKt;
import me.i;
import org.jetbrains.annotations.NotNull;
import we.n;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\"\u0010\t\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\u0007H\u0014¢\u0006\u0004\b\f\u0010\rR\u001A\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/LazyStandaloneCoroutine;", "Lkotlinx/coroutines/StandaloneCoroutine;", "Lme/i;", "parentContext", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lie/H;", "", "block", "<init>", "(Lme/i;Lwe/n;)V", "onStart", "()V", "continuation", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class LazyStandaloneCoroutine extends StandaloneCoroutine {
    @NotNull
    private final Continuation continuation;

    public LazyStandaloneCoroutine(@NotNull i i0, @NotNull n n0) {
        super(i0, false);
        this.continuation = u.q(n0, this, this);
    }

    @Override  // kotlinx.coroutines.JobSupport
    public void onStart() {
        CancellableKt.startCoroutineCancellable(this.continuation, this);
    }
}

