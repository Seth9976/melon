package com.google.android.gms.internal.cast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbt implements OnSuccessListener {
    public final TaskCompletionSource zza;

    public zzbt(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override  // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object object0) {
        boolean z = ((zzfe)object0) != null && ((zzfe)object0).zza();
        this.zza.trySetResult(Boolean.valueOf(z));
    }
}

