package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzcy extends zzdn {
    final int zza;
    final JSONObject zzb;
    final RemoteMediaPlayer zzc;

    public zzcy(RemoteMediaPlayer remoteMediaPlayer0, GoogleApiClient googleApiClient0, int v, JSONObject jSONObject0) {
        this.zza = v;
        this.zzb = jSONObject0;
        this.zzc = remoteMediaPlayer0;
        super(remoteMediaPlayer0, googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzdn
    public final void zza(zzx zzx0) {
        RemoteMediaPlayer remoteMediaPlayer0 = this.zzc;
        int v = this.zza;
        if(RemoteMediaPlayer.zza(remoteMediaPlayer0, v) == -1) {
            this.setResult(new zzdm(this, new Status(0)));
            return;
        }
        remoteMediaPlayer0.zzb.zzy(this.zzb(), new int[]{v}, this.zzb);
    }
}

