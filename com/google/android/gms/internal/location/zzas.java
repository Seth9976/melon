package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzas extends zzba {
    final ListenerHolder zza;
    final LocationRequest zzb;

    public zzas(zzbb zzbb0, GoogleApiClient googleApiClient0, ListenerHolder listenerHolder0, LocationRequest locationRequest0) {
        this.zza = listenerHolder0;
        this.zzb = locationRequest0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(AnyClient api$AnyClient0) {
        zzaz zzaz0 = new zzaz(this.zza);
        TaskCompletionSource taskCompletionSource0 = zzbb.zza(this);
        ((zzdz)api$AnyClient0).zzt(zzaz0, this.zzb, taskCompletionSource0);
    }
}

