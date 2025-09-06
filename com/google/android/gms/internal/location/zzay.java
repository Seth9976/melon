package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzay extends zzba {
    final Location zza;

    public zzay(zzbb zzbb0, GoogleApiClient googleApiClient0, Location location0) {
        this.zza = location0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(AnyClient api$AnyClient0) {
        TaskCompletionSource taskCompletionSource0 = zzbb.zza(this);
        ((zzdz)api$AnyClient0).zzA(this.zza, taskCompletionSource0);
    }
}

