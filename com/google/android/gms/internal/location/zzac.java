package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

final class zzac extends zzae {
    final long zza;
    final PendingIntent zzb;

    public zzac(zzaf zzaf0, GoogleApiClient googleApiClient0, long v, PendingIntent pendingIntent0) {
        this.zza = v;
        this.zzb = pendingIntent0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(AnyClient api$AnyClient0) {
        Preconditions.checkNotNull(this.zzb);
        Preconditions.checkArgument(Long.compare(this.zza, 0L) >= 0, "detectionIntervalMillis must be >= 0");
        ((zzv)((zzg)api$AnyClient0).getService()).zzh(this.zza, true, this.zzb);
        this.setResult(Status.RESULT_SUCCESS);
    }
}

