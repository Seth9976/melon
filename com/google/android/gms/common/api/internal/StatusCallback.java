package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;

@KeepForSdk
public class StatusCallback extends Stub {
    @KeepForSdk
    private final ResultHolder resultHolder;

    @KeepForSdk
    public StatusCallback(ResultHolder baseImplementation$ResultHolder0) {
        this.resultHolder = baseImplementation$ResultHolder0;
    }

    @Override  // com.google.android.gms.common.api.internal.IStatusCallback
    @KeepForSdk
    public void onResult(Status status0) {
        this.resultHolder.setResult(status0);
    }
}

