package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzat;

final class zzao extends zzbg {
    final RemoteMediaClient zza;

    public zzao(RemoteMediaClient remoteMediaClient0, boolean z) {
        this.zza = remoteMediaClient0;
        super(remoteMediaClient0, true);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zza.zzd.zzu(zzat0);
    }
}

