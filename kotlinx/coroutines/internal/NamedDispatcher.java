package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import me.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0001\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\fJ#\u0010\u0011\u001A\u00020\u00102\u0006\u0010\t\u001A\u00020\b2\n\u0010\u000F\u001A\u00060\rj\u0002`\u000EH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001A\u00020\u00102\u0006\u0010\t\u001A\u00020\b2\n\u0010\u000F\u001A\u00060\rj\u0002`\u000EH\u0017¢\u0006\u0004\b\u0013\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u001A\u001A\u00020\u00102\u0006\u0010\u0017\u001A\u00020\u00162\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00100\u0018H\u0096\u0001¢\u0006\u0004\b\u001A\u0010\u001BJ,\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u0017\u001A\u00020\u00162\n\u0010\u000F\u001A\u00060\rj\u0002`\u000E2\u0006\u0010\t\u001A\u00020\bH\u0096\u0001¢\u0006\u0004\b\u001D\u0010\u001ER\u0014\u0010\u0003\u001A\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001FR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010 ¨\u0006!"}, d2 = {"Lkotlinx/coroutines/internal/NamedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "dispatcher", "", "name", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/String;)V", "Lme/i;", "context", "", "isDispatchNeeded", "(Lme/i;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lie/H;", "dispatch", "(Lme/i;Ljava/lang/Runnable;)V", "dispatchYield", "toString", "()Ljava/lang/String;", "", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lme/i;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class NamedDispatcher extends CoroutineDispatcher implements Delay {
    private final Delay $$delegate_0;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    @NotNull
    private final String name;

    public NamedDispatcher(@NotNull CoroutineDispatcher coroutineDispatcher0, @NotNull String s) {
        Delay delay0 = coroutineDispatcher0 instanceof Delay ? ((Delay)coroutineDispatcher0) : null;
        if(delay0 == null) {
            delay0 = DefaultExecutorKt.getDefaultDelay();
        }
        this.$$delegate_0 = delay0;
        this.dispatcher = coroutineDispatcher0;
        this.name = s;
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull i i0, @NotNull Runnable runnable0) {
        this.dispatcher.dispatch(i0, runnable0);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull i i0, @NotNull Runnable runnable0) {
        this.dispatcher.dispatchYield(i0, runnable0);
    }

    @Override  // kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long v, @NotNull Runnable runnable0, @NotNull i i0) {
        return this.$$delegate_0.invokeOnTimeout(v, runnable0, i0);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@NotNull i i0) {
        return this.dispatcher.isDispatchNeeded(i0);
    }

    @Override  // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long v, @NotNull CancellableContinuation cancellableContinuation0) {
        this.$$delegate_0.scheduleResumeAfterDelay(v, cancellableContinuation0);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return this.name;
    }
}

