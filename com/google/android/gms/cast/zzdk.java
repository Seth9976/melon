package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzas;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzdk implements zzas {
    final RemoteMediaPlayer zza;
    private GoogleApiClient zzb;
    private long zzc;

    public zzdk(RemoteMediaPlayer remoteMediaPlayer0) {
        this.zza = remoteMediaPlayer0;
        super();
        this.zzc = 0L;
    }

    @Override  // com.google.android.gms.cast.internal.zzas
    public final long zza() {
        long v = this.zzc + 1L;
        this.zzc = v;
        return v;
    }

    @Override  // com.google.android.gms.cast.internal.zzas
    public final void zzb(String s, String s1, long v, String s2) {
        GoogleApiClient googleApiClient0 = this.zzb;
        if(googleApiClient0 == null) {
            throw new IllegalStateException("No GoogleApiClient available");
        }
        Cast.CastApi.sendMessage(googleApiClient0, s, s1).setResultCallback(new zzdj(this, v));
    }

    public final void zzc(GoogleApiClient googleApiClient0) {
        this.zzb = googleApiClient0;
    }
}

