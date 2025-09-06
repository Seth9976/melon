package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzdg extends zzdn {
    final double zza;
    final JSONObject zzb;
    final RemoteMediaPlayer zzc;

    public zzdg(RemoteMediaPlayer remoteMediaPlayer0, GoogleApiClient googleApiClient0, double f, JSONObject jSONObject0) {
        this.zza = f;
        this.zzb = jSONObject0;
        this.zzc = remoteMediaPlayer0;
        super(remoteMediaPlayer0, googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzdn
    public final void zza(zzx zzx0) {
        zzat zzat0 = this.zzb();
        this.zzc.zzb.zzG(zzat0, this.zza, this.zzb);
    }
}

