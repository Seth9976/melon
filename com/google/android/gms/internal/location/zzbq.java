package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

final class zzbq implements Continuation {
    private final TaskCompletionSource zza;

    public zzbq(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.tasks.Continuation
    public final Object then(Task task0) {
        TaskCompletionSource taskCompletionSource0 = this.zza;
        if(task0.isSuccessful()) {
            taskCompletionSource0.trySetResult(((Location)task0.getResult()));
            return null;
        }
        Exception exception0 = task0.getException();
        Objects.requireNonNull(exception0);
        taskCompletionSource0.trySetException(exception0);
        return null;
    }
}

