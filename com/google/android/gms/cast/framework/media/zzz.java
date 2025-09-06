package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzat;

final class zzz extends zzbg {
    final long[] zza;
    final RemoteMediaClient zzb;

    public zzz(RemoteMediaClient remoteMediaClient0, long[] arr_v) {
        this.zza = arr_v;
        this.zzb = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zzb.zzd.zzD(zzat0, this.zza);
    }
}

