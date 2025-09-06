package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzat extends zzba {
    final PendingIntent zza;
    final LocationRequest zzb;

    public zzat(zzbb zzbb0, GoogleApiClient googleApiClient0, PendingIntent pendingIntent0, LocationRequest locationRequest0) {
        this.zza = pendingIntent0;
        this.zzb = locationRequest0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(AnyClient api$AnyClient0) {
        TaskCompletionSource taskCompletionSource0 = zzbb.zza(this);
        ((zzdz)api$AnyClient0).zzu(this.zza, this.zzb, taskCompletionSource0);
    }
}

