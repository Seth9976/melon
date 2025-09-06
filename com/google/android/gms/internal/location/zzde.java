package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzde extends zzaa {
    final TaskCompletionSource zza;

    public zzde(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.location.zzab
    public final void zzb(LocationSettingsResult locationSettingsResult0) {
        TaskUtil.setResultOrApiException(locationSettingsResult0.getStatus(), new LocationSettingsResponse(locationSettingsResult0), this.zza);
    }
}

