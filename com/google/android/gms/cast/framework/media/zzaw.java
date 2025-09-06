package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.internal.zzat;

final class zzaw extends zzbg {
    final MediaSeekOptions zza;
    final RemoteMediaClient zzb;

    public zzaw(RemoteMediaClient remoteMediaClient0, MediaSeekOptions mediaSeekOptions0) {
        this.zza = mediaSeekOptions0;
        this.zzb = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zzb.zzd.zzC(zzat0, this.zza);
    }
}

