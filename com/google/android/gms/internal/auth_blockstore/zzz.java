package com.google.android.gms.internal.auth_blockstore;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzz extends zzj {
    final TaskCompletionSource zza;

    public zzz(zzaa zzaa0, TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.auth_blockstore.zzk
    public final void zza(Status status0, boolean z) {
        TaskUtil.setResultOrApiException(status0, Boolean.valueOf(z), this.zza);
    }
}

