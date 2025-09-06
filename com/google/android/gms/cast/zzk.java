package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzae;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzk extends zzae {
    public zzk(zzm zzm0, GoogleApiClient googleApiClient0) {
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.internal.zzae
    public final void doExecute(AnyClient api$AnyClient0) {
        this.zza(((zzx)api$AnyClient0));
    }

    @Override  // com.google.android.gms.cast.internal.zzae
    public final void zza(zzx zzx0) {
        try {
            zzx0.zzV("", this);
        }
        catch(IllegalStateException unused_ex) {
            this.zzc(2001);
        }
    }
}

