package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u001B\u0010\u0004\u001A\u00020\u00032\n\u0010\u0002\u001A\u00060\u0000j\u0002`\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001A+\u0010\u000B\u001A\u00020\n*\u00060\u0006j\u0002`\u00072\u0006\u0010\t\u001A\u00020\b2\n\u0010\u0002\u001A\u00060\u0000j\u0002`\u0001H\u0000¢\u0006\u0004\b\u000B\u0010\f\"\u0014\u0010\r\u001A\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000E\"\u0014\u0010\u000F\u001A\u00020\b8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010\"\u0014\u0010\u0012\u001A\u00020\u00118\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\"\u0014\u0010\u0014\u001A\u00020\u00118\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013\"\u0014\u0010\u0015\u001A\u00020\b8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010\"\u0016\u0010\u0017\u001A\u00020\u00168\u0000@\u0000X\u0081\u000E¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018*\f\b\u0000\u0010\u0019\"\u00020\u00002\u00020\u0000¨\u0006\u001A"}, d2 = {"", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "", "taskContextString", "(Z)Ljava/lang/String;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "submissionTime", "Lkotlinx/coroutines/scheduling/Task;", "asTask", "(Ljava/lang/Runnable;JZ)Lkotlinx/coroutines/scheduling/Task;", "DEFAULT_SCHEDULER_NAME", "Ljava/lang/String;", "WORK_STEALING_TIME_RESOLUTION_NS", "J", "", "CORE_POOL_SIZE", "I", "MAX_POOL_SIZE", "IDLE_WORKER_KEEP_ALIVE_NS", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "TaskContext", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class TasksKt {
    public static final int CORE_POOL_SIZE;
    @NotNull
    public static final String DEFAULT_SCHEDULER_NAME;
    public static final long IDLE_WORKER_KEEP_ALIVE_NS;
    public static final int MAX_POOL_SIZE;
    public static final long WORK_STEALING_TIME_RESOLUTION_NS;
    @NotNull
    public static SchedulerTimeSource schedulerTimeSource;

    static {
        TasksKt.DEFAULT_SCHEDULER_NAME = "DefaultDispatcher";
        TasksKt.WORK_STEALING_TIME_RESOLUTION_NS = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        TasksKt.CORE_POOL_SIZE = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.core.pool.size", 8, 1, 0, 8, null);
        TasksKt.MAX_POOL_SIZE = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.max.pool.size", 0x1FFFFE, 0, 0x1FFFFE, 4, null);
        TasksKt.IDLE_WORKER_KEEP_ALIVE_NS = TimeUnit.SECONDS.toNanos(SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null));
        TasksKt.schedulerTimeSource = NanoTimeSource.INSTANCE;
    }

    @NotNull
    public static final Task asTask(@NotNull Runnable runnable0, long v, boolean z) {
        return new TaskImpl(runnable0, v, z);
    }

    // 去混淆评级： 低(20)
    private static final String taskContextString(boolean z) {
        return z ? "Blocking" : "Non-blocking";
    }
}

