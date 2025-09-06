package okhttp3.internal.concurrent;

import U4.x;
import java.util.Arrays;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.a;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\u001A1\u0010\b\u001A\u00020\u00072\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00022\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0080\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001A7\u0010\f\u001A\u00028\u0000\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00022\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0080\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001A\'\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\u000F\u0010\u0010\u001A\u0015\u0010\u0013\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/concurrent/Task;", "task", "Lokhttp3/internal/concurrent/TaskQueue;", "queue", "Lkotlin/Function0;", "", "messageBlock", "Lie/H;", "taskLog", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lwe/a;)V", "T", "block", "logElapsed", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lwe/a;)Ljava/lang/Object;", "message", "log", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Ljava/lang/String;)V", "", "ns", "formatDuration", "(J)Ljava/lang/String;", "okhttp"}, k = 2, mv = {1, 8, 0}, xi = 0x30)
public final class TaskLoggerKt {
    @NotNull
    public static final String formatDuration(long v) {
        if(Long.compare(v, -999500000L) <= 0) {
            return String.format("%6s", Arrays.copyOf(new Object[]{x.h((v - 500000000L) / 1000000000L, " s ", new StringBuilder())}, 1));
        }
        if(Long.compare(v, 0xFFFFFFFFFFF0BFB4L) <= 0) {
            return String.format("%6s", Arrays.copyOf(new Object[]{x.h((v - 500000L) / 1000000L, " ms", new StringBuilder())}, 1));
        }
        if(Long.compare(v, 0L) <= 0) {
            return String.format("%6s", Arrays.copyOf(new Object[]{x.h((v - 500L) / 1000L, " µs", new StringBuilder())}, 1));
        }
        if(v < 0xF404CL) {
            return String.format("%6s", Arrays.copyOf(new Object[]{x.h((v + 500L) / 1000L, " µs", new StringBuilder())}, 1));
        }
        return v >= 999500000L ? String.format("%6s", Arrays.copyOf(new Object[]{x.h((v + 500000000L) / 1000000000L, " s ", new StringBuilder())}, 1)) : String.format("%6s", Arrays.copyOf(new Object[]{x.h((v + 500000L) / 1000000L, " ms", new StringBuilder())}, 1));
    }

    private static final void log(Task task0, TaskQueue taskQueue0, String s) {
        TaskRunner.Companion.getLogger().fine(taskQueue0.getName$okhttp() + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{s}, 1)) + ": " + task0.getName());
    }

    public static final Object logElapsed(@NotNull Task task0, @NotNull TaskQueue taskQueue0, @NotNull a a0) {
        Object object0;
        long v;
        q.g(task0, "task");
        q.g(taskQueue0, "queue");
        q.g(a0, "block");
        boolean z = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if(z) {
            v = taskQueue0.getTaskRunner$okhttp().getBackend().nanoTime();
            TaskLoggerKt.log(task0, taskQueue0, "starting");
        }
        else {
            v = -1L;
        }
        try {
            object0 = a0.invoke();
        }
        catch(Throwable throwable0) {
            if(z) {
                TaskLoggerKt.log(task0, taskQueue0, "failed a run in " + TaskLoggerKt.formatDuration(taskQueue0.getTaskRunner$okhttp().getBackend().nanoTime() - v));
            }
            throw throwable0;
        }
        if(z) {
            TaskLoggerKt.log(task0, taskQueue0, "finished run in " + TaskLoggerKt.formatDuration(taskQueue0.getTaskRunner$okhttp().getBackend().nanoTime() - v));
        }
        return object0;
    }

    public static final void taskLog(@NotNull Task task0, @NotNull TaskQueue taskQueue0, @NotNull a a0) {
        q.g(task0, "task");
        q.g(taskQueue0, "queue");
        q.g(a0, "messageBlock");
        if(TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            TaskLoggerKt.log(task0, taskQueue0, ((String)a0.invoke()));
        }
    }
}

