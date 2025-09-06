package com.google.android.gms.internal.cast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbu implements OnFailureListener {
    public final TaskCompletionSource zza;

    public zzbu(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exception0) {
        zzbw.zzb(this.zza, exception0);
    }
}

