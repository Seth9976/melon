package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.location.zzw;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdd extends zzq {
    final TaskCompletionSource zza;
    final zzw zzb;

    public zzdd(TaskCompletionSource taskCompletionSource0, zzw zzw0) {
        this.zza = taskCompletionSource0;
        this.zzb = zzw0;
        super();
    }

    @Override  // com.google.android.gms.internal.location.zzr
    public final void zzd(zzl zzl0) {
        TaskUtil.setResultOrApiException(zzl0.getStatus(), this.zza);
    }

    @Override  // com.google.android.gms.internal.location.zzr
    public final void zze() {
        this.zzb.zzf();
    }
}

