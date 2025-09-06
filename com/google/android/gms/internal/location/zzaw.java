package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationCallback;

final class zzaw extends zzba {
    final LocationCallback zza;

    public zzaw(zzbb zzbb0, GoogleApiClient googleApiClient0, LocationCallback locationCallback0) {
        this.zza = locationCallback0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(AnyClient api$AnyClient0) {
        ((zzdz)api$AnyClient0).zzw(ListenerHolders.createListenerKey(this.zza, "LocationCallback"), true, zzbb.zza(this));
    }
}

