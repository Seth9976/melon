package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.internal.zzao;
import java.util.Iterator;
import java.util.List;

final class zzbi implements zzao {
    final RemoteMediaClient zza;

    public zzbi(RemoteMediaClient remoteMediaClient0, zzbl zzbl0) {
        this.zza = remoteMediaClient0;
        super();
    }

    @Override  // com.google.android.gms.cast.internal.zzao
    public final void zza() {
        RemoteMediaClient remoteMediaClient0 = this.zza;
        for(Object object0: remoteMediaClient0.zzi) {
            ((Listener)object0).onAdBreakStatusUpdated();
        }
        for(Object object1: remoteMediaClient0.zzj) {
            ((Callback)object1).onAdBreakStatusUpdated();
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzao
    public final void zzb(MediaError mediaError0) {
        Iterator iterator0 = this.zza.zzj.iterator();
        while(iterator0.hasNext()) {
            iterator0.next();
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzao
    public final void zzc() {
        this.zzn();
        RemoteMediaClient remoteMediaClient0 = this.zza;
        for(Object object0: remoteMediaClient0.zzi) {
            ((Listener)object0).onMetadataUpdated();
        }
        for(Object object1: remoteMediaClient0.zzj) {
            ((Callback)object1).onMetadataUpdated();
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzao
    public final void zzd() {
        RemoteMediaClient remoteMediaClient0 = this.zza;
        for(Object object0: remoteMediaClient0.zzi) {
            ((Listener)object0).onPreloadStatusUpdated();
        }
        for(Object object1: remoteMediaClient0.zzj) {
            ((Callback)object1).onPreloadStatusUpdated();
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzao
    public final void zze(int[] arr_v) {
        for(Object object0: this.zza.zzj) {
            ((Callback)object0).zzb(arr_v);
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzao
    public final void zzf(int[] arr_v, int v) {
        for(Object object0: this.zza.zzj) {
            ((Callback)object0).zzc(arr_v, v);
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzao
    public final void zzg(MediaQueueItem[] arr_mediaQueueItem) {
        for(Object object0: this.zza.zzj) {
            ((Callback)object0).zzd(arr_mediaQueueItem);
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzao
    public final void zzh(int[] arr_v) {
        for(Object object0: this.zza.zzj) {
            ((Callback)object0).zze(arr_v);
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzao
    public final void zzi(List list0, List list1, int v) {
        for(Object object0: this.zza.zzj) {
            ((Callback)object0).zzf(list0, list1, v);
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzao
    public final void zzj(int[] arr_v) {
        for(Object object0: this.zza.zzj) {
            ((Callback)object0).zzg(arr_v);
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzao
    public final void zzk() {
        RemoteMediaClient remoteMediaClient0 = this.zza;
        for(Object object0: remoteMediaClient0.zzi) {
            ((Listener)object0).onQueueStatusUpdated();
        }
        for(Object object1: remoteMediaClient0.zzj) {
            ((Callback)object1).onQueueStatusUpdated();
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzao
    public final void zzl() {
        for(Object object0: this.zza.zzj) {
            ((Callback)object0).zzh();
        }
    }

    @Override  // com.google.android.gms.cast.internal.zzao
    public final void zzm() {
        this.zzn();
        RemoteMediaClient remoteMediaClient0 = this.zza;
        RemoteMediaClient.zzo(remoteMediaClient0);
        for(Object object0: remoteMediaClient0.zzi) {
            ((Listener)object0).onStatusUpdated();
        }
        for(Object object1: remoteMediaClient0.zzj) {
            ((Callback)object1).onStatusUpdated();
        }
    }

    private final void zzn() {
        RemoteMediaClient remoteMediaClient0 = this.zza;
        if(remoteMediaClient0.zzm != null) {
            MediaStatus mediaStatus0 = remoteMediaClient0.getMediaStatus();
            if(mediaStatus0 != null) {
                mediaStatus0.getWriter().setIsPlayingAd(remoteMediaClient0.zzm.parseIsPlayingAdFromMediaStatus(mediaStatus0));
                List list0 = remoteMediaClient0.zzm.parseAdBreaksFromMediaStatus(mediaStatus0);
                MediaInfo mediaInfo0 = remoteMediaClient0.getMediaInfo();
                if(mediaInfo0 != null) {
                    mediaInfo0.getWriter().setAdBreaks(list0);
                }
            }
        }
    }
}

