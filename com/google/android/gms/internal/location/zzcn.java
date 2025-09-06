package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcn extends zzcq {
    final GeofencingRequest zza;
    final PendingIntent zzb;

    public zzcn(zzcr zzcr0, GoogleApiClient googleApiClient0, GeofencingRequest geofencingRequest0, PendingIntent pendingIntent0) {
        this.zza = geofencingRequest0;
        this.zzb = pendingIntent0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(AnyClient api$AnyClient0) {
        TaskCompletionSource taskCompletionSource0 = zzcr.zza(this);
        ((zzdz)api$AnyClient0).zzE(this.zza, this.zzb, taskCompletionSource0);
    }
}

