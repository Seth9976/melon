package com.google.android.gms.internal.auth_blockstore;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzx extends zze {
    final TaskCompletionSource zza;

    public zzx(zzaa zzaa0, TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.auth_blockstore.zze
    public final void zza(Status status0, byte[] arr_b) {
        TaskUtil.setResultOrApiException(status0, arr_b, this.zza);
    }
}

