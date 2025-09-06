package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.internal.zzat;
import org.json.JSONObject;

final class zzac extends zzbg {
    final MediaQueueItem[] zza;
    final int zzb;
    final JSONObject zzc;
    final RemoteMediaClient zzd;

    public zzac(RemoteMediaClient remoteMediaClient0, MediaQueueItem[] arr_mediaQueueItem, int v, JSONObject jSONObject0) {
        this.zza = arr_mediaQueueItem;
        this.zzb = v;
        this.zzc = jSONObject0;
        this.zzd = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zzd.zzd.zzw(zzat0, this.zza, this.zzb, 0, -1, -1L, this.zzc);
    }
}

