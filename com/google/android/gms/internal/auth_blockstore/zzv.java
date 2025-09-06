package com.google.android.gms.internal.auth_blockstore;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzv extends zzn {
    final TaskCompletionSource zza;

    public zzv(zzaa zzaa0, TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.auth_blockstore.zzo
    public final void zza(Status status0, int v) {
        TaskUtil.setResultOrApiException(status0, v, this.zza);
    }
}

