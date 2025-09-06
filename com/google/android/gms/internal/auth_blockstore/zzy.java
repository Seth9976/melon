package com.google.android.gms.internal.auth_blockstore;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzy extends zzh {
    final TaskCompletionSource zza;

    public zzy(zzaa zzaa0, TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.auth_blockstore.zzi
    public final void zza(Status status0, boolean z) {
        TaskUtil.setResultOrApiException(status0, Boolean.valueOf(z), this.zza);
    }
}

