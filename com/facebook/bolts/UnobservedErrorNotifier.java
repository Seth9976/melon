package com.facebook.bolts;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\bR\u001C\u0010\u0003\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0003\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/facebook/bolts/UnobservedErrorNotifier;", "", "Lcom/facebook/bolts/Task;", "task", "<init>", "(Lcom/facebook/bolts/Task;)V", "Lie/H;", "finalize", "()V", "setObserved", "Lcom/facebook/bolts/Task;", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class UnobservedErrorNotifier {
    @Nullable
    private Task task;

    public UnobservedErrorNotifier(@Nullable Task task0) {
        this.task = task0;
    }

    @Override
    public final void finalize() {
        Task task0 = this.task;
        if(task0 != null) {
            UnobservedExceptionHandler task$UnobservedExceptionHandler0 = Task.Companion.getUnobservedExceptionHandler();
            if(task$UnobservedExceptionHandler0 != null) {
                task$UnobservedExceptionHandler0.unobservedException(task0, new UnobservedTaskException(task0.getError()));
            }
        }
    }

    public final void setObserved() {
        this.task = null;
    }
}

