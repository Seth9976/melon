package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationListener;

final class zzau extends zzba {
    final LocationListener zza;

    public zzau(zzbb zzbb0, GoogleApiClient googleApiClient0, LocationListener locationListener0) {
        this.zza = locationListener0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(AnyClient api$AnyClient0) {
        ((zzdz)api$AnyClient0).zzv(ListenerHolders.createListenerKey(this.zza, "LocationListener"), true, zzbb.zza(this));
    }
}

