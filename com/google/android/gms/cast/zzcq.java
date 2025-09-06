package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzcq extends zzdn {
    final MediaQueueItem zza;
    final int zzb;
    final long zzc;
    final JSONObject zzd;
    final RemoteMediaPlayer zze;

    public zzcq(RemoteMediaPlayer remoteMediaPlayer0, GoogleApiClient googleApiClient0, MediaQueueItem mediaQueueItem0, int v, long v1, JSONObject jSONObject0) {
        this.zza = mediaQueueItem0;
        this.zzb = v;
        this.zzc = v1;
        this.zzd = jSONObject0;
        this.zze = remoteMediaPlayer0;
        super(remoteMediaPlayer0, googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzdn
    public final void zza(zzx zzx0) {
        zzat zzat0 = this.zzb();
        this.zze.zzb.zzw(zzat0, new MediaQueueItem[]{this.zza}, this.zzb, 0, 0, this.zzc, this.zzd);
    }
}

