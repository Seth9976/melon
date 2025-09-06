package com.google.android.gms.internal.location;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

final class zzea implements OnCompleteListener {
    private final TaskCompletionSource zza;

    public zzea(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task0) {
        if(!task0.isSuccessful()) {
            Exception exception0 = task0.getException();
            Objects.requireNonNull(exception0);
            this.zza.trySetException(exception0);
        }
    }
}

