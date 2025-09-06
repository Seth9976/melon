package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzcz extends zzdn {
    final int zza;
    final long zzb;
    final JSONObject zzc;
    final RemoteMediaPlayer zzd;

    public zzcz(RemoteMediaPlayer remoteMediaPlayer0, GoogleApiClient googleApiClient0, int v, long v1, JSONObject jSONObject0) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = jSONObject0;
        this.zzd = remoteMediaPlayer0;
        super(remoteMediaPlayer0, googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzdn
    public final void zza(zzx zzx0) {
        RemoteMediaPlayer remoteMediaPlayer0 = this.zzd;
        int v = this.zza;
        if(RemoteMediaPlayer.zza(remoteMediaPlayer0, v) == -1) {
            this.setResult(new zzdm(this, new Status(0)));
            return;
        }
        remoteMediaPlayer0.zzb.zzA(this.zzb(), v, this.zzb, null, 0, null, null, this.zzc);
    }
}

