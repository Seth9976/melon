package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;
import me.i;
import me.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J#\u0010\u0015\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u00112\n\u0010\u0014\u001A\u00060\u0005j\u0002`\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u00112\n\u0010\u0014\u001A\u00060\u0005j\u0002`\u0013H\u0017¢\u0006\u0004\b\u0017\u0010\u0016J\u000F\u0010\u0018\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000F\u0010\u0019\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001B\u001A\u00020\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001F\u001A\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001E¨\u0006 "}, d2 = {"Lkotlinx/coroutines/scheduling/DefaultIoScheduler;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "<init>", "()V", "Ljava/lang/Runnable;", "command", "Lie/H;", "execute", "(Ljava/lang/Runnable;)V", "", "parallelism", "", "name", "Lkotlinx/coroutines/CoroutineDispatcher;", "limitedParallelism", "(ILjava/lang/String;)Lkotlinx/coroutines/CoroutineDispatcher;", "Lme/i;", "context", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lme/i;Ljava/lang/Runnable;)V", "dispatchYield", "close", "toString", "()Ljava/lang/String;", "default", "Lkotlinx/coroutines/CoroutineDispatcher;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class DefaultIoScheduler extends ExecutorCoroutineDispatcher implements Executor {
    @NotNull
    public static final DefaultIoScheduler INSTANCE;
    @NotNull
    private static final CoroutineDispatcher default;

    static {
        DefaultIoScheduler.INSTANCE = new DefaultIoScheduler();
        DefaultIoScheduler.default = CoroutineDispatcher.limitedParallelism$default(UnlimitedIoScheduler.INSTANCE, SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.io.parallelism", 0x40, 0, 0, 12, null), null, 2, null);
    }

    @Override
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull i i0, @NotNull Runnable runnable0) {
        DefaultIoScheduler.default.dispatch(i0, runnable0);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull i i0, @NotNull Runnable runnable0) {
        DefaultIoScheduler.default.dispatchYield(i0, runnable0);
    }

    @Override
    public void execute(@NotNull Runnable runnable0) {
        this.dispatch(j.a, runnable0);
    }

    @Override  // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @NotNull
    public Executor getExecutor() {
        return this;
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public CoroutineDispatcher limitedParallelism(int v, @Nullable String s) {
        return UnlimitedIoScheduler.INSTANCE.limitedParallelism(v, s);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return "Dispatchers.IO";
    }
}

