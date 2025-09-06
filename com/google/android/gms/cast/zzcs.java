package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzcs extends zzdn {
    final int[] zza;
    final JSONObject zzb;
    final RemoteMediaPlayer zzc;

    public zzcs(RemoteMediaPlayer remoteMediaPlayer0, GoogleApiClient googleApiClient0, int[] arr_v, JSONObject jSONObject0) {
        this.zza = arr_v;
        this.zzb = jSONObject0;
        this.zzc = remoteMediaPlayer0;
        super(remoteMediaPlayer0, googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzdn
    public final void zza(zzx zzx0) {
        zzat zzat0 = this.zzb();
        this.zzc.zzb.zzy(zzat0, this.zza, this.zzb);
    }
}

