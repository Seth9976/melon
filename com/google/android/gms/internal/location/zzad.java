package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzad extends zzae {
    final PendingIntent zza;

    public zzad(zzaf zzaf0, GoogleApiClient googleApiClient0, PendingIntent pendingIntent0) {
        this.zza = pendingIntent0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(AnyClient api$AnyClient0) {
        ((zzg)api$AnyClient0).zzp(this.zza);
        this.setResult(Status.RESULT_SUCCESS);
    }
}

