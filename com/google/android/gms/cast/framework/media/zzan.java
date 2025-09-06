package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONObject;

final class zzan extends zzbg {
    final int zza;
    final int zzb;
    final JSONObject zzc;
    final RemoteMediaClient zzd;

    public zzan(RemoteMediaClient remoteMediaClient0, int v, int v1, JSONObject jSONObject0) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = jSONObject0;
        this.zzd = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        RemoteMediaClient remoteMediaClient0 = this.zzd;
        MediaQueue mediaQueue0 = remoteMediaClient0.getMediaQueue();
        int v = this.zza;
        int v1 = mediaQueue0.indexOfItemWithId(v);
        int v2 = 0;
        if(v1 == -1) {
            MediaStatus mediaStatus0 = (MediaStatus)Preconditions.checkNotNull(remoteMediaClient0.getMediaStatus());
            for(int v3 = 0; true; ++v3) {
                v1 = -1;
                if(v3 >= mediaStatus0.getQueueItemCount()) {
                    break;
                }
                if(((MediaQueueItem)Preconditions.checkNotNull(mediaStatus0.getQueueItem(v3))).getItemId() == v) {
                    v1 = v3;
                    break;
                }
            }
        }
        int v4 = this.zzb;
        if(v4 < 0) {
            this.setResult(new zzbf(this, new Status(2001, "Invalid request: Invalid newIndex " + v4 + ".")));
            return;
        }
        if(v1 == v4) {
            this.setResult(new zzbf(this, new Status(0)));
            return;
        }
        if(v4 > v1) {
            ++v4;
        }
        Preconditions.checkMainThread("Must be called from the main thread.");
        int v5 = remoteMediaClient0.getMediaQueue().itemIdAtIndex(v4);
        if(v5 == 0) {
            MediaStatus mediaStatus1 = remoteMediaClient0.getMediaStatus();
            if(mediaStatus1 != null) {
                MediaQueueItem mediaQueueItem0 = mediaStatus1.getQueueItem(v4);
                if(mediaQueueItem0 != null) {
                    v2 = mediaQueueItem0.getItemId();
                }
            }
        }
        else {
            v2 = v5;
        }
        remoteMediaClient0.zzd.zzz(this.zzb(), new int[]{v}, v2, this.zzc);
    }
}

