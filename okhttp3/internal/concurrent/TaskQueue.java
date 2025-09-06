package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001D\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001?B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\r\u0010\u000EJ5\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u000B\u001A\u00020\n2\u000E\b\u0004\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\n0\u000FH\u0086\b\u00F8\u0001\u0000\u00A2\u0006\u0004\b\r\u0010\u0011J?\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u000B\u001A\u00020\n2\b\b\u0002\u0010\u0013\u001A\u00020\u00122\u000E\b\u0004\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\f0\u000FH\u0086\b\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001A\u00020\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\'\u0010\u001C\u001A\u00020\u00122\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0019\u001A\u00020\u0012H\u0000\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\r\u0010\u001D\u001A\u00020\f\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\r\u0010\u001F\u001A\u00020\f\u00A2\u0006\u0004\b\u001F\u0010\u001EJ\u000F\u0010\"\u001A\u00020\u0012H\u0000\u00A2\u0006\u0004\b \u0010!J\u000F\u0010#\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b#\u0010$R\u001A\u0010\u0003\u001A\u00020\u00028\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u0003\u0010%\u001A\u0004\b&\u0010\'R\u001A\u0010\u0005\u001A\u00020\u00048\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u0005\u0010(\u001A\u0004\b)\u0010$R\"\u0010\u001F\u001A\u00020\u00128\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\u001F\u0010*\u001A\u0004\b+\u0010!\"\u0004\b,\u0010-R$\u0010.\u001A\u0004\u0018\u00010\b8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b.\u0010/\u001A\u0004\b0\u00101\"\u0004\b2\u00103R \u00105\u001A\b\u0012\u0004\u0012\u00020\b048\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b5\u00106\u001A\u0004\b7\u00108R\"\u00109\u001A\u00020\u00128\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b9\u0010*\u001A\u0004\b:\u0010!\"\u0004\b;\u0010-R\u0017\u0010>\u001A\b\u0012\u0004\u0012\u00020\b0<8F\u00A2\u0006\u0006\u001A\u0004\b=\u00108\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00A8\u0006@"}, d2 = {"Lokhttp3/internal/concurrent/TaskQueue;", "", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "", "name", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Ljava/lang/String;)V", "Lokhttp3/internal/concurrent/Task;", "task", "", "delayNanos", "Lie/H;", "schedule", "(Lokhttp3/internal/concurrent/Task;J)V", "Lkotlin/Function0;", "block", "(Ljava/lang/String;JLwe/a;)V", "", "cancelable", "execute", "(Ljava/lang/String;JZLwe/a;)V", "Ljava/util/concurrent/CountDownLatch;", "idleLatch", "()Ljava/util/concurrent/CountDownLatch;", "recurrence", "scheduleAndDecide$okhttp", "(Lokhttp3/internal/concurrent/Task;JZ)Z", "scheduleAndDecide", "cancelAll", "()V", "shutdown", "cancelAllAndDecide$okhttp", "()Z", "cancelAllAndDecide", "toString", "()Ljava/lang/String;", "Lokhttp3/internal/concurrent/TaskRunner;", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "Ljava/lang/String;", "getName$okhttp", "Z", "getShutdown$okhttp", "setShutdown$okhttp", "(Z)V", "activeTask", "Lokhttp3/internal/concurrent/Task;", "getActiveTask$okhttp", "()Lokhttp3/internal/concurrent/Task;", "setActiveTask$okhttp", "(Lokhttp3/internal/concurrent/Task;)V", "", "futureTasks", "Ljava/util/List;", "getFutureTasks$okhttp", "()Ljava/util/List;", "cancelActiveTask", "getCancelActiveTask$okhttp", "setCancelActiveTask$okhttp", "", "getScheduledTasks", "scheduledTasks", "AwaitIdleTask", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class TaskQueue {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001A\u00020\bH\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lokhttp3/internal/concurrent/TaskQueue$AwaitIdleTask;", "Lokhttp3/internal/concurrent/Task;", "()V", "latch", "Ljava/util/concurrent/CountDownLatch;", "getLatch", "()Ljava/util/concurrent/CountDownLatch;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class AwaitIdleTask extends Task {
        @NotNull
        private final CountDownLatch latch;

        public AwaitIdleTask() {
            super("OkHttp awaitIdle", false);
            this.latch = new CountDownLatch(1);
        }

        @NotNull
        public final CountDownLatch getLatch() {
            return this.latch;
        }

        @Override  // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.latch.countDown();
            return -1L;
        }
    }

    @Nullable
    private Task activeTask;
    private boolean cancelActiveTask;
    @NotNull
    private final List futureTasks;
    @NotNull
    private final String name;
    private boolean shutdown;
    @NotNull
    private final TaskRunner taskRunner;

    public TaskQueue(@NotNull TaskRunner taskRunner0, @NotNull String s) {
        q.g(taskRunner0, "taskRunner");
        q.g(s, "name");
        super();
        this.taskRunner = taskRunner0;
        this.name = s;
        this.futureTasks = new ArrayList();
    }

    public final void cancelAll() {
        if(Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2410 MUST NOT hold lock on " + this);
        }
        synchronized(this.taskRunner) {
            if(this.cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
        }
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task0 = this.activeTask;
        if(task0 != null) {
            q.d(task0);
            if(task0.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        int v = this.futureTasks.size() - 1;
        boolean z = false;
        while(-1 < v) {
            if(((Task)this.futureTasks.get(v)).getCancelable()) {
                Task task1 = (Task)this.futureTasks.get(v);
                if(TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task1, this, "canceled");
                }
                this.futureTasks.remove(v);
                z = true;
            }
            --v;
        }
        return z;
    }

    public final void execute(@NotNull String s, long v, boolean z, @NotNull a a0) {
        q.g(s, "name");
        q.g(a0, "block");
        this.schedule(new Task(z, a0) {
            @Override  // okhttp3.internal.concurrent.Task
            public long runOnce() {
                this.$block.invoke();
                return -1L;
            }
        }, v);
    }

    public static void execute$default(TaskQueue taskQueue0, String s, long v, boolean z, a a0, int v1, Object object0) {
        if((v1 & 2) != 0) {
            v = 0L;
        }
        if((v1 & 4) != 0) {
            z = true;
        }
        q.g(s, "name");
        q.g(a0, "block");
        taskQueue0.schedule(new okhttp3.internal.concurrent.TaskQueue.execute.1(s, z, a0), v);
    }

    @Nullable
    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    @NotNull
    public final List getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    @NotNull
    public final String getName$okhttp() {
        return this.name;
    }

    @NotNull
    public final List getScheduledTasks() {
        synchronized(this.taskRunner) {
            return p.P0(this.futureTasks);
        }
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    @NotNull
    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    @NotNull
    public final CountDownLatch idleLatch() {
        AwaitIdleTask taskQueue$AwaitIdleTask0;
        synchronized(this.taskRunner) {
            if(this.activeTask == null && this.futureTasks.isEmpty()) {
                return new CountDownLatch(0);
            }
            Task task0 = this.activeTask;
            if(task0 instanceof AwaitIdleTask) {
                return ((AwaitIdleTask)task0).getLatch();
            }
            for(Object object0: this.futureTasks) {
                Task task1 = (Task)object0;
                if(task1 instanceof AwaitIdleTask) {
                    return ((AwaitIdleTask)task1).getLatch();
                }
                if(false) {
                    break;
                }
            }
            taskQueue$AwaitIdleTask0 = new AwaitIdleTask();
            if(this.scheduleAndDecide$okhttp(taskQueue$AwaitIdleTask0, 0L, false)) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
        }
        return taskQueue$AwaitIdleTask0.getLatch();
    }

    public final void schedule(@NotNull String s, long v, @NotNull a a0) {
        q.g(s, "name");
        q.g(a0, "block");
        this.schedule(new Task(a0) {
            final a $block;

            {
                this.$block = a0;
                super(s, false, 2, null);
            }

            @Override  // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return ((Number)this.$block.invoke()).longValue();
            }
        }, v);
    }

    public final void schedule(@NotNull Task task0, long v) {
        q.g(task0, "task");
        synchronized(this.taskRunner) {
            if(this.shutdown) {
                if(task0.getCancelable()) {
                    if(TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                        TaskLoggerKt.log(task0, this, "schedule canceled (queue is shutdown)");
                    }
                    return;
                }
                if(TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task0, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
            if(this.scheduleAndDecide$okhttp(task0, v, false)) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
        }
    }

    public static void schedule$default(TaskQueue taskQueue0, String s, long v, a a0, int v1, Object object0) {
        if((v1 & 2) != 0) {
            v = 0L;
        }
        q.g(s, "name");
        q.g(a0, "block");
        taskQueue0.schedule(new okhttp3.internal.concurrent.TaskQueue.schedule.2(s, a0), v);
    }

    public static void schedule$default(TaskQueue taskQueue0, Task task0, long v, int v1, Object object0) {
        if((v1 & 2) != 0) {
            v = 0L;
        }
        taskQueue0.schedule(task0, v);
    }

    public final boolean scheduleAndDecide$okhttp(@NotNull Task task0, long v, boolean z) {
        q.g(task0, "task");
        task0.initQueue$okhttp(this);
        long v1 = this.taskRunner.getBackend().nanoTime();
        long v2 = v1 + v;
        int v3 = this.futureTasks.indexOf(task0);
        if(v3 != -1) {
            if(task0.getNextExecuteNanoTime$okhttp() <= v2) {
                if(TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task0, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(v3);
        }
        task0.setNextExecuteNanoTime$okhttp(v2);
        if(TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            TaskLoggerKt.log(task0, this, (z ? "run again after " + TaskLoggerKt.formatDuration(v2 - v1) : "scheduled after " + TaskLoggerKt.formatDuration(v2 - v1)));
        }
        int v4 = 0;
        Iterator iterator0 = this.futureTasks.iterator();
        while(true) {
            if(!iterator0.hasNext()) {
                v4 = -1;
                break;
            }
            Object object0 = iterator0.next();
            if(((Task)object0).getNextExecuteNanoTime$okhttp() - v1 > v) {
                break;
            }
            ++v4;
        }
        if(v4 == -1) {
            v4 = this.futureTasks.size();
        }
        this.futureTasks.add(v4, task0);
        return v4 == 0;
    }

    public final void setActiveTask$okhttp(@Nullable Task task0) {
        this.activeTask = task0;
    }

    public final void setCancelActiveTask$okhttp(boolean z) {
        this.cancelActiveTask = z;
    }

    public final void setShutdown$okhttp(boolean z) {
        this.shutdown = z;
    }

    public final void shutdown() {
        if(Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2410 MUST NOT hold lock on " + this);
        }
        synchronized(this.taskRunner) {
            this.shutdown = true;
            if(this.cancelAllAndDecide$okhttp()) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
        }
    }

    @Override
    @NotNull
    public String toString() {
        return this.name;
    }
}

