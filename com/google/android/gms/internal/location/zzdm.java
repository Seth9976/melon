package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdm extends zzn {
    final TaskCompletionSource zza;

    public zzdm(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.location.zzo
    public final void zzb(Status status0, boolean z) {
        TaskUtil.setResultOrApiException(status0, Boolean.valueOf(z), this.zza);
    }
}

