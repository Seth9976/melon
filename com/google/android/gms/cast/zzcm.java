package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzcm extends zzdn {
    final long[] zza;
    final RemoteMediaPlayer zzb;

    public zzcm(RemoteMediaPlayer remoteMediaPlayer0, GoogleApiClient googleApiClient0, long[] arr_v) {
        this.zza = arr_v;
        this.zzb = remoteMediaPlayer0;
        super(remoteMediaPlayer0, googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzdn
    public final void zza(zzx zzx0) {
        zzat zzat0 = this.zzb();
        this.zzb.zzb.zzD(zzat0, this.zza);
    }
}

