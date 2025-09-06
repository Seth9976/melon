package com.google.android.gms.internal.cast;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

class zzed extends ApiMethodImpl {
    final zzef zzc;

    public zzed(zzef zzef0, GoogleApiClient googleApiClient0) {
        this.zzc = zzef0;
        super(zzef.zzd(zzef0), googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status0) {
        return new zzee(status0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public void doExecute(AnyClient api$AnyClient0) {
        this.zza(((zzei)api$AnyClient0));
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    @KeepForSdk
    public final void setResult(Object object0) {
        this.setResult(((Result)object0));
    }

    public void zza(zzei zzei0) {
        throw null;
    }
}

