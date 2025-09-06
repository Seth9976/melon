package com.facebook.bolts;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001A\u00020\u00052\b\u0010\b\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\t\u0010\nJ\u001D\u0010\u000E\u001A\u00020\u00052\u000E\u0010\r\u001A\n\u0018\u00010\u000Bj\u0004\u0018\u0001`\f¢\u0006\u0004\b\u000E\u0010\u000FJ\r\u0010\u0011\u001A\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0004J\u0017\u0010\u0012\u001A\u00020\u00102\b\u0010\b\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001D\u0010\u0014\u001A\u00020\u00102\u000E\u0010\r\u001A\n\u0018\u00010\u000Bj\u0004\u0018\u0001`\f¢\u0006\u0004\b\u0014\u0010\u0015R\u001D\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lcom/facebook/bolts/TaskCompletionSource;", "TResult", "", "<init>", "()V", "", "trySetCancelled", "()Z", "result", "trySetResult", "(Ljava/lang/Object;)Z", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "trySetError", "(Ljava/lang/Exception;)Z", "Lie/H;", "setCancelled", "setResult", "(Ljava/lang/Object;)V", "setError", "(Ljava/lang/Exception;)V", "Lcom/facebook/bolts/Task;", "task", "Lcom/facebook/bolts/Task;", "getTask", "()Lcom/facebook/bolts/Task;", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class TaskCompletionSource {
    @NotNull
    private final Task task;

    public TaskCompletionSource() {
        this.task = new Task();
    }

    @NotNull
    public final Task getTask() {
        return this.task;
    }

    public final void setCancelled() {
        if(!this.trySetCancelled()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public final void setError(@Nullable Exception exception0) {
        if(!this.trySetError(exception0)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public final void setResult(@Nullable Object object0) {
        if(!this.trySetResult(object0)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public final boolean trySetCancelled() {
        return this.task.trySetCancelled();
    }

    public final boolean trySetError(@Nullable Exception exception0) {
        return this.task.trySetError(exception0);
    }

    public final boolean trySetResult(@Nullable Object object0) {
        return this.task.trySetResult(object0);
    }
}

