package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdn extends zzq {
    final Object zza;
    final TaskCompletionSource zzb;

    public zzdn(Object object0, TaskCompletionSource taskCompletionSource0) {
        this.zza = object0;
        this.zzb = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.location.zzr
    public final void zzd(zzl zzl0) {
        TaskUtil.setResultOrApiException(zzl0.getStatus(), this.zza, this.zzb);
    }

    @Override  // com.google.android.gms.internal.location.zzr
    public final void zze() {
    }
}

