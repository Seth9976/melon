package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzi extends zzo {
    final String zza;
    final String zzb;

    public zzi(zzm zzm0, GoogleApiClient googleApiClient0, String s, String s1, zzbs zzbs0) {
        this.zza = s;
        this.zzb = s1;
        super(googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzo
    public final void doExecute(AnyClient api$AnyClient0) {
        this.zza(((zzx)api$AnyClient0));
    }

    @Override  // com.google.android.gms.cast.zzo
    public final void zza(zzx zzx0) {
        try {
            zzx0.zzL(this.zza, this.zzb, null, this);
        }
        catch(IllegalStateException unused_ex) {
            this.zzc(2001);
        }
    }
}

