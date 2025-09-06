package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbn extends zzbd {
    final TaskCompletionSource zza;

    public zzbn(zzbo zzbo0, TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.auth.zzbd
    public final void zzc(String s) {
        TaskUtil.setResultOrApiException((s == null ? new Status(3006) : Status.RESULT_SUCCESS), s, this.zza);
    }
}

