package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback.Stub;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdj extends Stub {
    final Object zza;
    final TaskCompletionSource zzb;

    public zzdj(Object object0, TaskCompletionSource taskCompletionSource0) {
        this.zza = object0;
        this.zzb = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status0) {
        TaskUtil.setResultOrApiException(status0, this.zza, this.zzb);
    }
}

