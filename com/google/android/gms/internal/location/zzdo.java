package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.location.zzz;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdo extends zzq {
    final TaskCompletionSource zza;
    final zzz zzb;

    public zzdo(TaskCompletionSource taskCompletionSource0, zzz zzz0) {
        this.zza = taskCompletionSource0;
        this.zzb = zzz0;
        super();
    }

    @Override  // com.google.android.gms.internal.location.zzr
    public final void zzd(zzl zzl0) {
        TaskUtil.setResultOrApiException(zzl0.getStatus(), this.zza);
    }

    @Override  // com.google.android.gms.internal.location.zzr
    public final void zze() {
        this.zzb.zze();
    }
}

