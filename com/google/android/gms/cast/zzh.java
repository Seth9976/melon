package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzh extends zzo {
    final String zza;
    final LaunchOptions zzb;

    public zzh(zzm zzm0, GoogleApiClient googleApiClient0, String s, LaunchOptions launchOptions0) {
        this.zza = s;
        this.zzb = launchOptions0;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzo
    public final void doExecute(AnyClient api$AnyClient0) {
        this.zza(((zzx)api$AnyClient0));
    }

    @Override  // com.google.android.gms.cast.zzo
    public final void zza(zzx zzx0) {
        try {
            zzx0.zzM(this.zza, this.zzb, this);
        }
        catch(IllegalStateException unused_ex) {
            this.zzc(2001);
        }
    }
}

