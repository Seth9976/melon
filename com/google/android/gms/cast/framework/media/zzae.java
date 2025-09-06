package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.internal.zzat;
import org.json.JSONObject;

final class zzae extends zzbg {
    final MediaQueueItem[] zza;
    final JSONObject zzb;
    final RemoteMediaClient zzc;

    public zzae(RemoteMediaClient remoteMediaClient0, MediaQueueItem[] arr_mediaQueueItem, JSONObject jSONObject0) {
        this.zza = arr_mediaQueueItem;
        this.zzb = jSONObject0;
        this.zzc = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zzc.zzd.zzA(zzat0, 0, -1L, this.zza, 0, null, null, this.zzb);
    }
}

