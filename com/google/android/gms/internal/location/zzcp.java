package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.List;

final class zzcp extends zzcq {
    final List zza;

    public zzcp(zzcr zzcr0, GoogleApiClient googleApiClient0, List list0) {
        this.zza = list0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(AnyClient api$AnyClient0) {
        ((zzdz)api$AnyClient0).zzF(zzem.zza(this.zza), zzcr.zza(this));
    }
}

