package com.google.android.gms.cast;

import com.google.android.gms.common.api.Status;

final class zzn implements ApplicationConnectionResult {
    final Status zza;

    public zzn(zzo zzo0, Status status0) {
        this.zza = status0;
        super();
    }

    @Override  // com.google.android.gms.cast.Cast$ApplicationConnectionResult
    public final ApplicationMetadata getApplicationMetadata() {
        return null;
    }

    @Override  // com.google.android.gms.cast.Cast$ApplicationConnectionResult
    public final String getApplicationStatus() {
        return null;
    }

    @Override  // com.google.android.gms.cast.Cast$ApplicationConnectionResult
    public final String getSessionId() {
        return null;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    @Override  // com.google.android.gms.cast.Cast$ApplicationConnectionResult
    public final boolean getWasLaunched() {
        return false;
    }
}

