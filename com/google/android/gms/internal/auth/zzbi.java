package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.auth.api.AuthProxy;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

abstract class zzbi extends ApiMethodImpl {
    public zzbi(GoogleApiClient googleApiClient0) {
        super(AuthProxy.API, googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status0) {
        return new zzbu(status0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(AnyClient api$AnyClient0) {
        this.zza(((zzbe)api$AnyClient0).getContext(), ((zzbh)((zzbe)api$AnyClient0).getService()));
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    @KeepForSdk
    public final void setResult(Object object0) {
        this.setResult(((Result)object0));
    }

    public abstract void zza(Context arg1, zzbh arg2);
}

