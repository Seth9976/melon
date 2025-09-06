package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzg extends zzo {
    final String zza;

    public zzg(zzm zzm0, GoogleApiClient googleApiClient0, String s) {
        this.zza = s;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzo
    public final void doExecute(AnyClient api$AnyClient0) {
        this.zza(((zzx)api$AnyClient0));
    }

    @Override  // com.google.android.gms.cast.zzo
    public final void zza(zzx zzx0) {
        try {
            LaunchOptions launchOptions0 = new LaunchOptions();
            launchOptions0.setRelaunchIfRunning(false);
            zzx0.zzM(this.zza, launchOptions0, this);
        }
        catch(IllegalStateException unused_ex) {
            this.zzc(2001);
        }
    }
}

