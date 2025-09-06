package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzcp extends zzdn {
    final MediaQueueItem[] zza;
    final int zzb;
    final JSONObject zzc;
    final RemoteMediaPlayer zzd;

    public zzcp(RemoteMediaPlayer remoteMediaPlayer0, GoogleApiClient googleApiClient0, MediaQueueItem[] arr_mediaQueueItem, int v, JSONObject jSONObject0) {
        this.zza = arr_mediaQueueItem;
        this.zzb = v;
        this.zzc = jSONObject0;
        this.zzd = remoteMediaPlayer0;
        super(remoteMediaPlayer0, googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzdn
    public final void zza(zzx zzx0) {
        zzat zzat0 = this.zzb();
        this.zzd.zzb.zzw(zzat0, this.zza, this.zzb, 0, -1, -1L, this.zzc);
    }
}

