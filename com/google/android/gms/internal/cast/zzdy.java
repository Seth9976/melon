package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzdy extends zzed {
    final String zza;
    final zzef zzb;

    public zzdy(zzef zzef0, GoogleApiClient googleApiClient0, String s) {
        this.zza = s;
        this.zzb = zzef0;
        super(zzef0, googleApiClient0);
    }

    @Override  // com.google.android.gms.internal.cast.zzed
    public final void doExecute(AnyClient api$AnyClient0) {
        this.zza(((zzei)api$AnyClient0));
    }

    @Override  // com.google.android.gms.internal.cast.zzed
    public final void zza(zzei zzei0) {
        zzei0.zzr(new zzeb(this, zzei0), zzef.zzc(this.zzb), this.zza);
    }
}

