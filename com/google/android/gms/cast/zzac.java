package com.google.android.gms.cast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzac extends zzad {
    final TaskCompletionSource zza;
    final CastRemoteDisplayClient zzb;

    public zzac(CastRemoteDisplayClient castRemoteDisplayClient0, TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        this.zzb = castRemoteDisplayClient0;
        super(null);
    }

    @Override  // com.google.android.gms.cast.zzad
    public final void zzd(int v) {
        this.zzb.zzc.d("onError: %d", new Object[]{v});
        CastRemoteDisplayClient.zzd(this.zzb);
        TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, this.zza);
    }

    @Override  // com.google.android.gms.cast.zzad
    public final void zzf() {
        this.zzb.zzc.d("onDisconnected", new Object[0]);
        CastRemoteDisplayClient.zzd(this.zzb);
        TaskUtil.setResultOrApiException(Status.RESULT_SUCCESS, this.zza);
    }
}

