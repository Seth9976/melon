package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzco extends zzcq {
    final PendingIntent zza;

    public zzco(zzcr zzcr0, GoogleApiClient googleApiClient0, PendingIntent pendingIntent0) {
        this.zza = pendingIntent0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(AnyClient api$AnyClient0) {
        ((zzdz)api$AnyClient0).zzF(zzem.zzb(this.zza), zzcr.zza(this));
    }
}

