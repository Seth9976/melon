package com.google.android.gms.cast.framework;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzf implements OnFailureListener {
    public final TaskCompletionSource zza;

    public zzf(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exception0) {
        this.zza.setException(exception0);
    }
}

