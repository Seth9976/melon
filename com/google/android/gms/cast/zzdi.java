package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzdi extends zzdn {
    final RemoteMediaPlayer zza;

    public zzdi(RemoteMediaPlayer remoteMediaPlayer0, GoogleApiClient googleApiClient0) {
        this.zza = remoteMediaPlayer0;
        super(remoteMediaPlayer0, googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzdn
    public final void zza(zzx zzx0) {
        zzat zzat0 = this.zzb();
        this.zza.zzb.zzB(zzat0);
    }
}

