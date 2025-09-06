package com.google.android.gms.internal.auth_blockstore;

import com.google.android.gms.auth.blockstore.RetrieveBytesResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzw extends zze {
    final TaskCompletionSource zza;

    public zzw(zzaa zzaa0, TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.auth_blockstore.zze
    public final void zzb(Status status0, RetrieveBytesResponse retrieveBytesResponse0) {
        TaskUtil.setResultOrApiException(status0, retrieveBytesResponse0, this.zza);
    }
}

