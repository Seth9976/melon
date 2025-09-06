package com.google.android.gms.internal.location;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

abstract class zzba extends ApiMethodImpl {
    public zzba(GoogleApiClient googleApiClient0) {
        super(zzbi.zzb, googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status0) {
        return status0;
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    @KeepForSdk
    public final void setResult(Object object0) {
        this.setResult(((Result)object0));
    }
}

