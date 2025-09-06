package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzdd extends zzdn {
    final JSONObject zza;
    final RemoteMediaPlayer zzb;

    public zzdd(RemoteMediaPlayer remoteMediaPlayer0, GoogleApiClient googleApiClient0, JSONObject jSONObject0) {
        this.zza = jSONObject0;
        this.zzb = remoteMediaPlayer0;
        super(remoteMediaPlayer0, googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzdn
    public final void zza(zzx zzx0) {
        zzat zzat0 = this.zzb();
        this.zzb.zzb.zzJ(zzat0, this.zza);
    }
}

