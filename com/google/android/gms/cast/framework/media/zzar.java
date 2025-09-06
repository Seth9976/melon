package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.internal.zzat;

final class zzar extends zzbg {
    final MediaLoadRequestData zza;
    final RemoteMediaClient zzb;

    public zzar(RemoteMediaClient remoteMediaClient0, MediaLoadRequestData mediaLoadRequestData0) {
        this.zza = mediaLoadRequestData0;
        this.zzb = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zzb.zzd.zzp(zzat0, this.zza);
    }
}

