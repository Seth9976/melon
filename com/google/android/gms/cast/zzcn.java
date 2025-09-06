package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzcn extends zzdn {
    final TextTrackStyle zza;
    final RemoteMediaPlayer zzb;

    public zzcn(RemoteMediaPlayer remoteMediaPlayer0, GoogleApiClient googleApiClient0, TextTrackStyle textTrackStyle0) {
        this.zza = textTrackStyle0;
        this.zzb = remoteMediaPlayer0;
        super(remoteMediaPlayer0, googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzdn
    public final void zza(zzx zzx0) {
        zzat zzat0 = this.zzb();
        this.zzb.zzb.zzH(zzat0, this.zza);
    }
}

