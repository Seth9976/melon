package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdl extends zzw {
    final TaskCompletionSource zza;

    public zzdl(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.location.zzx
    public final void zzb(Status status0, LocationAvailability locationAvailability0) {
        TaskUtil.setResultOrApiException(status0, locationAvailability0, this.zza);
    }
}

