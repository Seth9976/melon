package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback;

final class zzt extends Callback {
    final CastSession zza;

    public zzt(CastSession castSession0) {
        this.zza = castSession0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void onStatusUpdated() {
        CastSession castSession0 = this.zza;
        MediaStatus mediaStatus0 = castSession0.zzj == null ? null : castSession0.zzj.getMediaStatus();
        if(castSession0.zzm != null) {
            castSession0.zzm.zzd(mediaStatus0);
        }
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void zza(String s, long v, int v1, long v2, long v3) {
        CastSession castSession0 = this.zza;
        if(castSession0.zzm != null) {
            castSession0.zzm.zzc(s, v, v1, v2, v3);
        }
    }
}

