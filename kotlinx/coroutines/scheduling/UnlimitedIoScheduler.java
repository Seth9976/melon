package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u00042\n\u0010\b\u001A\u00060\u0006j\u0002`\u0007H\u0017¢\u0006\u0004\b\n\u0010\u000BJ#\u0010\f\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u00042\n\u0010\b\u001A\u00060\u0006j\u0002`\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000BJ!\u0010\u0011\u001A\u00020\u00012\u0006\u0010\u000E\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/scheduling/UnlimitedIoScheduler;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "Lme/i;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lie/H;", "dispatchYield", "(Lme/i;Ljava/lang/Runnable;)V", "dispatch", "", "parallelism", "", "name", "limitedParallelism", "(ILjava/lang/String;)Lkotlinx/coroutines/CoroutineDispatcher;", "toString", "()Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class UnlimitedIoScheduler extends CoroutineDispatcher {
    @NotNull
    public static final UnlimitedIoScheduler INSTANCE;

    static {
        UnlimitedIoScheduler.INSTANCE = new UnlimitedIoScheduler();
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull i i0, @NotNull Runnable runnable0) {
        DefaultScheduler.INSTANCE.dispatchWithContext$kotlinx_coroutines_core(runnable0, true, false);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull i i0, @NotNull Runnable runnable0) {
        DefaultScheduler.INSTANCE.dispatchWithContext$kotlinx_coroutines_core(runnable0, true, true);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public CoroutineDispatcher limitedParallelism(int v, @Nullable String s) {
        LimitedDispatcherKt.checkParallelism(v);
        return v < TasksKt.MAX_POOL_SIZE ? super.limitedParallelism(v, s) : LimitedDispatcherKt.namedOrThis(this, s);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return "Dispatchers.IO";
    }
}

