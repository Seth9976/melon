package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzct extends zzdn {
    final int[] zza;
    final int zzb;
    final JSONObject zzc;
    final RemoteMediaPlayer zzd;

    public zzct(RemoteMediaPlayer remoteMediaPlayer0, GoogleApiClient googleApiClient0, int[] arr_v, int v, JSONObject jSONObject0) {
        this.zza = arr_v;
        this.zzb = v;
        this.zzc = jSONObject0;
        this.zzd = remoteMediaPlayer0;
        super(remoteMediaPlayer0, googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzdn
    public final void zza(zzx zzx0) {
        zzat zzat0 = this.zzb();
        this.zzd.zzb.zzz(zzat0, this.zza, this.zzb, this.zzc);
    }
}

