package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzcr extends zzdn {
    final MediaQueueItem[] zza;
    final JSONObject zzb;
    final RemoteMediaPlayer zzc;

    public zzcr(RemoteMediaPlayer remoteMediaPlayer0, GoogleApiClient googleApiClient0, MediaQueueItem[] arr_mediaQueueItem, JSONObject jSONObject0) {
        this.zza = arr_mediaQueueItem;
        this.zzb = jSONObject0;
        this.zzc = remoteMediaPlayer0;
        super(remoteMediaPlayer0, googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzdn
    public final void zza(zzx zzx0) {
        zzat zzat0 = this.zzb();
        this.zzc.zzb.zzA(zzat0, 0, -1L, this.zza, 0, null, null, this.zzb);
    }
}

