package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.internal.zzat;
import org.json.JSONObject;

final class zzad extends zzbg {
    final MediaQueueItem zza;
    final int zzb;
    final long zzc;
    final JSONObject zzd;
    final RemoteMediaClient zze;

    public zzad(RemoteMediaClient remoteMediaClient0, MediaQueueItem mediaQueueItem0, int v, long v1, JSONObject jSONObject0) {
        this.zza = mediaQueueItem0;
        this.zzb = v;
        this.zzc = v1;
        this.zzd = jSONObject0;
        this.zze = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zze.zzd.zzw(zzat0, new MediaQueueItem[]{this.zza}, this.zzb, 0, 0, this.zzc, this.zzd);
    }
}

