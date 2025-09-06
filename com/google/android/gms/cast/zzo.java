package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzc;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

class zzo extends zzc {
    public zzo(GoogleApiClient googleApiClient0) {
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status0) {
        return new zzn(this, status0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public void doExecute(AnyClient api$AnyClient0) {
        this.zza(((zzx)api$AnyClient0));
    }

    public void zza(zzx zzx0) {
        throw null;
    }
}

