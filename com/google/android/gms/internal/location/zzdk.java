package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdk extends zzy {
    final TaskCompletionSource zza;

    public zzdk(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.location.zzz
    public final void zzb(Status status0, Location location0) {
        TaskUtil.setResultOrApiException(status0, location0, this.zza);
    }
}

