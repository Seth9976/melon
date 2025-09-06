package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.internal.zzat;
import org.json.JSONObject;

final class zzab extends zzbg {
    final MediaQueueItem[] zza;
    final int zzb;
    final int zzc;
    final long zzd;
    final JSONObject zze;
    final RemoteMediaClient zzf;

    public zzab(RemoteMediaClient remoteMediaClient0, MediaQueueItem[] arr_mediaQueueItem, int v, int v1, long v2, JSONObject jSONObject0) {
        this.zza = arr_mediaQueueItem;
        this.zzb = v;
        this.zzc = v1;
        this.zzd = v2;
        this.zze = jSONObject0;
        this.zzf = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zzf.zzd.zzx(zzat0, this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}

