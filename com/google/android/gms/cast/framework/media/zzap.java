package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzat;

final class zzap extends zzbg {
    final int[] zza;
    final RemoteMediaClient zzb;

    public zzap(RemoteMediaClient remoteMediaClient0, boolean z, int[] arr_v) {
        this.zza = arr_v;
        this.zzb = remoteMediaClient0;
        super(remoteMediaClient0, true);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zzb.zzd.zzv(zzat0, this.zza);
    }
}

