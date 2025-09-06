package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u0003102B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000B\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u000B\u0010\nJ\u001F\u0010\u000E\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0015\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001A\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00100\u0019¢\u0006\u0004\b\u001A\u0010\u001BJ\r\u0010\u001C\u001A\u00020\b¢\u0006\u0004\b\u001C\u0010\u001DR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001E\u001A\u0004\b\u001F\u0010 R\u0016\u0010\"\u001A\u00020!8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001A\u00020$8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\'\u001A\u00020\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\'\u0010(R\u001A\u0010*\u001A\b\u0012\u0004\u0012\u00020\u00100)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001A\u0010,\u001A\b\u0012\u0004\u0012\u00020\u00100)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010.\u001A\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00063"}, d2 = {"Lokhttp3/internal/concurrent/TaskRunner;", "", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "backend", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner$Backend;)V", "Lokhttp3/internal/concurrent/Task;", "task", "Lie/H;", "beforeRun", "(Lokhttp3/internal/concurrent/Task;)V", "runTask", "", "delayNanos", "afterRun", "(Lokhttp3/internal/concurrent/Task;J)V", "Lokhttp3/internal/concurrent/TaskQueue;", "taskQueue", "kickCoordinator$okhttp", "(Lokhttp3/internal/concurrent/TaskQueue;)V", "kickCoordinator", "awaitTaskToRun", "()Lokhttp3/internal/concurrent/Task;", "newQueue", "()Lokhttp3/internal/concurrent/TaskQueue;", "", "activeQueues", "()Ljava/util/List;", "cancelAll", "()V", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "getBackend", "()Lokhttp3/internal/concurrent/TaskRunner$Backend;", "", "nextQueueName", "I", "", "coordinatorWaiting", "Z", "coordinatorWakeUpAt", "J", "", "busyQueues", "Ljava/util/List;", "readyQueues", "Ljava/lang/Runnable;", "runnable", "Ljava/lang/Runnable;", "Companion", "Backend", "RealBackend", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class TaskRunner {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u001F\u0010\f\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u0007H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u000EH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/concurrent/TaskRunner$Backend;", "", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "Lie/H;", "beforeTask", "(Lokhttp3/internal/concurrent/TaskRunner;)V", "", "nanoTime", "()J", "coordinatorNotify", "nanos", "coordinatorWait", "(Lokhttp3/internal/concurrent/TaskRunner;J)V", "Ljava/lang/Runnable;", "runnable", "execute", "(Ljava/lang/Runnable;)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface Backend {
        void beforeTask(@NotNull TaskRunner arg1);

        void coordinatorNotify(@NotNull TaskRunner arg1);

        void coordinatorWait(@NotNull TaskRunner arg1, long arg2);

        void execute(@NotNull Runnable arg1);

        long nanoTime();
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/concurrent/TaskRunner$Companion;", "", "()V", "INSTANCE", "Lokhttp3/internal/concurrent/TaskRunner;", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Logger getLogger() {
            return TaskRunner.logger;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000E\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u000E\u0010\nJ\u001F\u0010\u0010\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001A\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001A\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lokhttp3/internal/concurrent/TaskRunner$RealBackend;", "Lokhttp3/internal/concurrent/TaskRunner$Backend;", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "<init>", "(Ljava/util/concurrent/ThreadFactory;)V", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "Lie/H;", "beforeTask", "(Lokhttp3/internal/concurrent/TaskRunner;)V", "", "nanoTime", "()J", "coordinatorNotify", "nanos", "coordinatorWait", "(Lokhttp3/internal/concurrent/TaskRunner;J)V", "Ljava/lang/Runnable;", "runnable", "execute", "(Ljava/lang/Runnable;)V", "shutdown", "()V", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class RealBackend implements Backend {
        @NotNull
        private final ThreadPoolExecutor executor;

        public RealBackend(@NotNull ThreadFactory threadFactory0) {
            q.g(threadFactory0, "threadFactory");
            super();
            this.executor = new ThreadPoolExecutor(0, 0x7FFFFFFF, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory0);
        }

        @Override  // okhttp3.internal.concurrent.TaskRunner$Backend
        public void beforeTask(@NotNull TaskRunner taskRunner0) {
            q.g(taskRunner0, "taskRunner");
        }

        @Override  // okhttp3.internal.concurrent.TaskRunner$Backend
        public void coordinatorNotify(@NotNull TaskRunner taskRunner0) {
            q.g(taskRunner0, "taskRunner");
            taskRunner0.notify();
        }

        @Override  // okhttp3.internal.concurrent.TaskRunner$Backend
        public void coordinatorWait(@NotNull TaskRunner taskRunner0, long v) {
            q.g(taskRunner0, "taskRunner");
            if(v / 1000000L <= 0L && v <= 0L) {
                return;
            }
            taskRunner0.wait(v / 1000000L, ((int)(v - 1000000L * (v / 1000000L))));
        }

        @Override  // okhttp3.internal.concurrent.TaskRunner$Backend
        public void execute(@NotNull Runnable runnable0) {
            q.g(runnable0, "runnable");
            this.executor.execute(runnable0);
        }

        @Override  // okhttp3.internal.concurrent.TaskRunner$Backend
        public long nanoTime() {
            return System.nanoTime();
        }

        public final void shutdown() {
            this.executor.shutdown();
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final TaskRunner INSTANCE;
    @NotNull
    private final Backend backend;
    @NotNull
    private final List busyQueues;
    private boolean coordinatorWaiting;
    private long coordinatorWakeUpAt;
    @NotNull
    private static final Logger logger;
    private int nextQueueName;
    @NotNull
    private final List readyQueues;
    @NotNull
    private final Runnable runnable;

    static {
        TaskRunner.Companion = new Companion(null);
        TaskRunner.INSTANCE = new TaskRunner(new RealBackend(Util.threadFactory("OkHttp TaskRunner", true)));
        Logger logger0 = Logger.getLogger("okhttp3.internal.concurrent.TaskRunner");
        q.f(logger0, "getLogger(TaskRunner::class.java.name)");
        TaskRunner.logger = logger0;
    }

    public TaskRunner(@NotNull Backend taskRunner$Backend0) {
        q.g(taskRunner$Backend0, "backend");
        super();
        this.backend = taskRunner$Backend0;
        this.nextQueueName = 10000;
        this.busyQueues = new ArrayList();
        this.readyQueues = new ArrayList();
        this.runnable = new Runnable() {
            @Override
            public void run() {
                Task task0;
                long v1;
                while(true) {
                    synchronized(TaskRunner.this) {
                        task0 = TaskRunner.this.awaitTaskToRun();
                    }
                    if(task0 == null) {
                        return;
                    }
                    TaskQueue taskQueue0 = task0.getQueue$okhttp();
                    q.d(taskQueue0);
                    TaskRunner taskRunner0 = TaskRunner.this;
                    boolean z = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
                    if(z) {
                        v1 = taskQueue0.getTaskRunner$okhttp().getBackend().nanoTime();
                        TaskLoggerKt.log(task0, taskQueue0, "starting");
                    }
                    else {
                        v1 = -1L;
                    }
                    try {
                        taskRunner0.runTask(task0);
                        if(!z) {
                            continue;
                        }
                    }
                    catch(Throwable throwable0) {
                        try {
                            taskRunner0.getBackend().execute(this);
                            throw throwable0;
                        }
                        catch(Throwable throwable1) {
                            if(z) {
                                TaskLoggerKt.log(task0, taskQueue0, "failed a run in " + TaskLoggerKt.formatDuration(taskQueue0.getTaskRunner$okhttp().getBackend().nanoTime() - v1));
                            }
                            throw throwable1;
                        }
                    }
                    TaskLoggerKt.log(task0, taskQueue0, "finished run in " + TaskLoggerKt.formatDuration(taskQueue0.getTaskRunner$okhttp().getBackend().nanoTime() - v1));
                }
            }
        };
    }

    @NotNull
    public final List activeQueues() {
        synchronized(this) {
            return p.A0(this.busyQueues, this.readyQueues);
        }
    }

    private final void afterRun(Task task0, long v) {
        if(Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2447 MUST hold lock on " + this);
        }
        TaskQueue taskQueue0 = task0.getQueue$okhttp();
        q.d(taskQueue0);
        if(taskQueue0.getActiveTask$okhttp() != task0) {
            throw new IllegalStateException("Check failed.");
        }
        taskQueue0.setCancelActiveTask$okhttp(false);
        taskQueue0.setActiveTask$okhttp(null);
        this.busyQueues.remove(taskQueue0);
        if(v != -1L && !taskQueue0.getCancelActiveTask$okhttp() && !taskQueue0.getShutdown$okhttp()) {
            taskQueue0.scheduleAndDecide$okhttp(task0, v, true);
        }
        if(!taskQueue0.getFutureTasks$okhttp().isEmpty()) {
            this.readyQueues.add(taskQueue0);
        }
    }

    @Nullable
    public final Task awaitTaskToRun() {
        if(Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2435 MUST hold lock on " + this);
        }
        while(true) {
            if(this.readyQueues.isEmpty()) {
                return null;
            }
            long v = this.backend.nanoTime();
            long v1 = 0x7FFFFFFFFFFFFFFFL;
            Task task0 = null;
            Iterator iterator0 = this.readyQueues.iterator();
            while(true) {
                boolean z = false;
                if(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    Task task1 = (Task)((TaskQueue)object0).getFutureTasks$okhttp().get(0);
                    long v2 = Math.max(0L, task1.getNextExecuteNanoTime$okhttp() - v);
                    if(v2 > 0L) {
                        v1 = Math.min(v2, v1);
                        continue;
                    }
                    else if(task0 == null) {
                        task0 = task1;
                        continue;
                    }
                    else {
                        z = true;
                    }
                }
                break;
            }
            if(task0 != null) {
                this.beforeRun(task0);
                if(z || !this.coordinatorWaiting && !this.readyQueues.isEmpty()) {
                    this.backend.execute(this.runnable);
                }
                return task0;
            }
            if(this.coordinatorWaiting) {
                if(v1 < this.coordinatorWakeUpAt - v) {
                    this.backend.coordinatorNotify(this);
                }
                return null;
            }
            try {
                this.coordinatorWaiting = true;
                this.coordinatorWakeUpAt = v + v1;
                this.backend.coordinatorWait(this, v1);
            }
            catch(InterruptedException unused_ex) {
                this.cancelAll();
            }
            finally {
                this.coordinatorWaiting = false;
            }
        }
    }

    private final void beforeRun(Task task0) {
        if(Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2437 MUST hold lock on " + this);
        }
        task0.setNextExecuteNanoTime$okhttp(-1L);
        TaskQueue taskQueue0 = task0.getQueue$okhttp();
        q.d(taskQueue0);
        taskQueue0.getFutureTasks$okhttp().remove(task0);
        this.readyQueues.remove(taskQueue0);
        taskQueue0.setActiveTask$okhttp(task0);
        this.busyQueues.add(taskQueue0);
    }

    public final void cancelAll() {
        for(int v = this.busyQueues.size() - 1; -1 < v; --v) {
            ((TaskQueue)this.busyQueues.get(v)).cancelAllAndDecide$okhttp();
        }
        for(int v1 = this.readyQueues.size() - 1; -1 < v1; --v1) {
            TaskQueue taskQueue0 = (TaskQueue)this.readyQueues.get(v1);
            taskQueue0.cancelAllAndDecide$okhttp();
            if(taskQueue0.getFutureTasks$okhttp().isEmpty()) {
                this.readyQueues.remove(v1);
            }
        }
    }

    @NotNull
    public final Backend getBackend() {
        return this.backend;
    }

    public final void kickCoordinator$okhttp(@NotNull TaskQueue taskQueue0) {
        q.g(taskQueue0, "taskQueue");
        if(Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2434 MUST hold lock on " + this);
        }
        if(taskQueue0.getActiveTask$okhttp() == null) {
            if(taskQueue0.getFutureTasks$okhttp().isEmpty()) {
                this.readyQueues.remove(taskQueue0);
            }
            else {
                Util.addIfAbsent(this.readyQueues, taskQueue0);
            }
        }
        if(this.coordinatorWaiting) {
            this.backend.coordinatorNotify(this);
            return;
        }
        this.backend.execute(this.runnable);
    }

    @NotNull
    public final TaskQueue newQueue() {
        int v;
        synchronized(this) {
            v = this.nextQueueName;
            this.nextQueueName = v + 1;
        }
        return new TaskQueue(this, "Q" + v);
    }

    private final void runTask(Task task0) {
        long v;
        if(Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2436 MUST NOT hold lock on " + this);
        }
        Thread thread0 = Thread.currentThread();
        thread0.setName(task0.getName());
        try {
            v = task0.runOnce();
        }
        catch(Throwable throwable0) {
            synchronized(this) {
                this.afterRun(task0, -1L);
            }
            thread0.setName("jeb-dexdec-sb-st-2436");
            throw throwable0;
        }
        synchronized(this) {
            this.afterRun(task0, v);
        }
        thread0.setName("jeb-dexdec-sb-st-2436");
    }
}

