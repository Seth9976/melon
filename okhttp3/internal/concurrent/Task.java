package okhttp3.internal.concurrent;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0010\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000BH\u0000¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001A\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R$\u0010\f\u001A\u0004\u0018\u00010\u000B8\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\f\u0010\u0018\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u000FR\"\u0010\u001C\u001A\u00020\b8\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\n\"\u0004\b\u001F\u0010 ¨\u0006!"}, d2 = {"Lokhttp3/internal/concurrent/Task;", "", "", "name", "", "cancelable", "<init>", "(Ljava/lang/String;Z)V", "", "runOnce", "()J", "Lokhttp3/internal/concurrent/TaskQueue;", "queue", "Lie/H;", "initQueue$okhttp", "(Lokhttp3/internal/concurrent/TaskQueue;)V", "initQueue", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getName", "Z", "getCancelable", "()Z", "Lokhttp3/internal/concurrent/TaskQueue;", "getQueue$okhttp", "()Lokhttp3/internal/concurrent/TaskQueue;", "setQueue$okhttp", "nextExecuteNanoTime", "J", "getNextExecuteNanoTime$okhttp", "setNextExecuteNanoTime$okhttp", "(J)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class Task {
    private final boolean cancelable;
    @NotNull
    private final String name;
    private long nextExecuteNanoTime;
    @Nullable
    private TaskQueue queue;

    public Task(@NotNull String s, boolean z) {
        q.g(s, "name");
        super();
        this.name = s;
        this.cancelable = z;
        this.nextExecuteNanoTime = -1L;
    }

    public Task(String s, boolean z, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            z = true;
        }
        this(s, z);
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final long getNextExecuteNanoTime$okhttp() {
        return this.nextExecuteNanoTime;
    }

    @Nullable
    public final TaskQueue getQueue$okhttp() {
        return this.queue;
    }

    public final void initQueue$okhttp(@NotNull TaskQueue taskQueue0) {
        q.g(taskQueue0, "queue");
        TaskQueue taskQueue1 = this.queue;
        if(taskQueue1 == taskQueue0) {
            return;
        }
        if(taskQueue1 != null) {
            throw new IllegalStateException("task is in multiple queues");
        }
        this.queue = taskQueue0;
    }

    public abstract long runOnce();

    public final void setNextExecuteNanoTime$okhttp(long v) {
        this.nextExecuteNanoTime = v;
    }

    public final void setQueue$okhttp(@Nullable TaskQueue taskQueue0) {
        this.queue = taskQueue0;
    }

    @Override
    @NotNull
    public String toString() {
        return this.name;
    }
}

