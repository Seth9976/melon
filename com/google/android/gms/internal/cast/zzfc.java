package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzfc extends zzfr {
    final TaskCompletionSource zza;

    public zzfc(zzfd zzfd0, TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.cast.zzfr
    public final void zzb(Status status0, zzfk zzfk0) {
        TaskUtil.setResultOrApiException(status0, new zzfe(new zzfq(Status.RESULT_SUCCESS, zzfk0)), this.zza);
    }
}

