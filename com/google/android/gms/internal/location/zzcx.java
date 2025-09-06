package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationSettingsRequest;

final class zzcx extends zzcy {
    final LocationSettingsRequest zza;

    public zzcx(zzcz zzcz0, GoogleApiClient googleApiClient0, LocationSettingsRequest locationSettingsRequest0, String s) {
        this.zza = locationSettingsRequest0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(AnyClient api$AnyClient0) {
        Preconditions.checkArgument(this.zza != null, "locationSettingsRequest can\'t be null");
        ((zzv)((zzdz)api$AnyClient0).getService()).zzD(this.zza, new zzdf(this), null);
    }
}

