package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzda extends zzdn {
    final int zza;
    final int zzb;
    final JSONObject zzc;
    final RemoteMediaPlayer zzd;

    public zzda(RemoteMediaPlayer remoteMediaPlayer0, GoogleApiClient googleApiClient0, int v, int v1, JSONObject jSONObject0) {
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
        int v1 = RemoteMediaPlayer.zza(remoteMediaPlayer0, v);
        int v2 = 0;
        if(v1 == -1) {
            this.setResult(new zzdm(this, new Status(0)));
            return;
        }
        int v3 = this.zzb;
        if(v3 < 0) {
            this.setResult(new zzdm(this, new Status(2001, "Invalid request: Invalid newIndex " + v3 + ".")));
            return;
        }
        if(v1 == v3) {
            this.setResult(new zzdm(this, new Status(0)));
            return;
        }
        MediaStatus mediaStatus0 = remoteMediaPlayer0.getMediaStatus();
        if(mediaStatus0 == null) {
            this.setResult(new zzdm(this, new Status(2001, "Invalid request: Invalid MediaStatus")));
            return;
        }
        if(v3 > v1) {
            ++v3;
        }
        MediaQueueItem mediaQueueItem0 = mediaStatus0.getQueueItem(v3);
        if(mediaQueueItem0 != null) {
            v2 = mediaQueueItem0.getItemId();
        }
        remoteMediaPlayer0.zzb.zzz(this.zzb(), new int[]{v}, v2, this.zzc);
    }
}

