package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzat;

final class zzx extends zzbg {
    final RemoteMediaClient zza;

    public zzx(RemoteMediaClient remoteMediaClient0) {
        this.zza = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zza.zzd.zzI(zzat0);
    }
}

