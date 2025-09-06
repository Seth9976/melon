package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

public abstract class zzc extends ApiMethodImpl {
    public zzc(GoogleApiClient googleApiClient0) {
        super(Cast.API, googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    @KeepForSdk
    public final void setResult(Object object0) {
        this.setResult(((Result)object0));
    }

    public final void zzc(int v) {
        this.setResult(this.createFailedResult(new Status(2001)));
    }
}

