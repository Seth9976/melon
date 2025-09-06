package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.common.api.Status;

public final class zzr implements ApplicationConnectionResult {
    private final Status zza;
    private final ApplicationMetadata zzb;
    private final String zzc;
    private final String zzd;
    private final boolean zze;

    public zzr(Status status0, ApplicationMetadata applicationMetadata0, String s, String s1, boolean z) {
        this.zza = status0;
        this.zzb = applicationMetadata0;
        this.zzc = s;
        this.zzd = s1;
        this.zze = z;
    }

    @Override  // com.google.android.gms.cast.Cast$ApplicationConnectionResult
    public final ApplicationMetadata getApplicationMetadata() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.cast.Cast$ApplicationConnectionResult
    public final String getApplicationStatus() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.cast.Cast$ApplicationConnectionResult
    public final String getSessionId() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    @Override  // com.google.android.gms.cast.Cast$ApplicationConnectionResult
    public final boolean getWasLaunched() {
        return this.zze;
    }
}

