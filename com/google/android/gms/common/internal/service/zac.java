package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zac extends zaf {
    public zac(zae zae0, GoogleApiClient googleApiClient0) {
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(AnyClient api$AnyClient0) {
        ((zal)((zah)api$AnyClient0).getService()).zae(new zad(this));
    }
}

