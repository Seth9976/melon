package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import me.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00020\u000E2\n\u0010\u0012\u001A\u00060\u0010j\u0002`\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00020\u000E2\n\u0010\u0012\u001A\u00060\u0010j\u0002`\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J/\u0010\u001C\u001A\u00020\u00132\n\u0010\u0012\u001A\u00060\u0010j\u0002`\u00112\n\u0010\u000F\u001A\u00060\u0017j\u0002`\u00182\u0006\u0010\u0019\u001A\u00020\u0017H\u0000¢\u0006\u0004\b\u001A\u0010\u001BR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001DR\u0014\u0010\u0004\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001DR\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001ER\u0014\u0010\b\u001A\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001FR\u0016\u0010 \u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001A\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lkotlinx/coroutines/scheduling/SchedulerCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "createScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Lme/i;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lie/H;", "dispatch", "(Lme/i;Ljava/lang/Runnable;)V", "dispatchYield", "", "Lkotlinx/coroutines/scheduling/TaskContext;", "fair", "dispatchWithContext$kotlinx_coroutines_core", "(Ljava/lang/Runnable;ZZ)V", "dispatchWithContext", "I", "J", "Ljava/lang/String;", "coroutineScheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class SchedulerCoroutineDispatcher extends ExecutorCoroutineDispatcher {
    private final int corePoolSize;
    @NotNull
    private CoroutineScheduler coroutineScheduler;
    private final long idleWorkerKeepAliveNs;
    private final int maxPoolSize;
    @NotNull
    private final String schedulerName;

    public SchedulerCoroutineDispatcher(int v, int v1, long v2, @NotNull String s) {
        this.corePoolSize = v;
        this.maxPoolSize = v1;
        this.idleWorkerKeepAliveNs = v2;
        this.schedulerName = s;
        this.coroutineScheduler = this.createScheduler();
    }

    private final CoroutineScheduler createScheduler() {
        return new CoroutineScheduler(this.corePoolSize, this.maxPoolSize, this.idleWorkerKeepAliveNs, this.schedulerName);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull i i0, @NotNull Runnable runnable0) {
        CoroutineScheduler.dispatch$default(this.coroutineScheduler, runnable0, false, false, 6, null);
    }

    public final void dispatchWithContext$kotlinx_coroutines_core(@NotNull Runnable runnable0, boolean z, boolean z1) {
        this.coroutineScheduler.dispatch(runnable0, z, z1);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull i i0, @NotNull Runnable runnable0) {
        CoroutineScheduler.dispatch$default(this.coroutineScheduler, runnable0, false, true, 2, null);
    }

    @Override  // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @NotNull
    public Executor getExecutor() {
        return this.coroutineScheduler;
    }
}

