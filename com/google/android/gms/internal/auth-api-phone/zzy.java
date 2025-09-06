package com.google.android.gms.internal.auth-api-phone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzy extends zzi {
    final TaskCompletionSource zza;

    public zzy(zzz zzz0, TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.auth-api-phone.zzj
    public final void zzb(Status status0, boolean z) {
        TaskUtil.setResultOrApiException(status0, Boolean.valueOf(z), this.zza);
    }
}

