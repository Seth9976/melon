package com.google.android.gms.cast.framework.media;

import java.util.List;

final class zzas extends zzbg {
    final String zza;
    final RemoteMediaClient zzb;

    public zzas(RemoteMediaClient remoteMediaClient0, boolean z, String s, List list0) {
        this.zza = s;
        this.zzb = remoteMediaClient0;
        super(remoteMediaClient0, true);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        this.zzb.zzd.zzs(this.zza, null);
    }
}

